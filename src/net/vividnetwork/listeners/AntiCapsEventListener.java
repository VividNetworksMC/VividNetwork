package net.vividnetwork.listeners;

import net.vividnetwork.VividNetwork;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiCapsEventListener implements Listener {
	public VividNetwork plugin;

	public AntiCapsEventListener(VividNetwork plugin){
		this.plugin = plugin;
	}
	
	public void onPlayerChat(AsyncPlayerChatEvent event)
	{
		int spacecount = 0;
		boolean msgbool = false;
		if(!event.getPlayer().hasPermission("anticaps.cancaps"))
		{
			String[] msg = event.getMessage().split(" ");
			for(int i = 0;i < msg.length;i++)
			{
				if(msg[i].length() == 1 && isMostUpper2(msg[i]))
				{
					spacecount++;
				}
				if(isMostUpper(msg[i]) || spacecount > 2)
				{
					msg[i] = msg[i].toLowerCase();
					if(!msgbool)
					{
						Bukkit.getServer().getWorld("world").strikeLightning(event.getPlayer().getLocation());
						event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "No caps no lightning.");
						msgbool = true;
					}
				}
			}
			String newmsg = "";
			for(int i = 0;i < msg.length;i++)
			{
				newmsg = newmsg + msg[i];
				newmsg = newmsg + " ";
			}
			event.setMessage(newmsg);
			msgbool = false;
		}

	}
	private static boolean isMostUpper(String s) {
		int capcount = 0;
	    for(char c : s.toCharArray()) 
	    {
	       if(Character.isLetter(c) && Character.isUpperCase(c)) 
	       {
	           capcount++;
	       }
	    }
	    if(capcount > s.length() / 2 && s.length() != 1)
	    {
	    	return true;
	    }
	    else
	    {
		    return false;
	    }
	}
	private static boolean isMostUpper2(String s) {
	    for(char c : s.toCharArray()) 
	    {
	       if(Character.isLetter(c) && Character.isUpperCase(c)) 
	       {
	    	   return true;
	       }
	    }
	    return false;
	}
	
}

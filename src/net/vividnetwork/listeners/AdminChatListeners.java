package net.vividnetwork.listeners;

import net.vividnetwork.AdminChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AdminChatListeners implements Listener
{
	
	public static boolean canUseAdminChat(CommandSender sender)
	{
		if(sender.hasPermission("AdminChat.use") || sender.isOp())
		{
			return true;
		}
		return sender.isOp();
	}
	
	public static void sendToChat(String msg, CommandSender sender)
	{
		String pname = sender.getName();
		if((sender instanceof Player))
		{
			pname = ((Player)sender).getDisplayName();
		}
		for(Player p : Bukkit.getServer().getOnlinePlayers())
		{
			if(canUseAdminChat(p))
			{
				p.sendMessage(ChatColor.RED + "[AdminChat] " + ChatColor.AQUA + pname + ChatColor.DARK_GRAY + " : " + ChatColor.WHITE + msg);
			}
		}
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event)
	{
		if(AdminChat.chatters.contains(event.getPlayer().getName()))
		{
			sendToChat(event.getMessage(), event.getPlayer());
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		String pname = event.getPlayer().getDisplayName();
		if(AdminChat.chatters.contains(pname))
		{
			AdminChat.chatters.remove(pname);
		}
		
	}
	
}

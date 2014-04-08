package net.vividnetwork.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.vividnetwork.VividNetwork;

public class AntiSwearListener implements Listener {
	
	public VividNetwork plugin;

	public AntiSwearListener(VividNetwork plugin){
		this.plugin = plugin;
	}
	
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
            for(String word : e.getMessage().split(" ")){
                    if(plugin.getConfig().getStringList("bannedwords").contains(word)){
                            e.setCancelled(true);
                            e.getPlayer().sendMessage(ChatColor.DARK_RED + "Please Don't Use That Sort Of Language!");
                    }
            }
    }

}

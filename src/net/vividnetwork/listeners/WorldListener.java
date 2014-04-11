package net.vividnetwork.listeners;

import net.vividnetwork.VividNetwork;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WorldListener implements Listener {
	
	public VividNetwork plugin;
	
	public WorldListener(VividNetwork plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if(event.getTo().getY() < 0){
			player.teleport(new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("X"), plugin.getConfig().getInt("Y"), plugin.getConfig().getInt("Z")));
		}
	}
}

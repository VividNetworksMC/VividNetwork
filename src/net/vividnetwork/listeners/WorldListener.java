package net.vividnetwork.listeners;

import net.vividnetwork.VividNetwork;

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
			player.teleport(event.getFrom().getWorld().getSpawnLocation());
		}
	}
}

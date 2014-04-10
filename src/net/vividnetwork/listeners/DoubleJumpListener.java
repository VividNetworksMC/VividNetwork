package net.vividnetwork.listeners;

import net.vividnetwork.VividNetwork;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJumpListener implements Listener {

	public VividNetwork plugin;

	public DoubleJumpListener(VividNetwork plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
		Player player = event.getPlayer();
		if (player.getGameMode() == GameMode.CREATIVE)
			return;
		event.setCancelled(true);
		player.setAllowFlight(false);
		player.setFlying(false);
		player.setVelocity(player.getLocation().getDirection().multiply(plugin.getConfig().getInt("Multiplier")).setY(plugin.getConfig().getInt("SetY")));
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if ((player.getGameMode() != GameMode.CREATIVE)
				&& (player.getLocation().subtract(0, plugin.getConfig().getInt("Subtract"), 0).getBlock().getType() != Material.AIR)
				&& (!player.isFlying()))
			player.setAllowFlight(true);
	}

}

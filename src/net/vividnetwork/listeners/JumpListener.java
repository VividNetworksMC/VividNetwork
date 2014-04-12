package net.vividnetwork.listeners;

import net.vividnetwork.VividNetwork;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class JumpListener implements Listener {
	public VividNetwork plugin;

	public JumpListener(VividNetwork plugin){ 
		this.plugin = plugin;
	}
	
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_BLOCK) { return; }
        if (e.getAction() == Action.LEFT_CLICK_AIR) { return; }
        if (!(e.getItem().getType() == Material.WHEAT)) { return; }
        Player p = e.getPlayer();
 
        p.setVelocity(p.getLocation().getDirection().normalize().multiply(3));
        p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 10, 1);
        return;
    }
}


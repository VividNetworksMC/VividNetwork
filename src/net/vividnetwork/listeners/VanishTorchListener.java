package net.vividnetwork.listeners;

import net.vividnetwork.VividNetwork;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

 

public class VanishTorchListener implements Listener{
    
    
    public VividNetwork plugin;

    public VanishTorchListener(VividNetwork plugin){ 
    	this.plugin = plugin;
     }
		
     @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
    	if(!(event.getPlayer().hasPermission("vanishtorch.use")))
    		return;
    	if(event.getItem() == null || event.getItem().equals(Material.AIR))
            return;
    if (event.getPlayer().hasPermission("vanishtorch.use")) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem().getType().equals(Material.MAGMA_CREAM)){
                Player player = event.getPlayer();
                for (Player other : plugin.getServer().getOnlinePlayers()) {
                    player.hidePlayer(other);
                    player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10, 1);
                    player.setItemInHand(new ItemStack(Material.SLIME_BALL));
                    player.sendMessage(ChatColor.GRAY + "Players toggled: "+ChatColor.RED.toString()+ChatColor.BOLD+"Off"+ChatColor.GRAY+"!");
                    return;
                }
                return;
            }
            
            if(event.getItem() == null || event.getItem().equals(Material.AIR))
              return;
              if(event.getItem().getType() != Material.SLIME_BALL)
            	  return;
            if (event.getItem().getType().equals(Material.SLIME_BALL)){
                Player player = event.getPlayer();
                for (Player other : plugin.getServer().getOnlinePlayers()) {
                    player.showPlayer(other);
                    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 10, 1);
                    player.setItemInHand(new ItemStack(Material.MAGMA_CREAM));
                    player.sendMessage(ChatColor.GRAY + "Players toggled: "+ChatColor.GREEN.toString()+ChatColor.BOLD+"On"+ChatColor.GRAY+"!");
                    return;
                }
                return;
            }
        }
    }
 }
}

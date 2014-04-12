package net.vividnetwork.listeners;

import net.vividnetwork.Items;
import net.vividnetwork.JoinItems;
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
    	 Player player = event.getPlayer();
    	 ItemStack itemstack = player.getItemInHand();
    	 Action action = event.getAction();
    	 
    	 if(!(player.hasPermission("vanishtorch.use")))
    		 return;
    	 
    	 if(itemstack == null || itemstack.getType().equals(Material.AIR) ||! itemstack.hasItemMeta())
    	 return;
    	 
    	 if(player.hasPermission("vanishtorch.use")){
    		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
    		 if(itemstack.getType().equals(Material.MAGMA_CREAM) && itemstack.hasItemMeta()){
    			 for(Player others : plugin.getServer().getOnlinePlayers()){
    			 player.hidePlayer(others);
                 player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10, 1);
                 player.setItemInHand(new ItemStack(JoinItems.getCustName(Items.slimeball)));
    			 }
    			player.sendMessage(ChatColor.GRAY + "Players Toggled: " + ChatColor.RED.toString() + ChatColor.BOLD + "Disabled");
    		  }    	
    		}
    		if(itemstack == null || itemstack.getType().equals(Material.AIR) ||! itemstack.hasItemMeta())
    	    	 return;
    		
    		 if(itemstack.getType().equals(Material.SLIME_BALL) && itemstack.hasItemMeta()){
    			for(Player others : plugin.getServer().getOnlinePlayers()){
    			 player.showPlayer(others);
    			 player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 10, 1);
                 player.setItemInHand(new ItemStack(JoinItems.getCustName(Items.magmacream)));
    		}
    		 player.sendMessage(ChatColor.GRAY + "Players Toggled: " + ChatColor.GREEN.toString() + ChatColor.BOLD + "Enabled");
    	   }
    	 }
    }
}


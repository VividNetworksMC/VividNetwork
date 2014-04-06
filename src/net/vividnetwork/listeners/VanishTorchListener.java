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
		
    public enum Items{
    	magmacream,
    	slimeball,
    }
    
    public ItemStack getCustName(Items item){
		ItemStack is = null;
		ItemMeta im;
		switch(item){
		case slimeball:
			is = new ItemStack(Material.SLIME_BALL);
			im = is.getItemMeta();
			im.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Show Players");
		    is.setItemMeta(im);
			break;
		case magmacream:
			is = new ItemStack(Material.MAGMA_CREAM);
			im = is.getItemMeta();
			im.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD + "Hide Players");
			is.setItemMeta(im);
		default:
			break;
		
		}
		return is;
		
	}

     @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
    	 Player player = event.getPlayer();
    	 ItemStack is = player.getItemInHand();
    	 Action action = event.getAction();
    	 
    	 if(!(player.hasPermission("vanishtorch.use")))
    		 return;
    	 
    	 if(is == null || is.getType().equals(Material.AIR))
    	 return;;
    	 
    	 if(player.hasPermission("vanishtorch.use")){
    		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
    		 if(is.getType().equals(Material.MAGMA_CREAM) && is.hasItemMeta()){
    			 for(Player others : this.plugin.getServer().getOnlinePlayers()){
    			 player.hidePlayer(others);
                 player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10, 1);
                 player.setItemInHand(new ItemStack(getCustName(Items.slimeball)));
                 player.sendMessage(ChatColor.GRAY + "Players Toggled: "+ChatColor.RED.toString()+ChatColor.BOLD+"Disabled");
    			 }
    		  }
            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
    		 if(is.getType().equals(Material.SLIME_BALL) && is.hasItemMeta()){
              	 for(Player others : this.plugin.getServer().getOnlinePlayers()){
    	    	     player.hidePlayer(others);
                     player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 10, 1);
                     player.setItemInHand(new ItemStack(getCustName(Items.magmacream)));
                     player.sendMessage(ChatColor.GRAY + "Players Toggled: "+ChatColor.GREEN.toString()+ChatColor.BOLD+"Enabled");
    			 }
    		  }
              }
    	    }
    	 }
     }
}

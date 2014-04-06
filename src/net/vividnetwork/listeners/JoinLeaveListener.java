package net.vividnetwork.listeners;

import net.vividnetwork.VividNetwork;



import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JoinLeaveListener implements Listener {
	
	
	public VividNetwork plugin;

	public JoinLeaveListener(VividNetwork plugin) {
		this.plugin = plugin;
	}
	
	
	
        public enum Items{
		Compass,
		fishingrod,
		magmacream,
		slimball,
	}
	
	
	public ItemStack getCustName(Items item){
		ItemStack is = null;
		ItemMeta im;
		switch(item){
		case Compass:
			is = new ItemStack(Material.COMPASS);
			im = is.getItemMeta();
			im.setDisplayName(ChatColor.GOLD.toString()+ ChatColor.BOLD + "Server Selector");
			is.setItemMeta(im);
			break;
		case fishingrod:
			is = new ItemStack(Material.FISHING_ROD);
			im = is.getItemMeta();
			im.setDisplayName(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Grappling Hook");
			is.setItemMeta(im);
			break;
		case slimball:
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
	public void onPlayerJoin(PlayerJoinEvent event){
            Player player = event.getPlayer();
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 360000, plugin.getConfig().getInt("SpeedStrength")));
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, plugin.getConfig().getInt("JumpStrength")));
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 360000, plugin.getConfig().getInt("SpeedStrength")));
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 360000, plugin.getConfig().getInt("SpeedStrength")));
            player.getInventory().setItem(0, new ItemStack(getCustName(Items.Compass)));
            player.getInventory().setItem(3, new ItemStack(getCustName(Items.fishingrod)));
            player.getInventory().setItem(2, new ItemStack(getCustName(Items.magmacream)));
    }
	
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
			Player player = event.getPlayer();
			if(!player.hasPermission("hub.bypass")) {
            player.teleport(new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("X"), plugin.getConfig().getInt("Y"), plugin.getConfig().getInt("Z")));
		}
		player.getInventory().clear();
	}
}

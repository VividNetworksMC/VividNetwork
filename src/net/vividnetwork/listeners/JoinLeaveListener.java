package net.vividnetwork.listeners;

import net.vividnetwork.Items;
import net.vividnetwork.JoinItems;
import net.vividnetwork.VividNetwork;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class JoinLeaveListener implements Listener {
	
	
	public VividNetwork plugin;

	public JoinLeaveListener(VividNetwork plugin) {
		this.plugin = plugin;
	}

	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
            Player player = event.getPlayer();
        		if(player.hasPermission("vivid.armor.default")){
        			PlayerInventory inv = player.getInventory();
        			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
        			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
        			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
        			im.setColor(Color.GRAY);
        			is.setItemMeta(im);
        			inv.setBoots(is);
        		}

        		if(player.hasPermission("vivid.armor.builder")){
        			PlayerInventory inv = player.getInventory();
        			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
        			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
        			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
        			im.setColor(Color.MAROON);
        			is.setItemMeta(im);
        			inv.setBoots(is);
        		}

        		if(player.hasPermission("vivid.armor.webdev")){
        			PlayerInventory inv = player.getInventory();
        			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
        			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
        			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
        			im.setColor(Color.FUCHSIA);
        			is.setItemMeta(im);
        			inv.setBoots(is);
        		}

        		if(player.hasPermission("vivid.armor.dev")){
        			PlayerInventory inv = player.getInventory();
        			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
        			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
        			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
        			im.setColor(Color.TEAL);
        			is.setItemMeta(im);
        			inv.setBoots(is);
        		}

        		if(player.hasPermission("vivid.armor.owner")){
        			PlayerInventory inv = player.getInventory();
        			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
        			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
        			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
        			im.setColor(Color.MAROON);
        			is.setItemMeta(im);
        			inv.setBoots(is);

        		}

        		if(player.hasPermission("vivid.armor.founder")){
        			PlayerInventory inv = player.getInventory();
        			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
        			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
        			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
        			im.setColor(Color.PURPLE);
        			is.setItemMeta(im);
        			inv.setBoots(is);
        		}
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 360000, plugin.getConfig().getInt("SpeedStrength")));
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, plugin.getConfig().getInt("JumpStrength")));
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 360000, plugin.getConfig().getInt("SpeedStrength")));
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 360000, plugin.getConfig().getInt("SpeedStrength")));
            PlayerInventory inv = player.getInventory();
            inv.setItem(0, new ItemStack(JoinItems.getCustName(Items.Compass)));
            inv.setItem(3, new ItemStack(JoinItems.getCustName(Items.fishingrod)));
            inv.setItem(8, new ItemStack(JoinItems.getCustName(Items.magmacream)));
    }


	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
			Player player = event.getPlayer();
			if(!player.hasPermission("vivid.hub.bypass")) {
            player.teleport(new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("X"), plugin.getConfig().getInt("Y"), plugin.getConfig().getInt("Z")));
		}
		player.getInventory().clear();
	}
}


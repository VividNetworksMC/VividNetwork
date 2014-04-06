package net.vividnetwork.listeners;

import net.vividnetwork.VividNetwork;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.LeatherArmorMeta;


public class AntiMoveListener implements Listener{

	public VividNetwork plugin;

	public AntiMoveListener(VividNetwork plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void Join(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		if(player.hasPermission("armor.default")){
			PlayerInventory inv = player.getInventory();
			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
			im.setColor(Color.GRAY);
			is.setItemMeta(im);
			inv.setBoots(is);
		}

		if(player.hasPermission("armor.builder")){
			PlayerInventory inv = player.getInventory();
			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
			im.setColor(Color.MAROON);
			is.setItemMeta(im);
			inv.setBoots(is);
		}

		if(player.hasPermission("armor.webdev")){
			PlayerInventory inv = player.getInventory();
			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
			im.setColor(Color.FUCHSIA);
			is.setItemMeta(im);
			inv.setBoots(is);
		}

		if(player.hasPermission("armor.dev")){
			PlayerInventory inv = player.getInventory();
			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
			im.setColor(Color.TEAL);
			is.setItemMeta(im);
			inv.setBoots(is);
		}

		if(player.hasPermission("armor.owner")){
			PlayerInventory inv = player.getInventory();
			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
			im.setColor(Color.MAROON);
			is.setItemMeta(im);
			inv.setBoots(is);

		}

		if(player.hasPermission("armor.founder")){
			PlayerInventory inv = player.getInventory();
			ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
			is.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 50);
			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
			im.setColor(Color.PURPLE);
			is.setItemMeta(im);
			inv.setBoots(is);
		}
	}

	@EventHandler
	public void onClick(InventoryClickEvent event)
	{
		if(event.getSlotType() == InventoryType.SlotType.ARMOR)
		{
			event.setCancelled(true);
		}
	}
}

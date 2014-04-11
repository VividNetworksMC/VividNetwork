package net.vividnetwork;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinItems {


	public static ItemStack getCustName(Items item){
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
			break;
		case Compass:
			is = new ItemStack(Material.COMPASS);
			im = is.getItemMeta();
			im.setDisplayName(ChatColor.DARK_PURPLE.toString()+ ChatColor.BOLD + "Ender Selecter");
			is.setItemMeta(im);
			break;
		case fishingrod:
			is = new ItemStack(Material.FISHING_ROD);
			im = is.getItemMeta();
			im.setDisplayName(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Grappling Hook");
			is.setItemMeta(im);
			break;
         	case wheat:
			is = new ItemStack(Material.WHEAT);
			im = is.getItemMeta();
			im.setDisplayName(ChatColor.DARK_AQUA.toString() + ChatColor.BOLD + "Magic Broom");
			is.setItemMeta(im);
			break;
		default:
			break;
		}
		return is;
	}

}

package net.vividnetwork.listeners;

import net.vividnetwork.VividNetwork;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;


public class InventoryListener implements Listener{

	public VividNetwork plugin;

	public InventoryListener(VividNetwork plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onClick(InventoryClickEvent event){
		if(event.getSlotType() == InventoryType.SlotType.ARMOR || event.getSlotType() == InventoryType.SlotType.OUTSIDE){
			event.setCancelled(true);
		}
	}
}

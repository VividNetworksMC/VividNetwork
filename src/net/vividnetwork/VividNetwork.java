package net.vividnetwork;

import java.util.List;

import net.vividnetwork.listeners.AntiCapsEventListener;
import net.vividnetwork.listeners.AntiSwearListener;
import net.vividnetwork.listeners.DoubleJumpListener;
import net.vividnetwork.listeners.DropListener;
import net.vividnetwork.listeners.JoinLeaveListener;
import net.vividnetwork.listeners.VanishTorchListener;
import net.vividnetwork.listeners.InventoryListener;
import net.vividnetwork.listeners.Grappler;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class VividNetwork extends JavaPlugin{

		@Override
		public void onEnable() {
			//Listeners			
			getServer().getPluginManager().registerEvents(new JoinLeaveListener(this), this);
			getServer().getPluginManager().registerEvents(new DropListener(this), this);
			getServer().getPluginManager().registerEvents(new DoubleJumpListener(this), this);
			getServer().getPluginManager().registerEvents(new VanishTorchListener(this), this);
			getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
			getServer().getPluginManager().registerEvents(new Grappler(this), this);
			getServer().getPluginManager().registerEvents(new AntiCapsEventListener(this), this);
			getServer().getPluginManager().registerEvents(new AntiSwearListener(this), this);
			getCommand("Warn").setExecutor(new WarnCommand(this));
			PluginDescriptionFile pdfFile = this.getDescription();
			System.out.println("[VividNetwork] " + pdfFile.getVersion() + " is Enabled!");
			List<String> authors = pdfFile.getAuthors();
			System.out.println("[VividNetwork] Developed by " + authors);
			saveConfig();
		}
		

		@Override
		public void onDisable(){
			PluginDescriptionFile pdfFile = this.getDescription();
			System.out.println("[VividNetwork] "+ pdfFile.getVersion() + " is Disabled!");
			saveConfig();
		}
}


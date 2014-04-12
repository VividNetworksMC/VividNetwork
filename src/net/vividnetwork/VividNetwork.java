package net.vividnetwork;

import java.util.List;

import net.vividnetwork.listeners.AdminChatListeners;
import net.vividnetwork.listeners.AntiSwearListener;
import net.vividnetwork.listeners.DoubleJumpListener;
import net.vividnetwork.listeners.DropListener;
import net.vividnetwork.listeners.JoinLeaveListener;
import net.vividnetwork.listeners.JumpListener;
import net.vividnetwork.listeners.ParticleListener;
import net.vividnetwork.listeners.VanishTorchListener;
import net.vividnetwork.listeners.InventoryListener;
import net.vividnetwork.listeners.Grappler;
import net.vividnetwork.listeners.WorldListener;

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
		getServer().getPluginManager().registerEvents(new AntiSwearListener(this), this);
		getServer().getPluginManager().registerEvents(new AdminChatListeners(), this);
		getServer().getPluginManager().registerEvents(new JumpListener(this), this);
		getServer().getPluginManager().registerEvents(new ParticleListener(this), this);
		getServer().getPluginManager().registerEvents(new WorldListener(this), this);
		getCommand("AdminChat").setExecutor(new AdminChat());
		getCommand("StopEffect").setExecutor(new StopEffectCommand(this));
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


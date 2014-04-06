package net.vividnetwork.listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitScheduler;

import net.vividnetwork.VividNetwork;

public class NoEnviromentChange implements Listener {

    public VividNetwork plugin;

    public NoEnviromentChange(VividNetwork plugin){ 
    	this.plugin = plugin;
     }
    
    public void onEnable()
	{		
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(plugin, new Runnable()
		{

			@Override
			public void run()
			{
				List<World> worlds = Bukkit.getWorlds();
				for(World w : worlds)
				{
					w.setStorm(false);
					w.setThundering(false);
					w.setTime(0);
				}

			}

		}
		, 0, 100L);
	}
    
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
	{
		Player player = (Player) sender;

		if(commandLabel.equalsIgnoreCase("NoEnviromentChanges") || commandLabel.equalsIgnoreCase("NEC"))
		{
			player.sendMessage(ChatColor.GOLD + "Feature developed by xAstraah!");
		}

		return false;
	}

}


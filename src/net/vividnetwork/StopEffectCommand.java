package net.vividnetwork;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StopEffectCommand implements CommandExecutor {

	public VividNetwork plugin;

	public StopEffectCommand(VividNetwork plugin)
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
	{
		Player player = (Player) sender;

		if(commandLabel.equalsIgnoreCase("stopeffect") || commandLabel.equalsIgnoreCase("se"))
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,360000, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,360000, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,360000, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL,360000, 0));
			player.sendMessage(ChatColor.RED + "Potion Effects Have Been Removed!");
		}

		return false;
	}

}

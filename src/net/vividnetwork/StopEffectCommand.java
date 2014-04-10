package net.vividnetwork;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopEffectCommand implements CommandExecutor {

	public VividNetwork plugin;

	public StopEffectCommand(VividNetwork plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(label.equalsIgnoreCase("stopeffect")){
				player.getActivePotionEffects().clear();    
			}else{
				sender.sendMessage(ChatColor.RED+"You need to be a player to do this command!");
			}
		}
		return false;
	}

}
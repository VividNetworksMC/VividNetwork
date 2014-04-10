package net.vividnetwork;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarnCommand implements CommandExecutor
{

	public VividNetwork plugin;

	public WarnCommand(VividNetwork plugin)
	{
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{

		if (cmd.getName().equalsIgnoreCase("warn"))
		{
			if(sender.hasPermission("vivid.warnings.use") || sender.isOp() )
			{
				if (args.length < 2)
				{
					sender.sendMessage(ChatColor.RED + "/warn <player> <reason>");
					return true;
				}

				final Player target = Bukkit.getServer().getPlayer(args[0]);

				if (target == null)
				{
					sender.sendMessage(ChatColor.RED + "Could not find player " + args[0]);
					return true;
				}

				String msg = "";
				for (int i = 1; i < args.length; i++)
				{
					msg += args[i] + " ";
				}

				Object level = this.plugin.getConfig().get(target.getName());

				if (level == null)
				{

					target.sendMessage(ChatColor.RED + "You have been warned, Reason: " + msg);
					this.plugin.getConfig().set(target.getName(), 1);
					this.plugin.saveConfig();

					return true;

				}

				int l = Integer.parseInt(level.toString());

				if (l == 1)
				{

					target.kickPlayer(ChatColor.RED + "You have been warned, Reason: " + msg);
					this.plugin.getConfig().set(target.getName(), 2);
					this.plugin.saveConfig();

					return true;

				}

				if (l == 2)
				{

					target.kickPlayer(ChatColor.RED + "You have been warned, Reason: " + msg);
					target.setBanned(true);
					this.plugin.getConfig().set(target.getName(), 3);
					this.plugin.saveConfig();

					return true;

				}
			}

		}
		return true;
	}

}

package net.vividnetwork;

import java.util.ArrayList;
import java.util.List;

import net.vividnetwork.listeners.AdminChatListeners;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChat implements CommandExecutor
{

	public static List<String> chatters = new ArrayList<String>();

	public String buildMessage(String[] args, int start)
	{
		StringBuilder msg = new StringBuilder();
		for(int i = start; i < args.length; i++)
		{
			if(i != start)
			{
				msg.append(" ");
			}
			msg.append(args[i]);
		}
		return msg.toString();
	}

	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
	{
		String msg = buildMessage(args, 0);
		if(commandLabel.equalsIgnoreCase("AdminChat"))
		{
			if(AdminChatListeners.canUseAdminChat(sender))
			{
				if(args.length > 0)
				{
					if(args[0].equalsIgnoreCase("toggle"))
					{
						if(!(sender instanceof Player))
						{
							sender.sendMessage(ChatColor.RED + "[AdminChat] Console can not use /AdminChat Toggle!");
							return false;
						}
						if(AdminChat.chatters.contains(sender.getName()))
						{
							AdminChat.chatters.remove(sender.getName());
							sender.sendMessage(ChatColor.RED + "[AdminChat] AdminChat Toggle Has Been Disabled!");
						}
						else
						{
							AdminChat.chatters.add(sender.getName());
							sender.sendMessage(ChatColor.RED + "[AdminChat] AdminChat Toggle Has Been Enabled!");
						}
						return true;
					}
					AdminChatListeners.sendToChat(msg, sender);
				}
				else
				{
					sender.sendMessage(ChatColor.RED + "[AdminChat] /AdminChat <MessageHere>");
				}
			}
			else
			{
				sender.sendMessage(ChatColor.RED + "[AdminChat] You Do Not Have Permission To Execute This Command!");
			}
		}
		return false;
	}

}

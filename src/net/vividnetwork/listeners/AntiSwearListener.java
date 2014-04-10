package net.vividnetwork.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.vividnetwork.VividNetwork;

public class AntiSwearListener implements Listener {

	public VividNetwork plugin;

	public AntiSwearListener(VividNetwork plugin){
		this.plugin = plugin;
	}

	boolean spamstop;
	boolean anticaps;
	boolean antichar;
	String capsmsg;
	String charmsg;
	int maxlength;
	int time;
	private static List<String> players = new ArrayList<String>();

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerChat(AsyncPlayerChatEvent e){
		spamstop = plugin.getConfig().getBoolean("spamstop");
		anticaps = plugin.getConfig().getBoolean("anticaps");
		antichar = plugin.getConfig().getBoolean("antichar");
		maxlength = plugin.getConfig().getInt("maxlength");
		time = plugin.getConfig().getInt("time");
		final Player p = e.getPlayer();
		if(p.hasPermission("vivid.chat.exempt")){
			return;
		}
		if(maxlength > -1){
			if(e.getMessage().length() > maxlength){
				e.setCancelled(true);
				p.sendMessage("§M"+e.getMessage());
				p.sendMessage("§4Message too long. Maximum length is " + maxlength + " chars");
			}
		}
		if(antichar == true){
			String rawmsg = e.getMessage();
			String patternn = "([\\D])\\1{3,}";
			String r = "$1";
			String msg = rawmsg.replaceAll(patternn, r);
			e.setMessage(msg);
			charmsg = msg;
		}
		if(anticaps == true){
			String msg = e.getMessage();
			if(antichar == true){
				msg = charmsg;
			}
			String expr = "([A-Z]){2,}";
			Pattern pattern = Pattern.compile(expr);  
			Matcher matcher = pattern.matcher(msg);  
			StringBuffer sb = new StringBuffer();  
			while (matcher.find()) {
				matcher.appendReplacement(sb, matcher.group().toLowerCase());      
			}  
			matcher.appendTail(sb);  
			String endmsg = sb.toString();  
			e.setMessage(endmsg);
		}
		if(spamstop == true){
			if(players.contains(p.getName())){
				e.setCancelled(true);
			} else {
				players.add(p.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override
					public void run() {
						players.remove(p.getName());
					}

				}, time*20L);
			}
		}
		for(String word : e.getMessage().split(" ")){
			if(plugin.getConfig().getStringList("bannedwords").contains(word)){
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.DARK_RED + "Please Don't Use That Sort Of Language!");
			}
		}
	}

}

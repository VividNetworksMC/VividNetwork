package net.vividnetwork.listeners;

import net.vividnetwork.VividNetwork;
import net.vividnetwork.particles.ParticleEffect;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ParticleListener implements Listener {
	
	public VividNetwork plugin;
	
	public ParticleListener(VividNetwork plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		Location loc = player.getLocation();
		if(!(player.hasPermission("particle.founder"))){
			return;
		}
		
		if(player.hasPermission("particle.founder") && player.getGameMode() == GameMode.SURVIVAL){
			if(player.isSneaking() || player.isSprinting()){
				ParticleEffect pe = ParticleEffect.TOWN_AURA;
				try {
					pe.sendToPlayer(player, loc, 1, 2, 1, 1, 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		if(!(player.hasPermission("particle.dev")))
			return;
		
		if(player.hasPermission("particle.dev") && player.getGameMode() == GameMode.SURVIVAL){
			if(player.isSneaking() || player.isSprinting()){
				ParticleEffect pe = ParticleEffect.FIREWORKS_SPARK;
				try {
					pe.sendToPlayer(player, loc, 1, 2, 1, 1, 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		if(!(player.hasPermission("particle.owner")))
			return;
		
		if(player.hasPermission("particle.owner") 
				&& player.getGameMode() == GameMode.SURVIVAL){
			if(player.isSneaking() || player.isSprinting()){
				ParticleEffect pe = ParticleEffect.CLOUD;
				try {
					pe.sendToPlayer(player, loc, 1, 2, 1, 1, 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		if(!(player.hasPermission("particle.webdev")))
			return;
		
		if(player.hasPermission("particle.webdev") 
			&& player.getGameMode() == GameMode.SURVIVAL){
		if(player.isSneaking() || player.isSprinting()){
			ParticleEffect pe = ParticleEffect.CLOUD;
			try {
				pe.sendToPlayer(player, loc, 1, 2, 1, 1, 2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
		if(!(player.hasPermission("particle.builder")))
			return;
		
		if(player.hasPermission("particle.builder") && player.getGameMode() == GameMode.SURVIVAL){
			if(player.isSneaking() || player.isSprinting()){
				ParticleEffect pe = ParticleEffect.MOB_SPELL;
				try {
					pe.sendToPlayer(player, loc, 1, 2, 1, 1, 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		if(player.hasPermission("particle.defualt") && player.getGameMode() == GameMode.SURVIVAL){
			if(player.isSneaking() || player.isSprinting()){
				ParticleEffect pe = ParticleEffect.RED_DUST;
				try {
					pe.sendToPlayer(player, loc, 1, 2, 1, 1, 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

package de.steuer.lobby.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.steuer.lobby.utils.ItemBuilder;

public class PlayerJoinListener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.getInventory().clear();
		player.getInventory().setItem(4, new ItemBuilder(Material.COMPASS, 1, 0).setName("§aNavigator").build());
		
		event.setJoinMessage(null);
	}

}

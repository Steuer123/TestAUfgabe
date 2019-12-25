package de.steuer.lobby.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.steuer.lobby.Lobby;

public class InventoryClickListener implements Listener{
	
	Lobby lobby;
	
	public InventoryClickListener(Lobby lobby) {
		this.lobby = lobby;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		try {
			if(event.getClickedInventory().getTitle().equalsIgnoreCase("§aNavigator")) {
				if(event.getCurrentItem().getType() != Material.GRASS) return;
				if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCityBuild")) {
					player.closeInventory();
					try {
						player.teleport(lobby.getLocationManager().getLocation("cb"));
						player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
					} catch(Exception e) {
						player.sendMessage(lobby.getPrefix() + "§7Der Citybuild Spawn wurde noch nicht gesetzt!");
					}
				}
			}
		} catch(NullPointerException e) {}
	}

}

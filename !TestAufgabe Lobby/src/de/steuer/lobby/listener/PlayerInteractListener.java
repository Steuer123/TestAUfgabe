package de.steuer.lobby.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import de.steuer.lobby.Lobby;

public class PlayerInteractListener implements Listener{
	
	Lobby lobby;
	
	public PlayerInteractListener(Lobby lobby) {
		this.lobby = lobby;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		try {
			if(event.getItem().getType() == Material.COMPASS) {
				if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aNavigator")) {
					lobby.getInstance().getInventoryManager().openNavInventory(player);
				}
			}
		} catch(NullPointerException e) {}
	}

}

package de.steuer.lobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryManager {

	public void openNavInventory(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 9, "§aNavigator");
		for(int i = 0; i < inventory.getSize(); i++) {
			inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS, 1, 7).build());
		}
		inventory.setItem(4, new ItemBuilder(Material.GRASS, 1, 0).setName("§bCityBuild").build());
		
		player.openInventory(inventory);
	}
	
}

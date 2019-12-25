package de.steuer.lobby.utils;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	private ItemStack item;
	private ItemMeta meta;
	
	public ItemBuilder(Material material, int amount, int subID) {
		item = new ItemStack(material, amount, (short) subID);
		meta = item.getItemMeta();
	}
	
	public ItemBuilder setName(String name) {
		meta.setDisplayName(name);
		return this;
	}
	
	public ItemBuilder setLore(String... lore) {
		meta.setLore(Arrays.asList(lore));
		return this;
	}
	
	public ItemStack build() {
		item.setItemMeta(meta);
		return item;
	}

}

package de.steuer.lobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.steuer.lobby.commands.SetCommand;
import de.steuer.lobby.listener.InventoryClickListener;
import de.steuer.lobby.listener.PlayerInteractListener;
import de.steuer.lobby.listener.PlayerJoinListener;
import de.steuer.lobby.utils.InventoryManager;
import de.steuer.lobby.utils.LocationManager;

public class Lobby extends JavaPlugin{
	
	private Lobby instance;
	private String prefix = "§aLobby §8| §r";
	private String noperms = prefix + "§7Dazu hast du keine Rechte!";
	private InventoryManager inventoryManager;
	private LocationManager locationManager;
	
	@Override
	public void onEnable() {
		instance = this;
		inventoryManager = new InventoryManager();
		locationManager = new LocationManager(this);
		
		loadConfig();
		register();
		
		System.out.println("Lobby gestartet!");
	}

	private void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	private void register() {
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new InventoryClickListener(this), this);
		pluginManager.registerEvents(new PlayerJoinListener(), this);
		pluginManager.registerEvents(new PlayerInteractListener(this), this);
		
		this.getCommand("set").setExecutor(new SetCommand(this));
	}
	
	public Lobby getInstance() {
		return instance;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getNoperms() {
		return noperms;
	}
	
	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}
	
	public LocationManager getLocationManager() {
		return locationManager;
	}

}

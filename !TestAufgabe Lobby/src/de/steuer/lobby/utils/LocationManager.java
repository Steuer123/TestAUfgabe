package de.steuer.lobby.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.steuer.lobby.Lobby;

public class LocationManager {
	
	Lobby lobby;
	private FileConfiguration cfg;
	
	public LocationManager(Lobby lobby) {
		this.cfg = lobby.getInstance().getConfig();
	}
	
	public void setLocation(String name, Location loc) {
		String path = "Location." + name.toUpperCase() + ".";
		this.cfg.set(path + "World", loc.getWorld().getName());
		this.cfg.set(path + "X", loc.getX());
		this.cfg.set(path + "Y", loc.getY());
		this.cfg.set(path + "Z", loc.getZ());
		this.cfg.set(path + "Yaw", loc.getYaw());
		this.cfg.set(path + "Pitch", loc.getPitch());
		File file = new File("plugins//TestLobby//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Location getLocation(String name) {
		return new Location(Bukkit.getWorld(this.cfg.getString("Location." + name.toUpperCase() + ".World")), this.cfg.getDouble("Location." + name.toUpperCase() + ".X"), this.cfg.getDouble("Location." + name.toUpperCase() + ".Y"), this.cfg.getDouble("Location." + name.toUpperCase() + ".Z"), (float) this.cfg.getDouble("Location." + name.toUpperCase() + ".Yaw"), (float) this.cfg.getDouble("Location." + name.toUpperCase() + ".Pitch"));
	}

}

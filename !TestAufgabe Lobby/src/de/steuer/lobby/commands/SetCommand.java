package de.steuer.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.steuer.lobby.Lobby;

public class SetCommand implements CommandExecutor{

	Lobby lobby;
	
	public SetCommand(Lobby lobby) {
		this.lobby = lobby;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(!(cs instanceof Player)) {
			cs.sendMessage(lobby.getPrefix() + "§7Du musst ein Spieler sein!");
			return true;
		}
		Player player = (Player) cs;
		if(!player.hasPermission("system.setup")) {
			player.sendMessage(lobby.getPrefix() + "§7Dazu hast du keine Rechte!");
			return true;
		}
		
		lobby.getLocationManager().setLocation("cb", player.getLocation());
		player.sendMessage(lobby.getPrefix() + "§7Du hast den citybuild Spawn gesetzt!");
		
		
		return false;
	}

}

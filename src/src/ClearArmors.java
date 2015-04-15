package src;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class ClearArmors extends JavaPlugin implements Listener {
	
	public void onDisable() {
		this.getLogger().info("Plugin disable !");
	}
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		this.getLogger().info("Plugin ready !");
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (commandLabel.equals("cleararmors")) {
			if (args.length < 1) {
				sender.sendMessage(ChatColor.RED+"Please enter player name");
				return true;
			}
			String player = args[0];
			Player p = getServer().getPlayer(player);
			if (p != null) {
				p.getInventory().setArmorContents(null);
				sender.sendMessage(ChatColor.GREEN+"Done.");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED+"Player "+player+" not found");
				return true;
			}
		}
		return false;
	}
	
	
}

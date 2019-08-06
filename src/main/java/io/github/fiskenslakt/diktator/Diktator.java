package io.github.fiskenslakt.diktator;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Diktator extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		getLogger().info("Diktator is enabled");
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {
		getLogger().info("Diktator is disabled");
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		String msg = event.getMessage();
		
		if (msg.toLowerCase().contains("xd")) {
			Player player = event.getPlayer();

			new BukkitRunnable() {
				@Override
				public void run() {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco take " + player.getName() + " 1");
				}
			}.runTask(this);
		}
	}
}
package com.flareye.ontime.handlers;


import com.flareye.FactionUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Optional;

public class playerHandler implements Listener {
    public playerHandler(FactionUtils plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent joinEvent) {
        String playerName = joinEvent.getPlayer().getName();
        ontimeHandler.updatePlayerOntime(playerName, Optional.of(true), Optional.empty());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent leaveEvent) {
        String playerName = leaveEvent.getPlayer().getName();
        ontimeHandler.setToDatabase(playerName);
    }
}

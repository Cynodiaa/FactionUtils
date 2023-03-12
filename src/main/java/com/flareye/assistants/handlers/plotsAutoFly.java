package com.flareye.assistants.handlers;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class plotsAutoFly implements Listener {

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        if (world.getName().equals("Arsalar")) {
            player.sendMessage("§cArsalar §6dünyasına ışınlandınız. Uçuş Modu §caktif");
            player.setAllowFlight(true);
        } else {
            // player.sendMessage("§cArsalar §6dünyasına çıktınız. Uçuş Modu §cde-aktif");
            player.setAllowFlight(false);
        }
    }
}

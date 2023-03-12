package com.flareye.protection.events;

import com.flareye.FactionUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static org.bukkit.ChatColor.*;

public class denyBlock implements Listener {
    public denyBlock(FactionUtils plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onCommandBlockPlace(BlockPlaceEvent placeEvent) {
        if (placeEvent.getPlayer().hasPermission("factionutils.protect.exempt")) {
            return;
        }
        if (placeEvent.getBlock().getType() != Material.TNT && placeEvent.getBlock().getType() != Material.TNT_MINECART) {
            return;
        }
        placeEvent.getPlayer().getInventory().getItemInMainHand().setType(Material.AIR);
        placeEvent.getPlayer().sendMessage(RED + "Bu sunucuda TNT bloklarının kullanımı yasaklanmıştır. Bu uyarının yanlış olduğunu düşünüyorsanız bir yetkiliyle iletişime geçin.");
    }
}

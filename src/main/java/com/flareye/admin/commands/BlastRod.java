package com.flareye.admin.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class BlastRod implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack lightRod = new ItemStack(Material.STICK);
            ItemMeta meta = lightRod.getItemMeta();
            meta.setDisplayName("§4§lŞimşekatar Mustaşak");
            lightRod.setItemMeta(meta);
            player.getInventory().addItem(lightRod);
            Location loc = player.getTargetBlock(null, 5).getLocation();
            World world = loc.getWorld();
            LightningStrike lightning = world.strikeLightning(loc);
            return true;
        }
        return false;
    }
}
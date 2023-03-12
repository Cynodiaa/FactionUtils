package com.flareye.chatguard.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class chat implements CommandExecutor {
    static ChatColor OldButGold = ChatColor.GOLD;
    static ChatColor DarkAqua = ChatColor.DARK_AQUA;
    static ChatColor White = ChatColor.WHITE;
    static ChatColor Yellow = ChatColor.YELLOW;
    static ChatColor Red = ChatColor.RED;

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!sender.hasPermission("factionutils.chat")) {
            sender.sendMessage(Red + "Bunun için iznin yok!");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(Red + "En az bir seçenek girin!");
            return true;
        }

        switch (args[0]) {
            case "clear": {}
            case "temizle": {
                return clear(sender);
            }
            default: {
                sender.sendMessage(Red + "Geçersiz bir argüman girdiniz.");
                return false;
            }
        }
    }

    private boolean clear(CommandSender sender) {
        if (!sender.hasPermission("factionutils.chat.delete")) {
            sender.sendMessage(Red + "Bunun için iznin yok!");
            return true;
        }

        for (int i = 0; i < 200; i++) {
            sender.getServer().broadcastMessage(" ");
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;
            sender.getServer().broadcastMessage(
                    OldButGold + "Flareye" + DarkAqua + "Chat" + White + " | "+ Yellow + "Sohbet "+ Red + player.getName() + " " + Yellow + "tarafından temizlendi" + Red + "!");
        }
        return true;
    }
}
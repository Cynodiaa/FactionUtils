package com.flareye.regulators.perms;

import org.bukkit.command.CommandSender;

public class permChecker {
    private CommandSender player;
    public void checkPerm(String permName, String messageName) throws Exception {
        if (player.hasPermission(permName)) return;
        player.sendMessage(getLanguageText(messageName));
        throw new Exception("This it not an error.");
    }

    public void setPlayer(CommandSender player) {
        this.player = player;
    }

    public static String getLanguageText(String messageName) {
        return ""; // Burayı hallet
    }
}
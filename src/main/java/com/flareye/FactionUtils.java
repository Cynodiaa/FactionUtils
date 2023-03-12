package com.flareye;

import com.flareye.admin.commands.BlastRod;
import com.flareye.chatguard.commands.chat;
import com.flareye.ontime.handlers.ontimeHandler;
import com.flareye.ontime.handlers.playerHandler;
import com.flareye.protection.events.denyBlock;
import com.flareye.regulators.config.FConfig;
import com.flareye.regulators.log.Logger;
import com.flareye.regulators.replacers.CommandReplacer;
import org.bukkit.plugin.java.JavaPlugin;

public final class FactionUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger.setPlugin(this);
        Logger.log("Logger system loaded!");

        FConfig.setPlugin(this);
        FConfig.reloadConfiguration();
        Logger.log("Configs are loaded!");

        ontimeHandler.startTimer();
        new playerHandler(this);
        Logger.log("Ontime system loaded!");

        new denyBlock(this);
        Logger.log("Protection system loaded!");

        CommandReplacer commands = new CommandReplacer();
        commands.addCommand("chat", new chat())
                .addCommand("lightrod", new BlastRod());
        commands.registerCommands(this);
        Logger.log("Commands loaded!");
    }

    @Override
    public void onDisable() {
        Logger.log("Systems shut down!");
        Logger.log("See you again :)!");
    }
}


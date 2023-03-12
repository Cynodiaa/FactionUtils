package com.flareye.regulators.replacers;

import com.flareye.FactionUtils;
import com.flareye.regulators.log.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandReplacer {
    private final static HashMap<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>() {};

    public final CommandReplacer addCommand(String commandName, CommandExecutor commandExecutor) {
        commands.put(commandName, commandExecutor);
        return this;
    }

    public final CommandReplacer registerCommands(FactionUtils plugin) {
        for (Map.Entry<String, CommandExecutor> command : commands.entrySet()) {
            Command commandCheck = plugin.getCommand(command.getKey());
            if (commandCheck == null) {
                Logger.log("Given command " + command.getKey() + " is not found.");
                continue;
            }
            commandCheck.setExecutor()
        }
        commands.forEach((command, executor) -> plugin.getCommand(command).setExecutor(executor));
        return this;
    }
}

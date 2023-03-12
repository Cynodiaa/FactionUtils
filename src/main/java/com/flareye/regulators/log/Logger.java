package com.flareye.regulators.log;

import com.flareye.FactionUtils;

public class Logger {
    private static FactionUtils plugin;
    private static final String logPrefix = "[FactionUtils]";

    public static void setPlugin(FactionUtils plugin) {
        Logger.plugin = plugin;
    }

    public static void log(String message) {
        plugin.getLogger().info(joinStrings(logPrefix, message));
    }

    private static String joinStrings(String... strings) {
        return String.join(" ", strings);
    }
}

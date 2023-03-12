package com.flareye.regulators.config;

import com.flareye.FactionUtils;
import com.flareye.regulators.config.holders.baseConfig;
import org.bukkit.configuration.file.FileConfiguration;

public class FConfig {
    private static FactionUtils plugin;
    private static FileConfiguration conf;
    public static void setPlugin(FactionUtils plugin) {
        FConfig.plugin = plugin;
    }

    public static void reloadConfiguration() {
        FConfig.conf = plugin.getConfig();
    }

    public static baseConfig getBase() {
        return new baseConfig(conf);
    }
}

package com.flareye.regulators.config.holders;

import org.bukkit.configuration.file.FileConfiguration;

public class baseConfig {
    private FileConfiguration config;
    public baseConfig(FileConfiguration config) {
        this.config = config;
    }

    public final String locale = config.getString("locale");
}
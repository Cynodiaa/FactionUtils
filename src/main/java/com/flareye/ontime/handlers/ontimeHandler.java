package com.flareye.ontime.handlers;

import java.sql.Timestamp;
import java.util.*;

import com.flareye.ontime.mysql.database;
import com.flareye.ontime.mysql.databaseUser;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ontimeHandler {
    public static void startTimer() {
        database.setDB();
        Timer ontimeTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    if (player == null) continue;
                    String playerName = player.getName();
                    setToDatabase(playerName);
                }
            }
        };

        ontimeTimer.schedule(task, 0, 1000 * 20); // 5 dk yapmayı unutma
    }

    public static Boolean setToDatabase(String playerName) {
        databaseUser user = database.getUser(playerName);
        if (user == null) {
            user = new databaseUser(playerName);
            user.setByMiliseconds(0L);
            user.setLastUpdate(getTimestamp());
        }
        Long newOntime = (getTimestamp() - user.lastUpdate) + user.miliseconds;
        return updatePlayerOntime(user, Optional.of(true), Optional.of(newOntime));
    }

    public static Long getTimestamp() {
        return (new Timestamp((new Date()).getTime())).getTime();
    }

    public static Boolean updatePlayerOntime(String playerName, Optional<Boolean> updateLastTime, Optional<Long> miliseconds) {
        databaseUser user = database.getUser(playerName);
        if (user == null) return false;
        return updatePlayerOntime(user, updateLastTime, miliseconds);
    }

    public static Boolean updatePlayerOntime(databaseUser user, Optional<Boolean> updateLastTime, Optional<Long> miliseconds) {
        if (user == null) return false;
        if (updateLastTime.isPresent()) user.lastUpdate = getTimestamp();
        miliseconds.ifPresent(user::setByMiliseconds);
        return database.setUser(user);
    }
}
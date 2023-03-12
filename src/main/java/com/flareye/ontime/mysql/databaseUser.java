package com.flareye.ontime.mysql;

import com.flareye.ontime.utils.dateSystem;
import com.flareye.ontime.utils.dateConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
public class databaseUser {
    public String username;
    public int days;
    public int hours;
    public int minutes;
    public Long miliseconds;
    public Long lastUpdate;

    public databaseUser(ResultSet userData) {
        try {
            username = userData.getString("Username");
            days = userData.getInt("Days");
            hours = userData.getInt("Hours");
            minutes  = userData.getInt("Minutes");
            miliseconds = userData.getLong("Miliseconds");
            lastUpdate = userData.getLong("LastUpdate");
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public databaseUser(String username) {
        this.username = username;
    }

    public databaseUser() {}

    public databaseUser setByMiliseconds(Long milisecond) {
        dateConverter converter = dateSystem.convertMiliseconds(milisecond);
        days = converter.days;
        hours = converter.hours;
        minutes = converter.minutes;
        miliseconds = converter.miliseconds;
        return this;
    }

    public databaseUser setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}

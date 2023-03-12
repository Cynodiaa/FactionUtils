package com.flareye.ontime.mysql;

import org.jetbrains.annotations.Nullable;

import java.sql.*;
public class database {
    private static Connection ontimeConnection;
    private static Boolean databaseFound = false;
    public static void setDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String ConnectionString = "jdbc:mysql://45.95.214.6:3306/FlareyeSys";

            Connection startup = DriverManager.getConnection(ConnectionString, "FlareyeSys", "BnE273-z@zKl^");
            ResultSet rs = startup.getMetaData().getTables(startup.getCatalog(), "", null, new String[]{"TABLE"});
            while(rs.next() && !databaseFound) {
                String tableName = rs.getString("TABLE_NAME");
                if (tableName.equals("Ontime")) databaseFound = true;
            }
            ontimeConnection = startup;
            if (!databaseFound) {
                String ontimeData = "(Username VARCHAR(32), Days INT, Hours INT, Minutes INT, Miliseconds BIGINT, LastUpdate BIGINT)";
                String statement = "CREATE TABLE Ontime " + ontimeData;
                execute(statement);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public static databaseUser getUser(String playerName) {
        try {
            ResultSet userData = query("SELECT * FROM Ontime WHERE Username='" + playerName + "'");
            if (!userData.next()) return null;
            return new databaseUser(userData);
        } catch (SQLException error) {
            error.printStackTrace();
            return null;
        }
    }

    public static @Nullable ResultSet query(String statement) {
        try {
            return ontimeConnection.createStatement().executeQuery(statement);
        } catch (SQLException error) {
            error.printStackTrace();
            return null;
        }
    }

    public static Boolean execute(String statement) {
        try {
            return ontimeConnection.createStatement().execute(statement);
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }

    public static Boolean setUser(databaseUser user) {
        databaseUser userCheck = getUser(user.username);
        if (userCheck == null) {
            System.out.println(user.lastUpdate);
            String dataSet = "Username, Days, Hours, Minutes, Miliseconds, LastUpdate";
            String newData = "'" + user.username +
                    "', '" + user.days +
                    "', '" + user.hours +
                    "', '" + user.minutes +
                    "', '" + user.miliseconds +
                    "', '" + user.lastUpdate + "'";
            return database.execute("INSERT INTO Ontime (" + dataSet + ") VALUES (" + newData + ")");
        }
        String newData = "Username='" + user.username +
                "', Days='" + user.days +
                "', Hours='" + user.hours +
                "', Minutes='" + user.minutes +
                "', Miliseconds='" + user.miliseconds +
                "', LastUpdate='" + user.lastUpdate + "'";
        return database.execute("UPDATE Ontime SET" + newData + "WHERE Username='" + user.username + "'");
    }
}

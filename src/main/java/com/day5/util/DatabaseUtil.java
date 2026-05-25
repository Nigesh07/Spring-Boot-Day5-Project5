package com.day5.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseUtil {

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    static {

        try {

            Properties properties = new Properties();

            InputStream input =
                    DatabaseUtil.class
                            .getClassLoader()
                            .getResourceAsStream("db.properties");

            properties.load(input);

            URL = properties.getProperty("db.url");
            USERNAME = properties.getProperty("db.username");
            PASSWORD = properties.getProperty("db.password");

            Class.forName(
                    properties.getProperty("db.driver")
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
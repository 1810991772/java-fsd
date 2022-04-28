package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConfig {
    private Connection con;
    private static MySqlConfig mySqlConfig;

    private MySqlConfig() {
    }

    public Connection getMyConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "root");
        return con;
    }

    public static MySqlConfig createMySqlConfig() {
        if(mySqlConfig == null) {
            mySqlConfig = new MySqlConfig();
        }

        return mySqlConfig;
    }
}

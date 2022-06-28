package com.github.qx57.tdo_example_java.configurations;

import lombok.Getter;

import java.sql.*;

public class DB {

    private final String url = "jdbc:postgresql://localhost:6543/test";
    private final String user = "postgres";
    private final String password = "pwd123";

    @Getter
    private Statement statement;

    public DB() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            statement = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet query(String q) {
        try {
            return statement.executeQuery(q);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.github.qx57.tdo_example_java.tdo.db;

import com.github.qx57.tdo_example_java.configurations.DB;
import com.google.inject.Inject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDB {

    @Inject
    private DB db;

    private final String table = "orders";

    private Integer id;

    private String status;

    public String getStatus(Integer id) {
        try {
            String q = String.format("SELECT status FROM %s WHERE id=%d", table, id);
            System.out.println(q);
            ResultSet result = db.query(q);
            result.next();
            return result.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

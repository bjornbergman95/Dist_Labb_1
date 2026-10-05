package org.example.db;

import org.example.bo.Order;

import java.sql.SQLException;

public class OrderDB {

    public static boolean checkout(Order order) {
        DbQueary db = new DbQueary();

        try {
            return db.checkout(order);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

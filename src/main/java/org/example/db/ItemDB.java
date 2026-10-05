package org.example.db;

import org.example.bo.Item;
import org.example.bo.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDB extends Item {

    public ItemDB(String name, String description, int price, int stock, int id) {
        super(name, description, price, stock, id);
    }

    public static ArrayList<ItemDB> getItems(){
        DbQueary db = new DbQueary();
        try{
            return db.getAllItems();
        } catch(SQLException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}

package org.example.bo;

import org.example.db.DbQueary;

import java.sql.SQLException;
import java.util.Arrays;

class UserService {

    public static User login(String username, String password){
        DbQueary db = new DbQueary();
        try{
            if(username != null && password != null) {
                User u = db.login(username);
                if (u != null && username.equals(u.getUsername()) && u.checkPassword(password)) {
                    return u;
                }
            }

        } catch(SQLException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return null;
    }



}

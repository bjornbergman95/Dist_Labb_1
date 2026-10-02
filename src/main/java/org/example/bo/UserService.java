package org.example.bo;

import org.example.db.DbQueary;

import java.sql.SQLException;

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
            e.printStackTrace();
        }
        return null;
    }



}

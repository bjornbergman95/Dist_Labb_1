package org.example.bo;

import org.example.db.DbQueary;

import java.sql.SQLException;
import java.util.Arrays;

class UserService {
    private static final DbQueary db = new DbQueary();

    static boolean login(String username, String password){

        try{
            if(username != null && password != null){
                User u = db.login(username);
                if(u.getUsername() == null && u.getPassword() == null){
                    return false;
                }
                System.out.println("DETTA AR ANVÄNDARNAMNET" + u.getUsername());
                System.out.println("DETTA AR LOSENORDET" + u.getPassword());
                if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                    return true;
                }
            } else{
                return false;
            }
            return false;

        } catch(SQLException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return false;
    }
}

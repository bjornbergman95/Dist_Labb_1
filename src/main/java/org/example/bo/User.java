package org.example.bo;

import org.mindrot.jbcrypt.BCrypt;


public class User {
    private final String username;
    private final String password;
    private final String role;

    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername(){
        return this.username;
    }

    public boolean checkPassword(String password){
        return BCrypt.checkpw(password, this.password);
    }

    public String getRole(){
        return this.role;
    }
}

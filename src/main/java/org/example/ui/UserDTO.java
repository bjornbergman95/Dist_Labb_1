package org.example.ui;

import org.example.bo.User;

public class UserDTO {
    private final String username;
    private final String role;

    public UserDTO(String username, String role){
        this.username = username;
        this.role = role;
    }

    public String getUsername(){
        return this.username;
    }

    public String getRole(){
        return this.role;
    }

}

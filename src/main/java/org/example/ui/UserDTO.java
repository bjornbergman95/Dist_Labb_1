package org.example.ui;

// User representation that UI can see
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

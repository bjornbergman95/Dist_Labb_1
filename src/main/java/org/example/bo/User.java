package org.example.bo;

public class User {
    private final String username;
    private final String password;
    private final String role;
    private final Cart cart;

    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
        this.cart = new Cart();
    }

    public String getUsername(){
        return this.username;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public Cart getCart(){
        return this.cart;
    }

    public String getRole(){
        return this.role;
    }
}

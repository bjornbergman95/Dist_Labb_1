package org.example.bo;

public class User {
    private final String username;
    private final String password;
    private final String role;
    private final Basket basket;

    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
        this.basket = new Basket();
    }

    public String getUsername(){
        return this.username;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public Basket getBasket() {
        return this.basket;
    }

    public String getRole(){
        return this.role;
    }
}

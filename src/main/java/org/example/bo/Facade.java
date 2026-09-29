package org.example.bo;

public class Facade {

    private static UserService userService;

    public Facade(){
        userService = new UserService();
    }

    public static boolean logIn(String username, String password){
        return userService.login(username, password);
    }
}

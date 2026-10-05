package org.example.bo;

import org.example.db.DbQueary;

import java.sql.SQLException;

/**
 * Provides services related to user authentication.
 * UserService communicates with the database layer to retrieve
 * user information and verify login credentials.
 */
public class UserService {

    /**
     * Attempts to authenticate a user using the given username and password.
     * The method retrieves the user from the database using the username
     * and then verifies that the username and password match the stored
     * user information.
     * @param username the username entered by the user
     * @param password the password entered by the user
     * @return the authenticated User if the login is successful,
     * otherwise null
     */
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

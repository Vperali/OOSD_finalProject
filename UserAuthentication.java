package shop;

import java.util.ArrayList;
import java.util.List;

public class UserAuthentication {

    private List<Customer> users;

    public UserAuthentication() {
        this.users = new ArrayList<>();
    }

    /**
     * Registers a new user with the provided information.
     * 
     * @param username the username of the new user
     * @param password the password of the new user
     * @param name     the name of the new user
     * @param email    the email of the new user
     */
    public void registerUser(String username, String password, String name, String email) {
        if (isUsernameTaken(username)) {
            System.out.println("Username is already taken. Please choose a different one.");
            return;
        }

        Customer newUser = new Customer(username, password, name, email);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }

    /**
     * Logs in a user with the provided username and password.
     * 
     * @param username the username of the user to log in
     * @param password the password of the user to log in
     * @return the logged-in user if found, null otherwise
     */
    public Customer login(String username, String password) {
        for (Customer user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // User found, return the user object
            }
        }
        return null; // User not found
    }

    /**
     * Checks if a username is already taken.
     * 
     * @param username the username to check
     * @return true if the username is already taken, false otherwise
     */
    private boolean isUsernameTaken(String username) {
        for (Customer user : users) {
            if (user.getUsername().equals(username)) {
                return true; // Username is already in use
            }
        }
        return false; // Username is available
    }

    // Additional validation methods can be added here
}

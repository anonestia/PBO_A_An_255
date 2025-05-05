package com.praktikum.users;

public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract boolean login();
    public abstract void displayInfo();
    public abstract void displayAppMenu();
}

package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter admin username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String inputPassword = scanner.nextLine();
        return inputUsername.equals(getName()) && inputPassword.equals(getPassword());
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin login successful.");
    }

    @Override
    public void manageItems() {
        System.out.println(">> Manage Items feature is not available <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Manage Students feature is not available <<");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Manage Item Reports");
            System.out.println("2. Manage Student Data");
            System.out.println("0. Logout");
            System.out.print("Select option: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    manageItems();
                    break;
                case "2":
                    manageUsers();
                    break;
                case "0":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}

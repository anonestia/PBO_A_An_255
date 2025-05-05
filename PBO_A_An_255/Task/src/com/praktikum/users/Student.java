package com.praktikum.users;

import com.praktikum.actions.StudentActions;
import java.util.Scanner;

public class Student extends User implements StudentActions {
    public Student(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student username: ");
        String inputName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String inputID = scanner.nextLine();
        return inputName.equals(getName()) && inputID.equals(getPassword());
    }

    @Override
    public void displayInfo() {
        System.out.println("Student login successful.");
        System.out.println("Username: " + getName());
        System.out.println("ID: " + getPassword());
        System.out.println("Class: 2A Informatics");
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String desc = scanner.nextLine();
        System.out.print("Last Seen Location: ");
        String loc = scanner.nextLine();
        System.out.println("Item reported successfully.");
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> View Report Feature Not Available <<");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Menu:");
            System.out.println("1. Report Found/Lost Items");
            System.out.println("2. View Report List");
            System.out.println("0. Logout");
            System.out.print("Select option: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    reportItem();
                    break;
                case "2":
                    viewReportedItems();
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

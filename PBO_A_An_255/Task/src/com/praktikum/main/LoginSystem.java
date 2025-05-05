package com.praktikum.main;

import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Student;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user;

        System.out.println("Select Login Type:");
        System.out.println("1. Admin");
        System.out.println("2. Student");

        while (true) {
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                user = new Admin("Admin255", "Password255");
                break;
            } else if (choice.equals("2")) {
                user = new Student("Anindya Estiningtyas", "20241037011255");
                break;
            } else {
                System.out.println("Invalid input. Please select 1 or 2.");
            }
        }

        if (user.login()) {
            user.displayInfo();
            user.displayAppMenu();
        } else {
            System.out.println("Login failed.");
        }
    }
}

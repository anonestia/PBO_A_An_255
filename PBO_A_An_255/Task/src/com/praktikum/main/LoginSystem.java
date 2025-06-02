package com.praktikum.main;

import com.praktikum.users.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    private static ArrayList<User> userList = new ArrayList<>();

    static {
        // default users
        userList.add(new Admin("admin255", "password255"));
        userList.add(new Admin("admin0", "0000"));
        userList.add(new Student("Anindya Estiningtyas", "202410370110255"));
        userList.add(new Student("dummy",   "dummy0"));
    }

    public static User login(Scanner sc) {
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password/NIM: ");
        String p = sc.nextLine();

        for (User usr : userList) {
            if (usr instanceof Admin) { // instanceof checks if the left is part of the right; if yes, True
                if (usr.getUsername().equals(u) && usr.getPassword().equals(p))
                    return usr;
            } else if (usr instanceof Student) {
                if (usr.getUsername().equals(u) && ((Student)usr).getNim().equals(p))
                    return usr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- LOGIN ---");
            User me = login(sc);
            if (me == null) {
                System.out.println("Invalid username or password. Please try again.");
                continue;
            }

            if (me instanceof Admin) {
                System.out.println("Welcome, Admin " + me.getUsername());
                Admin adm = (Admin) me;
                while (true) {
                    System.out.println("\n1. Manage Items\n2. Manage Users\n0. Logout");
                    System.out.print("Choice: ");
                    int c;
                    try {
                        c = sc.nextInt(); sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Input must be a number!"); sc.nextLine();
                        continue;
                    }
                    if (c == 0) break;
                    if (c == 1) adm.manageItems(sc);
                    else if (c == 2) adm.manageUsers(sc, userList);
                    else System.out.println("Invalid option.");
                }

            } else {
                System.out.println("Welcome, " + me.getUsername());
                Student mhs = (Student) me;
                while (true) {
                    System.out.println("\n1. Report Item\n2. View Reports\n0. Logout");
                    System.out.print("Choice: ");
                    int c;
                    try {
                        c = sc.nextInt(); sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Input must be a number!"); sc.nextLine();
                        continue;
                    }
                    if (c == 0) break;
                    if (c == 1) mhs.reportItem(sc);
                    else if (c == 2) mhs.viewReportedItems();
                    else System.out.println("Invalid option.");
                }
            }
        }
    }
}

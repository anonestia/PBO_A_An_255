package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.models.Item;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User {
    public Admin(String u, String p) {
        super(u, p);
    }

    public void manageItems(Scanner sc) {
        ArrayList<Item> list = Student.getReportedItems();
        while (true) {
            System.out.println("\n1. View All Reports\n2. Mark Reported → Claimed\n0. Back");
            System.out.print("Choice: ");
            int opt;
            try {
                opt = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println("Input must be a number!");
                sc.nextLine();
                continue;
            }
            if (opt == 0) return; // leaves without going to switch
            switch (opt) {
                case 1:
                    if (list.isEmpty()) {
                        System.out.println("No reports.");
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            Item it = list.get(i);
                            System.out.printf("%d) %s | %s | %s | %s%n",
                                    i + 1, it.getItemName(), it.getDescription(), it.getLocation(), it.getStatus());
                        } // the i + 1 is to make the list starts from 1 instead of 0
                    }
                    break;
                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No reports to claim.");
                        break;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        Item it = list.get(i);
                        if ("Reported".equals(it.getStatus())) {
                            System.out.printf("%d) %s%n", i, it.getItemName());
                        }
                    }
                    System.out.print("Index to claim: ");
                    try {
                        int idx = sc.nextInt();
                        sc.nextLine();
                        Item target = list.get(idx - 1); // to make sure it is the right index, not the shown list, as the list was i + 1
                        if (!"Reported".equals(target.getStatus())) {
                            System.out.println("Already claimed.");
                        } else {
                            target.setStatus("Claimed");
                            System.out.println("Marked as claimed.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be a number!");
                        sc.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index!");
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void manageUsers(Scanner sc, ArrayList<User> userList) {
        while (true) {
            System.out.println("\n1. Add Student\n2. Delete Student\n0. Back");
            System.out.print("Choice: ");
            int opt;
            try {
                opt = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println("Input must be a number!");
                sc.nextLine();
                continue;
            }
            if (opt == 0) return;
            switch (opt) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("NIM: ");
                    String nim  = sc.nextLine();
                    userList.add(new Student(name, nim));
                    System.out.println("Student added.");
                    break;
                case 2:
                    System.out.print("NIM to delete: ");
                    String delNim = sc.nextLine();
                    boolean removed = userList.removeIf(u ->
                            (u instanceof Student) && ((Student)u).getNim().equals(delNim)
                    ); // this part is supposed to use iterator(), but removeIf is more concise
                    System.out.println(removed? "Deleted." : "Not found.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

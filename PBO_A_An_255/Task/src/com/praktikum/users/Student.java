package com.praktikum.users;

import com.praktikum.models.Item;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {
    private String nim;
    private static ArrayList<Item> reportedItems = new ArrayList<>();

    public Student(String name, String nim) {
        super(name, nim);
        this.nim = nim;
    }

    public String getNim() { return nim; }

    public void reportItem(Scanner sc) {
        System.out.print("Item name: ");
        String name = sc.nextLine();
        System.out.print("Description: ");
        String desc = sc.nextLine();
        System.out.print("Location: ");
        String loc  = sc.nextLine();

        Item it = new Item(name, desc, loc);
        reportedItems.add(it);
        System.out.println("Report submitted.");
    }

    public void viewReportedItems() {
        if (reportedItems.isEmpty()) {
            System.out.println("No item reports yet.");
            return;
        }
        for (Item it : reportedItems) {
            if ("Reported".equals(it.getStatus())) {
                System.out.printf("%s | %s | %s%n", // %n is platform-independent newline \n
                        it.getItemName(), it.getDescription(), it.getLocation());
            }
        }
    }

    public static ArrayList<Item> getReportedItems() {
        return reportedItems;
    }
}

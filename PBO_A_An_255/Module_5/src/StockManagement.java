import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StockManagement {
    public static void main(String[] args) {
        ArrayList<Item> itemList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Initial sample data
        itemList.add(new Item("Pencil", 20));
        itemList.add(new Item("Notebook"));
        itemList.add(new Item("Eraser", 10));

        while (true) {
            System.out.println("\n=== STOCK MANAGEMENT MENU ===");
            System.out.println("1. Add New Item");
            System.out.println("2. Display All Items");
            System.out.println("3. Reduce Item Stock");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number!");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter initial stock: ");
                    try {
                        int stock = scanner.nextInt();
                        itemList.add(new Item(name, stock));
                        System.out.println("Item added successfully.");
                    } catch (InputMismatchException e) {
                        System.out.println("Stock input must be a number!");
                        scanner.nextLine(); // Clear buffer
                    }
                    break;

                case 2:
                    if (itemList.isEmpty()) {
                        System.out.println("Item stock is empty.");
                    } else {
                        System.out.println("\n-- Item List --");
                        for (Item item : itemList) {
                            System.out.println("Name: " + item.getName() + ", Stock: " + item.getStock());
                        }
                    }
                    break;

                case 3:
                    if (itemList.isEmpty()) {
                        System.out.println("No items available to reduce.");
                        break;
                    }

                    System.out.println("\n-- Choose Item to Reduce Stock --");
                    for (int i = 0; i < itemList.size(); i++) {
                        System.out.println(i + ". " + itemList.get(i).getName() + " (Stock: " + itemList.get(i).getStock() + ")");
                    }

                    try {
                        System.out.print("Enter item index: ");
                        int index = scanner.nextInt();

                        System.out.print("Enter amount to reduce: ");
                        int amount = scanner.nextInt();

                        Item selectedItem = itemList.get(index);

                        if (amount > selectedItem.getStock()) {
                            throw new InsufficientStockException("Stock for " + selectedItem.getName() + " is only " + selectedItem.getStock() + " left.");
                        }

                        selectedItem.setStock(selectedItem.getStock() - amount);
                        System.out.println("Stock successfully reduced.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be a number!");
                        scanner.nextLine(); // clear buffer
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid item index!");
                    } catch (InsufficientStockException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

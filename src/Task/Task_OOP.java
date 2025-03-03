package Task;

import java.util.Scanner;

public class Task_OOP {
    public static void main(String[] args) {
        int loginAs;
        String username1, username2, password1, password2, loginInputUN, loginInputPW;
        username1 = "Admin255";
        username2 = "Anindya Estiningtyas";
        password1 = "password255";
        password2 = "20241037011255";

        Scanner objInput = new Scanner(System.in);
        System.out.println("Select Login Type:\n1.Admin\n2.Student");
        System.out.print("Enter your choice: ");
        loginAs = objInput.nextInt();
        objInput.nextLine();

        if (loginAs == 1){
            System.out.print("Enter admin username: ");
            loginInputUN = objInput.nextLine();

            System.out.print("Enter admin password: ");
            loginInputPW = objInput.nextLine();
            if ((!loginInputUN.equals(username1)) || (!loginInputPW.equals(password1))) {
                System.out.print("Login failed. Wrong username or password.");
            } else {
                System.out.print("Login successful!");
            }
        } else if (loginAs == 2) {
            System.out.print("Enter student name: ");
            loginInputUN = objInput.nextLine();

            System.out.print("Enter student NIM: ");
            loginInputPW = objInput.nextLine();
            if ((!loginInputUN.equals(username2)) || (!loginInputPW.equals(password2))) {
                System.out.print("Login failed. Wrong name or NIM.");
            } else {
                System.out.print("Login successful!");
            }
        } else {
            System.out.print("Invalid input.");
        }
    }
}

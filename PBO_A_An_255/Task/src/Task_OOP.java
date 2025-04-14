import java.util.Scanner;

class Admin {
    String username = "Admin255", password = "Password255", loginInputUN, loginInputPW;

    void login() {
        Scanner objInput = new Scanner(System.in);

        System.out.print("Enter admin username: ");
        loginInputUN = objInput.nextLine();

        System.out.print("Enter admin password: ");
        loginInputPW = objInput.nextLine();
        if ((!loginInputUN.equals(username)) || (!loginInputPW.equals(password))) {
            System.out.print("Login failed. Wrong username or password.");
        } else {
            System.out.print("Login successful!");
        }
    }
}

class Student {
    String username = "Anindya Estiningtyas", password = "20241037011255", loginInputUN, loginInputPW;

    void login() {
        Scanner objInput = new Scanner(System.in);

        System.out.print("Enter student name: ");
        loginInputUN = objInput.nextLine();

        System.out.print("Enter student NIM: ");
        loginInputPW = objInput.nextLine();
        if ((!loginInputUN.equals(username)) || (!loginInputPW.equals(password))) {
            System.out.print("Login failed. Wrong name or NIM.");
        } else {
            System.out.print("Login successful!");
        }

        displayInfo();
    }

    void displayInfo() {
        System.out.println("\n\nFull Name: Anindya Estiningtyas");
        System.out.println("NIM: 20241037011255");
        System.out.println("Class: 2A Informatics");
        System.out.println("An is a girl student that likes to wear black and white outfit. She is interested in AI and game developments.");
    }
}

public class Task_OOP {
    public static void main(String[] args) {
        String loginAs;

        Scanner objInput = new Scanner(System.in);
        System.out.println("Select Login Type:\n1.Admin\n2.Student");

        do {
            System.out.print("Enter your choice: ");
            loginAs = objInput.nextLine();

            if (loginAs.equals("1")) {
                Admin admin = new Admin();
                admin.login();
            } else if (loginAs.equals("2")) {
                Student student = new Student();
                student.login();
            } else {
                System.out.print("Invalid input.\n\n");
            }
        } while (!loginAs.equals("1") && !loginAs.equals("2"));
    }
}

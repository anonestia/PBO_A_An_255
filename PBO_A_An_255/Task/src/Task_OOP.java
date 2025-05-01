import java.util.Scanner;

// Superclass representing a generic user
class User {
    // Encapsulated attributes
    private String username;
    private String password;

    // Constructor to initialize username and student ID
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for username
    public String getName() {
        return username;
    }

    // Getter for student ID
    public String getPassword() {
        return password;
    }

    // Method to handle login, to be overridden by subclasses
    public boolean login() {
        return false;
    }

    // Method to display user information, to be overridden by subclasses
    public void displayInfo() {
    }
}

// Admin subclass extends User and uses unique admin login
class Admin extends User {

    // Constructor using super() to set username and student ID
    public Admin(String username, String password) {
        super(username, password);
    }

    // Overrides login() to validate admin username and password
    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter admin username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter admin password: ");
        String inputPassword = scanner.nextLine();

        // Check if input matches the hardcoded admin credentials
        if (inputUsername.equals(getName()) && inputPassword.equals(getPassword())) {
            return true;
        } else {
            System.out.println("Login failed. Wrong username or password.");
            return false;
        }
    }

    // Overrides displayInfo() to show admin login success and info
    @Override
    public void displayInfo() {
        System.out.println("Admin login successful.");
    }
}

// Student subclass extends User and uses student name + student ID for login
class Student extends User {

    // Constructor that initializes username and student ID via super()
    public Student(String username, String password) {
        super(username, password);
    }

    // Overrides login() to match user input with student username and ID
    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student username: ");
        String inputName = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String inputID = scanner.nextLine();

        // Validate input with object's stored username and ID
        if (inputName.equals(getName()) && inputID.equals(getPassword())) {
            return true;
        } else {
            System.out.println("Login failed. Wrong username or student ID.");
            return false;
        }
    }

    // Overrides displayInfo() to show student profile information
    @Override
    public void displayInfo() {
        System.out.println("Student login successful.");
        System.out.println("username: " + getName());
        System.out.println("ID: " + getPassword());
        System.out.println("Class: 2A Informatics");
        System.out.println("An is a girl student that likes to wear black and white outfit. She is interested in AI and game developments.");
    }
}

// Main class for the login system
public class Task_OOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user;

        // Show user login options
        System.out.println("Select Login Type:");
        System.out.println("1. Admin");
        System.out.println("2. Student");

        // Loop until valid choice is made
        while (true) {
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            // Create Admin object with default credentials
            if (choice.equals("1")) {
                user = new Admin("Admin255", "Password255"); // Last NIM
                break;
            }
            // Create Student object with specific username and ID
            else if (choice.equals("2")) {
                user = new Student("Anindya Estiningtyas", "20241037011255"); // Student fullname and NIM
                break;
            } else {
                System.out.println("Invalid input. Please select 1 or 2.");
            }
        }

        // Call login method — if success, show info
        if (user.login()) {
            user.displayInfo();
        }
    }
}

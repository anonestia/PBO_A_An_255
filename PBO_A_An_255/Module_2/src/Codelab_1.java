// Define the Animal class
class Animal {
    // Attributes of the Animal class
    String name;
    String type;
    String sound;

    // Constructor to initialize the Animal object
    public Animal(String name, String type, String sound) {
        this.name = name;
        this.type = type;
        this.sound = sound;
    }

    // Method to display the animal's information
    public void displayInfo() {
        System.out.println("Animal Name: " + name);
        System.out.println("Animal Type: " + type);
        System.out.println("Animal Sound: " + sound);
        System.out.println("-----------------------");
    }
}

// Main class (must match the filename "Codelab_1")
public class Codelab_1 {
    public static void main(String[] args) {
        // Creating two Animal objects with specified attributes
        Animal animal1 = new Animal("Cat", "Mammal", "Nyann~~");
        Animal animal2 = new Animal("Dog", "Mammal", "Woof-Woof!!");

        // Calling the displayInfo method for both animals
        animal1.displayInfo();
        animal2.displayInfo();
    }
}

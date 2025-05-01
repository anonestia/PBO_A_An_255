// Define the Animal class
class Animal {
    // Attributes of the Animal class
    String name;
    String type;
    String sound;

    // Method to display the animal's information
    public void displayInfo() {
        System.out.println("Animal Name: " + name);
        System.out.println("Animal Type: " + type);
        System.out.println("Animal Sound: " + sound);
        System.out.println("-----------------------");
    }
}

// Main class
public class Codelab_1 {
    public static void main(String[] args) {
        // Creating two Animal objects
        Animal animal1 = new Animal();
        animal1.name = "Cat";
        animal1.type = "Mammal";
        animal1.sound = "Nyann~~";
        Animal animal2 = new Animal();
        animal2.name = "Dog";
        animal2.type = "Mammal";
        animal2.sound = "Woof-Woof!!";

        // Calling the displayInfo method for both animals
        animal1.displayInfo();
        animal2.displayInfo();
    }
}

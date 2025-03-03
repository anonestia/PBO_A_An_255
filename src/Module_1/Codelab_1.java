import java.util.Scanner;

public class Codelab_1 {
    public static void main(String[] args) {
        String name, gender, Gender; // Deklarasi untuk string
        int year; // Deklarasi untuk integer
        
        // Fungsi input
        Scanner objInput = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = objInput.nextLine(); // untuk string
        System.out.print("Enter gender (M/F): ");
        gender = objInput.nextLine(); // untuk string
        System.out.print("Enter year of birth: ");
        year = objInput.nextInt(); // untuk integer

        // print hasil input
        System.out.println("\nPersonal data:");
        System.out.println("Name\t: " + name);

        // penentu value agar F dan M berubah menjadi kata utuh
        if (gender.equalsIgnoreCase("F")) {
            Gender = "Female";
        } else if (gender.equalsIgnoreCase("M")) {
            Gender = "Male";
        } else {
            Gender = "Unknown"; // apabila input tidak keduanya
        }

        System.out.println("Gender\t: " + Gender); // menampilkan hasil kondisi melainkan karakter input
        System.out.println("Age\t: " + (2025 - year)); // mendapatkan usia dengan mengurangi tahun sekarang dengan tahun kelahirian
    }
}

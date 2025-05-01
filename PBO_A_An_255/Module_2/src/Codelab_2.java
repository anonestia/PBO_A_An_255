// Define the BankAccount class
class BankAccount {
    // Attributes of the BankAccount class
    String accountNumber;
    String ownerName;
    double balance;

    // Constructor to initialize the BankAccount object
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        // Ensure the balance is positive
        if (balance < 0) {
            System.out.println("Saldo tidak boleh negatif. Mengatur saldo ke 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // Method to display account information
    public void displayInfo() {
        System.out.println("Nomor Rekening: " + accountNumber);
        System.out.println("Nama Pemilik: " + ownerName);
        System.out.println("Saldo: Rp" + balance);
        System.out.println("--------------------------");
    }

    // Method to deposit money
    public void depositMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(ownerName + " menyetor Rp" + amount);
            System.out.println("Saldo Baru: Rp" + balance);
        } else {
            System.out.println("Jumlah setoran harus positif.");
        }
        System.out.println("--------------------------");
    }

    // Method to withdraw money
    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(ownerName + " menarik Rp" + amount);
            System.out.println("Sisa Saldo: Rp" + balance);
        } else if (amount > balance) {
            System.out.println("Saldo tidak mencukupi untuk penarikan.");
        } else {
            System.out.println("Jumlah penarikan harus positif.");
        }
        System.out.println("--------------------------");
    }
}

// Main class
public class Codelab_2 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("202410370110255", "Anindya Estiningtyas", 200000.0);
        BankAccount account2 = new BankAccount("202410370110039", "Firdaus Firmansyah Emha", 700000.0);

        account1.displayInfo();
        account2.displayInfo();

        account1.depositMoney(100000.0);  // Menyetor uang ke account1
        account1.withdrawMoney(200000.0); // Menarik uang dari account1

        account2.depositMoney(150000.0);  // Menyetor uang ke account2
        account2.withdrawMoney(400000.0); // Mencoba menarik lebih dari saldo

        account1.displayInfo();
        account2.displayInfo();
    }
}

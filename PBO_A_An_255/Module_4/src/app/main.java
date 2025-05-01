package app;

import library.*;

public class main {
    public static void main(String[] args) {
        book b1 = new fiction("Neuromancer", "William Gibson");
        book b2 = new nonfiction("HOW LEADER ACT", "Asw N Giandra");

        b1.displayInfo();
        b2.displayInfo();

        member m1 = new member("Anindya Estiningtyas", "0255");
        m1.borrowBook("Neuromancer");
        m1.borrowBook("HOW LEADER ACT", 14);
        m1.borrowBook();
        m1.returnBook();
    }
}

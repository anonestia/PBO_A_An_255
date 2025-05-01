package library;

public class member implements bookLoan {
    private String name;
    private String memberID;

    public member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
    }

    // Overloaded methods
    public void borrowBook(String title) {
        System.out.println(name + " borrowed \"" + title + "\".");
    }

    public void borrowBook(String title, int duration) {
        System.out.println(name + " borrowed \"" + title + "\" for " + duration + " days.");
    }

    @Override
    public void borrowBook() {
        System.out.println(name + " is borrowing a book.");
    }

    @Override
    public void returnBook() {
        System.out.println(name + " has returned a book.");
    }
}

package library;

public class nonfiction extends book {
    public nonfiction(String title, String author) {
        super(title, author);
    }

    @Override
    public void displayInfo() {
        System.out.println("[Non-Fiction] Title: " + title + ", Author: " + author);
    }
}

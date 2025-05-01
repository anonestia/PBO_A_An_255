package library;

public class fiction extends book {
    public fiction(String title, String author) {
        super(title, author);
    }

    @Override
    public void displayInfo() {
        System.out.println("[Fiction] Title: " + title + ", Author: " + author);
    }
}

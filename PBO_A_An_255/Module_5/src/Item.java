public class Item {
    private String name;
    private int stock;

    public Item(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public Item(String name) {
        this.name = name;
        this.stock = 0;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

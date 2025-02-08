import java.util.ArrayList;

public class Tray {
    private ArrayList<Product> stock;
    private double price;
    private int capacity;

    public Tray(double price, int capacity) {
        this.price = price;
        this.capacity = capacity;
        this.stock = new ArrayList<>();
    }

    public double getPrice() {
        return price;
    }

    public int getStockLevel() {
        return stock.size();
    }

    public void addItem(Product product) {
        if(getStockLevel() < capacity){
            stock.add(product);
        }
    }

    public Product ejectProduct() {
        return this.stock.remove(0);
    }
}

import java.util.ArrayList;

public class Customer {
    private double cash;
    private String name;
    private ArrayList<Product> inventory;

    public Customer(String name, double cash) {
        this.name = name;
        this.cash = cash;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public int getInventorySize() {
        return inventory.size();
    }
}

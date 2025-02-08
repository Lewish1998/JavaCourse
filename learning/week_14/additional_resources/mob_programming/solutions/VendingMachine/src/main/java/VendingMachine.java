import java.util.HashMap;

public class VendingMachine {
    private double credit;
    HashMap<Selection, Tray> products;
    double cash;

    public VendingMachine(HashMap<Selection, Tray> products, double cash) {
        this.products = products;
        this.cash = cash;
        this.credit = 0.00;
    }

    public double getCredit() {
        return credit;
    }

    public double getCash() {
        return this.cash;
    }

    public void addMoney(double amountEntered) {
        credit += amountEntered;
    }

    public double giveRefund() {
        // figure out how much credit there is in the machine
        double refundAmount = credit;

        // Reset the credit variable
        credit = 0;

        // return that amount back out of the function
        return refundAmount;
    }

    public int getStockLevelForTray(Selection selection) {
        return products.get(selection).getStockLevel();
    }

    public Product vend(Selection selection) {
        Tray tray = products.get(selection);
        Product product = null;

        // check credit >= price row
        if(credit >= tray.getPrice()){
            // check tray has product in stock
            if(tray.getStockLevel() > 0){
                // get product from tray
                product = tray.ejectProduct();

                // cash goes up
                cash += tray.getPrice();

                // credit goes down
                credit -= tray.getPrice();
            }
        }

        return product;
    }
}


















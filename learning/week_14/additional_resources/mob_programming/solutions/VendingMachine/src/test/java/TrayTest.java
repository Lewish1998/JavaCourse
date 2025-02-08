import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrayTest {
    private Tray tray;

    @Before
    public void setUp() throws Exception {
        tray = new Tray(0.50, 10);
    }

    // Check trays have a price
    @Test
    public void testTrayPrice() {
        assertEquals(0.50, tray.getPrice(), 0.01);
    }

    // Check that trays can report the number of items they contain

    @Test
    public void testStockLevelInitiallyZero() {
        assertEquals(0, tray.getStockLevel());
    }

    // Check that we can add an item to a tray

    @Test
    public void testCanAddItem() {
        Drink drink = new Drink("Ice Tea", 500);
        tray.addItem(drink);
        assertEquals(1, tray.getStockLevel());
    }


    // Check we can remove an item from a tray
    @Test
    public void testTrayEjectsItem() {
        Drink drink1 = new Drink("Ice Tea", 500);
        Drink drink2 = new Drink("Ice Tea", 500);

        tray.addItem(drink1);
        tray.addItem(drink2);

        Product ejectedProduct = tray.ejectProduct();

        assertEquals(drink1, ejectedProduct);
    }

    // check that we can't add items beyond a tray's capacity
    @Test
    public void testTrayCapacityCannotBeBreached() {
        for(int i = 0; i < 11; i++){
            Drink drink = new Drink("Irn-bru", 330);
            tray.addItem(drink);
        }
        assertEquals(10, tray.getStockLevel());
    }
}

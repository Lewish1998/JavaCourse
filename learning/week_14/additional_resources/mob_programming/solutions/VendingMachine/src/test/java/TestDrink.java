import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDrink {
    private Drink drink;

    @Before
    public void setUp() throws Exception {
        drink = new Drink("Pepsi", 330);
    }

    @Test
    public void testCanGetName() {
        assertEquals("Pepsi", drink.getName());
    }
}

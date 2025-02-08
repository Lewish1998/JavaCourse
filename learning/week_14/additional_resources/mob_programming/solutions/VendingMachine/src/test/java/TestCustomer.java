import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCustomer {
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("John", 10.00);
    }

    @Test
    public void testName() {
        assertEquals("John", customer.getName());
    }

    @Test
    public void testCustomerCash() {
        assertEquals(10.00, customer.getCash(), 0.01);
    }

    @Test
    public void testCustomerInventoryIsInitiallyEmpty() {
        assertEquals(0, customer.getInventorySize());
    }
}

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSweet {
    private Sweet sweet;

    @Before
    public void setUp() throws Exception {
        sweet = new Sweet("Refreshers", 50);
    }

    @Test
    public void testCanGetName() {
        assertEquals("Refreshers", sweet.getName());
    }
}

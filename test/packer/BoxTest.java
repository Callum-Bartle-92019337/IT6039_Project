package packer;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Callum Bartle CPP 92019337
 */
public class BoxTest {

    // Test data
    //
    //
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }

    @Test
    public void testOne() {
        assertEquals(true, true);
        assertEquals(false, false);
    }

    @Test
    public void testTwo() {

        assertEquals(true, false);
    }

    @Test
    public void testThree() {

        assertEquals(1, 1);
    }

    @Test
    public void testFour() {

        assertEquals(1, 0);
    }

}

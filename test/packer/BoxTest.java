package packer;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Callum Bartle CPP 92019337.
 */
public class BoxTest {

    // Test Data ============================================
    //
    // Product(String name, int weight, boolean hazardous, boolean fragile)
    Product p0 = new Product("Product0", 0, false, true);
    Product p1 = new Product("Product1", 2, true, false);
    Product p2 = new Product("Product2", 3, false, true);
    Product p3 = new Product("Product3", 20, false, false);

    Product pA = new Product("ProductA", 5, true, false);
    Product pB = new Product("ProductB", 10, false, true);
    Product pC = new Product("ProductC", 15, false, true);
    Product pD = new Product("ProductD", 40, true, false);

    Coordinates coord0 = new Coordinates(0, 0);
    Coordinates coord1 = new Coordinates(55, 55);
    Address address0 = new Address("0 Address", "Really", "Inn Town", "D444", coord0);
    Address address1 = new Address("1 Address", "Hello", "World", "35", coord1);

    Customer cust0 = new Customer("Test Customer", address0);
    Depot depo0 = new Depot("Test Depot", address1);

    Box box0 = new Box(cust0, depo0);
    Box box1 = new Box(cust0, depo0);
    //
    // Test Data end =========================================

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }

    /**
     * Test of addProduct method, of class Box.
     */
    @Test
    public void testAddProduct() {
        System.out.println("add Product");

        assertEquals(true, box0.isEmpty());

        box0.addProduct(p0);
        box0.addProduct(p1, 10);

        assertEquals(false, box0.isEmpty());
    }

    /**
     * Test of getLabel method, of class Box.
     */
    @Test
    public void testGetLabel() {
        System.out.println("get Label");

        String expectedLable
                = cust0 + "\n"
                + cust0.getClosestAddressTo(depo0);

        assertEquals(expectedLable + "\n\n", box0.getLabel());

        box0.addProduct(pB);
        String expectedLable1
                = expectedLable + "\n"
                + pB.getName() + " x 1\n"
                + "FRAGILE";

        assertEquals(expectedLable1 + "\n", box0.getLabel());

        box0.addProduct(pB);
        String expectedLable2
                = expectedLable + "\n"
                + pB.getName() + " x 2\n"
                + "FRAGILE\n"
                + "HEAVY";
        assertEquals(expectedLable2 + "\n", box0.getLabel());
    }

    /**
     * Test of getWeight method, of class Box.
     */
    @Test
    public void testGetWeight() {
        System.out.println("Get Weight");

        assertEquals(0, box1.getWeight(), 0);

        box1.addProduct(p0);
        box1.addProduct(p1, 10);

        assertEquals(20, box1.getWeight(), 0);
    }

    /**
     * Test of canFit method, of class Box.
     */
    @Test
    public void testCanFit_Product() {
        System.out.println("can Fit");

        assertEquals(false, box0.canFit(pD));
        assertEquals(true, box0.canFit(p0));

        box0.addProduct(p0);
        box0.addProduct(p1, 9);
        assertEquals(true, box0.canFit(p1));

        box0.addProduct(p1);
        assertEquals(false, box0.canFit(p1));

    }

    /**
     * Test of remainingCapacity method, of class Box.
     */
    @Test
    public void testRemainingCapacity() {
        System.out.println("remaining Capacity");

        assertEquals(20, box0.remainingCapacity(), 0.0);

        box0.addProduct(p0);
        box0.addProduct(p1, 10);

        assertEquals(0, box0.remainingCapacity(), 0.0);
    }

    /**
     * Test of isFragile method, of class Box.
     */
    @Test
    public void testIsFragile() {

        assertEquals(false, box0.isFragile());

        box0.addProduct(p0);
        box0.addProduct(p1, 10);

        assertEquals(true, box0.isFragile());
    }

    /**
     * Test of isHazardous method, of class Box.
     */
    @Test
    public void testIsHazardous() {

        assertEquals(false, box0.isHazardous());

        box0.addProduct(p0);
        box0.addProduct(p1, 10);

        assertEquals(true, box0.isHazardous());
    }

    /**
     * Test of isHeavy method, of class Box.
     */
    @Test
    public void testIsHeavy() {

        assertEquals(false, box0.isHeavy());

        box0.addProduct(p0);
        box0.addProduct(p1, 10);

        assertEquals(true, box0.isHeavy());
    }

}

package packer;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Callum Bartle CPP 92019337
 */
public class ManifestTest {

    // Test Data ============================================
    //
    // Product(String name, int weight, boolean hazardous, boolean fragile)
    Product p0 = new Product("Product0", 0, false, true);
    Product p1 = new Product("Product1", 2, true, false);
    Product p2 = new Product("Product2", 3, false, true);
    Product p3 = new Product("Product3", 20, false, false);

    Product pA = new Product("ProductA", 5, true, false);
    Product pB = new Product("ProductB", 10, true, true);
    Product pC = new Product("ProductC", 15, false, true);
    Product pD = new Product("ProductD", 40, true, false);

    Manifest m0 = new Manifest();
    Manifest m1 = new Manifest();
    //
    // Test Data end =========================================

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }

    /**
     * Test of isEmptyTest method, of class Manifest.
     */
    @Test
    public void isEmptyTest() {
        System.out.println("Is empty");

        assertEquals(true, m0.isEmpty());

        m0.addProduct(p0);
        m0.addProduct(p1, 10);

        assertEquals(false, m0.isEmpty());
    }

    /**
     * Test of addProductTest method, of class Manifest.
     */
    @Test
    public void addProductTest() {
        System.out.println("add Product");

        assertEquals(true, m0.isEmpty());

        m0.addProduct(p0);
        m0.addProduct(p1, 10);

        assertEquals(false, m0.isEmpty());
    }

    /**
     * Test of removeProductTest method, of class Manifest.
     */
    @Test
    public void removeProductTest() {
        System.out.println("remove Product");

        m0.addProduct(p0);
        assertEquals(false, m0.isEmpty());

        m0.removeProduct(p0);
        assertEquals(true, m0.isEmpty());
    }

    /**
     * Test of getTotalWeightTest method, of class Manifest.
     */
    @Test
    public void getTotalWeightTest() {
        System.out.println("Get Total Weight");

        assertEquals(0, m0.getTotalWeight(), 0);

        m0.addProduct(p0);
        m0.addProduct(p1, 10);

        assertEquals(20, m0.getTotalWeight(), 0);
    }

    /**
     * Test of getHeaviestUnderTest method, of class Manifest.
     */
    @Test
    public void getHeaviestUnderTest() {
        System.out.println("Get heaviest Under");

        m0.addProduct(p0);
        m0.addProduct(p1, 10);

        assertEquals(null, m0.getHeaviestUnder(-1));
        assertEquals(p0, m0.getHeaviestUnder(1));
        assertEquals(p1, m0.getHeaviestUnder(5));
    }

    /**
     * Test of containsProductTest method, of class Manifest.
     */
    @Test
    public void containsProductTest() {
        System.out.println("Contains product");

        assertEquals(false, m0.containsProduct(p0));

        m0.addProduct(p0);
        m0.addProduct(p1, 10);

        assertEquals(true, m0.containsProduct(p0));
    }

    /**
     * Test of hasFragileItemsTest method, of class Manifest.
     */
    @Test
    public void hasFragileItemsTest() {
        System.out.println("has Fragile Items");

        assertEquals(false, m0.hasFragileItems());

        m0.addProduct(p1, 10);
        assertEquals(false, m0.hasFragileItems());

        m0.addProduct(p0);
        assertEquals(true, m0.hasFragileItems());
    }

    /**
     * Test of hasHazardousItemsTest method, of class Manifest.
     */
    @Test
    public void hasHazardousItemsTest() {
        System.out.println("has Hazardous Items");

        assertEquals(false, m0.hasHazardousItems());

        m0.addProduct(p0);
        assertEquals(false, m0.hasHazardousItems());

        m0.addProduct(p1);
        assertEquals(true, m0.hasHazardousItems());
    }

}

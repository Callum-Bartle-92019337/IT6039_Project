/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Callum Bartle CPP 92019337
 */
public class PackerTest {

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

    Coordinates coord0 = new Coordinates(0, 0);
    Coordinates coord1 = new Coordinates(55, 55);
    Address address0 = new Address("0 Address", "Really", "Inn Town", "D444", coord0);
    Address address1 = new Address("1 Address", "Hello", "World", "35", coord1);

    Customer cust0 = new Customer("Test Customer", address0);
    Depot depo0 = new Depot("Test Depot", address1);

    Manifest m0 = new Manifest();
    Manifest m1 = new Manifest();

    //
    // Test Data end =========================================
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Packer class...");
    }

    /**
     * Test of packProducts method, of class Packer.
     */
    @Test
    public void testPackProducts() {
        System.out.println("pack Products");

        m0.addProduct(p0, 1);
        m0.addProduct(p1, 12);
        m0.addProduct(p2, 2);
        m0.addProduct(p3, 1);
        m0.addProduct(pA, 20);
        m0.addProduct(pB, 1);
        List<Box> packedBoxes = Packer.packProducts(cust0, depo0, m0);

        assertEquals(8, packedBoxes.size());

        m1.addProduct(p0, 3);
        m1.addProduct(p1, 127);
        m1.addProduct(p2, 2);
        m1.addProduct(p3, 17);
        m1.addProduct(pA, 3);
        m1.addProduct(pB, 4);
        packedBoxes = Packer.packProducts(cust0, depo0, m1);

        assertEquals(33, packedBoxes.size());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bunta
 */
public class CustomerTest {

    // Test data
    Coordinates testCoordinates0 = new Coordinates(0, 0);
    Coordinates testCoordinates1 = new Coordinates(3, 4);
    Coordinates testCoordinates2 = new Coordinates(30, 40);
    Coordinates testCoordinates3 = new Coordinates(300, 400);
    Coordinates testCoordinates4 = new Coordinates(3000, 4000);

    Address testAddress0 = new Address("0 Address", "Really", "Inn Town", "D444", testCoordinates0);
    Address testAddress1 = new Address("1 Address", "Aplace", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("2 Address", "Brooklyn", "Welling Town", "B222", testCoordinates2);
    Address testAddress3 = new Address("3 Address", "Christly", "Holly Oaks", "C333", testCoordinates3);
    Address testAddress4 = new Address("4 Address", "Somewhere", "Elsewhere", "E555", testCoordinates4);

    Depot testDepot0 = new Depot("Test Depot", testAddress0);
    Depot testDepot4 = new Depot("Test Depot", testAddress4);

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Customer class...");
    }

    /**
     * Test of the first getClosestAddressTo method, of class Customer.
     */
    @Test
    public void testOneGetClosestAddressTo() {
        System.out.println("First getClosestAddressTo");
        Customer testCustomer;

        testCustomer = new Customer("Test Customer", testAddress3);
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress2);
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress1);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress0);
        assertEquals(testAddress0, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
    }

    /**
     * Test of the second getClosestAddressTo method, of class Customer.
     */
    @Test
    public void testTwoGetClosestAddressTo() {
        System.out.println("Second getClosestAddressTo");
        Customer testCustomer;

        testCustomer = new Customer("Test Customer", testAddress1);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress2);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress3);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress4);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress4, testCustomer.getClosestAddressTo(testDepot4));
    }

    /**
     * Test of the third getClosestAddressTo method, of class Customer.
     */
    @Test
    public void testThreeGetClosestAddressTo() {
        System.out.println("Third getClosestAddressTo");
        Customer testCustomer;

        testCustomer = new Customer("Test Customer", testAddress2);
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress3);
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
        testCustomer.addAddress(testAddress1);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot0));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot4));
    }

}

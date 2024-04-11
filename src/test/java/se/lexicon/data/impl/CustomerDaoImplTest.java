package se.lexicon.data.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerDaoImplTest {

    private CustomerDaoImpl testObject;

    @BeforeEach
    public void setUp() {
        testObject = new CustomerDaoImpl();
    }

    @Test
    public void testCreateCustomer() {

        Customer customer1 = new Customer("Elnaz", "123456");
        Customer actualCustomer = testObject.create(customer1); // 1001

        Customer expectedCustomer = new Customer(1001, "Elnaz", "123456");


        assertEquals(expectedCustomer.getId(), actualCustomer.getId());
        assertEquals(expectedCustomer.getName(), actualCustomer.getName());

    }

    @Test
    public void testFindById() {

        Customer customer1 = new Customer("Elnaz", "123456");
        Customer createdCustomer = testObject.create(customer1);
        Optional<Customer> foundCustomer = testObject.find(1001);

        assertTrue(foundCustomer.isPresent());

    }

    @Test
    public void testNonExistentCustomer() {
        Optional<Customer> foundCustomer = testObject.find(989);
        assertFalse(foundCustomer.isPresent());

    }

    @Test
    public void testRemoveCustomer() {
        Customer customer1 = new Customer("Elnaz", "123456");
        testObject.create(customer1);
        boolean removed = testObject.remove(customer1.getId());
        assertTrue(removed);
        assertFalse(testObject.find(customer1.getId()).isPresent());

    }

    @Test
    public void testRemoveNonExistentCustomer() {
        boolean removed = testObject.remove(900);
        assertFalse(removed);

    }

    @Test
    public void testFindAllCustomers() {
        Customer customer1= new Customer("Elnaz", "123456");
        Customer customer2= new Customer("Nickan", "246810");
        Customer customer3= new Customer("Marry", "357911");
        testObject.create(customer1);
        testObject.create(customer2);
        testObject.create(customer3);
        List<Customer> customers= testObject.findAll();
        assertEquals(3, customers.size());
        assertTrue(customers.contains(customer1));
        assertTrue(customers.contains(customer2));
        assertTrue(customers.contains(customer3));

    }

    @Test
    public void testFindAllCustomersEmptyList() {
        List<Customer> customers = testObject.findAll();
        assertTrue(customers.isEmpty());

    }

}

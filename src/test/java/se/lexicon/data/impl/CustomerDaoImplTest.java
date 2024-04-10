package se.lexicon.data.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;

import java.util.Optional;

public class CustomerDaoImplTest {

    private CustomerDaoImpl testObject;

    @BeforeEach
    public void setUp() {
        testObject = new CustomerDaoImpl();
    }

    @Test
    public void testCreateCustomer() {

        Customer customer1 = new Customer("Elnaz","123456");
        Customer actualCustomer = testObject.create(customer1); // 1001

        Customer expectedCustomer = new Customer(1001, "Elnaz","123456");


        Assertions.assertEquals(expectedCustomer.getId(), actualCustomer.getId());
        Assertions.assertEquals(expectedCustomer.getName(), actualCustomer.getName());

    }




    @Test
    public void testFindById() {

        Customer customer1 = new Customer("Elnaz","123456");
        Customer createdCustomer = testObject.create(customer1);
        Optional<Customer> foundCustomer = testObject.find(1001);

        Assertions.assertTrue(foundCustomer.isPresent());

    }

    @Test
    public void testNonExistentCustomer() {
        //todo: Implement JUnit test

    }

    @Test
    public void testRemoveCustomer() {
        //todo: Implement JUnit test

    }

    @Test
    public void testRemoveNonExistentCustomer() {
        //todo: Implement JUnit test

    }

    @Test
    public void testFindAllCustomers() {
        //todo: Implement JUnit test

    }

    @Test
    public void testFindAllCustomersEmptyList() {
        //todo: Implement JUnit test

    }

}

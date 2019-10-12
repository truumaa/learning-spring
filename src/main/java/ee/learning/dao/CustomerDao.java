package ee.learning.dao;

import ee.learning.model.Customer;

import java.util.List;

public interface CustomerDao {
    void insert(Customer customer);

    List<Customer> findAll();
}

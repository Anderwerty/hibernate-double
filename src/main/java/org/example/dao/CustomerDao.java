package org.example.dao;

import org.example.entity.Customer;

import java.util.List;
import java.util.Optional;

//CRUD
public interface CustomerDao {

    List<Customer> findAll();

    Optional<Customer> findById(Integer id);

    void save(Customer customer);


    void delete(Customer customer);
}

package com.greatlearning.cmsapp.service;

import com.greatlearning.cmsapp.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();

    public Customer findById(int id);

    public void save(Customer theCustomer); // save or update

    public void deleteById(int id);
}

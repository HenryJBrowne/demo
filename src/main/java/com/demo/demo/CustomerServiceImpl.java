package com.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * This service class generates of Customer records in the database
 * 
 * @Author: Henry Browne
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository CustomerRepository;

    /*
     * This method generates a new customer record using the @CustomerRepository
     */
    @Override
    public Customer saveCustomer(Customer Customer) {

        return CustomerRepository.save(Customer);
    }

}

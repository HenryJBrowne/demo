package com.demo.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * CustomerRepository class interface 
 * 
 * @Author: Henry Browne
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}

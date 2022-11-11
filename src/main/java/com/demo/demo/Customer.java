package com.demo.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

/*
 * This model class generates the Customer database and allows for the creation of new customer objects / records
 * 
 * @Author: Henry Browne
 */
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "registered", nullable = true)
    private Date registered;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    private String email;

    @Column(name = "title", nullable = false, length = 5)
    private String title;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "addressline1", nullable = false, length = 255)
    private String addressline1;

    @Column(name = "addessline2", nullable = true, length = 255)
    private String addressline2;

    @Column(name = "city", nullable = true, length = 255)
    private String city;

    @Column(name = "postcode", nullable = false, length = 10)
    private String postcode;

    @Column(name = "phonenumber", nullable = true, length = 20)
    private String phoneNumber;

    /**
     * This constuctor allows for the creation of new customers / records in the Customer database
     * @param email customer associated email
     * @param title customer associated email - title Mr, Ms
     * @param firstname customer associated first name
     * @param lastname customer associated last name
     * @param addressline1 customer associated address line 1 
     * @param addressline2 customer associated address line 2 
     * @param city customer associated city
     * @param postcode customer associated postcode
     * @param phoneNumber customer associated phone number 
     */
    public Customer(String email, String title, String firstname, String lastname, String addressline1, String addressline2, String city, String postcode, String phoneNumber) {

        super();

        this.registered = new Date();
        this.email = email;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;

    }

    // add getters and setters here...

}

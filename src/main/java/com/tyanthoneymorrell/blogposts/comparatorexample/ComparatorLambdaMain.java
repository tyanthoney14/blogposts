/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.comparatorexample;

import java.util.*;

/**
 *
 * @author tyanthoneym
 */
public class ComparatorLambdaMain {
    
    public static void main(String[] args) {
        
        List<Customer> customers = new ArrayList<>();
        
        customers.add(new Customer(4, "Steve", "Pink"));
        customers.add(new Customer(3, "Tim", "Orange"));
        customers.add(new Customer(1, "Edward", "Blue"));
        customers.add(new Customer(9, "Harvey", "White"));
        customers.add(new Customer(2, "Quentin", "Brown"));
        customers.add(new Customer(12, "Michael", "Blonde"));
        
        System.out.println("Before sorting");
        
        for (Customer customer : customers) {
            
            System.out.println(customer.toString());
            
        }
        
        
        // sort by cutomer id
        Collections.sort(customers, (Customer a, Customer b) -> {
            
            return a.getCustomerID().compareTo(b.getCustomerID());
            
        });
        
        System.out.println("\nSorted by CustomerID");
        
        for (Customer customer : customers) {
            
            System.out.println(customer.toString());
            
        }
        
        // sort by last name
        Collections.sort(customers, (Customer a, Customer b) -> {
            
            return a.getlName().compareTo(b.getlName());
            
        });
        
        System.out.println("\nSorted by last name");
        
        for (Customer customer : customers) {
            
            System.out.println(customer.toString());
            
        }
        
        // sort by first name
        Collections.sort(customers, (Customer a, Customer b) -> {
            
            return a.getfName().compareTo(b.getfName());
            
        });
        
        System.out.println("\nSorted by first name");
        
        for (Customer customer : customers) {
            
            System.out.println(customer.toString());
            
        }
        
    }
    
}

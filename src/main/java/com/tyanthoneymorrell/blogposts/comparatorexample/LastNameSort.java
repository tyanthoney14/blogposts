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
public class LastNameSort implements Comparator<Customer> {
    
    @Override
    public int compare(Customer a, Customer b) {
        
        return a.getlName().compareTo(b.getlName());
        
    }
    
}

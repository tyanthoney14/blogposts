/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.jdbctemplateexample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CustomerResultExtractorByState implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet set) throws SQLException, DataAccessException {
        
        Map<String, List<Customer>> customers = new HashMap<>();
        
        while (set.next()) {
            
            Customer customer = new Customer();
            
            customer.setID(set.getLong("ID"));
            customer.setfName(set.getNString("firstName"));
            customer.setlName(set.getNString("lastName"));
            
            String key = set.getNString("state");
        
            if (!customers.containsKey(key)) {
            
                customers.put(key, new ArrayList<>());
                
            }
            
            customers.get(key).add(customer);
        
        }
        
        return customers;
        
    }
    
}

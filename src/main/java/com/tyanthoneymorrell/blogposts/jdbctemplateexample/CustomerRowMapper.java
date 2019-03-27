/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.jdbctemplateexample;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet set, int i) throws SQLException {
        
        Customer customer = new Customer();
        
        customer.setID(set.getLong("ID"));
        customer.setfName(set.getNString("firstName"));
        customer.setlName(set.getNString("lastName"));
        
        
        return customer;
    }
    
}

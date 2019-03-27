/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.jdbctemplateexample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@SpringBootApplication
public class JdbcMain implements CommandLineRunner {
    
    @Resource(name="databaseoneconnection")
    private DataSource dataSource;
    
    @Autowired
    private ApplicationContext  context;
    
    public static void main(String[] args) {
        
        SpringApplication.run(JdbcMain.class, args);
        
    }

    @Override
    public void run(final String... args) throws Exception {
        
        JdbcTemplate dbTemplate = new JdbcTemplate(dataSource);
        
        try {
            
            Integer count = dbTemplate.queryForObject(
                    "select count(ID) from Customer",
                    Integer.class
            );

            List<Integer> ids = dbTemplate.queryForList(
                    "select top 100 ID from Customer",
                    Integer.class
            );

            Customer customer = (Customer) dbTemplate.queryForObject(
                    "select top 1 ID, firstName, lastName from Customer order by ID desc",
                    new CustomerRowMapper()
            );

            System.out.println(customer.toString());
        
            List<Customer> customers = (List<Customer>) dbTemplate.query(
                    "select top 10 ID, firstName, lastName from Customer order by ID desc",
                    new CustomerExtractor()
            );
            
            customers = dbTemplate.query(
                    "select top 10 ID, ReportedFirst as firstName, REportedLast as lastName from Customer order by ID desc",
                    new CustomerRowMapper()
            );
            
            Map<String, List<Customer>> customersByState = (Map<String, List<Customer>>) dbTemplate.query(
                    "select top 100 ID, firstName, lastName, state from Customer order by ID desc",
                    new CustomerResultExtractorByState()
            );
            
            for (String key : customersByState.keySet()) {
                
                System.out.println("State: " + key);
                
                for (Customer cus : customersByState.get(key)) {
                    
                    System.out.println(cus.toString());
                    
                }
                
            }
            
            Integer totalRowsUpdated = dbTemplate.update(
                    "update Customer set firstName = ? where ID = ?",
                    new Object[] {"Steve", 10}
            );
            
            Integer totalRowsDeleted = dbTemplate.update(
                    "delete from Customer where ID = 11"
            );
            
            SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
                    .withTableName("Customer");
            
            Integer ID = 0;
            String firstName = "Stan";
            String lastName = "Lee";
            String state = "Ohio";
            
            Map<String, Object> insertionValues = new HashMap<String, Object>();
            insertionValues.put("ID", ID);
            insertionValues.put("firstName", firstName);
            insertionValues.put("lastName", lastName);
            insertionValues.put("state", state);
            
            Integer totalRowsInserted = jdbcInsert.execute(insertionValues);
            
            System.out.println("Count: " + count);
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}

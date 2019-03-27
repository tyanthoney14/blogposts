/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.jdbctemplateexample;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfiguration {
    
    @Value("${db.driverClassName}")
    private String driverClassName;
    
    @Value("${db.url}")
    private String dbUrl;
    
    @Value("${db.username}")
    private String userName;
    
    @Value("${db.password}")
    private String password;
    
    @Bean(name="databaseoneconnection")
    public DataSource getDataBaseOneTemplate() {
        
        DriverManagerDataSource dataSource = 
                new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        
        return dataSource;
        
    }
    
}

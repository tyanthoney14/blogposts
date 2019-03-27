/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.springannotationsexample;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClassExample {
    
    @Value("${thirdpartyapi.start}")
    private String thirdPartyStartApi;
    
    @Bean(name="thirdpartystartapi")
    public String getThirdPartyApiStart() {
        
        return this.thirdPartyStartApi;
        
    }
    
    
}

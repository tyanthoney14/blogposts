/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.springannotationsexample;

import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author tyanthoneym
 */
@SpringBootApplication
public class SpringAnnotationsMain implements CommandLineRunner {
    
    @Resource(name="thirdpartystartapi")
    private String thirdPartyStartApi;
    
    public static void main(String[] args) {
        
        SpringApplication.run(SpringAnnotationsMain.class, args);
        
    }

    @Override
    public void run(final String... args) throws Exception {
        
        System.out.println(this.thirdPartyStartApi);
        
    }
    
}

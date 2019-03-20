/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.concurrencyexample;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author tyanthoneym
 */
public class RunnableExample implements Runnable {

    @Override
    public void run() {
        
        try {
            
            // to illustrate that this code is being executed concurrently
            TimeUnit.SECONDS.sleep(2);
            
            System.out.println(Thread.currentThread().getName());
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}

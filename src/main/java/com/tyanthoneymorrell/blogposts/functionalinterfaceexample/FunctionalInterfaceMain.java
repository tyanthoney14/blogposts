/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.functionalinterfaceexample;

/**
 *
 * @author tyanthoneym
 */
public class FunctionalInterfaceMain {
    
    public static void main(String[] args) {
        
        AFunctionalInterface functionalInterface = () -> {
            
            System.out.println("Hello World!");
            
        };
        
        functionalInterface.sayHelloWorld();
        
        functionalInterface.sayGoodbyeWorld();
        
    }
}

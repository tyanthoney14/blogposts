/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.concurrencyexample;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author tyanthoneym
 */
public class ConcurrencyMain {
    
    public static void main(String[] args) {
        
        RunnableExample runnableExample = new RunnableExample();
        
        // create a thread to execute our runnable in
        Thread threadForRunnableExample = new Thread(runnableExample);
        
        // should print the main thread
        runnableExample.run();
        
        // create a thread using Java 8 lambda expression
        Thread threadForRunnableExample2 = new Thread(() -> {
            
            System.out.println("LAMBDA: " + Thread.currentThread().getName());
            
        });
        
        // should print the name of a different thread
        threadForRunnableExample.start();
        
        // should print the name of a different thread
        threadForRunnableExample2.start();
        
        // ExecutorService example
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        
        threadPool.submit(runnableExample);
        
        // ExecutorService submit using Java 8 lambda expression
        threadPool.submit(() -> {
            
            System.out.println("EXECUTOR LAMBDA: " + Thread.currentThread().getName());
            
        });
        
        // ExecutorService also takes a callable which can be returned to a future
        Future<String> future = threadPool.submit(() -> {
            
            TimeUnit.SECONDS.sleep(18);
            
            return "CALLABLE EXECUTOR LAMBDA: " + Thread.currentThread().getName();
            
        });
        
        // calling is done on a future lets us know whether or not our task has completed.
        while (!future.isDone()) {
            
            System.out.println("Not Done Yet!!");
            
        }
        
        try {
            
            System.out.println(future.get());
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }

        future = threadPool.submit(() -> {
            
            TimeUnit.SECONDS.sleep(18);
            
            return "CALLABLE EXECUTOR LAMBDA: " + Thread.currentThread().getName();
            
        });
        
        try {
            
            // will block since we did not wait for isDone()
            System.out.println(future.get());
            
            // make sure to shut down the Executor
            threadPool.shutdown();
            
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            // shut down the executor just in case all of the tasks had not finished before out await time
            threadPool.shutdownNow();
            
        }
        
        
        System.out.println("Finished");
    }
    
}

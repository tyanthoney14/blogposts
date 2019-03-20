/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.comparatorexample;

/**
 *
 * @author tyanthoneym
 */
public class Customer {
    
    private Integer customerID;
    private String fName, lName;

    public Customer() {
    }

    public Customer(Integer customerID, String fName, String lName) {
        this.customerID = customerID;
        this.fName = fName;
        this.lName = lName;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", fName=" + fName + ", lName=" + lName + '}';
    }
}

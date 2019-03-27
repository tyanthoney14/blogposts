/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyanthoneymorrell.blogposts.jdbctemplateexample;

/**
 *
 * @author tyanthoneym
 */
public class Customer {
    
    private Long ID;
    private String fName, lName;

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Long getID() {
        return ID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    @Override
    public String toString() {
        return "Customer{" + "ID=" + ID + ", fName=" + fName + ", lName=" + lName + '}';
    }
}

package com.mk.tutorials.hibernate;


import java.util.Date;
import java.util.Objects;


public class User implements java.io.Serializable {


     private String username;
     private String firstname;
     private String lastname;
     private Date doj;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUsername());
    }

    public User() {
    }


    public User(String username) {
        this.username = username;
    }
    public User(String username, String firstname, String lastname, Date doj) {
       this.username = username;
       this.firstname = firstname;
       this.lastname = lastname;
       this.doj = doj;
    }


    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }


    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    

    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public Date getDoj() {
        return this.doj;
    }
    
    public void setDoj(Date doj) {
        this.doj = doj;
    }




}



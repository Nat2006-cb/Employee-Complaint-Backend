package com.examly.springapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;



@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String password;

    public User(){

    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    

}

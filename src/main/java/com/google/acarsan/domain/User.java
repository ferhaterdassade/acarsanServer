package com.google.acarsan.domain;

/**
 * Created by ferhat on 12/2/2015.
 */
public class User {
    private final String userName;
    private final String password;
    private String email;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


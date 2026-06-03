package com.lld.systemdesign.structural.facade;

public class AuthService {

    public boolean authenticate(String userId) {
        System.out.println("Authenticating user: " + userId);
        return true;
    }
}
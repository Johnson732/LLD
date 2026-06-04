package com.lld.systemdesign.structural.proxy;

/**
 * Simulates an expensive external API call.
 */
public class RealThirdPartyApi implements ThirdPartyApi {

    @Override
    public String fetchUserProfile(String userId) {

        System.out.println("Calling external API for user: " + userId);

        return "Profile Data for User -> " + userId;
    }
}
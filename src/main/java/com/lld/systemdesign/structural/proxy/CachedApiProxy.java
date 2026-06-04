package com.lld.systemdesign.structural.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Proxy adds caching before delegating to the real API.
 */
public class CachedApiProxy implements ThirdPartyApi {

    private final ThirdPartyApi realApi;
    private final Map<String, String> cache = new HashMap<>();

    public CachedApiProxy() {
        this.realApi = new RealThirdPartyApi();
    }

    @Override
    public String fetchUserProfile(String userId) {

        if (cache.containsKey(userId)) {
            System.out.println("Returning cached result for user: " + userId);
            return cache.get(userId);
        }

        String result = realApi.fetchUserProfile(userId);

        cache.put(userId, result);

        return result;
    }
}
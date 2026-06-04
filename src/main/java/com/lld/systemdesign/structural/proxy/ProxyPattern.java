package com.lld.systemdesign.structural.proxy;

/**
 * Proxy Pattern example
 */
public final class ProxyPattern {

    private ProxyPattern() {
    }

    public static void main(String[] args) {

        ThirdPartyApi api = new CachedApiProxy();

        System.out.println(api.fetchUserProfile("101"));

        System.out.println();

        System.out.println(api.fetchUserProfile("101"));

        System.out.println();

        System.out.println(api.fetchUserProfile("202"));
    }
}
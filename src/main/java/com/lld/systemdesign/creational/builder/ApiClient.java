package com.lld.systemdesign.creational.builder;

/**
 * Real-world idea:
 * SDK/API clients usually require mandatory settings and several optional configurations.
 * Builder makes object creation readable and maintainable.
 */
public final class ApiClient {

    private final String baseUrl;
    private final String apiKey;
    private final int connectTimeout;
    private final int readTimeout;
    private final int retryCount;
    private final boolean loggingEnabled;

    private ApiClient(Builder builder) {
        this.baseUrl = builder.baseUrl;
        this.apiKey = builder.apiKey;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.retryCount = builder.retryCount;
        this.loggingEnabled = builder.loggingEnabled;
    }

    public void printConfiguration() {
        System.out.println("API Client Configuration");
        System.out.println("Base URL: " + baseUrl);
        System.out.println("API Key: " + apiKey);
        System.out.println("Connect Timeout: " + connectTimeout + " ms");
        System.out.println("Read Timeout: " + readTimeout + " ms");
        System.out.println("Retry Count: " + retryCount);
        System.out.println("Logging Enabled: " + loggingEnabled);
    }

    public static class Builder {

        // Mandatory fields
        private final String baseUrl;
        private final String apiKey;

        // Optional fields
        private int connectTimeout = 5000;
        private int readTimeout = 10000;
        private int retryCount = 3;
        private boolean loggingEnabled = false;

        public Builder(String baseUrl, String apiKey) {
            this.baseUrl = baseUrl;
            this.apiKey = apiKey;
        }

        public Builder connectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder readTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public Builder retryCount(int retryCount) {
            this.retryCount = retryCount;
            return this;
        }

        public Builder loggingEnabled(boolean loggingEnabled) {
            this.loggingEnabled = loggingEnabled;
            return this;
        }

        public ApiClient build() {
            return new ApiClient(this);
        }
    }
}
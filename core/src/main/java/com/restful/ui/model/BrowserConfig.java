package com.restful.ui.model;

/**
 * @author olufemi
 */
public class BrowserConfig {

    private String url;
    private String driverType;

    private String platform;

    private BrowserConfig(Builder builder) {
        setUrl(builder.url);
        setDriverType(builder.driverType);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    String getDriverType() {
        return driverType;
    }

    String getPlatform() {
        return platform;
    }

    private void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    private void setPlatform(String platform) {
        this.platform = platform;
    }

    String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }


    public static final class Builder {
        private String url;
        private String driverType;

        private String platform;

        private Builder() {
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }


        public Builder withDriverType(String driverType) {
            this.driverType = driverType;
            return this;
        }

        public Builder withPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public BrowserConfig build() {
            return new BrowserConfig(this);
        }
    }
}

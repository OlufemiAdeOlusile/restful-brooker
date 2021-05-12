package com.restful.automation.factory;

import com.restful.automation.config.ConfigResolver;
import com.restful.automation.model.BrowserConfig;


/**
 * @author olufemi on 2021-05-11
 */
class BrowserConfigFactory {

    private static final String DRIVER_TYPE = ConfigResolver.getConfig().getString("browser.type");
    private static final String URL = ConfigResolver.getConfig().getString("browser.remote_uri");


    private BrowserConfigFactory() {

    }

    /**
     * @return the Browser Config
     */
    static BrowserConfig initConfig() {
        return BrowserConfig.newBuilder().withDriverType(DRIVER_TYPE).withUrl(URL)
                .build();
    }
}

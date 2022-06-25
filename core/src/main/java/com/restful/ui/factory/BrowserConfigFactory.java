package com.restful.ui.factory;

import com.restful.ui.config.ConfigResolver;
import com.restful.ui.model.BrowserConfig;


/**
 * @author olufemi
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

package com.restful.automation.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * @author olufemi on 2021-05-11
 */
public class ConfigResolver {

    private static final String BUILD_CONF = "conf/defaults";

    private static final Config CONFIG = ConfigFactory.load(BUILD_CONF);

    private ConfigResolver() {

    }

    public static Config getConfig() {
        return CONFIG;
    }
}

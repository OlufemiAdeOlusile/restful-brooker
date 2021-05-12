package com.restful.automation.model;


import com.restful.automation.exceptions.RestfulWebException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author olufemi on 2021-05-11
 */
public enum BrowserType {

    CHROME {
        @Override
        protected WebDriver createWebDriver(BrowserConfig config) {
            try {
                return new RemoteWebDriver(new URL(config.getUrl()), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                throw new RestfulWebException("Cannot Instantiate new Driver", e);
            }
        }
    };

    /**
     * Creates the web driver.
     *
     * @return the web driver
     */
    protected abstract WebDriver createWebDriver(BrowserConfig config);

}

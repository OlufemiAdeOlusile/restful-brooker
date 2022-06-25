package com.restful.ui.model;


import com.restful.ui.exceptions.WebException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author olufemi
 */
public enum BrowserType {

    chrome {
        @Override
        protected WebDriver createWebDriver(BrowserConfig config) {
            try {
                return new RemoteWebDriver(new URL(config.getUrl()), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                throw new WebException("Cannot Instantiate new Driver", e);
            }
        }
    },
    firefox {
        @Override
        protected WebDriver createWebDriver(BrowserConfig config) {
            try {
                return new RemoteWebDriver(new URL(config.getUrl()), DesiredCapabilities.firefox());
            } catch (MalformedURLException e) {
                throw new WebException("Cannot Instantiate new Driver", e);
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

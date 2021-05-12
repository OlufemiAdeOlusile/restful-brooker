package com.restful.automation.factory;


import com.restful.automation.model.BrowserManager;
import org.openqa.selenium.WebDriver;

/**
 * @author olufemi on 2021-05-11
 */
public class BrowserFactory {


    /**
     *
     * @return instantiate and return driver
     */
    public WebDriver initBrowser() {
        return BrowserManager.getInstance().getDriver(BrowserConfigFactory.initConfig());
    }

    /**
     *
     * @return instantiated driver
     */
    public WebDriver getBrowser() {
        return BrowserManager.getInstance().getInstantiatedDriver();
    }

    /**
     * quit the driver
     */
    public void quitBrowser() {
        BrowserManager.getInstance().destroyDriver();
    }
}

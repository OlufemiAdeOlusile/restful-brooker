package com.restful.ui.factory;


import com.restful.ui.model.BrowserManager;
import org.openqa.selenium.WebDriver;

/**
 * @author olufemi
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

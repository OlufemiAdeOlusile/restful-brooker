package com.restful.automation.pages;

import com.restful.automation.config.ConfigResolver;
import com.restful.automation.factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * @author olufemi on 2021-05-11
 */
public abstract class BasePageObject<V> {

    protected static final String URL = ConfigResolver.getConfig().getString("test.url");
    protected static WebDriver driver = new BrowserFactory().getBrowser();

    public BasePageObject() {
        PageFactory.initElements(driver, this);
    }


    @SuppressWarnings(value = "unchecked")
    public V and() {
        return (V) this;
    }

    public abstract V waitForPage();

}

package com.restful.ui.pages;

import com.restful.ui.config.ConfigResolver;
import com.restful.ui.factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * @author olufemi
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

    public abstract V waitForPageOrModule();

}

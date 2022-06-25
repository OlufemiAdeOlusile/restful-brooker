package com.restful.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.restful.ui.dsl.WebDriverDsl.*;

/**
 * @author olufemi
 */
public class HomePage extends BasePageObject<HomePage> {

    @FindBy(css = "[data-category='Departure Month']")
    private WebElement depatureMonth;

    public void open() {
        openUrl(URL);
        waitForPageOrModule();
    }

    public void verifyTitle(String title) {
        String title1 = getTitle();
        Assert.assertEquals(title, title1);
    }

    @Override
    public HomePage waitForPageOrModule() {
        waitForNewPageOrModule(depatureMonth);
        return this;
    }
}

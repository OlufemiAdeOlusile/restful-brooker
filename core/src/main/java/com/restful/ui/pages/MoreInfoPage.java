package com.restful.ui.pages;

import com.restful.ui.dsl.WebDriverDsl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * @author olufemi
 */
public class MoreInfoPage extends BasePageObject<MoreInfoPage> {

    @FindBy(id = "supplier-phone")
    private WebElement phoneNumberElement;

    @FindBy(id = "price-pin_riviera-days-num")
    private WebElement numberOfDays;

    @FindBy(id = "price-pin_price_non_newmarket")
    private WebElement priceElement;


    public void verifyDaysPriceAndNumber(String days, String price, String phoneNumber) {
        Assert.assertTrue(numberOfDays.getText().contains(days));
        Assert.assertTrue(priceElement.getText().contains(price));
        Assert.assertTrue(phoneNumberElement.getText().contains(phoneNumber));
    }

    @Override
    public MoreInfoPage waitForPageOrModule() {
        WebDriverDsl.waitForNewPageOrModule(numberOfDays);
        return this;
    }
}

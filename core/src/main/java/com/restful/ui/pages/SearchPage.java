package com.restful.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.restful.ui.dsl.WebDriverDsl.waitForNewPageOrModule;

/**
 * @author olufemi
 */
public class SearchPage extends BasePageObject<SearchPage> {

    private static final String PRODUCT_NAME = "iterator_%s_product_custom_product-name";
    private static final String PRODUCT_TEXT = "iterator_%s_product_custom_product-text";
    private static final String PRODUCT_DAYS = "iterator_%s_product_custom_days-ctr";
    private static final String PRODUCT_PRICE = "iterator_%s_product_custom_price-from";
    private static final String MORE_INFO = "iterator_%s_product_custom_more-info-button";

    @FindBy(css = ".nbf_tpl_custom.nbf_tpl_it")
    private List<WebElement> productList;

    @FindBy(id = "reset-filters")
    private WebElement filterReset;


    public void clickMoreInfo(String title, String productText, String productDays, String productAmount) {
        for (int i = 1; i < productList.size(); i++) {
            String iterator = String.valueOf(i);
            WebElement productElement = driver.findElement(By.id(String.format(PRODUCT_NAME, iterator)));
            WebElement productTextElement = driver.findElement(By.id(String.format(PRODUCT_TEXT, iterator)));
            WebElement productDaysElement = driver.findElement(By.id(String.format(PRODUCT_DAYS, iterator)));
            WebElement productPriceElement = driver.findElement(By.id(String.format(PRODUCT_PRICE, iterator)));
            WebElement moreInfoElement = driver.findElement(By.id(String.format(MORE_INFO, iterator)));

            if (productElement.getText().contains(title) &&
                    productTextElement.getText().contains(productText) &&
                    productDaysElement.getText().contains(productDays) && productPriceElement.getText().contains(productAmount)) {
                moreInfoElement.click();
                break;
            }
        }
    }

    @Override
    public SearchPage waitForPageOrModule() {
        waitForNewPageOrModule(filterReset);
        return this;
    }
}

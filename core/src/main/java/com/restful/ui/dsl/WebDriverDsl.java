package com.restful.ui.dsl;

import com.restful.ui.factory.BrowserFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author olufemi
 */
public class WebDriverDsl {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverDsl.class);
    private static final long WAIT_TIMEOUT = 20;
    private static WebDriver driver = new BrowserFactory().getBrowser();

    private WebDriverDsl() {
    }


    public static void openUrl(String url) {
        driver.get(url);
    }

    public static void waitForNewPageOrModule(WebElement webElement) {
        waitForElementToBeVisible(webElement);
    }

    public static String getTitle() {
       return driver.getTitle();
    }


    public static void fillText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(WebElement element) {
        return element.getText();
    }


    public static void clickIfVisible(WebElement element) {
        if (isVisible(element)) {
            element.click();
        }
    }


    public static void clickUntilElementVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(input -> clickWhenVisible(element));

    }

    public static void clickFromList(List<WebElement> elements, String language) {
        elements.stream().filter(f -> f.getText().contains(language)).findAny().ifPresent(WebElement::click);
    }

    public static void clickFromDropDownUntilElementIsVisible(List<WebElement> elements, WebElement conditionalElement, String language) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(input -> clickFromListAndVerifyElementIsVisible(elements, conditionalElement, language));
    }


    public static double parseStringToDouble(String value) {
        return Double.parseDouble(value);
    }

    public static void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(input -> isVisible(element));
    }

    public static void waitForElementSize(List<WebElement> element, int previousSize) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(input -> element.size() >= previousSize + 1);
    }

    private static boolean clickFromListAndVerifyElementIsVisible(List<WebElement> elements, WebElement conditionalElement, String value) {
        try {
            elements.stream().filter(f -> f.getText().contains(value)).findAny().ifPresent(WebElement::click);
        } catch (StaleElementReferenceException e) {
            return false;
        }
        return isVisible(conditionalElement);
    }

    private static boolean clickWhenVisible(WebElement element) {
        try {
            element.click();
            return true;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }


    private static boolean isVisible(WebElement element) {
        boolean retval;

        try {
            retval = element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            LOGGER.debug("Element was not found!", e);
            retval = false;
        }

        return retval;
    }

}

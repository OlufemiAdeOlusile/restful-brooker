package com.restful.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.restful.automation.dsl.WebDriverDsl.*;

/**
 * @author olufemi on 2021-05-12
 */
public class LoginPage extends BasePageObject<LoginPage> {

    @FindBy(id = "username")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "doLogin")
    private WebElement loginBotton;


    public void login(String name, String pass) {
        fillText(userName, name);
        fillText(password, pass);
        loginBotton.click();
   }

    public void open() {
        openUrl(URL);
        waitForPage();
    }


    @Override
    public LoginPage waitForPage() {
        waitForNewPage(userName);
        return this;
    }
}

package com.restful.ui;


import com.restful.ui.factory.BrowserFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src/test/resources/features", tags = "@mail")

public class CucumberRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    public void setup() {
        new BrowserFactory().initBrowser();
    }

    @AfterTest
    public void tearDown() {
        new BrowserFactory().quitBrowser();
    }
}

package com.restful.ui;

import com.restful.ui.pages.HomePage;
import com.restful.ui.pages.MoreInfoPage;
import com.restful.ui.pages.SearchPage;
import com.restful.ui.pages.TopSearchHeader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author olufemi
 */
public class MailTravelStepDefs {
    private final HomePage homePage = new HomePage();
    private final MoreInfoPage moreInfoPage = new MoreInfoPage();
    private final SearchPage searchPage = new SearchPage();
    private final TopSearchHeader topSearchHeader = new TopSearchHeader();

    @Given("^a user is on the homepage$")
    public void a_user_is_on_the_homepage(){
        homePage.open();
    }

    @Given("^verifies title \"([^\"]*)\"$")
    public void verifies_title(String arg1) {
        homePage.waitForPageOrModule().verifyTitle(arg1);
    }

    @When("^the user searches for travel destination \"([^\"]*)\"$")
    public void the_user_searches_for_travel_destination(String arg1) {
        topSearchHeader.waitForPageOrModule().searchHoliday(arg1);
    }

    @When("^the user clicks more info on \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void the_user_clicks_more_info_on(String title, String text, String days, String amount) {
        searchPage.waitForPageOrModule().clickMoreInfo(title, text, days, amount);
    }

    @Then("^the user should see the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" on the More info page\"$")
    public void the_user_should_see_the_on_the_More_info_page(String days, String price, String phoneNumber) {
        moreInfoPage.waitForPageOrModule().verifyDaysPriceAndNumber(days, price, phoneNumber);
    }
}

package com.restful.automation;

import com.restful.automation.pages.LoginPage;
import com.restful.automation.pages.RoomPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author olufemi on 2021-05-11
 */
public class RoomStepDefs {

    private LoginPage loginPage = new LoginPage();
    private RoomPage roomPage = new RoomPage();


    @Given("^a user has logged in$")
    public void aUserHasLoggedIn() {
        loginPage.open();
        loginPage.login("admin", "password");
    }

    @When("^the user books a room \"([^\"]*)\" \"([^\"]*)\"$")
    public void theUserBooksARoom(String arg0, String arg1) {
        roomPage.waitForPage().and().bookRoom(arg0,arg1);
    }

    @Then("^the user should be able to delete this room \"([^\"]*)\"$")
    public void theUserShouldBeAbleToDeleteThisRoom(String arg0) {
        roomPage.waitForPage().and().deleteRoom(arg0);
    }
}

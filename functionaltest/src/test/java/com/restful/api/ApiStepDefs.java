package com.restful.api;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

/**
 * @author olufemi
 */
public class ApiStepDefs {
    Response response;
    String baseUrl;

    @Given("^an endpoint with url \"([^\"]*)\"$")
    public void an_endpoint_with_url(String arg1) {
        baseUrl = arg1;
    }

    @When("^a get request with route \"([^\"]*)\"$")
    public void a_get_request_with_route(String arg1) {
        response = RestAssured.get(baseUrl + arg1);
        System.out.println(response.getBody().asString());
    }

    @Then("^status code is \"([^\"]*)\"$")
    public void status_code_is(String arg1) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(arg1));
    }

    @Then("^body should contain strings$")
    public void body_should_contain_strings(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        rows.forEach(f -> {
            response.then().body(f.get("body"), is(f.get("data")));
        });
    }

    @Then("^body should contain int$")
    public void body_should_contain_int(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        rows.forEach(f -> {
            response.then().body(f.get("body"), is(Integer.parseInt(f.get("data"))));
        });
    }
}

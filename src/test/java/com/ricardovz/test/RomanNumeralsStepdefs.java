package com.ricardovz.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Implements the steps mentioned on the feature file
 */
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class RomanNumeralsStepdefs {

    public static final String URL = "http://localhost:{port}/convert/{input}";

    @Value("${local.server.port}")
    protected int serverPort;

    private int input;

    private String result;

    private RestTemplate restTemplate;

    public RomanNumeralsStepdefs() {
        this.restTemplate = new RestTemplate();
    }

    @Given("^The number is '(\\d+)'$")
    public void The_number_is_(int number) throws Throwable {

        input = number;

    }

    @When("^the application converts the number$")
    public void the_application_converts_the_number() throws Throwable {

        result = restTemplate.getForObject(URL, String.class, serverPort, input);

    }

    @Then("^the application returns '(\\w+)'$")
    public void the_application_returns_I(String romanNumeral) throws Throwable {

        Assert.assertEquals(romanNumeral, result);

    }
}

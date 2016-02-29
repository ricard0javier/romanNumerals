package com.ricardovz.romanNumerals.acceptanceTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Set of Acceptance Tests created to ensure the Application meets the expected behaviour
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class RunRomanNumeralsAcceptanceTests {

}

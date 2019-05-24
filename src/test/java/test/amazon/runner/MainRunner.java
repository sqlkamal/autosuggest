package test.amazon.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import test.amazon.utils.Driver;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", 
				 plugin = { "pretty","html:target/cucumber-reports" }, 
				 monochrome = true, 
				 glue = "test.amazon.stepdefs", 
				 dryRun = false, 
				 tags = "@autosuggest")

public class MainRunner {

	@AfterClass
	public static void terDown() {
		Driver.quitDriver();
	}

}
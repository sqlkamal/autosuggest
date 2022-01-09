package test.amazon.stepdefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import test.amazon.utils.Driver;

public class Hook {

	@After
	public void tearDown(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				final byte[] screenshot = ((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		} finally {
			Driver.getInstance().quit();
		}
	}

}
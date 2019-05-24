package test.amazon.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

	public static WebDriver driver;

	/* Get Driver */
	public static WebDriver getInstance() {
		if (driver == null) {
			switch (Config.getPropertyValue("browser")) {
			case "ie":
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//libs//");
				driver = new InternetExplorerDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//libs//chromedriver");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//libs//");
				driver = new FirefoxDriver();
				break;
			}
			return driver;
		} else {
			return driver;
		}
	}

	/* Quit Driver */
	public static void quitDriver() {
		driver.quit();
		driver = null;
	}

}
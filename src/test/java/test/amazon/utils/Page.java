package test.amazon.utils;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	/* Highlight Element */
	public static void highLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			print(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
	}

	/* Click Element */
	public static void clickElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("arguments[0].click();", element);
	}

	/* Random Number */
	public static int getRandomNumber(int max) {
		Random rn = new Random();
		int answer = rn.nextInt(max);
		print("Random Number " + answer);
		return answer;
	}

	/* Wait For Visibility */
	public static void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/* Print */
	public static void print(String print) {
		System.out.println("\n" + print);
	}

}
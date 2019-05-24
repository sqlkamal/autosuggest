package test.amazon.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.amazon.utils.Driver;
import test.amazon.utils.Page;

public class HomePage {

	private WebDriver driver;

	/* Constructor */
	public HomePage() {
		driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}

	/* WebElements */
	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchProductTextBox;

	@FindBy(id = "suggestions-template")
	public WebElement autoSuggestTemplate;

	@FindBy(xpath = "//div[@class='s-suggestion']")
	public List<WebElement> autoSuggestList;

	@FindBy(xpath = "//div[@class='s-suggestion']/span[1]")
	public List<WebElement> autoSuggestListPre;

	@FindBy(xpath = "//div[@class='s-suggestion']/span[2]")
	public List<WebElement> autoSuggestListSuf;

	/* Home Page */
	public void gotoHomePage() {
		driver.get("https://www.amazon.com");
	}

	/* Search Product */
	public void searchProduct(String product) {
		searchProductTextBox.sendKeys(product);
		Page.waitForVisibility(autoSuggestTemplate);
	}

	/* Select Product */
	public void selectProduct() {
		int randomNumber = Page.getRandomNumber(autoSuggestList.size());
		Page.print("Selected " + autoSuggestListSuf.get(randomNumber).getText() + " Product From Auto Suggest List");
		Page.highLightElement(autoSuggestList.get(randomNumber));
		Page.clickElement(autoSuggestList.get(randomNumber));
	}

}
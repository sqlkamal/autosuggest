package test.amazon.stepdefs;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import test.amazon.api.modal.RESTTester;
import test.amazon.pages.HomePage;
import test.amazon.utils.Page;

public class AutoSuggest_StepDef {

	private static ObjectMapper mapper = new ObjectMapper();

	@Given("^user is on homepage$")
	public void navigateToHome() {
		HomePage hp = new HomePage();
		hp.gotoHomePage();
	}

	@Then("^user searches for the product \"([^\"]*)\"$")
	public void searchProduct(String product) {
		HomePage hp = new HomePage();
		hp.searchProduct(product);
	}

	@Then("^user validates autosuggest list against search \"([^\"]*)\" and RestAPI response$")
	public void validateAutoSuggestList(String product) {
		HomePage hp = new HomePage();
		Page.print("Size is " + hp.autoSuggestList.size());
		Assert.assertTrue(hp.autoSuggestList.size() <= 10);

		RESTTester api = new RESTTester();
		String result = api.callAPIAutoSuggest(product);
		JsonNode jsn = null;

		try {
			jsn = mapper.readTree(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int i = 0;
		for (WebElement a : hp.autoSuggestListSuf) {
			if (i <= hp.autoSuggestListSuf.size()) {
				i = i + 1;
			}

			String finalProduct = null;
			if ((a.getText().trim() == "")) {
				if (a.getText().toString().substring(0, 1).equals("es")) {
					finalProduct = product + a.getText();
				}
			} else {
				finalProduct = product + "" + a.getText();
			}

			Page.print("Product From Auto Suggest List " + finalProduct + "\n" + "Product From RestAPI "
					+ jsn.get("suggestions").get(i).get("value").toString().replace("\"", ""));

			/* The order of RestAPI and Auto Suggest List on UI is off */
			Assert.assertTrue(
					(jsn.get("suggestions").get(i).get("value").toString().replace("\"", "")).equals(finalProduct));
		}
	}

	@Then("^user selects random product from autosuggest list$")
	public void selectProductFromAutoSuggestList() throws Throwable {
		HomePage hp = new HomePage();
		hp.selectProduct();
	}

}
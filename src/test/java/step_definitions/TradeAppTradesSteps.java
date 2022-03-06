package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeAppTradesPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.Driver;
import utilities.PropertiesReader;

public class TradeAppTradesSteps {

	TradeAppTradesPage tradePage = new TradeAppTradesPage();
	BrowserUtils utils = new BrowserUtils();
	DButils dbUtils = new DButils();
	
	String stockSymbol;
	String stockEntryPrice;

	// log in with valid #START
	@Given("I am on the Trade App log in page")
	public void i_am_on_the_trade_app_log_in_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("tradeAppUrl"));
		Assert.assertTrue(tradePage.pleaseSignInText.isDisplayed());
	}

	@When("I enter username {string} password {string}")
	public void i_enter_username_password(String username, String password) {
		tradePage.username.sendKeys(username);
		tradePage.password.sendKeys(password);
	}

	@When("I click on Trade login button")
	public void i_click_on_trade_login_button() {
		tradePage.signInBtn.click();
	}

	@Then("I should be on Trade homepage")
	public void i_should_be_on_trade_homepage() {
		Assert.assertTrue(tradePage.tradeIconImage.isDisplayed());
		Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());
	}
	// log in valid #END

	// log in with invalid #START
	@Then("I should get error message says {string}")
	public void i_should_get_error_message_says(String expectedErrorMessage) {
		Assert.assertTrue(tradePage.loginAlertText.isDisplayed());
		String actualText = tradePage.loginAlertText.getText().trim();
		Assert.assertEquals(actualText, expectedErrorMessage);
	}

	@Then("I should still in the log in page")
	public void i_should_still_in_the_log_in_page() {
		Assert.assertTrue(tradePage.pleaseSignInText.isDisplayed());
	}
	// log in with invalid #END

	// log out #START
	@Then("I click on Trade logout button")
	public void i_click_on_trade_logout_button() {
		tradePage.logOutBtn.click();
		tradePage.logOutBtnConfirm.click();
	}

	@Then("I shoud be on Trade App log in page")
	public void i_shoud_be_on_trade_app_log_in_page() {
		Assert.assertTrue(tradePage.pleaseSignInText.isDisplayed());
	}
	// log out #END

	// add trade valid #START
	@When("I click on Add Trade button")
	public void i_click_on_add_trade_button() {
		tradePage.addTradeBtn.click();
	}

	@Then("I should be on Save Trade page")
	public void i_should_be_on_save_trade_page() {
		Assert.assertTrue(tradePage.saveTradeText.isDisplayed());
	}

	@When("I select {string} and I enter symbol {string} entryDate {string} entryPrice {string} exitDate {string} exitPrice {string}")
	public void i_select_and_i_enter_symbol_entry_date_entry_price_exit_date_exit_price(String typeOfTrade,
			String symbol, String entryDate, String entryPrice, String exitDate, String exitPrice) {
		stockSymbol = symbol;
		stockEntryPrice = entryPrice;
		
		utils.selectByVisibleText(tradePage.buyOrSellDropDown, typeOfTrade);
		tradePage.stockSymbol.sendKeys(symbol);
		tradePage.openDate.sendKeys(entryDate);
		tradePage.stockEntryPrice.sendKeys(entryPrice);
		tradePage.closeDate.sendKeys(exitDate);
		tradePage.stockExitPrice.sendKeys(exitPrice);
	}

	@When("I click Save button")
	public void i_click_save_button() {
		tradePage.saveBtn.click();
	}

	@Then("The trade is displayed on the trade table")
	public void the_trade_is_displayed_on_the_trade_table() {
		Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());

		for (WebElement singleSymbol : tradePage.stockSymbols) {
			if (singleSymbol.getText().equals(stockSymbol)) {
				Assert.assertEquals(singleSymbol.getText(), stockSymbol);
			}
		}
	}
	// add trade valid #END
	
	// add trade invalid #START
	@Then("I should get error alert says {string}")
	public void i_should_get_error_alert_says(String expectedAlertMessage) throws InterruptedException {
		Thread.sleep(10000);
		String actualMessage = tradePage.stockSymbol.getAttribute("validationMessage");
		System.out.println(actualMessage);
		Assert.assertEquals(actualMessage, expectedAlertMessage);
	}
	// add trade invalid #END
	
	// search trade valid #START
	@When("I enter symbol {string} and date {string}")
	public void i_enter_symbol_and_date(String searchSymbol, String searchDate) {
		tradePage.searchInputSymbol.sendKeys(searchSymbol);
		tradePage.searchInputDate.sendKeys(searchDate);
	}
	
	@When("I click on Search button")
	public void i_click_on_search_button() {
		tradePage.searchBtn.click();
	}
	
	@Then("The system should displays the search entered")
	public void the_system_should_displays_the_search_entered() {
		Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());
		
		for (WebElement singleSymbol : tradePage.stockSymbols) {
			if (singleSymbol.getText().equals(stockSymbol)) {
				Assert.assertEquals(singleSymbol.getText(), stockSymbol);
			}
		}
	}
	// search trade valid #END
	
	// update trade valid #START
	@When("I click on Update")
	public void i_click_on_update() {
		System.out.println(stockSymbol);
		for (WebElement singleSymbol : tradePage.stockSymbols) {
			if (singleSymbol.getText().equals(stockSymbol)) {
				Assert.assertEquals(singleSymbol.getText(), stockSymbol);
			}
		}
		System.out.println(stockSymbol);
		
		tradePage.updateBtn.click();
	}
	
	@Then("The trade is displayed on the trade table with updated values")
	public void the_trade_is_displayed_on_the_trade_table_with_updated_values() {
		Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());
		
		for (WebElement singleSymbol : tradePage.stockSymbols) {
			if (singleSymbol.getText().equals(stockSymbol)) {
				Assert.assertEquals(singleSymbol.getText(), stockSymbol);
			}
		}
		
		

	}
	// update trade valid #END
	
	// update trade invalid #START
	
	// update trade invalid #END
	
	// delete trade #START
	@When("I click on Delete button")
	public void i_click_on_delete_button() {
		tradePage.deleteBtn.click();
	}
	
	@Then("I should get alert says {string}")
	public void i_should_get_alert_says(String expectedAlertText) {
		utils.switchToAlert();
		String actualAlertText = utils.alertGetText();
		System.out.println(actualAlertText);
		Assert.assertEquals(actualAlertText, expectedAlertText);
	}
	
	@Then("I click on OK")
	public void i_click_on_ok() {
		utils.alertAccept();
	}
	
	@Then("The system should not displays the deleted transaction")
	public void the_system_should_not_displays_the_deleted_transaction() {
		Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());
		
		System.out.println(stockSymbol);
		
		for (WebElement singleSymbol : tradePage.stockSymbols) {
			if (!singleSymbol.getText().equals(stockSymbol)) {
				Assert.assertNotEquals(singleSymbol.getText(), stockSymbol);
			}
		}
	}
	// delete trade #END

}

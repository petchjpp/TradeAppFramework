package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class TradeAppTradesPage {
	
	public TradeAppTradesPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (css = ".form-signin-heading")
	public WebElement pleaseSignInText;
	
	@FindBy (id = "username")
	public WebElement username;
	
	@FindBy (id = "password")
	public WebElement password;
	
	@FindBy (css = ".btn-primary")
	public WebElement signInBtn;
	
	@FindBy (xpath = "//img[contains(@src, '.png')]")
	public WebElement tradeIconImage;
	
	@FindBy (xpath = "//a[contains(text(), 'Add trade')]")
	public WebElement addTradeBtn;
	
	@FindBy (xpath = "//div[@class='alert alert-danger']")
	public WebElement loginAlertText;
	
	@FindBy (xpath = "//button[contains(text(),'Logout')]")
	public WebElement logOutBtn;
	
	@FindBy (xpath = "//button[contains(text(),'Log Out')]")
	public WebElement logOutBtnConfirm;
	
	@FindBy (xpath = "//p[contains(text(), 'Save Trade')]")
	public WebElement saveTradeText;
	
	@FindBy (id = "longTrade")
	public WebElement buyOrSellDropDown;
	
	@FindBy (id = "symbol")
	public WebElement stockSymbol;
	
	public WebElement openDate;
	
	@FindBy (id = "entry")
	public WebElement stockEntryPrice;
	
	public WebElement closeDate;
	
	@FindBy (id = "exit")
	public WebElement stockExitPrice;
	
	@FindBy (xpath = "//button[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy (xpath = "//table[@class='table table-bordered table-striped']/tbody/tr/td[2]")
	public List<WebElement> stockSymbols;
	
	@FindBy (xpath = "//table[@class='table table-bordered table-striped']/tbody/tr/td[4]")
	public List<WebElement> stockEntryPrices;
	
	@FindBy (xpath = "//input[@type='search']")
	public WebElement searchInputSymbol;
	
	@FindBy (xpath = "//input[@type='date']")
	public WebElement searchInputDate;
	
	@FindBy (xpath = "//button[contains(text(),'Search')]")
	public WebElement searchBtn;
	
	@FindBy (xpath = "//a[@class='btn btn-danger btn-sm']")
	public WebElement deleteBtn;
	
	@FindBy (xpath = "//a[@class='btn btn-info btn-sm']")
	public WebElement updateBtn;
	
	
	

}

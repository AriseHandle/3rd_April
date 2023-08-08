package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.ipfilter.IpFilterRuleType;

public class LoginPage {

	@FindBy (xpath = "//input[@id='email']")private WebElement email;
	@FindBy (xpath = "//input[@id='pass']")private WebElement pass;
	@FindBy (xpath = "//button[@name='login']")private WebElement login;
	@FindBy (xpath = "//a[text()='Forgotten password?']") private WebElement forgot;
	@FindBy (xpath = "//a[@data-testid='open-registration-form-button']") private WebElement createAccount;
	@FindBy (xpath = "//a[text()='Create a Page']") private WebElement createPage;
	@FindBy (xpath = "//input[@name='firstname']") private WebElement firstName;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//initElement trigger @FindBy annotation to find all the WebElment in the class
	
	public void enterEmailId(String id) {
		email.sendKeys(id);
	}
	
	public void enterPassword(String password) {
		pass.sendKeys(password);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public void clickOnForgotPassword() {
		forgot.click();
	}
	
	public void clickOnCreateAccount() {
		createAccount.click();
	}
	
	public void clickOnCreatePage() {
		createPage.click();
	}
	
	public void enterFirstName(String name, WebDriver driver) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofSeconds(9));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(firstName));
		
		firstName.sendKeys(name);
	}
	
}

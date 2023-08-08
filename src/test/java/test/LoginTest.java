package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.LoginPage;
import utility.Reports;
import utility.Screenshot;

@Listeners(test.Listeners.class)
public class LoginTest extends BaseClass {
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		extent =Reports.createReports();
	}
	
	@BeforeMethod
	public void openBrowser() {
		driver = LaunchBrowser.chrome("https://www.facebook.com/");
		 
	}
	
	
	@Test
	public void loginWithValidCredentials() throws IOException {
		test = extent.createTest("loginWithValidCredentials");
		LoginPage faceBookLoginPage = new LoginPage(driver);
		SoftAssert softAssert = new SoftAssert();
		faceBookLoginPage.enterEmailId("Arise@gamil.com");
		faceBookLoginPage.enterPassword("12345");
		faceBookLoginPage.clickOnLogin();
		String currentTitle =driver.getTitle();
		
		
		softAssert.assertEquals(currentTitle,"Home Page");
		System.out.println("Home page validation done");
		
		softAssert.assertTrue(true);
		System.out.println("assert true validation done");
		
		softAssert.assertNull(currentTitle);
		
		System.out.println("POst assertion");
		
		
		softAssert.assertAll();
		
		
	}
	
	@Test
	public void loginWithValidUserNameAndInvalidPassword() {
		//test =extent.createTest("loginWithValidUserNameAndInvalidPassword");
		LoginPage faceBookLoginPage = new LoginPage(driver);
		faceBookLoginPage.enterEmailId("Arise@gamil.com");
		faceBookLoginPage.enterPassword("11111");
		faceBookLoginPage.clickOnLogin();
	}
	
	@Test
	public void loginwithInvalidUserNameAndPassword() {
		test =extent.createTest("loginwithInvalidUserNameAndPassword");
		LoginPage faceBookLoginPage = new LoginPage(driver);
		faceBookLoginPage.enterEmailId("xyz@gamil.com");
		faceBookLoginPage.enterPassword("11111");
		faceBookLoginPage.clickOnLogin();
		
	}
	
	@Test 
	public void createNewAccount() {
		test =extent.createTest("createNewAccount");
		LoginPage faceBookLoginPage = new LoginPage(driver);
		faceBookLoginPage.clickOnCreateAccount();
		faceBookLoginPage.enterFirstName("Arise",driver);
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult result)  {
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
	
		driver.close();
	}
	
	@AfterTest
	public void publish() {
		extent.flush();
	}
}

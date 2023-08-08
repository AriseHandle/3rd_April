package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Screenshot;


public class Listeners extends BaseClass implements ITestListener{
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test started :-"+ result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed :-"+ result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed :-"+ result.getName());
		try {
			Screenshot.clickScreenshot(driver, result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped :- "+ result.getName());
	}
	

}

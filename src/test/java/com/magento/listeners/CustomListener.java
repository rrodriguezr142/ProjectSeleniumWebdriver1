package com.magento.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.magento.extentreports.ExtentManager;
import com.magento.logs.Log;
import com.magento.tests.BaseTest;
import static com.magento.extentreports.ExtentTestManager.getTest;

import java.util.Objects;

public class CustomListener extends BaseTest implements ITestListener {
	WebDriver driver;
	
	private static String getTestMehodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	public void onStart(ITestContext iTestContext) {
		Log.info("I am in onStart Method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", this.driver);
	}
	
	public void onFinish(ITestContext iTestContext) {
		Log.info("I am in onFinish method " + iTestContext.getName());
		ExtentManager.extentReports.flush();
	}
	
	public void onTestStart(ITestResult iTestResult) {
		Log.info(getTestMehodName(iTestResult) + " test is starting.");
	}
	
	public void insTestSucces(ITestResult iTestResult) {
		Log.info(getTestMehodName(iTestResult) + " test is succed.");
		getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult iTestResult) {
		Log.info(getTestMehodName(iTestResult) + " test is failed.");
		Object testClass=iTestResult.getInstance();
		WebDriver driver=((BaseTest) testClass).getDriver();
		
		String base64Screenshot="data:image/pn;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
		getTest().log(Status.FAIL,"Test Failed",getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
		
		//SaveTextLog(getTestMehodName(iTestResult)+ "Failed and screenshot taken");
	}
	
	public void onTestSkipped(ITestResult iTestResult) {
		Log.info(getTestMehodName(iTestResult) + " test is skipped.");
		getTest().log(Status.SKIP, "Test skipped");
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		Log.info("Test failed but it is in defined succes ratio "+ getTestMehodName(iTestResult));
	}

}

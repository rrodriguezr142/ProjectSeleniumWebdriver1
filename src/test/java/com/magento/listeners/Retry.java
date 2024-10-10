package com.magento.listeners;

import static com.magento.extentreports.ExtentTestManager.getTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.magento.tests.BaseTest;

public class Retry implements IRetryAnalyzer{
	private int count=0;
	private static int maxtry=1;
	
	public boolean retry(ITestResult iTestResult) {
		if(!iTestResult.isSuccess()) {
			if(count<maxtry) {
				count ++;
				iTestResult.setStatus(ITestResult.FAILURE);
				return true;
			}
		}else {
			iTestResult.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}
	
	public void extendReporsFailOperations(ITestResult iTestResult) {
		Object testClass=iTestResult.getInstance();
		WebDriver webDriver=((BaseTest) testClass).getDriver();
		String base64Screenshot="data:imagen/pn;base64," + ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
		getTest().log(Status.FAIL, "Test Fail",getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
	}
	
}

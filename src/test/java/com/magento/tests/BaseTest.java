package com.magento.tests;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;
import com.magento.logs.Log;
import com.magento.pages.CartPage;
import com.magento.pages.CheckoutPage;
import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;
import com.magento.pages.RegisterPage;
import com.magento.pages.ResetPassword;
import com.magento.utils.Variables;

public class BaseTest {
	protected WebDriver driver;
	protected HomePage homePage;
	protected RegisterPage registerPage;
	protected LoginPage loginPage;
	public ResetPassword resetPassword;
	protected CartPage cartPage;
	protected CheckoutPage checkoutPage;

	public Faker faker;
	
	@BeforeTest
	public void loadSettings() {
		Log.info("Loading Base url fo all testing");
	}
	
	@BeforeTest
	public void setud() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.TIME_OUT));
		driver.manage().window().maximize();
		driver.get(Variables.BASE_URL);
		faker=new Faker(new Locale("en-US"));
		homePage =new HomePage(driver);
		registerPage=new RegisterPage(driver);
		loginPage =new LoginPage(driver);
		resetPassword=new ResetPassword(driver);
		cartPage=new CartPage(driver);
		checkoutPage=new CheckoutPage(driver);
	}
	
	@AfterMethod
	public void teardown() {
		Log.info("Closing the driver");
		if(driver!=null) {
			//driver.quit();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}

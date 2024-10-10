package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.magento.logs.Log;

public class HomePage extends BasePage {
	public By CreateanAccount = By.linkText("Create an Account");
	public By SingIn = By.linkText("Sign In");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	public void SelectedOption() {
		Log.info("Selected form for new Account");
		click(CreateanAccount);	
	}
	
	public void SelectedSingIn() {
		Log.info("Selected option of login");
		click(SingIn);
	}
	
}

package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPassword extends BasePage{

	protected By ImputresetPass=By.id("email_address");
	protected By btnReset = By.xpath("//div[@class='primary']/button");
	
	public ResetPassword(WebDriver driver) {
		super(driver);
	}
	
	public void ImputResetPassword(String email) {
		type(ImputresetPass,email);
	}
	
	public void ClickResetPassword() {
		click(btnReset);
	}
	
}

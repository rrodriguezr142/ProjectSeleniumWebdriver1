package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	protected By InputEmail=By.id("email");
	protected By InputPassword=By.id("pass");
	protected By ButtonLogin=By.id("send2");
	protected By LinkForgotPass=By.linkText("Forgot Your Password?"); //By.className("action remind");
	protected By LinkRegister=By.linkText("Create an Account");
	public By logo=By.className("logo");
	public By EspeClaveIncorrecta= By.partialLinkText("Please wait and try again later.");//"//div[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]");
	public String msgClaveIncorrecta="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
	
	//Varible: sin datos
	public By sinCredenciales=By.xpath("//div[contains(text(),A login and a password are required.]");
	public String msgSinCredenciales="A login and a password are required.";
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void crearUsuario() {
		click(LinkRegister);
	}
	
	public void iniciarSesion(String email,String password) {
		type(InputEmail,email);
		type(InputPassword,password);
	}
	
	public void btnIniciarSesion () {
		click(ButtonLogin);
	}
	
	public void ingresarRecPass(){
		click(LinkForgotPass);
	}
	
	public String getSinCredenciales() {
		return text(sinCredenciales);
	}
	
}

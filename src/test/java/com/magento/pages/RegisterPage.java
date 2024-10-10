package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.magento.logs.Log;

public class RegisterPage extends BasePage {
	protected By ImputFirstname = By.id("firstname");
	protected By ImputLastname = By.id("lastname");
	protected By ImputEmail = By.id("email_address");
	protected By ImputPassword=By.id("password");
	protected By ImputRepassword= By.id("password-confirmation");
	protected By ButtonCReateanAccount=By.xpath("//div[@class='primary']/button");
	public By AccountTitle = By.className("base");
	public String expected_Title="My Account";
	
	//Variables-datos obligatorios
	public By AccountTitle2=By.id("email_address-error");
	public String expected_Title2="This is a required field.";
	
	//Variables-Validaciòn de correo
	public By CorreoIncompleto=By.id("email_address-error"); //By.xpath("//div[@class='control']/div");
	public String msgCorreoIcompleto="Please enter a valid email address (Ex: johndoe@domain.com).";
	
	//Variable: contraseña segura
	public By claveSegura=By.id("password-error");
	public String msClaveSegura="Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";
	
	//Varibles: Claveiguales
	public By claveiguales =By.id("password-confirmation-error");
	public String msgClaveiguales="Please enter the same value again.";
	
	//Variables: Correo duplicados
	public By correoDuplicado=By.linkText("click here");
	public String msgCorreoDuplicado="click here";
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	public void createNewAccount(String firstname_, String lastname_, String email_, String password_, String repassword_) {
		//Log.info("Asignando valores a los imput");
		type(ImputFirstname,firstname_);
		type(ImputLastname,lastname_);
		type(ImputEmail,email_);
		type(ImputPassword,password_);
		type(ImputRepassword,repassword_);
	}
	
	
	public void createNewAccountNotmail(String firstname_, String lastname_, String password_, String repassword_) {
		//Log.info("Asignando valores a los imput");
		type(ImputFirstname,firstname_);
		type(ImputLastname,lastname_);
		//type(ImputEmail,email_);
		type(ImputPassword,password_);
		type(ImputRepassword,repassword_);
	}
	
	public void correoIncompleto(String firstname_, String lastname_, String email_, String password_, String repassword_) {
		//Log.info("Asignando valores a los imput");
		type(ImputFirstname,firstname_);
		type(ImputLastname,lastname_);
		type(ImputEmail,email_);
		type(ImputPassword,password_);
		type(ImputRepassword,repassword_);
	}
	
	public void contraseñaSegura(String firstname_, String lastname_, String email_, String password_, String repassword_) {
		//Log.info("Asignando valores a los imput");
		type(ImputFirstname,firstname_);
		type(ImputLastname,lastname_);
		type(ImputEmail,email_);
		type(ImputPassword,password_);
		type(ImputRepassword,repassword_);
	}
	
	public void clavesIguales(String firstname_, String lastname_, String email_, String password_, String repassword_) {
		//Log.info("Asignando valores a los imput");
		type(ImputFirstname,firstname_);
		type(ImputLastname,lastname_);
		type(ImputEmail,email_);
		type(ImputPassword,password_);
		type(ImputRepassword,repassword_);
	}
	
	public void correoDuplicado(String firstname_, String lastname_, String email_, String password_, String repassword_) {
		//Log.info("Asignando valores a los imput");
		type(ImputFirstname,firstname_);
		type(ImputLastname,lastname_);
		type(ImputEmail,email_);
		type(ImputPassword,password_);
		type(ImputRepassword,repassword_);
	}
	
	
	public void clickCReateanAccountButton() {
		//Log.info("Presionar el botín registrar");
		click(ButtonCReateanAccount);
	}
	
	public String getExpectedTitle() {
		return text(AccountTitle);
	}
	
	public String getExpectedTitle2() {
		return text(AccountTitle2);
	}
	
	public String getExpectedmsgEmail() {
		return text(CorreoIncompleto);
	}
	
	public String getContraseñaSegura() {
		return text(claveSegura);
	}
	
	public String getClaveIguales() {
		return text(claveiguales);
	}
	
	public String getCorreoDuplicados() {
		return text(correoDuplicado);
	}
}

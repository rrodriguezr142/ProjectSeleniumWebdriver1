package com.magento.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.lang.reflect.Method;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.magento.logs.Log;

import static com.magento.extentreports.ExtentTestManager.startTest;
@Listeners(com.magento.listeners.CustomListener.class)
public class RegisterTest extends BaseTest{

	Faker faker= new Faker(new Locale("en-US"));
	String email=faker.internet().emailAddress();
	String password=faker.internet().password(8, 10, true, true, true);
	String emailIncompleto="juancrisostomo@gmail";
	String vclavesegura="123654789";
	String vClaveIguales1="A987*ad8*#";
	String vClaveIguales2="A987*ad8*";
	String vCorreoDuplicado="pedroconde@gmail.com";
	
	
	@Test (groups= "Functional", priority=1)
	public  void doRegisterNewAccountRequiredFields(Method method) throws InterruptedException{
		startTest(method.getName(),"doRegisterNewAccountRequiredFields");
		homePage.SelectedOption();
		registerPage.createNewAccount(faker.name().firstName(),faker.name().lastName(), email, password, password);
		registerPage.clickCReateanAccountButton();
		Thread.sleep(1000);
		
		AssertJUnit.assertEquals(registerPage.getExpectedTitle(), registerPage.expected_Title);
		System.out.println("The account has been created whit Email: " + email + " and Password: " + password );
		registerPage.SingOut();
	}

	@Test (groups= {"Functional","Integration"},priority=2)
	public  void doRegisterNewAccountNotmail(Method method) throws InterruptedException{
		startTest(method.getName(),"doRegisterNewAccountNotmail");
		homePage.SelectedOption();
		registerPage.createNewAccountNotmail(faker.name().firstName(),faker.name().lastName(), password, password);
		registerPage.clickCReateanAccountButton();
		Thread.sleep(1000);
		AssertJUnit.assertEquals(registerPage.getExpectedTitle2(), registerPage.expected_Title2);
		System.out.println("mensaje de la pagina: " + registerPage.getExpectedTitle2());
		System.out.println("mensaje esperado: " + registerPage.expected_Title2);
	}
	
	@Test (groups= {"Functional","Regression"},priority=3)
	public  void validacionCorreo(Method method) throws InterruptedException{
		startTest(method.getName(),"validacionCorreo");
		homePage.SelectedOption();
		registerPage.correoIncompleto(faker.name().firstName(),faker.name().lastName(),emailIncompleto, password, password);
		registerPage.clickCReateanAccountButton();
		Thread.sleep(1000);
		
		AssertJUnit.assertEquals(registerPage.getExpectedmsgEmail(), registerPage.msgCorreoIcompleto);
		System.out.println("mensaje de la pagina: " + registerPage.getExpectedmsgEmail());
		System.out.println("mensaje esperado: " + registerPage.msgCorreoIcompleto);
	}
	
	@Test (groups= "Regression",priority=4)
	public  void validacionclaveSegura(Method method) throws InterruptedException{
		startTest(method.getName(),"validacionclaveSegura");
		homePage.SelectedOption();
		registerPage.contraseñaSegura(faker.name().firstName(),faker.name().lastName(),email,vclavesegura, vclavesegura);
		registerPage.clickCReateanAccountButton();
		Thread.sleep(1000);
		AssertJUnit.assertEquals(registerPage.getContraseñaSegura(), registerPage.msClaveSegura);
		System.out.println("mensaje de la pagina: " + registerPage.getContraseñaSegura());
		System.out.println("mensaje esperado: " + registerPage.msClaveSegura);
	}
	
	@Test (groups= {"Functional","Integration"},priority=5)
	public  void validacionclaveiguales(Method method) throws InterruptedException{
		startTest(method.getName(),"validacionclaveiguales");
		homePage.SelectedOption();
		registerPage.clavesIguales(faker.name().firstName(),faker.name().lastName(),email,vClaveIguales1, vClaveIguales2);
		registerPage.clickCReateanAccountButton();
		Thread.sleep(1000);
		AssertJUnit.assertEquals(registerPage.getClaveIguales(), registerPage.msgClaveiguales);
		System.out.println("mensaje de la pagina: " + registerPage.getClaveIguales());
		System.out.println("mensaje esperado: " + registerPage.msgClaveiguales);
	}
	
	@Test (groups="Integration",priority=6)
	public  void validacionCorreoDuplicado(Method method) throws InterruptedException{
		startTest(method.getName(),"validacionCorreoDuplicado");
		homePage.SelectedOption();
		registerPage.correoDuplicado(faker.name().firstName(),faker.name().lastName(),vCorreoDuplicado,password, password);
		registerPage.clickCReateanAccountButton();
		Thread.sleep(1000);
		AssertJUnit.assertEquals(registerPage.getCorreoDuplicados(), registerPage.msgCorreoDuplicado);
		System.out.println("mensaje de la pagina: " + registerPage.getCorreoDuplicados());
		System.out.println("mensaje esperado: " + registerPage.msgCorreoDuplicado);
	}
}

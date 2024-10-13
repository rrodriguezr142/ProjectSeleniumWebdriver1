package com.magento.tests;

import static com.magento.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.magento.pages.LoginPage;
//@Listeners(com.magento.listeners.CustomListener.class)

public class LoginTest extends BaseTest {
	
	@Test(groups={"Regression","Integration"},priority=1)
	public void inicioSesionCredCorrectos (Method method) throws InterruptedException{
		startTest(method.getName(),"inicioSesionCredCorrectos");
		homePage.SelectedSingIn();
		loginPage.iniciarSesion("pedroroja@gmail.com", "ASD712*142+");
		loginPage.btnIniciarSesion();
		
		Thread.sleep(1000);
		Assert.assertTrue(loginPage.isDisplayed(loginPage.logo));
		System.out.println("Inicio de sesión correcto.");
		loginPage.SingOutLogin();
		
	}
	
	@Test(groups="Functional",priority=2, dataProvider="dp-invalid-pass")
	public void inicioSesionCredInCorrectos (Method method, String email, String password) throws InterruptedException{
		startTest(method.getName(),"inicioSesionCredInCorrectos");
		homePage.SelectedSingIn();
		loginPage.iniciarSesion(email, password);
		loginPage.btnIniciarSesion();
		Thread.sleep(1000);
		
		//Assert.assertTrue(loginPage.isDisplayed(loginPage.EspeClaveIncorrecta));
		//AssertJUnit.assertEquals(LoginPage.getClaveIncorrecta(), false);
		//Assert.assertEquals(loginPage.EspeClaveIncorrecta, loginPage.msgClaveIncorrecta);
		System.out.println("Mensaje con clave incorrecta: " + loginPage.msgClaveIncorrecta);
	}
	
	@DataProvider(name="dp-invalid-pass")
	public Object[][] passInvalido() {
		return new Object [][] {
			{"pedroroja@gmail.com","ASD712*14"}
		};
	}
	
	@Test(groups="Functional",priority=3)
	public void inicioSesionSinCredenciales (Method method) throws InterruptedException{
		startTest(method.getName(),"inicioSesionSinCredenciales");
		homePage.SelectedSingIn();
		loginPage.iniciarSesion("", "");
		loginPage.btnIniciarSesion();
		Thread.sleep(1000);
		
		//Assert.assertEquals(loginPage.getSinCredenciales(), loginPage.msgSinCredenciales);
		System.out.println("Msg campos obligatorio: " + loginPage.msgSinCredenciales);
	}
	
	@Test(groups="Regression",priority=4)
	public void inicioSesionEmailNoRegistrado(Method method) throws InterruptedException{
		startTest(method.getName(),"inicioSesionEmailNoRegistrado");
		homePage.SelectedSingIn();
		loginPage.iniciarSesion("jessel@gmail.com", "ASD712*142+");
		loginPage.btnIniciarSesion();
		Thread.sleep(1000);
		
		//Assert.assertEquals(loginPage.getSinCredenciales(), loginPage.msgSinCredenciales);
		System.out.println("Email no registrado.");
	}
	
	@Test(groups= {"Functional","Integration"},priority=5)
	public void inicioSesionResetearClave (Method method) throws InterruptedException{
		startTest(method.getName(),"inicioSesionResetearClave");
		homePage.SelectedSingIn();
		loginPage.ingresarRecPass();
		//resetPassword.ImputResetPassword("juancenturion@gmail.com");
		//resetPassword.ClickResetPassword();
		homePage.SelectedSingIn();
		Thread.sleep(1000);
		
		//Assert.assertEquals(loginPage.getSinCredenciales(), loginPage.msgSinCredenciales);
		System.out.println("Clave reseteada");
	}
}

package com.magento.tests;

import static com.magento.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
	
	@Test (priority=1, groups="Regression")
	public void agregarProductosalCarrito (Method method) throws Exception{
		startTest(method.getName(),"agregarProductosalCarrito");
		homePage.SelectedSingIn();
		loginPage.iniciarSesion("leoramirez@hotmail.com", "AXD789*/875as");
		loginPage.btnIniciarSesion();
		cartPage.searchIntems(cartPage.name_Product_1);
		cartPage.selectedItems();
		cartPage.customizaItems(1);
		cartPage.addQtyRandon();
		cartPage.addToCard();
		//cartPage.addToCard();
		//cartPage.clickAddToCard();
		Assert.assertEquals(cartPage.AssertAddToCard(), cartPage.msgArtAdd);
		Thread.sleep(1000);
	}
	
	@Test (priority=2, groups="Regression")
	public void EliminarProductosdelCarrito (Method method) throws Exception{
		startTest(method.getName(),"EliminarProductosdelCarrito");
		homePage.SelectedSingIn();
		loginPage.iniciarSesion("carlosramirez@hotmail.com", "AXD789*/875as");
		loginPage.btnIniciarSesion();
		cartPage.searchIntems(cartPage.name_Product_1);
		cartPage.selectedItems();
		cartPage.customizaItems(1);
		cartPage.addQtyRandon();
		cartPage.addToCard();
		cartPage.searchIntems(cartPage.name_Product_2);
		cartPage.selectedItems();
		cartPage.customizaItems(2);
		cartPage.addQtyRandon();
		cartPage.addToCard();
		cartPage.clickShowCart();
		cartPage.clickRemoveItem();
		cartPage.clickacceptRemove();
		cartPage.clickGoToCart();
		Assert.assertEquals(cartPage.AssertRemove(), cartPage.msgremove);
		Thread.sleep(1000);
	}
	
	@Test (priority=3, groups={"Functional","Integration"})
	public void ModCantProductosdelCarrito (Method method) throws Exception{
		startTest(method.getName(),"ModCantProductosdelCarrito");
		homePage.SelectedSingIn();
		loginPage.iniciarSesion("carlosramirez@hotmail.com", "AXD789*/875as");
		loginPage.btnIniciarSesion();
		cartPage.searchIntems(cartPage.name_Product_1);
		cartPage.selectedItems();
		cartPage.customizaItems(1);
		cartPage.addQtyRandon();
		cartPage.addToCard();
		cartPage.searchIntems(cartPage.name_Product_2);
		cartPage.selectedItems();
		cartPage.customizaItems(2);
		cartPage.addQtyRandon();
		cartPage.addToCard();
		cartPage.clickShowCart();
		cartPage.clickGoToCart();
		cartPage.modQtyRandon();
		Assert.assertEquals(cartPage.AssertRemove(), cartPage.msgremove);
		Thread.sleep(1000);
	}
	
	@Test (priority=4, groups="Regression")
	public void checkout (Method method) throws Exception{
		startTest(method.getName(),"ModCantProductosdelCarrito");
		homePage.SelectedSingIn();
		loginPage.iniciarSesion("carlosramirez@hotmail.com", "AXD789*/875as");
		loginPage.btnIniciarSesion();
		cartPage.searchIntems(cartPage.name_Product_1);
		cartPage.selectedItems();
		cartPage.customizaItems(1);
		cartPage.addQtyRandon();
		cartPage.addToCard();
		cartPage.searchIntems(cartPage.name_Product_2);
		cartPage.selectedItems();
		cartPage.customizaItems(2);
		cartPage.addQtyRandon();
		cartPage.addToCard();
		cartPage.searchIntems(cartPage.name_Product_3);
		cartPage.selectedItems();
		cartPage.customizaItems(3);
		cartPage.addQtyRandon();
		cartPage.addToCard();
		cartPage.clickShowCart();
		cartPage.clickGoToCart();
		cartPage.clickBtnCheckout();
		checkoutPage.fillshippingAddres("ADESY", "AV. SOL NACIENTE 132", "Lima", "18", faker.address().zipCodeByState("FL"), "US", "991352686");
		checkoutPage.chooseShippingMethods();
		checkoutPage.goToBtnNext();
		checkoutPage.clickCheckBilling();
		checkoutPage.goToPlaceOrder();
		Assert.assertEquals(checkoutPage.AssertOrdenComplete(), checkoutPage.msgOrdenComplete);
		Thread.sleep(1000);
	}
}

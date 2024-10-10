package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

	//protected By inputfirstName=By.name("firstname");
	//protected By inputlastName=By.name("lastname");
	protected By inputcompany=By.name("company");
	protected By inputstreet=By.name("street[0]");
	protected By inputCity=By.name("city");
	protected By cbccity=By.name("region_id");//By.xpath("//select[@class='select']//option[@value=1]");
	protected By inputPostCode=By.name("postcode");
	protected By cbcCountry=By.name("country_id");//By.xpath("//select[@class='select']//option[@value=US]");
	protected By inputTelephone=By.name("telephone");
	protected By radioShipMethods=By.id("checkout-shipping-method-load");//By.xpath("//td[@class='col col-method']/input[@value=tablerate_bestway]");
	protected By radioShipMethod=By.name("ko_unique_1");//By.xpath("//table[@class='table-checkout-shipping-method']/tbody/tr/td/input[value='tablerate_bestway']");//By.name("ko_unique_1");
	protected By btnNext=By.xpath("//div[@class='primary']/button/span[contains(text(),'Next')]");//By.xpath("//div[@class='actions-toolbar']/div/button");;
	protected By btnPlaceOrder=By.xpath("//div[@class='primary']/button/span[contains(text(),'Place Order')]");//By.xpath("//div[@class='actions-toolbar']/div/button");//By.xpath("//div[@class='primary']/button");
	protected By checkBilling=By.xpath("//div[@class='billing-address-same-as-shipping-block field choice']/input");
	
	protected By OrdenComplete= By.xpath("//div[@class='page-title-wrapper']/h1/span[contains(text(),'Thank you for your purchase!')]");
    public String msgOrdenComplete="Thank you for your purchase!";
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void fillshippingAddres( String company, String address, String city, String province, String postalcode, String country, String phone ) { //String firstname,String lastname,
		//type(inputfirstName,firstname);
		//type(inputlastName,lastname);
		type(inputcompany,company);
		type(inputstreet,address);
		type(inputCity,city);
		selectByValue(cbccity,province);
		type(inputPostCode,postalcode);
		selectByValue(cbcCountry,country);
		type(inputTelephone,phone);
	}
	
	public void chooseShippingMethods() {
		if (isDisplayed(radioShipMethods)) {
		click(radioShipMethod);
		}
	}
	
	public void goToBtnNext() {
		click(btnNext);
	}
	
	public void goToPlaceOrder() {
		goOutofIframe();
		click(btnPlaceOrder);
	}
	
	public void clickCheckBilling() {
		click(checkBilling);
	}
	
	public String AssertOrdenComplete() {
		return text(OrdenComplete);
	}

}

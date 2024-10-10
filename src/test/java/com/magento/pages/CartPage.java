package com.magento.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
	
	protected By InputSearch=By.name("q");
	protected By LinkItemSearch=By.xpath("//div[@class='search results']/div/ol/li/div/a");
	protected By qtyProduct = By.name("qty");
	//primer producto
	protected By sizeM =By.xpath("//div[@class='swatch-attribute-options clearfix']/div[text()='M']");
	protected By sizeMSelected = By.xpath("//spam[@class='swatch-attribute-selected-option']");
	protected By colorBlack =By.id("option-label-color-93-item-49");
	protected By colorBlackSelected=By.id("option-label-color-93-item-49");
	//segundo producto
	protected By sizeS =By.xpath("//div[@class='swatch-attribute-options clearfix']/div[text()='S']");
	protected By sizeSSelected = By.xpath("//spam[@class='swatch-attribute-selected-option']");
	protected By colorRed =By.id("option-label-color-93-item-58");
	protected By colorRedSelected=By.id("option-label-color-93-item-58");
	//Terce Producto
	protected By sizeL =By.xpath("//div[@class='swatch-attribute-options clearfix']/div[text()='L']");
	protected By sizeLSelected = By.xpath("//spam[@class='swatch-attribute-selected-option']");
	protected By colorYellow =By.id("option-label-color-93-item-60");
	protected By colorYellowSelected=By.id("option-label-color-93-item-60");
	//eliminar producto
	protected By showcart =By.xpath("//div[@class='minicart-wrapper']/a");
	protected By removeItem=By.xpath("//div[@class='secondary']/a");
	protected By acceptRemove=By.xpath("//button[@class='action-primary action-accept']");
	
	//modificar cantidad
	protected By cant=By.xpath("//div[@class='control qty']/label/input");
	
	protected By goToCart=By.xpath("//a[@class='action viewcart']");
	
	protected By addToCardbtn = By.id("product-addtocart-button");//By.xpath("//div[@class='actions']/button");
	protected By clickToCardbtn = By.id("product-addtocart-button");//By.xpath("//div[@class='actions']/button");
	protected By btncheckout=By.xpath("//div[@class='cart-summary']/ul/li/button");
	
	public String name_Product_1 = "Proteus Fitness Jackshirt";
    public String name_Product_2 = "Erikssen CoolTech™ Fitness Tank";
    public String name_Product_3 = "Aero Daily Fitness Tee";
    protected int qtyRandom;
    
    protected By artAdd=By.xpath("//div/a[contains(text(),'shopping cart')]");
    public String msgArtAdd="shopping cart";
    
    protected By remove= By.xpath("//div[@class='page-title-wrapper']/h1/span");
    public String msgremove="Shopping Cart";

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void searchIntems(String product) {
		typeAndEnter(InputSearch,product);
	}
	
	
	public void selectedItems () {
		click(LinkItemSearch);
	}
	
	public void addQtyRandon() {
		Random rn=new Random();
		qtyRandom=rn.nextInt(5)+1;
		find(qtyProduct).clear();
		type(qtyProduct,Integer.toString(qtyRandom));
	}
	
	public void customizaItems(int number) {
		if(number==1) {
			click(sizeM);
			isSelectedCustomItems(sizeMSelected);
			click(colorBlack);
			isSelectedCustomItems(colorBlackSelected);
		}else if(number==2){
			click(sizeS);
			isSelectedCustomItems(sizeSSelected);
			click(colorRed);
			isSelectedCustomItems(colorRedSelected);
		}
		else if(number==3){
			click(sizeL);
			isSelectedCustomItems(sizeLSelected);
			click(colorYellow);
			isSelectedCustomItems(colorYellowSelected);
		}
	}
	
	public void addToCard() {
		submit(addToCardbtn);
	}
	
	public void clickAddToCard() {
		click(clickToCardbtn);
	}
	
	public String AssertAddToCard() {
		return text(artAdd);
	}
	
	public void clickShowCart() {
		click(showcart);
	}
	
	public void clickRemoveItem() {
		click(removeItem);
	}
	
	public void clickacceptRemove() {
		click(acceptRemove);
	}
	
	public void clickGoToCart() {
		click(goToCart);
	}
	
	public String AssertRemove() {
		return text(remove);
	}
	
	public void modQtyRandon() {
		Random rn=new Random();
		qtyRandom=rn.nextInt(5)+1;
		find(cant).clear();
		type(cant,Integer.toString(qtyRandom));
	}
	
	public void clickBtnCheckout() {
		click(btncheckout);
	}
}

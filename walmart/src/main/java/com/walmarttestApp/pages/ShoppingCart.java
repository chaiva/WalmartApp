package com.walmarttestApp.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;

public class ShoppingCart extends TestBase {

	@FindBy(xpath = "//div[@id = 'cart-summary']/div/div[3]/div/a")
	WebElement checkoutbtn;

	@FindBy(xpath = "//div[@class = 'product-content']/div/div/descendant::a[@class = 'cart-product-title']")
	List<WebElement> cartprodtitle;

	@FindBy(xpath = "//div[@class = 'product-content']/div/div/descendant::button[@class = 'more button-list']")
	List<WebElement> moreqtybtn;

	@FindBy(xpath = "//div[@class = 'product-content']/div/div/descendant::button[@class = 'less button-list']")
	List<WebElement> lessqtybtn;

	@FindBy(xpath = "//div[@class = 'product-content']/div/div/descendant::button[@class = 'button-text-like remove-button']")
	List<WebElement> removebtn;
	
	@FindBy(xpath = "//ul[@class ='cart-products-list clearfix']/li/div/descendant::input[@id= 'qty-input-0']")
	List<WebElement> qtyval;
	
	/*@FindBy(xpath = "//div[@id = 'cart-summary']/div/descendant::a[@id = 'cart-aside-checkout-btn']")
	WebElement checkoutbtn;*/

	public ShoppingCart() {
		PageFactory.initElements(driver, this);
	}

	public void removeproduct(String brandname) {
		int cnt = cartprodtitle.size();
		for (int i = 0; i < cnt; i++) {
			String txt = cartprodtitle.get(i).getText();
			System.out.println(txt);
			if (txt.equalsIgnoreCase(brandname)) {
				ScrollIntoView(cartprodtitle.get(i), driver);
				removebtn.get(i).click();
				break;
			}
		}

	}

	public void increaseproductqnty(String brandname, int qty) {
		int j = 0;
		int cnt = cartprodtitle.size();
		for (int i = 0; i < cnt; i++) {
			String txt = cartprodtitle.get(i).getText();
			System.out.println(txt);
			if (txt.equalsIgnoreCase(brandname)) {
				ScrollIntoView(cartprodtitle.get(i), driver);
				if (j < qty) {
					moreqtybtn.get(i).click();
					j++;
				}
				break;
			}

		}
	}
	
	public void decreaseproductqnty(String brandname,int qty)
	{
		int j = 0;
		int cnt = cartprodtitle.size();
		for (int i = 0; i < cnt; i++) {
			String txt = cartprodtitle.get(i).getText();
			System.out.println(txt);
			if (txt.equalsIgnoreCase(brandname)) {
				ScrollIntoView(cartprodtitle.get(i), driver);
				String c = qtyval.get(i).getText();
				j =Integer.parseInt(c);		
				if (j > qty) {
					lessqtybtn.get(i).click();
					j++;
					break;
				}
			}

		}
	}
	
	public CheckoutPage clickoncheckoutbtn()
	{
		ScrollIntoView(checkoutbtn, driver);
		clickOn(driver, checkoutbtn, 30);
		return new CheckoutPage();
	}

}

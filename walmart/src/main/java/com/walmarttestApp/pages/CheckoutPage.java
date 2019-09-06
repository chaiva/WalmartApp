package com.walmarttestApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;

public class CheckoutPage extends TestBase {
	
	@FindBy(xpath = "//div[@class = 'cart-content']/div/div/div/button[@class = 'link-button']")
	WebElement editshippingdetails;
	
	@FindBy(xpath = "//div[@class = 'cart-content']/div/div/button[@class = 'button-outline wgrid-2w6 wgrid-4w4 marg-lr-0 marg-t-1unit marg-b-1unit float-r']")
	WebElement showitemsbtn;
	
	@FindBy(xpath = "//div[@id = 'credit-card-container']/button[text() = 'Edit card']")
	WebElement Editcardbtn;
	
	@FindBy(xpath = "//div[@class ='cart-total-summary']/div/descendant::a[@id = 'cart-edit']")
	WebElement ViewCartlnk;
	
	@FindBy(xpath = "//div[@class ='cart-content']/div/div/button[@class ='button-outline wgrid-2w6 wgrid-4w4 marg-lr-0 marg-t-1unit marg-b-1unit float-r']")
	WebElement hideitemsbtn;
	
	@FindBy(xpath = "//button[@id ='checkout-step4-applyCC']")
	WebElement applybtn;
	
	@FindBy(xpath = "//div/button[@class ='wgrid-3w6 wgrid-2w4 marg-lr-0 float-r button-action add-new-button']")
	WebElement addnewcrd;
	public CheckoutPage()
	{
		PageFactory.initElements(driver, this);
	}

}

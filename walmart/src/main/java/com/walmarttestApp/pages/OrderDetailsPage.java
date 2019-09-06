package com.walmarttestApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.walmarttestApp.Base.TestBase;

public class OrderDetailsPage extends TestBase {

	@FindBy(xpath = "//span[@id = 'orderId']")
	WebElement orderdetails;
	
	@FindBy(xpath = "//section[@id = 'order-details-container']/div/ul/li/em")
	WebElement orderdate;
	
	@FindBy(xpath = "//*[@id=\"shipping-payment-section\"]/div[3]/span/a")
	WebElement Trackshipmentlnk;
	
	public OrderDetailsPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	public String verifypageTitle()
	{
		return driver.getTitle();
	}
	public String getOrderDetailid()
	{
		return orderdetails.getText();
	}
	
	public String getOrderDateinDetails()
	{
		return orderdate.getText();
	}
	
	public void trackshipment()
	{
		clickOn(driver, Trackshipmentlnk, 15);
	}
	public static void clickOn(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}

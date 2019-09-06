package com.walmarttestApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.walmarttestApp.Base.TestBase;

public class OrderHistory extends TestBase {
	
	@FindBy(xpath = "//select[@id = 'past-orders-by-date']")
	WebElement viewordersfrmlnk;
	
	@FindBy(xpath = "//section[@id = 'order-details-container']/div/dl/div[1]/dd")
	WebElement Orderdate;
	
	@FindBy(xpath = "//section[@id = 'order-details-container']/div/dl/div[3]/dd")
	WebElement Orderno;
	
	@FindBy(xpath = "//section[@id = 'order-details-container']/div/a")
	WebElement ManageOrderlnk;
	
	@FindBy(xpath = "//div[@class = 'track-order']/a")
	WebElement trackorderlnk;
	
	
	public OrderHistory()
	{
		PageFactory.initElements(driver, this);
	}
	public String getOrderNum()
	{
		return Orderno.getText();
	}
	
	public String getOrderDate()
	{
		return Orderdate.getText();
	}
	public OrderDetailsPage selectandmanageorder(String orderdate )
	{
		Select s = new Select(viewordersfrmlnk);
		s.selectByVisibleText(orderdate);
		clickOn(driver,ManageOrderlnk,15);
		return new OrderDetailsPage();
	}
	public void trackorder()
	{
		clickOn(driver,trackorderlnk,15);
	}
	
	public static void clickOn(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}


}

package com.walmarttestApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;
import com.walmarttestApp.clothing.ClothingshoeandAccessoriesPage;

public class HomePage extends TestBase {
	Actions a = new Actions(driver);
	
	@FindBy(xpath = "//input[@id = 'global-search']")
	WebElement searchbox;
	
	@FindBy(xpath = "//span[@id ='account-menu-signin-msg']")
	WebElement MyAccntdrpdwn;
	
	@FindBy(xpath = "//span[@id = 'header-dept-btn-desktop']")
	WebElement departmentslnk;
	
	@FindBy(xpath = "//a[text() = 'Patio']/parent::li[@id = 'header-patio']")
	WebElement patiolnk;
	
	@FindBy(xpath = "//a[text() = 'BBQs']/parent::li[@id = 'header-bbqs']")
	WebElement BBQslnk;
	
	@FindBy(xpath = "//a[text() = 'Electronics']/parent::li[@id = 'header-electronics']")
	WebElement electronicslnk;
	
	@FindBy(xpath = "//a[text() = 'Clothing']/parent::li[@id = 'header-clothing']")
	WebElement clothinglnk;
	
	@FindBy(xpath = "//a[text() = 'Toys']/parent::li[@id = 'header-toys']")
	WebElement toys;
	
	@FindBy(xpath = "//a[text() = 'Baby']/parent::li[@id = 'header-baby']")
	WebElement babylnk;
	
	@FindBy(xpath = "//span[@id = 'hdr-grocery-toggle-desktop-txt']")
	WebElement shopgrocerieslnk;
	
	@FindBy(xpath = "//a[text() = 'Store Finder']/parent::li[@id = 'header-store-finder']")
	WebElement storeFinderlnk;
	
	@FindBy(xpath = "//a[text() = 'Flyers']/parent::li[@id = 'header-flyers']")
	WebElement flyerslnk;
	
	@FindBy(xpath = "//a[@id = 'header-my-orders-desktop']")
	WebElement MyOrderslnk;
	
	@FindBy(xpath = "//a[@id = 'nav-cart']")
	WebElement MyCartlnk;
	
	@FindBy(xpath = "//span[@id = 'hdr-begin-search']/parent::button[@type = 'submit']")
	WebElement searchbtn;
	
	/*@FindBy(xpath = "//span[@class = 'tt-dropdown-menu']//div[@class = 'tt-dataset-results']")
	WebElement suggestionbox;*/
	
	//====================left menu elements==================================
	
	@FindBy(xpath = "//ol[@id = 'nav-wrap-simplified-desktop']/li[5]/h2/a")
	WebElement l_electronicslnk;
	
	@FindBy(xpath = "//ol[@id = 'nav-wrap-simplified-desktop']/li[5]/div/div/div[3]/div/a")
	WebElement l_ipadnadtab;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OrderHistory clickonMyOrderslnk()
	{
		
		try
		{
		a.moveToElement(MyAccntdrpdwn).build().perform();
		MyOrderslnk.click();
		}
		catch (Exception e) {

		}
		return new OrderHistory();
	}
	
	public ClothingshoeandAccessoriesPage clickonClothing()
	{
		//a.moveToElement(clothinglnk).click().build().perform();
		clickOn(driver, clothinglnk, 20);
		clothinglnk.click();
		return new ClothingshoeandAccessoriesPage();
	
	}
	
	public ipadandTabPage clickonIpadlink()
	{
		a.moveToElement(departmentslnk).build().perform();
		WaitElement(driver, l_electronicslnk, 15);
		a.moveToElement(l_electronicslnk).build().perform();
		WaitElement(driver, l_ipadnadtab, 15);
		a.moveToElement(l_ipadnadtab).click().build().perform();
		return new ipadandTabPage();
	}
	
	public Searchproductlistspage searchproduct(String inputName,String productname) throws InterruptedException
	{

		int i = 0;;
		searchbox.sendKeys(inputName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"global-search\").value;";
		String text = (String) js.executeScript(script);
		while (!text.equalsIgnoreCase(productname)) {
			i++;
			Thread.sleep(2000);
			searchbox.sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			System.out.println(text);
			if (i > 10) {
				break;
			}
		}

		if (i > 10) {
			System.out.println("Element not found");
		} else {
			//Thread.sleep(5000);
			searchbox.sendKeys(Keys.ENTER);
			

	}
		
	return new 	Searchproductlistspage();
	}
	
}

package com.walmarttestApp.clothing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;
import com.walmarttestApp.pages.ShoppingCart;

public class pantsandcaprispage extends TestBase {
	Actions a = new Actions(driver);

	@FindBy(xpath = "//div[@id = 'shelf-thumbs']/div/descendant::div[@class = 'title']")
	List<WebElement> capriandpants;

	@FindBy(xpath = "//div[@id = 'shelf-thumbs']/div/descendant::span[@class = 'btn-txt']")
	List<WebElement> addtocartbutnlst;

	@FindBy(xpath = "//div[@id = 'shelf-thumbs']/div/descendant::div[@class = 'swatches']")
	List<WebElement> prodcolorlst;

	@FindBy(xpath = "//a[text() = 'Price']")
	WebElement pricesort;

	@FindBy(xpath = "//input[@id = 'chk-length-ref-2']/parent::a")
	WebElement capriandcroppedcheck;

	@FindBy(xpath = "//div[@class='wgrid-3w6 wgrid-4w4 marg-l-0']/descendant::button[@class = 'button add-to-cart-btn available']")
	WebElement coloraddbtn;

	@FindBy(xpath = "//ul[@id = 'ac-details']/descendant::button[@class ='less button-list']")
	WebElement lessbtn;

	@FindBy(xpath = "//ul[@id = 'ac-details']/descendant::button[@class ='more button-list']")
	WebElement morebtn;

	@FindBy(xpath = "//div[@class ='lightbox lightbox-with-close addCart-Lightbox add-cart-confirmation']/descendant::a[@class = 'button']")
	WebElement checkout;
	
	@FindBy(xpath = "//div[@id = 'product-purchase-cartridge']/div[3]/descendant::div[@class = 'wgrid-3w6 wgrid-4w4 marg-l-0']/button[@class = 'button add-to-cart-btn available' and @aria-label='available, Add to cart']")
	WebElement noncoloraddbtn;

	public pantsandcaprispage() {
		PageFactory.initElements(driver, this);
	}

	public int pantsandcapricount() throws Exception {
		WaitElement(driver, pricesort, 10);
		pricesort.click();
		ScrollPageDown(driver);
		if (capriandpants.size() < 1) {
			System.out.println("No pants or capri available");
			throw new Exception("No pants availabe");
		}
		System.out.println(capriandpants.size());
		return capriandpants.size();
	}

	public ShoppingCart selectcapripant(String brandname) {
		ScrollIntoView(capriandcroppedcheck, driver);
		try {
			Thread.sleep(5000);
			/*
			 * if(surveypopup.isDisplayed()) {
			 * a.moveToElement(surveypopup).build().perform(); closebtn.click(); }
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WaitElement(driver, capriandcroppedcheck, 20);
		capriandcroppedcheck.click();
        //WaitListElement(driver, capriandpants,15);
		try {
			Thread.sleep(5000);
			/*
			 * if(surveypopup.isDisplayed()) {
			 * a.moveToElement(surveypopup).build().perform(); closebtn.click(); }
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = capriandpants.size();
		for (int i = 0; i <count; i++) {

			String txt = capriandpants.get(i).getAttribute("aria-label");
			System.out.println(txt);
			if (txt.equalsIgnoreCase(brandname)) {
				ScrollIntoView(capriandpants.get(i), driver);
				//a.moveToElement(capriandpants.get(i)).build().perform();
				//WaitElement(driver, prodcolorlst.get(i), 15);
				//String xpathName = "//div[@aria-label='" + brandname + "']";
				String xpathName = "//div[@aria-label=\""+ brandname +"\"]";
				String swatchxpath = "/parent::div/parent::div/parent::a/following-sibling::div[@class ='swatches']";
				List<WebElement>swatchesXpath = driver.findElements(By.xpath(xpathName+swatchxpath));
				if((swatchesXpath.size())>0) {

					clickOn(driver, addtocartbutnlst.get(i), 15);
					driver.switchTo().activeElement();
					ScrollIntoView(coloraddbtn, driver);
					clickOn(driver, coloraddbtn, 15);
					driver.switchTo().activeElement();
					clickOn(driver, morebtn, 15);
					clickOn(driver, checkout, 15);
					break;
				} else {
					clickOn(driver, addtocartbutnlst.get(i), 15);
					driver.switchTo().activeElement();
					clickOn(driver, noncoloraddbtn, 15);
					driver.switchTo().activeElement();
					clickOn(driver, checkout, 15);
					break;
				}

			}

		}

		return new ShoppingCart();
	}
}

package com.walmarttestApp.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;

public class Searchproductlistspage extends TestBase {
	Actions a = new Actions(driver);

	@FindBy(xpath = "//div[@id = 'shelf-thumbs']/div/descendant::div[@class = 'title']")
	List<WebElement> prodlist;

	@FindBy(xpath = "//div[@id = 'shelf-thumbs']/div/descendant::span[@class = 'btn-txt']")
	List<WebElement> addtocartbutnlst;

	@FindBy(xpath = "//div[@id = 'shelf-thumbs']/div/descendant::div[@class = 'swatches']")
	List<WebElement> prodcolorlst;

	@FindBy(xpath = "//div[@class='wgrid-3w6 wgrid-4w4 marg-l-0']/descendant::button[@class = 'button add-to-cart-btn available']")
	WebElement coloraddbtn;

	@FindBy(xpath = "//ul[@id = 'ac-details']/descendant::button[@class ='less button-list']")
	WebElement lessbtn;

	@FindBy(xpath = "//ul[@id = 'ac-details']/descendant::button[@class ='more button-list']")
	WebElement morebtn;

	@FindBy(xpath = "//div[@class ='lightbox lightbox-with-close addCart-Lightbox add-cart-confirmation']/descendant::li[@id = 'ac-name']")
	WebElement prodtitle;

	@FindBy(xpath = "//div[@class ='lightbox lightbox-with-close addCart-Lightbox add-cart-confirmation']/descendant::a[@class = 'button']")
	WebElement checkout;

	@FindBy(xpath = "//div[@id = 'actualcolor']")
	WebElement prodcolors;

	public Searchproductlistspage() {
		PageFactory.initElements(driver, this);
	}
	/*
	 * public boolean isElementPresent(By by) { try { driver.findElement(by); return
	 * true; } catch (org.openqa.selenium.NoSuchElementException e) { return false;
	 * } }
	 */

	public ShoppingCart searchparticularproduct(String brandname) {
		int cnt = prodlist.size();
		for (int i = 0; i < cnt; i++) {
			String txt = prodlist.get(i).getAttribute("aria-label");
			System.out.println(txt);
			if (txt.equalsIgnoreCase(brandname)) {
				ScrollIntoView(prodlist.get(i), driver);
				WaitElement(driver, prodcolorlst.get(i), 15);
				String xpathName = "//div[@aria-label='" + brandname + "']";
				String swatchxpath = "/parent::div/parent::div/parent::a/following-sibling::div[@class ='swatches']";
				List<WebElement>swatchesXpath = driver.findElements(By.xpath(xpathName+swatchxpath));
				if((swatchesXpath.size())>0)
				{
					clickOn(driver, addtocartbutnlst.get(i), 15);
					driver.switchTo().activeElement();

					coloraddbtn.click();
					driver.switchTo().activeElement();
					morebtn.click();
					checkout.click();
					break;
				}
				else
				{
					clickOn(driver, addtocartbutnlst.get(i), 15);
					driver.switchTo().activeElement();
					checkout.click();
					break;
				}

			}

		}

		return new ShoppingCart();
	}
}

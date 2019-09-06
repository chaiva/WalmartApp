package com.walmarttestApp.clothing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;

public class Womenshoppingpage extends TestBase {
	//Actions a = new Actions(driver);
	
	@FindBy(xpath = "//div[@id = 'jalapeno-template']/div[2]/div[1]/section/div/a[1]")
	WebElement beachreadylnk;
	
	@FindBy(xpath = "//div[@id = 'jalapeno-template']/div[2]/div[1]/section/div/a[2]")
	WebElement SummerTopslnk;
	
	@FindBy(xpath = "//div[@id = 'jalapeno-template']/div[2]/div[6]/div/div[4]/a/div/span")
	WebElement shoeslnk;
	
	@FindBy(xpath = "//div[@id = 'jalapeno-template']/div[2]/div[6]/div/div[10]/a/div/span")
	WebElement pants_caprislnk;
	
	@FindBy(xpath = "//div[@id='acsMainInvite']")
	WebElement surveypopup;
	
	@FindBy(xpath = "//div[@id='acsMainInvite']/a")
	WebElement closebtn;
	
	
	public Womenshoppingpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public shoespage clickonshoelnk()
	{
		shoeslnk.click();
		return new shoespage();
	}
	public pantsandcaprispage clickonpants_caprislnk()
	{
		try
		{
		     Thread.sleep(5000);
		}catch(InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ScrollIntoView(pants_caprislnk, driver);
		pants_caprislnk.click();
		return new pantsandcaprispage();

	}
	
	
}

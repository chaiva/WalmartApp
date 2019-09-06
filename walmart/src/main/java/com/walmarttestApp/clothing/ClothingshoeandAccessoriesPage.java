package com.walmarttestApp.clothing;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;

public class ClothingshoeandAccessoriesPage extends TestBase {
	
	//Actions a = new Actions(driver);
	
	/*@FindBy(xpath = "//div[@id = 'poblano-template']/div[2]/div[2]/div[4]/div/div/a/div/span")
	WebElement womenlnk;*/
	
	@FindBy(xpath = "//div[@id = 'poblano-template']/div[2]/descendant::span[contains(text(),'Women')]")
	WebElement womenlnk;
	
	@FindBy(xpath ="//div[@id = 'poblano-template']/div[2]/div[2]/div[4]/div/div[2]/a/div/span")
	WebElement  menlnk;
	
	@FindBy(xpath = "//div[@id = 'poblano-template']/div[2]/div[2]/div[4]/div/div[3]/a/div/span")
	WebElement Kids_Babylnk;
	
	@FindBy(xpath = "//div[@id = 'poblano-template']/div[2]/div[2]/div[4]/div/div[4]/a/div/span")
	WebElement shoelnk;
	
	@FindBy(xpath = "//div[@id = 'poblano-template']/div[2]/div[2]/div[4]/div/div[5]/a/div/span")
	WebElement luggagelnk;
	
	@FindBy(xpath = "//div[@id = 'poblano-template']/div[2]/div[2]/div[4]/div/div[6]/a/div/span")
	WebElement  handbagslnk;
	
	@FindBy(xpath = "//div[@id = 'poblano-template']/div[2]/div[2]/div[4]/div/div[7]/a/div/span")
	WebElement jewellerywatcheslnk;
	
	@FindBy(xpath = "//div[@id = 'poblano-template']/div[2]/div[2]/div[4]/div/div[8]/a/div/span")
	WebElement rollbackclearancelnk;
	
	@FindBy(xpath = "//div[@id='acsMainInvite']")
	WebElement surveypopup;
	
	@FindBy(xpath = "//div[@id='acsMainInvite']/a")
	WebElement closebtn;
	
	public ClothingshoeandAccessoriesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Womenshoppingpage clickonWomenlnk()
	{
	ScrollIntoView(womenlnk, driver);
clickOn(driver, womenlnk, 15);		
return new Womenshoppingpage();
	}
	public void clickonmenlnk()
	{
		menlnk.click();
	}
	public void clickonKids_Babylnk()
	{
		Kids_Babylnk.click();
	}
	public void clickonshoelnk()
	{
		shoelnk.click();
	}
	public void clickonluggagelnk()
	{
		luggagelnk.click();
	}
	public void clickonhandbagslnk()
	{
		handbagslnk.click();
	}
	public void clickonjewellerywatcheslnk()
	{
		jewellerywatcheslnk.click();
	}
	public void clickonrollbackclearancelnk()
	{
		rollbackclearancelnk.click();
	}

}

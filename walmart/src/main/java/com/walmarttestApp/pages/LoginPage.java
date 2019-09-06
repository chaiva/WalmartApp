package com.walmarttestApp.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//input[@id ='login-form-email']")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement passwd;

	@FindBy(xpath = "//a[@id ='account-forgot-password']")
	WebElement frgtpwdlnk;
	
	/*@FindBy(xpath = "//button[@id='account-signin-btn' and @type = 'submit']")
	WebElement signinbtn;*/
	
	@FindBy(xpath = "//*[@id='account-signin-btn']")
	WebElement signinbtn;
	
	@FindBy(xpath = "//input[@name = 'email' and @class = 'create-account-email']")
	WebElement createemail;
	
	@FindBy(xpath = "//*[@id='create-account-partial']/div/form/fieldset/button[1]")
	WebElement createAcctBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage Login(String uname,String pwd)
	{
		WaitElement(driver, userName, 15);
		userName.clear();
		userName.sendKeys(uname);
		WaitElement(driver, passwd, 15);
		passwd.sendKeys(pwd);
		//clickOn(driver,signinbtn,30);
		//ScrollPageDown(driver);
		clickOn(driver, signinbtn, 15);
		//signinbtn.click();
		//driver.switchTo().alert().accept();
		return new HomePage();
		
	}
	public boolean isValid(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	}
	public CreateAccount clickonCreateAcctBtn(String emailid)
	{
		createemail.sendKeys(emailid);
		clickOn(driver,createAcctBtn,15);
		//createAcctBtn.click();
		return new CreateAccount();
	}
	
	
}

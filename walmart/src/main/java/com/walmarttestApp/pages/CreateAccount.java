package com.walmarttestApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;

public class CreateAccount extends TestBase {
	
	@FindBy(xpath = "//input[@id ='email']")
	WebElement emailid;
	
	@FindBy(xpath = "//input[@id ='phone']")
	WebElement phone;
	
	@FindBy(xpath = "//input[@id ='firstName']")
	WebElement fname;
	
	@FindBy(xpath = "//input[@id ='lastName']")
	WebElement lname;
	
	@FindBy(xpath = "//input[@id ='password']")
	WebElement passwd;
	
	@FindBy(xpath = "//input[@id ='confirmPassword']")
	WebElement confrmpwd;
	
	@FindBy(xpath ="//input[@id ='tnc']")
	WebElement accptPolicy;
	
	@FindBy(id = "create-account-btn")
	WebElement createmyacctbtn;
	
	public CreateAccount()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createaccount(String e_mail,String phNo,String firstname,String lastname,String pwd,String cpwd)
	{
		emailid.sendKeys(e_mail);
		phone.sendKeys(phNo);
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		passwd.sendKeys(pwd);
		confrmpwd.sendKeys(cpwd);
		accptPolicy.click();
		//createmyacctbtn.click();
	}
	/*public void createacctfrmLogin(String phNo,String firstname,String lastname,String pwd,String cpwd)
	{
		
		String email  = h.createemail.getText();
		emailid.sendKeys(email);
		phone.sendKeys(phNo);
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		passwd.sendKeys(pwd);
		confrmpwd.sendKeys(cpwd);
		accptPolicy.click();
		createmyacctbtn.click();
	}*/

}

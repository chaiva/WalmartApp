package com.walmarttestApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;

public class SigninPage extends TestBase {
	Actions a1 = new Actions(driver);
	//Actions a2 = new Actions(driver);
	
	@FindBy(xpath = "//a[@data-automation ='sign-in-container']")
	WebElement MyAccountdrpdwn;
	
	@FindBy(xpath ="  //button[text() = 'Sign in']")
	WebElement SignInbtn;
	
	@FindBy(xpath = "//a[text() = 'Join Now']")
	WebElement JoinNowlnk;

	public SigninPage()
	{
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickonSignInbtn() {
		try {
			a1.moveToElement(MyAccountdrpdwn).build().perform();
			SignInbtn.click();

		} catch (Exception e) {

		}
		return new LoginPage();
	}
	
	public CreateAccount clickonJoinNowlnk()
	{
		try
		{
			a1.moveToElement(MyAccountdrpdwn).build().perform();
			Thread.sleep(5000);
			JoinNowlnk.click();
		}
		catch(Exception e)
		{
			
		}
		return new CreateAccount();
	}
	
}

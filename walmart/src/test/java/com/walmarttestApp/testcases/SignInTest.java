package com.walmarttestApp.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmarttestApp.Base.TestBase;
import com.walmarttestApp.pages.CreateAccount;
import com.walmarttestApp.pages.LoginPage;
import com.walmarttestApp.pages.SigninPage;
import com.walmarttestApp.util.TestUtil;

public class SignInTest extends TestBase {
	LoginPage loginpage;
	CreateAccount createAccount;
	TestUtil testutil;
	SigninPage signinPage;
	public SignInTest()
	{
		super();
	
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		createAccount = new CreateAccount();
		signinPage = new SigninPage();
		
	}
	@Test
	public void clickonSignInbtntest()
	{
		signinPage.clickonSignInbtn();
	}
	
	@Test
	public void clickonJoinNowlnktest()
	{
		signinPage.clickonJoinNowlnk();
	}
@AfterMethod
public void close()
{
	driver.quit();
}
}

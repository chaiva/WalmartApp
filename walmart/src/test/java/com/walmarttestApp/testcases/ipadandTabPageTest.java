package com.walmarttestApp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmarttestApp.Base.TestBase;
import com.walmarttestApp.pages.HomePage;
import com.walmarttestApp.pages.LoginPage;
import com.walmarttestApp.pages.OrderDetailsPage;
import com.walmarttestApp.pages.OrderHistory;
import com.walmarttestApp.pages.Searchproductlistspage;
import com.walmarttestApp.pages.ShoppingCart;
import com.walmarttestApp.pages.SigninPage;
import com.walmarttestApp.pages.ipadandTabPage;
import com.walmarttestApp.util.TestUtil;

public class ipadandTabPageTest extends TestBase{
	SigninPage signinpage;
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ShoppingCart shopcart;
	ipadandTabPage iptpage;
	
public ipadandTabPageTest()
{
	super();
}

@BeforeMethod
public void setUp() {
	initialization();
	testUtil = new TestUtil();
	signinpage = new SigninPage();
	loginpage = signinpage.clickonSignInbtn();
	homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	iptpage = homepage.clickonIpadlink();
	//testUtil.switchtoframe();
	//iptpage = new ipadandTabPage();

	
}
@Test
public void ratingtest() throws InterruptedException
{
	
	//Thread.sleep(5000);
boolean result =iptpage.checkparticularratingonproducts("fourstar");
Assert.assertTrue(result);
}

@AfterMethod
public void close()
{
	driver.quit();
}
}

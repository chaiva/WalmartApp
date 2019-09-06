package com.walmarttestApp.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmarttestApp.Base.TestBase;
import com.walmarttestApp.pages.HomePage;
import com.walmarttestApp.pages.LoginPage;
import com.walmarttestApp.pages.OrderDetailsPage;
import com.walmarttestApp.pages.OrderHistory;
import com.walmarttestApp.pages.SigninPage;
import com.walmarttestApp.util.TestUtil;

public class MyOrderTest extends TestBase {
	SigninPage signinpage;
	LoginPage loginpage;
	HomePage homepage;
	OrderHistory orderhistory;
	OrderDetailsPage orderDetailspage;
	TestUtil testUtil;

	
	public MyOrderTest()
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
		orderhistory = homepage.clickonMyOrderslnk();


}
	@Test
	public void selectorderdatetest()
	{
		String ord_date = "May 2015 (1 order)";
		 orderhistory.selectandmanageorder(ord_date);
	}
	
	
	@Test
	public void trackordertest()
	{
		String ord_date = "May 2015 (1 order)";
		orderDetailspage= orderhistory.selectandmanageorder(ord_date);
		orderDetailspage.trackshipment();
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	
}

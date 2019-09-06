package com.walmarttestApp.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

public class HomePageTest extends TestBase {
	SigninPage signinpage;
	LoginPage loginpage;
	HomePage homepage;
	OrderHistory orderhistory;
	OrderDetailsPage orderDetailspage;
	TestUtil testUtil;
	Searchproductlistspage splpage;
	ShoppingCart shopcart;
	ipadandTabPage iptpage;
	public HomePageTest()
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
	}
	
	/*@Test
	public void  ipadpagetest()
	{
		iptpage = homepage.clickonIpadlink();
	}*/
	
	@Test(dataProvider = "getTestData")
	public void searchfunctionalitytest(String inputName,String prodname,String brandname) throws InterruptedException
	{
		Thread.sleep(5000);
		splpage =homepage.searchproduct(inputName,prodname);
		shopcart =splpage.searchparticularproduct(brandname);
		shopcart.clickoncheckoutbtn();
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = TestUtil.getdatafromExcelforproducts();
		return testData.iterator();
		
	} 
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}

package com.walmarttestApp.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.walmarttestApp.Base.TestBase;
import com.walmarttestApp.clothing.ClothingshoeandAccessoriesPage;
import com.walmarttestApp.clothing.Womenshoppingpage;
import com.walmarttestApp.clothing.pantsandcaprispage;
import com.walmarttestApp.pages.HomePage;
import com.walmarttestApp.pages.LoginPage;
import com.walmarttestApp.pages.ShoppingCart;
import com.walmarttestApp.pages.SigninPage;
import com.walmarttestApp.util.TestUtil;

public class pantsandcapritest extends TestBase {
	SigninPage signinpage;
	LoginPage loginpage;
	HomePage homepage;
	ClothingshoeandAccessoriesPage csapage;
	Womenshoppingpage wspage;
	pantsandcaprispage pcpage;
	TestUtil testUtil;
	ShoppingCart scpage;
	
	public pantsandcapritest()
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
		csapage = homepage.clickonClothing();
	}
	
	/*@Test
	public void countofpantsandpages() throws Exception
	{
		wspage =csapage.clickonWomenlnk();
		pcpage = wspage.clickonpants_caprislnk();
		int cnt =pcpage.pantsandcapricount();
		System.out.println("The count of pants and capris for price sort"+cnt);
	}*/
	

	@Test(dataProvider = "getTestData")
	public void selectcapribybrand(String brandname)
	{
		wspage =csapage.clickonWomenlnk();
		pcpage = wspage.clickonpants_caprislnk();
		scpage =pcpage.selectcapripant(brandname);
		scpage.clickoncheckoutbtn();
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = TestUtil.getdatafromExcelforcapripantsbrands();
		return testData.iterator();
		
	} 
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}

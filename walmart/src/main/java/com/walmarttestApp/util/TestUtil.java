package com.walmarttestApp.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.walmarttestApp.Base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 30;
static XLs_Reader reader;

public void switchtoframe()
{
	//driver.switchTo().frame("google_ads_iframe_/10337976/en/gm/electronics/ipad-tablets_1");
	driver.switchTo().frame(1);
}
	
	public static ArrayList<Object[]> getdatafromExcelforcreateWalmartAcct()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		XLs_Reader reader =new XLs_Reader("C:\\chaithra\\SeleniumAssignments\\walmart\\src\\main\\java\\com\\walmarttestApp\\data\\walmartApp.xlsx");
		int rowcount = reader.getRowCount("createAccDetails");
		
		for(int row = 2;row <=rowcount;row++)
		{
			String emailid = reader.getCellData("createAccDetails", "email", row);
			System.out.println(emailid);
			
			String phno =reader.getCellData("createAccDetails", "phoneNo", row);
			System.out.println(phno);
			
			String fname = reader.getCellData("createAccDetails", "firstName", row);
			System.out.println(fname);
			
			String lname = reader.getCellData("createAccDetails", "lastName", row);
			System.out.println(lname);
			
			String passwd = reader.getCellData("createAccDetails", "password", row);
			System.out.println(passwd);
			
			String confirmpwd = reader.getCellData("createAccDetails", "confirmpassword", row);
			System.out.println(confirmpwd);
			
			Object[] ob = new Object[] {emailid,phno,fname,lname,passwd,confirmpwd};
			mydata.add(ob);
		}
		return mydata;
}
	public static ArrayList<Object[]> getdatafromExcelforcapripantsbrands()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		XLs_Reader reader =new XLs_Reader("C:\\chaithra\\SeleniumAssignments\\walmart\\src\\main\\java\\com\\walmarttestApp\\data\\walmartApp.xlsx");
		int rowcount = reader.getRowCount("capripants");
		for(int row = 2;row <= rowcount;row++)
		{
			String brandname = reader.getCellData("capripants", "Brands", row);
			System.out.println(brandname);
			Object[] obj = new Object[] {brandname};
			mydata.add(obj);
		}
		return mydata;
	}
	
	public static ArrayList<Object[]> getdatafromExcelforproducts()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		XLs_Reader reader =new XLs_Reader("C:\\chaithra\\SeleniumAssignments\\walmart\\src\\main\\java\\com\\walmarttestApp\\data\\walmartApp.xlsx");
		int rowcount = reader.getRowCount("productsearch");
		for(int row = 2;row <=rowcount;row++)
		{
			String inpName = reader.getCellData("productsearch", "inputName", row);
			System.out.println(inpName);
			String prodName = reader.getCellData("productsearch", "prodName", row);
			System.out.println(prodName);
			String brandname = reader.getCellData("productsearch", "brandname", row);
			System.out.println(brandname);
			Object[] obj = new Object[] {inpName,prodName,brandname};
			mydata.add(obj);
		}
		return mydata;
	}
	public static ArrayList<Object[]> getLoginCredentials()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		XLs_Reader reader =new XLs_Reader("C:\\chaithra\\SeleniumAssignments\\walmart\\src\\main\\java\\com\\walmarttestApp\\data\\walmartApp.xlsx");
		int rowcount = reader.getRowCount("loginDetails");
		for(int row = 2;row <=rowcount;row++)
		{
			String username = reader.getCellData("loginDetails", "username", row);
			System.out.println(username);
			String pwd = reader.getCellData("loginDetails", "password", row);
			System.out.println(pwd);
			Object[] obj = new Object[] {username,pwd};
			mydata.add(obj);
		}
		return mydata;
	}
			
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}

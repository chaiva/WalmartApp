package com.walmarttestApp.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.walmarttestApp.Base.TestBase;
import com.walmarttestApp.pages.CreateAccount;
import com.walmarttestApp.pages.SigninPage;
import com.walmarttestApp.util.TestUtil;

public class CreateAccountTest extends TestBase{
	TestUtil testUtil;
	CreateAccount createAcct;
	SigninPage signinpage;
	
	public CreateAccountTest ()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil = new TestUtil();
		signinpage = new SigninPage();
		createAcct =signinpage.clickonJoinNowlnk();
	}
	
	@Test(dataProvider = "getTestData")
	public void createacc_details(String email,String phno,String fname,String lname,String pwd,String cpwd)
	{
		createAcct.createaccount(email, phno, fname, lname, pwd, cpwd);
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = TestUtil.getdatafromExcelforcreateWalmartAcct();
		return testData.iterator();
		
	} 
}

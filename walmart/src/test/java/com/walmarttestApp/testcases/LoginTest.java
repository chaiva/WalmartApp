package com.walmarttestApp.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.walmarttestApp.Base.TestBase;
import com.walmarttestApp.pages.CreateAccount;
import com.walmarttestApp.pages.HomePage;
import com.walmarttestApp.pages.LoginPage;
import com.walmarttestApp.pages.SigninPage;
import com.walmarttestApp.util.CustomEventListener;
import com.walmarttestApp.util.TestUtil;
@Listeners(CustomEventListener.class)
public class LoginTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	CreateAccount caccnt;
	SigninPage signinpage;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
public void init()
{
		initialization();
		signinpage = new SigninPage();
		loginpage = signinpage.clickonSignInbtn();
		caccnt = new CreateAccount();
		 
}
	/*@Test
	public void logintest()
	{
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}*/
	
	/*@Test
	public void createaccnttest()
	{
		String mailid = "ck.test@xyz.com";
		caccnt = loginpage.clickonCreateAcctBtn(mailid);
	}*/
	
	@Test
	public void loginvalidatetestforinvalidusername() throws IOException
	{
		String username = "vamshi";
		String pwd = "Slasya12";
		homepage = loginpage.Login(username,pwd); 
		String incorrectEmailid = "Please enter a valid email address or phone number";
		WebElement emailidfield = driver.findElement(By.xpath("//input[@id = 'login-form-email']/following-sibling::span[@class = 'error']"));
		//WebElement passfield  = driver.findElement(By.xpath("//input[@name= 'password']/following-sibling::span[@class = 'error']"));
		//WebElement alertmsg = driver.findElement(By.xpath("//div[@class = 'a-alert a-alert--warning']/p"));
		//Please enter a valid email address or phone number
		if(emailidfield.isDisplayed())
		{
			ScrollIntoView(emailidfield, driver);
			String emailfield = emailidfield.getText();
		
		  Assert.assertEquals(incorrectEmailid, emailfield);
		   
		}
		
		}
		
@Test
public void loginvalidatetestforinvalidpaswrd()
{
	String username = "vamshi.sadhu@gmail.com";
	String pwd = "";
	homepage = loginpage.Login(username,pwd); 
	String incorrectpaswd = "Password is not a required field";
	WebElement passfield  = driver.findElement(By.xpath("//input[@name= 'password']/following-sibling::span[@class = 'error']"));
	//WebElement alertmsg = driver.findElement(By.xpath("//div[@class = 'a-alert a-alert--warning']/p"));
	if(passfield.isDisplayed())
	{
		ScrollIntoView(passfield, driver);
		String passwd = passfield.getText();
	
	  Assert.assertEquals(incorrectpaswd, passwd);
	   
	}
}

@Test
public void loginvalidatetestforincorrectcredentials()
{
	String username = "vamshi.sadhu@gmail.com";
	String pwd = "Skalya";
	homepage = loginpage.Login(username,pwd); 
	String incorrectmsg = "The information you entered does not match our records. Please try again.";
	WebElement alertmsg = driver.findElement(By.xpath("//div[@class = 'a-alert a-alert--warning']/p"));
	if(alertmsg.isDisplayed())
	{
		ScrollIntoView(alertmsg, driver);
		String msg = alertmsg.getText();
	
	  Assert.assertEquals(incorrectmsg, msg);
	   
	}
}
	
	/*@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = TestUtil.getLoginCredentials();
		return testData.iterator();
		
	} */
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}

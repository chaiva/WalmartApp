package com.walmarttestApp.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.walmarttestApp.util.TestUtil;
import com.walmarttestApp.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\chaithra\\SeleniumAssignments\\walmart\\src\\main\\java\\com\\walmarttestApp\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			//ChromeOptions options  = new ChromeOptions();
			//options.addArguments("--disable-notifications");
			/*DesiredCapabilities dc = DesiredCapabilities.chrome();
			dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
			ChromeOptions options = new ChromeOptions();
			dc.setCapability(options.CAPABILITY, options);*/
			System.setProperty("webdriver.chrome.driver", "C:\\chaithra\\SeleniumAssignments\\walmart\\src\\main\\resources\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\chaithra\\SeleniumAssignments\\walmart\\src\\main\\resources\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\chaithra\\SeleniumAssignments\\walmart\\src\\main\\resources\\MicrosoftWebDriver.exe");
			 driver = new InternetExplorerDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	public static void WaitElement(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void WaitListElement(WebDriver driver,List<WebElement> elements,int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public static void clickOn(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static void ScrollPageDown(WebDriver driver)
	{
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void ScrollIntoView(WebElement targetElement,WebDriver driver)
	{
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
	}
	public void takeScreenShot(String methodname)
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + methodname + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

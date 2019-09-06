package com.walmarttestApp.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmarttestApp.Base.TestBase;

public class ipadandTabPage extends TestBase {
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::h2[@class = 'thumb-header']")
	List<WebElement> ipadandtabprod;
	
	@FindBy(xpath = "//nav[@id = 'guided-navigation']/descendant::button[@class ='refinement-button']")
	WebElement CustomerRatingbtn;
	
	@FindBy(xpath = "//div[@id = 'rm-CustomerRating']")
	WebElement ratingsec;
	
	@FindBy(xpath = "//li[@id = 'rmi-customerrating-id-0']")
	WebElement fivestar;
	
	@FindBy(xpath = "//li[@id = 'rmi-customerrating-id-1']")
	WebElement fourstar;
	
	@FindBy(xpath = "//li[@id = 'rmi-customerrating-id-2']")
	WebElement threestar;
	
	@FindBy(xpath = "//li[@id = 'rmi-customerrating-id-3']")
	WebElement twostar;
	
	@FindBy(xpath = "//li[@id = 'rmi-customerrating-id-4']")
	WebElement onestar;
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::div[@class ='stars rating-1_5']")
	List<WebElement> oneandhalfstarproducts; 
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::div[@class ='stars rating-1_0']")
	List<WebElement> onestarproducts; 
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::div[@class ='stars rating-2_5']")
	List<WebElement> twoandhalfstarproducts;
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::div[@class ='stars rating-2_0']")
	List<WebElement> twostarproducts;
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::div[@class ='stars rating-3_5']")
	List<WebElement> threeandhalfstarproducts;
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::div[@class ='stars rating-3_0']")
	List<WebElement> threestarproducts;
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::div[@class ='stars rating-4_5']")
	List<WebElement> fourandhalfstarproducts;
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::div[@class ='stars rating-4_0']")
	List<WebElement> fourstarproducts;
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::div[@class ='stars rating-5_5']")
	List<WebElement> fiveandhalfstarproducts;
	
	@FindBy(xpath = "//div[@class = 'shelf-thumbs pnoDone']/article/descendant::div[@class ='stars rating-5_0']")
	List<WebElement> fivestarproducts;
	
	public ipadandTabPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public int clickonfivestarrating()
	{
		fivestar.click();
		int cnt = ipadandtabprod.size();
		return cnt;
	}
	
	public boolean checkparticularratingonproducts(String rating)
	{
		/*driver.switchTo().defaultContent();*/
		WaitElement(driver, CustomerRatingbtn, 30);
		ScrollIntoView(ratingsec, driver);
		clickOn(driver, CustomerRatingbtn, 10);
		int cnt =0;
		int j = 0;
		if(rating.equalsIgnoreCase("onestar"))
		{
			clickOn(driver, onestar, 30);
			cnt = ipadandtabprod.size();
			for (int i = 0; i < cnt; i++) {
			if((oneandhalfstarproducts.size() > 0) ||(onestarproducts.size()>0))
 					{
				 j = j+1;
				
					}
			}
		}
		
		else if(rating.equalsIgnoreCase("twostar"))
		{
			clickOn(driver, twostar, 30);
			cnt = ipadandtabprod.size();
			for (int i = 0; i < cnt; i++) {
			if((twoandhalfstarproducts.size() > 0) ||(twostarproducts.size()>0))
 					{
				 j = j+1;
				
					}
			}
		}
		
		else if(rating.equalsIgnoreCase("threestar"))
		{
			clickOn(driver, threestar, 30);
			cnt = ipadandtabprod.size();
			for (int i = 0; i < cnt; i++) {
			if((threeandhalfstarproducts.size() > 0) ||(threestarproducts.size()>0))
 					{
				 j = j+1;
				
					}
			}
		}
		else if(rating.equalsIgnoreCase("fourstar"))
		{
			clickOn(driver, fourstar, 30);
			cnt = ipadandtabprod.size();
			for (int i = 0; i < cnt; i++) {
			if((fourandhalfstarproducts.size() > 0) ||(fourstarproducts.size()>0))
 					{
				 j = j+1;
				
					}
			}
		}
		/*else if(rating.equalsIgnoreCase("fivestar"))
		{
			clickOn(driver, fivestar, 30);
			cnt = ipadandtabprod.size();
			int x = fiveandhalfstarproducts.size();
			int y = fivestarproducts.size();
		//	ScrollPageDown(driver);
			
			for (int i = 0; i < cnt; i++) {
			if(x >0 ||y > 0)
 					{
				 j = j+1;
				
					}
			}
		}*/
			if(j ==cnt)
			{
				System.out.println("All items are displayed with "+rating+" star rating" +j);
				return true;
			}
			else
				return false;
		

}
}

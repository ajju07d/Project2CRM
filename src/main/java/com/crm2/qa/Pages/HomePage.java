package com.crm2.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm2.qa.Base.TestBase;

public class HomePage extends TestBase{
	
	//initializing webelements to object of this class
				public HomePage() {
					PageFactory.initElements(driver, this);
				}
	//webelements :			
				@FindBy(xpath="//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'][normalize-space()='Ajinkya'] ")
				WebElement usernamelabel;
				
				@FindBy(xpath="//span[contains(text(),'Marketplace')] ")
				WebElement mkt_place_link;
				
	//Actions			
				
		public String HomePageTitle() {
			return driver.getTitle();
		}
		  
		public boolean verifyUsernameLabel() {
		
				return usernamelabel.isDisplayed();
		}
		
		public MarketPlace clickonMarketPlace() {
			mkt_place_link.click();
			
			return new MarketPlace();
		}
	

}

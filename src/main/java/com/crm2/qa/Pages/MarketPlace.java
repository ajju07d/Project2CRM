package com.crm2.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm2.qa.Base.TestBase;

public class MarketPlace extends TestBase{

	
	MarketPlace(){
		super();
	}
	
	
	@FindBy(xpath=  "//span[contains(text(),'Notifications')]")
	WebElement notification;
	
	public boolean ismarketPlaceDisplayed() 
	{
		return notification.isDisplayed();
	}
	
	public Notification clickonNotification() {
		 notification.click();
		 return new Notification();
	}
}

package com.crm2.qa.TestCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm2.qa.Base.TestBase;
import com.crm2.qa.Pages.HomePage;
import com.crm2.qa.Pages.LoginPage;
import com.crm2.qa.Pages.MarketPlace;
import com.crm2.qa.Pages.Notification;

public class MarketPlaceTest extends TestBase {

	LoginPage login_page;
	HomePage home_page;
	MarketPlace mktplace_page;
	Notification notiFi_page;
	Alert alert,alert1;

	public MarketPlaceTest() {

		super();// it will intialize testbase class constructor
	}

	@BeforeMethod
	public void Setup() {

		initialization();

		login_page = new LoginPage();
		home_page = login_page.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		mktplace_page= home_page.clickonMarketPlace();
		try {
			alert1 = driver.switchTo().alert();
			alert1.accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		notiFi_page =	mktplace_page.clickonNotification();
	
		}

//	 @Test
//	 public void marketplaceDisplayTest() {
//		 boolean b= mktplace_page.ismarketPlaceDisplayed();
//		 Assert.assertTrue(b);
//	 }
	@Test
	public void notificationclickTest() {

		notiFi_page = mktplace_page.clickonNotification();
	}

	@AfterMethod
	public void TearDown() {
		// driver.quit();
	}

}

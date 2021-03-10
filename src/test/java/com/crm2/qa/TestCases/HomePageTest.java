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

public class HomePageTest extends TestBase {

	LoginPage login_page;
	HomePage home_page;
	MarketPlace mktplace_page;
	public HomePageTest() {

		super();// it will intialzae testbase class constructor
	}

	@BeforeMethod
	public void Setup() {

		initialization();

		login_page = new LoginPage();
		home_page = login_page.login(prop.getProperty("username"), prop.getProperty("password"));
	}

//	@Test
//	public void ValidateHomePageTitleTest() {
//	
//		String hometitle=home_page.HomePageTitle();
//		Assert.assertEquals(hometitle, "","Title is not matching");
//	}
//	
//	@Test
//	public void usernamevalidityTest() {
//
//		boolean b = home_page.verifyUsernameLabel();
//		Assert.assertTrue(b);
//	}

//	
	@Test
	public void clickonMarketPlaceTest() throws InterruptedException {
		
		mktplace_page=home_page.clickonMarketPlace();
		Thread.sleep(10000);
	}

	@AfterMethod
	public void TearDown() {
	//	driver.quit();
	}

}

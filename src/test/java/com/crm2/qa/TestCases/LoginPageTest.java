package com.crm2.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm2.qa.Base.TestBase;
import com.crm2.qa.Pages.HomePage;
import com.crm2.qa.Pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage login_page;
	HomePage home_page;
	
	 public LoginPageTest() {
	 
		 super();// it will intialzae testbase class constructor
	}
	
	@BeforeMethod
	public void Setup() {
		
		initialization();
		
		 login_page= new LoginPage();
	}
	
//	@Test(priority = 1)
//	public void loginPageTitleTest() {
//		
//		String title=login_page.validateLoginPageTitle();
//		Assert.assertEquals(title, "Facebook – log in or sign up");//to validate or to confirm
//		
//	}
//	@Test(priority = 2)
//	public void ValidateLogoTest() {
//		boolean flag=login_page.validateLogo();
//		Assert.assertTrue(flag);
//	}
	@Test
	public void LoginTest() throws InterruptedException {
		home_page=  login_page.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	
}

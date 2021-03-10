package com.crm2.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm2.qa.Base.TestBase;

public class LoginPage extends TestBase {

	// constructor will initialize page objects via --->pagefactory.initelements()
	// methods

	public LoginPage() {

		PageFactory.initElements(driver, this);// to initialize page factory
	}

	// page factory or Object Repository
	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "pass")
	WebElement password;

	@FindBy(name = "login")
	WebElement login_btn;

	@FindBy(xpath = "//a[contains(test(),'Create New Account')]")
	WebElement new_account;

	@FindBy(xpath = "//img[contains(@class,'fb_logo _8ilh img')]")
	WebElement logo;

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {

		return logo.isDisplayed();
	}

	public HomePage login(String un,String pwd) {

		username.sendKeys(un);
		password.sendKeys(pwd);
		login_btn.click();
		//Thread.sleep(5000);
		return new HomePage();
	}
}

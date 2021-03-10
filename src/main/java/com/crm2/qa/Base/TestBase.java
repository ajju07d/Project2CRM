package com.crm2.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm2.qa.Util.TestUtil;
import com.crm2.qa.Util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistner;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Shree\\eclipse-workspace\\Project2CRM\\src\\main\\java\\com\\crm2\\qa\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		if (prop.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shree\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//-----------------------------------------------------------------------------------
		e_driver = new EventFiringWebDriver(driver);

		eventlistner = new WebEventListener();
		e_driver.register(eventlistner);
		driver = e_driver;
		
		//-----------------------------------------------------------------------------------

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

}

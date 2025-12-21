package com.rmgYantra.genericUtilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.rmgYantra.objectRepository.LoginPage;

public class Base {
	
	protected WebDriver driver;
	static public WebDriver sdriver=null;
	protected PropertiesFileUtility plib;
	protected WebDriverUtility wlib;
	protected JavaUtility jlib;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("=== Before suite ===");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("=== Pre-conditions for test block ===");
	}
	//@Parameters("browser")
	@BeforeClass
	public void beforeClass() throws IOException {
		
		plib = new PropertiesFileUtility();
		wlib = new WebDriverUtility();
		jlib = new JavaUtility();
		
		String browser = plib.toReadDataFromPropertiesFile("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String,Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		}else if(browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver = new  FirefoxDriver();
		}
		
		wlib.tomaximizeWindow(driver);
		wlib.toimplicitlyWait(driver, 10);
		System.out.println("=== Browser launched ===");
		sdriver=driver;
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		
		String url = plib.toReadDataFromPropertiesFile("url");
		String un  = plib.toReadDataFromPropertiesFile("username");
		String pwd = plib.toReadDataFromPropertiesFile("password");
		
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(un, pwd);
		System.out.println("=== Logged in to RMG Yantra ===");
		
	}
	
	@AfterMethod
	public void afterMethod() {
		 System.out.println("=== AfterMethod: here we'll do logout once HomePage is ready ===");
	}
	
	@AfterClass
	public void afterClass() {
		if(driver!=null)
		{
			driver.quit();
		}
		 System.out.println("=== Browser closed ===");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("=== Post-conditions for test block ===");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("=== After suite ===");
	}
	

}

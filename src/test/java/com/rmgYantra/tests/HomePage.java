package com.rmgYantra.tests;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	
	public void BlaBla() {
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("www.amazon.in");
	
	Date date = new Date();
	date.toString().replace("","-").replace(":","-");
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	ts.getScreenshotAs(OutputType.FILE);
	
	}
}

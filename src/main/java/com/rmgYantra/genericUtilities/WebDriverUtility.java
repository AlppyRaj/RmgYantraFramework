package com.rmgYantra.genericUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void tomaximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	
	public void toimplicitlyWait(WebDriver driver, long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		
	}
	
	public void toexplicitlyWait(WebDriver driver, long seconds, WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void tomouseHover(WebElement element, WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
}

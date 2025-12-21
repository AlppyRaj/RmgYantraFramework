package com.rmgYantra.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rmgYantra.genericUtilities.WebDriverUtility;

public class contactPage extends WebDriverUtility {
	
	WebDriver driver;
	public contactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//span[text()='Create Contact']")
	private WebElement createContBtn;
	
	public WebElement getCreateContBtn() {
		return createContBtn;
	}
	
	

}

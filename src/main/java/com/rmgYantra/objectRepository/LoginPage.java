package com.rmgYantra.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement usernameT;	
	
	@FindBy(name ="password")
	private WebElement passwordT;
	
	@FindBy(xpath = "//button[text() = 'Sign In']")
	private WebElement loginBtn;
	
	public void loginToApp(String username, String password)
	{
		usernameT.sendKeys(username);
		passwordT.sendKeys(password);
		loginBtn.click();
	}
	
}

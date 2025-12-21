package com.rmgYantra.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rmgYantra.genericUtilities.WebDriverUtility;

public class SelectCampaignPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public SelectCampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search-input")
	private WebElement searchtb;
	
	@FindBy(xpath="//button[contains(@class,'select-btn') and contains(@onclick,'SpidersA')]")
	private WebElement SelBtn ;
	
	public WebElement getSrchBox() {
		return searchtb;
	}
	public WebElement getSelBtn() {
		return SelBtn;
	}
	
	public void selectCamp() {
		toexplicitlyWait(driver,20,SelBtn);
		SelBtn.click();
	}
	
		
	
}

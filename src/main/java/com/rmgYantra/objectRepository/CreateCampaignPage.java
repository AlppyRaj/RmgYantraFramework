package com.rmgYantra.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rmgYantra.genericUtilities.WebDriverUtility;

public class CreateCampaignPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public CreateCampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignName")
	private WebElement campaignName;
	
	@FindBy(name="expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy(name="targetAudience")
	private WebElement targetAudience;
	
	@FindBy(name="campaignStatus")
	private WebElement campaignStatus;
	
	@FindBy(name="targetSize")
	private WebElement targetSize;
	
	@FindBy(name="description")
	private WebElement description;
	
	@FindBy(xpath = "//button[text() = 'Create Campaign']")
	private WebElement createCampBtn;
	
	@FindBy(xpath="//div[@role='alert' and contains(@class,'Toastify__toast-body')]")
	private WebElement toastmsg;
	
	public WebElement getToastmsg() {
		return toastmsg;
	}
	public WebElement gettargetSize() {
		return targetSize;
	}
	public WebElement getdescription() {
		return description;
	}
	
	public WebElement getCampaignName() {
		return campaignName;
	}
	public WebElement getexpectedCloseDate() {
		return expectedCloseDate;
	}
	public WebElement gettargetAudience() {
		return targetAudience;
	}
	public WebElement getcampaignStatus() {
		return campaignStatus;
	}
	public WebElement getcreateCampBtn() {
		return createCampBtn;
	}
	
	public void createCampaignWithMandatoryDetails(String cname,String tnum) {
		campaignName.sendKeys(cname);
		targetSize.clear();
		targetSize.sendKeys(tnum);
		createCampBtn.click();
		
	}
	public void createCampaignWithCloseDate(String cname,String tnum, String ExpectedDate) {
		
		campaignName.sendKeys(cname);
		targetSize.clear();
		targetSize.sendKeys(tnum);
		expectedCloseDate.sendKeys(ExpectedDate);
		createCampBtn.click();
	}
	
	public void createCampaignWithTarAud(String cname,String tnum, String ExpectedDate, String TargAud) {
		campaignName.sendKeys(cname);
		targetSize.clear();
		targetSize.sendKeys(tnum);
		expectedCloseDate.sendKeys(ExpectedDate);
		targetAudience.sendKeys(TargAud);
		createCampBtn.click();
	}
	
	public String getToastMessage(WebDriver driver) {
		
		toexplicitlyWait(driver, 20, toastmsg);
		return toastmsg.getText();
		
	}

}

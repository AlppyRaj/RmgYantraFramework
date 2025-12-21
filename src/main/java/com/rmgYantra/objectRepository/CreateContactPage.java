package com.rmgYantra.objectRepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rmgYantra.genericUtilities.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public CreateContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="contactName")
	private WebElement contactName;
	
	@FindBy(name="organizationName")
	private WebElement organizationName;
	
	@FindBy(name="mobile")
	private WebElement mobile;
	
	@FindBy(name="title")
	private WebElement title;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="department")
	private WebElement department;
	
	@FindBy(xpath="//*[name()='svg' and @data-icon='plus']")
	private WebElement plusIcon;
	
	@FindBy(name="officePhone")
	private WebElement officePhone;
	
	@FindBy(xpath="//button[text()='Create Contact']")
	private WebElement createCntBtn;
	
	@FindBy(xpath = "//div[@role='alert' and contains(@class,'Toastify__toast-body')]")
	private WebElement toastMsg;
	
	public WebElement getToastMsg() {return toastMsg;}
	public WebElement getContactName() {return contactName;}
	public WebElement getOrgName() {return organizationName;}
	public WebElement getMobileN() {return mobile;}
	public WebElement getTitle() {return title;}
	public WebElement getEmail() {return email;}
	public WebElement getdeptName() {return department;}
	public WebElement getplusIcon() {return plusIcon;}
	public WebElement getOfficepn() {return officePhone;}
	public WebElement getCntBtn() {return createCntBtn;}
	
	public String ToastMessage() {
		toexplicitlyWait(driver, 20, toastMsg);
		return toastMsg.getText();
	}
	
	public void createContactWithMandatory(String contname, String orgName, String mob, String titles)
	{
		String childwin = null;
		contactName.sendKeys(contname);
		organizationName.sendKeys(orgName);
		mobile.sendKeys(mob);
		title.sendKeys(titles);
		plusIcon.click();
		
		String parWin=driver.getWindowHandle();
		Set<String> wins = driver.getWindowHandles();
		for(String win:wins) {
			if(!win.equals(parWin))	{
				 childwin = win;
				 break;
			}
		}
		if(childwin!=null) {
			driver.switchTo().window(childwin);
		SelectCampaignPage scp= new SelectCampaignPage(driver);
		scp.selectCamp();
		driver.switchTo().window(parWin);
		}
		createCntBtn.click();
		System.out.println("Create Contact Page - Eclipse change");

	}
}


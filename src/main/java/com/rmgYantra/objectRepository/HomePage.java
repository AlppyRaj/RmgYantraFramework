package com.rmgYantra.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rmgYantra.genericUtilities.Base;
import com.rmgYantra.genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@class = 'btn btn-info']/span")
	private WebElement createCapmpaignBtn;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseOrderLink;
	
	@FindBy(xpath="//a[contains(text(), 'Sales Order')]")
	private WebElement salesOrderLink;
	
	@FindBy(linkText="Invoice")
	private WebElement invoiceLink;
	
	@FindBy(xpath ="//div[@class = 'nav-link']/li")
	private WebElement AdminConsole;
	
	@FindBy(xpath ="//*[name() = 'svg' and @data-icon = 'user']")
	private WebElement userIcon;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logoutbtn;
	
	@FindBy(xpath = "//div[text() = 'Create User']")
	private WebElement createUserBtn;
	
	@FindBy(xpath ="//div[text() = 'View Users']")
	private WebElement viewUserBtn;
	
	public WebElement getcreateCapmpaignBtn()
	{
		return createCapmpaignBtn;
	}
	
	public WebElement getcampaignsLink() {
		return campaignsLink;
	}
	public WebElement getcontactLink() {
		return contactLink;
	}
	public WebElement getcleadsLink() {
		return leadsLink;
	}
	public WebElement getopportunitiesLink() {
		return opportunitiesLink;
	}
	public WebElement getproductsLinkk() {
		return productsLink;
	}
	public WebElement getpurchaseOrderLink() {
		return purchaseOrderLink;
	}
	public WebElement getsalesOrderLink() {
		return salesOrderLink;
	}
	public WebElement getinvoiceLink() {
		return invoiceLink;
	}
	public WebElement getAdminConsole() {
		return AdminConsole;
	}
	public WebElement getuserIcon() {
		return userIcon;
	}
	public WebElement getlogoutbtn() {
		return logoutbtn;
	}
	public WebElement getcreateUserBtn() {
		return createUserBtn;
	}
	public WebElement getviewUserBtn() {
		return viewUserBtn;
	}
	
	public void navigateToCreateUser(WebDriver driver) {
		tomouseHover(AdminConsole, driver);
		createUserBtn.click();
	}
	
	public void navigateToViewUser(WebDriver driver) {
		tomouseHover(AdminConsole, driver);
		viewUserBtn.click();
	}
	
	public void navigateToLogOut(WebDriver driver) {
		tomouseHover(userIcon, driver);
		logoutbtn.click();
	}
	public void clickCampBtn(WebDriver driver) {
		createCapmpaignBtn.click();
	}
}

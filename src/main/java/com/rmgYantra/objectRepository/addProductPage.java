package com.rmgYantra.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addProductPage {
	
	WebDriver driver;
	
	public addProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="quantity")
	private WebElement quantity;
	
	@FindBy(name="productName")
	private WebElement productName;
	
	@FindBy(name ="productCategory")
	private WebElement productCategory;
	
	@FindBy(name ="price")
	private WebElement price;
	
	@FindBy(name ="vendorId")
	private WebElement vendorId;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addBtn;
	
	public WebElement getQuantity()
	{
		return quantity;
	}
	public WebElement getProductName()
	{
		return productName;
	}
	public WebElement getProductCategory()
	{
		return productCategory;
	}
	public WebElement getPrice()
	{
		return price;
	}
	public WebElement getVendorId()
	{
		return vendorId;
	}
	public WebElement getAddBtn()
	{
		return addBtn;
	}
	
	public void addProductWithMandatoryDetails(String pName, String catg, String quant, String pr,String Vid)
	{
		productName.sendKeys(pName);
		
		//Select select = new Select(productCategory);
		//select.selectByVisibleText(catg);
		
		productCategory.sendKeys(catg);
		quantity.sendKeys(quant);
		price.clear();
		price.sendKeys(pr);
		vendorId.sendKeys(Vid);
		//Select select1 = new Select(vendorId);
		//select1.selectByVisibleText(Vid);
		
		addBtn.click();
	}
	

}

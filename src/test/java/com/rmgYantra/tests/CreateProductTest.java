package com.rmgYantra.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.rmgYantra.genericUtilities.Base;
import com.rmgYantra.genericUtilities.ExcelUtilities;
import com.rmgYantra.objectRepository.HomePage;
import com.rmgYantra.objectRepository.ProductPage;
import com.rmgYantra.objectRepository.addProductPage;
@Listeners(com.rmgYantra.ListenersUtilities.ListenerImplementation.class)

public class CreateProductTest extends Base {
	
	@Test
	public void createProduct() throws Throwable {
		
		ExcelUtilities elib = new ExcelUtilities();
		 	String prodName  = elib.toReadDataFromExcel("Product", 1, 0);
		    String category  = elib.toReadDataFromExcel("Product", 1, 1);
		    String quantity  = elib.toReadDataFromExcel("Product", 1, 2);
		    String price     = elib.toReadDataFromExcel("Product", 1, 3);
		    String vendor    = elib.toReadDataFromExcel("Product", 1, 4);

		
//		String prodName ="Product_"+jlib.getRandomAlphabet(2);
//		String categ    ="Electronics";
//		String quant   = "1"+jlib.getRandomNumber();
//		String price = "0."+jlib.getRandomNumber();
//		String vid  = "VID_1568";
		
	HomePage hp1 = new HomePage(driver);
	hp1.getproductsLinkk().click();
	//Adding comment for checking poll SCM
	ProductPage pp = new ProductPage(driver);
	pp.getAddProdBtn().click();
	
	addProductPage add = new addProductPage(driver);
	add.addProductWithMandatoryDetails(prodName, category, quantity, price, vendor);
	
	System.out.println("Prod created !!");
	
	String expResult = "Ninza CRM";
	String actResult = driver.getTitle();
	
	Assert.assertEquals(expResult, actResult);
	
	

}}

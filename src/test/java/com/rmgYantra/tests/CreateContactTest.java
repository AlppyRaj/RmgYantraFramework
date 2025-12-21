package com.rmgYantra.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgYantra.genericUtilities.Base;
import com.rmgYantra.objectRepository.CreateContactPage;
import com.rmgYantra.objectRepository.HomePage;
import com.rmgYantra.objectRepository.contactPage;
@Listeners(com.rmgYantra.ListenersUtilities.ListenerImplementation.class)

public class CreateContactTest extends Base {
	
	@Test
	public void createContactPosT() {
		
	String conName = "Contact_" + jlib.getRandomAlphabet(3);
	String orgName = "Organisation_" + jlib.getRandomAlphabet(3);
	String phnNum = "965986" + jlib.getRandomNumber();
	String titleName = "Title_" + jlib.getRandomAlphabet(2);
	System.out.println(phnNum);
	HomePage hp1 = new HomePage(driver);
	hp1.getcontactLink().click();
	
	contactPage cp = new contactPage(driver);
	cp.getCreateContBtn().click();
	
	CreateContactPage ccp =new CreateContactPage(driver);
	ccp.createContactWithMandatory(conName, orgName, phnNum, titleName);
	
	String msg = ccp.ToastMessage();
	Assert.assertTrue(msg.contains("Successfully"),"Validation Failed");
	}
	
	@Test
	public void createContactNegTest() {
		
	String conName = "Contact_" + jlib.getRandomAlphabet(3);
	String orgName = "Organisation_" + jlib.getRandomAlphabet(3);
	String phnNum = "9659" + jlib.getRandomNumber();
	String titleName = "Title_" + jlib.getRandomAlphabet(2);
	System.out.println(phnNum);
	HomePage hp1 = new HomePage(driver);
	hp1.getcontactLink().click();
	
	contactPage cp = new contactPage(driver);
	cp.getCreateContBtn().click();
	
	CreateContactPage ccp =new CreateContactPage(driver);
	ccp.createContactWithMandatory(conName, orgName, phnNum, titleName);
	
	String msg = ccp.ToastMessage();
	Assert.assertFalse(msg.contains("Successfully"),"Validation Failed");
	}
}

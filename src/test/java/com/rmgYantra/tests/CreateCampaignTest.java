package com.rmgYantra.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgYantra.genericUtilities.Base;
import com.rmgYantra.genericUtilities.JavaUtility;
import com.rmgYantra.objectRepository.CreateCampaignPage;
import com.rmgYantra.objectRepository.HomePage;
@Listeners(com.rmgYantra.ListenersUtilities.ListenerImplementation.class)
public class CreateCampaignTest extends Base {
	
	@Test
	public void createCampaignTest() {
		
       String campaignName = "AutomationCampaign" + jlib.getRandomAlphabet(3);
        System.out.println(campaignName);
        String tarN= String.valueOf(jlib.getRandomNumber());
        
        HomePage hp =new HomePage(driver);
        hp.clickCampBtn(driver);
        
        CreateCampaignPage ccp = new CreateCampaignPage(driver);
        ccp.createCampaignWithMandatoryDetails(campaignName, tarN);
        
       // System.out.println("Value in field: " + 
        	    //ccp.getCampaignName().getAttribute("value"));

        String msg = ccp.getToastMessage(driver);
        System.out.println("Toast Message: " + msg);
        
        Assert.assertTrue(msg.contains("Successfully"),"Validation failed");
        System.out.println("=== Campaign created successfully ===");
        
	}
	
	

}

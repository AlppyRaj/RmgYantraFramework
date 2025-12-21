package com.rmgYantra.ListenersUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.rmgYantra.genericUtilities.Base;

public class ListenerImplementation implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Listener triggered for failure");

		String testName = result.getMethod().getMethodName(); 
		Reporter.log("====="+testName+" FAILURE=====",true); 
		Date d=new Date();
		String newDate = d.toString().replace(" ","_").replace(":","_");
		
		TakesScreenshot ts = (TakesScreenshot)Base.sdriver;
		File temp= ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/"+testName+" "+newDate+".png");
		try {
			FileUtils.copyFile(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

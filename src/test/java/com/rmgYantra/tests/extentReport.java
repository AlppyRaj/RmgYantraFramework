package com.rmgYantra.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {
	
	public void  demoReport() {
	
	ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
	spark.config().setDocumentTitle("CRM");
	spark.config().setReportName("CRM Report");
	spark.config().setTheme(Theme.DARK);
	
	ExtentReports ext = new ExtentReports();
	ext.attachReporter(spark);
	ext.setSystemInfo("MAC-OS","MAC" );
	ext.setSystemInfo("BROWSER", "CHROME-144");
	
	ExtentTest test = ext.createTest("demoReport");
	test.log(Status.INFO, "Login To App");
	test.log(Status.INFO, "Navigate to Page");
	test.log(Status.INFO, "Create page");
	
	if("HDFC".equals("HDFC")) {
		test.log(Status.PASS, "Successfully");
		
	}
	else {
		test.log(Status.FAIL, "Failed");
	}
	
	ext.flush();
	
	}
}

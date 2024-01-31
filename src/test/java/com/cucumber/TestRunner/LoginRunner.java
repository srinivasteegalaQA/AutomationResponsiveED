package com.cucumber.TestRunner;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.cucumber.listener.Reporter;
import com.cucumber.managers.WebDriverManager;
import com.cucumber.utility.Log;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/features/Login.feature" }, glue = {
		"com/cucumber/stepdefination" }, plugin = { "json:target/cucumber-reports/cucumber.json",
				"html:target/cucumber-pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent-reports/Extent_Report.html",
				"pretty" }, monochrome = true, dryRun = false, strict = true)

public class LoginRunner extends AbstractTestNGCucumberTests {

	String testcasename;
	WebDriverManager driverManager = new WebDriverManager();

	
	  @Parameters("browser")
	  
	  @BeforeClass public void beforeclass(String browser) {
	  
	  testcasename = this.getClass().getSimpleName();
	  
	  System.out.println("***************** " + testcasename +
	  " Test satrting *****************");
	  
	  DOMConfigurator.configure("log4j.xml"); 
	 // "html:target/cucumber-reports/cucumber-pretty", 
	 // "rerun:target/cucumber-reports/rerun.txt"
	  
	  driverManager.launchBrowser(browser);
	  
	  Log.startTestCase(testcasename);
	   }
	 

	@AfterClass(alwaysRun = true)
	public void testDownClass() throws IOException {

		// Reporter.loadXMLConfig(new
		// File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));

		// Reporter.loadXMLConfig(new File(ConfigFileReader.getReportConfigPath()));

		Reporter.addScreenCaptureFromPath("screenshotPath");
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("os", "Window");
		Reporter.setTestRunnerOutput("Sample test runner output message");
		driverManager.quitDriver();
		Log.endTestCase(testcasename);
		System.out.println("***************** " + testcasename + " Test end *****************");

	}

}

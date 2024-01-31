package com.cucumber.PageObjects;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.TestBase.TestBase;
import com.cucumber.utility.Constants;

public class CreateInstitutionPageObjects {
	WebDriver driver;
	Actions act;
	TestBase testbase;
	private final int TIMEOUT_WAIT = 30;
	private final int POOLING_WAIT = 8000;

	//click on Institutions dropdown
	By institutions= By.xpath("//a[normalize-space()='Institutions']");

	//select the Create Institution 
	By create= By.xpath("//a[normalize-space()='Create Institution']");

	// Enter Insitution name and Select state dropdown fields
	By name= By.xpath("//input[@id='institutionName']");
	By state= By.xpath("//*[@id='stateId']/option[25]");

	// Enter City and Address fields
	By city= By.xpath("//input[@id='city']");
	By Address= By.xpath("//input[@id='address']");

	// Upload the logo
	By logo= By.xpath("//input[@id='logo']");
	

	// Select the Network dropdown
	By network= By.xpath("//*[@id='network']/option[2]");

	// Enter the Contact person and Email Id fields
	By contact = By.xpath("//input[@id='contactperson']");
	By email= By.xpath("//input[@id='email']");

	//click on Enable split payment checkbox and enter Razorpay Id
	//By checkbox= By.xpath("//input[@id='myCheck']");
	//By Rpay= By.xpath("//input[@id='recepient']");

	// click on Submit 
	By submit= By.xpath("//input[@id='rcfrmsubmit']");



	public CreateInstitutionPageObjects(WebDriver driver) {
		this.driver = driver;
		testbase = new TestBase();
	}

	public void clickonInstitutionsdropdown() throws InterruptedException {
		WebElement institution = testbase.waitForElement(Constants.driver.findElement(institutions), TIMEOUT_WAIT,POOLING_WAIT);
		Actions action = new Actions(driver);
		action.moveToElement(institution).build().perform();
		Thread.sleep(3000);

	}



	public void selecttheCreateInstitution() throws InterruptedException {
		testbase.waitForElement(Constants.driver.findElement(create), TIMEOUT_WAIT, POOLING_WAIT);
		Constants.driver.findElement(create).click();
		Thread.sleep(2000);
	}	


	public void EnterInstitution() throws InterruptedException {
		testbase.waitForElement(Constants.driver.findElement(name), TIMEOUT_WAIT, POOLING_WAIT);
		Constants.driver.findElement(name).sendKeys("Automation Testing Academy");
		Thread.sleep(2000);

		testbase.waitForElement(Constants.driver.findElement(state), TIMEOUT_WAIT, POOLING_WAIT);
		Constants.driver.findElement(state).click();
		Thread.sleep(2000);
	}
	public void EnterCityAndAddressFields() throws InterruptedException {
		testbase.waitForElement(Constants.driver.findElement(city), TIMEOUT_WAIT, POOLING_WAIT);
		Constants.driver.findElement(city).sendKeys("Hyderabad");
		Thread.sleep(2000);

		testbase.waitForElement(Constants.driver.findElement(Address), TIMEOUT_WAIT, POOLING_WAIT);
		Constants.driver.findElement(Address).sendKeys("Sapphirus Estate, Jubilee Enclave");
		Thread.sleep(2000);
	} 
	public void UploadLogo() throws InterruptedException {
		testbase.waitForElement(Constants.driver.findElement(logo), TIMEOUT_WAIT, POOLING_WAIT);
		String img= "C:\\Users\\srava\\Downloads\\bsecure logo.jpg";
		Constants.driver.findElement(logo);
		WebElement Upload= testbase.waitForElement(Constants.driver.findElement(logo), TIMEOUT_WAIT, POOLING_WAIT);
		//Upload.click();
		//Upload.sendKeys("C:\\Users\\srava\\Downloads\\bsecure logo.jpg");
		Upload.sendKeys(img);
		Thread.sleep(2000);
	}

	public void EnterNetworkDropdown() throws InterruptedException {
		testbase.waitForElement(Constants.driver.findElement(network), TIMEOUT_WAIT, POOLING_WAIT);

		WebElement dropdown = testbase.waitForElement(Constants.driver.findElement(network), TIMEOUT_WAIT, POOLING_WAIT);
		Constants.driver.findElement(network).click();
		Thread.sleep(2000);
	}

	public void EnterContactandEmail() throws InterruptedException {
		testbase.waitForElement(Constants.driver.findElement(contact), TIMEOUT_WAIT, POOLING_WAIT);
		Constants.driver.findElement(contact).sendKeys("Testing Team");
		Thread.sleep(2000);

		testbase.waitForElement(Constants.driver.findElement(email), TIMEOUT_WAIT, POOLING_WAIT);
		Constants.driver.findElement(email).sendKeys("pallavi.p@sapphirus.in");
		Thread.sleep(2000);
	}

	public void EnterSubmit() throws InterruptedException {
		testbase.waitForElement(Constants.driver.findElement(submit), TIMEOUT_WAIT, POOLING_WAIT);
		Constants.driver.findElement(submit).click();
		Thread.sleep(2000);
	
		
	}}
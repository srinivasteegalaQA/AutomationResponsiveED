package com.cucumber.stepdefination;


import com.cucumber.PageObjects.CreateUserPageObj;
import com.cucumber.PageObjects.LoginPageObjects;
import com.cucumber.utility.Constants;
import com.cucumber.utility.TestContext;

import cucumber.api.java.en.*;

public class CreateNewUser {
	TestContext testContext;
	LoginPageObjects login;
	CreateUserPageObj user;

	public CreateNewUser(TestContext context) {
		System.out.println("Started CL2plus1 Step Definition ");
		testContext = context;
		login = testContext.getPageObjectManager().getlogin();
		user = testContext.getPageObjectManager().getcreateUser();
		
	}

	@Given("^login by the Username and Password$")
	public void login_by_the_Username_and_Password() throws Throwable {
		login.Logintoappln("srinivas.test", "Welcome1!");
	}

	@When("^click the UserMenu$")
	public void click_the_UserMenu() throws Throwable {
	    user.clickonUserMenu();
	    Thread.sleep(2000);
	}

	@Then("^Click on The Create Button$")
	public void click_on_The_Create_Button() throws Throwable {
	    user.clickonCreateButton();
	}

	@Then("^Enter data to all fields$")
	public void enter_data_to_all_fields() throws Throwable {
	    user.ResponsiveEDcreateUser(Constants.driver);
	}

	@Then("^Click on create button$")
	public void click_on_create_button() throws Throwable {
	   user.createuser();
	}

	@Then("^click on OK button$")
	public void click_on_OK_button() throws Throwable {
	    user.CreateUserOkButton();
	}

	@And("^SignOut$")
	public void signout() throws Throwable {
	  login.logoutApp();
	}

}

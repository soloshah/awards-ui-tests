package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.SharedYesNoPage;
import com.nhsbsa.finance.pageobjects.WorkingForNHSPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WorkingForNHSStepDefs {
	
	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private WorkingForNHSPage workingForNHSPage;

	SharedYesNoPage sharedYesNoPage;

	@Given("^I am on working for NHS page$")
	public void iAmOnWorkingForNHSPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/are-you-working-in-nhs");
	}

	@Given("^I go to working for NHS page$")
	public void iGoToWorkingForNHSPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/are-you-working-in-nhs");
		workingForNHSPage = new WorkingForNHSPage(driver);
		assertThat(workingForNHSPage.getHeading()).contains("Are you working for the NHS?");
	}

	@Then("^the default value for working for NHS will be blank$")
	public void theDefaultValueForWorkingForNHSWillBeBlank() {
		assertThat(workingForNHSPage.isWorkingForNHSRadioButtonSelected()).isFalse();
	}

	@Then("^are you working for NHS page will be displayed$")
	public void areYouWorkingForNHSPageWillBeDisplayed() {
		workingForNHSPage = new WorkingForNHSPage(driver);
		assertThat(workingForNHSPage.getHeading()).contains("Are you working for the NHS?");
	}

}
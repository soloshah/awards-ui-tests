package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DateOfBirthPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.WorkingForNHSPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WorkingForNHSStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private WorkingForNHSPage workingForNHSPage;

	@Given("^I am on working for NHS page$")
	public void iAmOnWorkingForNHSPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/are-you-working-in-nhs");
	}

	@Given("^I go to working for NHS page$")
	public void iGoToWorkingForNHSPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/are-you-working-in-nhs");
		workingForNHSPage = new WorkingForNHSPage(driver);
		assertThat(workingForNHSPage.getHeading()).contains("Are you for working the NHS?");
	}

	@Then("^the default value for working for NHS will be blank$")
	public void theDefaultValueForWorkingForNHSWillBeBlank() {
		assertThat(workingForNHSPage.isWorkingForNHSRadioButtonSelected()).isFalse();
	}

	@And("^Are you working for NHS error message '(.*)' will be displayed$")
	public void areYouWorkingForNhsErrorMessageWillBeDisplayed(String errorMessage) {
		workingForNHSPage = new WorkingForNHSPage(driver);
		assertThat(workingForNHSPage.getNhsFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I select Yes$")
	public void iSelectYes(String working) {
		workingForNHSPage = new WorkingForNHSPage(driver);
		workingForNHSPage.getWorkingForNhs(working);
		workingForNHSPage.submitValidYesNhsDetails();
	}

	@When("^I select No$")
	public void iSelectNo(String working) {
		workingForNHSPage = new WorkingForNHSPage(driver);
		workingForNHSPage.getWorkingForNhs(working);
		workingForNHSPage.submitValidNoNhsDetails();
	}

	@When("^I dont select anything$")
	public void iDontSelectAnything() {

		workingForNHSPage = new WorkingForNHSPage(driver);
		assertThat(workingForNHSPage.checkWorkingForNHS());
	}
}
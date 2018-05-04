package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.AllocationNamePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllocationNameStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private AllocationNamePage allocationNamePage;
	private String firstName;
	private String lastName;

	@Given("^I am on the allocation name page$")
	public void iAmOnTheAllocationNamePage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-allocation-name");
	}

	@Given("^I go to the allocation name page$")
	public void iGoToTheAllocationNamePage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-allocation-name");
		allocationNamePage = new AllocationNamePage(driver);
		assertThat(allocationNamePage.getHeading())
				.contains("What is the name of the person you want to allocate some of your pension to?");
	}

	@Then("^the allocation name submission will be successful$")
	public void theAllocationNameSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the allocation name page will be displayed$")
	public void theAllocationNamePageWillBeDisplayed() {
		allocationNamePage = new AllocationNamePage(driver);
		assertThat(allocationNamePage.getHeading()).contains("What is the name of the person you want to allocate some of your pension to?");
	}

		
	@When("^I enter valid allocation name$")
	public void IenterValidAllocationName() {

		final String inputFirstName = RandomStringUtils.randomAlphabetic(10);
		SharedData.allocationFirstName = inputFirstName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputFirstName.toLowerCase().substring(1);
		final String inputLastName = RandomStringUtils.randomAlphabetic(10);
		SharedData.allocationLastName = inputLastName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputLastName.toLowerCase().substring(1);
		allocationNamePage = new AllocationNamePage(driver);
		allocationNamePage.submitAllocationName(SharedData.allocationFirstName, SharedData.allocationLastName);
	}


	@Then("^the allocation name submission will be unsuccessful$")
	public void theChildNameSubmissionWillBeUnsuccessful() {
		allocationNamePage = new AllocationNamePage(driver);
		assertThat(allocationNamePage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(allocationNamePage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@And("^the allocation first name error message '(.*)' will be displayed$")
	public void theChildFirstNameErrorMessageWillBeDisplayed(String errorMessage) {
		allocationNamePage = new AllocationNamePage(driver);
		assertThat(allocationNamePage.doesAllocationFirstNameErrorMessageHaveAnchor()).isTrue();
		assertThat(allocationNamePage.getAllocationFirstNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(allocationNamePage.getAllocationFirstNameFieldErrorMessage()).matches(errorMessage);

	}

	@And("^the allocation last name error message '(.*)' will be displayed$")
	public void theChildLastNameErrorMessageWillBeDisplayed(String errorMessage) {
		allocationNamePage = new AllocationNamePage(driver);
		assertThat(allocationNamePage.doesAllocationLastNameErrorMessageHaveAnchor()).isTrue();
		assertThat(allocationNamePage.getAllocationLastNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(allocationNamePage.getAllocationLastNameFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter an invalid allocation details using the (.*) '(.*)'$")
	public void iEnterAnInvalidAllocationDetailsUsingFieldValue(String field, String value) {
		setAllocationNameDetails();

		switch (field) {
		case "firstName":
			firstName = value;
			break;
		case "lastName":
			lastName = value;
			break;
		}
		allocationNamePage = new AllocationNamePage(driver);
		allocationNamePage.enterAllocationNameDetails(firstName, lastName);
		allocationNamePage.submitInValidAllocationNameDetails();
	}

	@When("^I enter an invalid allocation name using the firstName '(.*)' and lastName '(.*)'$")
	public void iEnterAnInvalidAllocationNameUsingTheFirstNameAndLastName(String firstName, String lastName) {
		allocationNamePage = new AllocationNamePage(driver);
		allocationNamePage.enterAllocationNameDetails(firstName, lastName);
		allocationNamePage.submitInValidAllocationNameDetails();
	}

	@Then("^The length of allocation first and last name is verified$")
	public void theLengthOfAllocationFirstAndLastNameIsVerified() {
		allocationNamePage = new AllocationNamePage(driver);
		assertThat(allocationNamePage.readAllocationFirstNameField()).matches("InvalidIn@validInvalidIn");
		assertThat(allocationNamePage.readAllocationLastNameField()).matches("InvalidIn@validInvalidIn");
	}

	private void setAllocationNameDetails() {
		firstName = "Allocation Test";
		lastName = "Allocation User";

	}
	
	@When("^I click next on allocation name page$")
	public void iClickNextOnAllocationNamePage() {
		allocationNamePage = new AllocationNamePage(driver);
		allocationNamePage.nextStep();
	}

	@Then("^the allocatePensionName details are sustained$")
	public void theAllocateNameDetailsAreSustained() {
		allocationNamePage = new AllocationNamePage(driver);
		assertThat(allocationNamePage.getFirstNameDetails()).matches(SharedData.allocationFirstName);
		assertThat(allocationNamePage.getLastNameDetails()).matches(SharedData.allocationLastName);
	}

	@When("^I enter allocatePensionName using different valid details$")
	public void iEnterAllocatePensionNameUsingDifferentDetails() {

		final String inputFirstName = RandomStringUtils.randomAlphabetic(10);
		SharedData.allocationFirstName = inputFirstName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputFirstName.toLowerCase().substring(1);
		final String inputLastName = RandomStringUtils.randomAlphabetic(10);
		SharedData.allocationLastName = inputLastName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputLastName.toLowerCase().substring(1);
		allocationNamePage = new AllocationNamePage(driver);
		allocationNamePage.submitAllocationName(SharedData.allocationFirstName, SharedData.allocationLastName);
	}


}

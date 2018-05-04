package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.PartnerNamePage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PartnerNameStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private PartnerNamePage partnerNamePage;
	private String firstName;
	private String lastName;

	@Given("^I am on the partner name page$")
	public void iAmOnThePartnerNamePage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-your-partner-name");
	}

	@Given("^I go to the partner name page$")
	public void iGoToThePartnerNamePage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-your-partner-name");
		partnerNamePage = new PartnerNamePage(driver);
		assertThat(partnerNamePage.getHeading()).contains("What is your spouse's or civil partner's name?");
	}

	@Then("^the partner name page will be displayed$")
	public void thePartnerNamePageWillBeDisplayed() {
		partnerNamePage = new PartnerNamePage(driver);
		assertThat(partnerNamePage.getHeading()).contains("What is your spouse's or civil partner's name?");
	}

	
	@Then("^the partner name submission will be successful$")
	public void thePartnerNameSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	
	
	@When("^I enter valid partner name details$")
	public void IenterValidPartnerNameDetails() {
		
		final String inputFirstName = RandomStringUtils.randomAlphabetic(10);
		SharedData.firstName = inputFirstName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputFirstName.toLowerCase().substring(1);
		final String inputLastName = RandomStringUtils.randomAlphabetic(10);
		SharedData.lastName = inputLastName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputLastName.toLowerCase().substring(1);
		partnerNamePage = new PartnerNamePage(driver);
		partnerNamePage.submitValidPartnerNameDetails(SharedData.firstName, SharedData.lastName);
	}

	@Then("^the partner name submission will be unsuccessful$")
	public void thePartnerNameSubmissionWillBeUnsuccessful() {
		partnerNamePage = new PartnerNamePage(driver);
		assertThat(partnerNamePage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(partnerNamePage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@And("^the partner first name error message '(.*)' will be displayed$")
	public void thePartnerFirstNameErrorMessageWillBeDisplayed(String errorMessage) {
		partnerNamePage = new PartnerNamePage(driver);
		assertThat(partnerNamePage.doesPartnerFirstNameErrorMessageHaveAnchor()).isTrue();
		assertThat(partnerNamePage.getPartnerFirstNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(partnerNamePage.getPartnerFirstNameFieldErrorMessage()).matches(errorMessage);

	}

	@And("^the partner last name error message '(.*)' will be displayed$")
	public void thePartnerLastNameErrorMessageWillBeDisplayed(String errorMessage) {
		partnerNamePage = new PartnerNamePage(driver);
		assertThat(partnerNamePage.doesPartnerLastNameErrorMessageHaveAnchor()).isTrue();
		assertThat(partnerNamePage.getPartnerLastNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(partnerNamePage.getPartnerLastNameFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter an invalid partner details using the (.*) '(.*)'$")
	public void iEnterAnInvalidPartnerDetailsUsingFieldValue(String field, String value) {
		setPartnerNameDetails();

		switch (field) {
		case "firstName":
			firstName = value;
			break;
		case "lastName":
			lastName = value;
			break;
		}
		partnerNamePage = new PartnerNamePage(driver);
		partnerNamePage.enterPartnerNameDetails(firstName, lastName);
		partnerNamePage.submitInValidPartnerNameDetails();
	}

	@When("^I enter an invalid partner name using the firstName '(.*)' and lastName '(.*)'$")
	public void iEnterAnInvalidPartnerNameDetailsUsingTheFirstNameAndLastName(String firstName, String lastName) {
		partnerNamePage = new PartnerNamePage(driver);
		partnerNamePage.enterPartnerNameDetails(firstName, lastName);
		partnerNamePage.submitInValidPartnerNameDetails();
	}

	@Then("^The length of partner first and last name is verified$")
	public void theLengthOfPartnerFirstAndLastNameIsVerified() {
		partnerNamePage = new PartnerNamePage(driver);
		assertThat(partnerNamePage.readPartnerFirstNameField()).matches("InvalidIn@validInvalidIn");
		assertThat(partnerNamePage.readPartnerLastNameField()).matches("InvalidIn@validInvalidIn");
	}

	private void setPartnerNameDetails() {
		firstName = "Partner-Test";
		lastName = "User";

	}

	@And("^I submit valid partner first and last name details$")
	public void iSubmitValidPartnerFirstAndLastNameDetails() {

		final String inputFirstName = RandomStringUtils.randomAlphabetic(10);
		SharedData.firstName = inputFirstName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputFirstName.toLowerCase().substring(1);
		final String inputLastName = RandomStringUtils.randomAlphabetic(10);
		SharedData.lastName = inputLastName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputLastName.toLowerCase().substring(1);
		partnerNamePage = new PartnerNamePage(driver);
		partnerNamePage.submitValidPartnerNameDetails(SharedData.firstName, SharedData.lastName);
	}
	
	
	@When("^I click next on partner name page$")
	public void iClickNextOnPartnerNamePage() {
		partnerNamePage = new PartnerNamePage(driver);
		partnerNamePage.nextStep();
	}

	@Then("^the partnerName details are sustained$")
	public void thePartnerNameDetailsAreSustained() {
		partnerNamePage = new PartnerNamePage(driver);
		assertThat(partnerNamePage.getFirstNameDetails()).matches(SharedData.firstName);
		assertThat(partnerNamePage.getLastNameDetails()).matches(SharedData.lastName);
	}

	@When("^I enter partner name using different valid details$")
	public void iEnterPartnerNameUsingDifferentDetails() {

		final String inputFirstName = RandomStringUtils.randomAlphabetic(10);
		SharedData.firstName = inputFirstName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputFirstName.toLowerCase().substring(1);
		final String inputLastName = RandomStringUtils.randomAlphabetic(10);
		SharedData.lastName = inputLastName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputLastName.toLowerCase().substring(1);
		partnerNamePage = new PartnerNamePage(driver);
		partnerNamePage.submitValidPartnerNameDetails(SharedData.firstName, SharedData.lastName);
	}
	
}

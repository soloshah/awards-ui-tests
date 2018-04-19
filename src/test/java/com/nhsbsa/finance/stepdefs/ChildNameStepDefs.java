package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ChildNamePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChildNameStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private ChildNamePage childNamePage;
	
	private String firstName;
	private String lastName;

	@Given("^I am on the child name page$")
	public void iAmOnTheChildNamePage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-your-child-name");
	}

	@Given("^I go to the child name page$")
	public void iGoToTheChildNamePage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-your-child-name");
		childNamePage = new ChildNamePage(driver);
		 assertThat(childNamePage.getHeading()).contains("What is your child's name?");
	}

	@Then("^the child name page will be displayed$")
	public void theChildNamePageWillBeDisplayed() {
		childNamePage = new ChildNamePage(driver);
		assertThat(childNamePage.getHeading()).contains("What is your child's name?");
	}

	@Then("^the child name submission will be successful$")
	public void theChildNameSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@When("^I enter valid child name details$")
	public void IenterValidChildNameDetails() {

		SharedData.childFirstName = RandomStringUtils.randomAlphabetic(10);
		SharedData.childLastName = RandomStringUtils.randomAlphabetic(10);

		childNamePage = new ChildNamePage(driver);
		childNamePage.submitValidChildNameDetails(SharedData.childFirstName, SharedData.childLastName);
	}
	
	@When("^I enter valid child name$")
	public void IenterValidChildName() {

		SharedData.childFirstName = "Brian";
		SharedData.childLastName = "Stark";

		childNamePage = new ChildNamePage(driver);
		childNamePage.submitValidChildNameDetails(SharedData.childFirstName, SharedData.childLastName);
	}

	@Then("^the child name submission will be unsuccessful$")
	public void theChildNameSubmissionWillBeUnsuccessful() {
		childNamePage = new ChildNamePage(driver);
		assertThat(childNamePage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly.");
		assertThat(childNamePage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@And("^the child first name error message '(.*)' will be displayed$")
	public void theChildFirstNameErrorMessageWillBeDisplayed(String errorMessage) {
		childNamePage = new ChildNamePage(driver);
		assertThat(childNamePage.doesChildFirstNameErrorMessageHaveAnchor()).isTrue();
		assertThat(childNamePage.getChildFirstNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(childNamePage.getChildFirstNameFieldErrorMessage()).matches(errorMessage);

	}

	@And("^the child last name error message '(.*)' will be displayed$")
	public void theChildLastNameErrorMessageWillBeDisplayed(String errorMessage) {
		childNamePage = new ChildNamePage(driver);
		assertThat(childNamePage.doesChildLastNameErrorMessageHaveAnchor()).isTrue();
		assertThat(childNamePage.getChildLastNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(childNamePage.getChildLastNameFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter an invalid child details using the (.*) '(.*)'$")
	public void iEnterAnInvalidChildDetailsUsingFieldValue(String field, String value) {
		setChildNameDetails();

		switch (field) {
		case "firstName":
			firstName = value;
			break;
		case "lastName":
			lastName = value;
			break;
		}
		childNamePage = new ChildNamePage(driver);
		childNamePage.enterChildNameDetails(firstName, lastName);
		childNamePage.submitInValidChildNameDetails();
	}

	@When("^I enter an invalid child name using the firstName '(.*)' and lastName '(.*)'$")
	public void iEnterAnInvalidChildNameUsingTheFirstNameAndLastName(String firstName, String lastName) {
		childNamePage = new ChildNamePage(driver);
		childNamePage.enterChildNameDetails(firstName, lastName);
		childNamePage.submitInValidChildNameDetails();
	}

	@Then("^The length of child first and last name is verified$")
	public void theLengthOfChildFirstAndLastNameIsVerified() {
		childNamePage = new ChildNamePage(driver);
		assertThat(childNamePage.readChildFirstNameField()).matches("InvalidIn@validInvalidIn");
		assertThat(childNamePage.readChildLastNameField()).matches("InvalidIn@validInvalidIn");
	}

	@When("^I enter valid child first and last name details$")
	public void IenterValidChildFirstAndLastNameDetails() {

		final String inputFirstName = RandomStringUtils.randomAlphabetic(10);
		SharedData.childFirstName = inputFirstName.toLowerCase().substring(0, 1).toUpperCase() + inputFirstName.toLowerCase().substring(1);
		final String inputLastName = RandomStringUtils.randomAlphabetic(10);
		SharedData.childLastName = inputLastName.toLowerCase().substring(0, 1).toUpperCase() + inputLastName.toLowerCase().substring(1);
		SharedData.fullName.add(SharedData.childFirstName + " " + SharedData.childLastName);
		childNamePage = new ChildNamePage(driver);
		childNamePage.submitValidChildNameDetails(SharedData.childFirstName, SharedData.childLastName);
	}

	private void setChildNameDetails() {
		firstName = RandomStringUtils.randomAlphabetic(10);
		lastName = RandomStringUtils.randomAlphabetic(10);

	}

}

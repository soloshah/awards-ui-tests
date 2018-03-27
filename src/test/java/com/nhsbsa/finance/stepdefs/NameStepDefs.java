package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NamePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.StartPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NameStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private NamePage namePage;
	private String title;
	private String firstName;
	private String lastName;

	@Given("^I am on the name page$")
	public void iAmOnTheNamePage() {

		new Page(driver).navigateToUrl(baseUrl + "/personal-details/what-is-your-name");
		StartPage startPage = new StartPage(driver);
		startPage.startNow();
	}

	@When("^I go to the name page$")
	public void iGoToTheNamePage() {
		namePage = new NamePage(driver);
		new Page(driver).navigateToUrl(baseUrl + "/personal-details/what-is-your-name");
	}

	@Then("^the name page will be displayed$")
	public void theChildNamePageWillBeDisplayed() {
		namePage = new NamePage(driver);
		assertThat(namePage.getHeading()).contains("What is your name?");
	}

	@Then("^the name details are sustained$")
	public void theNameDetailsAreSustained() {
		namePage = new NamePage(driver);
		assertThat(namePage.getTitleDetails()).matches(SharedData.title);
		assertThat(namePage.getFirstNameDetails()).matches(SharedData.firstName);
		assertThat(namePage.getLastNameDetails()).matches(SharedData.lastName);
	}

	@When("^I enter valid title using the title '(.*)'$")
	public void IenterValidTitleUsingTitle(String title) {
		namePage = new NamePage(driver);
		namePage.enterTitle(title);
	}

	@When("^I enter name details using different valid details$")
	public void iEnterNameDetailsUsingDifferentDetails() {
		SharedData.title = "M/S";
		namePage = new NamePage(driver);
		namePage.enterTitle(SharedData.title);
		IenterValidFirstAndLastName();
	}

	@Then("^the name submission will be successful$")
	public void theNameSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@When("^I enter valid first and last name$")
	public void IenterValidFirstAndLastName() {
		final String inputFirstName = RandomStringUtils.randomAlphabetic(10);
		SharedData.firstName = inputFirstName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputFirstName.toLowerCase().substring(1);
		final String inputLastName = RandomStringUtils.randomAlphabetic(10);
		SharedData.lastName = inputLastName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputLastName.toLowerCase().substring(1);

		namePage = new NamePage(driver);
		namePage.enterNames(SharedData.firstName, SharedData.lastName);
	}

	@When("^I enter valid name details$")
	public void IenterValidNameDetails() {
		SharedData.title = "MR";
		final String inputFirstName = RandomStringUtils.randomAlphabetic(10);
		SharedData.firstName = inputFirstName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputFirstName.toLowerCase().substring(1);
		final String inputLastName = RandomStringUtils.randomAlphabetic(10);
		SharedData.lastName = inputLastName.toLowerCase().substring(0, 1).toUpperCase()
				+ inputLastName.toLowerCase().substring(1);

		namePage = new NamePage(driver);
		namePage.submitValidNameDetails(SharedData.title, SharedData.firstName, SharedData.lastName);
	}

	@Then("^the name submission will be unsuccessful$")
	public void theNameSubmissionWillBeUnsuccessful() {
		namePage = new NamePage(driver);
		assertThat(namePage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(namePage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@And("^the (.*) error message '(.*)' will be displayed$")
	public void theErrorMessageWillBeDisplayed(String field, String errorMessage) {
		namePage = new NamePage(driver);
		switch (field) {
		case "firstName":
			assertThat(namePage.doesFirstNameErrorMessageHaveAnchor()).isTrue();
			assertThat(namePage.getFirstNameAnchoredErrorMessage()).matches(errorMessage);
			assertThat(namePage.getFirstNameFieldErrorMessage()).matches(errorMessage);
			break;
		case "lastName":
			assertThat(namePage.doesLastNameErrorMessageHaveAnchor()).isTrue();
			assertThat(namePage.getLastNameAnchoredErrorMessage()).matches(errorMessage);
			assertThat(namePage.getLastNameFieldErrorMessage()).matches(errorMessage);
			break;
		case "title":
			assertThat(namePage.doesTitleErrorMessageHaveAnchor()).isTrue();
			assertThat(namePage.getTitleAnchoredErrorMessage()).matches(errorMessage);
			assertThat(namePage.getTitleFieldErrorMessage()).matches(errorMessage);
			break;
		}
	}

	@When("^I enter an invalid details using the (.*) '(.*)'$")
	public void iEnterAnInvalidDetailsUsingFieldValue(String field, String value) {
		setNameDetails();
		switch (field) {
		case "title":
			title = value;
			break;
		case "firstName":
			firstName = value;
			break;
		case "lastName":
			lastName = value;
			break;
		}
		namePage = new NamePage(driver);
		namePage.enterNameDetails(title, firstName, lastName);
		namePage.submitInValidNameDetails();
	}

	@When("^I enter valid name details using the title '(.*)', firstName '(.*)' and lastName '(.*)'$")
	public void iEnterValidNameDetailsUsingTheTitleFirstNameAndLastName(String title, String firstName,
			String lastName) {
		namePage = new NamePage(driver);
		namePage.enterNameDetails(title, firstName, lastName);
		namePage.submitInValidNameDetails();
	}

	@Then("^The length of title,first and last name is verified$")
	public void theLengthOfTitleFirstAndLastNameIsVerified() {
		namePage = new NamePage(driver);
		assertThat(namePage.readTitleField()).matches("AA@A");
		assertThat(namePage.readFirstNameField()).matches("InvalidIn@validInvalidInv");
		assertThat(namePage.readLastNameField()).matches("InvalidIn@validInvalidInvalidInv");
	}

	private void setNameDetails() {
		title = "Mrs";
		firstName = "Test";
		lastName = "User";

	}

}
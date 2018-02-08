package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DateOfBirthPage;
import com.nhsbsa.finance.pageobjects.DateYouLeavePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DateYouLeaveStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private DateYouLeavePage dateYouLeavePage;

/*	@Given("^I am on DOB page$")
	public void iAmOnTheDOBPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dob");
	}

	@Then("^the date of birth submission will be successful$")
	public void theDateOfBirthSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}*/

	@Then("^the date you leave page will be displayed$")
	public void theDateOfBirthPageWillBeDisplayed() {
		dateYouLeavePage = new DateYouLeavePage(driver);
		assertThat(dateYouLeavePage.getHeading()).matches("What date did you leave?");
	}

	/*@When("^I enter valid DOB details$")
	public void IenterValidDOBDetails() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.day = SharedMethods.formatDay(localDate);
		SharedData.month = SharedMethods.formatMonth(localDate);
		SharedData.year = SharedMethods.formatYear(localDate);
		dateOfBirthPage = new DateOfBirthPage(driver);
		dateOfBirthPage.submitValidDOBDetails(SharedData.day, SharedData.month, SharedData.year);
	}

	@Then("^the date of birth submission will be unsuccessful$")
	public void theDateOfBirthSubmissionWillBeUnsuccessful() {
		dateOfBirthPage = new DateOfBirthPage(driver);
		assertThat(dateOfBirthPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly.");
		assertThat(dateOfBirthPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter DOB details using the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterDOBDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		dateOfBirthPage = new DateOfBirthPage(driver);
		dateOfBirthPage.enterDobDetails(SharedData.day, SharedData.month, SharedData.year);
		dateOfBirthPage.submitInValidDOBDetails();

	}

	@And("^the date of birth error message '(.*)' will be displayed$")
	public void theDateOfBirthErrorMessageWillBeDisplayed(String errorMessage) {
		dateOfBirthPage = new DateOfBirthPage(driver);
		assertThat(dateOfBirthPage.doesDobErrorMessageHaveAnchor()).isTrue();
		assertThat(dateOfBirthPage.getDobAnchoredErrorMessage()).matches(errorMessage);
		assertThat(dateOfBirthPage.getDobFieldErrorMessage()).matches(errorMessage);
	}

	@Then("^the past date of birth error message '(.*)' will be displayed$")
	public void thePastDateOfBirthErrorMessageWillBeDisplayed(String errorMessage) {
		dateOfBirthPage = new DateOfBirthPage(driver);
		assertThat(dateOfBirthPage.doesDobErrorMessageHaveAnchor()).isTrue();
		assertThat(dateOfBirthPage.getDobAnchoredErrorMessage()).matches(errorMessage);
		assertThat(dateOfBirthPage.getDobPastFieldErrorMessage()).matches(errorMessage);
	}

	@Then("^the date of birth for 16 years error message '(.*)' will be displayed$")
	public void theDateOfBirthFor16YearsErrorMessageWillBeDisplayed(String errorMessage) {
		dateOfBirthPage = new DateOfBirthPage(driver);
		assertThat(dateOfBirthPage.doesDobErrorMessageHaveAnchor()).isTrue();
		assertThat(dateOfBirthPage.getDobAnchoredErrorMessage()).matches(errorMessage);
		assertThat(dateOfBirthPage.getDobLaterFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter DOB equal or greater than today's date$")
	public void iEnterDOBEqualorGreaterThanTodaysDate() {

		LocalDate date = LocalDate.now().plusDays(1);
		SharedData.day = SharedMethods.formatDay(date);
		SharedData.month = SharedMethods.formatMonth(date);
		SharedData.year = SharedMethods.formatYear(date);

		dateOfBirthPage = new DateOfBirthPage(driver);
		dateOfBirthPage.enterDobDetails(SharedData.day, SharedData.month, SharedData.year);
		dateOfBirthPage.submitInValidDOBDetails();

	}

	@When("^I enter DOB less than 16 years from today's date$")
	public void iEnterDOBLessThan16YearsFromTodaysDate() {
		LocalDate date = LocalDate.now().minusYears(16);
		SharedData.day = SharedMethods.formatDay(date);
		SharedData.month = SharedMethods.formatMonth(date);
		SharedData.year = SharedMethods.formatYear(date);
		dateOfBirthPage = new DateOfBirthPage(driver);
		dateOfBirthPage.enterDobDetails(SharedData.day, SharedData.month, SharedData.year);
		dateOfBirthPage.submitInValidDOBDetails();
	}*/
}

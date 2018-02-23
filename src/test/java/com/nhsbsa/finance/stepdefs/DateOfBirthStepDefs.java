package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DateOfBirthPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DateOfBirthStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private DateOfBirthPage dateOfBirthPage;

	@Given("^I am on DOB page$")
	public void iAmOnTheDOBPage() {

		new Page(driver).navigateToUrl(baseUrl + "/personal-details/what-is-your-dob");
		dateOfBirthPage = new DateOfBirthPage(driver);
		assertThat(dateOfBirthPage.getHeading()).contains("What is your date of birth?");
	}

	@When("^I go to DOB page$")
	public void iGoToDOBPage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/personal-details/what-is-your-dob");
		dateOfBirthPage = new DateOfBirthPage(driver);
		assertThat(dateOfBirthPage.getHeading()).contains("What is your date of birth?");
		assertThat(dateOfBirthPage.getExampleHintMessage().matches("For example, 31 03 1980"));
	}

	@Then("^the date of birth submission will be successful$")
	public void theDateOfBirthSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
		
	}

	@Then("^the date of birth page will be displayed$")
	public void theDateOfBirthPageWillBeDisplayed() {
		dateOfBirthPage = new DateOfBirthPage(driver);
		assertThat(dateOfBirthPage.getHeading()).contains("What is your date of birth?");
	}

	@When("^I enter valid DOB details$")
	public void IenterValidDOBDetails() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.day = SharedMethods.formatDay(localDate);
		SharedData.month = SharedMethods.formatMonth(localDate);
		SharedData.year = SharedMethods.formatYear(localDate);
		dateOfBirthPage = new DateOfBirthPage(driver);
		dateOfBirthPage.submitValidDateDetails(SharedData.day, SharedData.month, SharedData.year);
	}

	@Then("^the date of birth submission will be unsuccessful$")
	public void theDateOfBirthSubmissionWillBeUnsuccessful() {
		dateOfBirthPage = new DateOfBirthPage(driver);
		assertThat(dateOfBirthPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly:");
		assertThat(dateOfBirthPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter DOB details using the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterDOBDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		dateOfBirthPage = new DateOfBirthPage(driver);
		dateOfBirthPage.enterDobDetails(day, month, year);
		dateOfBirthPage.submitInValidDOBDetails();

	}

	@And("^the date of birth error message '(.*)' will be displayed$")
	public void theDateOfBirthErrorMessageWillBeDisplayed(String errorMessage) {
		dateOfBirthPage = new DateOfBirthPage(driver);
		assertThat(dateOfBirthPage.doesDobErrorMessageHaveAnchor()).isTrue();
		assertThat(dateOfBirthPage.getDobAnchoredErrorMessage()).matches(errorMessage);
		assertThat(dateOfBirthPage.getDobFieldErrorMessage()).matches(errorMessage);
	}

	@Then("^the date of birth for 16 years error message '(.*)' will be displayed$")
	public void theDateOfBirthFor16YearsErrorMessageWillBeDisplayed(String errorMessage) {
		dateOfBirthPage = new DateOfBirthPage(driver);
		assertThat(dateOfBirthPage.getDobFieldErrorMessage()).matches(errorMessage);
		assertThat(dateOfBirthPage.doesDobErrorMessageHaveAnchor()).isTrue();
		assertThat(dateOfBirthPage.getDobAnchoredErrorMessage()).matches(errorMessage);
	}

	@And("^I enter DOB less than 16 years from today's date$")
	public void iEnterDOBLessThan16YearsFromTodaysDate() {
		LocalDate minusYear = LocalDate.now().plusDays(1).minusYears(16);
		SharedData.day = SharedMethods.formatDay(minusYear);
		SharedData.month = SharedMethods.formatMonth(minusYear);
		SharedData.year = SharedMethods.formatYear(minusYear);
		dateOfBirthPage = new DateOfBirthPage(driver);
		dateOfBirthPage.enterDobDetails(SharedData.day, SharedData.month, SharedData.year);
		dateOfBirthPage.submitInValidDOBDetails();
	}
}

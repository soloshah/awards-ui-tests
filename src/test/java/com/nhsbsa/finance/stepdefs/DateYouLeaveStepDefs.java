package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
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

	@Given("^I am on date you leave page$")
	public void iAmOnDateYouLeavePage() {

		new Page(driver).navigateToUrl(baseUrl + "/employment-details/when-did-you-leave");
		dateYouLeavePage = new DateYouLeavePage(driver);
		assertThat(dateYouLeavePage.getHeading()).contains("What date did you leave?");
	}

	@When("^I go to date you leave page$")
	public void iGoToDateYouLeavePage() {

		new Page(driver).navigateToUrl(baseUrl + "/employment-details/when-did-you-leave");
		dateYouLeavePage = new DateYouLeavePage(driver);
		assertThat(dateYouLeavePage.getHeading().contains("What date did you leave?"));
		assertThat(dateYouLeavePage.getExampleHint().matches("For example, 31 03 1980"));
	}

	@Then("^the the date you leave submission will be successful$")
	public void theDateYouleaveSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the date you leave page will be displayed$")
	public void theDateYouleavePageWillBeDisplayed() {
		dateYouLeavePage = new DateYouLeavePage(driver);
		assertThat(dateYouLeavePage.getHeading()).contains("What date did you leave?");
	}

	@When("^I enter valid date details$")
	public void IenterValidDateDetails() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.day = SharedMethods.formatDay(localDate);
		SharedData.month = SharedMethods.formatMonth(localDate);
		SharedData.year = SharedMethods.formatYear(localDate);
		dateYouLeavePage = new DateYouLeavePage(driver);
		dateYouLeavePage.submitValidDate(SharedData.day, SharedData.month, SharedData.year);
	}

	@When("^I click next on date you leave page$")
	public void iClickNextOnDateYouLeavePage() {
		dateYouLeavePage = new DateYouLeavePage(driver);
		dateYouLeavePage.nextStep();
	}

	@Then("^the date you leave submission will be unsuccessful$")
	public void theDateYouLeaveSubmissionWillBeUnsuccessful() {
		dateYouLeavePage = new DateYouLeavePage(driver);
		assertThat(dateYouLeavePage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly:");
		assertThat(dateYouLeavePage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter invalid date using the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterInvalidDateUsingTheDayMonthAndYear(String day, String month, String year) {

		dateYouLeavePage = new DateYouLeavePage(driver);
		dateYouLeavePage.enterDateDetails(day, month, year);
		dateYouLeavePage.submitInValidDateDetails();
	}

	@And("^the date you leave error message '(.*)' will be displayed$")
	public void theDateYouLeaveErrorMessageWillBeDisplayed(String errorMessage) {
		dateYouLeavePage = new DateYouLeavePage(driver);
		assertThat(dateYouLeavePage.doesDateErrorMessageHaveAnchor()).isTrue();
		assertThat(dateYouLeavePage.getDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(dateYouLeavePage.getDateFieldErrorMessage()).matches(errorMessage);
	}

	@And("^I enter the date greater than today's date$")
	public void iEnterTheDateGreaterThanTodaysDate() {
		LocalDate pastdate = LocalDate.now().plusDays(1);
		SharedData.day = SharedMethods.formatDay(pastdate);
		SharedData.month = SharedMethods.formatMonth(pastdate);
		SharedData.year = SharedMethods.formatYear(pastdate);
		dateYouLeavePage = new DateYouLeavePage(driver);
		dateYouLeavePage.enterDateDetails(SharedData.day, SharedData.month, SharedData.year);
		dateYouLeavePage.submitInValidDateDetails();
	}

	@Then("^the date you leave details are sustained$")
	public void theDateYouLeaveDetailsAreSustained() {
		dateYouLeavePage = new DateYouLeavePage(driver);
		assertThat(dateYouLeavePage.getDay()).matches(SharedData.day);
		assertThat(dateYouLeavePage.getMonth()).matches(SharedData.month);
		assertThat(dateYouLeavePage.getYear()).matches(SharedData.year);
	}

	@When("^I enter date you leave using different valid details$")
	public void iEnterDateYouLeaveUsingDifferentDetails() {
		IenterValidDateDetails();
	}
}

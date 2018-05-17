package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.LastDayOfWorkPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LastDayOfWorkStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private LastDayOfWorkPage lastDayOfWorkPage;

	@When("^I go to last day of work page$")
	public void iGoToLastDayOfWorkPage() {

		new Page(driver).navigateToUrl(baseUrl + "/employment-details/when-will-your-last-day-of-work-be");
		lastDayOfWorkPage = new LastDayOfWorkPage(driver);
		assertThat(lastDayOfWorkPage.getHeading().contains("When will be your last day of work?"));
		assertThat(lastDayOfWorkPage.getExampleDateHint().matches("For example, 31 03 1980"));
	}

	@Then("^the last day of work submission will be successful$")
	public void theLastDayOfWorkSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the last day of work page will be displayed$")
	public void theLastDayOfWorkPageWillBeDisplayed() {
		lastDayOfWorkPage = new LastDayOfWorkPage(driver);
		assertThat(lastDayOfWorkPage.getHeading()).contains("When will be your last day of work?");
	}
	

	@When("^I click next on last day of work page$")
	public void iClickNextOnLastDayOfWorkPage() {
		lastDayOfWorkPage = new LastDayOfWorkPage(driver);
		lastDayOfWorkPage.nextStep();
	}

	@Then("^the lastDayOfWork details are sustained$")
	public void theLastDayOfWorkDetailsAreSustained() {
		lastDayOfWorkPage = new LastDayOfWorkPage(driver);
		//assertThat(lastDayOfWorkPage.getDay()).matches(SharedData.day);
		//assertThat(lastDayOfWorkPage.getMonth()).matches(SharedData.month);
		assertThat(lastDayOfWorkPage.getYear()).matches(SharedData.year);

	}

	@When("^I enter lastDayOfWork using different valid details$")
	public void iEnterLastDayOfWorkUsingDifferentDetails() {
		IenterValidDateForLastDayOfWork();
	}

	
	@When("^I enter valid date for last day of work$")
	public void IenterValidDateForLastDayOfWork() {
		LocalDate futureDate = LocalDate.now().plusDays(1);
		SharedData.day = SharedMethods.formatDay(futureDate);
		SharedData.month = SharedMethods.formatMonth(futureDate);
		SharedData.year = SharedMethods.formatYear(futureDate);
		lastDayOfWorkPage = new LastDayOfWorkPage(driver);
		lastDayOfWorkPage.submitValidDateDetails(SharedData.day, SharedData.month, SharedData.year);
	}

	@Then("^the last day of work submission will be unsuccessful$")
	public void theLastDayOfWorkSubmissionWillBeUnsuccessful() {
		lastDayOfWorkPage = new LastDayOfWorkPage(driver);
		assertThat(lastDayOfWorkPage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(lastDayOfWorkPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I enter invalid date for last day of work using the day '(.*)', month '(.*)' and year '(.*)'$")
	public void iEnterInvalidDateForLastDayOfWorkUsingTheDayMonthAndYear(String day, String month, String year) {

		lastDayOfWorkPage = new LastDayOfWorkPage(driver);
		lastDayOfWorkPage.enterDateDetails(day, month, year);
		lastDayOfWorkPage.submitInValidDateDetails();
	}

	@And("^the last day of work error message '(.*)' will be displayed$")
	public void theLastDayOfWorkErrorMessageWillBeDisplayed(String errorMessage) {
		lastDayOfWorkPage = new LastDayOfWorkPage(driver);
		assertThat(lastDayOfWorkPage.doesLastDayErrorMessageHaveAnchor()).isTrue();
		assertThat(lastDayOfWorkPage.getLastDayAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lastDayOfWorkPage.getlastDayFieldErrorMessage()).matches(errorMessage);
	}

	@And("^I enter the date less than or equal to today's date$")
	public void iEnterTheDateLessThanOrEqualToTodaysDate() {
		LocalDate pastDate = LocalDate.now().minusDays(1);
		SharedData.day = SharedMethods.formatDay(pastDate);
		SharedData.month = SharedMethods.formatMonth(pastDate);
		SharedData.year = SharedMethods.formatYear(pastDate);
		lastDayOfWorkPage = new LastDayOfWorkPage(driver);
		lastDayOfWorkPage.enterDateDetails(SharedData.day, SharedData.month, SharedData.year);
		lastDayOfWorkPage.submitInValidDateDetails();
	}
}

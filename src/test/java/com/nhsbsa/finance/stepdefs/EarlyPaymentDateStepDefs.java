package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.EarlyPaymentDatePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EarlyPaymentDateStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private EarlyPaymentDatePage earlyPaymentDatePage;

	@Given("^I am on early payment date page$")
	public void iAmOnTheEarlyPaymentDatePage() {

		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/1995-early-payment-date");
		earlyPaymentDatePage = new EarlyPaymentDatePage(driver);
		assertThat(earlyPaymentDatePage.getHeading()).contains("When should the early payment of deferred benefit start?");
	}

	@When("^I go to the early payment date page$")
	public void iGoToTheEarlyPaymentDatePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/1995-early-payment-date");
		earlyPaymentDatePage = new EarlyPaymentDatePage(driver);
		assertThat(earlyPaymentDatePage.getHeading()).contains("When should the early payment of deferred benefit start?");
	}

	@Then("^the early payment date submission will be successful$")
	public void theEarlyPaymentDateSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
		
	}
	
	@When("^I enter valid early payment date details$")
	public void IenterValidEarlyPaymentDateDetails() {
		LocalDate localDate = LocalDate.now();
		SharedData.day = SharedMethods.formatDay(localDate);
		SharedData.month = SharedMethods.formatMonth(localDate);
		SharedData.year = SharedMethods.formatYear(localDate);
		earlyPaymentDatePage = new EarlyPaymentDatePage(driver);
		earlyPaymentDatePage.submitValidPaymentDateDetails(SharedData.day, SharedData.month, SharedData.year);
	}

	@Then("^the early payment date submission will be unsuccessful$")
	public void theEarlyPaymentDateSubmissionWillBeUnsuccessful() {
		earlyPaymentDatePage = new EarlyPaymentDatePage(driver);
		assertThat(earlyPaymentDatePage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly:");
		assertThat(earlyPaymentDatePage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter early payment date details using the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterEarlyPaymentDateDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		earlyPaymentDatePage = new EarlyPaymentDatePage(driver);
		earlyPaymentDatePage.enterPaymentDateDetails(day, month, year);
		earlyPaymentDatePage.submitInValidPaymentDateDetails();

	}

	@And("^the early payment date error message '(.*)' will be displayed$")
	public void theEarlyPaymentDateErrorMessageWillBeDisplayed(String errorMessage) {
		earlyPaymentDatePage = new EarlyPaymentDatePage(driver);
		assertThat(earlyPaymentDatePage.doesPaymentDateErrorMessageHaveAnchor()).isTrue();
		assertThat(earlyPaymentDatePage.getPaymentDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(earlyPaymentDatePage.getPaymentDateFieldErrorMessage()).matches(errorMessage);
	}

	@And("^I verify early payment date error message with date before 6 months from now$")
	public void iVerifyEarlyPaymentDateErrorMessageWithDateBefore6MonthsFromNow() {
		earlyPaymentDatePage = new EarlyPaymentDatePage(driver);
		LocalDate limitDate =  LocalDate.now().plusMonths(6);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String limitDateFormat = limitDate.format(formatters);
		String errorMessage = "Enter a date between 01/04/2000 and " + limitDateFormat;
		assertThat(earlyPaymentDatePage.doesPaymentDateErrorMessageHaveAnchor()).isTrue();
		assertThat(earlyPaymentDatePage.getPaymentDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(earlyPaymentDatePage.getPaymentDateFieldErrorMessage()).matches(errorMessage);
	}
	
	@And("^I enter invalid early payment date details the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterInvalidEarlyPaymentDateDetailsUsingTheDayMonthAndYear(String day, String month, String year) {
		earlyPaymentDatePage = new EarlyPaymentDatePage(driver);
		earlyPaymentDatePage.enterPaymentDateDetails(day, month, year);
		earlyPaymentDatePage.submitInValidPaymentDateDetails();
	}
}

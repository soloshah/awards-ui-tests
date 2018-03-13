package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.EarlyPaymentDate_1995Page;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EarlyPaymentDate_1995StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private EarlyPaymentDate_1995Page earlyPaymentDate_1995Page;

	@Given("^I am on the 1995 early payment date page$")
	public void iAmOnThe1995EarlyPaymentDatePage() {

		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/1995-early-payment-date");
		earlyPaymentDate_1995Page = new EarlyPaymentDate_1995Page(driver);
		assertThat(earlyPaymentDate_1995Page.getHeading()).contains("When should the early payment of deferred benefit start?");
	}

	@When("^I go to the 1995 early payment date page$")
	public void iGoToThe1995EarlyPaymentDatePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/1995-early-payment-date");
		earlyPaymentDate_1995Page = new EarlyPaymentDate_1995Page(driver);
		assertThat(earlyPaymentDate_1995Page.getHeading()).contains("When should the early payment of deferred benefit start?");
	}

	@Then("^the 1995 early payment date submission will be successful$")
	public void the1995EarlyPaymentDateSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
		
	}
	
	@When("^I enter valid 1995 early payment date details$")
	public void IenterValid1995EarlyPaymentDateDetails() {
		LocalDate localDate = LocalDate.now();
		SharedData.day = SharedMethods.formatDay(localDate);
		SharedData.month = SharedMethods.formatMonth(localDate);
		SharedData.year = SharedMethods.formatYear(localDate);
		earlyPaymentDate_1995Page = new EarlyPaymentDate_1995Page(driver);
		earlyPaymentDate_1995Page.submitValidPaymentDateDetails(SharedData.day, SharedData.month, SharedData.year);
	}

	@Then("^the 1995 early payment date submission will be unsuccessful$")
	public void the1995EarlyPaymentDateSubmissionWillBeUnsuccessful() {
		earlyPaymentDate_1995Page = new EarlyPaymentDate_1995Page(driver);
		assertThat(earlyPaymentDate_1995Page.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly:");
		assertThat(earlyPaymentDate_1995Page.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter 1995 early payment date details using the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnter1995EarlyPaymentDateDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		earlyPaymentDate_1995Page = new EarlyPaymentDate_1995Page(driver);
		earlyPaymentDate_1995Page.enterPaymentDateDetails(day, month, year);
		earlyPaymentDate_1995Page.submitInValidPaymentDateDetails();

	}

	@And("^the 1995 early payment date error message '(.*)' will be displayed$")
	public void the1995EarlyPaymentDateErrorMessageWillBeDisplayed(String errorMessage) {
		earlyPaymentDate_1995Page = new EarlyPaymentDate_1995Page(driver);
		assertThat(earlyPaymentDate_1995Page.doesPaymentDateErrorMessageHaveAnchor()).isTrue();
		assertThat(earlyPaymentDate_1995Page.getPaymentDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(earlyPaymentDate_1995Page.getPaymentDateFieldErrorMessage()).matches(errorMessage);
	}

	@And("^I verify 1995 early payment date error message with date before 6 months from now$")
	public void iVerify1995EarlyPaymentDateErrorMessageWithDateBefore6MonthsFromNow() {
		earlyPaymentDate_1995Page = new EarlyPaymentDate_1995Page(driver);
		LocalDate limitDate =  LocalDate.now().plusMonths(6);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String limitDateFormat = limitDate.format(formatters);
		String errorMessage = "Enter a date between 01/04/2000 and " + limitDateFormat;
		assertThat(earlyPaymentDate_1995Page.doesPaymentDateErrorMessageHaveAnchor()).isTrue();
		assertThat(earlyPaymentDate_1995Page.getPaymentDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(earlyPaymentDate_1995Page.getPaymentDateFieldErrorMessage()).matches(errorMessage);
	}
	
	@And("^I enter invalid 1995 early payment date details the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterInvalid1995EarlyPaymentDateDetailsUsingTheDayMonthAndYear(String day, String month, String year) {
		earlyPaymentDate_1995Page = new EarlyPaymentDate_1995Page(driver);
		earlyPaymentDate_1995Page.enterPaymentDateDetails(day, month, year);
		earlyPaymentDate_1995Page.submitInValidPaymentDateDetails();
	}
}

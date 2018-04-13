package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.SharedEarlyPaymentPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SharedEarlyPaymentStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private SharedEarlyPaymentPage sharedEarlyPaymentPage;

	@Then("^the early payment date submission will be successful$")
	public void the2008EarlyPaymentDateSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@When("^I enter valid early payment date details$")
	public void IenterValidEarlyPaymentDateDetails() {
		LocalDate localDate = LocalDate.now();
		SharedData.day = SharedMethods.formatDay(localDate);
		SharedData.month = SharedMethods.formatMonth(localDate);
		SharedData.year = SharedMethods.formatYear(localDate);
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		sharedEarlyPaymentPage.submitValidPaymentDateDetails(SharedData.day, SharedData.month, SharedData.year);
	}

	@Then("^the early payment date submission will be unsuccessful$")
	public void theEarlyPaymentDateSubmissionWillBeUnsuccessful() {
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		assertThat(sharedEarlyPaymentPage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(sharedEarlyPaymentPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I enter early payment date details using the day '(.*)', month '(.*)' and year '(.*)'$")
	public void iEnterEarlyPaymentDateDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		sharedEarlyPaymentPage.enterPaymentDateDetails(day, month, year);
		sharedEarlyPaymentPage.submitInValidPaymentDateDetails();

	}

	@And("^the error message '(.*)' for early payment dates will be displayed$")
	public void theErrorMessageForEarlyPaymentDateWillBeDisplayed(String errorMessage) {
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		assertThat(sharedEarlyPaymentPage.doesPaymentDateErrorMessageHaveAnchor()).isTrue();
		assertThat(sharedEarlyPaymentPage.getPaymentDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(sharedEarlyPaymentPage.getPaymentDateFieldErrorMessage()).matches(errorMessage);
	}

	@And("^I enter invalid early payment date details the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterInvalidEarlyPaymentDateDetailsUsingTheDayMonthAndYear(String day, String month, String year) {
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		sharedEarlyPaymentPage.enterPaymentDateDetails(day, month, year);
		sharedEarlyPaymentPage.submitInValidPaymentDateDetails();
	}
	
	@Given("^I am on the 2015 early payment date page$")
	public void iAmOnThe2015EarlyPaymentDatePage() {

		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/2015-early-payment-date");
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		assertThat(sharedEarlyPaymentPage.getHeading())
				.contains("When should the early payment of deferred benefit start?");
	}

	@When("^I go to the 2015 early payment date page$")
	public void iGoToThe2015EarlyPaymentDatePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2015-early-payment-date");
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		assertThat(sharedEarlyPaymentPage.getHeading())
				.contains("When should the early payment of deferred benefit start?");
	}

	@And("^I verify 2015 early payment date error message with date before 6 months from now$")
	public void iVerify2015EarlyPaymentDateErrorMessageWithDateBefore6MonthsFromNow() {
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		LocalDate limitDate = LocalDate.now().plusMonths(6);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String limitDateFormat = limitDate.format(formatters);
		String errorMessage = "Enter a date between 01/04/2015 and " + limitDateFormat;
		assertThat(sharedEarlyPaymentPage.doesPaymentDateErrorMessageHaveAnchor()).isTrue();
		assertThat(sharedEarlyPaymentPage.getPaymentDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(sharedEarlyPaymentPage.getPaymentDateFieldErrorMessage()).matches(errorMessage);
	}
	
	@Given("^I am on the 2008 early payment date page$")
	public void iAmOnThe2008EarlyPaymentDatePage() {

		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/2008-early-payment-date");
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		assertThat(sharedEarlyPaymentPage.getHeading()).contains("When should the early payment of deferred benefit start?");
	}

	@When("^I go to the 2008 early payment date page$")
	public void iGoToThe2008EarlyPaymentDatePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2008-early-payment-date");
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		assertThat(sharedEarlyPaymentPage.getHeading()).contains("When should the early payment of deferred benefit start?");
	}
	
	
	@And("^I verify 2008 early payment date error message with date before 6 months from now$")
	public void iVerify2008EarlyPaymentDateErrorMessageWithDateBefore6MonthsFromNow() {
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		LocalDate limitDate =  LocalDate.now().plusMonths(6);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String limitDateFormat = limitDate.format(formatters);
	    System.out.println("Date" + limitDateFormat);
		String errorMessage = "Enter a date between 01/04/2008 and " + limitDateFormat;
		assertThat(sharedEarlyPaymentPage.doesPaymentDateErrorMessageHaveAnchor()).isTrue();
		assertThat(sharedEarlyPaymentPage.getPaymentDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(sharedEarlyPaymentPage.getPaymentDateFieldErrorMessage()).matches(errorMessage);
	}
	
	@Given("^I am on the 1995 early payment date page$")
	public void iAmOnThe1995EarlyPaymentDatePage() {

		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/1995-early-payment-date");
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		assertThat(sharedEarlyPaymentPage.getHeading()).contains("When should the early payment of deferred benefit start?");
	}

	@When("^I go to the 1995 early payment date page$")
	public void iGoToThe1995EarlyPaymentDatePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/1995-early-payment-date");
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		assertThat(sharedEarlyPaymentPage.getHeading()).contains("When should the early payment of deferred benefit start?");
	}

	
	@And("^I verify 1995 early payment date error message with date before 6 months from now$")
	public void iVerify1995EarlyPaymentDateErrorMessageWithDateBefore6MonthsFromNow() {
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		LocalDate limitDate =  LocalDate.now().plusMonths(6);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String limitDateFormat = limitDate.format(formatters);
		String errorMessage = "Enter a date between 01/04/2000 and " + limitDateFormat;
		assertThat(sharedEarlyPaymentPage.doesPaymentDateErrorMessageHaveAnchor()).isTrue();
		assertThat(sharedEarlyPaymentPage.getPaymentDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(sharedEarlyPaymentPage.getPaymentDateFieldErrorMessage()).matches(errorMessage);
	}
	
	@Then("^the early payment date page will be displayed$")
	public void theEarlyPaymentDatePageWillBeDisplayed() {
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		assertThat(sharedEarlyPaymentPage.getHeading()).contains("When should the early payment of deferred benefit start?");
	}
	
	@When("^I click next on early payment date page$")
	public void iClickNextOnEarlyPaymentDatePage() {
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		sharedEarlyPaymentPage.nextStep();
	}

	

	@Then("^the earlyPaymentDate details are sustained$")
	public void theEarlyPaymentDateDetailsAreSustained() {
		sharedEarlyPaymentPage = new SharedEarlyPaymentPage(driver);
		//assertThat(sharedEarlyPaymentPage.getDay()).matches(SharedData.day);
		//assertThat(sharedEarlyPaymentPage.getMonth()).matches(SharedData.month);
		assertThat(sharedEarlyPaymentPage.getYear()).matches(SharedData.year);

	}

	@When("^I enter earlyPaymentDate using different valid date$")
	public void iEnterEarlyPaymewntDateUsingDifferentDate() {
		IenterValidEarlyPaymentDateDetails();
	}
	
}

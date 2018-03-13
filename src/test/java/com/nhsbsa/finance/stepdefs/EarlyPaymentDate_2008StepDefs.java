package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.EarlyPaymentDate_2008Page;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EarlyPaymentDate_2008StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private EarlyPaymentDate_2008Page earlyPaymentDate_2008Page;

	@Given("^I am on the 2008 early payment date page$")
	public void iAmOnThe2008EarlyPaymentDatePage() {

		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/2008-early-payment-date");
		earlyPaymentDate_2008Page = new EarlyPaymentDate_2008Page(driver);
		assertThat(earlyPaymentDate_2008Page.getHeading()).contains("When should the early payment of deferred benefit start?");
	}

	@When("^I go to the 2008 early payment date page$")
	public void iGoToThe2008EarlyPaymentDatePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2008-early-payment-date");
		earlyPaymentDate_2008Page = new EarlyPaymentDate_2008Page(driver);
		assertThat(earlyPaymentDate_2008Page.getHeading()).contains("When should the early payment of deferred benefit start?");
	}

	@Then("^the 2008 early payment date submission will be successful$")
	public void the2008EarlyPaymentDateSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
		
	}
	
	@When("^I enter valid 2008 early payment date details$")
	public void IenterValid2008EarlyPaymentDateDetails() {
		LocalDate localDate = LocalDate.now();
		SharedData.day = SharedMethods.formatDay(localDate);
		SharedData.month = SharedMethods.formatMonth(localDate);
		SharedData.year = SharedMethods.formatYear(localDate);
		earlyPaymentDate_2008Page = new EarlyPaymentDate_2008Page(driver);
		earlyPaymentDate_2008Page.submitValidPaymentDate2008Details(SharedData.day, SharedData.month, SharedData.year);
	}

	@Then("^the 2008 early payment date submission will be unsuccessful$")
	public void the2008EarlyPaymentDateSubmissionWillBeUnsuccessful() {
		earlyPaymentDate_2008Page = new EarlyPaymentDate_2008Page(driver);
		assertThat(earlyPaymentDate_2008Page.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly:");
		assertThat(earlyPaymentDate_2008Page.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter 2008 early payment date details using the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnter2008EarlyPaymentDateDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		earlyPaymentDate_2008Page = new EarlyPaymentDate_2008Page(driver);
		earlyPaymentDate_2008Page.enterPaymentDate2008Details(day, month, year);
		earlyPaymentDate_2008Page.submitInValidPaymentDate2008Details();

	}

	@And("^the 2008 early payment date error message '(.*)' will be displayed$")
	public void the2008EarlyPaymentDateErrorMessageWillBeDisplayed(String errorMessage) {
		earlyPaymentDate_2008Page = new EarlyPaymentDate_2008Page(driver);
		assertThat(earlyPaymentDate_2008Page.doesPaymentDate2008ErrorMessageHaveAnchor()).isTrue();
		assertThat(earlyPaymentDate_2008Page.getPaymentDate2008AnchoredErrorMessage()).matches(errorMessage);
		assertThat(earlyPaymentDate_2008Page.getPaymentDate2008FieldErrorMessage()).matches(errorMessage);
	}

	@And("^I verify 2008 early payment date error message with date before 6 months from now$")
	public void iVerify2008EarlyPaymentDateErrorMessageWithDateBefore6MonthsFromNow() {
		earlyPaymentDate_2008Page = new EarlyPaymentDate_2008Page(driver);
		LocalDate limitDate =  LocalDate.now().plusMonths(6);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String limitDateFormat = limitDate.format(formatters);
	    System.out.println("Date" + limitDateFormat);
		String errorMessage = "Enter a date between 01/04/2008 and " + limitDateFormat;
		assertThat(earlyPaymentDate_2008Page.doesPaymentDate2008ErrorMessageHaveAnchor()).isTrue();
		assertThat(earlyPaymentDate_2008Page.getPaymentDate2008AnchoredErrorMessage()).matches(errorMessage);
		assertThat(earlyPaymentDate_2008Page.getPaymentDate2008FieldErrorMessage()).matches(errorMessage);
	}
	
	@And("^I enter invalid 2008 early payment date details the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterInvalid2008EarlyPaymentDateDetailsUsingTheDayMonthAndYear(String day, String month, String year) {
		earlyPaymentDate_2008Page = new EarlyPaymentDate_2008Page(driver);
		earlyPaymentDate_2008Page.enterPaymentDate2008Details(day, month, year);
		earlyPaymentDate_2008Page.submitInValidPaymentDate2008Details();
	}
}

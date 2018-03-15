package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.MaritalStatusPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MaritalStatusStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private MaritalStatusPage maritalStatusPage;

	@Given("^I am on marital status page$")
	public void iAmOnMaritalStatusPage() {
		new Page(driver).navigateToUrl(baseUrl + "/partner-and-child/what-is-your-marital-status");
	}

	@Given("^I go to the marital status page$")
	public void iGoToTheMaritalStatusPage() {
		new Page(driver).navigateToUrl(baseUrl + "/partner-and-child/what-is-your-marital-status");
		maritalStatusPage = new MaritalStatusPage(driver);
		assertThat(maritalStatusPage.getHeading()).contains("What is your marital status?");
	}
	
	@Then("^What is your marital status page will be displayed$")
	public void whatIsYourMaritalStatusPageWillBeDisplayed() {
		maritalStatusPage = new MaritalStatusPage(driver);
		assertThat(maritalStatusPage.getHeading()).contains("What is your marital status?");
	}

	@Then("^the default value for marital status will be blank$")
	public void theDefaultValueForMaritalStatusWillBeBlank() {
		assertThat(maritalStatusPage.maritalStatusRadioButtonSelected()).isFalse();
	}

	@When("^I dont select anything on marital status page$")
	public void iDontSelectAnythingOnMaritalStatusPage() {
		maritalStatusPage = new MaritalStatusPage(driver);
		maritalStatusPage.maritalStatusIsNotSelected();
	}

	@Then("^the marital status submission will be unsuccessful$")
	public void theMaritalStatusSubmissionWillBeUnsuccessful() {
		maritalStatusPage = new MaritalStatusPage(driver);
		assertThat(maritalStatusPage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(maritalStatusPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@Then("^the marital status submission will be successful$")
	public void theMaritalStatusSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@And("^marital status page error message '(.*)' will be displayed$")
	public void maritalStatusPageErrorMessageWillBeDisplayed(String errorMessage) {
		maritalStatusPage = new MaritalStatusPage(driver);
		assertThat(maritalStatusPage.getMaritalStatusFieldErrorMessage()).matches(errorMessage);
		assertThat(maritalStatusPage.doesMaritalStatusErrorMessageHaveAnchor()).isTrue();
		assertThat(maritalStatusPage.getMaritalStatusAnchoredErrorMessage()).matches(errorMessage);
	}

	@When("^I select (.*) on marital status page$")
	public void iSelectStatusOnMaritalStatusPage(String field) {
		maritalStatusPage = new MaritalStatusPage(driver);
		switch (field) {
		case "single":
			maritalStatusPage.selectSingleMaritalStatus();
			break;
		case "married":
			maritalStatusPage.selectMarriedMaritalStatus();
			break;
		case "civilPartnership":
			maritalStatusPage.selectCivilMaritalStatus();
			break;
		case "widowed":
			maritalStatusPage.selectWidowedMaritalStatus();
			break;
		case "divorced":
			maritalStatusPage.selectDivorcedMaritalStatus();
			break;
		}

	}

	@When("^the (.*) date fields will be displayed$")
	public void theDateFieldsWillBeDisplayed(String field) {
		maritalStatusPage = new MaritalStatusPage(driver);
		switch (field) {
		case "married":
			assertThat(maritalStatusPage.getMarriedDateHeading().contains("When did you get married?"));
			assertThat(maritalStatusPage.getMarriedHint().matches("For example, 31 3 1980"));
			break;
		case "civilPartnership":
			assertThat(maritalStatusPage.getCivilDateHeading().contains("When did you enter your civil partnership?"));
			assertThat(maritalStatusPage.getCivilPartnershipHint().matches("For example, 31 3 1980"));
			break;
		case "widowed":
			assertThat(maritalStatusPage.getWidowedDateHeading().contains("When did your partner die?"));
			assertThat(maritalStatusPage.getWidowedHint().matches("For example, 31 3 1980"));
			break;
		case "divorced":
			assertThat(maritalStatusPage.getDivorcedDateHeading()
					.contains("What is the date of your divorce or dissolution?"));
			assertThat(maritalStatusPage.getDivorcedHint().matches("For example, 31 3 1980"));
			break;
		}
	}

	@When("^I enter valid (.*) date$")
	public void iEnterValidDates(String field) {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.day = SharedMethods.formatDay(localDate);
		SharedData.month = SharedMethods.formatMonth(localDate);
		SharedData.year = SharedMethods.formatYear(localDate);
		maritalStatusPage = new MaritalStatusPage(driver);
		switch (field) {
		case "married":
			maritalStatusPage.submitValidMarriedDate(SharedData.day, SharedData.month, SharedData.year);
			break;
		case "civilPartnership":
			maritalStatusPage.submitValidCivilDate(SharedData.day, SharedData.month, SharedData.year);
			break;
		case "widowed":
			maritalStatusPage.submitValidWidowedDate(SharedData.day, SharedData.month, SharedData.year);
			break;
		case "divorced":
			maritalStatusPage.submitValidDivorcedDate(SharedData.day, SharedData.month, SharedData.year);
			break;
		}
	}

	@When("^I enter invalid (.*) date details using the day '(.*)', month '(.*)' and year '(.*)'$")
	public void iEnterInvalidMaritalStatusDateDetailsUsingTheDayMonthAndYear(String field, String day, String month,
			String year) {
		maritalStatusPage = new MaritalStatusPage(driver);
		switch (field) {
		case "married":
			maritalStatusPage.enterMarriedDateDetails(day, month, year);
			break;
		case "civilPartnership":
			maritalStatusPage.enterCivilDateDetails(day, month, year);
			break;
		case "widowed":
			maritalStatusPage.enterWidowedDateDetails(day, month, year);
			break;
		case "divorced":
			maritalStatusPage.enterDivorcedDateDetails(day, month, year);
			break;
		}
		maritalStatusPage.submitInValidDates();
	}

	@And("^the (.*) date error message '(.*)' will be displayed$")
	public void theDateYouReturnToWorkErrorMessageWillBeDisplayed(String field, String errorMessage) {
		maritalStatusPage = new MaritalStatusPage(driver);
		switch (field) {
		case "married":
			assertThat(maritalStatusPage.doesMarriedErrorMessageHaveAnchor()).isTrue();
			assertThat(maritalStatusPage.getMarriedAnchoredErrorMessage()).matches(errorMessage);
			assertThat(maritalStatusPage.getMarriedFieldErrorMessage()).matches(errorMessage);
			break;
		case "civilPartnership":
			assertThat(maritalStatusPage.doesCivilErrorMessageHaveAnchor()).isTrue();
			assertThat(maritalStatusPage.getCivilAnchoredErrorMessage()).matches(errorMessage);
			assertThat(maritalStatusPage.getCivilFieldErrorMessage()).matches(errorMessage);
			break;
		case "widowed":
			assertThat(maritalStatusPage.doesWidowedErrorMessageHaveAnchor()).isTrue();
			assertThat(maritalStatusPage.getWidowedAnchoredErrorMessage()).matches(errorMessage);
			assertThat(maritalStatusPage.getWidowedFieldErrorMessage()).matches(errorMessage);
			break;
		case "divorced":
			assertThat(maritalStatusPage.doesDivorcedErrorMessageHaveAnchor()).isTrue();
			assertThat(maritalStatusPage.getDivorcedAnchoredErrorMessage()).matches(errorMessage);
			assertThat(maritalStatusPage.getDivorcedFieldErrorMessage()).matches(errorMessage);
			break;
		}
	}

}
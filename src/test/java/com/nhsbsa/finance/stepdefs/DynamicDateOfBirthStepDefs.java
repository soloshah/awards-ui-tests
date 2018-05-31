package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ChildDOBPage;
import com.nhsbsa.finance.pageobjects.DynamicDateOfBirthPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DynamicDateOfBirthStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private DynamicDateOfBirthPage dynamicDateOfBirthPage;
	ChildDOBPage childDOBPage;
	
	
	@Then("^the partners date of birth page will be displayed$")
	public void thePartnersDateOfBirthPageWillBeDisplayed() {
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.getExampleHint().matches("For example, 31 03 1980"));
		assertThat(dynamicDateOfBirthPage.getHeading())
				.containsIgnoringCase("What is " + SharedData.firstName + "'s " + "date of birth?");
	}

	@Then("^the dynamic value of partner first name is displayed on the partners DOB page$")
	public void theDynamicValueOfPartnerFirstNameIsDisplayedOnThePartnersDOBPage() {
		
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.getHeading()).contains("What is " + SharedData.firstName + "'s " + "date of birth?");

	}
	
	
	@When("^I go to partner DOB page$")
	public void iGoToPartnerDOBPage() {
   		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-your-partner-dob");
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.getHeading()).contains("What is " + SharedData.firstName + "'s " + "date of birth?");
		assertThat(dynamicDateOfBirthPage.getExampleHint().matches("For example, 31 03 1980"));
	}

	@Then("^the partner date of birth submission will be successful$")
	public void thePartnerDateOfBirthSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the partner date of birth submission will be unsuccessful$")
	public void thePartnerDateOfBirthSubmissionWillBeUnsuccessful() {
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(dynamicDateOfBirthPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I enter partner DOB details using the day '(.*)', month '(.*)' and year '(.*)'$")
	public void iEnterPartnerDOBDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		dynamicDateOfBirthPage.enterPartnerDobDetails(day, month, year);
		dynamicDateOfBirthPage.submitInValidPartnerDOBDetails();

	}

	@And("^the partner date of birth error message '(.*)' will be displayed$")
	public void thePartnerDateOfBirthErrorMessageWillBeDisplayed(String errorMessage) {
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.doesPartnerDobErrorMessageHaveAnchor()).isTrue();
		assertThat(dynamicDateOfBirthPage.getPartnerDobAnchoredErrorMessage()).matches(errorMessage);
		assertThat(dynamicDateOfBirthPage.getPartnerDobFieldErrorMessage()).matches(errorMessage);
	}

	@Then("^the partner date of birth for 16 years error message '(.*)' will be displayed$")
	public void thePartnerDateOfBirthFor16YearsErrorMessageWillBeDisplayed(String errorMessage) {
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.getPartnerDobFieldErrorMessage()).matches(errorMessage);
		assertThat(dynamicDateOfBirthPage.doesPartnerDobErrorMessageHaveAnchor()).isTrue();
		assertThat(dynamicDateOfBirthPage.getPartnerDobAnchoredErrorMessage()).matches(errorMessage);
	}

	@And("^I enter partner's dob  less than 16 years from today's date$")
	public void iEnterPartnersDOBLessThan16YearsFromTodaysDate() {
		LocalDate minusYear = LocalDate.now().plusDays(1).minusYears(16);
		SharedData.day = SharedMethods.formatDay(minusYear);
		SharedData.month = SharedMethods.formatMonth(minusYear);
		SharedData.year = SharedMethods.formatYear(minusYear);
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		dynamicDateOfBirthPage.enterPartnerDobDetails(SharedData.day, SharedData.month, SharedData.year);
		dynamicDateOfBirthPage.submitInValidPartnerDOBDetails();
	}
	
	
	
	@When("^I enter valid partner DOB$")
	public void IenterValidPartnerDOB() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.day = SharedMethods.formatDay(localDate);
		SharedData.month = SharedMethods.formatMonth(localDate);
		SharedData.year = SharedMethods.formatYear(localDate);
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		dynamicDateOfBirthPage.submitValidPartnerDOBDetails(SharedData.day, SharedData.month, SharedData.year);
	}
	
	

	@Then("^the parnerDob details are sustained$")
	public void thePartnerDobDetailsAreSustained() {
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		//assertThat(dynamicDateOfBirthPage.getDay()).matches(SharedData.day);
		//assertThat(dynamicDateOfBirthPage.getMonth()).matches(SharedData.month);
		assertThat(dynamicDateOfBirthPage.getYear()).matches(SharedData.year);

	}

	@When("^I enter partner dob using different valid details$")
	public void iEnterPartnerDOBUsingDifferentDetails() {
		IenterValidPartnerDOB();
	}

	@When("^I click next on partner date of birth page$")
	public void iClickNextOnPartnerDateOfBirthPage() {
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		dynamicDateOfBirthPage.nextStep();
	}	
	
}

package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.PartnerDateOfBirthPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PartnerDateOfBirthStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private PartnerDateOfBirthPage partnerDateOfBirthPage;
	
	 
	@Given("^I am on partner DOB page$")
	public void iAmOnPartnerDOBPage() {
		new Page(driver).navigateToUrl(baseUrl + "/partner-and-child/what-is-your-partner-dob");
		partnerDateOfBirthPage = new PartnerDateOfBirthPage(driver);
		assertThat(partnerDateOfBirthPage.getHeading()).contains("What is " + SharedData.firstName + "'s " + " date of birth?");
	}

	@When("^I go to partner DOB page$")
	public void iGoToPartnerDOBPage() {
   		new Page(driver).navigateToUrl(baseUrl + "/partner-and-child/what-is-your-partner-dob");
		partnerDateOfBirthPage = new PartnerDateOfBirthPage(driver);
		assertThat(partnerDateOfBirthPage.getExampleHint().matches("For example, 31 03 1980"));
	}

	@Then("^the partner date of birth submission will be successful$")
	public void thePartnerDateOfBirthSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the partners date of birth page will be displayed$")
	public void thePartnersDateOfBirthPageWillBeDisplayed() {
		partnerDateOfBirthPage = new PartnerDateOfBirthPage(driver);
		assertThat(partnerDateOfBirthPage.getExampleHint().matches("For example, 31 03 1980"));
		assertThat(partnerDateOfBirthPage.getHeading()).contains("What is " + SharedData.firstName + "'s " +  "date of birth?");
	}

	@When("^I enter valid partner DOB details$")
	public void IenterValidPartnerDOBDetails() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.day = SharedMethods.formatDay(localDate);
		SharedData.month = SharedMethods.formatMonth(localDate);
		SharedData.year = SharedMethods.formatYear(localDate);
		partnerDateOfBirthPage = new PartnerDateOfBirthPage(driver);
		partnerDateOfBirthPage.submitValidPartnerDOB(SharedData.day, SharedData.month, SharedData.year);
	}

	@Then("^the partner date of birth submission will be unsuccessful$")
	public void theAllocationDateOfBirthSubmissionWillBeUnsuccessful() {
		partnerDateOfBirthPage = new PartnerDateOfBirthPage(driver);
		assertThat(partnerDateOfBirthPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly:");
		assertThat(partnerDateOfBirthPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter partner DOB details using the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterDOBDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		partnerDateOfBirthPage = new PartnerDateOfBirthPage(driver);
		partnerDateOfBirthPage.enterPartnerDobDetails(day, month, year);
		partnerDateOfBirthPage.submitInValidPartnerDOBDetails();

	}

	@And("^the partner date of birth error message '(.*)' will be displayed$")
	public void theAllocationDateOfBirthErrorMessageWillBeDisplayed(String errorMessage) {
		partnerDateOfBirthPage = new PartnerDateOfBirthPage(driver);
		assertThat(partnerDateOfBirthPage.doesPartnerDobErrorMessageHaveAnchor()).isTrue();
		assertThat(partnerDateOfBirthPage.getPartnerDobAnchoredErrorMessage()).matches(errorMessage);
		assertThat(partnerDateOfBirthPage.getPartnerDobFieldErrorMessage()).matches(errorMessage);
	}

	@Then("^the partner date of birth for 16 years error message '(.*)' will be displayed$")
	public void thePartnerDateOfBirthFor16YearsErrorMessageWillBeDisplayed(String errorMessage) {
		partnerDateOfBirthPage = new PartnerDateOfBirthPage(driver);
		assertThat(partnerDateOfBirthPage.getPartnerDobFieldErrorMessage()).matches(errorMessage);
		assertThat(partnerDateOfBirthPage.doesPartnerDobErrorMessageHaveAnchor()).isTrue();
		assertThat(partnerDateOfBirthPage.getPartnerDobAnchoredErrorMessage()).matches(errorMessage);
	}

	@And("^I enter partner's dob  less than 16 years from today's date$")
	public void iEnterPartnersDOBLessThan16YearsFromTodaysDate() {
		LocalDate minusYear = LocalDate.now().plusDays(1).minusYears(16);
		SharedData.day = SharedMethods.formatDay(minusYear);
		SharedData.month = SharedMethods.formatMonth(minusYear);
		SharedData.year = SharedMethods.formatYear(minusYear);
		partnerDateOfBirthPage = new PartnerDateOfBirthPage(driver);
		partnerDateOfBirthPage.enterPartnerDobDetails(SharedData.day, SharedData.month, SharedData.year);
		partnerDateOfBirthPage.submitInValidPartnerDOBDetails();
	}
	
	}

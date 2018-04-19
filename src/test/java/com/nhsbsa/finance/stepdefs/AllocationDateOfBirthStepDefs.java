package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.AllocationDateOfBirthPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllocationDateOfBirthStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private AllocationDateOfBirthPage allocationDateOfBirthPage;

	@Given("^I am on allocation DOB page$")
	public void iAmOnAllocationDOBPage() {

		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-allocation-dob");
		allocationDateOfBirthPage = new AllocationDateOfBirthPage(driver);
		assertThat(allocationDateOfBirthPage.getHeading()).contains("What is their date of birth?");
	}

	@When("^I go to allocation DOB page$")
	public void iGoToAllocationDOBPage() {

		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-allocation-dob");
		allocationDateOfBirthPage = new AllocationDateOfBirthPage(driver);
		assertThat(allocationDateOfBirthPage.getHeading().contains("What is their date of birth?"));
		assertThat(allocationDateOfBirthPage.getExampleFormHint().matches("For example, 31 03 1980"));
	}

	@Then("^the allocation date of birth submission will be successful$")
	public void theAllocationDateOfBirthSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the allocation date of birth page will be displayed$")
	public void theAllocationDateOfBirthPageWillBeDisplayed() {
		allocationDateOfBirthPage = new AllocationDateOfBirthPage(driver);
		assertThat(allocationDateOfBirthPage.getHeading()).contains("What is their date of birth?");
	}

	@When("^I enter valid allocation DOB details$")
	public void IenterAllocationValidDOBDetails() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.allocateDay = SharedMethods.formatDay(localDate);
		SharedData.allocateMonth = SharedMethods.formatMonth(localDate);
		SharedData.allocateYear = SharedMethods.formatYear(localDate);
		allocationDateOfBirthPage = new AllocationDateOfBirthPage(driver);
		allocationDateOfBirthPage.submitValidAllocationDateDetails(SharedData.allocateDay, SharedData.allocateMonth,
				SharedData.allocateYear);
	}

	@Then("^the allocation date of birth submission will be unsuccessful$")
	public void theAllocationDateOfBirthSubmissionWillBeUnsuccessful() {
		allocationDateOfBirthPage = new AllocationDateOfBirthPage(driver);
		assertThat(allocationDateOfBirthPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly:");
		assertThat(allocationDateOfBirthPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter allocation DOB details using the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterDOBDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		allocationDateOfBirthPage = new AllocationDateOfBirthPage(driver);
		allocationDateOfBirthPage.enterAllocationDobDetails(day, month, year);
		allocationDateOfBirthPage.submitInValidAllocationDOBDetails();

	}

	@And("^the allocation date of birth error message '(.*)' will be displayed$")
	public void theAllocationDateOfBirthErrorMessageWillBeDisplayed(String errorMessage) {
		allocationDateOfBirthPage = new AllocationDateOfBirthPage(driver);
		assertThat(allocationDateOfBirthPage.doesAllocationDobErrorMessageHaveAnchor()).isTrue();
		assertThat(allocationDateOfBirthPage.getAllocationDobAnchoredErrorMessage()).matches(errorMessage);
		assertThat(allocationDateOfBirthPage.getAllocationDobFieldErrorMessage()).matches(errorMessage);
	}

	@Then("^the allocation date of birth for greater than today's date error message '(.*)' will be displayed$")
	public void theAllocationDateOfBirthForGreaterThanTodaysDateErrorMessageWillBeDisplayed(String errorMessage) {
		allocationDateOfBirthPage = new AllocationDateOfBirthPage(driver);
		assertThat(allocationDateOfBirthPage.getAllocationDobFieldErrorMessage()).matches(errorMessage);
		assertThat(allocationDateOfBirthPage.doesAllocationDobErrorMessageHaveAnchor()).isTrue();
		assertThat(allocationDateOfBirthPage.getAllocationDobAnchoredErrorMessage()).matches(errorMessage);
	}

	@And("^I enter allocation DOB greater than today's date$")
	public void iEnterAllocationDOBGreaterThanTodaysDate() {
		LocalDate pastdate = LocalDate.now().plusDays(1);
		SharedData.day = SharedMethods.formatDay(pastdate);
		SharedData.month = SharedMethods.formatMonth(pastdate);
		SharedData.year = SharedMethods.formatYear(pastdate);
		allocationDateOfBirthPage = new AllocationDateOfBirthPage(driver);
		allocationDateOfBirthPage.enterAllocationDobDetails(SharedData.day, SharedData.month, SharedData.year);
		allocationDateOfBirthPage.submitInValidAllocationDOBDetails();
	}

}

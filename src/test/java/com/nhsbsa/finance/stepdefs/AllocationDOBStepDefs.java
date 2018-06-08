package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.AllocationDOBPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllocationDOBStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private AllocationDOBPage allocationDOBPage;

	
	@When("^I go to allocation DOB page$")
	public void iGoToAllocationDOBPage() {

		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-allocation-dob");
		allocationDOBPage = new AllocationDOBPage(driver);
		assertThat(allocationDOBPage.getHeading().contains("What is their date of birth?"));
		assertThat(allocationDOBPage.getExampleFormHint().matches("For example, 31 03 1980"));
	}

	@Then("^the allocation date of birth submission will be successful$")
	public void theAllocationDateOfBirthSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the allocation date of birth submission will be unsuccessful$")
	public void theAllocationDateOfBirthSubmissionWillBeUnsuccessful() {
		allocationDOBPage = new AllocationDOBPage(driver);
		assertThat(allocationDOBPage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(allocationDOBPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I enter allocation DOB details using the day '(.*)', month '(.*)' and year '(.*)'$")
	public void iEnterDOBDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		allocationDOBPage = new AllocationDOBPage(driver);
		allocationDOBPage.enterAllocationDobDetails(day, month, year);
		allocationDOBPage.submitInValidAllocationDOBDetails();

	}

	@And("^the allocation date of birth error message '(.*)' will be displayed$")
	public void theAllocationDateOfBirthErrorMessageWillBeDisplayed(String errorMessage) {
		allocationDOBPage = new AllocationDOBPage(driver);
		assertThat(allocationDOBPage.doesAllocationDobErrorMessageHaveAnchor()).isTrue();
		assertThat(allocationDOBPage.getAllocationDobAnchoredErrorMessage()).matches(errorMessage);
		assertThat(allocationDOBPage.getAllocationDobFieldErrorMessage()).matches(errorMessage);
	}


	@And("^I enter allocation DOB greater than today's date$")
	public void iEnterAllocationDOBGreaterThanTodaysDate() {
		LocalDate pastdate = LocalDate.now().plusDays(1);
		SharedData.day = SharedMethods.formatDay(pastdate);
		SharedData.month = SharedMethods.formatMonth(pastdate);
		SharedData.year = SharedMethods.formatYear(pastdate);
		allocationDOBPage = new AllocationDOBPage(driver);
		allocationDOBPage.enterAllocationDobDetails(SharedData.day, SharedData.month, SharedData.year);
		allocationDOBPage.submitInValidAllocationDOBDetails();
	}
	
	@Then("^the allocation date of birth page will be displayed$")
	public void theAllocationDateOfBirthPageWillBeDisplayed() {
		
		allocationDOBPage = new AllocationDOBPage(driver);
		assertThat(allocationDOBPage.getExampleHint().matches("For example, 31 03 1980"));
		assertThat(allocationDOBPage.getHeading()).contains("What is " + SharedData.allocationFirstName + "'s " + "date of birth?");
	}

	
	@When("^I enter valid allocation DOB$")
	public void IenterValidAllocationDOB() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.allocateDay = SharedMethods.formatDay(localDate);
		SharedData.allocateMonth = SharedMethods.formatMonth(localDate);
		SharedData.allocateYear = SharedMethods.formatYear(localDate);
		allocationDOBPage = new AllocationDOBPage(driver);
		allocationDOBPage.submitValidAllocationDateDetails(SharedData.allocateDay, SharedData.allocateMonth,
				SharedData.allocateYear);
	}
	
	

	@Then("^the allocationDOB details are sustained$")
	public void theAllocationDOBDetailsAreSustained() {
		allocationDOBPage = new AllocationDOBPage(driver);
	//	assertThat(dynamicAllocationPage.getAllocationDay()).matches(SharedData.allocateDay);
	//	assertThat(dynamicAllocationPage.getAllocationMonth()).matches(SharedData.allocateMonth);
		assertThat(allocationDOBPage.getAllocationYear()).matches(SharedData.allocateYear);

	}

	@When("^I enter allocationDOB using different valid details$")
	public void iEnterAllocationDOBUsingDifferentDetails() {
		IenterValidAllocationDOB();
	}

	@When("^I click next on allocation date of birth page$")
	public void iClickNextOnAllocationDateOfBirthPage() {
		allocationDOBPage = new AllocationDOBPage(driver);
		allocationDOBPage.nextStep();
	}	
		
}

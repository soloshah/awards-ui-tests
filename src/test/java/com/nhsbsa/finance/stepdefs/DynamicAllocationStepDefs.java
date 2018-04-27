package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DynamicAllocationPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DynamicAllocationStepDefs {

	private WebDriver driver = Config.getDriver();
	private DynamicAllocationPage dynamicAllocationPage;

	
	@Then("^the dynamic allocation date of birth page will be displayed$")
	public void theDynamicAllocationDateOfBirthPageWillBeDisplayed() {
		
		Page page = new Page(driver);
		String allocationDobPageTitle = "What is " + SharedData.allocationFirstName + "'s " + "date of birth? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(allocationDobPageTitle);
		dynamicAllocationPage = new DynamicAllocationPage(driver);
		assertThat(dynamicAllocationPage.getExampleHint().matches("For example, 31 03 1980"));
		assertThat(dynamicAllocationPage.getHeading()).contains("What is " + SharedData.allocationFirstName + "'s " + "date of birth?");
	}

	
	@When("^I enter valid allocation DOB$")
	public void IenterValidAllocationDOB() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.allocateDay = SharedMethods.formatDay(localDate);
		SharedData.allocateMonth = SharedMethods.formatMonth(localDate);
		SharedData.allocateYear = SharedMethods.formatYear(localDate);
		dynamicAllocationPage = new DynamicAllocationPage(driver);
		dynamicAllocationPage.submitValidAllocationDateDetails(SharedData.allocateDay, SharedData.allocateMonth,
				SharedData.allocateYear);
	}
	
	

	@Then("^the allocationDOB details are sustained$")
	public void theAllocationDOBDetailsAreSustained() {
		dynamicAllocationPage = new DynamicAllocationPage(driver);
	//	assertThat(dynamicAllocationPage.getAllocationDay()).matches(SharedData.allocateDay);
	//	assertThat(dynamicAllocationPage.getAllocationMonth()).matches(SharedData.allocateMonth);
		assertThat(dynamicAllocationPage.getAllocationYear()).matches(SharedData.allocateYear);

	}

	@When("^I enter allocationDOB using different valid details$")
	public void iEnterAllocationDOBUsingDifferentDetails() {
		IenterValidAllocationDOB();
	}

	@When("^I click next on allocation date of birth page$")
	public void iClickNextOnAllocationDateOfBirthPage() {
		dynamicAllocationPage = new DynamicAllocationPage(driver);
		dynamicAllocationPage.nextStep();
	}	
		
}

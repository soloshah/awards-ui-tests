package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ChildDOBPage;
import com.nhsbsa.finance.pageobjects.DynamicDateOfBirthPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DynamicDateOfBirthStepDefs {

	private WebDriver driver = Config.getDriver();
	//private String baseUrl = PropertyReader.getProperty("base.server");
	private DynamicDateOfBirthPage dynamicDateOfBirthPage;
	ChildDOBPage childDOBPage;
	PartnerDateOfBirthStepDefs partnerDobSteps;
	
	@Then("^the dynamic partners date of birth page will be displayed$")
	public void theDynamicPartnersDateOfBirthPageWillBeDisplayed() {
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.getExampleHint().matches("For example, 31 03 1980"));
		assertThat(dynamicDateOfBirthPage.getHeading())
				.containsIgnoringCase("What is " + SharedData.firstName + "'s " + "date of birth?");
	}

	@Then("^the dynamic value of partner first name is displayed on the partners DOB page$")
	public void theDynamicValueOfPartnerFirstNameIsDisplayedOnThePartnersDOBPage() {
		Page page = new Page(driver);
		String partnerDatePageTitle = "What is " + SharedData.firstName + "'s " + "date of birth? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(partnerDatePageTitle);
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.getHeading()).contains("What is " + SharedData.firstName + "'s " + "date of birth?");

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

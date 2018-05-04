package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ChildDOBPage;
import com.nhsbsa.finance.pageobjects.DynamicChildDateOfBirthPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DynamicChildDateOfBirthStepDefs {

	private WebDriver driver = Config.getDriver();
	private DynamicChildDateOfBirthPage dynamicChildDateOfBirthPage;
	ChildDOBPage childDOBPage;

	
	@Then("^the dynamic child date of birth page will be displayed$")
	public void theDynamicChildDateOfBirthPageWillBeDisplayed() {
		dynamicChildDateOfBirthPage = new DynamicChildDateOfBirthPage(driver);
		Page page = new Page(driver);
		String childDatePageTitle = "What is " + SharedData.childFirstName + "'s " + "date of birth? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(childDatePageTitle);
		assertThat(dynamicChildDateOfBirthPage.getExampleHint().matches("For example, 31 03 1980"));
		assertThat(dynamicChildDateOfBirthPage.getHeading())
				.containsIgnoringCase("What is " + SharedData.childFirstName + "'s " + "date of birth?");
	}

	@Then("^the dynamic value of child first name is displayed on the childs DOB page$")
	public void theDynamicValueOfChildFirstNameIsDisplayedOnTheChildsDOBPage() {
		Page page = new Page(driver);
		String childDatePageTitle = "What is " + SharedData.childFirstName + "'s " + "date of birth? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(childDatePageTitle);
		dynamicChildDateOfBirthPage = new DynamicChildDateOfBirthPage(driver);
		assertThat(dynamicChildDateOfBirthPage.getHeading()).contains("What is " + SharedData.childFirstName + "'s " + "date of birth?");

	}
	
	@When("^I enter valid child DOB details$")
	public void IenterValidChildDobDetails() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.childDay = SharedMethods.formatDay(localDate);
		SharedData.childMonth = SharedMethods.formatMonth(localDate);
		SharedData.childYear = SharedMethods.formatYear(localDate);
		dynamicChildDateOfBirthPage = new DynamicChildDateOfBirthPage(driver);
		dynamicChildDateOfBirthPage.submitValidChildDateOfBirth(SharedData.childDay, SharedData.childMonth, SharedData.childYear);
	}
	
	

	
}

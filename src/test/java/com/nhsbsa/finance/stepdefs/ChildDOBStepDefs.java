package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ChildDOBPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChildDOBStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private ChildDOBPage childDOBPage;
  
   
   
	@Given("^I am on child DOB page$")
	public void iAmOnChildDOBPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-your-childs-dob");
		childDOBPage = new ChildDOBPage(driver);
		assertThat(childDOBPage.getHeading()).contains("What is your child's date of birth?");
	}

	@When("^I go to child DOB page$")
	public void iGoToChildDOBPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-your-childs-dob");
		childDOBPage = new ChildDOBPage(driver);
		assertThat(childDOBPage.getHeading()).contains("What is your child's date of birth?");
		assertThat(childDOBPage.getExampleHint().matches("For example, 31 03 1980"));
	}

	@Then("^the child date of birth submission will be successful$")
	public void thePartnerDateOfBirthSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the child date of birth page will be displayed$")
	public void theChildDateOfBirthPageWillBeDisplayed() {
		childDOBPage = new ChildDOBPage(driver);
		assertThat(childDOBPage.getHeading()).contains("What is your child's date of birth?");
	}

	@When("^I enter valid child date of birth details$")
	public void IenterValidChildDateOfBirthDetails() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.childDay = SharedMethods.formatDay(localDate);
		SharedData.childMonth = SharedMethods.formatMonth(localDate);
		SharedData.childYear = SharedMethods.formatYear(localDate);
		childDOBPage = new ChildDOBPage(driver);
		childDOBPage.submitValidChildDateOfBirth(SharedData.childDay, SharedData.childMonth, SharedData.childYear);
	}
	
	@When("^I enter valid child date of birth details using the day '(.*)', month '(.*)' and year '(.*)$")
	public void IenterValidChildDateOfBirthDetailsUsingTheDayMonthAndYear(String day, String month, String year) {
	
		childDOBPage = new ChildDOBPage(driver);
		childDOBPage.submitValidChildDateOfBirth(day,month,year);
	}
	
	@Then("^the child date of birth submission will be unsuccessful$")
	public void theChildDateOfBirthSubmissionWillBeUnsuccessful() {
		childDOBPage = new ChildDOBPage(driver);
		assertThat(childDOBPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly:");
		assertThat(childDOBPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter child DOB details using the day '(.*)', month '(.*)' and year '(.*)$")
	public void iEnterChildDOBDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		childDOBPage = new ChildDOBPage(driver);
		childDOBPage.enterChildDobDetails(day, month, year);
		childDOBPage.submitInValidChildDOBDetails();

	}

	@And("^the child date of birth error message '(.*)' will be displayed$")
	public void theChildDateOfBirthErrorMessageWillBeDisplayed(String errorMessage) {
		childDOBPage = new ChildDOBPage(driver);
		assertThat(childDOBPage.doesChildDobErrorMessageHaveAnchor()).isTrue();
		assertThat(childDOBPage.getChildDobAnchoredErrorMessage()).matches(errorMessage);
		assertThat(childDOBPage.getChildDobFieldErrorMessage()).matches(errorMessage);
	}

	@And("^I enter child DOB greater than today's date$")
	public void iEnterChildDOBGreaterThanTodaysDate() {
		LocalDate pastdate = LocalDate.now().plusDays(1);
		SharedData.day = SharedMethods.formatDay(pastdate);
		SharedData.month = SharedMethods.formatMonth(pastdate);
		SharedData.year = SharedMethods.formatYear(pastdate);
		childDOBPage = new ChildDOBPage(driver);
		childDOBPage.enterChildDobDetails(SharedData.day, SharedData.month, SharedData.year);
		childDOBPage.submitInValidChildDOBDetails();
	}

	@Then("^the dynamic value on child date of birth page will be displayed$")
	public void theDynamicValueOnChildDateOfBirthPageWillBeDisplayed() {
		childDOBPage = new ChildDOBPage(driver);
		assertThat(childDOBPage.getExampleHint().matches("For example, 31 03 1980"));
		assertThat(childDOBPage.getHeading())
				.containsIgnoringCase("What is " + SharedData.childFirstName + "'s " + "date of birth?");
	}
		
		
}
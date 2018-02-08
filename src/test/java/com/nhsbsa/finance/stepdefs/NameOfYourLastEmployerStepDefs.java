package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NameOfYourLastEmployerPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NameOfYourLastEmployerStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private NameOfYourLastEmployerPage nameOfYourLastEmployerPage;

	@Then("^What was the name of your last employer page will be displayed$")
	public void whatWasTheNameofYourLastEmployerPageWillBeDisplayed() {
		nameOfYourLastEmployerPage = new NameOfYourLastEmployerPage(driver);
		assertThat(nameOfYourLastEmployerPage.getHeading()).matches("What was the name of your last NHS employer?");
	}

	@Given("^I am on the name of the last NHS employer page$")
	public void iAmOnTheNameOfYourLastNHSEmployerPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/what-was-last-nhs-employer-name");
	}

	@When("^I go to the name of your last NHS employer page$")
	public void iGoToTheNameOfYourLastNHSEmployerPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/what-was-last-nhs-employer-name");
		nameOfYourLastEmployerPage = new NameOfYourLastEmployerPage(driver);
		assertThat(nameOfYourLastEmployerPage.getHeading()).contains("What was the name of your last NHS employer?");
	}

	@Then("^the name of your last NHS employer page submission will be successful$")
	public void theNameOfYourLastNHSEmployerPageSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@When("^I enter valid name of last NHS employer details$")
	public void IenterValidNameOfLastNHSEmployerDetails() {
		SharedData.employerName = "NHS BSA AUTHORITY";
		nameOfYourLastEmployerPage = new NameOfYourLastEmployerPage(driver);
		nameOfYourLastEmployerPage.submitValidJobTitleDetails(SharedData.employerName);
	}

	@Then("^the name of your last NHS employer page submission will be unsuccessful$")
	public void theNameOfYourLastNHSEmployerPageSubmissionWillBeUnsuccessful() {
		nameOfYourLastEmployerPage = new NameOfYourLastEmployerPage(driver);
		assertThat(nameOfYourLastEmployerPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly.");
		assertThat(nameOfYourLastEmployerPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter name of last NHS employer details using the name '(.*)'$")
	public void iEnterNameOfLastNHSEmployerDetailsUsingTheName(String employerName) {
		nameOfYourLastEmployerPage = new NameOfYourLastEmployerPage(driver);
		nameOfYourLastEmployerPage.enterEmployerNameDetails(employerName);
		nameOfYourLastEmployerPage.submitInValidEmployerNameDetails();
	}

	@And("^the name of your last NHS employer error message '(.*)' will be displayed$")
	public void theNameOfYourLastNHSEmployerErrorMessageWillBeDisplayed(String errorMessage) {
		nameOfYourLastEmployerPage = new NameOfYourLastEmployerPage(driver);
		assertThat(nameOfYourLastEmployerPage.doesEmployerNameErrorMessageHaveAnchor()).isTrue();
		assertThat(nameOfYourLastEmployerPage.getEmployerNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(nameOfYourLastEmployerPage.getEmployerNameFieldErrorMessage()).matches(errorMessage);
	}

}
package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NameOfYourCurrentEmployerPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NameOfYourCurentEmployerStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private NameOfYourCurrentEmployerPage nameOfYourCurrentEmployerPage;

	@Then("^What is the name of your current employer page will be displayed$")
	public void whatIsTheNameOfYourCurrentEmployerPageWillBeDisplayed() {
		nameOfYourCurrentEmployerPage = new NameOfYourCurrentEmployerPage(driver);
		assertThat(nameOfYourCurrentEmployerPage.getHeading())
				.contains("What is the name of your current NHS employer?");
	}

	@Given("^I am on the name of the current NHS employer page$")
	public void iAmOnTheNameOfYourCurrenttNHSEmployerPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/what-is-your-current-nhs-employer-name");
	}

	@When("^I click next on current employer name page$")
	public void iClickNextOnCurrentEmployerNamePage() {
		nameOfYourCurrentEmployerPage = new NameOfYourCurrentEmployerPage(driver);
		nameOfYourCurrentEmployerPage.nextStep();
	}

	@Then("^the currentEmploymentName details are sustained$")
	public void theCurrentEmploymentNameDetailsAreSustained() {
		nameOfYourCurrentEmployerPage = new NameOfYourCurrentEmployerPage(driver);
		assertThat(nameOfYourCurrentEmployerPage.getEmployerNameDetails()).matches(SharedData.employerName);

	}

	@When("^I go to the name of your current NHS employer page$")
	public void iGoToTheNameOfYourCurrentNHSEmployerPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/what-is-your-current-nhs-employer-name");
		nameOfYourCurrentEmployerPage = new NameOfYourCurrentEmployerPage(driver);
		assertThat(nameOfYourCurrentEmployerPage.getHeading())
				.contains("What is the name of your current NHS employer?");
	}

	@Then("^the name of your current NHS employer page submission will be successful$")
	public void theNameOfYourCurrentNHSEmployerPageSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@When("^I enter valid name of current NHS employer details$")
	public void IenterValidNameOfCurrentNHSEmployerDetails() {
		SharedData.employerName = "NHS ENGLAND";
		nameOfYourCurrentEmployerPage = new NameOfYourCurrentEmployerPage(driver);
		nameOfYourCurrentEmployerPage.submitValidEmployerNameDetails(SharedData.employerName);
	}

	@Then("^the name of your current NHS employer page submission will be unsuccessful$")
	public void theNameOfYourCurrenttNHSEmployerPageSubmissionWillBeUnsuccessful() {
		nameOfYourCurrentEmployerPage = new NameOfYourCurrentEmployerPage(driver);
		assertThat(nameOfYourCurrentEmployerPage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(nameOfYourCurrentEmployerPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I enter name of current NHS employer details using the name '(.*)'$")
	public void iEnterNameOfCurrenttNHSEmployerDetailsUsingTheName(String employerName) {
		nameOfYourCurrentEmployerPage = new NameOfYourCurrentEmployerPage(driver);
		nameOfYourCurrentEmployerPage.enterEmployerNameDetails(employerName);
		nameOfYourCurrentEmployerPage.submitInValidEmployerNameDetails();
	}

	@And("^the name of your current NHS employer error message '(.*)' will be displayed$")
	public void theNameOfYourCurrenttNHSEmployerErrorMessageWillBeDisplayed(String errorMessage) {
		nameOfYourCurrentEmployerPage = new NameOfYourCurrentEmployerPage(driver);
		assertThat(nameOfYourCurrentEmployerPage.doesEmployerNameErrorMessageHaveAnchor()).isTrue();
		assertThat(nameOfYourCurrentEmployerPage.getEmployerNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(nameOfYourCurrentEmployerPage.getEmployerNameFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter currentEmployerName using different valid details$")
	public void iEntercurrentEmployerNameUsingDifferentDetails() {
		SharedData.employerName = "NHS Scotland";
		nameOfYourCurrentEmployerPage = new NameOfYourCurrentEmployerPage(driver);
		nameOfYourCurrentEmployerPage.submitValidEmployerNameDetails(SharedData.employerName);

	}

}
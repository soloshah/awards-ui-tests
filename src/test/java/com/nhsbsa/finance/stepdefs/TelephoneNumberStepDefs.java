package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.TelephoneNumberPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TelephoneNumberStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private TelephoneNumberPage telephoneNumberPage;

	@Given("^I am on the telephone number page$")
	public void iAmOnTheTelePhoneNumberPage() {
		new Page(driver).navigateToUrl(baseUrl + "/contact-details/what-is-your-phone-number");
	}

	@Given("^I go to the telephone number page$")
	public void iGoToTheTelephoneNumberPage() {
		new Page(driver).navigateToUrl(baseUrl + "/contact-details/what-is-your-phone-number");
		telephoneNumberPage = new TelephoneNumberPage(driver);
		assertThat(telephoneNumberPage.getHeading()).contains("What is your telephone number?");
	}

	@Then("^the telephone number submission will be successful$")
	public void theTelephonNumberSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@When("^I enter valid telephone number details using the number '(.*)'$")
	public void IenterValidTelephoneNumberDetailsUsingTheNumber(String number) {
		telephoneNumberPage = new TelephoneNumberPage(driver);
		telephoneNumberPage.submitValidTelephoneNumber(number);
	}
	
	@When("^I enter valid telephone number details$")
	public void IenterValidTelephoneNumberDetails() {
		SharedData.phoneNumber = "0123456789";
		telephoneNumberPage = new TelephoneNumberPage(driver);
		telephoneNumberPage.submitValidTelephoneNumber(SharedData.phoneNumber);
	}

	
	@Then("^What is your telephone number page will be displayed$")
	public void whatisYourTelephoneNumberPageWillBeDisplayed() {
		telephoneNumberPage = new TelephoneNumberPage(driver);
		assertThat(telephoneNumberPage.getHeading()).contains("What is your telephone number?");
	}
	

	@When("^I enter telephoneNumber using different valid details$")
	public void iEnterTelephoneNumberDetailsUsingDifferentDetails() {
		SharedData.phoneNumber = "9876543210";
		telephoneNumberPage = new TelephoneNumberPage(driver);
		telephoneNumberPage.submitValidTelephoneNumber(SharedData.phoneNumber);
	}
	
	@Then("^the telephoneNumber details are sustained$")
	public void theTelephoneNumberDetailsAreSustained() {
		telephoneNumberPage = new TelephoneNumberPage(driver);
		assertThat(telephoneNumberPage.getPhoneNumber()).matches(SharedData.phoneNumber);
		
	}
	
	@When("^I click next on telephoneNumber page$")
	public void iClickNextOnTelephoneNumberPage() {
		telephoneNumberPage = new TelephoneNumberPage(driver);
		telephoneNumberPage.nextStep();
	}

	@Then("^the telephone number submission will be unsuccessful$")
	public void theTelephoneNumberSubmissionWillBeUnsuccessful() {
		telephoneNumberPage = new TelephoneNumberPage(driver);
		assertThat(telephoneNumberPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly.");
		assertThat(telephoneNumberPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter invalid telephone number details using the number '(.*)'$")
	public void iEnterInvalieTelephoneNumberDetailsUsingTheNumber(String number) {
		telephoneNumberPage = new TelephoneNumberPage(driver);
		telephoneNumberPage.enterNumber(number);
		telephoneNumberPage.submitInValidTelephoneDetails();
	}

	@And("^the telephone number error message '(.*)' will be displayed$")
	public void theTelephoneNumberErrorMessageWillBeDisplayed(String errorMessage) {
		telephoneNumberPage = new TelephoneNumberPage(driver);
		assertThat(telephoneNumberPage.doesTelephoneErrorMessageHaveAnchor()).isTrue();
		assertThat(telephoneNumberPage.getTelephoneAnchoredErrorMessage()).matches(errorMessage);
		assertThat(telephoneNumberPage.getTelephoneFieldErrorMessage()).matches(errorMessage);
	}

}

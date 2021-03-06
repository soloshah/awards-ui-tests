package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.EmailAddressPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmailAddressStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private EmailAddressPage emailAddressPage;

	@Given("^I am on the email address page$")
	public void iAmOnTheEmailAddressPage() {
		new Page(driver).navigateToUrl(baseUrl + "/contact-details/what-is-your-email-address");
	}

	@Given("^I go to the email address page$")
	public void iGoToTheEmailAddressPage() {
		new Page(driver).navigateToUrl(baseUrl + "/contact-details/what-is-your-email-address");
		emailAddressPage = new EmailAddressPage(driver);
		assertThat(emailAddressPage.getHeading()).contains("What is your email address?");
	}

	@Then("^the email address submission will be successful$")
	public void theEmailAddressSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}
	
	@Then("^What is your email address page will be displayed$")
	public void whatisYourEmailAddressPageWillBeDisplayed() {
		emailAddressPage = new EmailAddressPage(driver);
		assertThat(emailAddressPage.getHeading()).contains("What is your email address?");
	}
	
	@When("^I enter emailAddress using different valid details$")
	public void iEnterEmailAddressDetailsUsingDifferentDetails() {
		SharedData.emailAddress = "xyz@testuser.com";
		emailAddressPage = new EmailAddressPage(driver);
		emailAddressPage.submitValidEmailAddress(SharedData.emailAddress);
	}
	
	@Then("^the email details are sustained$")
	public void theEmailDetailsAreSustained() {
		emailAddressPage = new EmailAddressPage(driver);
		assertThat(emailAddressPage.getEmailAddress()).matches(SharedData.emailAddress);
		
	}
	

	@When("^I enter valid email address details using the email '(.*)'$")
	public void IenterValidEmailAddressDetailsUsingTheEmail(String email) {
		emailAddressPage = new EmailAddressPage(driver);
		emailAddressPage.submitValidEmailAddress(email);
	}
	
	@When("^I click next on emailAddress page$")
	public void iClickNextOnEmailAddressPage() {
		emailAddressPage = new EmailAddressPage(driver);
		emailAddressPage.nextStep();
	}
	
	@When("^I enter valid email address details$")
	public void IenterValidEmailAddressDetails() {
		SharedData.emailAddress = "abc@test.com";
		emailAddressPage = new EmailAddressPage(driver);
		emailAddressPage.submitValidEmailAddress(SharedData.emailAddress);
	}
		

	@Then("^the email address submission will be unsuccessful$")
	public void theEmailAddressSubmissionWillBeUnsuccessful() {
		emailAddressPage = new EmailAddressPage(driver);
		assertThat(emailAddressPage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(emailAddressPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I enter invalid email address details using the email '(.*)'$")
	public void iEnterInvalieEmailAddressDetailsUsingTheEmail(String email) {
		emailAddressPage = new EmailAddressPage(driver);
		emailAddressPage.enterEmail(email);
		emailAddressPage.submitInValidEmailDetails();
	}

	@And("^the email address error message '(.*)' will be displayed$")
	public void theEmailAddressErrorMessageWillBeDisplayed(String errorMessage) {
		emailAddressPage = new EmailAddressPage(driver);
		assertThat(emailAddressPage.doesEmailErrorMessageHaveAnchor()).isTrue();
		assertThat(emailAddressPage.getEmailAnchoredErrorMessage()).matches(errorMessage);
		assertThat(emailAddressPage.getEmailFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter valid email address using the email '(.*)'$")
	public void iEnterValidEmailAddressUsingTheEmail(String email) {
		emailAddressPage = new EmailAddressPage(driver);
		;
		emailAddressPage.enterEmailAddress(email);
	}

	@Then("^the length of email is verified$")
	public void theLengthOfEmailIsVerified() {
		emailAddressPage = new EmailAddressPage(driver);
		assertThat(emailAddressPage.readEmailField()).matches(
				"InvalidI@nvalidInvalid-Invalid.Invalid-InvalidInvalid1234567890Invalid1234567890@domain1234567890.co");

	}

}

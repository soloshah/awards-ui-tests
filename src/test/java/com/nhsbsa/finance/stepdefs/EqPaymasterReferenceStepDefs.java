package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.EqPaymasterReferencePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EqPaymasterReferenceStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private EqPaymasterReferencePage eqPaymasterReferencePage;

	@Given("^I am on the eq paymaster reference page$")
	public void iAmOnTheEqPaymasterReferencePage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/eq-paymaster-reference");
	}

	@Given("^I go to eq paymaster reference page$")
	public void iGoToEqPaymasterReferencePage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/eq-paymaster-reference");
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		assertThat(eqPaymasterReferencePage.getHeading()
				.contains("Give the reference number of " + SharedData.eqPaymasterName));
	}

	@Then("^the eqPaymasterReference page will be displayed$")
	public void theEqPaymasterReferencePageWillBeDisplayed() {
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		assertThat(eqPaymasterReferencePage.getHeading())
				.contains("Give the reference number of " + SharedData.eqPaymasterName);
	}

	@When("^I click next on eq paymaster reference page$")
	public void iClickNextOnEqpaymasterReferencePage() {
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		eqPaymasterReferencePage.nextStep();
	}

	@And("^the eqPaymasterReference details are sustained$")
	public void theeqPaymasterReferenceDetailsAreSustained() {
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		assertThat(eqPaymasterReferencePage.getEqPaymasterRef()).matches(SharedData.eqPaymasterRef);

	}

	@When("^I enter eqPaymasterReference details using different valid option$")
	public void iEnterEqPaymasterReferenceDetailsUsingDifferentValidOption() {
		SharedData.eqPaymasterRef = "9876543B";
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		eqPaymasterReferencePage.submitValidReferenceNumber(SharedData.eqPaymasterRef);
	}

	
	@Then("^the eq paymaster reference submission will be successful$")
	public void theEqPaymasterReferenceSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@When("^I enter valid eq paymaster reference number$")
	public void IenterValidEqPaymasterReferenceNumber() {
		SharedData.eqPaymasterRef = "1234567A";
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		eqPaymasterReferencePage.submitValidReferenceNumber(SharedData.eqPaymasterRef);
	}

	@Then("^the eq paymaster reference submission will be unsuccessful$")
	public void theEqPaymasterReferenceSubmissionWillBeUnsuccessful() {
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		assertThat(eqPaymasterReferencePage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(eqPaymasterReferencePage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I enter invalid eq paymaster reference number '(.*)'$")
	public void iEnterInvalidEqPaymasterReferenceNumber(String refNumber) {
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		eqPaymasterReferencePage.enterReferenceNumber(refNumber);
		eqPaymasterReferencePage.submitInValidReferenceNumber();
	}

	@And("^the eq paymaster reference error message '(.*)' will be displayed$")
	public void theEqPaymasterReferenceErrorMessageWillBeDisplayed(String errorMessage) {
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		assertThat(eqPaymasterReferencePage.doesReferenceErrorMessageHaveAnchor()).isTrue();
		assertThat(eqPaymasterReferencePage.getReferenceAnchoredErrorMessage()).matches(errorMessage);
		assertThat(eqPaymasterReferencePage.getReferenceFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I dont enter eq paymaster reference number$")
	public void iEnterValidEqPaymasterNameUsingTheName(String name) {
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		eqPaymasterReferencePage.submitInValidReferenceNumber();
	}

	@And("^I verify eq paymaster reference error message with the dynamic value of eq paymaster name$")
	public void iVerifyEqPaymasterReferenceErrorMessageWithTheDynamicValueOfEqPaymasterName() {
		eqPaymasterReferencePage = new EqPaymasterReferencePage(driver);
		String errorMessage = "Enter a valid reference number" + SharedData.eqPaymasterName
				+ ".This must be 8 characters, which includes 7 numbers and 1 letter";
		assertThat(eqPaymasterReferencePage.doesReferenceErrorMessageHaveAnchor()).isTrue();
		assertThat(eqPaymasterReferencePage.getReferenceAnchoredErrorMessage()).matches(errorMessage);
		assertThat(eqPaymasterReferencePage.getReferenceFieldErrorMessage()).matches(errorMessage);
	}

}

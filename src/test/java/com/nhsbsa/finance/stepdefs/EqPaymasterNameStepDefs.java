package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.EqPaymasterNamePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EqPaymasterNameStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private EqPaymasterNamePage eqPaymasterNamePage;

	@Given("^I am on the eq paymaster name page$")
	public void iAmOnTheEqPaymasterNamePage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/eq-paymaster-name");
	}

	@Given("^I go to the eq paymaster name page$")
	public void iGoToTheEqPaymasterNamePage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/eq-paymaster-name");
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		assertThat(eqPaymasterNamePage.getHeading()).contains("Give the name of the pension paid by Equiniti Paymaster");
	}
	
	@Then("^the eqPaymasterName page will be displayed$")
	public void theEqPaymasterNamePageWillBeDisplayed() {
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		assertThat(eqPaymasterNamePage.getHeading()).contains("Give the name of the pension paid by Equiniti Paymaster");
	}

	@Then("^the eq paymaster name submission will be successful$")
	public void theEqPaymasterNameSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}
	
	@When("^I enter eqPaymasterName details using different valid option$")
	public void iEnterEqPaymasterNameDetailsUsingDifferentValidOption(){
		SharedData.eqPaymasterName = "NHS-Ireland";
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		eqPaymasterNamePage.submitValidEqPaymasterName(SharedData.eqPaymasterName);
	}

	@When("^I enter valid eq paymaster name details$")
	public void IenterValidEqPaymasterNameDetails() {
		SharedData.eqPaymasterName = "NHS-England";
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		eqPaymasterNamePage.submitValidEqPaymasterName(SharedData.eqPaymasterName);
	}
	
	@When("^I click next on eq paymaster name page$")
	public void iClickNextOnEqPaymasterNamePage() {
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		eqPaymasterNamePage.nextStep();
	}

	@And("^the eqPaymasterName details are sustained$")
	public void theeqPaymasterNameDetailsAreSustained() {
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		assertThat(eqPaymasterNamePage.getEqPaymasterName()).matches(SharedData.eqPaymasterName);
		
	}
	
	@Then("^the eq paymaster name submission will be unsuccessful$")
	public void theEqPaymasterNameSubmissionWillBeUnsuccessful() {
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		assertThat(eqPaymasterNamePage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(eqPaymasterNamePage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I enter invalid eq paymaster name details using the name '(.*)'$")
	public void iEnterInvalidEqPaymasterNameDetailsUsingTheName(String name) {
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		eqPaymasterNamePage.enterEqPaymasterName(name);
		eqPaymasterNamePage.submitInValidEqPaymasterNameDetails();
	}

	@And("^the eq paymaster name error message '(.*)' will be displayed$")
	public void theEqPaymasterNameErrorMessageWillBeDisplayed(String errorMessage) {
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		assertThat(eqPaymasterNamePage.doesEqPaymasterNameErrorMessageHaveAnchor()).isTrue();
		assertThat(eqPaymasterNamePage.getEqPaymasterNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(eqPaymasterNamePage.getEqPaymasterNameFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter valid eq paymaster name using the name '(.*)'$")
	public void iEnterValidEqPaymasterNameUsingTheName(String name) {
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		eqPaymasterNamePage.enterEqPaymasterName(name);
		eqPaymasterNamePage.submitInValidEqPaymasterNameDetails();
	}

	@Then("^the length of eq paymaster name is verified$")
	public void theLengthOfEqPaymasterNameIsVerified() {
		eqPaymasterNamePage = new EqPaymasterNamePage(driver);
		assertThat(eqPaymasterNamePage.readEqPaymasterNameField().matches("InvalidInvalidInvalid@InvalidInv"));

	}

}

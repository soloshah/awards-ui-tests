package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.LumpSumPreference_1995Page;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LumpSumPreference_1995StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private LumpSumPreference_1995Page lumpSumPreference_1995Page;
	private String amount;

	@Then("^the 1995 lumpsum preference submission will be successful$")
	public void the1995LumpsumPreferenceSubmissionWillBeSuccessful() {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		lumpSumPreference_1995Page.selectValidLumpSumPref();
		// new NavBarPage(driver);
	}
	
	@When("^I select LessTaxFreeAmount as 1995 lumpsum preference$")
	public void ISelectLessTaxFreeAmountAs1995LumpSumPreference() {
		SharedData.sharedNHSRadioButton = "An additional amount less than the maximum tax-free amount permitted";
		amount = "1440";
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		lumpSumPreference_1995Page.selectLessThanMaxTaxFreeAmount();
		lumpSumPreference_1995Page.submitValidLumpSumAmount(amount);

	}
	
		
	@When("^I select MaxTaxFreeAmount as 1995 lumpsum preference$")
	public void ISelectMaxTaxFreeAmountAs1995LumpSumPreference() {
		SharedData.sharedNHSRadioButton = "Maximum tax-free amount";
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		lumpSumPreference_1995Page.selectMaxtaxFreeAmount();
		lumpSumPreference_1995Page.selectValidLumpSumPref();

	}
	
		

	@When("^I select valid 1995 lumpsum preference using (.*)$")
	public void ISelectValid1995LumpSumPreferenceUsing(String field) {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		switch (field) {
		case "MaxTaxFreeAmount":
			lumpSumPreference_1995Page.selectMaxtaxFreeAmount();
			break;
		case "LessTaxFreeAmount":
			lumpSumPreference_1995Page.selectLessThanMaxTaxFreeAmount();
			break;
		case "MaxAdditionalLumpSum":
			lumpSumPreference_1995Page.selectAdditionalLumpSumAmount();
			break;
		}
	}

	@When("^the valid 1995 lumpsum preference text for (.*) will be displayed$")
	public void theValid1995LumpsumPreferenceTextForWillBeDisplayed(String field) {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		switch (field) {
		case "MaxTaxFreeAmount":

			assertThat(lumpSumPreference_1995Page.getMaxTaxFreeAmountText()).matches(
					"This could be 25% of the capital value of your benefits being paid but cannot be more than 25% of your available lifetime allowance.");
			break;
		case "LessTaxFreeAmount":

			assertThat(lumpSumPreference_1995Page.getLessThanMaxTaxFreeAmountText()).matches(
					"This amount must be in whole pounds and dividable by 12. When added to your normal lump sum entitlement the total is lower than the maximum tax-free amount.");
			break;
		case "MaxAdditionalLumpSum":

			assertThat(lumpSumPreference_1995Page.getMaxAdditonalLumpSumAmountText()).matches(
					"This could be 25% of your available lifetime allowance. If the lump sum is more than 25% of the capital value of your benefits being paid you will have to pay tax on the excess amount.");
			break;

		}
	}

	@Then("^the 1995 lumpsum preference submission will be unsuccessful$")
	public void the1995LumpsumPreferenceSubmissionWillBeUnsuccessful() {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		assertThat(lumpSumPreference_1995Page.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(lumpSumPreference_1995Page.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I dont select any 1995 lumpsum preference$")
	public void iDontSelectAny1995LumpsumPreference() {

		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		lumpSumPreference_1995Page.isLumpSumAmountNotSelected();

	}

	@Then("^the default value of 1995 lumpsum preference will be blank$")
	public void theDefaultValueOf1995ReasonForRetirementWillBeBlank() {
		assertThat(lumpSumPreference_1995Page.isLumpSumAmountRadioButtonSelected()).isFalse();
	}

	@Then("^the 1995 lumpsum preference page will be displayed$")
	public void the1995LumpsumPreferencePageWillBeDisplayed() {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		assertThat(lumpSumPreference_1995Page.getHeading()).contains("How would you like your lump sum?");
	}

	@And("^the error message '(.*)' for 1995 lumpsum preference will be displayed$")
	public void theErrorMessageFor1995LumpsumPreferenceWillBeDisplayed(String errorMessage) {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		assertThat(lumpSumPreference_1995Page.doesLumpSumErrorMessageHaveAnchor()).isTrue();
		assertThat(lumpSumPreference_1995Page.getLumpSumAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lumpSumPreference_1995Page.getLumpSumFieldErrorMessage()).matches(errorMessage);
	}

	@And("^the amount error message '(.*)' for 1995 lumpsum preference will be displayed$")
	public void theAmountErrorMessageFor1995LumpsumPreferenceWillBeDisplayed(String errorMessage) {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		assertThat(lumpSumPreference_1995Page.doesAmountErrorMessageHaveAnchor()).isTrue();
		assertThat(lumpSumPreference_1995Page.getAmountAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lumpSumPreference_1995Page.getAmountFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I go to the 1995 lumpsum preference page$")
	public void iGoToThe1995LumpSumPreferencePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/1995-lump-sum-preference");
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		assertThat(lumpSumPreference_1995Page.getHeading()).contains("How would you like your lump sum?");
	}

	@And("^the amount field for 1995 lumpsum preference will be displayed$")
	public void theAmountFieldFor1995LumpsumPreferencWillBeDisplayed() {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		assertThat(lumpSumPreference_1995Page.getPoundSymbol()).matches("£");
	}

	@And("^I enter valid amount dividable by 12 for 1995 lumpsum preference$")
	public void iEnterValidAmountDividableBy12For1995LumpsumPreferenc() {
		amount = "1440";
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		lumpSumPreference_1995Page.submitValidLumpSumAmount(amount);
	}

	@And("^I enter invalid amount using '(.*)' for 1995 lumpsum preference$")
	public void iEnterInValidAmountFor1995LumpsumPreferenc(String amount) {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		lumpSumPreference_1995Page.enterAmount(amount);
		lumpSumPreference_1995Page.submitInvalidAmount();
	}
	
	@When("^I click next on 1995 lumpsum pref page$")
	public void iClickNextOn1995LumpsumPrefPage() {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		lumpSumPreference_1995Page.nextStep();
	}
	
	@Then("^the lumpSum preference details are sustained$")
	public void thelumpSumPreferenceDetailsAreSustained() {
		lumpSumPreference_1995Page = new LumpSumPreference_1995Page(driver);
		assertThat(lumpSumPreference_1995Page.getLumpsumPref()).matches(SharedData.sharedNHSRadioButton);

	}

	@When("^I select lumpSum preference using different valid option$")
	public void iSelectLumpsumPreferenceUsingDifferentValidOption() {
		ISelectMaxTaxFreeAmountAs1995LumpSumPreference();
	}
}

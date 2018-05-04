package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.LumpSumPreferencePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LumpSumPreferenceStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private LumpSumPreferencePage lumpSumPreferencePage;
	private String amount;

	@Then("^the lumpsum preference submission will be successful$")
	public void theLumpsumPreferenceSubmissionWillBeSuccessful() {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		lumpSumPreferencePage.selectValidLumpSumPref();
		 new NavBarPage(driver);
	}
	
	@When("^I select LessTaxFreeAmount as lumpsum preference$")
	public void ISelectLessTaxFreeAmountAsLumpSumPreference() {
		SharedData.sharedNHSRadioButton = "An additional amount less than the maximum tax-free amount permitted";
		amount = "1440";
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		lumpSumPreferencePage.selectLessThanMaxTaxFreeAmount();
		lumpSumPreferencePage.submitValidLumpSumAmount(amount);

	}
	
		
	@When("^I select MaxTaxFreeAmount as lumpsum preference$")
	public void ISelectMaxTaxFreeAmountAsLumpSumPreference() {
		SharedData.sharedNHSRadioButton = "Maximum tax-free amount";
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		lumpSumPreferencePage.selectMaxtaxFreeAmount();
		lumpSumPreferencePage.selectValidLumpSumPref();

	}
	

	@When("^I select MaxAdditionalLumpSum as lumpsum preference$")
	public void ISelectMaxAdditionalLumpSumAsLumpSumPreference() {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		lumpSumPreferencePage.selectAdditionalLumpSumAmount();
		lumpSumPreferencePage.selectValidLumpSumPref();
	}
		

	@When("^I select valid lumpsum preference using (.*)$")
	public void ISelectValidLumpSumPreferenceUsing(String field) {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		switch (field) {
		case "MaxTaxFreeAmount":
			lumpSumPreferencePage.selectMaxtaxFreeAmount();
			break;
		case "LessTaxFreeAmount":
			lumpSumPreferencePage.selectLessThanMaxTaxFreeAmount();
			break;
		case "MaxAdditionalLumpSum":
			lumpSumPreferencePage.selectAdditionalLumpSumAmount();
			break;
		}
	}

	@When("^the valid 1995 lumpsum preference text for (.*) will be displayed$")
	public void theValid1995LumpsumPreferenceTextForWillBeDisplayed(String field) {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		switch (field) {
		case "MaxTaxFreeAmount":

			assertThat(lumpSumPreferencePage.getMaxTaxFreeAmountText()).matches(
					"This could be 25% of the capital value of your benefits being paid but cannot be more than 25% of your available lifetime allowance.");
			break;
		case "LessTaxFreeAmount":

			assertThat(lumpSumPreferencePage.getLessThanMaxTaxFreeAmountText()).matches(
					"This amount must be in whole pounds and dividable by 12. When added to your normal lump sum entitlement the total is lower than the maximum tax-free amount.");
			break;
		case "MaxAdditionalLumpSum":

			assertThat(lumpSumPreferencePage.getMaxAdditonalLumpSumAmountText()).matches(
					"This could be 25% of your available lifetime allowance. If the lump sum is more than 25% of the capital value of your benefits being paid you will have to pay tax on the excess amount.");
			break;

		}
	}
	
	
	@When("^the valid lumpsum preference text for (.*) will be displayed$")
	public void theValidLumpsumPreferenceTextForWillBeDisplayed(String field) {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		switch (field) {
		case "MaxTaxFreeAmount":

			assertThat(lumpSumPreferencePage.getMaxTaxFreeAmountText()).matches(
					"This could be 25% of the capital value of your benefits being paid but cannot be more than 25% of your available lifetime allowance.");
			break;
		case "LessTaxFreeAmount":

			assertThat(lumpSumPreferencePage.getLessThanMaxTaxFreeAmountText()).matches(
					"This amount must be in whole pounds, dividable by 12 and lower than the maximum tax-free amount.");
			break;
		case "MaxAdditionalLumpSum":

			assertThat(lumpSumPreferencePage.getMaxAdditonalLumpSumAmountText()).matches(
					"If this is more than the maximum tax-free amount you will have to pay tax on the excess amount.");
			break;

		}
	}

	@Then("^the lumpsum preference submission will be unsuccessful$")
	public void theLumpsumPreferenceSubmissionWillBeUnsuccessful() {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(lumpSumPreferencePage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I dont select any lumpsum preference$")
	public void iDontSelectAnyLumpsumPreference() {

		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		lumpSumPreferencePage.isLumpSumAmountNotSelected();

	}


	@Then("^the lumpsum preference page will be displayed$")
	public void theLumpsumPreferencePageWillBeDisplayed() {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.getHeading()).contains("How would you like your lump sum?");
	}

	@And("^the error message '(.*)' for 1995 lumpsum preference will be displayed$")
	public void theErrorMessageFor1995LumpsumPreferenceWillBeDisplayed(String errorMessage) {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.doesLumpSumErrorMessageHaveAnchor()).isTrue();
		assertThat(lumpSumPreferencePage.getLumpSumAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lumpSumPreferencePage.getLumpSum1995FieldErrorMessage()).matches(errorMessage);
	}
	
	@And("^the error message '(.*)' for 2008 lumpsum preference will be displayed$")
	public void theErrorMessageFor2008LumpsumPreferenceWillBeDisplayed(String errorMessage) {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.doesLumpSumErrorMessageHaveAnchor()).isTrue();
		assertThat(lumpSumPreferencePage.getLumpSumAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lumpSumPreferencePage.getLumpSum2008FieldErrorMessage()).matches(errorMessage);
	}
	
	@And("^the error message '(.*)' for 2015 lumpsum preference will be displayed$")
	public void theErrorMessageFor2015LumpsumPreferenceWillBeDisplayed(String errorMessage) {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.doesLumpSumErrorMessageHaveAnchor()).isTrue();
		assertThat(lumpSumPreferencePage.getLumpSumAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lumpSumPreferencePage.getLumpSum2015FieldErrorMessage()).matches(errorMessage);
	}

	@And("^the amount error message '(.*)' for lumpsum preference will be displayed$")
	public void theAmountErrorMessageForLumpsumPreferenceWillBeDisplayed(String errorMessage) {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.doesAmountErrorMessageHaveAnchor()).isTrue();
		assertThat(lumpSumPreferencePage.getAmountAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lumpSumPreferencePage.getAmountFieldErrorMessage()).matches(errorMessage);
	}

	
	@When("^I go to the 1995 lumpsum preference page$")
	public void iGoToThe1995LumpSumPreferencePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/1995-lump-sum-preference");
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.getHeading()).contains("How would you like your lump sum?");
	}
	
	
	@When("^I go to the 2008 lumpsum preference page$")
	public void iGoToThe2008LumpSumPreferencePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2008-lump-sum-preference");
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.getHeading())
				.contains("How would you like your lump sum?");
	}

	
	
	@When("^I go to the 2015 lumpsum preference page$")
	public void iGoToThe2015LumpSumPreferencePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2015-lump-sum-preference");
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.getHeading())
				.contains("How would you like your lump sum?");
	}
	
	@And("^the amount field for lumpsum preference will be displayed$")
	public void theAmountFieldForLumpsumPreferencWillBeDisplayed() {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.getPoundSymbol()).matches("£");
	}

	@And("^I enter valid amount dividable by 12 for lumpsum preference$")
	public void iEnterValidAmountDividableBy12ForLumpsumPreferenc() {
		amount = "1440";
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		lumpSumPreferencePage.submitValidLumpSumAmount(amount);
	}

	@And("^I enter invalid amount using '(.*)' for lumpsum preference$")
	public void iEnterInValidAmountForLumpsumPreferenc(String amount) {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		lumpSumPreferencePage.enterAmount(amount);
		lumpSumPreferencePage.submitInvalidAmount();
	}
	
	@When("^I click next on lumpsum pref page$")
	public void iClickNextOnLumpsumPrefPage() {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		lumpSumPreferencePage.nextStep();
	}
	
	@Then("^the lumpSum preference details are sustained$")
	public void thelumpSumPreferenceDetailsAreSustained() {
		lumpSumPreferencePage = new LumpSumPreferencePage(driver);
		assertThat(lumpSumPreferencePage.getLumpsumPref()).matches(SharedData.sharedNHSRadioButton);

	}

	@When("^I select lumpSum preference using different valid option$")
	public void iSelectLumpsumPreferenceUsingDifferentValidOption() {
		ISelectMaxTaxFreeAmountAsLumpSumPreference();
	}
}

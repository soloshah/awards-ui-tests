package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.LumpSumPreference_2015Page;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LumpSumPreference_2015StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private LumpSumPreference_2015Page lumpSumPreference_2015Page;
	private String amount;
	
	@Then("^the 2015 lumpsum preference submission will be successful$")
	public void the2015LumpsumPreferenceSubmissionWillBeSuccessful() {
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		lumpSumPreference_2015Page.selectValidLumpSumAmount();
		// new NavBarPage(driver);
	}

	@When("^I select MaxAdditionalLumpSum as 2015 lumpsum preference$")
	public void ISelectMaxAdditionalLumpSumAs2015LumpSumPreference() {
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		lumpSumPreference_2015Page.selectAdditionalLumpSumAmount();
		lumpSumPreference_2015Page.selectValidLumpSumAmount();
	}
	
	
	@When("^I select valid 2015 lumpsum preference using (.*)$")
	public void ISelectValid2015LumpSumPreferenceUsing(String field) {
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		switch (field) {
		case "MaxTaxFreeAmount":
			lumpSumPreference_2015Page.selectMaxtaxFreeAmount();
			break;
		case "LessTaxFreeAmount":
			lumpSumPreference_2015Page.selectLessThanMaxTaxFreeAmount();
			break;
		case "MaxAdditionalLumpSum":
			lumpSumPreference_2015Page.selectAdditionalLumpSumAmount();
			break;
		}
	}

	@When("^the valid 2015 lumpsum preference text for (.*) will be displayed$")
	public void theValid2015LumpsumPreferenceTextForWillBeDisplayed(String field) {
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		switch (field) {
		case "MaxTaxFreeAmount":

			assertThat(lumpSumPreference_2015Page.getMaxTaxFreeAmountText())
					.matches("This could be 25% of the capital value of your benefits being paid but cannot be more than 25% of your available lifetime allowance.");
			break;
		case "LessTaxFreeAmount":

			assertThat(lumpSumPreference_2015Page.getLessThanMaxTaxFreeAmountText())
					.matches("This amount must be in whole pounds and dividable by 12. When added to your normal lump sum entitlement the total is lower than the maximum tax-free amount.");
			break;
		case "MaxAdditionalLumpSum":
			
			assertThat(lumpSumPreference_2015Page.getMaxAdditonalLumpSumAmountText())
			.matches("If this is more than the maximum tax-free amount you will have to pay tax on the excess amount.");
			break;
		
		}
	}
	
	@Then("^the 2015 lumpsum preference page will be displayed$")
	public void the2015LumpsumPreferencePageWillBeDisplayed() {
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		assertThat(lumpSumPreference_2015Page.getHeading()).contains("How would you like your lump sum?");
	}

	@Then("^the 2015 lumpsum preference submission will be unsuccessful$")
	public void the2015LumpsumPreferenceSubmissionWillBeUnsuccessful() {
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		assertThat(lumpSumPreference_2015Page.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(lumpSumPreference_2015Page.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I dont select any 2015 lumpsum preference$")
	public void iDontSelectAny2015LumpsumPreference() {

		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		lumpSumPreference_2015Page.isLumpSumAmountNotSelected();

	}

	@Then("^the default value of 2015 lumpsum preference will be blank$")
	public void theDefaultValueOf2015ReasonForRetirementWillBeBlank() {
		assertThat(lumpSumPreference_2015Page.isLumpSumAmountRadioButtonSelected()).isFalse();
	}

	
	@And("^the error message '(.*)' for 2015 lumpsum preference will be displayed$")
	public void theErrorMessageFor2015LumpsumPreferenceWillBeDisplayed(String errorMessage) {
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		assertThat(lumpSumPreference_2015Page.doesLumpSumErrorMessageHaveAnchor()).isTrue();
		assertThat(lumpSumPreference_2015Page.getLumpSumAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lumpSumPreference_2015Page.getLumpSumFieldErrorMessage()).matches(errorMessage);
	}
	
	@And("^the amount error message '(.*)' for 2015 lumpsum preference will be displayed$")
	public void theAmountErrorMessageFor2015LumpsumPreferenceWillBeDisplayed(String errorMessage) {
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		assertThat(lumpSumPreference_2015Page.doesAmountErrorMessageHaveAnchor()).isTrue();
		assertThat(lumpSumPreference_2015Page.getAmountAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lumpSumPreference_2015Page.getAmountFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I go to the 2015 lumpsum preference page$")
	public void iGoToThe2015LumpSumPreferencePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2015-lump-sum-preference");
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		assertThat(lumpSumPreference_2015Page.getHeading())
				.contains("How would you like your lump sum?");
	}
	
	@And("^the amount field for 2015 lumpsum preference will be displayed$")
	public void theAmountFieldFor2015LumpsumPreferenceWillBeDisplayed() {
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
		assertThat(lumpSumPreference_2015Page.getPoundSymbol()).matches("£");
	}
	
	
	@And("^I enter valid amount dividable by 12 for 2015 lumpsum preference$")
	public void iEnterValidAmountDividableBy12For2015LumpsumPreference() {
		amount = "1440";
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
	lumpSumPreference_2015Page.submitValidLumpSumAmount(amount);
	}
		

	@And("^I enter invalid amount '(.*)' for 2015 lumpsum preference$")
	public void iEnterInValidAmountFor2015LumpsumPreference(String amount) {
		lumpSumPreference_2015Page = new LumpSumPreference_2015Page(driver);
	lumpSumPreference_2015Page.enterAmount(amount);
	lumpSumPreference_2015Page.submitInvalidAmount();
	}
}

package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.LumpSumPreference_2008Page;
import com.nhsbsa.finance.pageobjects.OtherDependantChildrenPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LumpSumPreference_2008StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private LumpSumPreference_2008Page lumpSumPreference_2008Page;
	private String amount;
	
	@Then("^the 2008 lumpsum preference submission will be successful$")
	public void the2008LumpsumPreferenceSubmissionWillBeSuccessful() {
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
		lumpSumPreference_2008Page.selectValidLumpSumAmount();
		// new NavBarPage(driver);
	}

	@When("^I select valid 2008 lumpsum preference using (.*)$")
	public void IenterValid2008LumpSumPreferenceUsing(String field) {
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
		switch (field) {
		case "MaxTaxFreeAmount":
			lumpSumPreference_2008Page.selectMaxtaxFreeAmount();
			break;
		case "LessTaxFreeAmount":
			lumpSumPreference_2008Page.selectLessThanMaxTaxFreeAmount();
			break;
		case "MaxAdditionalLumpSum":
			lumpSumPreference_2008Page.selectAdditionalLumpSumAmount();
			break;
		}
	}

	@When("^the valid 2008 lumpsum preference text for (.*) will be displayed$")
	public void theValid2008LumpsumPreferenceTextForWillBeDisplayed(String field) {
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
		switch (field) {
		case "MaxTaxFreeAmount":

			assertThat(lumpSumPreference_2008Page.getMaxTaxFreeAmountText())
					.matches("This could be 25% of the capital value of your benefits being paid but cannot be more than 25% of your available lifetime allowance.");
			break;
		case "LessTaxFreeAmount":

			assertThat(lumpSumPreference_2008Page.getLessThanMaxTaxFreeAmountText())
					.matches("This amount must be in whole pounds and dividable by 12. When added to your normal lump sum entitlement the total is lower than the maximum tax-free amount.");
			break;
		case "MaxAdditionalLumpSum":
			
			assertThat(lumpSumPreference_2008Page.getMaxAdditonalLumpSumAmountText())
			.matches("If this is more than the maximum tax-free amount you will have to pay tax on the excess amount.");
			break;
		
		}
	}
	
	@Then("^the 2008 lumpsum preference page will be displayed$")
	public void the2008LumpsumPreferencePageWillBeDisplayed() {
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
		assertThat(lumpSumPreference_2008Page.getHeading()).contains("How would you like your lump sum?");
	}

	@Then("^the 2008 lumpsum preference submission will be unsuccessful$")
	public void the2008LumpsumPreferenceSubmissionWillBeUnsuccessful() {
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
		assertThat(lumpSumPreference_2008Page.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(lumpSumPreference_2008Page.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I dont select any 2008 lumpsum preference$")
	public void iDontSelectAny2008LumpsumPreference() {

		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
		lumpSumPreference_2008Page.isLumpSumAmountNotSelected();

	}

	@Then("^the default value of 2008 lumpsum preference will be blank$")
	public void theDefaultValueOf2008ReasonForRetirementWillBeBlank() {
		assertThat(lumpSumPreference_2008Page.isLumpSumAmountRadioButtonSelected()).isFalse();
	}

	
	@And("^the error message '(.*)' for 2008 lumpsum preference will be displayed$")
	public void theErrorMessageFor2008LumpsumPreferenceWillBeDisplayed(String errorMessage) {
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
		assertThat(lumpSumPreference_2008Page.doesLumpSumErrorMessageHaveAnchor()).isTrue();
		assertThat(lumpSumPreference_2008Page.getLumpSumAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lumpSumPreference_2008Page.getLumpSumFieldErrorMessage()).matches(errorMessage);
	}
	
	@And("^the amount error message '(.*)' for 2008 lumpsum preference will be displayed$")
	public void theAmountErrorMessageFor2008LumpsumPreferenceWillBeDisplayed(String errorMessage) {
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
		assertThat(lumpSumPreference_2008Page.doesAmountErrorMessageHaveAnchor()).isTrue();
		assertThat(lumpSumPreference_2008Page.getAmountAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lumpSumPreference_2008Page.getAmountFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I go to the 2008 lumpsum preference page$")
	public void iGoToThe2008LumpSumPreferencePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2008-lump-sum-preference");
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
		assertThat(lumpSumPreference_2008Page.getHeading())
				.contains("How would you like your lump sum?");
	}
	
	@And("^the amount field for 2008 lumpsum preference will be displayed$")
	public void theAmountFieldFor2008LumpsumPreferenceWillBeDisplayed() {
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
		assertThat(lumpSumPreference_2008Page.getPoundSymbol()).matches("£");
	}
	
	
	@And("^I enter valid amount dividable by 12 for 2008 lumpsum preference$")
	public void iEnterValidAmountDividableBy12For2008LumpsumPreference() {
		amount = "1440";
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
	lumpSumPreference_2008Page.submitValidLumpSumAmount(amount);
	}
		

	@And("^I enter invalid amount '(.*)' for 2008 lumpsum preference$")
	public void iEnterInValidAmountFor2008LumpsumPreference(String amount) {
		lumpSumPreference_2008Page = new LumpSumPreference_2008Page(driver);
	lumpSumPreference_2008Page.enterAmount(amount);
	lumpSumPreference_2008Page.submitInvalidAmount();
	}
}

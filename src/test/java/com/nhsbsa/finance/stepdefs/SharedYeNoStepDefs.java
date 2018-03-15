package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.SharedYesNoPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class SharedYeNoStepDefs {

	private WebDriver driver = Config.getDriver();

	SharedYesNoPage sharedYesNoPage;

	@When("^I select Yes$")
	public void iSelectYes() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		sharedYesNoPage.selectYes();
	}

	@When("^I select No$")
	public void iSelectNo() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		sharedYesNoPage.selectNo();
	}

	@When("^I dont select anything$")
	public void iDontSelectAnything() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		sharedYesNoPage.radioButtonIsNotSelected();
	}
	
	@And("^the radio button not selected error message '(.*)' will be displayed$")
	public void theRadioButtonNotSelectedErrorMessageWillBeDisplayed(String errorMessage) {
		sharedYesNoPage = new SharedYesNoPage(driver);
		assertThat(sharedYesNoPage.getSharedFieldErrorMessage()).matches(errorMessage);
		assertThat(sharedYesNoPage.doesSharedErrorMessageHaveAnchor()).isTrue();
		assertThat(sharedYesNoPage.getSharedAnchoredErrorMessage()).matches(errorMessage);
	}
}
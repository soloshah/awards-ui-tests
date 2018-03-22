package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.SharedYesNoPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class SharedYeNoStepDefs {

	private WebDriver driver = Config.getDriver();

	SharedYesNoPage sharedYesNoPage;

	@When("^I select Yes$")
	public void iSelectYes() {
		SharedData.sharedRadioButton = "Yes";
		sharedYesNoPage = new SharedYesNoPage(driver);
		sharedYesNoPage.selectYes();
	}

	@When("^I select No$")
	public void iSelectNo() {
		SharedData.sharedRadioButton = "No";
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

	@When("^I click next on other eq pensions page$")
	public void iClickNextOnOthereqpensionsPage() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		sharedYesNoPage.nextStep();
	}

	@When("^I select otherEqPensions details using different valid option$")
	public void iSelectotherEqPensionsDetailsUsingDifferentValidOption() {
		iSelectNo();
	}

	@And("^the otherEqPensions details are sustained$")
	public void theOtherEqPensionDetailsAreSustained() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		assertThat(sharedYesNoPage.getYesRadioButton()).matches(SharedData.sharedRadioButton);

	}

}
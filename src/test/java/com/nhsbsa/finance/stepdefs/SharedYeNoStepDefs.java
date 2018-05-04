package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.SharedYesNoPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
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
		assertThat(sharedYesNoPage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
        assertThat(sharedYesNoPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
		assertThat(sharedYesNoPage.getSharedFieldErrorMessage()).matches(errorMessage);
		assertThat(sharedYesNoPage.doesSharedErrorMessageHaveAnchor()).isTrue();
		assertThat(sharedYesNoPage.getSharedAnchoredErrorMessage()).matches(errorMessage);
	}

	@When("^I click next on other eq pensions page$")
	public void iClickNextOnOthereqpensionsPage() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		sharedYesNoPage.nextStep();
	}
	
	@When("^I click next on 1995 lumpsum choice page$")
	public void iClickNextOn1995LumpsumChoicePage() {
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
	
	@And("^the working for nhs details are sustained$")
	public void theWorkingForNHSDetailsAreSustained() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		assertThat(sharedYesNoPage.getYesRadioButton()).matches(SharedData.sharedRadioButton);

	}
	
	@And("^the lumpsum choice details are sustained$")
	public void theLumpsumChoiceDetailsAreSustained() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		assertThat(sharedYesNoPage.getYesRadioButton()).matches(SharedData.sharedRadioButton);

	}	
	
	@When("^I select lumpsum choice using different details$")
	public void iSelectLumpSumChoiceUsingDifferentDetails() {
		iSelectNo();
	}

	
	
	@And("^the otherPensionArrangement details are sustained$")
	public void theOtherPensionArrangementDetailsAreSustained() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		assertThat(sharedYesNoPage.getYesRadioButton()).matches(SharedData.sharedRadioButton);

	}	
	
	@When("^I select different pensionArrangement using different valid option$")
	public void iSelectDifferentPensionArrangementUsingDifferentValidOption() {
		iSelectYes();
	}

	

	@When("^I click on the link increase in lump sum affects benefits$")
	public void iClickOnTheLinkIncreaseinLumpSumAffectsBenefits() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		sharedYesNoPage.verifyLumpSumLink();
	}

	@Then("^the lump sum benefits information text will be displayed$")
	public void theLumpSumBenefitsInformationTextWillBeDisplayed() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		assertThat(sharedYesNoPage.verifyLumpSumInformationText())
				.contains("For every £1 of pension exchanged you’ll receive £12 of lump sum.");
		assertThat(sharedYesNoPage.verifyLumpSumMoreInformationText()).contains("For example, if you exchange £100 of your pension, you’d get £1200 of lump sum.");
	}

	
	
	@Then("^the dependantChildren details are sustained$")
	public void theDependantChildrenDetailsAreSustained() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		assertThat(sharedYesNoPage.getYesRadioButton()).matches(SharedData.sharedRadioButton);
		iClickNextOnDependantChildrenPage();

	}

		
	@When("^I click next on dependantChildren page$")
	public void iClickNextOnDependantChildrenPage() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		sharedYesNoPage.nextStep();
	}
	
	
	@Then("^the allocatePension details are sustained$")
	public void theAllocatePensionDetailsAreSustained() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		assertThat(sharedYesNoPage.getYesRadioButton()).matches(SharedData.sharedRadioButton);

	}

	@When("^I select allocatePension using different valid option$")
	public void iSelectAllocatePensionUsingDifferentValidOption() {
			iSelectNo();
			
	}
	
	@When("^I click next on allocatePension page$")
	public void iClickNextOnAllocatePensionPage() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		sharedYesNoPage.nextStep();
	}
	
	@And("^the excessBenefit details are sustained$")
	public void theExcessBenefitDetailsAreSustained() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		assertThat(sharedYesNoPage.getYesRadioButton()).matches(SharedData.sharedRadioButton);

	}	
	
	@When("^I select excessBenefit with different valid option$")
	public void iSelectexcessBenefitWithDifferentValidOption() {
		iSelectNo();
	}

	

}
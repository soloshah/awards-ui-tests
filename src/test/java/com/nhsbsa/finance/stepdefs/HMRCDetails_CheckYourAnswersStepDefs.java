package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.HMRCDetails_CheckYourAnswerPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HMRCDetails_CheckYourAnswersStepDefs {

	private WebDriver driver = Config.getDriver();

	private HMRCDetails_CheckYourAnswerPage hMRCDetails_CheckYourAnswerPage;
	private StartPageStepdefs startSteps;
	private OtherPensionArrangementsStepDefs otherPensionSteps;
	private PensionOver30StepDefs pensionOver30kSteps;
	private SeparatePensionBenefitsStepDefs separatePensionSteps;
	private TreatBenefitsStepDefs treatBenefitsSteps;
	private LifetimeAllowanceStepDefs lifetimeAllowanceSteps;
	private SharedYeNoStepDefs sharedYesNoSteps;

	@Given("^I have filled in the hmrc details$")
	public void iHaveFilledInTheHmrcDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		otherPensionSteps = new OtherPensionArrangementsStepDefs();
		otherPensionSteps.iGoToOtherPensionArrangementsPage();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		pensionOver30kSteps = new PensionOver30StepDefs();
		pensionOver30kSteps.iSelectYesOnPensionOver30kPage();
		separatePensionSteps =  new SeparatePensionBenefitsStepDefs();
		separatePensionSteps.IselectAfterAndBeforeApril62006AndIdontHaveInformation();
		treatBenefitsSteps =  new TreatBenefitsStepDefs();
		treatBenefitsSteps.theTreatBenefitsPageWillbeDisplayed();
		sharedYesNoSteps =  new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		lifetimeAllowanceSteps = new LifetimeAllowanceStepDefs();
		lifetimeAllowanceSteps.theLifetimeAllowancePageWillBeDisplayed();
		lifetimeAllowanceSteps.iSelectNoOnLifetimeAllowancePage();

	}
	

	@Then("^Check your answers page for hmrc details will be displayed$")
	public void checkYourAnswersPageForHmrcDetailsWillBeDisplayed() {
		hMRCDetails_CheckYourAnswerPage = new HMRCDetails_CheckYourAnswerPage(driver);
		assertThat(hMRCDetails_CheckYourAnswerPage.getHeading()).contains("Check your answers");
	}

	@Then("^the correct hmrc details will be displayed$")
	public void theCorrectHmrcDetailsWillBeDisplayed() {
		hMRCDetails_CheckYourAnswerPage = new HMRCDetails_CheckYourAnswerPage(driver);
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfOtherPension()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getOtherPensions()).matches("Do you have any additional pension arrangements");
		assertThat(hMRCDetails_CheckYourAnswerPage.getOtherPensionsText()).matches("Yes");
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfPensionOver30k()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getPensionOver30k()).matches("Will your NHS pension plus any other pension benefits be more than £30,000 per year, or have you accessed your benefits with another pension scheme using pension flexibilities");
		assertThat(hMRCDetails_CheckYourAnswerPage.getPensionOver30kText()).matches(SharedData.shared1995RadioButton);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfAfterApril6()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getAfterApril6()).matches("Yes - they were in payment on or after 6 April 2006");
		assertThat(hMRCDetails_CheckYourAnswerPage.getAfterApril6Text()).matches("Yes");
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfCombinedLTA()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getCombinedLTA()).matches("Total combined % of LTA");
		assertThat(hMRCDetails_CheckYourAnswerPage.getCombinedLTAText()).matches(SharedData.combinedLTA);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfBenefitDate()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getBenefitDate()).matches("What is the date of first Benefit Crystallisation");
		assertThat(hMRCDetails_CheckYourAnswerPage.getBenefitDateText()).matches(SharedData.day + " " +SharedData.month + " " +SharedData.year);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfBeforeApril6()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getBeforeApril6()).matches("Yes – they were in payment before 6 April 2006");
		assertThat(hMRCDetails_CheckYourAnswerPage.getBeforeApril6Text()).matches("Yes");
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfGrossAnnualRate()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getGrossAnnualRate()).matches("Gross annual rate");
		assertThat(hMRCDetails_CheckYourAnswerPage.getGrossAnnualRateText()).matches(SharedData.grossAnnualRate);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfSeparateBenefitsNoInformation()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getSeparateBenefitsNoInformation()).matches("Do you have any separate pension benefits");
		assertThat(hMRCDetails_CheckYourAnswerPage.getSeparateBenefitsText()).matches(SharedData.sharedCheckBox);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfExcessLTA()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getExcessLTA()).matches("Would you like us to treat your NHS Pension Scheme benefits in the excess of the Lifetime Allowance");
		assertThat(hMRCDetails_CheckYourAnswerPage.getExcessLTAText()).matches(SharedData.sharedRadioButton);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfLifetimeAllowance()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getLifetimeAllowance()).matches("Do you have HMRC Lifetime Allowance protection");
		assertThat(hMRCDetails_CheckYourAnswerPage.getLifetimeAllowanceText()).matches(SharedData.sharedNHSRadioButton);
		
	}

	
	@Then("^the correct hmrc details with updated separateBenefits will be displayed$")
	public void theCorrectHmrcDetailsWithUpdatedSeparateBenefitsWillBeDisplayed() {
		hMRCDetails_CheckYourAnswerPage = new HMRCDetails_CheckYourAnswerPage(driver);
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfOtherPension()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getOtherPensions()).matches("Do you have any additional pension arrangements");
		assertThat(hMRCDetails_CheckYourAnswerPage.getOtherPensionsText()).matches("Yes");
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfPensionOver30k()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getPensionOver30k()).matches("Will your NHS pension plus any other pension benefits be more than £30,000 per year, or have you accessed your benefits with another pension scheme using pension flexibilities");
		assertThat(hMRCDetails_CheckYourAnswerPage.getPensionOver30kText()).matches(SharedData.shared1995RadioButton);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfAfterApril6()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getAfterApril6()).matches("Yes - they were in payment on or after 6 April 2006");
		assertThat(hMRCDetails_CheckYourAnswerPage.getAfterApril6Text()).matches("Yes");
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfCombinedLTA()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getCombinedLTA()).matches("Total combined % of LTA");
		assertThat(hMRCDetails_CheckYourAnswerPage.getCombinedLTAText()).matches(SharedData.combinedLTA);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfBenefitDate()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getBenefitDate()).matches("What is the date of first Benefit Crystallisation");
		assertThat(hMRCDetails_CheckYourAnswerPage.getBenefitDateText()).matches(SharedData.day + " " +SharedData.month + " " +SharedData.year);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfBeforeApril6()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getBeforeApril6()).matches("Yes – they were in payment before 6 April 2006");
		assertThat(hMRCDetails_CheckYourAnswerPage.getBeforeApril6Text()).matches("Yes");
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfGrossAnnualRate()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getGrossAnnualRate()).matches("Gross annual rate");
		assertThat(hMRCDetails_CheckYourAnswerPage.getGrossAnnualRateText()).matches(SharedData.grossAnnualRate);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfSeparatePensionNobenefits()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getSeparatePensionNoBenefits()).matches("Do you have any separate pension benefits");
		assertThat(hMRCDetails_CheckYourAnswerPage.getSeparatePensionNoBenefitsText()).matches(SharedData.sharedCheckBox);
		
		assertThat(hMRCDetails_CheckYourAnswerPage.getPresenceOfLifetimeAllowance()).isEqualTo(true);
		assertThat(hMRCDetails_CheckYourAnswerPage.getLifetimeAllowance()).matches("Do you have HMRC Lifetime Allowance protection");
		assertThat(hMRCDetails_CheckYourAnswerPage.getLifetimeAllowanceText()).matches(SharedData.sharedNHSRadioButton);
		
	}
	
	@And("^the updated value for (.*) will be displayed$")
	public void theUpdatedValueForWillBeDisplayed(String field) {
		hMRCDetails_CheckYourAnswerPage = new HMRCDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "pensionover30k":
			assertThat(hMRCDetails_CheckYourAnswerPage.getPensionOver30kText()).matches(SharedData.shared1995RadioButton);
			break;
		case "combinedLTA":
			assertThat(hMRCDetails_CheckYourAnswerPage.getCombinedLTA()).matches(SharedData.combinedLTA);
			break;
		case "benefitCrysallisationDate":
			assertThat(hMRCDetails_CheckYourAnswerPage.getBenefitDateText()).matches(SharedData.day + " " +SharedData.month + " " +SharedData.year);
			break;
		case "grossAnnualRate":
			assertThat(hMRCDetails_CheckYourAnswerPage.getGrossAnnualRateText()).matches(SharedData.grossAnnualRate);
			break;
		case "separateNoBenefit":
			assertThat(hMRCDetails_CheckYourAnswerPage.getSeparatePensionNoBenefitsText()).matches(SharedData.sharedCheckBox);
			break;

		}
	}

	
	@When("^I click change (.*)$")
	public void iClickOnChangeOn(String field) {
		hMRCDetails_CheckYourAnswerPage = new HMRCDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "otherPensionBenefits":
			hMRCDetails_CheckYourAnswerPage.changePensionOver30K();
			break;
		case "combinedLTA":
			hMRCDetails_CheckYourAnswerPage.changeCombinedLTA();
			break;
		case "benefitCrysallisationDate":
			hMRCDetails_CheckYourAnswerPage.changeBenefitsDate();
			break;
		case "grossAnnualrate":
			hMRCDetails_CheckYourAnswerPage.changeGrossAnnualRate();
			break;
		case "separateBenefit":
			hMRCDetails_CheckYourAnswerPage.changeSeparateBenefits();
			break;
		case "excessBenefit":
			hMRCDetails_CheckYourAnswerPage.changeExcessLTA();
			break;
	
		}
	}

	@When("^I submit the hmrc details$")
	public void iSubmitTheHmrcDetails() {
		hMRCDetails_CheckYourAnswerPage = new HMRCDetails_CheckYourAnswerPage(driver);
		hMRCDetails_CheckYourAnswerPage.submitHMRCDetails();
	}
	
	
	@And("^I navigate from pensionOver30k page to check your answers page$")
	public void InavigateFrompensionOver30kPageToCheckYourAnswersPage() {
		separatePensionSteps =  new SeparatePensionBenefitsStepDefs();
		separatePensionSteps.theSeparatePensionBenefitsPageWillBeDisplayed();
		separatePensionSteps.iClickNextOnSeparateBenefitPage();
		treatBenefitsSteps =  new TreatBenefitsStepDefs();
		treatBenefitsSteps.theTreatBenefitsPageWillbeDisplayed();
		treatBenefitsSteps.iClickNextOnTreatExcessBenefitPage();
		lifetimeAllowanceSteps = new LifetimeAllowanceStepDefs();
		lifetimeAllowanceSteps.theLifetimeAllowancePageWillBeDisplayed();
		lifetimeAllowanceSteps.iClickNextOnLifetimeAllowancePage();

	}
	
	
	
	@And("^I navigate from separateBenefits page to check your answers page$")
	public void InavigateFromSeparateBenefitsPageToCheckYourAnswersPage() {
		treatBenefitsSteps =  new TreatBenefitsStepDefs();
		treatBenefitsSteps.theTreatBenefitsPageWillbeDisplayed();
		treatBenefitsSteps.iClickNextOnTreatExcessBenefitPage();
		lifetimeAllowanceSteps = new LifetimeAllowanceStepDefs();
		lifetimeAllowanceSteps.theLifetimeAllowancePageWillBeDisplayed();
		lifetimeAllowanceSteps.iClickNextOnLifetimeAllowancePage();

	}
	
	@And("^I navigate from lifetimeAllowance page to check your answers page$")
	public void InavigateFromLifetimeAllowancePageToCheckYourAnswersPage() {
		lifetimeAllowanceSteps = new LifetimeAllowanceStepDefs();
		lifetimeAllowanceSteps.theLifetimeAllowancePageWillBeDisplayed();
		lifetimeAllowanceSteps.iClickNextOnLifetimeAllowancePage();

	}
	
	
	
}
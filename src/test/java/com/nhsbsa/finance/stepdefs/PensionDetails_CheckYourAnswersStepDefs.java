package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.PensionDetails_CheckYourAnswerPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PensionDetails_CheckYourAnswersStepDefs {

	private WebDriver driver = Config.getDriver();
	private PensionDetails_CheckYourAnswerPage pensionDetails_CheckYourAnswerPage;
	private StartPageStepdefs startSteps;
	private WhichSchemeStepDefs whichSchemeSteps;
	private SharedYeNoStepDefs sharedYesNoSteps;
	private SharedEarlyPaymentStepDefs sharedEarlyPaymentSteps;
	private RetirementReason_1995StepDefs retirementReason1995Steps;
	private RetirementReason_2008StepDefs retirementReason2008Steps;
	private RetirementReason_2015StepDefs retirementReason2015Steps;
	private LumpSumChoice_1995StepDefs lumpsumChoice1995Steps;
	private LumpSumChoice_2008StepDefs lumpsumChoice2008Steps;
	private LumpSumChoice_2015StepDefs lumpsumChoice2015Steps;
	private LumpSumPreference_1995StepDefs lumpsumPref1995Steps;
	private LumpSumPreference_2008StepDefs lumpsumPref2008Steps;
	private LumpSumPreference_2015StepDefs lumpsumPref2015Steps;
	private Interstitial2008StepDefs interstitial2008Steps;
	private Interstitial2015StepDefs interstitial2015Steps;

	@Given("^I have filled in 1995 pension scheme details$")
	public void iHaveFilledIn1995PensionSchemeDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		whichSchemeSteps = new WhichSchemeStepDefs();
		whichSchemeSteps.iGoToWhichSchemePage();
		whichSchemeSteps.Iselect1995SectionScheme();
		retirementReason1995Steps = new RetirementReason_1995StepDefs();
		retirementReason1995Steps.the1995ReasonForRetirementPageWillBeDisplayed();
		retirementReason1995Steps.ISelectDeferredBenefitAs1995RetirementReason();
		sharedEarlyPaymentSteps = new SharedEarlyPaymentStepDefs();
		sharedEarlyPaymentSteps.theEarlyPaymentDatePageWillBeDisplayed();
		sharedEarlyPaymentSteps.IenterValidEarlyPaymentDateDetails();
		lumpsumChoice1995Steps = new LumpSumChoice_1995StepDefs();
		lumpsumChoice1995Steps.the1995LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		lumpsumPref1995Steps = new LumpSumPreference_1995StepDefs();
		lumpsumPref1995Steps.ISelectLessTaxFreeAmountAs1995LumpSumPreference();
	}
	
	@Given("^I have filled in 1995 pension scheme details for summary page$")
	public void iHaveFilledIn1995PensionSchemeDetailsForSummaryPage() throws Throwable {
		whichSchemeSteps = new WhichSchemeStepDefs();
		whichSchemeSteps.whichSchemePageWillBeDisplayed();
		whichSchemeSteps.Iselect1995SectionScheme();
		retirementReason1995Steps = new RetirementReason_1995StepDefs();
		retirementReason1995Steps.the1995ReasonForRetirementPageWillBeDisplayed();
		retirementReason1995Steps.ISelectDeferredBenefitAs1995RetirementReason();
		sharedEarlyPaymentSteps = new SharedEarlyPaymentStepDefs();
		sharedEarlyPaymentSteps.theEarlyPaymentDatePageWillBeDisplayed();
		sharedEarlyPaymentSteps.IenterValidEarlyPaymentDateDetails();
		lumpsumChoice1995Steps = new LumpSumChoice_1995StepDefs();
		lumpsumChoice1995Steps.the1995LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		lumpsumPref1995Steps = new LumpSumPreference_1995StepDefs();
		lumpsumPref1995Steps.ISelectLessTaxFreeAmountAs1995LumpSumPreference();
	}

	@Given("^I have filled in 2008 pension scheme details$")
	public void iHaveFilledIn2008PensionSchemeDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		whichSchemeSteps = new WhichSchemeStepDefs();
		whichSchemeSteps.iGoToWhichSchemePage();
		whichSchemeSteps.Iselect2008SectionScheme();
		retirementReason2008Steps = new RetirementReason_2008StepDefs();
		retirementReason2008Steps.ISelect2008RetirementReasonAsRetirementAge();
		lumpsumChoice2008Steps = new LumpSumChoice_2008StepDefs();
		lumpsumChoice2008Steps.the2008LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		lumpsumPref2008Steps = new LumpSumPreference_2008StepDefs();
		lumpsumPref2008Steps.ISelectMaxTaxFreeAmountAs2008LumpSumPreference();
	}

	@Given("^I fill in 2008 pension scheme details$")
	public void iFillIn2008PensionSchemeDetails() throws Throwable {
		retirementReason2008Steps = new RetirementReason_2008StepDefs();
		retirementReason2008Steps.ISelect2008RetirementReasonAsRetirementAge();
		lumpsumChoice2008Steps = new LumpSumChoice_2008StepDefs();
		lumpsumChoice2008Steps.the2008LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		lumpsumPref2008Steps = new LumpSumPreference_2008StepDefs();
		lumpsumPref2008Steps.ISelectMaxTaxFreeAmountAs2008LumpSumPreference();
	}

	@Given("^I have filled in 2015 pension scheme details$")
	public void iHaveFilledIn2015PensionSchemeDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		whichSchemeSteps = new WhichSchemeStepDefs();
		whichSchemeSteps.iGoToWhichSchemePage();
		whichSchemeSteps.Iselect2015SectionScheme();
		retirementReason2015Steps = new RetirementReason_2015StepDefs();
		retirementReason2015Steps.the2015ReasonForRetirementPageWillBeDisplayed();
		retirementReason2015Steps.iSelectdeferredBenefitHealth2015RetirementReason();
		lumpsumChoice2015Steps = new LumpSumChoice_2015StepDefs();
		lumpsumChoice2015Steps.the2015LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		lumpsumPref2015Steps = new LumpSumPreference_2015StepDefs();
		lumpsumPref2015Steps.the2015LumpsumPreferencePageWillBeDisplayed();
		lumpsumPref2015Steps.ISelectMaxAdditionalLumpSumAs2015LumpSumPreference();
	}

	@Given("^I have filled in all pension scheme details$")
	public void iHaveFilledInAllPensionSchemeDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		whichSchemeSteps = new WhichSchemeStepDefs();
		whichSchemeSteps.iGoToWhichSchemePage();
		whichSchemeSteps.iSelectAllTheSchemes();
		retirementReason1995Steps = new RetirementReason_1995StepDefs();
		retirementReason1995Steps.the1995ReasonForRetirementPageWillBeDisplayed();
		retirementReason1995Steps.ISelectretirementAgeAs1995RetirementReason();
		lumpsumChoice1995Steps = new LumpSumChoice_1995StepDefs();
		lumpsumChoice1995Steps.the1995LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectNo();
		interstitial2008Steps = new Interstitial2008StepDefs();
		interstitial2008Steps.the2008InterstitialPageWillBeDisplayed();
		retirementReason2008Steps = new RetirementReason_2008StepDefs();
		retirementReason2008Steps.ISelect2008RetirementReasonAsRetirementAge();
		lumpsumChoice2008Steps = new LumpSumChoice_2008StepDefs();
		lumpsumChoice2008Steps.the2008LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		lumpsumPref2008Steps = new LumpSumPreference_2008StepDefs();
		lumpsumPref2008Steps.ISelectMaxTaxFreeAmountAs2008LumpSumPreference();
		interstitial2015Steps = new Interstitial2015StepDefs();
		interstitial2015Steps.the2015InterstitialPageWillBeDisplayed();
		retirementReason2015Steps = new RetirementReason_2015StepDefs();
		retirementReason2015Steps.the2015ReasonForRetirementPageWillBeDisplayed();
		retirementReason2015Steps.iSelectdeferredBenefitHealth2015RetirementReason();
		lumpsumChoice2015Steps = new LumpSumChoice_2015StepDefs();
		lumpsumChoice2015Steps.the2015LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectNo();

	}

	@Then("^Check your answers page for pension scheme details will be displayed$")
	public void checkYourAnswersPageForPensionSchemeDetailsWillBeDisplayed() {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		assertThat(pensionDetails_CheckYourAnswerPage.getHeading()).contains("Check your answers");
	}

	@And("^the correct 1995 pension scheme details will be displayed$")
	public void theCorrect1995PensionSchemeDetailsWillBeDisplayed() {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOfWhichScheme()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichScheme())
				.matches("Which Section or Scheme are you claiming benefits from");
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichSchemeText()).matches("1995");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995Section()).matches("1995 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995RetirementReason()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995Retirementreason())
				.matches("Why are you claiming your deferred benefits for the 1995 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995RetirementReasonText())
				.matches(SharedData.shared1995RadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995EarlyPaymentDate()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995EarlyPaymentDate())
				.matches("When should the early payment of deferred benefit start");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995EarlyPaymentDateText())
				.matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995LumpsumChoice()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoice()).matches(
				"You are already entitled to a lump sum. Do you want to increase your lump sum by giving up part of your 1995 pension");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoiceText()).matches(SharedData.sharedRadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995LumpsumPref()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumPref()).matches("How would you like your lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumPrefText())
				.matches(SharedData.sharedNHSRadioButton + "\n" +"£1440");

	}
	
	
	@And("^the 1995 pension scheme details with different option will be displayed$")
	public void the1995PensionSchemeDetailsWithDifferentOptionWillBeDisplayed() {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOfWhichScheme()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichScheme())
				.matches("Which Section or Scheme are you claiming benefits from");
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichSchemeText()).matches("1995");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995Section()).matches("1995 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995RetirementReason()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995Retirementreason())
				.matches("Why are you claiming your deferred benefits for the 1995 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995RetirementReasonText())
				.matches(SharedData.shared1995RadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995EarlyPaymentDate()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995EarlyPaymentDate())
				.matches("When should the early payment of deferred benefit start");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995EarlyPaymentDateText())
				.matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995LumpsumChoice()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoice()).matches(
				"You are already entitled to a lump sum. Do you want to increase your lump sum by giving up part of your 1995 pension");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoiceText()).matches(SharedData.sharedRadioButton);
		
	}
	
	
	@And("^the 1995 pension scheme details will be displayed$")
	public void the1995PensionSchemeDetailsWillBeDisplayed() {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOfWhichScheme()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichScheme())
				.matches("Which Section or Scheme are you claiming benefits from");
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichSchemeText()).matches("1995");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995Section()).matches("1995 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995RetirementReason()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995Retirementreason())
				.matches("Why are you claiming your deferred benefits for the 1995 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995RetirementReasonText())
				.matches(SharedData.shared1995RadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995EarlyPaymentDate()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995EarlyPaymentDate())
				.matches("When should the early payment of deferred benefit start");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995EarlyPaymentDateText())
				.matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995LumpsumChoice()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoice()).matches(
				"You are already entitled to a lump sum. Do you want to increase your lump sum by giving up part of your 1995 pension");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoiceText()).matches(SharedData.sharedRadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995LumpsumPref()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumPref()).matches("How would you like your lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumPrefText())
				.matches(SharedData.sharedNHSRadioButton);

	}
	

	@And("^the correct 2008 pension scheme details will be displayed$")
	public void theCorrect2008PensionSchemeDetailsWillBeDisplayed() {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOfWhichScheme()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichScheme())
				.matches("Which Section or Scheme are you claiming benefits from");
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichSchemeText()).matches("2008");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008Section()).matches("2008 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2008RetirementReason()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2008RetirementReason())
				.matches("Why are you claiming your deferred benefits for the 2008 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008RetirementReasonText())
				.matches("Retirement based on your age");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2008LumpsumChoice()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumChoice()).matches(
				"Do you want to give up part of your 2008 Section pension to receive a lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumChoiceText()).matches(SharedData.sharedRadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2008LumpsumPref()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumPref()).matches("How would you like your lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumPrefText()).matches("Maximum tax-free amount");

	}

	@And("^the correct 2015 pension scheme details will be displayed$")
	public void theCorrect2015PensionSchemeDetailsWillBeDisplayed() {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOfWhichScheme()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichScheme())
				.matches("Which Section or Scheme are you claiming benefits from");
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichSchemeText()).matches("2015");
		assertThat(pensionDetails_CheckYourAnswerPage.get2015Section()).matches("2015 Scheme");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2015RetirementReason()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2015RetirementReason())
				.matches("Why are you claiming your deferred benefits for the 2015 Scheme");
		assertThat(pensionDetails_CheckYourAnswerPage.get2015RetirementReasonText())
				.matches("Early payment of deferred benefits because of ill health");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2015LumpsumChoice()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2015LumpsumChoice()).matches(
				"Do you want to give up part of your 2015 Section pension to receive a lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get2015LumpsumChoiceText()).matches(SharedData.sharedRadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2015LumpsumPref()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2015LumpsumPref()).matches("How would you like your lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get2015LumpsumPrefText())
				.matches("The maximum additional lump sum, which may incur a tax charge");

	}

	@And("^the correct pension scheme details will be displayed$")
	public void theCorrectPensionSchemeDetailsWillBeDisplayed() {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOfWhichScheme()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichScheme())
				.matches("Which Section or Scheme are you claiming benefits from");
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichSchemeText()).matches("1995\n2008\n2015");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995Section()).matches("1995 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995RetirementReason()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995Retirementreason())
				.matches("Why are you claiming your deferred benefits for the 1995 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995RetirementReasonText())
				.matches(SharedData.shared1995RadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995LumpsumChoice()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoice()).matches("You are already entitled to a lump sum. Do you want to increase your lump sum by giving up part of your 1995 pension");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoiceText()).matches("No");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008Section()).matches("2008 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2008RetirementReason()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2008RetirementReason()).matches("Why are you claiming your deferred benefits for the 2008 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008RetirementReasonText()).matches("Retirement based on your age");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2008LumpsumChoice()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumChoice()).matches("Do you want to give up part of your 2008 Section pension to receive a lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumChoiceText()).matches("Yes");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2008LumpsumPref()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumPref()).matches("How would you like your lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumPrefText()).matches("Maximum tax-free amount");
		assertThat(pensionDetails_CheckYourAnswerPage.get2015Section()).matches("2015 Scheme");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2015RetirementReason()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2015RetirementReason())
				.matches("Why are you claiming your deferred benefits for the 2015 Scheme");
		assertThat(pensionDetails_CheckYourAnswerPage.get2015RetirementReasonText())
				.matches("Early payment of deferred benefits because of ill health");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2015LumpsumChoice()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2015LumpsumChoice()).matches(
				"Do you want to give up part of your 2015 Section pension to receive a lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get2015LumpsumChoiceText()).matches("No");

	}

	@And("^the correct 1995 and 2008 pension details will be displayed$")
	public void theCorrect1995And2008PensionDetailsWillBeDisplayed() {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOfWhichScheme()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichScheme())
				.matches("Which Section or Scheme are you claiming benefits from");
		assertThat(pensionDetails_CheckYourAnswerPage.getWhichSchemeText()).matches("1995\n2008");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995Section()).matches("1995 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995RetirementReason()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995Retirementreason())
				.matches("Why are you claiming your deferred benefits for the 1995 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995RetirementReasonText())
				.matches(SharedData.shared1995RadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995EarlyPaymentDate()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995EarlyPaymentDate())
				.matches("When should the early payment of deferred benefit start");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995EarlyPaymentDateText())
				.matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995LumpsumChoice()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoice()).matches(
				"You are already entitled to a lump sum. Do you want to increase your lump sum by giving up part of your 1995 pension");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoiceText()).matches(SharedData.sharedRadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf1995LumpsumPref()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumPref()).matches("How would you like your lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumPrefText())
				.matches(SharedData.sharedNHSRadioButton + "\n" + "£1440");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008Section()).matches("2008 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2008RetirementReason()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2008RetirementReason())
				.matches("Why are you claiming your deferred benefits for the 2008 Section");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008RetirementReasonText())
				.matches("Retirement based on your age");
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2008LumpsumChoice()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumChoice()).matches(
				"Do you want to give up part of your 2008 Section pension to receive a lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumChoiceText()).matches(SharedData.sharedRadioButton);
		assertThat(pensionDetails_CheckYourAnswerPage.getPresenceOf2008LumpsumPref()).isEqualTo(true);
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumPref()).matches("How would you like your lump sum");
		assertThat(pensionDetails_CheckYourAnswerPage.get2008LumpsumPrefText()).matches("Maximum tax-free amount");
	}

	@And("^I navigate from whichScheme page to 2008 interstitial page$")
	public void InavigateFromWhichSchemePageTo2008InterstitialPage() {
		retirementReason1995Steps = new RetirementReason_1995StepDefs();
		retirementReason1995Steps.the1995ReasonForRetirementPageWillBeDisplayed();
		retirementReason1995Steps.iClickNextOn1995RetirementReasonPage();
		sharedEarlyPaymentSteps = new SharedEarlyPaymentStepDefs();
		sharedEarlyPaymentSteps.theEarlyPaymentDatePageWillBeDisplayed();
		sharedEarlyPaymentSteps.iClickNextOnEarlyPaymentDatePage();
		lumpsumChoice1995Steps = new LumpSumChoice_1995StepDefs();
		lumpsumChoice1995Steps.the1995LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps.iClickNextOn1995LumpsumChoicePage();
		lumpsumPref1995Steps = new LumpSumPreference_1995StepDefs();
		lumpsumPref1995Steps.iClickNextOn1995LumpsumPrefPage();
		interstitial2008Steps = new Interstitial2008StepDefs();
		interstitial2008Steps.the2008InterstitialPageWillBeDisplayed();

	}

	@And("^I navigate from reasonForRetirement page to check your answers page$")
	public void InavigateFromReasonForRetirementPageToCheckYourAnswersPage() {
		lumpsumChoice1995Steps = new LumpSumChoice_1995StepDefs();
		lumpsumChoice1995Steps.the1995LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps.iClickNextOn1995LumpsumChoicePage();
		lumpsumPref1995Steps = new LumpSumPreference_1995StepDefs();
		lumpsumPref1995Steps.iClickNextOn1995LumpsumPrefPage();

	}

	@And("^I navigate from earlyPaymentDate page to check your answers page$")
	public void InavigateFromEarlyPaymentDatePageToCheckYourAnswersPage() {
		lumpsumChoice1995Steps = new LumpSumChoice_1995StepDefs();
		lumpsumChoice1995Steps.the1995LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps.iClickNextOn1995LumpsumChoicePage();
		lumpsumPref1995Steps = new LumpSumPreference_1995StepDefs();
		lumpsumPref1995Steps.iClickNextOn1995LumpsumPrefPage();
	}

	@When("^I click change for (.*)$")
	public void iChangeCurrent(String field) {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "whichScheme":
			pensionDetails_CheckYourAnswerPage.changeWhichSchemeDetails();
			break;
		case "reasonForRetirement":
			pensionDetails_CheckYourAnswerPage.changeRetirementReasonDetails();
			break;
		case "earlyPaymentDate":
			pensionDetails_CheckYourAnswerPage.changeEarlyPaymentDateDetails();
			break;
		case "lumpSumChoice":
			pensionDetails_CheckYourAnswerPage.changeLumpsumChoiceDetails();
			break;
		case "lumpSumPreference":
			pensionDetails_CheckYourAnswerPage.changeLumpsumPrefDetails();
			break;

		}
	}

	@When("^I submit the pension scheme details$")
	public void iSubmitThePensionSchemeDetails() {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		pensionDetails_CheckYourAnswerPage.submitPensionDetails();
	}

	@And("^the updated pension details for (.*) will be displayed$")
	public void theUpdatedCurrentDetailsWillBeDisplayed(String field) {
		pensionDetails_CheckYourAnswerPage = new PensionDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "whichScheme":
			assertThat(pensionDetails_CheckYourAnswerPage.getWhichSchemeText()).matches("1995\n2008");
			break;
		case "reasonForRetirement":
			assertThat(pensionDetails_CheckYourAnswerPage.get1995RetirementReasonText())
					.matches(SharedData.shared1995RadioButton);
			break;
		case "earlyPaymentDate":
			assertThat(pensionDetails_CheckYourAnswerPage.get1995EarlyPaymentDateText())
					.matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
			break;
		case "lumpsumChoice":
			assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumChoiceText()).matches(SharedData.sharedRadioButton);
			break;
		case "lumpSumPreference":
			assertThat(pensionDetails_CheckYourAnswerPage.get1995LumpsumPrefText())
					.matches(SharedData.sharedNHSRadioButton);
			break;
		}
	}

}
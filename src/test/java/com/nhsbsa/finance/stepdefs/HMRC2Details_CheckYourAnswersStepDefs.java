package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.HMRC2Details_CheckYourAnswerPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HMRC2Details_CheckYourAnswersStepDefs {

	private WebDriver driver = Config.getDriver();

	private HMRC2Details_CheckYourAnswerPage hMRC2Details_CheckYourAnswerPage;
	private StartPageStepdefs startSteps;
	private OtherPensionArrangementsStepDefs otherPensionSteps;
	private LifetimeAllowanceStepDefs lifetimeAllowanceSteps;
	private SharedYeNoStepDefs sharedYesNoSteps;

	@Given("^I have filled in the hmrc details$")
	public void iHaveFilledInTheHmrcDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		otherPensionSteps = new OtherPensionArrangementsStepDefs();
		otherPensionSteps.iGoToOtherPensionArrangementsPage();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectNo();
		lifetimeAllowanceSteps = new LifetimeAllowanceStepDefs();
		lifetimeAllowanceSteps.theLifetimeAllowancePageWillBeDisplayed();
		lifetimeAllowanceSteps.iSelectYesOnLifetimeAllowancePage();
		lifetimeAllowanceSteps.IenterTheValidCertificateNumber();

	}
	
	@Given("^I have filled in the hmrc details for summary page$")
	public void iHaveFilledInTheHmrcDetailsForSummaryPage() throws Throwable {
		otherPensionSteps = new OtherPensionArrangementsStepDefs();
		otherPensionSteps.doYouHaveAnyOtherPensionArrangementsPageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectNo();
		lifetimeAllowanceSteps = new LifetimeAllowanceStepDefs();
		lifetimeAllowanceSteps.theLifetimeAllowancePageWillBeDisplayed();
		lifetimeAllowanceSteps.iSelectYesOnLifetimeAllowancePage();
		lifetimeAllowanceSteps.IenterTheValidCertificateNumber();

	}


	@Then("^Check your answers page for hmrc details will be displayed$")
	public void checkYourAnswersPageForHmrcDetailsWillBeDisplayed() {
		hMRC2Details_CheckYourAnswerPage = new HMRC2Details_CheckYourAnswerPage(driver);
		assertThat(hMRC2Details_CheckYourAnswerPage.getHeading()).contains("Check your answers");
	}

	@Then("^the correct hmrc details will be displayed$")
	public void theCorrectHmrcDetailsWillBeDisplayed() {
		hMRC2Details_CheckYourAnswerPage = new HMRC2Details_CheckYourAnswerPage(driver);
		assertThat(hMRC2Details_CheckYourAnswerPage.getPresenceOfOtherPension()).isEqualTo(true);
		assertThat(hMRC2Details_CheckYourAnswerPage.getOtherPensions())
				.matches("Do you have any additional pension arrangements");
		assertThat(hMRC2Details_CheckYourAnswerPage.getOtherPensionsText()).matches(SharedData.sharedRadioButton);
		assertThat(hMRC2Details_CheckYourAnswerPage.getPresenceOfLifetimeAllowance()).isEqualTo(true);
		assertThat(hMRC2Details_CheckYourAnswerPage.getLifetimeAllowance())
				.matches("Do you have HMRC Lifetime Allowance protection");
		assertThat(hMRC2Details_CheckYourAnswerPage.getLifetimeAllowanceText())
				.matches(SharedData.sharedNHSRadioButton);
		assertThat(hMRC2Details_CheckYourAnswerPage.getPresenceOfCertificateNumber()).isEqualTo(true);
		assertThat(hMRC2Details_CheckYourAnswerPage.getCertificateNumber()).matches("Certificate number");
		assertThat(hMRC2Details_CheckYourAnswerPage.getCertificateNumberText()).matches(SharedData.certNumber);
	}

	@And("^the updated (.*) value will be displayed$")
	public void theUpdatedValueWillBeDisplayed(String field) {
		hMRC2Details_CheckYourAnswerPage = new HMRC2Details_CheckYourAnswerPage(driver);
		switch (field) {
		case "lifetimeAllowance":
			assertThat(hMRC2Details_CheckYourAnswerPage.getLifetimeAllowanceText())
					.matches(SharedData.sharedNHSRadioButton);
			break;
		case "certificateNumber":
			assertThat(hMRC2Details_CheckYourAnswerPage.getCertificateNumberText()).matches(SharedData.certNumber);
			break;

		}
	}

	@Then("^the correct hmrc details with lifetimeAllowance will be displayed$")
	public void theCorrectHmrcDetailsWithLifetimeallowanceWillBeDisplayed() {
		hMRC2Details_CheckYourAnswerPage = new HMRC2Details_CheckYourAnswerPage(driver);
		assertThat(hMRC2Details_CheckYourAnswerPage.getPresenceOfOtherPension()).isEqualTo(true);
		assertThat(hMRC2Details_CheckYourAnswerPage.getOtherPensions())
				.matches("Do you have any additional pension arrangements");
		assertThat(hMRC2Details_CheckYourAnswerPage.getOtherPensionsText()).matches(SharedData.sharedRadioButton);
		assertThat(hMRC2Details_CheckYourAnswerPage.getPresenceOfLifetimeAllowance()).isEqualTo(true);
		assertThat(hMRC2Details_CheckYourAnswerPage.getLifetimeAllowance())
				.matches("Do you have HMRC Lifetime Allowance protection");
		assertThat(hMRC2Details_CheckYourAnswerPage.getLifetimeAllowanceText())
				.matches(SharedData.sharedNHSRadioButton);

	}

	@When("^I click change on (.*)$")
	public void iClickOnChangeOn(String field) {
		hMRC2Details_CheckYourAnswerPage = new HMRC2Details_CheckYourAnswerPage(driver);
		switch (field) {
		case "additionalPensionArrangement":
			hMRC2Details_CheckYourAnswerPage.changeOtherPensionsDetails();
			break;
		case "lifeTimeAllowance":
			hMRC2Details_CheckYourAnswerPage.changeLifetimeAllowance();
			break;
		case "certificateNumber":
			hMRC2Details_CheckYourAnswerPage.changeCertificateNumber();
			break;

		}
	}

	@When("^I submit the hmrc details$")
	public void iSubmitTheHmrcDetails() {
		hMRC2Details_CheckYourAnswerPage = new HMRC2Details_CheckYourAnswerPage(driver);
		hMRC2Details_CheckYourAnswerPage.submitHMRC2Details();
	}
}
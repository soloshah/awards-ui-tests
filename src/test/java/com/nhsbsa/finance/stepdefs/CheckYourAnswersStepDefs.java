package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.CheckYourAnswerPage;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckYourAnswersStepDefs {

	private WebDriver driver = Config.getDriver();
	private CheckYourAnswerPage checkYourAnswerPage;

	@Then("^Check your answers page will be displayed$")
	public void checkYourAnswersPageWillBeDisplayed() {
		checkYourAnswerPage = new CheckYourAnswerPage(driver);
		assertThat(checkYourAnswerPage.getHeading()).contains("Check your answers");
	}

	@When("^I click on change (.*)$")
	public void iClickOnChange(String field) {
		checkYourAnswerPage = new CheckYourAnswerPage(driver);
		switch (field) {
		case "currentEmployerName":
			checkYourAnswerPage.changeLink("currentNhsEmployer");
			break;
		case "currentEmployerAddress":
			checkYourAnswerPage.changeLink("whatIsYourEmployerAddress");
			break;
		case "currentLastDay":
			checkYourAnswerPage.changeLink("lastDayOfWorkWillBe");
			break;
		case "currentIntendToWork":
			checkYourAnswerPage.changeLink("doYouIntend");
			break;
		case "currentReturnDate":
			checkYourAnswerPage.clickChange("doYouIntend.label");
			break;
		case "lastEmployerName":
			checkYourAnswerPage.changeLink("lastNhsEmployer");
			break;
		case "lastJobTitle":
			checkYourAnswerPage.changeLink("jobTitle");
			break;
		case "lastLeavingDate":
			checkYourAnswerPage.changeLink("lastEmploymentDate");
			break;
		case "workingForNHS":
			checkYourAnswerPage.changeLink("workingNhs");
			break;
		case "maritalStatus":
			checkYourAnswerPage.changeLink("maritalStatus");
			break;
		case "partnerName":
			checkYourAnswerPage.changeLink("whatIsYourPartnerName");
			break;
		case "partnerDob":
			checkYourAnswerPage.changeLink("whatIsYourPartnerDob");
			break;
		case "partnerGender":
			checkYourAnswerPage.changeLink("partnerGender.static");
			break;
		case "partnerNino":
			checkYourAnswerPage.changeLink("whatIsYourPartnerNino.static");
			break;
		case "dependantChildren":
			checkYourAnswerPage.changeLink("anyDependantChildren");
			break;
		case "allocationPension":
			checkYourAnswerPage.changeLink("doYouWantToAllocatePension");
			break;
		case "allocationPensionName":
			checkYourAnswerPage.changeLink("whatIsAllocationName");
			break;
		case "allocationDob":
			checkYourAnswerPage.changeLink("whatIsAllocationDOB.static");
			break;
		case "allocationRelationship":
			checkYourAnswerPage.changeLink("whatIsAllocationRelationship.static");
			break;
		case "telephoneNumber":
			checkYourAnswerPage.clickChange("contactDetails.checkYourAnswers.phone");
			break;
		case "emailAddress":
			checkYourAnswerPage.clickChange("contactDetails.checkYourAnswers.email");
			break;
		case "WouldYouLikeToBeContacted":
			checkYourAnswerPage.clickChange("contactDetails.checkYourAnswers.contactPref");
			break;
		case "additionalPensionArrangement":
			checkYourAnswerPage.changeLink("otherPensionArrangements");
			break;
		case "lifeTimeAllowance":
			checkYourAnswerPage.changeLink("lifetimeAllowance");
			break;
		case "certificateNumber":
			checkYourAnswerPage.clickChange("lifetimeAllowance.cert");
			break;
		case "otherPensionBenefits":
			checkYourAnswerPage.clickChange("pensionOver30k.heading.cya");
			break;
		case "combinedLTA":
			checkYourAnswerPage.clickChange("separateBenefits.ltaPercent");
			break;
		case "benefitCrysallisationDate":
			checkYourAnswerPage.clickChange("separateBenefits.date");
			break;
		case "grossAnnualrate":
			checkYourAnswerPage.clickChange("separateBenefits.gross");
			break;
		case "separateBenefit":
			checkYourAnswerPage.clickChange("separateBenefits.noInformation");
			break;
		case "excessBenefit":
			checkYourAnswerPage.clickChange("treatBenefitsInExcessOfLTA");
			break;
		case "name":
			checkYourAnswerPage.clickChange("personalDetails.checkYourAnswers.fullname");
			break;
		case "dob":
			checkYourAnswerPage.clickChange("personalDetails.checkYourAnswers.dob");
			break;
		case "gender":
			checkYourAnswerPage.clickChange("personalDetails.checkYourAnswers.gender");
			break;
		case "address":
			checkYourAnswerPage.clickChange("personalDetails.checkYourAnswers.address");
			break;
		case "nino":
			checkYourAnswerPage.clickChange("personalDetails.checkYourAnswers.ni");
			break;
		case "whichScheme":
			checkYourAnswerPage.clickChange("pensionSchemeDetails.checkYourAnswers.scheme");
			break;
		case "reasonForRetirement":
			checkYourAnswerPage.clickChange("pensionSchemeDetails.checkYourAnswers.1995RetirementReason");
			break;
		case "earlyPaymentDate":
			checkYourAnswerPage.clickChange("pensionSchemeDetails.checkYourAnswers.1995EarlyPaymentDate");
			break;
		case "lumpSumChoice":
			checkYourAnswerPage.clickChange("pensionSchemeDetails.checkYourAnswers.1995lumpSumChoice");
			break;
		case "lumpSumPreference":
			checkYourAnswerPage.clickChange("pensionSchemeDetails.checkYourAnswers.lumpSum1995pref");
			break;
		case "accountType":
			checkYourAnswerPage.clickChange("paymentDetails.checkYourAnswers.accountType");
			break;
		case "accountHolderName":
			checkYourAnswerPage.clickChange("paymentDetails.checkYourAnswers.accountName");
			break;
		case "accountNumber":
			checkYourAnswerPage.clickChange("paymentDetails.checkYourAnswers.accountNumber");
			break;
		case "rollNumber":
			checkYourAnswerPage.clickChange("paymentDetails.checkYourAnswers.rollNumber");
			break;
		case "sortCode":
			checkYourAnswerPage.clickChange("paymentDetails.checkYourAnswers.sortCode");
			break;
		case "otherEqPensions":
			checkYourAnswerPage.clickChange("paymentDetails.checkYourAnswers.eqOther");
			break;
		case "eqPaymasterName":
			checkYourAnswerPage.clickChange("paymentDetails.checkYourAnswers.eqName");
			break;
		case "eqPaymasterReference":
			checkYourAnswerPage.clickChange("paymentDetails.checkYourAnswers.eqRef.static");
			break;
		}
	}

	@When("^I submit all details$")
	public void iSubmitAllDetails() {
		checkYourAnswerPage = new CheckYourAnswerPage(driver);
		checkYourAnswerPage.submitDetails();
	}

}
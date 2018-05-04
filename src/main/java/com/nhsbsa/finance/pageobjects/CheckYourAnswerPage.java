package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
/*	private By afterApril6ChangeLinkLocator =  By.id("separateBenefits.onOrAfter-change");
	private By beforeApril6ChangeLinkLocator = By.id("separateBenefits.before-change");
	private By fullNameChangeLinkLocator = By.id("personalDetails.checkYourAnswers.fullname-change");
	private By dobChangeLinkLocator = By.id("personalDetails.checkYourAnswers.dob-change");
	private By genderChangeLinkLocator = By.id("personalDetails.checkYourAnswers.gender-change");
	private By addressChangeLinkLocator = By.id("personalDetails.checkYourAnswers.address-change");
	private By ninoChangeLinkLocator = By.id("personalDetails.checkYourAnswers.ni-change");
	private By whichSchemeChangeLinkLocator = By.id("pensionSchemeDetails.checkYourAnswers.scheme-change");
	private By retirementReason1995ChangeLinkLocator = By.id("pensionSchemeDetails.checkYourAnswers.1995RetirementReason-change");
	private By earlyPaymentDate1995ChangeLinkLocator = By.id("pensionSchemeDetails.checkYourAnswers.1995EarlyPaymentDate-change");
	private By lumpsumChoice1995ChangeLinkLocator = By.id("pensionSchemeDetails.checkYourAnswers.1995lumpSumChoice-change");
	private By lumpsumPreference1995ChangeLinkLocator = By.id("pensionSchemeDetails.checkYourAnswers.lumpSum1995pref-change");
	private By accountTypeChangeLinkLocator = By.id("paymentDetails.checkYourAnswers.accountType-change");
	private By accountHolderNameChangeLinkLocator = By.id("paymentDetails.checkYourAnswers.accountName-change");
	private By accountNumberChangeLinkLocator = By.id("paymentDetails.checkYourAnswers.accountNumber-change");
	private By rollNumberChangeLinkLocator = By.id("paymentDetails.checkYourAnswers.rollNumber-change");
	private By sortCodeChangeLinkLocator = By.id("paymentDetails.checkYourAnswers.sortCode-change");
	private By otherEqPensionChangeLinkLocator = By.id("paymentDetails.checkYourAnswers.eqOther-change");
	private By eqPaymasterNameChangeLinkLocator = By.id("paymentDetails.checkYourAnswers.eqName-change");
	private By eqPaymasterRefChangeLinkLocator = By.id("paymentDetails.checkYourAnswers.eqRef.static-change");*/
	private By continueButtonLocator = By.id("continue_button");

	public CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(checkYouAnswersPageTitle);
		waitForElementToBeVisibleBy(continueButtonLocator);
	}

	private By getChangeLinkLocator(String page) {
		return By.id(page + ".heading-change");
	}

	public Page changeLink(String page) {
		navigateToRootElement();
		navigateToElementBy(getChangeLinkLocator(page));
		click();
		return new Page(driver);
	}
	
	private By getChangeLink(String page) {
		return By.id(page + "-change");
	}

	public Page clickChange(String page) {
		navigateToRootElement();
		navigateToElementBy(getChangeLink(page));
		click();
		return new Page(driver);
	}

	public SummaryPage submitDetails() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
		return new SummaryPage(driver);
	}
}

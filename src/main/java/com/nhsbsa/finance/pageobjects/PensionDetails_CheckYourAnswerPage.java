package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PensionDetails_CheckYourAnswerPage extends Page {

	private By whichSchemeFieldLocator = By.id("pensionSchemeDetails.checkYourAnswers.scheme");
	private By section1995Locator = By.xpath("//*[@id='review-pension-1995-details-table']/thead/tr/th");
	private By section2008Locator = By.xpath("//*[@id='review-pension-2008-details-table']/thead/tr/th");
	private By section2015Locator = By.xpath("//*[@id='review-pension-2015-details-table']/thead/tr/th");
	private By reasonForRetirement1995FieldLocator = By
			.id("pensionSchemeDetails.checkYourAnswers.1995RetirementReason");
	private By earlyPaymentDate1995FieldLocator = By.id("pensionSchemeDetails.checkYourAnswers.1995EarlyPaymentDate");
	private By lumpsumChoice1995FieldLocator = By.id("pensionSchemeDetails.checkYourAnswers.1995lumpSumChoice");
	private By lumpsumPreference1995FieldLocator = By.id("pensionSchemeDetails.checkYourAnswers.lumpSum1995pref");
	private By reasonForRetirement2008FieldLocator = By
			.id("pensionSchemeDetails.checkYourAnswers.2008RetirementReason");
	private By lumpsumChoice2008FieldLocator = By.id("pensionSchemeDetails.checkYourAnswers.2008lumpSumChoice");
	private By lumpsumPreference2008FieldLocator = By.id("pensionSchemeDetails.checkYourAnswers.lumpSum2008pref");
	private By reasonForRetirement2015FieldLocator = By
			.id("pensionSchemeDetails.checkYourAnswers.2015RetirementReason");
	private By lumpsumChoice2015FieldLocator = By.id("pensionSchemeDetails.checkYourAnswers.2015lumpSumChoice");
	private By lumpsumPreference2015FieldLocator = By.id("pensionSchemeDetails.checkYourAnswers.lumpSum2015pref");
	private By whichSchemeTextLocator = By.id("pensionSchemeDetails.checkYourAnswers.scheme-answer");
	private By retirementReason1995TextLocator = By
			.id("pensionSchemeDetails.checkYourAnswers.1995RetirementReason-answer");
	private By earlyPaymentDate1995TextLocator = By
			.id("pensionSchemeDetails.checkYourAnswers.1995EarlyPaymentDate-answer");
	private By lumpsumChoice1995TextLocator = By.id("pensionSchemeDetails.checkYourAnswers.1995lumpSumChoice-answer");
	private By lumpsumPreference1995TextLocator = By.id("pensionSchemeDetails.checkYourAnswers.lumpSum1995pref-answer");
	private By retirementReason2008TextLocator = By
			.id("pensionSchemeDetails.checkYourAnswers.2008RetirementReason-answer");
	private By lumpsumChoice2008TextLocator = By.id("pensionSchemeDetails.checkYourAnswers.2008lumpSumChoice-answer");
	private By lumpsumPreference2008TextLocator = By.id("pensionSchemeDetails.checkYourAnswers.lumpSum2008pref-answer");
	private By retirementReason2015TextLocator = By
			.id("pensionSchemeDetails.checkYourAnswers.2015RetirementReason-answer");
	private By lumpsumChoice2015TextLocator = By.id("pensionSchemeDetails.checkYourAnswers.2015lumpSumChoice-answer");
	private By lumpsumPreference2015TextLocator = By.id("pensionSchemeDetails.checkYourAnswers.lumpSum2015pref-answer");

	public PensionDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForElementToBeVisibleBy(whichSchemeFieldLocator);
	}

	public boolean getPresenceOfWhichScheme() {
		navigateToRootElement();
		return getPresenceOfElement(whichSchemeFieldLocator);
	}

	public boolean getPresenceOf1995RetirementReason() {
		navigateToRootElement();
		return getPresenceOfElement(reasonForRetirement1995FieldLocator);
	}

	public boolean getPresenceOf2008RetirementReason() {
		navigateToRootElement();
		return getPresenceOfElement(reasonForRetirement2008FieldLocator);
	}

	public boolean getPresenceOf2015RetirementReason() {
		navigateToRootElement();
		return getPresenceOfElement(reasonForRetirement2015FieldLocator);
	}

	public boolean getPresenceOf1995LumpsumChoice() {
		navigateToRootElement();
		return getPresenceOfElement(lumpsumChoice1995FieldLocator);
	}

	public boolean getPresenceOf2008LumpsumChoice() {
		navigateToRootElement();
		return getPresenceOfElement(lumpsumChoice2008FieldLocator);
	}

	public boolean getPresenceOf2015LumpsumChoice() {
		navigateToRootElement();
		return getPresenceOfElement(lumpsumChoice2015FieldLocator);
	}

	public boolean getPresenceOf1995LumpsumPref() {
		navigateToRootElement();
		return getPresenceOfElement(lumpsumPreference1995FieldLocator);
	}

	public boolean getPresenceOf2008LumpsumPref() {
		navigateToRootElement();
		return getPresenceOfElement(lumpsumPreference2008FieldLocator);
	}

	public boolean getPresenceOf2015LumpsumPref() {
		navigateToRootElement();
		return getPresenceOfElement(lumpsumPreference2015FieldLocator);
	}

	public boolean getPresenceOf1995EarlyPaymentDate() {
		navigateToRootElement();
		return getPresenceOfElement(earlyPaymentDate1995FieldLocator);
	}

	public String getWhichScheme() {
		navigateToRootElement();
		navigateToElementBy(whichSchemeFieldLocator);
		return getElementText();
	}

	public String get1995EarlyPaymentDate() {
		navigateToRootElement();
		navigateToElementBy(earlyPaymentDate1995FieldLocator);
		return getElementText();
	}

	public String get1995Retirementreason() {
		navigateToRootElement();
		navigateToElementBy(reasonForRetirement1995FieldLocator);
		return getElementText();
	}

	public String get1995LumpsumChoice() {
		navigateToRootElement();
		navigateToElementBy(lumpsumChoice1995FieldLocator);
		return getElementText();
	}

	public String get1995LumpsumPref() {
		navigateToRootElement();
		navigateToElementBy(lumpsumPreference1995FieldLocator);
		return getElementText();
	}

	public String get2008RetirementReason() {
		navigateToRootElement();
		navigateToElementBy(reasonForRetirement2008FieldLocator);
		return getElementText();
	}

	public String get2008LumpsumChoice() {
		navigateToRootElement();
		navigateToElementBy(lumpsumChoice2008FieldLocator);
		return getElementText();
	}

	public String get2008LumpsumPref() {
		navigateToRootElement();
		navigateToElementBy(lumpsumPreference2008FieldLocator);
		return getElementText();
	}

	public String get2015RetirementReason() {
		navigateToRootElement();
		navigateToElementBy(reasonForRetirement2015FieldLocator);
		return getElementText();
	}

	public String get2015LumpsumChoice() {
		navigateToRootElement();
		navigateToElementBy(lumpsumChoice2015FieldLocator);
		return getElementText();
	}

	public String get2015LumpsumPref() {
		navigateToRootElement();
		navigateToElementBy(lumpsumPreference2015FieldLocator);
		return getElementText();
	}

	public String get1995Section() {
		navigateToRootElement();
		navigateToElementBy(section1995Locator);
		return getElementText();
	}

	public String get2008Section() {
		navigateToRootElement();
		navigateToElementBy(section2008Locator);
		return getElementText();
	}

	public String get2015Section() {
		navigateToRootElement();
		navigateToElementBy(section2015Locator);
		return getElementText();
	}

	public String getWhichSchemeText() {
		navigateToRootElement();
		navigateToElementBy(whichSchemeTextLocator);
		return getElementText();
	}

	public String get1995RetirementReasonText() {
		navigateToRootElement();
		navigateToElementBy(retirementReason1995TextLocator);
		return getElementText();
	}

	public String get1995EarlyPaymentDateText() {
		navigateToRootElement();
		navigateToElementBy(earlyPaymentDate1995TextLocator);
		return getElementText();
	}

	public String get1995LumpsumChoiceText() {
		navigateToRootElement();
		navigateToElementBy(lumpsumChoice1995TextLocator);
		return getElementText();
	}

	public String get1995LumpsumPrefText() {
		navigateToRootElement();
		navigateToElementBy(lumpsumPreference1995TextLocator);
		return getElementText();
	}

	public String get2008RetirementReasonText() {
		navigateToRootElement();
		navigateToElementBy(retirementReason2008TextLocator);
		return getElementText();
	}

	public String get2008LumpsumChoiceText() {
		navigateToRootElement();
		navigateToElementBy(lumpsumChoice2008TextLocator);
		return getElementText();
	}

	public String get2008LumpsumPrefText() {
		navigateToRootElement();
		navigateToElementBy(lumpsumPreference2008TextLocator);
		return getElementText();
	}

	public String get2015RetirementReasonText() {
		navigateToRootElement();
		navigateToElementBy(retirementReason2015TextLocator);
		return getElementText();
	}

	public String get2015LumpsumChoiceText() {
		navigateToRootElement();
		navigateToElementBy(lumpsumChoice2015TextLocator);
		return getElementText();
	}

	public String get2015LumpsumPrefText() {
		navigateToRootElement();
		navigateToElementBy(lumpsumPreference2015TextLocator);
		return getElementText();
	}

}

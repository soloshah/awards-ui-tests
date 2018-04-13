package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PensionDetails_CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
	private By whichSchemeFieldLocator = By.id("scheme.heading");
	private By section1995Locator = By.xpath("//*[@id='review-pension-1995-details-table']/thead/tr/th");
	private By section2008Locator = By.xpath("//*[@id='review-pension-2008-details-table']/thead/tr/th");
	private By section2015Locator = By.xpath("//*[@id='review-pension-2015-details-table']/thead/tr/th");
	private By reasonForRetirement1995FieldLocator = By.id("1995RetirementReason.heading");
	private By earlyPaymentDate1995FieldLocator = By.id("1995EarlyPaymentDate.heading");
	private By lumpsumChoice1995FieldLocator = By.id("1995lumpSumChoice.heading");
	private By lumpsumPreference1995FieldLocator = By.id("lumpSum1995.heading");
	private By reasonForRetirement2008FieldLocator = By.id("2008RetirementReason.heading");
	private By lumpsumChoice2008FieldLocator = By.id("2008lumpSumChoice.heading");
	private By lumpsumPreference2008FieldLocator = By.id("lumpSum2008.heading");
	private By reasonForRetirement2015FieldLocator = By.id("2015RetirementReason.heading");
	private By lumpsumChoice2015FieldLocator = By.id("2015lumpSumChoice.heading");
	private By lumpsumPreference2015FieldLocator = By.id("lumpSum2015.heading");
	private By continueButtonLocator = By.id("continue_button");
	private By whichSchemeChangeLinkLocator = By.id("scheme.heading-chgit snge");
	private By retirementReason1995ChangeLinkLocator = By.id("1995RetirementReason.heading-chgit snge");
	private By earlyPaymentDate1995ChangeLinkLocator = By.id("1995EarlyPaymentDate.heading-chgit snge");
	private By lumpsumChoice1995ChangeLinkLocator = By.id("1995lumpSumChoice.heading-chgit snge");
	private By lumpsumPreference1995ChangeLinkLocator = By.id("lumpSum1995.heading-chgit snge");
	private By whichSchemeTextLocator = By.id("scheme.heading-answer");
	private By retirementReason1995TextLocator = By.id("1995RetirementReason.heading-answer");
	private By earlyPaymentDate1995TextLocator = By.id("1995EarlyPaymentDate.heading-answer");
	private By lumpsumChoice1995TextLocator = By.id("1995lumpSumChoice.heading-answer");
	private By lumpsumPreference1995TextLocator = By.id("lumpSum1995.heading-answer");
	private By retirementReason2008TextLocator = By.id("2008RetirementReason.heading-answer");
	private By lumpsumChoice2008TextLocator = By.id("2008lumpSumChoice.heading-answer");
	private By lumpsumPreference2008TextLocator = By.id("lumpSum2008.heading-answer");
	private By retirementReason2015TextLocator = By.id("2015RetirementReason.heading-answer");
	private By lumpsumChoice2015TextLocator = By.id("2015lumpSumChoice.heading-answer");
	private By lumpsumPreference2015TextLocator = By.id("lumpSum2015.heading-answer");
	

	public PensionDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(checkYouAnswersPageTitle);
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
	private void changeWhichSchemeLink() {
		navigateToRootElement();
		navigateToElementBy(whichSchemeChangeLinkLocator);
		click();
	}

	public WhichSchemePage changeWhichSchemeDetails() {
		changeWhichSchemeLink();
		return new WhichSchemePage(driver);
	}

	private void changeRetirementReasonLink() {
		navigateToRootElement();
		navigateToElementBy(retirementReason1995ChangeLinkLocator);
		click();
	}

	public ReasonForRetirement_1995Page changeRetirementReasonDetails() {
		changeRetirementReasonLink();
		return new ReasonForRetirement_1995Page(driver);
	}

	private void changeLumpsumChoiceLink() {
		navigateToRootElement();
		navigateToElementBy(lumpsumChoice1995ChangeLinkLocator);
		click();
	}

	public LumpSumChoice_1995Page changeLumpsumChoiceDetails() {
		changeLumpsumChoiceLink();
		return new LumpSumChoice_1995Page(driver);
	}

	private void changeLumpsumPrefLink() {
		navigateToRootElement();
		navigateToElementBy(lumpsumPreference1995ChangeLinkLocator);
		click();
	}

	public LumpSumPreference_1995Page changeLumpsumPrefDetails() {
		changeLumpsumPrefLink();
		return new LumpSumPreference_1995Page(driver);
	}

	private void changeEarlyPaymentDateLink() {
		navigateToRootElement();
		navigateToElementBy(earlyPaymentDate1995ChangeLinkLocator);
		click();
	}

	public SharedEarlyPaymentPage changeEarlyPaymentDateDetails() {
		changeEarlyPaymentDateLink();
		return new SharedEarlyPaymentPage(driver);
	}
	
	public SummaryPage submitPensionDetails() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
		return new SummaryPage(driver);
	}
}

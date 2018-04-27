package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HMRCDetails_CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
	private By otherPensionArrangementsFieldLocator = By.id("otherPensionArrangements.heading");
	private By pensionOver30kFieldLocator = By.id("pensionOver30k.heading.cya");
	private By afterApril6FieldLocator = By.id("separateBenefits.onOrAfter");
	private By combinedLTAFieldLocator = By.id("separateBenefits.ltaPercent");
	private By benefitCrystallisationDateFieldLocator = By.id("separateBenefits.date");
	private By beforeApril6FieldLocator = By.id("separateBenefits.before");
	private By grossAnnualRateFieldLocator = By.id("separateBenefits.gross");
	private By separateBenefitsNoInformationFieldLocator = By.id("separateBenefits.noInformation");
	private By separateNoBenefitsFieldLocator = By.id("separateBenefits.nobenefits");
	private By excessLTAFieldLocator= By.id("treatBenefitsInExcessOfLTA");
	private By lifetimeAllowanceFieldLocator = By.id("lifetimeAllowance.heading");
	private By continueButtonLocator = By.id("continue_button");
	private By pensionOver30KChangeLinkLocator = By.id("pensionOver30k.heading.cya-change");
	private By afterApril6ChangeLinkLocator =  By.id("separateBenefits.onOrAfter-change");
	private By combinedLTAChangeLinkLocator = By.id("separateBenefits.ltaPercent-change");
	private By benefitCrystallisationDateChangeLinkLocator = By.id("separateBenefits.date-change");
	private By beforeApril6ChangeLinkLocator = By.id("separateBenefits.before-change");
	private By grossAnnualRateChangeLinkLocator = By.id("separateBenefits.gross-change");
	private By separatePensionBenefitsChangeLinkLocator = By.id("separateBenefits.noInformation-change");
	private By excessLTAChangeLinkLocator = By.id("treatBenefitsInExcessOfLTA-change");
	private By otherPensionArrangementsTextLocator = By.id("otherPensionArrangements.heading-answer");
	private By pensionOver30kTextLocator = By.id("pensionOver30k.heading.cya-answer");
	private By afterApril6TextLocator = By.id("separateBenefits.onOrAfter-answer");
	private By combinedLTATextLocator = By.id("separateBenefits.ltaPercent-answer");
	private By benefitCrystallisationDateTextLocator = By.id("separateBenefits.date-answer");
	private By beforeApril6TextLocator = By.id("separateBenefits.before-answer");
	private By grossAnnualRateTextLocator = By.id("separateBenefits.gross-answer");
	private By separatePensionBenefitsTextLocator = By.id("separateBenefits.noInformation-answer");
	private By separatePensionNoBenefitsTextLocator = By.id("separateBenefits.nobenefits-answer");
	private By excessLTATextLocator = By.id("treatBenefitsInExcessOfLTA-answer");
	private By lifetimeAllowanceTextLocator = By.id("lifetimeAllowance.heading-answer");


	public HMRCDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(checkYouAnswersPageTitle);
		waitForElementToBeVisibleBy(otherPensionArrangementsFieldLocator);
	}

	public boolean getPresenceOfOtherPension() {
		navigateToRootElement();
		return getPresenceOfElement(otherPensionArrangementsFieldLocator);
	}
	
	public boolean getPresenceOfPensionOver30k() {
		navigateToRootElement();
		return getPresenceOfElement(pensionOver30kFieldLocator);
	}
	
	public boolean getPresenceOfAfterApril6() {
		navigateToRootElement();
		return getPresenceOfElement(afterApril6FieldLocator);
	}
	
	public boolean getPresenceOfCombinedLTA() {
		navigateToRootElement();
		return getPresenceOfElement(combinedLTAFieldLocator);
	}
	
	public boolean getPresenceOfBenefitDate() {
		navigateToRootElement();
		return getPresenceOfElement(benefitCrystallisationDateFieldLocator);
	}
	
	public boolean getPresenceOfBeforeApril6() {
		navigateToRootElement();
		return getPresenceOfElement(beforeApril6FieldLocator);
	}
	
	public boolean getPresenceOfGrossAnnualRate() {
		navigateToRootElement();
		return getPresenceOfElement(grossAnnualRateFieldLocator);
	}
	
	public boolean getPresenceOfSeparateBenefitsNoInformation() {
		navigateToRootElement();
		return getPresenceOfElement(separateBenefitsNoInformationFieldLocator);
	}
	
	public boolean getPresenceOfSeparatePensionNobenefits() {
		navigateToRootElement();
		return getPresenceOfElement(separateNoBenefitsFieldLocator);
	}
	
	public boolean getPresenceOfExcessLTA() {
		navigateToRootElement();
		return getPresenceOfElement(excessLTAFieldLocator);
	}
	

	public boolean getPresenceOfLifetimeAllowance() {
		navigateToRootElement();
		return getPresenceOfElement(lifetimeAllowanceFieldLocator);
	}

	public String getOtherPensions() {
		navigateToRootElement();
		navigateToElementBy(otherPensionArrangementsFieldLocator);
		return getElementText();
	}
	
	public String getPensionOver30k() {
		navigateToRootElement();
		navigateToElementBy(pensionOver30kFieldLocator);
		return getElementText();
	}
	
	public String getAfterApril6() {
		navigateToRootElement();
		navigateToElementBy(afterApril6FieldLocator);
		return getElementText();
	}
	
	public String getCombinedLTA() {
		navigateToRootElement();
		navigateToElementBy(combinedLTAFieldLocator);
		return getElementText();
	}
	
	public String getBenefitDate() {
		navigateToRootElement();
		navigateToElementBy(benefitCrystallisationDateFieldLocator);
		return getElementText();
	}
	
	public String getBeforeApril6() {
		navigateToRootElement();
		navigateToElementBy(beforeApril6FieldLocator);
		return getElementText();
	}
	
	public String getGrossAnnualRate() {
		navigateToRootElement();
		navigateToElementBy(grossAnnualRateFieldLocator);
		return getElementText();
	}
	
	public String getSeparateBenefitsNoInformation() {
		navigateToRootElement();
		navigateToElementBy(separateBenefitsNoInformationFieldLocator);
		return getElementText();
	}
	
	public String getSeparatePensionNoBenefits() {
		navigateToRootElement();
		navigateToElementBy(separateNoBenefitsFieldLocator);
		return getElementText();
	}
	
	public String getExcessLTA() {
		navigateToRootElement();
		navigateToElementBy(excessLTAFieldLocator);
		return getElementText();
	}


	public String getLifetimeAllowance() {
		navigateToRootElement();
		navigateToElementBy(lifetimeAllowanceFieldLocator);
		return getElementText();
	}


	public String getOtherPensionsText() {
		navigateToRootElement();
		navigateToElementBy(otherPensionArrangementsTextLocator);
		return getElementText();
	}


	public String getPensionOver30kText() {
		navigateToRootElement();
		navigateToElementBy(pensionOver30kTextLocator);
		return getElementText();
	}

	public String getAfterApril6Text() {
		navigateToRootElement();
		navigateToElementBy(afterApril6TextLocator);
		return getElementText();
	}
	
	public String getCombinedLTAText() {
		navigateToRootElement();
		navigateToElementBy(combinedLTATextLocator);
		return getElementText();
	}
	
	
	public String getBenefitDateText() {
		navigateToRootElement();
		navigateToElementBy(benefitCrystallisationDateTextLocator);
		return getElementText();
	}
	
	public String getBeforeApril6Text() {
		navigateToRootElement();
		navigateToElementBy(beforeApril6TextLocator);
		return getElementText();
	}
	
	
	public String getGrossAnnualRateText() {
		navigateToRootElement();
		navigateToElementBy(grossAnnualRateTextLocator);
		return getElementText();
	}
	
	public String getSeparateBenefitsText() {
		navigateToRootElement();
		navigateToElementBy(separatePensionBenefitsTextLocator);
		return getElementText();
	}
	
	public String getSeparatePensionNoBenefitsText() {
		navigateToRootElement();
		navigateToElementBy(separatePensionNoBenefitsTextLocator);
		return getElementText();
	}
	
	
	
	public String getExcessLTAText() {
		navigateToRootElement();
		navigateToElementBy(excessLTATextLocator);
		return getElementText();
	}
	
	public String getLifetimeAllowanceText() {
		navigateToRootElement();
		navigateToElementBy(lifetimeAllowanceTextLocator);
		return getElementText();
	}


	
	
	public PensionOver30Page changePensionOver30K() {
		navigateToRootElement();
		navigateToElementBy(pensionOver30KChangeLinkLocator);
		click();
		return new PensionOver30Page(driver);
	}
	
	public SeparatePensionBenefitsPage changeAfterApril6() {
		navigateToRootElement();
		navigateToElementBy(afterApril6ChangeLinkLocator);
		click();
		return new SeparatePensionBenefitsPage(driver);
	}
	
	public SeparatePensionBenefitsPage changeCombinedLTA() {
		navigateToRootElement();
		navigateToElementBy(combinedLTAChangeLinkLocator);
		click();
		return new SeparatePensionBenefitsPage(driver);
	}
	
	public SeparatePensionBenefitsPage changeBenefitsDate() {
		navigateToRootElement();
		navigateToElementBy(benefitCrystallisationDateChangeLinkLocator);
		click();
		return new SeparatePensionBenefitsPage(driver);
	}
	
	public SeparatePensionBenefitsPage changeBeforeApril6() {
		navigateToRootElement();
		navigateToElementBy(beforeApril6ChangeLinkLocator);
		click();
		return new SeparatePensionBenefitsPage(driver);
	}
	
	public SeparatePensionBenefitsPage changeGrossAnnualRate() {
		navigateToRootElement();
		navigateToElementBy(grossAnnualRateChangeLinkLocator);
		click();
		return new SeparatePensionBenefitsPage(driver);
	}
	
	
	public SeparatePensionBenefitsPage changeSeparateBenefits() {
		navigateToRootElement();
		navigateToElementBy(separatePensionBenefitsChangeLinkLocator);
		click();
		return new SeparatePensionBenefitsPage(driver);
	}
	
	public TreatBenefitsPage changeExcessLTA() {
		navigateToRootElement();
		navigateToElementBy(excessLTAChangeLinkLocator);
		click();
		return new TreatBenefitsPage(driver);
	}
	
	
	
	public SummaryPage submitHMRCDetails() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
		return new SummaryPage(driver);
	}
}

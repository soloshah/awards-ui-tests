package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HMRC2Details_CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
	private By otherPensionArrangementsFieldLocator = By.id("otherPensionArrangements.heading");
	private By lifetimeAllowanceFieldLocator = By.id("lifetimeAllowance.heading");
	private By certificateNumberFieldLocator = By.id("lifetimeAllowance.cert");
	private By continueButtonLocator = By.id("continue_button");
	private By otherPensionArrangementsChangeLinkLocator = By.id("otherPensionArrangements.heading-chgit snge");
	private By lifetimeAllowanceChangeLinkLocator = By.id("lifetimeAllowance.heading-chgit snge");
	private By certificateNumberChangeLinkLocator = By.id("lifetimeAllowance.cert-chgit snge");
	private By otherPensionArrangementsTextLocator = By.id("otherPensionArrangements.heading-answer");
	private By lifetimeAllowanceTextLocator = By.id("lifetimeAllowance.heading-answer");
	private By certificateNumberTextLocator = By.id("lifetimeAllowance.cert-answer");

	public HMRC2Details_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(checkYouAnswersPageTitle);
		waitForElementToBeVisibleBy(otherPensionArrangementsFieldLocator);
	}

	public boolean getPresenceOfOtherPension() {
		navigateToRootElement();
		return getPresenceOfElement(otherPensionArrangementsFieldLocator);
	}

	public boolean getPresenceOfLifetimeAllowance() {
		navigateToRootElement();
		return getPresenceOfElement(lifetimeAllowanceFieldLocator);
	}

	public boolean getPresenceOfCertificateNumber() {
		navigateToRootElement();
		return getPresenceOfElement(certificateNumberFieldLocator);
	}

	public String getOtherPensions() {
		navigateToRootElement();
		navigateToElementBy(otherPensionArrangementsFieldLocator);
		return getElementText();
	}

	public String getLifetimeAllowance() {
		navigateToRootElement();
		navigateToElementBy(lifetimeAllowanceFieldLocator);
		return getElementText();
	}

	public String getCertificateNumber() {
		navigateToRootElement();
		navigateToElementBy(certificateNumberFieldLocator);
		return getElementText();
	}

	public String getOtherPensionsText() {
		navigateToRootElement();
		navigateToElementBy(otherPensionArrangementsTextLocator);
		return getElementText();
	}

	public String getLifetimeAllowanceText() {
		navigateToRootElement();
		navigateToElementBy(lifetimeAllowanceTextLocator);
		return getElementText();
	}

	public String getCertificateNumberText() {
		navigateToRootElement();
		navigateToElementBy(certificateNumberTextLocator);
		return getElementText();
	}

	private void changeOtherPensionLink() {
		navigateToRootElement();
		navigateToElementBy(otherPensionArrangementsChangeLinkLocator);
		click();
	}

	public OtherPensionArrangementsPage changeOtherPensionsDetails() {
		changeOtherPensionLink();
		return new OtherPensionArrangementsPage(driver);
	}

	private void changeLifetimeAllowanceLink() {
		navigateToRootElement();
		navigateToElementBy(lifetimeAllowanceChangeLinkLocator);
		click();
	}

	public LifetimeAllowancePage changeLifetimeAllowance() {
		changeLifetimeAllowanceLink();
		return new LifetimeAllowancePage(driver);
	}

	private void changeCertificateNumberLink() {
		navigateToRootElement();
		navigateToElementBy(certificateNumberChangeLinkLocator);
		click();
	}

	public LifetimeAllowancePage changeCertificateNumber() {
		changeCertificateNumberLink();
		return new LifetimeAllowancePage(driver);

	}

	public SummaryPage submitHMRC2Details() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
		return new SummaryPage(driver);
	}
}

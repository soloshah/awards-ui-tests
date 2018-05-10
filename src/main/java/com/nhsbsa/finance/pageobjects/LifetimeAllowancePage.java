package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LifetimeAllowancePage extends Page {
	
	private String lifetimeAllowanceTitle = "Do you have HMRC Lifetime Allowance protection? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.id("radio-yes");
	private By noRadioButtonLocator = By.id("radio-no");
	private By nextButtonLocator = By.id("submit_button");
	private By backButtonLocator = By.id("back-link");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By lifetimeAllowanceAnchoredErrorMessageLocator = By.id("error-list0");
	private By lifetimeAllowanceAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#yesNoValue']");
	private By lifetimeAllowanceFieldErrorMessageLocator = By.id("fieldName-error-message");
	private By certNumberAnchoredErrorMessageLocator = By.id("error-list1");
	private By certNumberAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#certRefNumber']");
	private By certNumberFieldErrorMessageLocator = By.id("certRefNumber-error-message");
	private By certNumberFieldLocator = By.id("certRefNumber");
	private By certNumberHeaderLocator = By.id("certRefNumber-label-text");
	private By selectedYesRadioButtonLocator = By.xpath("//input[@checked='checked']");
	private By selectedNoRadioButtonLocator = By.xpath("//input[@checked='checked']");

	public LifetimeAllowancePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(lifetimeAllowanceTitle);
		waitForElementToBeVisibleBy(backButtonLocator);
	}

	public void enterCertNumber(String certNumber) {
		navigateToRootElement();
		navigateToElementBy(certNumberFieldLocator);
		type(certNumber);
	}

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public String getCertNumberHeading() {
		navigateToRootElement();
		navigateToElementBy(certNumberHeaderLocator);
		return getElementText();
	}

	public String getErrorHeadingErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(errorHeadingErrorMessageLocator);
		return getElementText();
	}

	public String getErrorsBelowErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(errorsBelowErrorMessageLocator);
		return getElementText();
	}

	public String getLifetimeAllowanceFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lifetimeAllowanceFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesLifetimeAllowanceErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(lifetimeAllowanceAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(lifetimeAllowanceAnchoredErrorMessageAnchorLocator);
	}

	public String getLifetimeAllowanceAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lifetimeAllowanceAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getCertNumberFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(certNumberFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesCertNumberErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(certNumberAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(certNumberAnchoredErrorMessageAnchorLocator);
	}

	public String getCertNumberAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(certNumberAnchoredErrorMessageLocator);
		return getElementText();
	}

	public LifetimeAllowancePage lifetimeAllowanceIsNotSelected() {
		nextStep();
		return new LifetimeAllowancePage(driver);
	}
	
	public LifetimeAllowancePage selectYes() {
		navigateToRootElement();
		navigateToElementBy(yesRadioButtonLocator);
		click();
		return new LifetimeAllowancePage(driver);
	}

	public HMRC2Details_CheckYourAnswerPage submitValidCertNumber(String certNumber) {
		enterCertNumber(certNumber);
		nextStep();
		return new HMRC2Details_CheckYourAnswerPage(driver);
	}

	public LifetimeAllowancePage submitInValidCertNumber() {
		nextStep();
		return new LifetimeAllowancePage(driver);
	}

	public HMRC2Details_CheckYourAnswerPage selectNo() {
		navigateToRootElement();
		navigateToElementBy(noRadioButtonLocator);
		click();
		nextStep();
		return new HMRC2Details_CheckYourAnswerPage(driver);
	}

	public String getCertNumberValue() {
		navigateToRootElement();
		navigateToElementBy(certNumberFieldLocator);
		return getElementValue();
	}

	public String getYesRadioButton() {
		navigateToRootElement();
		navigateToElementBy(selectedYesRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}

	public String getNoRadioButton() {
		navigateToRootElement();
		navigateToElementBy(selectedNoRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}
	
}

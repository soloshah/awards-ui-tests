package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartnerNinoPage extends Page {

	//private String partnerNinoPageTitle = "What is your spouse's or civil partner's National Insurance number? - Claim your NHS Pension";
	private By ninoFieldLocator = By.id("nino");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By ninoFieldErrorMessageLocator = By.id("nino-error-message");
	private By ninoAnchoredErrorMessageLocator = By.id("error-list0");
	private By ninoAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#nino']");

	public PartnerNinoPage(WebDriver driver) {
		super(driver);
		//waitForTitleToExist(partnerNinoPageTitle);
		waitForElementToBeVisibleBy(ninoFieldLocator);
	}

	public void enterPartnerNino(String nino) {
		navigateToRootElement();
		navigateToElementBy(ninoFieldLocator);
		type(nino);
	}

	private void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
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

	public boolean doesNinoErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(ninoAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(ninoAnchoredErrorMessageAnchorLocator);
	}

	public String getNinoAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(ninoAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getNinoFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(ninoFieldErrorMessageLocator);
		return getElementText();
	}

	public DependantChildrenPage submitValidNiDetails(String nino) {
		enterPartnerNino(nino);
		nextStep();
		return new DependantChildrenPage(driver);
	}

	public PartnerNinoPage submitInValidNinoDetails() {
		nextStep();
		return new PartnerNinoPage(driver);
	}

}

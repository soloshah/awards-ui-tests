package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NinoPage extends Page {

	private String ninoPageTitle = "What is your National Insurance number? - Claim your NHS Pension - NHSBSA";
	private By ninoFieldLocator = By.id("nino");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By ninoFieldErrorMessageLocator = By.id("nino-error-message");
	private By ninoAnchoredErrorMessageLocator = By.id("error-list0");
	private By ninoAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#nino']");

	public NinoPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(ninoPageTitle);
		waitForElementToBeVisibleBy(ninoFieldLocator);
	}

	public void enterNino(String nino) {
		navigateToRootElement();
		navigateToElementBy(ninoFieldLocator);
		type(nino);
	}

	public void nextStep() {
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

	public PersonalDetails_CheckYourAnswerPage submitValidNinoDetails(String nino) {
		enterNino(nino);
		nextStep();
		return new PersonalDetails_CheckYourAnswerPage(driver);
	}

	public void submitValidNiDetails(String nino) {
		enterNino(nino);
		nextStep();
	
	}

	public String getNino() {
		navigateToRootElement();
		navigateToElementBy(ninoFieldLocator);
		return getElementValue();
	}

	public NinoPage submitInValidNinoDetails() {
		nextStep();
		return new NinoPage(driver);
	}

}

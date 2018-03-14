package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EqPaymasterNamePage extends Page {

	private String eqPaymasterNamePageTitle = "Give the name of the pension paid by Equiniti Paymaster - Claim your NHS Pension - NHSBSA";
	private By eqPaymasterNameFieldLocator = By.id("name");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By eqPaymasterNameFieldErrorMessageLocator = By.id("name-error-message");
	private By eqPaymasterNameAnchoredErrorMessageLocator = By.id("error-list0");
	private By eqPaymasterNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#name']");

	public EqPaymasterNamePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(eqPaymasterNamePageTitle);
		waitForElementToBeVisibleBy(eqPaymasterNameFieldLocator);
	}

	public void enterEqPaymasterName(String name) {
		navigateToRootElement();
		navigateToElementBy(eqPaymasterNameFieldLocator);
		type(name);
	}

	public void enterEqPaymasterNameDetails(String name) {
		enterEqPaymasterName(name);
		nextStep();
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

	public boolean doesEqPaymasterNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(eqPaymasterNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(eqPaymasterNameAnchoredErrorMessageAnchorLocator);
	}

	public String getEqPaymasterNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(eqPaymasterNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getEqPaymasterNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(eqPaymasterNameFieldErrorMessageLocator);
		return getElementText();
	}

	
	public TBIPage submitValidEqPaymasterName(String name) {
		enterEqPaymasterName(name);
		nextStep();
		return new TBIPage(driver);
	}

	public EqPaymasterNamePage submitInValidEqPaymasterNameDetails() {
		nextStep();
		return new EqPaymasterNamePage(driver);
	}

	public String readEqPaymasterNameField() {
		navigateToRootElement();
		navigateToElementBy(eqPaymasterNameFieldLocator);
		return getElementValue();
	}


	
}

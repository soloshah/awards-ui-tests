package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelephoneNumberPage extends Page {

	private String telephoneNumberPageTitle = "What is your email address? - Claim your NHS Pension";
	private By telephoneNumberFieldLocator = By.id("phoneNumber");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By telephoneNumberFieldErrorMessageLocator = By.id("phoneNumber-error-message");
	private By telephoneNumberAnchoredErrorMessageLocator = By.id("error-list0");
	private By telephoneNumberAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#phoneNumber']");

	public TelephoneNumberPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(telephoneNumberPageTitle);
		waitForElementToBeVisibleBy(telephoneNumberFieldLocator);
	}

	public void enterNumber(String number) {
		navigateToRootElement();
		navigateToElementBy(telephoneNumberFieldLocator);
		type(number);
	}

	public void enterTelephoneNumber(String number) {
		enterNumber(number);
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

	public boolean doesTelephoneErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(telephoneNumberAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(telephoneNumberAnchoredErrorMessageAnchorLocator);
	}

	public String getTelephoneAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(telephoneNumberAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getTelephoneFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(telephoneNumberFieldErrorMessageLocator);
		return getElementText();
	}

	
	public TBIPage submitValidTelephoneNumber(String number) {
		enterTelephoneNumber(number);
		return new TBIPage(driver);
	}

	public TelephoneNumberPage submitInValidTelephoneDetails() {
		nextStep();
		return new TelephoneNumberPage(driver);
	}


}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailAddressPage extends Page {

	private String emailAddressPageTitle = "What is your email address? - Claim your NHS Pension";
	private By emailAddressFieldLocator = By.id("email");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By emailAddressFieldErrorMessageLocator = By.id("email-error-message");
	private By emailAddressAnchoredErrorMessageLocator = By.id("error-list0");
	private By emailAddressAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#email']");

	public EmailAddressPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(emailAddressPageTitle);
		waitForElementToBeVisibleBy(emailAddressFieldLocator);
	}

	public void enterEmail(String email) {
		navigateToRootElement();
		navigateToElementBy(emailAddressFieldLocator);
		type(email);
	}

	public void enterEmailAddress(String email) {
		enterEmail(email);
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

	public boolean doesEmailErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(emailAddressAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(emailAddressAnchoredErrorMessageAnchorLocator);
	}

	public String getEmailAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(emailAddressAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getEmailFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(emailAddressFieldErrorMessageLocator);
		return getElementText();
	}

	public CheckYourAnswerPage submitValidEmailDetails(String email) {
		enterEmail(email);

		nextStep();
		return new CheckYourAnswerPage(driver);
	}

	public TBIPage submitValidEmailAddress(String email) {
		enterEmail(email);

		nextStep();
		return new TBIPage(driver);
	}

	public EmailAddressPage submitInValidEmailDetails() {
		nextStep();
		return new EmailAddressPage(driver);
	}

	public String readEmailField() {
		navigateToRootElement();
		navigateToElementBy(emailAddressFieldLocator);
		return getElementValue();
	}

	public SessionsExpiredPage submitValidJobtitleDetailsInExpiredSession(String email) {
		enterEmail(email);

		nextStep();
		return new SessionsExpiredPage(driver);
	}

	
}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartnerNamePage extends Page {

	private String partnerNamePageTitle = "What is your spouse's or civil partner's name? - Claim your NHS Pension";
	private By firstNameFieldLocator = By.id("firstName");
	private By lastNameFieldLocator = By.id("lastName");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By partnerFirstNameFieldErrorMessageLocator = By.id("firstName-error-message");
	private By partnerFirstNameAnchoredErrorMessageLocator = By.id("error-list0");
	private By partnerFirstNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#firstName']");
	private By partnerLastNameFieldErrorMessageLocator = By.id("lastName-error-message");
	private By partnerLastNameAnchoredErrorMessageLocator = By.id("error-list1");
	private By partnerLastNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#lastName']");

	public PartnerNamePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(partnerNamePageTitle);
		waitForElementToBeVisibleBy(firstNameFieldLocator);
	}

	public void enterfirstName(String firstName) {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldLocator);
		type(firstName);
	}

	public void getFirstName(String firstName) {
		navigateToRootElement();
		enterfirstName(firstName);

	}

	public void enterlastName(String lastName) {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldLocator);
		type(lastName);
	}

	public void enterPartnerNameDetails(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
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

	public boolean doesPartnerFirstNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(partnerFirstNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(partnerFirstNameAnchoredErrorMessageAnchorLocator);
	}

	public boolean doesPartnerLastNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(partnerLastNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(partnerLastNameAnchoredErrorMessageAnchorLocator);
	}

	public String getPartnerFirstNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(partnerFirstNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getPartnerLastNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(partnerLastNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getPartnerFirstNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(partnerFirstNameFieldErrorMessageLocator);
		return getElementText();
	}

	public String getPartnerLastNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(partnerLastNameFieldErrorMessageLocator);
		return getElementText();
	}

	public String readPartnerFirstNameField() {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldLocator);
		return getElementValue();
	}

	public String readPartnerLastNameField() {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldLocator);
		return getElementValue();
	}

	public DynamicPartnerDateOfBirthPage submitValidPartnerNameDetails(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
		return new DynamicPartnerDateOfBirthPage(driver);
	}
	
	public PartnerNamePage submitInValidPartnerNameDetails() {
		nextStep();
		return new PartnerNamePage(driver);
	}

	public TBIPage submitValidPartnerName(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
		return new TBIPage(driver);
	}

	public SessionsExpiredPage submitValidPartnerNameDetailsInExpiredSession(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
		return new SessionsExpiredPage(driver);
	}

}

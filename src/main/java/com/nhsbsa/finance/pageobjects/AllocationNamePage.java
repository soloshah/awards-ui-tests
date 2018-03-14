package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllocationNamePage extends Page {

	private String allocationNamePageTitle = "What is the name of the person you want to allocate some of your pension to? - Claim your NHS Pension";
	private By firstNameFieldLocator = By.id("firstName");
	private By lastNameFieldLocator = By.id("lastName");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By allocationFirstNameFieldErrorMessageLocator = By.id("firstName-error-message");
	private By allocationFirstNameAnchoredErrorMessageLocator = By.id("error-list0");
	private By allocationFirstNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#firstName']");
	private By allocationLastNameFieldErrorMessageLocator = By.id("lastName-error-message");
	private By allocationLastNameAnchoredErrorMessageLocator = By.id("error-list1");
	private By allocationLastNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#lastName']");

	public AllocationNamePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(allocationNamePageTitle);
		waitForElementToBeVisibleBy(firstNameFieldLocator);
	}

	public void enterfirstName(String firstName) {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldLocator);
		type(firstName);
	}

	public void enterlastName(String lastName) {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldLocator);
		type(lastName);
	}

	public void enterAllocationNameDetails(String firstName, String lastName) {
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

	public boolean doesAllocationFirstNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(allocationFirstNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(allocationFirstNameAnchoredErrorMessageAnchorLocator);
	}

	public boolean doesAllocationLastNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(allocationLastNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(allocationLastNameAnchoredErrorMessageAnchorLocator);
	}

	public String getAllocationFirstNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(allocationFirstNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getAllocationLastNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(allocationLastNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getAllocationFirstNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(allocationFirstNameFieldErrorMessageLocator);
		return getElementText();
	}

	public String getAllocationLastNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(allocationLastNameFieldErrorMessageLocator);
		return getElementText();
	}

	public String readAllocationFirstNameField() {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldLocator);
		return getElementValue();
	}

	public String readAllocationLastNameField() {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldLocator);
		return getElementValue();
	}

	public AllocationDateOfBirthPage submitValidAllocationNameDetails(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
		return new AllocationDateOfBirthPage(driver);
	}

	public TBIPage submitValidAllocationName(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
		return new TBIPage(driver);
	}

	public AllocationNamePage submitInValidAllocationNameDetails() {
		nextStep();
		return new AllocationNamePage(driver);
	}

}

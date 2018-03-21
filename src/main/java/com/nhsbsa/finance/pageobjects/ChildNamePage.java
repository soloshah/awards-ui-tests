package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChildNamePage extends Page {

	private String childNamePageTitle = "What is your Child's name? - Claim your NHS Pension";
	private By firstNameFieldLocator = By.id("firstName");
	private By lastNameFieldLocator = By.id("lastName");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By childFirstNameFieldErrorMessageLocator = By.id("firstName-error-message");
	private By childFirstNameAnchoredErrorMessageLocator = By.id("error-list0");
	private By childFirstNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#firstName']");
	private By childLastNameFieldErrorMessageLocator = By.id("lastName-error-message");
	private By childLastNameAnchoredErrorMessageLocator = By.id("error-list1");
	private By childLastNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#lastName']");

	public ChildNamePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(childNamePageTitle);
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

	public void enterChildNameDetails(String firstName, String lastName) {
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

	public boolean doesChildFirstNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(childFirstNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(childFirstNameAnchoredErrorMessageAnchorLocator);
	}

	public boolean doesChildLastNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(childLastNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(childLastNameAnchoredErrorMessageAnchorLocator);
	}

	public String getChildFirstNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(childFirstNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getChildLastNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(childLastNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getChildFirstNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(childFirstNameFieldErrorMessageLocator);
		return getElementText();
	}

	public String getChildLastNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(childLastNameFieldErrorMessageLocator);
		return getElementText();
	}

	public String readChildFirstNameField() {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldLocator);
		return getElementValue();
	}

	public String readChildLastNameField() {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldLocator);
		return getElementValue();
	}

	public ChildDOBPage submitValidChildNameDetails(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
		return new ChildDOBPage(driver);
	}

	public DynamicDateOfBirthPage submitValidChildName(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
		return new DynamicDateOfBirthPage(driver);
	}
	
	public void submitValidChildNames(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
	
	}
	
	public ChildNamePage submitInValidChildNameDetails() {
		nextStep();
		return new ChildNamePage(driver);
	}

}

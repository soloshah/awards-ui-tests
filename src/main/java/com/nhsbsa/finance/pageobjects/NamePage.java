package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NamePage extends Page {

	private String namePageTitle = "What is your name? - Claim your NHS Pension";
	private By firstNameFieldLocator = By.id("firstName");
	private By lastNameFieldLocator = By.id("lastName");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By firstNameFieldErrorMessageLocator = By.id("firstName-error-message");
	private By firstNameAnchoredErrorMessageLocator = By.id("error-list0");
	private By firstNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#firstName']");
	private By lastNameFieldErrorMessageLocator = By.id("lastName-error-message");
	private By lastNameAnchoredErrorMessageLocator = By.id("error-list1");
	private By lastNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#lastName']");

	public NamePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(namePageTitle);
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

	
	 public String getFirstNameDetails() {
		    navigateToRootElement();
		    navigateToElementBy(firstNameFieldLocator);
		    return getElementValue();
		  }
	
	 public String getLastNameDetails() {
		    navigateToRootElement();
		    navigateToElementBy(lastNameFieldLocator);
		    return getElementValue();
		  }
	 
	public void enterNameDetails(String firstName, String lastName) {
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

	public boolean doesFirstNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(firstNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(firstNameAnchoredErrorMessageAnchorLocator);
	}

	public boolean doesLastNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(lastNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(lastNameAnchoredErrorMessageAnchorLocator);
	}

	public String getFirstNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(firstNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getLastNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lastNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getFirstNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldErrorMessageLocator);
		return getElementText();
	}

	public String getLastNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldErrorMessageLocator);
		return getElementText();
	}

	public String readFirstNameField() {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldLocator);
		return getElementValue();
	}

	public String readLastNameField() {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldLocator);
		return getElementValue();
	}

	public DateOfBirthPage submitValidNameDetails(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
		return new DateOfBirthPage(driver);
	}

	public NamePage submitInValidNameDetails() {
		nextStep();
		return new NamePage(driver);
	}


}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositAccountPage extends Page {

	private String depositAccountPageTitle = "Enter bank details - Claim your NHS Pension - NHSBSA";
	private By accountNumberFieldLocator = By.id("accountNumber");
	private By rollNumberFieldLocator = By.id("rollNumber");
	private By sortCodeFirstFieldLocator = By.id("sortCode-first-field");
	private By sortCodeSecondFieldLocator = By.id("sortCode-second-field");
	private By sortCodeThirdFieldLocator = By.id("sortCode-third-field");
	private By accountHolderNameFieldLocator = By.id("accountHolderName");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By accountNumberFieldErrorMessageLocator = By.id("accountNumber-error-message");
	private By accountNumberAnchoredErrorMessageLocator = By.id("error-list0");
	private By accountNumberAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#accountNumber']");
	private By rollNumberFieldErrorMessageLocator = By.id("rollNumber-error-message");
	private By rollNumberAnchoredErrorMessageLocator = By.id("error-list1");
	private By rollNumberAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#rollNumber']");
	private By sortCodeFieldErrorMessageLocator = By.id("sortCode-error-message");
	private By sortCodeAnchoredErrorMessageLocator = By.id("error-list2");
	private By sortCodeAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#sortCode']");
	private By accountHolderNameFieldErrorMessageLocator = By.id("accountHolderName-error-message");
	private By accountHolderNameAnchoredErrorMessageLocator = By.id("error-list3");
	private By accountHolderNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#accountHolderName']");

	public DepositAccountPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(depositAccountPageTitle);
		waitForElementToBeVisibleBy(accountNumberFieldLocator);
		waitForElementToBeVisibleBy(rollNumberFieldLocator);
	}

	public void enterAccountNumber(String accountNumber) {
		navigateToRootElement();
		navigateToElementBy(accountNumberFieldLocator);
		type(accountNumber);
	}

	public void enterRollNumber(String rollNumber) {
		navigateToRootElement();
		navigateToElementBy(rollNumberFieldLocator);
		type(rollNumber);
	}

	public void enterSortCodeFirstField(String sortCodeFirstField) {
		navigateToRootElement();
		navigateToElementBy(sortCodeFirstFieldLocator);
		type(sortCodeFirstField);
	}
	
	public void enterSortCodeSecondField(String sortCodeSecondField) {
		navigateToRootElement();
		navigateToElementBy(sortCodeSecondFieldLocator);
		type(sortCodeSecondField);
	}
	
	public void enterSortCodeThirdField(String sortCodeThirdField) {
		navigateToRootElement();
		navigateToElementBy(sortCodeThirdFieldLocator);
		type(sortCodeThirdField);
	}

	public void enterAccountHolderName(String accountHolderName) {
		navigateToRootElement();
		navigateToElementBy(accountHolderNameFieldLocator);
		type(accountHolderName);
	}
	
	private void nextStep() {
	navigateToRootElement();
	navigateToElementBy(nextButtonLocator);
	click();
   } 
	
	public void enterSortCode(String firstField, String secondField, String thirdField) {
		enterSortCodeFirstField(firstField);
		enterSortCodeSecondField(secondField);
		enterSortCodeThirdField(thirdField);
	}

		
	public void enterBankDetails(String accountNumber, String rollNumber, String firstField, String secondField, String thirdField, String accountHolderName) {
		enterAccountNumber(accountNumber);
		enterRollNumber(rollNumber);
		enterSortCode(firstField,secondField,thirdField);
		enterAccountHolderName(accountHolderName);
		}
	
	public void enterBankAccountDetails(String accountNumber, String rollNumber, String accountHolderName) {
		enterAccountNumber(accountNumber);
		enterRollNumber(rollNumber);
		enterAccountHolderName(accountHolderName);
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

	public boolean doesAccountNumberErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(accountNumberAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(accountNumberAnchoredErrorMessageAnchorLocator);
	}

	public boolean doesRollNumberErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(rollNumberAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(rollNumberAnchoredErrorMessageAnchorLocator);
	}

	public boolean doesSortCodeErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(sortCodeAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(sortCodeAnchoredErrorMessageAnchorLocator);
	}
	
	public boolean doesAccountHolderNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(accountHolderNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(accountHolderNameAnchoredErrorMessageAnchorLocator);
	}
	public String getAccountNumberAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(accountNumberAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getRollNumberAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(rollNumberAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getSortCodeAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(sortCodeAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getAccountHolderNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(accountHolderNameAnchoredErrorMessageLocator);
		return getElementText();
	}
	public String getAccountNumberFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(accountNumberFieldErrorMessageLocator);
		return getElementText();
	}

	public String getRollNumberFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(rollNumberFieldErrorMessageLocator);
		return getElementText();
	}

	public String getSortCodeFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(sortCodeFieldErrorMessageLocator);
		return getElementText();
	}

	public String getAccountHolderNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(accountHolderNameFieldErrorMessageLocator);
		return getElementText();
	}

	
	public String readAccountHolderNameField() {
		navigateToRootElement();
		navigateToElementBy(accountHolderNameFieldLocator);
		return getElementValue();
	}


	public CheckYourAnswerPage submitValidBankDetails(String accountNumber, String rollNumber, String firstField, String secondField, String thirdField, String accountHolderName) {
		enterBankDetails(accountNumber, rollNumber, firstField, secondField, thirdField, accountHolderName);
		nextStep();
		return new CheckYourAnswerPage(driver);
	}

	public TBIPage submitValidBankAccountDetails(String accountNumber, String rollNumber, String firstField, String secondField, String thirdField, String accountHolderName) {
		enterBankDetails(accountNumber, rollNumber, firstField, secondField, thirdField, accountHolderName);
		nextStep();
		return new TBIPage(driver);
	}
	
	public DepositAccountPage submitInValidBankDetails() {
		nextStep();
		return new DepositAccountPage(driver);
	}


}

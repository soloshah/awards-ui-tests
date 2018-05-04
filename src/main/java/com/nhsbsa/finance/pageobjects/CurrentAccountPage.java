package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CurrentAccountPage extends Page {

	private String currentAccountPageTitle = "Enter bank details - Claim your NHS Pension - NHSBSA";
	private By accountNumberFieldLocator = By.id("accountNumber");
	private By sortCodeFirstFieldLocator = By.id("sort-code-1");
	private By sortCodeSecondFieldLocator = By.id("sort-code-2");
	private By sortCodeThirdFieldLocator = By.id("sort-code-3");
	private By accountHolderNameFieldLocator = By.id("accountHolderName");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By accountNumberFieldErrorMessageLocator = By.id("accountNumber-error-message");
	private By accountNumberAnchoredErrorMessageLocator = By.id("error-list0");
	private By accountNumberAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#accountNumber']");
	private By sortCodeFieldErrorMessageLocator = By.id("sortCode-error-message");
	private By sortCodeAnchoredErrorMessageLocator = By.id("error-list1");
	private By sortCodeAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#sortCode']");
	private By accountHolderNameFieldErrorMessageLocator = By.id("accountHolderName-error-message");
	private By accountHolderNameAnchoredErrorMessageLocator = By.id("error-list2");
	private By accountHolderNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#accountHolderName']");

	public CurrentAccountPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(currentAccountPageTitle);
		waitForElementToBeVisibleBy(accountNumberFieldLocator);
	}

	public void enterAccountNumber(String accountNumber) {
		navigateToRootElement();
		navigateToElementBy(accountNumberFieldLocator);
		type(accountNumber);
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
	
	public void nextStep() {
	navigateToRootElement();
	navigateToElementBy(nextButtonLocator);
	click();
   } 
	
	public void enterSortCode(String firstField, String secondField, String thirdField) {
		enterSortCodeFirstField(firstField);
		enterSortCodeSecondField(secondField);
		enterSortCodeThirdField(thirdField);
	}

		
	public void enterBankDetails(String accountNumber, String firstField, String secondField, String thirdField, String accountHolderName) {
		enterAccountNumber(accountNumber);
		enterSortCode(firstField,secondField,thirdField);
		enterAccountHolderName(accountHolderName);
		}
	
	public void enterBankAccountDetails(String accountNumber, String accountHolderName) {
		enterAccountNumber(accountNumber);
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


	public OtherEqPensionsPage submitValidBankAccountDetails(String accountNumber, String firstField, String secondField, String thirdField, String accountHolderName) {
		enterBankDetails(accountNumber, firstField, secondField, thirdField, accountHolderName);
		nextStep();
		return new OtherEqPensionsPage(driver);
	}
	
	public CurrentAccountPage submitInValidBankDetails() {
		nextStep();
		return new CurrentAccountPage(driver);
	}


}

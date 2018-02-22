package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankDetailsPage extends Page {

	private String bankDetailsTitle = "Enter bank details - Claim your NHS Pension - NHSBSA";
	private By accountNumberLocator = By.id("accountNumber");
//	private By sortCodeFirstFieldLocator = By.id("sortCode-first-field");
//	private By nextButtonLocator = By.id("submit_button");
//	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
//	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
//	private By bankAccountTypeAnchoredErrorMessageLocator = By.id("error-list0");
//	private By bankAccountTypeAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#accountType']");
//	private By bankAccountTypeFieldErrorMessageLocator = By.id("'error-message-'+${fieldName}");

	public BankDetailsPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(bankDetailsTitle);
		waitForElementToBeVisibleBy(accountNumberLocator);
	}

	
}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankAccountTypePage extends Page {

	private String bankAccountTypeTitle = "What type of account are we making the payment to? - Claim your NHS Pension";
	private By currentAccountRadioButtonLocator = By.xpath("//*[@id='accountType_group']/fieldset/div[1]/label");
	private By depositAccountRadioButtonLocator = By.xpath("//*[@id='accountType_group']/fieldset/div[2]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By bankAccountTypeAnchoredErrorMessageLocator = By.id("error-list0");
	private By bankAccountTypeAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#accountType']");
	private By bankAccountTypeFieldErrorMessageLocator = By.id("'error-message-'+${fieldName}");
	private By selectedCurrentAccountRadioButtonLocator = By.xpath("//input[@checked='checked']");
	private By selectedDepositAccountRadioButtonLocator = By.xpath("//input[@checked='checked']");

	public BankAccountTypePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(bankAccountTypeTitle);
		waitForElementToBeVisibleBy(currentAccountRadioButtonLocator);
	}

	public void getBankAccountType(String account) {
		navigateToRootElement();
		if (account.equals("currentAccount")) {
			navigateToElementBy(currentAccountRadioButtonLocator);
		} else if (account.equals("depositAccount")) {
			navigateToElementBy(depositAccountRadioButtonLocator);
		}
		click();
	}

	public BankAccountTypePage checkBankAccountType() {

		nextStep();
		return new BankAccountTypePage(driver);
	}

	public boolean isBankAccountRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(currentAccountRadioButtonLocator) && !isElementSelected(depositAccountRadioButtonLocator))
			selected = false;
		return selected;
	}

	public CurrentAccountPage selectValidCurrentAccountDetails() {
		navigateToRootElement();
		navigateToElementBy(currentAccountRadioButtonLocator);
		click();
		nextStep();
		return new CurrentAccountPage(driver);
	}


	public DepositAccountPage selectValidDepositAccountDetails() {
		navigateToRootElement();
		navigateToElementBy(depositAccountRadioButtonLocator);
		click();
		nextStep();
		return new DepositAccountPage(driver);
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

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public String getBankAccountFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(bankAccountTypeFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesBankAccountErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(bankAccountTypeAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(bankAccountTypeAnchoredErrorMessageAnchorLocator);
	}

	public String getBankAccountAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(bankAccountTypeAnchoredErrorMessageLocator);
		return getElementText();
	}
	
	public String getCurrentAccount() {
		navigateToRootElement();
		navigateToElementBy(selectedCurrentAccountRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}

	public String getDepositAccount() {
		navigateToRootElement();
		navigateToElementBy(selectedDepositAccountRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}
}

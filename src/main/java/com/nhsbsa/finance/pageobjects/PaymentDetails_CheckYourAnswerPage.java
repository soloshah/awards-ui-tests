package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentDetails_CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
	private By accountTypeFieldLocator = By.id("account-type");
	private By accountHolderNameFieldLocator = By.id("account-name");
	private By accountNumberFieldLocator = By.id("account-number");
	private By rollNumberFieldLocator = By.id("roll-number");
	private By sortCodeFieldLocator = By.id("sort-code");
	private By otherEqPensionFieldLocator = By.id("other-pension");
	private By eqPaymasterNameFieldLocator = By.id("other-pension-name");
	private By eqPaymasterRefFieldLocator = By.id("other-pension-ref");
	private By accountTypeTextLocator = By.id("account-type-answer");
	private By accountHolderNameTextLocator = By.id("account-name-answer");
	private By accountNumberTextLocator = By.id("account-number-answer");
	private By rollNumberTextLocator = By.id("roll-number-answer");
	private By sortCodeTextLocator = By.id("sort-code-answer");
	private By otherEqPensionTextLocator = By.id("other-pension-answer");
	private By eqPaymasterNameTextLocator = By.id("other-pension-name-answer");
	private By eqPaymasterRefTextLocator = By.id("other-pension-ref-answer");
	private By continueButtonLocator = By.id("continue_button");
	private By accountTypeChangeLinkLocator = By.id("account-type-change");
	private By accountHolderNameChangeLinkLocator = By.id("account-name-change");
	private By accountNumberChangeLinkLocator = By.id("account-number-change");
	private By rollNumberChangeLinkLocator = By.id("roll-number-change");
	private By sortCodeChangeLinkLocator = By.id("sort-code-change");
	private By otherEqPensionChangeLinkLocator = By.id("other-pension-change");
	private By eqPaymasterNameChangeLinkLocator = By.id("other-pension-name-change");
	private By eqPaymasterRefChangeLinkLocator = By.id("other-pension-ref-change");
	
	
	public PaymentDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(checkYouAnswersPageTitle);
		waitForElementToBeVisibleBy(accountTypeFieldLocator);
	}

	public boolean getPresenceOfAccountType() {
		navigateToRootElement();
		return getPresenceOfElement(accountTypeFieldLocator);
	}
	
	public boolean getPresenceOfAccountHolderName() {
		navigateToRootElement();
		return getPresenceOfElement(accountHolderNameFieldLocator);
	}

	public boolean getPresenceOfAccountNumber() {
		navigateToRootElement();
		return getPresenceOfElement(accountNumberFieldLocator);
	}

	public boolean getPresenceOfRollNumber() {
		navigateToRootElement();
		return getPresenceOfElement(rollNumberFieldLocator);
	}

	public boolean getPresenceOfSortCode() {
		navigateToRootElement();
		return getPresenceOfElement(sortCodeFieldLocator);
	}

	public boolean getPresenceOfOtherEqPension() {
		navigateToRootElement();
		return getPresenceOfElement(otherEqPensionFieldLocator);
	}
	
	public boolean getPresenceOfEqPaymasterName() {
		navigateToRootElement();
		return getPresenceOfElement(eqPaymasterNameFieldLocator);
	}

	public boolean getPresenceOfEqPaymasterRef() {
		navigateToRootElement();
		return getPresenceOfElement(eqPaymasterRefFieldLocator);
	}


	public String getAccountType() {
		navigateToRootElement();
		navigateToElementBy(accountTypeTextLocator);
		return getElementText();
	}

	public String getAccountHolderName() {
		navigateToRootElement();
		navigateToElementBy(accountHolderNameTextLocator);
		return getElementText();
	}

	public String getAccountNumber() {
		navigateToRootElement();
		navigateToElementBy(accountNumberTextLocator);
		return getElementText();
	}

	public String getRollNumber() {
		navigateToRootElement();
		navigateToElementBy(rollNumberTextLocator);
		return getElementText();
	}

	public String getSortCode() {
		navigateToRootElement();
		navigateToElementBy(sortCodeTextLocator);
		return getElementText();
	}

	public String getOtherEqPension() {
		navigateToRootElement();
		navigateToElementBy(otherEqPensionTextLocator);
		return getElementText();
	}

	public String getEqPaymasterName() {
		navigateToRootElement();
		navigateToElementBy(eqPaymasterNameTextLocator);
		return getElementText();
	}

	public String getEqPaymasterRef() {
		navigateToRootElement();
		navigateToElementBy(eqPaymasterRefTextLocator);
		return getElementText();
	}

	private void changeAccountTypeLink() {
		navigateToRootElement();
		navigateToElementBy(accountTypeChangeLinkLocator);
		click();
	}

	public BankAccountTypePage changeAccountTypeDetails() {
		changeAccountTypeLink();
		return new BankAccountTypePage(driver);
	}

	private void changeAccountHolderNameLink() {
		navigateToRootElement();
		navigateToElementBy(accountHolderNameChangeLinkLocator);
		click();
	}

	public void changeAccountHolderName() {
		changeAccountHolderNameLink();
	
	}
	
	private void changeAccountNumberLink() {
		navigateToRootElement();
		navigateToElementBy(accountNumberChangeLinkLocator);
		click();
	}

	public void changeAccountNumber() {
		changeAccountNumberLink();
	}

	private void changeSortCodeLink() {
		navigateToRootElement();
		navigateToElementBy(sortCodeChangeLinkLocator);
		click();
	}

	public void changeSortCode() {
		changeSortCodeLink();

	}

	private void changeRollNumberLink() {
		navigateToRootElement();
		navigateToElementBy(rollNumberChangeLinkLocator);
		click();
	}

	public void changeRollNumber() {
		changeRollNumberLink();
		
	}
	
	private void changeOtherEqPensionLink() {
		navigateToRootElement();
		navigateToElementBy(otherEqPensionChangeLinkLocator);
		click();
	}

	public OtherEqPensionsPage changeOtherEqPension() {
		changeOtherEqPensionLink();
		return new OtherEqPensionsPage(driver);	
	}
	
	private void changeEqPaymasterNameLink() {
		navigateToRootElement();
		navigateToElementBy(eqPaymasterNameChangeLinkLocator);
		click();
	}

	public EqPaymasterNamePage changeEqPaymasterName() {
		changeEqPaymasterNameLink();
		return new EqPaymasterNamePage(driver);
		
	}
	private void changeEqPaymasterRefLink() {
		navigateToRootElement();
		navigateToElementBy(eqPaymasterRefChangeLinkLocator);
		click();
	}

	public EqPaymasterReferencePage changeEqPaymasterRef() {
		changeEqPaymasterRefLink();
		return new EqPaymasterReferencePage(driver);
	}

	public SummaryPage submitPaymentDetails() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
		return new SummaryPage(driver);
	}
}

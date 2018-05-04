package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentDetails_CheckYourAnswerPage extends Page {

	private By accountTypeFieldLocator = By.id("paymentDetails.checkYourAnswers.accountType");
	private By accountHolderNameFieldLocator = By.id("paymentDetails.checkYourAnswers.accountName");
	private By accountNumberFieldLocator = By.id("paymentDetails.checkYourAnswers.accountNumber");
	private By rollNumberFieldLocator = By.id("paymentDetails.checkYourAnswers.rollNumber");
	private By sortCodeFieldLocator = By.id("paymentDetails.checkYourAnswers.sortCode");
	private By otherEqPensionFieldLocator = By.id("paymentDetails.checkYourAnswers.eqOther");
	private By eqPaymasterNameFieldLocator = By.id("paymentDetails.checkYourAnswers.eqName");
	private By eqPaymasterRefFieldLocator = By.id("paymentDetails.checkYourAnswers.eqRef.static");
	private By accountTypeTextLocator = By.id("paymentDetails.checkYourAnswers.accountType-answer");
	private By accountHolderNameTextLocator = By.id("paymentDetails.checkYourAnswers.accountName-answer");
	private By accountNumberTextLocator = By.id("paymentDetails.checkYourAnswers.accountNumber-answer");
	private By rollNumberTextLocator = By.id("paymentDetails.checkYourAnswers.rollNumber-answer");
	private By sortCodeTextLocator = By.id("paymentDetails.checkYourAnswers.sortCode-answer");
	private By otherEqPensionTextLocator = By.id("paymentDetails.checkYourAnswers.eqOther-answer");
	private By eqPaymasterNameTextLocator = By.id("paymentDetails.checkYourAnswers.eqName-answer");
	private By eqPaymasterRefTextLocator = By.id("paymentDetails.checkYourAnswers.eqRef.static-answer");

	public PaymentDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
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

}

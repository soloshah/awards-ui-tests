package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SharedEarlyPaymentPage extends Page {

	private String paymentDatePageTitle = "When should the early payment of deferred benefit start? - Claim your NHS Pension - NHSBSA";
	private By dayFieldLocator = By.id("paymentDate-day");
	private By monthFieldLocator = By.id("paymentDate-month");
	private By yearFieldLocator = By.id("paymentDate-year");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By paymentDateFieldErrorMessageLocator = By.id("paymentDate-error-message");
	private By paymentDateAnchoredErrorMessageLocator = By.id("error-list0");
	private By paymentDateAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#paymentDate']");
		
	public SharedEarlyPaymentPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(paymentDatePageTitle);
		waitForElementToBeVisibleBy(dayFieldLocator);
	}

	private void enterDay(String day) {
		navigateToRootElement();
		navigateToElementBy(dayFieldLocator);
		type(day);
	}

	private void enterMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(monthFieldLocator);
		type(month);
	}

	private void enterYear(String year) {
		navigateToRootElement();
		navigateToElementBy(yearFieldLocator);
		type(year);
	}

	private void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public void enterPaymentDateDetails(String day, String month, String year) {
		
		enterDay(day);
		enterMonth(month);
		enterYear(year);
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

	public boolean doesPaymentDateErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(paymentDateAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(paymentDateAnchoredErrorMessageAnchorLocator);
	}

	public String getPaymentDateAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(paymentDateAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getPaymentDateFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(paymentDateFieldErrorMessageLocator);
		return getElementText();
	}

		public TBIPage submitValidPaymentDateDetails(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new TBIPage(driver);
	}


	public SharedEarlyPaymentPage submitInValidPaymentDateDetails() {
		nextStep();
		return new SharedEarlyPaymentPage(driver);
	}


}

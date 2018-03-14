package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EarlyPaymentDate_2008Page extends Page {

	private String paymentDate2008PageTitle = "When should the early payment of deferred benefit start? - Claim your NHS Pension - NHSBSA";
	private By dayFieldLocator = By.id("paymentDate-day");
	private By monthFieldLocator = By.id("paymentDate-month");
	private By yearFieldLocator = By.id("paymentDate-year");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By paymentDate2008FieldErrorMessageLocator = By.id("paymentDate-error-message");
	private By paymentDate2008AnchoredErrorMessageLocator = By.id("error-list0");
	private By paymentDate2008AnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#paymentDate']");
		
	public EarlyPaymentDate_2008Page(WebDriver driver) {
		super(driver);
		waitForTitleToExist(paymentDate2008PageTitle);
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

	public void enterPaymentDate2008Details(String day, String month, String year) {
		
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

	public boolean doesPaymentDate2008ErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(paymentDate2008AnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(paymentDate2008AnchoredErrorMessageAnchorLocator);
	}

	public String getPaymentDate2008AnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(paymentDate2008AnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getPaymentDate2008FieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(paymentDate2008FieldErrorMessageLocator);
		return getElementText();
	}

		public TBIPage submitValidPaymentDate2008Details(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new TBIPage(driver);
	}


	public EarlyPaymentDate_2008Page submitInValidPaymentDate2008Details() {
		nextStep();
		return new EarlyPaymentDate_2008Page(driver);
	}


}

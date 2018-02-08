package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DateYouLeavePage extends Page {

	private String dateLeavePageTitle = "What was the name of your last NHS employer?-Claim your NHS Pension";
	private By dayFieldLocator = By.id("day");
	private By monthFieldLocator = By.id("month");
	private By yearFieldLocator = By.id("year");
	private By nextButtonLocator = By.id("next");
	private By errorHeadingErrorMessageLocator = By.id("date-error-heading");
	private By errorsBelowErrorMessageLocator = By.id("date-error-text");
	private By dateFieldErrorMessageLocator = By.id("error-message-date");
	private By dateAnchoredErrorMessageLocator = By.id("date-error-list1");
	private By dateAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#date']");
/*	private By datePastFieldErrorMessageLocator = By.id("date-past-error-message");
	private By dateLaterFieldErrorMessageLocator = By.id("date-past-error-message");*/

	public DateYouLeavePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(dateLeavePageTitle);
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

	public void enterDateDetails(String day, String month, String year) {
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

	public boolean doesDateErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(dateAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(dateAnchoredErrorMessageAnchorLocator);
	}

	public String getDateAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(dateAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getDateFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(dateFieldErrorMessageLocator);
		return getElementText();
	}

	/*public String getDatePastFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(datePastFieldErrorMessageLocator);
		return getElementText();
	}

	public String getDateLaterFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(dateLaterFieldErrorMessageLocator);
		return getElementText();
	}*/

	public PlanToWorkPage submitValidDateDetails(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new PlanToWorkPage(driver);
	}

	public DateYouLeavePage submitInValidDateDetails() {
		nextStep();
		return new DateYouLeavePage(driver);
	}

	public SessionsExpiredPage submitValidDateDetailsInExpiredSession(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new SessionsExpiredPage(driver);
	}

}

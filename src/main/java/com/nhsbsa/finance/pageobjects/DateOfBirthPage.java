package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DateOfBirthPage extends Page {

	private String dobPageTitle = "What is your date of birth? - Claim your NHS Pension";
	private By dayFieldLocator = By.id("dateOfBirth-day");
	private By monthFieldLocator = By.id("dateOfBirth-month");
	private By yearFieldLocator = By.id("dateOfBirth-year");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By dobFieldErrorMessageLocator = By.id("dateOfBirth-error-message");
	private By dobAnchoredErrorMessageLocator = By.id("error-list0");
	private By dobAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#dateOfBirth']");
	
	
	SharedDateOfBirthPage sharedDateOfBirthPage = new SharedDateOfBirthPage(driver);
	
	public DateOfBirthPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(dobPageTitle);
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

	public void enterDobDetails(String day, String month, String year) {
		
		sharedDateOfBirthPage.enterDay("");
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

	public boolean doesDobErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(dobAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(dobAnchoredErrorMessageAnchorLocator);
	}

	public String getDobAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(dobAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getDobFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(dobFieldErrorMessageLocator);
		return getElementText();
	}

	public GenderPage submitValidDOBDetails(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new GenderPage(driver);
	}
	
	public TBIPage submitValidDateDetails(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new TBIPage(driver);
	}


	public DateOfBirthPage submitInValidDOBDetails() {
		nextStep();
		return new DateOfBirthPage(driver);
	}

	public SessionsExpiredPage submitValidDOBDetailsInExpiredSession(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new SessionsExpiredPage(driver);
	}

}

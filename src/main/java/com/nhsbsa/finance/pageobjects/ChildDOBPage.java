package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChildDOBPage extends Page {

	private String childDOBPageTitle = "Claim your NHS Pension";
	private By childDayFieldLocator = By.id("dateOfBirth-day");
	private By childMonthFieldLocator = By.id("dateOfBirth-month");
	private By childYearFieldLocator = By.id("dateOfBirth-year");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By childDobFieldErrorMessageLocator = By.id("dateOfBirth-error-message");
	private By childDobAnchoredErrorMessageLocator = By.id("error-list0");
	private By childDobAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#dateOfBirth']");

	public ChildDOBPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(childDOBPageTitle);
		waitForElementToBeVisibleBy(childDayFieldLocator);
	}
	
	private void enterPartnerDay(String day) {
		navigateToRootElement();
		navigateToElementBy(childDayFieldLocator);
		type(day);
	}

	private void enterPartnerMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(childMonthFieldLocator);
		type(month);
	}

	private void enterPartnerYear(String year) {
		navigateToRootElement();
		navigateToElementBy(childYearFieldLocator);
		type(year);
	}

	private void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public void enterChildDobDetails(String day, String month, String year) {
		enterPartnerDay(day);
		enterPartnerMonth(month);
		enterPartnerYear(year);
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

	public boolean doesChildDobErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(childDobFieldErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(childDobAnchoredErrorMessageAnchorLocator);
	}

	public String getChildDobAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(childDobAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getChildDobFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(childDobFieldErrorMessageLocator);
		return getElementText();
	}

/*	public DependantChildrenPage submitValidChildDOBDetails(String day, String month, String year) {
		enterPartnerDay(day);
		enterPartnerMonth(month);
		enterPartnerYear(year);
		nextStep();
		return new DependantChildrenPage(driver);
	}*/

	public TBIPage submitValidChildDOB(String day, String month, String year) {
		enterPartnerDay(day);
		enterPartnerMonth(month);
		enterPartnerYear(year);
		nextStep();
		return new TBIPage(driver);
	}

	public ChildDOBPage submitInValidChildDOBDetails() {
		nextStep();
		return new ChildDOBPage(driver);
	}

	public SessionsExpiredPage submitValidChildDOBDetailsInExpiredSession(String day, String month, String year) {
		enterPartnerDay(day);
		enterPartnerMonth(month);
		enterPartnerYear(year);
		nextStep();
		return new SessionsExpiredPage(driver);
	}

}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nhsbsa.finance.pageobjects.Page;

public class PartnerDateOfBirthPage extends Page {

	
	private String partnerDobPageTitle = "What is your spouse's or civil partner's date of birth? - Claim your NHS Pension";
	//String firstName = "Partner Test";
	//private String partnerDobPageTitle = "What is " + firstName + "'s " +  "date of birth? - Claim your NHS Pension";
	private By partnerDayFieldLocator = By.id("dateOfBirth-day");
	private By partnerMonthFieldLocator = By.id("dateOfBirth-month");
	private By partnerYearFieldLocator = By.id("dateOfBirth-year");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By partnerDobFieldErrorMessageLocator = By.id("dateOfBirth-error-message");
	private By partnerDobAnchoredErrorMessageLocator = By.id("error-list0");
	private By partnerDobAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#dateOfBirth']");

	public PartnerDateOfBirthPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(partnerDobPageTitle);
		waitForElementToBeVisibleBy(partnerDayFieldLocator);
	}

	private void enterPartnerDay(String day) {
		navigateToRootElement();
		navigateToElementBy(partnerDayFieldLocator);
		type(day);
	}

	private void enterPartnerMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(partnerMonthFieldLocator);
		type(month);
	}

	private void enterPartnerYear(String year) {
		navigateToRootElement();
		navigateToElementBy(partnerYearFieldLocator);
		type(year);
	}

	private void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public void enterPartnerDobDetails(String day, String month, String year) {
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

	public boolean doesPartnerDobErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(partnerDobFieldErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(partnerDobAnchoredErrorMessageAnchorLocator);
	}

	public String getPartnerDobAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(partnerDobAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getPartnerDobFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(partnerDobFieldErrorMessageLocator);
		return getElementText();
	}

	public PartnerGenderPage submitValidPartnerDOBDetails(String day, String month, String year) {
		enterPartnerDay(day);
		enterPartnerMonth(month);
		enterPartnerYear(year);
		nextStep();
		return new PartnerGenderPage(driver);
	}

	public TBIPage submitValidPartnerDOB(String day, String month, String year) {
		enterPartnerDay(day);
		enterPartnerMonth(month);
		enterPartnerYear(year);
		nextStep();
		return new TBIPage(driver);
	}

	public PartnerDateOfBirthPage submitInValidPartnerDOBDetails() {
		nextStep();
		return new PartnerDateOfBirthPage(driver);
	}

	public SessionsExpiredPage submitValidPartnerDOBDetailsInExpiredSession(String day, String month, String year) {
		enterPartnerDay(day);
		enterPartnerMonth(month);
		enterPartnerYear(year);
		nextStep();
		return new SessionsExpiredPage(driver);
	}

}

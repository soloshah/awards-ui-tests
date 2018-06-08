package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllocationDOBPage extends Page {

	private String allocationDobPageTitle = "What is their date of birth? - Claim your NHS Pension - NHSBSA";
	private By allocationDayFieldLocator = By.id("dateOfBirth-day");
	private By allocationMonthFieldLocator = By.id("dateOfBirth-month");
	private By allocationYearFieldLocator = By.id("dateOfBirth-year");
	private By nextButtonLocator = By.id("submit_button");
	private By backLinkLocator = By.id("back-link");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By allocationDobFieldErrorMessageLocator = By.id("dateOfBirth-error-message");
	private By allocationDobAnchoredErrorMessageLocator = By.id("error-list0");
	private By allocationDobAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#dateOfBirth']");
    private By exampleFormHintLocator = By.id("dateOfBirth-form-hint");
    
	
	public AllocationDOBPage(WebDriver driver) {
		super(driver);
	waitForTitleToExist(allocationDobPageTitle);
	waitForElementToBeVisibleBy(backLinkLocator);
		waitForElementToBeVisibleBy(allocationDayFieldLocator);
	}
	
	private void enterAllocationDay(String day) {
		navigateToRootElement();
		navigateToElementBy(allocationDayFieldLocator);
		type(day);
	}

	private void enterAllocationMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(allocationMonthFieldLocator);
		type(month);
	}

	private void enterAllocationYear(String year) {
		navigateToRootElement();
		navigateToElementBy(allocationYearFieldLocator);
		type(year);
	}

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public AllocationRelationshipPage submitValidAllocationDateDetails(String day, String month, String year) {
		enterAllocationDay(day);
		enterAllocationMonth(month);
		enterAllocationYear(year);
		nextStep();
		return new AllocationRelationshipPage(driver);
	}
	
	public String getAllocationDay() {
	    navigateToRootElement();
	    navigateToElementBy(allocationDayFieldLocator);
	    return getElementValue();
	  }

 public String getAllocationMonth() {
	    navigateToRootElement();
	    navigateToElementBy(allocationMonthFieldLocator);
	    return getElementValue();
	  }

 public String getAllocationYear() {
	    navigateToRootElement();
	    navigateToElementBy(allocationYearFieldLocator);
	    return getElementValue();
	  }
 public void enterAllocationDobDetails(String day, String month, String year) {
		enterAllocationDay(day);
		enterAllocationMonth(month);
		enterAllocationYear(year);
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

	public boolean doesAllocationDobErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(allocationDobFieldErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(allocationDobAnchoredErrorMessageAnchorLocator);
	}

	public String getAllocationDobAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(allocationDobAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getAllocationDobFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(allocationDobFieldErrorMessageLocator);
		return getElementText();
	}

		public AllocationDOBPage submitInValidAllocationDOBDetails() {
		nextStep();
		return new AllocationDOBPage(driver);
	}

	public String getExampleFormHint() {
		navigateToRootElement();
		navigateToElementBy(exampleFormHintLocator);
		return getElementText();
	}

}

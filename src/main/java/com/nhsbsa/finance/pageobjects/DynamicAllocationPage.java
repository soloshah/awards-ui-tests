package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicAllocationPage extends Page {

	private String fname = "Rob";
	private String allocationDobPageTitle = "What is " + fname + "'s " + "date of birth? - Claim your NHS Pension - NHSBSA";
	private By allocationDayFieldLocator = By.id("dateOfBirth-day");
	private By allocationMonthFieldLocator = By.id("dateOfBirth-month");
	private By allocationYearFieldLocator = By.id("dateOfBirth-year");
	private By nextButtonLocator = By.id("submit_button");
	
	public DynamicAllocationPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(allocationDobPageTitle);
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

	public DynamicAllocationRelationshipPage submitValidAllocationDateDetails(String day, String month, String year) {
		enterAllocationDay(day);
		enterAllocationMonth(month);
		enterAllocationYear(year);
		nextStep();
		return new DynamicAllocationRelationshipPage(driver);
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
	

}

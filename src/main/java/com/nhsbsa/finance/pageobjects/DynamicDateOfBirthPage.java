package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nhsbsa.finance.pageobjects.Page;

public class DynamicDateOfBirthPage extends Page {

	String fName = "Arya";
	private String dobPageTitle = "What is " + fName + "'s " +  "date of birth? - Claim your NHS Pension - NHSBSA";
	private By partnerDayFieldLocator = By.id("dateOfBirth-day");
	private By partnerMonthFieldLocator = By.id("dateOfBirth-month");
	private By partnerYearFieldLocator = By.id("dateOfBirth-year");
	private By nextButtonLocator = By.id("submit_button");
	

	public DynamicDateOfBirthPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(dobPageTitle);
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

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}
	
	public PartnerGenderPage submitValidPartnerDOBDetails(String day, String month, String year) {
		enterPartnerDay(day);
		enterPartnerMonth(month);
		enterPartnerYear(year);
		nextStep();
		return new PartnerGenderPage(driver);
	}
	
	public String getDay() {
	    navigateToRootElement();
	    navigateToElementBy(partnerDayFieldLocator);
	    return getElementValue();
	  }

 public String getMonth() {
	    navigateToRootElement();
	    navigateToElementBy(partnerMonthFieldLocator);
	    return getElementValue();
	  }

 public String getYear() {
	    navigateToRootElement();
	    navigateToElementBy(partnerYearFieldLocator);
	    return getElementValue();
	  }

	

	
}

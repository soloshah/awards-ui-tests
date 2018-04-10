package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LastDayOfWorkPage extends Page {

	private String lastDayOfWorkPageTitle = "When will be your last day of work? - Claim your NHS Pension - NHSBSA";
	private By dayFieldLocator = By.id("lastDayOfWorkWillBe-day");
	private By monthFieldLocator = By.id("lastDayOfWorkWillBe-month");
	private By yearFieldLocator = By.id("lastDayOfWorkWillBe-year");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By dateHintLocator = By.id("lastDayOfWorkWillBe-form-hint");
	private By lastDayFieldErrorMessageLocator = By.id("lastDayOfWorkWillBe-error-message");
	private By lastDayAnchoredErrorMessageLocator = By.id("error-list0");
	private By lastDayAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#lastDayOfWorkWillBe']");


	public LastDayOfWorkPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(lastDayOfWorkPageTitle);
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

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}
	
	
	 public String getDay() {
		    navigateToRootElement();
		    navigateToElementBy(dayFieldLocator);
		    return getElementValue();
		  }

	 public String getMonth() {
		    navigateToRootElement();
		    navigateToElementBy(monthFieldLocator);
		    return getElementValue();
		  }
	
	 public String getYear() {
		    navigateToRootElement();
		    navigateToElementBy(yearFieldLocator);
		    return getElementValue();
		  }

	public String getExampleDateHint() {
		navigateToRootElement();
		navigateToElementBy(dateHintLocator);
		return getElementText();
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

	public boolean doesLastDayErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(lastDayAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(lastDayAnchoredErrorMessageAnchorLocator);
	}

	public String getLastDayAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lastDayAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getlastDayFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lastDayFieldErrorMessageLocator);
		return getElementText();
	}


	public IntendToWorkForNHSPage submitValidDateDetails(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new IntendToWorkForNHSPage(driver);
	}
	
	
	public LastDayOfWorkPage submitInValidDateDetails() {
		nextStep();
		return new LastDayOfWorkPage(driver);
	}


}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DateYouLeavePage extends Page {

	private String dateYouLeavePageTitle = "What date did you leave? - Claim your NHS Pension - NHSBSA";
	private By dayFieldLocator = By.id("lastEmploymentDate-day");
	private By monthFieldLocator = By.id("lastEmploymentDate-month");
	private By yearFieldLocator = By.id("lastEmploymentDate-year");
	private By nextButtonLocator = By.id("submit_button");
	private By exampleHintLocator = By.id("lastEmploymentDate-form-hint");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By dateFieldErrorMessageLocator = By.id("lastEmploymentDate-error-message");
	private By dateAnchoredErrorMessageLocator = By.id("error-list0");
	private By dateAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#lastEmploymentDate']");


	public DateYouLeavePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(dateYouLeavePageTitle);
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
	 
	public void nextStep() {
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


	
	public IntendToWorkForNHSPage submitValidDate(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new IntendToWorkForNHSPage(driver);
	}


	public DateYouLeavePage submitInValidDateDetails() {
		nextStep();
		return new DateYouLeavePage(driver);
	}
	
	public String getExampleDateHint() {
		navigateToRootElement();
		navigateToElementBy(exampleHintLocator);
		return getElementText();
	}


}

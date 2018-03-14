package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntendToWorkForNHSPage extends Page {

	private String intendToWorkForNHSTitle = "Claim your NHS Pension";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNoValue_group']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNoValue_group']/div/div[2]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By nhsAnchoredErrorMessageLocator = By.id("error-list0");
	private By nhsAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#yesNoValue']");
	private By nhsFieldErrorMessageLocator = By.id("fieldName-error-message");
	private By dateAnchoredErrorMessageLocator = By.id("error-list1");
	private By dateAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#dateValue']");
	private By dateFieldErrorMessageLocator = By.id("dateValue-error-message");
	private By dayFieldLocator = By.id("dateValue-day");
	private By monthFieldLocator = By.id("dateValue-month");
	private By yearFieldLocator = By.id("dateValue-year");
	private By dateHeaderLocator = By.id("label-text");

	public IntendToWorkForNHSPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(intendToWorkForNHSTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
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
	
	public String getDateHeading() {
		navigateToRootElement();
		navigateToElementBy(dateHeaderLocator);
		return getElementText();
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


	public String getNhsFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(nhsFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesNhsErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(nhsAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(nhsAnchoredErrorMessageAnchorLocator);
	}

	public String getNhsAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(nhsAnchoredErrorMessageLocator);
		return getElementText();
	}
	
	public String getDateFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(dateFieldErrorMessageLocator);
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
	
	public void enterDateDetails(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
	}

	
	public IntendToWorkForNHSPage intendToWorkForNHSIsNotSelected() {
		nextStep();
		return new IntendToWorkForNHSPage(driver);
	}

	public boolean intendToWorkForNHSRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

	public IntendToWorkForNHSPage submitValidYesNhsDetails() {
		navigateToRootElement();
		navigateToElementBy(yesRadioButtonLocator);
		click();
		return new IntendToWorkForNHSPage(driver);
	}
	
	public TBIPage submitValidDate(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new TBIPage(driver);
	}
	
	public IntendToWorkForNHSPage submitInValidDateDetails() {
		nextStep();
		return new IntendToWorkForNHSPage(driver);
	}

	public CheckYourAnswerPage submitValidNoNhsDetails() {
		navigateToRootElement();
		navigateToElementBy(noRadioButtonLocator);
		click();
		nextStep();
		return new CheckYourAnswerPage(driver);
	}

	public TBIPage submitValidNoDetails() {
		navigateToRootElement();
		navigateToElementBy(noRadioButtonLocator);
		click();
		nextStep();
		return new TBIPage(driver);
	}

}

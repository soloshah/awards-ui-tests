package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntendToWorkForNHSPage extends Page {

	private String intendToWorkForNHSTitle = "Do you plan to work for the NHS after you get your pension? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNoValue']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNoValue']/div/div[2]/label");
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
	private By dateHeaderLocator = By.id("dateValue-label-text");
	private By exampleReturnDateHintLocator = By.id("dateValue-form-hint");
	private By selectedYesRadioButtonLocator = By.xpath("//input[@checked='checked']");
	private By selectedNoRadioButtonLocator = By.xpath("//input[@checked='checked']");
	
	
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
	
	public String getDateHeading() {
		navigateToRootElement();
		navigateToElementBy(dateHeaderLocator);
		return getElementText();
	}
	
	public String getYesRadioButton() {
		navigateToRootElement();
		navigateToElementBy(selectedYesRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}
	
	public String getNoRadioButton() {
		navigateToRootElement();
		navigateToElementBy(selectedNoRadioButtonLocator);
		navigateToParentElement();
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
	
	public void submitValidDate(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		
	}
	
	public IntendToWorkForNHSPage submitInValidDateDetails() {
		nextStep();
		return new IntendToWorkForNHSPage(driver);
	}

	public void submitValidNoDetails() {
		navigateToRootElement();
		navigateToElementBy(noRadioButtonLocator);
		click();
		nextStep();
		
	}
	
	public String getExampleReturnDateHint() {
		navigateToRootElement();
		navigateToElementBy(exampleReturnDateHintLocator);
		return getElementText();
	}

}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MaritalStatusPage extends Page {

	
	private String maritalStatusTitle = "What is your marital status? - Claim your NHS Pension - NHSBSA";
	private By singleRadioButtonLocator = By.xpath("//*[@id='status']/fieldset/div/div[1]/label");
	private By marriedRadioButtonLocator = By.xpath("//*[@id='status']/fieldset/div/div[2]/label");
	private By civilPartnershipRadioButtonLocator = By.xpath("//*[@id='status']/fieldset/div/div[4]/label");
	private By widowedRadioButtonLocator = By.xpath("//*[@id='status']/fieldset/div/div[6]/label");
	private By divorcedRadioButtonLocator = By.xpath("//*[@id='status']/fieldset/div/div[8]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By maritalStatusAnchoredErrorMessageLocator = By.id("error-list0");
	private By maritalStatusAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#status']");
	private By maritalStatusFieldErrorMessageLocator = By.id("error-message-marital-status");
	private By marriedDateAnchoredErrorMessageLocator = By.id("error-list1");
	private By marriedDateAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#marriedDate']");
	private By marriedDateFieldErrorMessageLocator = By.id("marriedDate-error-message");
	private By marriedDateHeaderLocator = By.id("marriedDate-label-text");
	private By marriedDayFieldLocator = By.id("marriedDate-day");
	private By marriedMonthFieldLocator = By.id("marriedDate-month");
	private By marriedYearFieldLocator = By.id("marriedDate-year");
	private By marriedDateHintLocator = By.id("marriedDate-form-hint");
	private By civilDateAnchoredErrorMessageLocator = By.id("error-list2");
	private By civilDateAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#civilDate']");
	private By civilDateFieldErrorMessageLocator = By.id("civilDate-error-message");
	private By civilDayFieldLocator = By.id("civilDate-day");
	private By civilMonthFieldLocator = By.id("civilDate-month");
	private By civilYearFieldLocator = By.id("civilDate-year");
	private By civilDateHintLocator = By.id("civilDate-form-hint");
	private By civilDateHeaderLocator = By.id("civilDate-label-text");
	private By widowedDateAnchoredErrorMessageLocator = By.id("error-list3");
	private By widowedDateAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#widowedDate']");
	private By widowedDateFieldErrorMessageLocator = By.id("widowedDate-error-message");
	private By widowedDayFieldLocator = By.id("widowedDate-day");
	private By widowedMonthFieldLocator = By.id("widowedDate-month");
	private By widowedYearFieldLocator = By.id("widowedDate-year");
	private By widowedDateHintLocator = By.id("widowedDate-form-hint");
	private By widowedDateHeaderLocator = By.id("widowedDate-label-text");
	private By divorcedDateAnchoredErrorMessageLocator = By.id("error-list4");
	private By divorcedDateAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#divorcedDate']");
	private By divorcedDateFieldErrorMessageLocator = By.id("divorcedDate-error-message");
	private By divorcedDayFieldLocator = By.id("divorcedDate-day");
	private By divorcedMonthFieldLocator = By.id("divorcedDate-month");
	private By divorcedYearFieldLocator = By.id("divorcedDate-year");
	private By divorcedDateHintLocator = By.id("divorcedDate-form-hint");
	private By divorcedDateHeaderLocator = By.id("divorcedDate-label-text");
	private By selectedMarriedRadioButtonLocator = By.xpath("//input[@checked='checked']");
	

	public MaritalStatusPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(maritalStatusTitle);
		waitForElementToBeVisibleBy(singleRadioButtonLocator);
	}

	private void enterMarriedDay(String day) {
		navigateToRootElement();
		navigateToElementBy(marriedDayFieldLocator);
		type(day);
	}

	private void enterMarriedMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(marriedMonthFieldLocator);
		type(month);
	}

	private void enterMarriedYear(String year) {
		navigateToRootElement();
		navigateToElementBy(marriedYearFieldLocator);
		type(year);
	}

	private void enterCivilDay(String day) {
		navigateToRootElement();
		navigateToElementBy(civilDayFieldLocator);
		type(day);
	}

	private void enterCivilMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(civilMonthFieldLocator);
		type(month);
	}

	private void enterCivilYear(String year) {
		navigateToRootElement();
		navigateToElementBy(civilYearFieldLocator);
		type(year);
	}

	private void enterWidowedDay(String day) {
		navigateToRootElement();
		navigateToElementBy(widowedDayFieldLocator);
		type(day);
	}

	private void enterWidowedMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(widowedMonthFieldLocator);
		type(month);
	}

	private void enterWidowedYear(String year) {
		navigateToRootElement();
		navigateToElementBy(widowedYearFieldLocator);
		type(year);
	}

	private void enterDivorcedDay(String day) {
		navigateToRootElement();
		navigateToElementBy(divorcedDayFieldLocator);
		type(day);
	}

	private void enterDivorcedMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(divorcedMonthFieldLocator);
		type(month);
	}

	private void enterDivorcedYear(String year) {
		navigateToRootElement();
		navigateToElementBy(divorcedYearFieldLocator);
		type(year);
	}

	public String getMarriedDateHeading() {
		navigateToRootElement();
		navigateToElementBy(marriedDateHeaderLocator);
		return getElementText();
	}

	public String getCivilDateHeading() {
		navigateToRootElement();
		navigateToElementBy(civilDateHeaderLocator);
		return getElementText();
	}

	public String getWidowedDateHeading() {
		navigateToRootElement();
		navigateToElementBy(widowedDateHeaderLocator);
		return getElementText();
	}

	public String getDivorcedDateHeading() {
		navigateToRootElement();
		navigateToElementBy(divorcedDateHeaderLocator);
		return getElementText();
	}

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
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

	public String getMaritalStatusFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(maritalStatusFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesMaritalStatusErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(maritalStatusAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(maritalStatusAnchoredErrorMessageAnchorLocator);
	}

	public String getMaritalStatusAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(maritalStatusAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getMarriedFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(marriedDateFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesMarriedErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(marriedDateAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(marriedDateAnchoredErrorMessageAnchorLocator);
	}

	public String getMarriedAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(marriedDateAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getCivilFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(civilDateFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesCivilErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(civilDateAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(civilDateAnchoredErrorMessageAnchorLocator);
	}

	public String getCivilAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(civilDateAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getWidowedFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(widowedDateFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesWidowedErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(widowedDateAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(widowedDateAnchoredErrorMessageAnchorLocator);
	}

	public String getWidowedAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(widowedDateAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getDivorcedFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(divorcedDateFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesDivorcedErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(divorcedDateAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(divorcedDateAnchoredErrorMessageAnchorLocator);
	}

	public String getDivorcedAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(divorcedDateAnchoredErrorMessageLocator);
		return getElementText();
	}

	public void enterMarriedDateDetails(String day, String month, String year) {
		enterMarriedDay(day);
		enterMarriedMonth(month);
		enterMarriedYear(year);
	}

	public void enterCivilDateDetails(String day, String month, String year) {
		enterCivilDay(day);
		enterCivilMonth(month);
		enterCivilYear(year);
	}

	public void enterWidowedDateDetails(String day, String month, String year) {
		enterWidowedDay(day);
		enterWidowedMonth(month);
		enterWidowedYear(year);
	}

	public void enterDivorcedDateDetails(String day, String month, String year) {
		enterDivorcedDay(day);
		enterDivorcedMonth(month);
		enterDivorcedYear(year);
	}

	public MaritalStatusPage maritalStatusIsNotSelected() {
		nextStep();
		return new MaritalStatusPage(driver);
	}

	public boolean maritalStatusRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(singleRadioButtonLocator) && !isElementSelected(marriedRadioButtonLocator)
				&& !isElementSelected(civilPartnershipRadioButtonLocator)
				&& !isElementSelected(widowedRadioButtonLocator) && !isElementSelected(divorcedRadioButtonLocator))
			selected = false;
		return selected;
	}

	public DependantChildrenPage selectSingleMaritalStatus() {
		navigateToRootElement();
		navigateToElementBy(singleRadioButtonLocator);
		click();
		nextStep();
		return new DependantChildrenPage(driver);
	}

	public MaritalStatusPage selectMarriedMaritalStatus() {
		navigateToRootElement();
		navigateToElementBy(marriedRadioButtonLocator);
		click();
		return new MaritalStatusPage(driver);
	}

	public PartnerNamePage submitValidMarriedDate(String day, String month, String year) {
		enterMarriedDateDetails(day, month, year);
		nextStep();
		return new PartnerNamePage(driver);
	}

	public MaritalStatusPage selectCivilMaritalStatus() {
		navigateToRootElement();
		navigateToElementBy(civilPartnershipRadioButtonLocator);
		click();
		return new MaritalStatusPage(driver);
	}

	public PartnerNamePage submitValidCivilDate(String day, String month, String year) {
		enterCivilDateDetails(day, month, year);
		nextStep();
		return new PartnerNamePage(driver);
	}

	public MaritalStatusPage selectWidowedMaritalStatus() {
		navigateToRootElement();
		navigateToElementBy(widowedRadioButtonLocator);
		click();
		return new MaritalStatusPage(driver);
	}

	public DependantChildrenPage submitValidWidowedDate(String day, String month, String year) {
		enterWidowedDateDetails(day, month, year);
		nextStep();
		return new DependantChildrenPage(driver);
	}

	public MaritalStatusPage selectDivorcedMaritalStatus() {
		navigateToRootElement();
		navigateToElementBy(divorcedRadioButtonLocator);
		click();
		return new MaritalStatusPage(driver);
	}

	public DependantChildrenPage submitValidDivorcedDate(String day, String month, String year) {
		enterDivorcedDateDetails(day, month, year);
		nextStep();
		return new DependantChildrenPage(driver);
	}

	public MaritalStatusPage submitInValidDates() {
		nextStep();
		return new MaritalStatusPage(driver);
	}

	public String getMarriedHint() {
		navigateToRootElement();
		navigateToElementBy(marriedDateHintLocator);
		return getElementText();
	}

	public String getCivilPartnershipHint() {
		navigateToRootElement();
		navigateToElementBy(civilDateHintLocator);
		return getElementText();
	}

	public String getWidowedHint() {
		navigateToRootElement();
		navigateToElementBy(widowedDateHintLocator);
		return getElementText();
	}

	public String getDivorcedHint() {
		navigateToRootElement();
		navigateToElementBy(divorcedDateHintLocator);
		return getElementText();
	}
	
	public String getMarriedStatus() {
		navigateToRootElement();
		navigateToElementBy(selectedMarriedRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}
	
	 public String getMarriedDay() {
		    navigateToRootElement();
		    navigateToElementBy(marriedDayFieldLocator);
		    return getElementValue();
		  }

	 public String getMarriedMonth() {
		    navigateToRootElement();
		    navigateToElementBy(marriedMonthFieldLocator);
		    return getElementValue();
		  }
	
	 public String getMarriedYear() {
		    navigateToRootElement();
		    navigateToElementBy(marriedYearFieldLocator);
		    return getElementValue();
		  }
	


}

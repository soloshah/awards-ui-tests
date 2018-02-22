package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NameOfYourLastEmployerPage extends Page {

	private String lastEmployerPageTitle = "What was the name of your last NHS employer? - Claim your NHS Pension";
	private By employerNameFieldLocator = By.id("employerName");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By employerNameFieldErrorMessageLocator = By.id("employerName-error-message");
	private By employerNameAnchoredErrorMessageLocator = By.id("error-list0");
	private By employerNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#employerName']");
    
	
	public NameOfYourLastEmployerPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(lastEmployerPageTitle);
		waitForElementToBeVisibleBy(employerNameFieldLocator);
	}

	public void enterEmployerName(String employerName) {
		navigateToRootElement();
		navigateToElementBy(employerNameFieldLocator);
		type(employerName);
	}

	public void enterEmployerNameDetails(String employerName) {
		enterEmployerName(employerName);
		nextStep();
	}

	private void nextStep() {
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

	public boolean doesEmployerNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(employerNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(employerNameAnchoredErrorMessageAnchorLocator);
	}

	public String getEmployerNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(employerNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getEmployerNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(employerNameFieldErrorMessageLocator);
		return getElementText();
	}

	public JobTitlePage submitValidJobTitleDetails(String employerName) {
		enterEmployerName(employerName);
		nextStep();
		return new JobTitlePage(driver);
	}

	public NameOfYourLastEmployerPage submitInValidEmployerNameDetails() {
		nextStep();
		return new NameOfYourLastEmployerPage(driver);
	}
	
	
	public SessionsExpiredPage submitValidJobtitleDetailsInExpiredSession(String employerName) {
		enterEmployerName(employerName);
		nextStep();
		return new SessionsExpiredPage(driver);
	}

}

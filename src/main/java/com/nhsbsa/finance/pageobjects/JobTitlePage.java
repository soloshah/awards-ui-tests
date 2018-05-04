package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobTitlePage extends Page {

	private String jobPageTitle = "What was your job title? - Claim your NHS Pension - NHSBSA";
	private By jobTitleFieldLocator = By.id("jobTitle");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By jobTitleFieldErrorMessageLocator = By.id("jobTitle-error-message");
	private By jobTitleAnchoredErrorMessageLocator = By.id("error-list0");
	private By jobTitleAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#jobTitle']");

	public JobTitlePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(jobPageTitle);
		waitForElementToBeVisibleBy(jobTitleFieldLocator);
	}

	public void enterjobTitle(String jobTitle) {
		navigateToRootElement();
		navigateToElementBy(jobTitleFieldLocator);
		type(jobTitle);
	}

	public void enterJobDetails(String jobTitle) {
		enterjobTitle(jobTitle);
		nextStep();
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

	public boolean doesJobTitleErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(jobTitleAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(jobTitleAnchoredErrorMessageAnchorLocator);
	}

	public String getJobTitleAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(jobTitleAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getJobTitleFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(jobTitleFieldErrorMessageLocator);
		return getElementText();
	}


	public DateYouLeavePage submitValidJobTitle(String jobTitle) {
		enterjobTitle(jobTitle);
		nextStep();
		return new DateYouLeavePage(driver);
	}

	public JobTitlePage submitInValidJobTitleDetails() {
		nextStep();
		return new JobTitlePage(driver);
	}

	public String readJobTitleField() {
		navigateToRootElement();
		navigateToElementBy(jobTitleFieldLocator);
		return getElementValue();
	}

	
	public String getJobTitleDetails() {
		navigateToRootElement();
		navigateToElementBy(jobTitleFieldLocator);
		return getElementValue();
	}
}

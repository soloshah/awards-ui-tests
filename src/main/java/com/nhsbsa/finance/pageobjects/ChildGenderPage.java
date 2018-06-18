package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChildGenderPage extends Page {

	private String childGenderTitle = "What is your child's gender? - Claim your NHS Pension - NHSBSA";
	private By femaleRadioButtonLocator = By.id("gender0");
	private By maleRadioButtonLocator = By.id("gender1");
	private By nextButtonLocator = By.id("submit_button");
	private By backLinkLocator = By.id("back-link");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By childGenderAnchoredErrorMessageLocator = By.id("error-list0");
	private By childGenderAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#gender']");
	private By childGenderFieldErrorMessageLocator = By.id("'error-message-'+${fieldName}");
	private By selectedFemaleRadioButtonLocator = By.xpath("//input[@checked='checked']");
	private By selectedMaleRadioButtonLocator = By.xpath("//input[@checked='checked']");

	
	public ChildGenderPage(WebDriver driver) {
		super(driver);
	waitForTitleToExist(childGenderTitle);
		waitForElementToBeVisibleBy(backLinkLocator);
	}

	
	public OtherDependantChildrenPage selectFemale() {
		navigateToRootElement();
		navigateToElementBy(femaleRadioButtonLocator);
		click();
		nextStep();
		return new OtherDependantChildrenPage(driver);
	}

	public OtherDependantChildrenPage selectMale() {
		navigateToRootElement();
		navigateToElementBy(maleRadioButtonLocator);
		click();
		nextStep();
		return new OtherDependantChildrenPage(driver);
	}
	
	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}
	
	public String getGenderFemale() {
		navigateToRootElement();
		navigateToElementBy(selectedFemaleRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}

	public String getGenderMale() {
		navigateToRootElement();
		navigateToElementBy(selectedMaleRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}
	
	public ChildGenderPage childGenderIsNotSelected() {
		nextStep();
		return new ChildGenderPage(driver);
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


	public String getChildGenderFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(childGenderFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesChildGenderErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(childGenderAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(childGenderAnchoredErrorMessageAnchorLocator);
	}

	public String getChildGenderAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(childGenderAnchoredErrorMessageLocator);
		return getElementText();
	}



}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllocationRelationshipPage extends Page {

	private String relationshipPageTitle = "What is their relationship to you? - Claim your NHS Pension - NHSBSA";
	private By relationshipNameFieldLocator = By.id("relationship");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By relationshipFieldErrorMessageLocator = By.id("relationship-error-message");
	private By relationshipAnchoredErrorMessageLocator = By.id("error-list1");
	private By relationshipAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#relationship']");

	public AllocationRelationshipPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(relationshipPageTitle);
		waitForElementToBeVisibleBy(relationshipNameFieldLocator);
	}

	public void enterRelationship(String relationship) {
		navigateToRootElement();
		navigateToElementBy(relationshipNameFieldLocator);
		type(relationship);
	}

	public void enterRelationshipDetails(String relationship) {
		enterRelationship(relationship);
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

	public boolean doesRelationshipErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(relationshipAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(relationshipAnchoredErrorMessageAnchorLocator);
	}

	public String getRelationshipAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(relationshipAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getRelationshipFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(relationshipFieldErrorMessageLocator);
		return getElementText();
	}


	public DependantDetails_CheckYourAnswerPage submitValidAllocationRelationship(String relationship) {
		enterRelationship(relationship);

		nextStep();
		return new DependantDetails_CheckYourAnswerPage(driver);
	}

	public AllocationRelationshipPage submitInValidRelationshipDetails() {
		nextStep();
		return new AllocationRelationshipPage(driver);
	}



}

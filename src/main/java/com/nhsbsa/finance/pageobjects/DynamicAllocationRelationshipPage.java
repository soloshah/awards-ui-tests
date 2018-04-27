package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicAllocationRelationshipPage extends Page {

	private String fname = "Rob";
	private String allocationRelationshipPageTitle = "What is " + fname + "'s " + "relationship to you? - Claim your NHS Pension - NHSBSA";
	private By relationshipNameFieldLocator = By.id("relationship");
	private By nextButtonLocator = By.id("submit_button");
	
	
	
	public DynamicAllocationRelationshipPage(WebDriver driver) {
		super(driver);
	//	waitForTitleToExist(allocationRelationshipPageTitle);
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

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}


	public DependantDetails_CheckYourAnswerPage submitValidAllocationRelationship(String relationship) {
		enterRelationship(relationship);

		nextStep();
		return new DependantDetails_CheckYourAnswerPage(driver);
	}

	public String getRelationshipNameDetails() {
		navigateToRootElement();
		navigateToElementBy(relationshipNameFieldLocator);
		return getElementValue();
	}

}

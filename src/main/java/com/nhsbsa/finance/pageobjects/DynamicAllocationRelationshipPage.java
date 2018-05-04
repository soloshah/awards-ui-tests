package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicAllocationRelationshipPage extends Page {

	
	private By relationshipNameFieldLocator = By.id("relationship");
	private By nextButtonLocator = By.id("submit_button");
	
	
	
	public DynamicAllocationRelationshipPage(WebDriver driver) {
		super(driver);
	
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


	public CheckYourAnswerPage submitValidAllocationRelationship(String relationship) {
		enterRelationship(relationship);

		nextStep();
		return new CheckYourAnswerPage(driver);
	}

	public String getRelationshipNameDetails() {
		navigateToRootElement();
		navigateToElementBy(relationshipNameFieldLocator);
		return getElementValue();
	}

}

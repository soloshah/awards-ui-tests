package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DependantDetails_CheckYourAnswerPage extends Page {

	private By maritalStatusFieldLocator = By.id("maritalStatus.heading");
	private By partnerNameFieldLocator = By.id("whatIsYourPartnerName.heading");
	private By partnerDobFieldLocator = By.id("whatIsYourPartnerDob.static.heading");
	private By partnerGenderFieldLocator = By.id("partnerGender.static.heading");
	private By partnerNinoFieldLocator = By.id("whatIsYourPartnerNino.static.heading");
	private By dependantFieldLocator = By.id("anyDependantChildren.heading");
	private By allocationPensionFieldLocator = By.id("doYouWantToAllocatePension.heading");
	private By allocationNameFieldLocator = By.id("whatIsAllocationName.heading");
	private By allocationDOBFieldLocator = By.id("whatIsAllocationDOB.static.heading");
	private By allocationRelationshipFieldLocator = By.id("whatIsAllocationRelationship.static.heading");
	private By maritalStatusTextLocator = By.id("maritalStatus.heading-answer");
	private By partnerNameTextLocator = By.id("whatIsYourPartnerName.heading-answer");
	private By partnerDobTextLocator = By.id("whatIsYourPartnerDob.static.heading-answer");
	private By partnerGenderTextLocator = By.id("partnerGender.static.heading-answer");
	private By partnerNinoTextLocator = By.id("whatIsYourPartnerNino.static.heading-answer");
	private By dependantChildrenTextLocator = By.id("anyDependantChildren.heading-answer");
	private By allocationPensionTextLocator = By.id("doYouWantToAllocatePension.heading-answer");
	private By allocationNameTextLocator = By.id("whatIsAllocationName.heading-answer");
	private By allocationDobTextLocator = By.id("whatIsAllocationDOB.static.heading-answer");
	private By allocationRelationshipTextLocator = By.id("whatIsAllocationRelationship.static.heading-answer");

	public DependantDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForElementToBeVisibleBy(maritalStatusFieldLocator);
	}

	public boolean getPresenceOfMaritalStatus() {
		navigateToRootElement();
		return getPresenceOfElement(maritalStatusFieldLocator);
	}

	public boolean getPresenceOfPartnerName() {
		navigateToRootElement();
		return getPresenceOfElement(partnerNameFieldLocator);
	}

	public boolean getPresenceOfPartnerDOB() {
		navigateToRootElement();
		return getPresenceOfElement(partnerDobFieldLocator);
	}

	public boolean getPresenceOfPartnerGender() {
		navigateToRootElement();
		return getPresenceOfElement(partnerGenderFieldLocator);
	}

	public boolean getPresenceOfPartnerNino() {
		navigateToRootElement();
		return getPresenceOfElement(partnerNinoFieldLocator);
	}

	public boolean getPresenceOfDependantChildren() {
		navigateToRootElement();
		return getPresenceOfElement(dependantFieldLocator);
	}

	public boolean getPresenceOfAllocationPension() {
		navigateToRootElement();
		return getPresenceOfElement(allocationPensionFieldLocator);
	}

	public boolean getPresenceOfAllocationName() {
		navigateToRootElement();
		return getPresenceOfElement(allocationNameFieldLocator);
	}

	public boolean getPresenceOfAllocationDob() {
		navigateToRootElement();
		return getPresenceOfElement(allocationDOBFieldLocator);
	}

	public boolean getPresenceOfAllocationRelationship() {
		navigateToRootElement();
		return getPresenceOfElement(allocationRelationshipFieldLocator);
	}

	public String getMaritalStatus() {
		navigateToRootElement();
		navigateToElementBy(maritalStatusFieldLocator);
		return getElementText();
	}

	public String getPartnername() {
		navigateToRootElement();
		navigateToElementBy(partnerNameFieldLocator);
		return getElementText();
	}

	public String getPartnerDob() {
		navigateToRootElement();
		navigateToElementBy(partnerDobFieldLocator);
		return getElementText();
	}

	public String getPartnerGender() {
		navigateToRootElement();
		navigateToElementBy(partnerGenderFieldLocator);
		return getElementText();
	}

	public String getPartnerNino() {
		navigateToRootElement();
		navigateToElementBy(partnerNinoFieldLocator);
		return getElementText();
	}

	public String getDependantChildren() {
		navigateToRootElement();
		navigateToElementBy(dependantFieldLocator);
		return getElementText();
	}

	public String getAllocationPension() {
		navigateToRootElement();
		navigateToElementBy(allocationPensionFieldLocator);
		return getElementText();
	}

	public String getAllocationName() {
		navigateToRootElement();
		navigateToElementBy(allocationNameFieldLocator);
		return getElementText();
	}

	public String getAllocationDob() {
		navigateToRootElement();
		navigateToElementBy(allocationDOBFieldLocator);
		return getElementText();
	}

	public String getAllocationRelationship() {
		navigateToRootElement();
		navigateToElementBy(allocationRelationshipFieldLocator);
		return getElementText();
	}

	public String getMaritalStatusText() {
		navigateToRootElement();
		navigateToElementBy(maritalStatusTextLocator);
		return getElementText();
	}

	public String getPartnerNameText() {
		navigateToRootElement();
		navigateToElementBy(partnerNameTextLocator);
		return getElementText();
	}

	public String getPartnerDobText() {
		navigateToRootElement();
		navigateToElementBy(partnerDobTextLocator);
		return getElementText();
	}

	public String getPartnerGenderText() {
		navigateToRootElement();
		navigateToElementBy(partnerGenderTextLocator);
		return getElementText();
	}

	public String getPartnerNinoText() {
		navigateToRootElement();
		navigateToElementBy(partnerNinoTextLocator);
		return getElementText();
	}

	public String getDependantChildrenText() {
		navigateToRootElement();
		navigateToElementBy(dependantChildrenTextLocator);
		return getElementText();
	}

	public String getAllocationPensionText() {
		navigateToRootElement();
		navigateToElementBy(allocationPensionTextLocator);
		return getElementText();
	}

	public String getAllocationNameText() {
		navigateToRootElement();
		navigateToElementBy(allocationNameTextLocator);
		return getElementText();
	}

	public String getAllocationDobText() {
		navigateToRootElement();
		navigateToElementBy(allocationDobTextLocator);
		return getElementText();
	}

	public String getAllocationRelationshipText() {
		navigateToRootElement();
		navigateToElementBy(allocationRelationshipTextLocator);
		return getElementText();
	}

}

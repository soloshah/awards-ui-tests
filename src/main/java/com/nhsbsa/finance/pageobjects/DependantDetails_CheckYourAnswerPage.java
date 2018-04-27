package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DependantDetails_CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
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
	private By continueButtonLocator = By.id("continue_button");
	private By maritalStatusChangeLinkLocator = By.id("maritalStatus.heading-chgit snge");
	private By partnerNameChangeLinkLocator = By.id("whatIsYourPartnerName.heading-chgit snge");
	private By partnerDobChangeLinkLocator = By.id("whatIsYourPartnerDob.static.heading-chgit snge");
	private By partnerGenderChangeLinkLocator = By.id("partnerGender.static.heading-chgit snge");
	private By partnerNinoChangeLinkLocator = By.id("whatIsYourPartnerNino.static.heading-chgit snge");
	private By dependantChildrenChangeLinkLocator = By.id("anyDependantChildren.heading-chgit snge");
	private By allocationPensionChangeLinkLocator = By.id("doYouWantToAllocatePension.heading-chgit snge");
	private By allocationNameChangeLinkLocator = By.id("whatIsAllocationName.heading-chgit snge");
	private By allocationDobChangeLinkLocator = By.id("whatIsAllocationDOB.static.heading-chgit snge");
	private By allocationRelationshipChangeLinkLocator = By
			.id("whatIsAllocationRelationship.static.heading-chgit snge");
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
	
	private By getChangeLinkLocator(String page) {
		return By.id(page + ".heading-chgit snge"); 
	}
	
	public DependantDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(checkYouAnswersPageTitle);
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

	private void changeMaritalStatusLink() {
		navigateToRootElement();
		navigateToElementBy(maritalStatusChangeLinkLocator);
		click();
	}

	public Page changeLink(String page) {
		navigateToRootElement();
		navigateToElementBy(getChangeLinkLocator(page));
		return new Page(driver);
	}

	private void changePartnerNameLink() {
		navigateToRootElement();
		navigateToElementBy(partnerNameChangeLinkLocator);
		click();
	}

	public PartnerNamePage changePartnerName() {
		changePartnerNameLink();
		return new PartnerNamePage(driver);
	}

	private void changePartnerDobLink() {
		navigateToRootElement();
		navigateToElementBy(partnerDobChangeLinkLocator);
		click();
	}

	public DynamicDateOfBirthPage changePartnerDob() {
		changePartnerDobLink();
		return new DynamicDateOfBirthPage(driver);
	}

	private void changePartnerGenderLink() {
		navigateToRootElement();
		navigateToElementBy(partnerGenderChangeLinkLocator);
		click();
	}

	public PartnerGenderPage changePartnerGender() {
		changePartnerGenderLink();
		return new PartnerGenderPage(driver);
	}

	private void changePartnerNinoLink() {
		navigateToRootElement();
		navigateToElementBy(partnerNinoChangeLinkLocator);
		click();
	}

	public DynamicNinoPage changePartnerNino() {
		changePartnerNinoLink();
		return new DynamicNinoPage(driver);
	}

	private void changeDependantChildrenLink() {
		navigateToRootElement();
		navigateToElementBy(dependantChildrenChangeLinkLocator);
		click();
	}

	public DependantChildrenPage changeDependantChildren() {
		changeDependantChildrenLink();
		return new DependantChildrenPage(driver);
	}

	private void changeAllocationPensionLink() {
		navigateToRootElement();
		navigateToElementBy(allocationPensionChangeLinkLocator);
		click();
	}

	public AllocatePensionPage changeAllocationPension() {
		changeAllocationPensionLink();
		return new AllocatePensionPage(driver);
	}

	private void changeAllocationNameLink() {
		navigateToRootElement();
		navigateToElementBy(allocationNameChangeLinkLocator);
		click();
	}

	public AllocationNamePage changeAllocationName() {
		changeAllocationNameLink();
		return new AllocationNamePage(driver);
	}

	private void changeAllocationDOBLink() {
		navigateToRootElement();
		navigateToElementBy(allocationDobChangeLinkLocator);
		click();
	}

	public DynamicAllocationPage changeAllocationDOB() {
		changeAllocationDOBLink();
		return new DynamicAllocationPage(driver);
	}

	private void changeAllocationRelationshipLink() {
		navigateToRootElement();
		navigateToElementBy(allocationRelationshipChangeLinkLocator);
		click();
	}

	public DynamicAllocationRelationshipPage changeAllocationRelationship() {
		changeAllocationRelationshipLink();
		return new DynamicAllocationRelationshipPage(driver);
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

	public SummaryPage submitDependantDetails() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
		return new SummaryPage(driver);
	}
}

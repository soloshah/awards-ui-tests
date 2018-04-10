package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployerAddressPage extends Page {

	private String employerAddressPageTitle = "What is your employer's address? - Claim your NHS Pension - NHSBSA";
	private By streetLine1FieldLocator = By.id("addr1");
	private By streetLine2FieldLocator = By.id("addr2");
	private By townFieldLocator = By.id("town");
	private By postCodeFieldLocator = By.id("postcode");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By streetLine1FieldErrorMessageLocator = By.id("addr1-error-message");
	private By streetLine1AnchoredErrorMessageLocator = By.id("error-list0");
	private By streetLine1AnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#addr1']");
	private By streetLine2FieldErrorMessageLocator = By.id("addr2-error-message");
	private By streetLine2AnchoredErrorMessageLocator = By.id("error-list1");
	private By streetLine2rAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#addr2']");
	private By townFieldErrorMessageLocator = By.id("town-error-message");
	private By townAnchoredErrorMessageLocator = By.id("error-list2");
	private By townAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#town']");
	private By postCodeFieldErrorMessageLocator = By.id("postcode-error-message");
	private By postCodeAnchoredErrorMessageLocator = By.id("error-list3");
	private By postCodeAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#postcode']");

	public EmployerAddressPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(employerAddressPageTitle);
		waitForElementToBeVisibleBy(streetLine1FieldLocator);
	}

	public void enterStreetLine1(String streetLineOne) {
		navigateToRootElement();
		navigateToElementBy(streetLine1FieldLocator);
		type(streetLineOne);
	}

	public void enterStreetLine2(String streetLineTwo) {
		navigateToRootElement();
		navigateToElementBy(streetLine2FieldLocator);
		type(streetLineTwo);
	}

	public void enterTown(String town) {
		navigateToRootElement();
		navigateToElementBy(townFieldLocator);
		type(town);
	}

	public void enterPostCode(String postCode) {
		navigateToRootElement();
		navigateToElementBy(postCodeFieldLocator);
		type(postCode);
	}

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public void enterEmployerAddressDetails(String streetLineOne, String streetLineTwo, String town, String postCode) {
		enterStreetLine1(streetLineOne);
		enterStreetLine2(streetLineTwo);
		enterTown(town);
		enterPostCode(postCode);
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

	public boolean doesStreetLineOneErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(streetLine1AnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(streetLine1AnchoredErrorMessageAnchorLocator);
	}

	public boolean doesStreetLineTwoErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(streetLine2AnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(streetLine2rAnchoredErrorMessageAnchorLocator);
	}

	public boolean doesTownErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(townAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(townAnchoredErrorMessageAnchorLocator);
	}

	public boolean doesPostCodeErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(postCodeAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(postCodeAnchoredErrorMessageAnchorLocator);
	}

	public String getStreetLineOneAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(streetLine1AnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getStreetLineTwoAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(streetLine2AnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getTownAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(townAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getPostCodeAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(postCodeAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getStreetLineOneFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(streetLine1FieldErrorMessageLocator);
		return getElementText();
	}

	public String getStreetLineTwoFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(streetLine2FieldErrorMessageLocator);
		return getElementText();
	}

	public String getTownFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(townFieldErrorMessageLocator);
		return getElementText();
	}

	public String getPostCodeFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(postCodeFieldErrorMessageLocator);
		return getElementText();
	}
	
	
	public String getAddressLineOneDetails() {
		navigateToRootElement();
		navigateToElementBy(streetLine1FieldLocator);
		return getElementValue();
	}

	public String getAddressLineTwoDetails() {
		navigateToRootElement();
		navigateToElementBy(streetLine2FieldLocator);
		return getElementValue();
	}

	public String getAddressTownDetails() {
		navigateToRootElement();
		navigateToElementBy(townFieldLocator);
		return getElementValue();
	}

	public String getAddressPostcodeDetails() {
		navigateToRootElement();
		navigateToElementBy(postCodeFieldLocator);
		return getElementValue();
	}

	public LastDayOfWorkPage submitValidAddressDetails(String streetLineOne, String streetLineTwo, String town, String postCode) {
		enterEmployerAddressDetails(streetLineOne, streetLineTwo, town, postCode);
		nextStep();
		return new LastDayOfWorkPage(driver);
	}

	public EmployerAddressPage submitInValidEmployerAddressDetails() {
		nextStep();
		return new EmployerAddressPage(driver);
	}


}

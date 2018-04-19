package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicNinoPage extends Page {

	private String fname = "Arya";
	private String partnerNinoPageTitle = "What is " + fname + "'s " + "National Insurance number? - Claim your NHS Pension - NHSBSA";
	private By partnerNinoFieldLocator = By.id("nino");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");

	public DynamicNinoPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(partnerNinoPageTitle);
		waitForElementToBeVisibleBy(partnerNinoFieldLocator);
	}

	
	public void enterPartnerNino(String nino) {
		navigateToRootElement();
		navigateToElementBy(partnerNinoFieldLocator);
		type(nino);
	}
	
	
	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}
	
	
	public DynamicNinoPage submitInValidNinoDetails() {
		nextStep();
		return new DynamicNinoPage(driver);
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
	
	public DependantChildrenPage submitValidNiDetails(String nino) {
		enterPartnerNino(nino);
		nextStep();
		return new DependantChildrenPage(driver);
	}
	
	public DynamicNinoPage submitNino(String nino) {
		enterPartnerNino(nino);
		nextStep();
		return new DynamicNinoPage(driver);
	}
	
	public String getNino() {
		navigateToRootElement();
		navigateToElementBy(partnerNinoFieldLocator);
		return getElementValue();
	}
}

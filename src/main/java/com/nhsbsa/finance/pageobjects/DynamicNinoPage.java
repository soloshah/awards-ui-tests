package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nhsbsa.finance.pageobjects.Page;

public class DynamicNinoPage extends Page {

	String fName = "Partner-Test";
	private String partnerNinoPageTitle = "What is " + fName + "'s " +  "National Insurance number? - Claim your NHS Pension";
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
	
	
	private void nextStep() {
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
	
	
}

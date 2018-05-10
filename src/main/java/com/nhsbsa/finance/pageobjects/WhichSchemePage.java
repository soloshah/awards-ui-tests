package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhichSchemePage extends Page {

	private String whichSchemePageTitle = "Which Section or Scheme are you claiming benefits from? - Claim your NHS Pension - NHSBSA";
	private By section1995CheckboxLocator = By.xpath("//*[@id='scheme0']");
	private By section2008CheckboxLocator = By.xpath("//*[@id='scheme1']");
	private By section2015CheckboxLocator = By.xpath("//*[@id='scheme2']");
	private By nextButtonLocator = By.id("submit_button");
	private By backButtonLocator = By.id("back-link");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By whichSchemeFieldErrorMessageLocator = By.id("fieldName-error-message");
	private By whichSchemeAnchoredErrorMessageLocator = By.id("error-list0");
	private By whichSchemeAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#errorMessage']");
	private By schemeInformationLink = By.linkText("scheme identifier tool (opens in a new window)");
	private By selected1995CheckBoxLocator = By.xpath("//input[@checked='checked']");
    
    
	public WhichSchemePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(whichSchemePageTitle);
		waitForElementToBeVisibleBy(backButtonLocator);
	}

	public void select1995Section() {
		navigateToRootElement();
		navigateToElementBy(section1995CheckboxLocator);
		click();
	}

	public void select2008Section() {
		navigateToRootElement();
		navigateToElementBy(section2008CheckboxLocator);
		click();
	}

	public void select2015Section() {
		navigateToRootElement();
		navigateToElementBy(section2015CheckboxLocator);
		click();
	}

	private void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public void selectSchemeInformation() {
		navigateToRootElement();
		navigateToElementBy(schemeInformationLink);
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

	public boolean doesWhichSchemeErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(whichSchemeAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(whichSchemeAnchoredErrorMessageAnchorLocator);
	}

	public String getWhichSchemeAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(whichSchemeAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getWhichSchemeFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(whichSchemeFieldErrorMessageLocator);
		return getElementText();
	}

	public void selectWhichScheme() {
		nextStep();

	}

	public WhichSchemePage isWhichSchemeNotSelected() {
		nextStep();
		return new WhichSchemePage(driver);
	}

	
	public boolean is1995CheckboxSelected() {
		navigateToRootElement();
		boolean checked=isElementSelected(selected1995CheckBoxLocator);

	return checked;

		}
	


}

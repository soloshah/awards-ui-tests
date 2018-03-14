package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtherEqPensionsPage extends Page {

	private String otherEqPensionsTitle = "Do you have any other pensions paid by Equiniti Paymaster? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[2]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By eqPensionsAnchoredErrorMessageLocator = By.id("error-list0");
	private By eqPensionsAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#yesNo']");
	private By eqPensionsFieldErrorMessageLocator = By.id("fieldName-error-message");

	public OtherEqPensionsPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(otherEqPensionsTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}

	public OtherEqPensionsPage otherEqPensionsIsNotSelected() {
		nextStep();
		return new OtherEqPensionsPage(driver);
	}

	public boolean isOtherEqPensionsRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

	public TBIPage selectYesButton() {
		navigateToRootElement();
		navigateToElementBy(yesRadioButtonLocator);
		click();
		nextStep();
		return new TBIPage(driver);
	}

	public TBIPage selectNoButton() {
		navigateToRootElement();
		navigateToElementBy(noRadioButtonLocator);
		click();
		nextStep();
		return new TBIPage(driver);
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

	private void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public String getOtherEqPensionsFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(eqPensionsFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesOtherEqPensionsErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(eqPensionsAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(eqPensionsAnchoredErrorMessageAnchorLocator);
	}

	public String getOtherEqPensionsAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(eqPensionsAnchoredErrorMessageLocator);
		return getElementText();
	}
}

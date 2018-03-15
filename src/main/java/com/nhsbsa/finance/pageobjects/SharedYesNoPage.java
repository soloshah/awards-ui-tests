package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SharedYesNoPage extends Page {

	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[2]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By sharedAnchoredErrorMessageLocator = By.id("error-list0");
	private By sharedAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#yesNo']");
	private By sharedFieldErrorMessageLocator = By.id("fieldName-error-message");

	public SharedYesNoPage(WebDriver driver) {
		super(driver);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}
	
	public void radioButtonIsNotSelected() {
		nextStep();
		}

	public void selectYes() {
		navigateToRootElement();
		navigateToElementBy(yesRadioButtonLocator);
		click();
		nextStep();
	}
	

	public void selectNo() {
		navigateToRootElement();
		navigateToElementBy(noRadioButtonLocator);
		click();
		nextStep();
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

	public String getSharedFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(sharedFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesSharedErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(sharedAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(sharedAnchoredErrorMessageAnchorLocator);
	}

	public String getSharedAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(sharedAnchoredErrorMessageLocator);
		return getElementText();
	}
}

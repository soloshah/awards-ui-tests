package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WouldYouLikeToBeContactedPage extends Page {

	private String wouldYouLikeToBeContactedTitle = "How would you like to be contacted about your pension? - Claim your NHS Pension - NHSBSA";
	private By byPhoneCheckboxLocator = By.xpath("//*[@id='contactPref_group']/div[1]/label");
	private By byEmailCheckboxLocator = By.xpath("//*[@id='contactPref_group']/div[2]/label");
	private By noContactCheckboxLocator = By.xpath("//*[@id='contactPref_group']/div[3]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By contactAnchoredErrorMessageLocator = By.id("error-list0");
	private By contactAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#errorMessage']");
	private By contactFieldErrorMessageLocator = By.id("fieldName-error-message");

	public WouldYouLikeToBeContactedPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(wouldYouLikeToBeContactedTitle);
		waitForElementToBeVisibleBy(byPhoneCheckboxLocator);
	}

	public WouldYouLikeToBeContactedPage wouldYouLikeToBeContactedIsNotSelected() {
		nextStep();
		return new WouldYouLikeToBeContactedPage(driver);
	}

	public boolean isWouldYouLikeToBeContactedCheckboxSelected() {
		boolean selected = true;

		if (!isElementSelected(byPhoneCheckboxLocator) && !isElementSelected(byEmailCheckboxLocator)
				&& !isElementSelected(noContactCheckboxLocator))
			selected = false;
		return selected;
	}

	public TelephoneNumberPage selectByPhoneCheckbox() {
		navigateToRootElement();
		navigateToElementBy(byPhoneCheckboxLocator);
		click();
		nextStep();
		return new TelephoneNumberPage(driver);
	}

	public EmailAddressPage selectByEmailCheckbox() {
		navigateToRootElement();
		navigateToElementBy(byEmailCheckboxLocator);
		click();
		nextStep();
		return new EmailAddressPage(driver);
	}

	public void selectByPhoneAndByEmailCheckbox() {
		navigateToRootElement();
		navigateToElementBy(byPhoneCheckboxLocator);
		click();
		navigateToRootElement();
		navigateToElementBy(byEmailCheckboxLocator);
		click();

	}

	public TelephoneNumberPage selectByPhoneAndEmailCheckbox() {
		selectByPhoneAndByEmailCheckbox();
		nextStep();
		return new TelephoneNumberPage(driver);
	}

	public TBIPage selectNotToBeContactedCheckbox() {
		navigateToRootElement();
		navigateToElementBy(noContactCheckboxLocator);
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

	public String getContactFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(contactFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesContactErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(contactAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(contactAnchoredErrorMessageAnchorLocator);
	}

	public String getContactAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(contactAnchoredErrorMessageLocator);
		return getElementText();
	}
}

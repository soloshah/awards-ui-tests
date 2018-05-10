package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WouldYouLikeToBeContactedPage extends Page {

	private String wouldYouLikeToBeContactedTitle = "How would you like to be contacted about your pension? - Claim your NHS Pension - NHSBSA";
	private By byPhoneCheckboxLocator = By.id("contactPref0");
	private By byEmailCheckboxLocator = By.id("contactPref1");
	private By nextButtonLocator = By.id("submit_button");
	private By backButtonLocator =  By.id("back-link");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By contactAnchoredErrorMessageLocator = By.id("error-list0");
	private By contactAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#errorMessage']");
	private By contactFieldErrorMessageLocator = By.id("fieldName-error-message");
	private By selectedEmailCheckBoxLocator = By.xpath("//input[@checked='checked']");
	private By selectedPhoneCheckBoxLocator = By.xpath("//input[@checked='checked']");

	
	public WouldYouLikeToBeContactedPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(wouldYouLikeToBeContactedTitle);
		waitForElementToBeVisibleBy(backButtonLocator);
	}

	public WouldYouLikeToBeContactedPage wouldYouLikeToBeContactedIsNotSelected() {
		nextStep();
		return new WouldYouLikeToBeContactedPage(driver);
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

	
	public void  deselectEmail(){
		navigateToRootElement();
		navigateToElementBy(byEmailCheckboxLocator);
		click();
		nextStep();
		
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

	public void nextStep() {
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
	
	
	
	public boolean isEmailCheckboxSelected() {
		navigateToRootElement();
		boolean checked=isElementSelected(selectedEmailCheckBoxLocator);

	return checked;

		}
	
	
	public boolean isPhoneCheckboxSelected() {
		navigateToRootElement();
		boolean checked= isElementSelected(selectedPhoneCheckBoxLocator);
    
          return checked;
	}


}

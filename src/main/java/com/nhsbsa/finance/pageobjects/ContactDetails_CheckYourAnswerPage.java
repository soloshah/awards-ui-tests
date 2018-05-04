package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetails_CheckYourAnswerPage extends Page {

	private By contactPrefFieldLocator = By.id("contactDetails.checkYourAnswers.contactPref");
	private By emailFieldLocator = By.id("contactDetails.checkYourAnswers.email");
	private By phoneFieldLocator = By.id("contactDetails.checkYourAnswers.phone");
	private By contactPrefEmailTextLocator = By.id("Email");
	private By contactPrefPhoneTextLocator = By.id("Phone");
	private By ContactPrefTextLocator = By.id("contactDetails.checkYourAnswers.contactPref-answer");
	private By emailTextLocator = By.id("contactDetails.checkYourAnswers.email-answer");
	private By phoneTextLocator = By.id("contactDetails.checkYourAnswers.phone-answer");

	public ContactDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForElementToBeVisibleBy(contactPrefFieldLocator);
	}

	public boolean getPresenceOfContactPref() {
		navigateToRootElement();
		return getPresenceOfElement(contactPrefFieldLocator);
	}

	public boolean getPresenceOfContactPrefEmail() {
		navigateToRootElement();
		return getPresenceOfElement(emailFieldLocator);
	}

	public boolean getPresenceOfContactPrefPhone() {
		navigateToRootElement();
		return getPresenceOfElement(phoneFieldLocator);
	}

	public String getContactPrefText() {
		navigateToRootElement();
		navigateToElementBy(contactPrefFieldLocator);
		return getElementText();
	}

	public String getEmailText() {
		navigateToRootElement();
		navigateToElementBy(emailFieldLocator);
		return getElementText();
	}

	public String getPhoneText() {
		navigateToRootElement();
		navigateToElementBy(phoneFieldLocator);
		return getElementText();
	}

	public String getContactPref() {
		navigateToRootElement();
		navigateToElementBy(ContactPrefTextLocator);
		return getElementText();
	}

	public String getContactPrefEmail() {
		navigateToRootElement();
		navigateToElementBy(contactPrefEmailTextLocator);
		return getElementText();
	}

	public String getContactPrefPhone() {
		navigateToRootElement();
		navigateToElementBy(contactPrefPhoneTextLocator);
		return getElementText();
	}

	public String getEmailAddressText() {
		navigateToRootElement();
		navigateToElementBy(emailTextLocator);
		return getElementText();
	}

	public String getPhoneNumberText() {
		navigateToRootElement();
		navigateToElementBy(phoneTextLocator);
		return getElementText();
	}

}

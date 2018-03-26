package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetails_CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
	private By contactPrefFieldLocator = By.id("contactDetails.checkYourAnswers.contactPref");
	private By emailFieldLocator = By.id("contactDetails.checkYourAnswers.email");
	private By phoneFieldLocator = By.id("contactDetails.checkYourAnswers.phone");
	private By continueButtonLocator = By.id("continue_button");
	private By contactPrefChangeLinkLocator = By.id("contactDetails.checkYourAnswers.contactPref-change");
	private By emailChangeLinkLocator = By.id("contactDetails.checkYourAnswers.email-change");
	private By phoneChangeLinkLocator = By.id("contactDetails.checkYourAnswers.phone-change");
	private By contactPrefEmailTextLocator = By.id("Email");
	private By contactPrefPhoneTextLocator = By.id("Phone");
	private By ContactPrefTextLocator = By.id("contactDetails.checkYourAnswers.contactPref-answer");
	private By emailTextLocator = By.id("contactDetails.checkYourAnswers.email-answer");
	private By phoneTextLocator = By.id("contactDetails.checkYourAnswers.phone-answer");


	public ContactDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(checkYouAnswersPageTitle);
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

		
	private void changeContactPrefLink() {
		navigateToRootElement();
		navigateToElementBy(contactPrefChangeLinkLocator);
		click();
	}

	public WouldYouLikeToBeContactedPage changeContactPrefDetails() {
		changeContactPrefLink();
		return new WouldYouLikeToBeContactedPage(driver);
	}

	private void changeEmailAddressLink() {
		navigateToRootElement();
		navigateToElementBy(emailChangeLinkLocator);
		click();
	}

	public EmailAddressPage changeEmailAddressDetails() {
		changeEmailAddressLink();
		return new EmailAddressPage(driver);
	}

	private void changeTelephoneNumberLink() {
		navigateToRootElement();
		navigateToElementBy(phoneChangeLinkLocator);
		click();
	}

	public TelephoneNumberPage changeTelephonNumberDetails() {
		changeTelephoneNumberLink();
		return new TelephoneNumberPage(driver);
	}

	public SummaryPage submitContactDetails() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
		return new SummaryPage(driver);
	}
}

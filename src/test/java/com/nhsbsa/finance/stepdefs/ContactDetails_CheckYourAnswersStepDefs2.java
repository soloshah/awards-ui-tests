package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ContactDetails_CheckYourAnswerPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class ContactDetails_CheckYourAnswersStepDefs2 {

	private WebDriver driver = Config.getDriver();
	private ContactDetails_CheckYourAnswerPage contactDetails_CheckYourAnswerPage;
	private StartPageStepdefs startSteps;
	private WouldYouLikeToBeContactedStepDefs contactPrefSteps;
	private TelephoneNumberStepDefs phoneSteps;
	private EmailAddressStepDefs emailSteps;

	@Given("^I have filled in a contact details$")
	public void iHaveFilledInAContactDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		contactPrefSteps = new WouldYouLikeToBeContactedStepDefs();
		contactPrefSteps.iGoToWouldYouLikeToBeContactedPage();
		contactPrefSteps.iSelectByPhoneAndEmail();
		phoneSteps = new TelephoneNumberStepDefs();
		phoneSteps.whatisYourTelephoneNumberPageWillBeDisplayed();
		phoneSteps.IenterValidTelephoneNumberDetails();
		emailSteps = new EmailAddressStepDefs();
		emailSteps.whatisYourEmailAddressPageWillBeDisplayed();
		emailSteps.IenterValidEmailAddressDetails();

	}

	@Given("^I have filled in a contact details for summary page$")
	public void iHaveFilledInAContactDetailsForSummaryPage() throws Throwable {
		contactPrefSteps = new WouldYouLikeToBeContactedStepDefs();
		contactPrefSteps.wouldYouLikeToBeContactedPageWillBeDisplayed();
		contactPrefSteps.iSelectByPhoneAndEmail();
		phoneSteps = new TelephoneNumberStepDefs();
		phoneSteps.whatisYourTelephoneNumberPageWillBeDisplayed();
		phoneSteps.IenterValidTelephoneNumberDetails();
		emailSteps = new EmailAddressStepDefs();
		emailSteps.whatisYourEmailAddressPageWillBeDisplayed();
		emailSteps.IenterValidEmailAddressDetails();

	}

	@And("^would you like to be contacted details will be displayed$")
	public void wouldYouLikeToBeContactedDetailsWillBeDisplayed() {
		contactDetails_CheckYourAnswerPage = new ContactDetails_CheckYourAnswerPage(driver);
		assertThat(contactDetails_CheckYourAnswerPage.getPresenceOfContactPref()).isEqualTo(true);
		assertThat(contactDetails_CheckYourAnswerPage.getContactPrefText())
				.matches("How would you like to be contacted about your pension");
		assertThat(contactDetails_CheckYourAnswerPage.getContactPref()).matches("I would not like to be contacted");
	}

	@And("^Check your answers page with telephone contact details will be displayed$")
	public void checkYourAnswersPageWithTelephoneContactDetailsWillBeDisplayed() {
		contactDetails_CheckYourAnswerPage = new ContactDetails_CheckYourAnswerPage(driver);
		assertThat(contactDetails_CheckYourAnswerPage.getPresenceOfContactPref()).isEqualTo(true);
		assertThat(contactDetails_CheckYourAnswerPage.getContactPrefText())
				.matches("How would you like to be contacted about your pension");
		assertThat(contactDetails_CheckYourAnswerPage.getContactPref()).matches("Phone");
		assertThat(contactDetails_CheckYourAnswerPage.getPresenceOfContactPrefPhone()).isEqualTo(true);
		assertThat(contactDetails_CheckYourAnswerPage.getPhoneText()).matches("Phone number");
		assertThat(contactDetails_CheckYourAnswerPage.getPhoneNumberText()).matches(SharedData.phoneNumber);

	}

	@And("^Check your answers page with email contact details will be displayed$")
	public void checkYourAnswersPageWithEmailContactDetailsWillBeDisplayed() {
		contactDetails_CheckYourAnswerPage = new ContactDetails_CheckYourAnswerPage(driver);
		assertThat(contactDetails_CheckYourAnswerPage.getPresenceOfContactPref()).isEqualTo(true);
		assertThat(contactDetails_CheckYourAnswerPage.getContactPrefText())
				.matches("How would you like to be contacted about your pension");
		assertThat(contactDetails_CheckYourAnswerPage.getContactPref()).matches("Email");

		assertThat(contactDetails_CheckYourAnswerPage.getPresenceOfContactPrefEmail()).isEqualTo(true);
		assertThat(contactDetails_CheckYourAnswerPage.getEmailText()).matches("Email address");
		assertThat(contactDetails_CheckYourAnswerPage.getEmailAddressText()).matches(SharedData.emailAddress);

	}

	@And("^Check your answers page with telephone and email contact details will be displayed$")
	public void checkYourAnswersPageWithTelephoneAndEmailContactDetailsWillBeDisplayed() {
		contactDetails_CheckYourAnswerPage = new ContactDetails_CheckYourAnswerPage(driver);
		assertThat(contactDetails_CheckYourAnswerPage.getPresenceOfContactPref()).isEqualTo(true);
		assertThat(contactDetails_CheckYourAnswerPage.getContactPrefText())
				.matches("How would you like to be contacted about your pension");
		assertThat(contactDetails_CheckYourAnswerPage.getContactPref()).matches("Email\nPhone");

		assertThat(contactDetails_CheckYourAnswerPage.getPresenceOfContactPrefPhone()).isEqualTo(true);
		assertThat(contactDetails_CheckYourAnswerPage.getPhoneText()).matches("Phone number");
		assertThat(contactDetails_CheckYourAnswerPage.getPhoneNumberText()).matches(SharedData.phoneNumber);

		assertThat(contactDetails_CheckYourAnswerPage.getPresenceOfContactPrefEmail()).isEqualTo(true);
		assertThat(contactDetails_CheckYourAnswerPage.getEmailText()).matches("Email address");
		assertThat(contactDetails_CheckYourAnswerPage.getEmailAddressText()).matches(SharedData.emailAddress);

	}

	@And("^the changed (.*) will be displayed$")
	public void theChangedDetailsWillBeDisplayed(String field) {
		contactDetails_CheckYourAnswerPage = new ContactDetails_CheckYourAnswerPage(driver);

		switch (field) {
		case "emailAddress":
			assertThat(contactDetails_CheckYourAnswerPage.getEmailAddressText()).matches(SharedData.emailAddress);
			break;
		case "telephoneNumber":
			assertThat(contactDetails_CheckYourAnswerPage.getPhoneNumberText()).matches(SharedData.phoneNumber);
			break;
		}
	}

	@And("^I fill in the telephone number and email address details$")
	public void iFillInTheTelephoneNumberAndEmailAddressDetails() {
		phoneSteps = new TelephoneNumberStepDefs();
		phoneSteps.whatisYourTelephoneNumberPageWillBeDisplayed();
		phoneSteps.IenterValidTelephoneNumberDetails();
		emailSteps = new EmailAddressStepDefs();
		emailSteps.whatisYourEmailAddressPageWillBeDisplayed();
		emailSteps.IenterValidEmailAddressDetails();

	}

	@And("^I navigate from telephone number page to check your answers page$")
	public void InavigateFromTelephoneNumberPageToCheckYourAnswersPage() {
		emailSteps = new EmailAddressStepDefs();
		emailSteps.whatisYourEmailAddressPageWillBeDisplayed();
		emailSteps.iClickNextOnEmailAddressPage();

	}

}
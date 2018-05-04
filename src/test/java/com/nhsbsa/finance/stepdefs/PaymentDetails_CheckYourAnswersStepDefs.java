package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.PaymentDetails_CheckYourAnswerPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PaymentDetails_CheckYourAnswersStepDefs {

	private WebDriver driver = Config.getDriver();

	private PaymentDetails_CheckYourAnswerPage paymentDetails_CheckYourAnswersPage;
	private StartPageStepdefs startSteps;
	private BankAccountTypeStepDefs bankAccountTypeSteps;
	private DepositAccountStepDefs depositAccountSteps;
	private CurrentAccountStepDefs currentAccountSteps;
	private OtherEqPensionsStepDefs otherEqPensionsSteps;
	private SharedYeNoStepDefs sharedYesNoSteps;
	private EqPaymasterNameStepDefs eqPaymasterNameSteps;
	private EqPaymasterReferenceStepDefs eqPaymasterReferenceSteps;

	@Given("^I have filled in a payment details$")
	public void iHaveFilledInAPaymentDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		bankAccountTypeSteps = new BankAccountTypeStepDefs();
		bankAccountTypeSteps.iGoToBankAccountTypePage();
		bankAccountTypeSteps.iSelectDepositAccount();
		depositAccountSteps = new DepositAccountStepDefs();
		depositAccountSteps.enterBankDetailsForDepositAccountPageWillBeDisplayed();
		depositAccountSteps.IenterValidDepositAccountDetails();
		otherEqPensionsSteps = new OtherEqPensionsStepDefs();
		otherEqPensionsSteps.theOtherEqpensionsPageWillbeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		eqPaymasterNameSteps = new EqPaymasterNameStepDefs();
		eqPaymasterNameSteps.theEqPaymasterNamePageWillBeDisplayed();
		eqPaymasterNameSteps.IenterValidEqPaymasterNameDetails();
		eqPaymasterReferenceSteps = new EqPaymasterReferenceStepDefs();
		eqPaymasterReferenceSteps.theEqPaymasterReferencePageWillBeDisplayed();
		eqPaymasterReferenceSteps.IenterValidEqPaymasterReferenceNumber();
	}

	@Given("^I have filled in a payment details for summary page$")
	public void iHaveFilledInAPaymentDetailsForSummaryPage() throws Throwable {
		bankAccountTypeSteps = new BankAccountTypeStepDefs();
		bankAccountTypeSteps.theBankAccountTypePageWillBeDisplayed();
		bankAccountTypeSteps.iSelectDepositAccount();
		depositAccountSteps = new DepositAccountStepDefs();
		depositAccountSteps.enterBankDetailsForDepositAccountPageWillBeDisplayed();
		depositAccountSteps.IenterValidDepositAccountDetails();
		otherEqPensionsSteps = new OtherEqPensionsStepDefs();
		otherEqPensionsSteps.theOtherEqpensionsPageWillbeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		eqPaymasterNameSteps = new EqPaymasterNameStepDefs();
		eqPaymasterNameSteps.theEqPaymasterNamePageWillBeDisplayed();
		eqPaymasterNameSteps.IenterValidEqPaymasterNameDetails();
		eqPaymasterReferenceSteps = new EqPaymasterReferenceStepDefs();
		eqPaymasterReferenceSteps.theEqPaymasterReferencePageWillBeDisplayed();
		eqPaymasterReferenceSteps.IenterValidEqPaymasterReferenceNumber();
	}

	@Then("^the correct payment details will be displayed$")
	public void theCorrectPaymentDetailsWillBeDisplayed() {
		paymentDetails_CheckYourAnswersPage = new PaymentDetails_CheckYourAnswerPage(driver);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfAccountType()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getAccountType()).matches(SharedData.accountType);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfAccountHolderName()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getAccountHolderName()).matches(SharedData.accountHolderName);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfAccountNumber()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getAccountNumber()).matches(SharedData.accountNumber);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfRollNumber()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getRollNumber()).matches(SharedData.rollNumber);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfSortCode()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getSortCode()).matches(
				SharedData.sortCodeFirstField + SharedData.sortCodeSecondField + SharedData.sortCodeThirdField);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfOtherEqPension()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getOtherEqPension()).matches(SharedData.sharedRadioButton);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfEqPaymasterName()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getEqPaymasterName()).matches(SharedData.eqPaymasterName);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfEqPaymasterRef()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getEqPaymasterRef()).matches(SharedData.eqPaymasterRef);

	}

	@And("^the updated (.*) details will be displayed$")
	public void theUpdatedDetailsWillBeDisplayed(String field) {
		paymentDetails_CheckYourAnswersPage = new PaymentDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "accountType":
			assertThat(paymentDetails_CheckYourAnswersPage.getAccountType()).matches(SharedData.accountType);
			break;
		case "currentAccount":
			assertThat(paymentDetails_CheckYourAnswersPage.getAccountHolderName())
					.matches(SharedData.accountHolderName);
			assertThat(paymentDetails_CheckYourAnswersPage.getAccountNumber()).matches(SharedData.accountNumber);
			assertThat(paymentDetails_CheckYourAnswersPage.getSortCode()).matches(
					SharedData.sortCodeFirstField + SharedData.sortCodeSecondField + SharedData.sortCodeThirdField);
			break;
		case "otherEqPension":
			assertThat(paymentDetails_CheckYourAnswersPage.getOtherEqPension()).matches(SharedData.sharedRadioButton);
			break;
		case "eqPaymasterName":

			assertThat(paymentDetails_CheckYourAnswersPage.getEqPaymasterName()).matches(SharedData.eqPaymasterName);
			break;
		case "eqPaymasterReference":

			assertThat(paymentDetails_CheckYourAnswersPage.getEqPaymasterRef()).matches(SharedData.eqPaymasterRef);
			break;
		}
	}

	@And("^I navigate from accountType page to check your answers page$")
	public void InavigateFromAccountTypePageToCheckYourAnswersPage() {
		currentAccountSteps = new CurrentAccountStepDefs();
		currentAccountSteps.enterBankDetailsForCurrentAccountPageWillBeDisplayed();
		currentAccountSteps.IenterValidCurrentAccountDetails();
		otherEqPensionsSteps = new OtherEqPensionsStepDefs();
		otherEqPensionsSteps.theOtherEqpensionsPageWillbeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectNo();

	}

	@Then("^the correct payment with current account details will be displayed$")
	public void theCorrectPaymentWithCurrentAccountDetailsWillBeDisplayed() {
		paymentDetails_CheckYourAnswersPage = new PaymentDetails_CheckYourAnswerPage(driver);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfAccountType()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getAccountType()).matches(SharedData.accountType);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfAccountHolderName()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getAccountHolderName()).matches(SharedData.accountHolderName);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfAccountNumber()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getAccountNumber()).matches(SharedData.accountNumber);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfSortCode()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getSortCode()).matches(
				SharedData.sortCodeFirstField + SharedData.sortCodeSecondField + SharedData.sortCodeThirdField);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfOtherEqPension()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getOtherEqPension()).matches(SharedData.sharedRadioButton);

	}

	@Then("^the correct payment details with deposit account details will be displayed$")
	public void theCorrectPaymentWithDepositAccountDetailsWillBeDisplayed() {
		paymentDetails_CheckYourAnswersPage = new PaymentDetails_CheckYourAnswerPage(driver);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfAccountType()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getAccountType()).matches(SharedData.accountType);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfAccountHolderName()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getAccountHolderName()).matches(SharedData.accountHolderName);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfAccountNumber()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getAccountNumber()).matches(SharedData.accountNumber);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfRollNumber()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getRollNumber()).matches(SharedData.rollNumber);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfSortCode()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getSortCode()).matches(
				SharedData.sortCodeFirstField + SharedData.sortCodeSecondField + SharedData.sortCodeThirdField);
		assertThat(paymentDetails_CheckYourAnswersPage.getPresenceOfOtherEqPension()).isEqualTo(true);
		assertThat(paymentDetails_CheckYourAnswersPage.getOtherEqPension()).matches(SharedData.sharedRadioButton);

	}

	@And("^I navigate from bank details page to check your answers page$")
	public void InavigateFrombankDetailsPageToCheckYourAnswersPage() {
		otherEqPensionsSteps = new OtherEqPensionsStepDefs();
		otherEqPensionsSteps.theOtherEqpensionsPageWillbeDisplayed();
		sharedYesNoSteps.iClickNextOnOthereqpensionsPage();
		eqPaymasterNameSteps = new EqPaymasterNameStepDefs();
		eqPaymasterNameSteps.theEqPaymasterNamePageWillBeDisplayed();
		eqPaymasterNameSteps.iClickNextOnEqPaymasterNamePage();
		eqPaymasterReferenceSteps = new EqPaymasterReferenceStepDefs();
		eqPaymasterReferenceSteps.theEqPaymasterReferencePageWillBeDisplayed();
		eqPaymasterReferenceSteps.iClickNextOnEqpaymasterReferencePage();

	}

	@And("^I navigate from eqPaymasterName page to check your answers page$")
	public void InavigateFromEqPaymasterNamePageToCheckYourAnswersPage() {
		eqPaymasterReferenceSteps = new EqPaymasterReferenceStepDefs();
		eqPaymasterReferenceSteps.theEqPaymasterReferencePageWillBeDisplayed();
		eqPaymasterReferenceSteps.iClickNextOnEqpaymasterReferencePage();

	}
	
	@And("^Check your answers page for payment details will be displayed$")
	public void checkYourAnswersPageForPaymentDetailsWillBeDisplayed() {
		
		paymentDetails_CheckYourAnswersPage = new PaymentDetails_CheckYourAnswerPage(driver);
		assertThat(paymentDetails_CheckYourAnswersPage.getHeading()).contains("Check your bank details");
	}
	

}
package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.BankAccountTypePage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BankAccountTypeStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private BankAccountTypePage bankAccountTypePage;

	@Given("^I am on bank account type page$")
	public void iAmOnBankAccountTypePage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/what-type-of-account");
	}

	@Given("^I go to bank account type page$")
	public void iGoToBankAccountTypePage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/what-type-of-account");
		bankAccountTypePage = new BankAccountTypePage(driver);
		assertThat(bankAccountTypePage.getHeading()).contains("What type of account are we making the payment to?");
	}

	@Then("^the default value for select bank account type will be blank$")
	public void theDefaultValueForSelectBankAccountTypeWillBeBlank() {
		assertThat(bankAccountTypePage.isBankAccountRadioButtonSelected()).isFalse();
	}

	@Then("^the bank account type page will be displayed$")
	public void theBankAccountTypePageWillBeDisplayed() {
		bankAccountTypePage = new BankAccountTypePage(driver);
		assertThat(bankAccountTypePage.getHeading()).contains("What type of account are we making the payment to?");
	}

	@When("^I select different account type using different valid option$")
	public void theSelectDifferentAccountTypeUsingDifferentValidOption() {
		iSelectCurrentAccount();
	}

	@And("^the account type details are sustained$")
	public void theAccountTypeDetailsAreSustained() {
		bankAccountTypePage = new BankAccountTypePage(driver);
		assertThat(bankAccountTypePage.getDepositAccount()).matches(SharedData.accountType);

	}

	@Then("^the bank account type submission will be unsuccessful$")
	public void theBankAccountTypeSubmissionWillBeUnsuccessful() {
		bankAccountTypePage = new BankAccountTypePage(driver);
		assertThat(bankAccountTypePage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(bankAccountTypePage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@And("^the bank account page error message '(.*)' will be displayed$")
	public void bankAccountPageErrorMessageWillBeDisplayed(String errorMessage) {
		bankAccountTypePage = new BankAccountTypePage(driver);
		assertThat(bankAccountTypePage.getBankAccountFieldErrorMessage()).matches(errorMessage);
		assertThat(bankAccountTypePage.doesBankAccountErrorMessageHaveAnchor()).isTrue();
		assertThat(bankAccountTypePage.getBankAccountAnchoredErrorMessage()).matches(errorMessage);

	}

	@When("^I select Current Account$")
	public void iSelectCurrentAccount() {
		SharedData.accountType = "Current Account";
		bankAccountTypePage = new BankAccountTypePage(driver);
		bankAccountTypePage.selectValidCurrentAccountDetails();
	}

	@When("^I select Deposit Account$")
	public void iSelectDepositAccount() {
		SharedData.accountType = "Deposit Account";
		bankAccountTypePage = new BankAccountTypePage(driver);
		bankAccountTypePage.selectValidDepositAccountDetails();
	}

	@When("^I dont select any account type$")
	public void iDontSelectAnyAccountType() {

		bankAccountTypePage = new BankAccountTypePage(driver);
		bankAccountTypePage.checkBankAccountType();
	}
}
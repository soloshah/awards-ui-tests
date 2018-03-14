package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DepositAccountPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DepositAccountStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private DepositAccountPage depositAccountPage;
	private String accountNumber;
	private String rollNumber;
	private String accountHolderName;
	private String sortCodeFirstField;
	private String sortCodeSecondField;
	private String sortCodeThirdField;

	@Given("^I am on the deposit account details page$")
	public void iAmOnTheDepositAccountDetailsPage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/deposit-account-details");
	}

	@Given("^I go to deposit account details page$")
	public void iGoToTheDepositAccountDetailsPage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/deposit-account-details");
		depositAccountPage = new DepositAccountPage(driver);
		 assertThat(depositAccountPage.getHeading()).contains("Enter bank details");
	}

	@Then("^the deposit account details submission will be successful$")
	public void theDepositAccountDetailsSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}
	
	@Then("^enter bank details for deposit account page will be displayed$")
	public void enterBankDetailsForDepositAccountPageWillBeDisplayed() {
		depositAccountPage = new DepositAccountPage(driver);
		assertThat(depositAccountPage.getHeading()).contains("Enter bank details");
	}
	@When("^I enter valid deposit account details$")
	public void IenterValidDepositAccountDetails() {
		setBankDetails();
		depositAccountPage = new DepositAccountPage(driver);
		depositAccountPage.submitValidBankAccountDetails(accountNumber, rollNumber, sortCodeFirstField,
				sortCodeSecondField, sortCodeThirdField, accountHolderName);
	}

	@Then("^the deposit account details submission will be unsuccessful$")
	public void theDepositAccountDetailsSubmissionWillBeUnsuccessful() {
		depositAccountPage = new DepositAccountPage(driver);
		assertThat(depositAccountPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly.");
		assertThat(depositAccountPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@And("^the account number error message '(.*)' will be displayed$")
	public void theAccountNumberErrorMessageWillBeDisplayed(String errorMessage) {
		depositAccountPage = new DepositAccountPage(driver);
		assertThat(depositAccountPage.doesAccountNumberErrorMessageHaveAnchor()).isTrue();
		assertThat(depositAccountPage.getAccountNumberAnchoredErrorMessage()).matches(errorMessage);
		assertThat(depositAccountPage.getAccountNumberFieldErrorMessage()).matches(errorMessage);

	}

	@And("^the roll number error message '(.*)' will be displayed$")
	public void theRollNumberErrorMessageWillBeDisplayed(String errorMessage) {
		depositAccountPage = new DepositAccountPage(driver);
		assertThat(depositAccountPage.doesRollNumberErrorMessageHaveAnchor()).isTrue();
		assertThat(depositAccountPage.getRollNumberAnchoredErrorMessage()).matches(errorMessage);
		assertThat(depositAccountPage.getRollNumberFieldErrorMessage()).matches(errorMessage);
	}

	@And("^the sort code error message '(.*)' will be displayed$")
	public void theSortCodeErrorMessageWillBeDisplayed(String errorMessage) {
		depositAccountPage = new DepositAccountPage(driver);
		assertThat(depositAccountPage.doesSortCodeErrorMessageHaveAnchor()).isTrue();
		assertThat(depositAccountPage.getSortCodeAnchoredErrorMessage()).matches(errorMessage);
		assertThat(depositAccountPage.getSortCodeFieldErrorMessage()).matches(errorMessage);
	}

	@And("^the account holder name error message '(.*)' will be displayed$")
	public void theAccountHolderNameErrorMessageWillBeDisplayed(String errorMessage) {
		depositAccountPage = new DepositAccountPage(driver);
		assertThat(depositAccountPage.doesAccountHolderNameErrorMessageHaveAnchor()).isTrue();
		assertThat(depositAccountPage.getAccountHolderNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(depositAccountPage.getAccountHolderNameFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter invalid deposit account details using the (.*) '(.*)'$")
	public void iEnterInvalidDepositAccountDetailsUsingFieldValue(String field, String value) {

		setBankDetails();

		switch (field) {
		case "accountNumber":
			accountNumber = value;
			break;
		case "rollNumber":
			rollNumber = value;
			break;
		case "accountHolderName":
			accountHolderName = value;
			break;
		}
		depositAccountPage = new DepositAccountPage(driver);
		depositAccountPage.enterBankDetails(accountNumber, rollNumber, sortCodeFirstField, sortCodeSecondField,
				sortCodeThirdField, accountHolderName);
		depositAccountPage.submitInValidBankDetails();
	}

	@Then("^The length of account holder name is verified$")
	public void theLengthOfAccountHolderNameIsVerified() {
		depositAccountPage = new DepositAccountPage(driver);
		assertThat(depositAccountPage.readAccountHolderNameField()).matches("InvalidIn@ validInvalidI");

	}
	
	@When("^I enter invalid sort code details using the sortCode1 '(.*)', sortCode2 '(.*)' and sortCode3 '(.*)'$")
	public void iEnterInvalidSortCodeDetailsUsingTheSortCode1SortCode2AndSortCode3(String sortCode1, String sortCode2, String sortCode3) {
		setBankAccountDetails();
		depositAccountPage = new DepositAccountPage(driver);
		depositAccountPage.enterBankDetails(accountNumber, rollNumber, sortCode1, sortCode2,
				sortCode3, accountHolderName);
		depositAccountPage.submitInValidBankDetails();
	}

	@When("^I enter invalid account holder name using the name '(.*)'$")
	public void iEnterInvalidAccountHolderNameUsingTheName(String Name) {
		setBankDetails();
		depositAccountPage = new DepositAccountPage(driver);
		depositAccountPage.enterBankDetails(accountNumber, rollNumber, sortCodeFirstField, sortCodeSecondField,
				sortCodeThirdField, Name);
		depositAccountPage.submitInValidBankDetails();
	}

	private void setBankDetails() {
		accountNumber = "12345678";
		rollNumber = "AA-12345/9P";
		accountHolderName = "Test-User";
		sortCodeFirstField = "12";
		sortCodeSecondField = "34";
		sortCodeThirdField = "56";
	}
	
	private void setBankAccountDetails(){
		accountNumber = "12345678";
		rollNumber = "AA-12345/9P";
		accountHolderName = "Test-User";
	}

}

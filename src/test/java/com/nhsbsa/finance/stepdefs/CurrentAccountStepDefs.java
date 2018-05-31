package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.CurrentAccountPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CurrentAccountStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private CurrentAccountPage currentAccountPage;
	private String accountNumber;
	private String accountHolderName;
	private String sortCodeFirstField;
	private String sortCodeSecondField;
	private String sortCodeThirdField;

	@Given("^I am on the current account details page$")
	public void iAmOnTheCurrentAccountDetailsPage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/current-account-details");
	}

	@Given("^I go to current account details page$")
	public void iGoToTheCurrentAccountDetailsPage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/current-account-details");
		driver.getPageSource().contains("This can be your own account or a joint account with someone else.");
		currentAccountPage = new CurrentAccountPage(driver);
		assertThat(currentAccountPage.getHeading()).contains("Enter bank details");
	}

	@Then("^the current account details submission will be successful$")
	public void theCurrentAccountDetailsSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^enter bank details for current account page will be displayed$")
	public void enterBankDetailsForCurrentAccountPageWillBeDisplayed() {
		currentAccountPage = new CurrentAccountPage(driver);
		assertThat(currentAccountPage.getHeading()).contains("Enter bank details");
	}

	@When("^I enter valid current account details$")
	public void IenterValidCurrentAccountDetails() {
		setBankDetails();
		currentAccountPage = new CurrentAccountPage(driver);
		currentAccountPage.submitValidBankAccountDetails(SharedData.accountNumber, SharedData.sortCodeFirstField, SharedData.sortCodeSecondField,
				SharedData.sortCodeThirdField, SharedData.accountHolderName);
	}
	
	@When("^I click next on current account page$")
	public void iClickNextOnCurrentAccountPage() {
		currentAccountPage = new CurrentAccountPage(driver);
		currentAccountPage.nextStep();
	}
	

	@Then("^the current account details submission will be unsuccessful$")
	public void theCurrentAccountDetailsSubmissionWillBeUnsuccessful() {
		currentAccountPage = new CurrentAccountPage(driver);
		assertThat(currentAccountPage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(currentAccountPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@And("^the current account number error message '(.*)' will be displayed$")
	public void theCurrentAccountNumberErrorMessageWillBeDisplayed(String errorMessage) {
		currentAccountPage = new CurrentAccountPage(driver);
		assertThat(currentAccountPage.doesAccountNumberErrorMessageHaveAnchor()).isTrue();
		assertThat(currentAccountPage.getAccountNumberAnchoredErrorMessage()).matches(errorMessage);
		assertThat(currentAccountPage.getAccountNumberFieldErrorMessage()).matches(errorMessage);

	}

	@And("^the sort code for current account error message '(.*)' will be displayed$")
	public void theSortCodeForCurrentAccountErrorMessageWillBeDisplayed(String errorMessage) {
		currentAccountPage = new CurrentAccountPage(driver);
		assertThat(currentAccountPage.doesSortCodeErrorMessageHaveAnchor()).isTrue();
		assertThat(currentAccountPage.getSortCodeAnchoredErrorMessage()).matches(errorMessage);
		assertThat(currentAccountPage.getSortCodeFieldErrorMessage()).matches(errorMessage);
	}

	@And("^the current account holder name error message '(.*)' will be displayed$")
	public void theCurrentAccountHolderNameErrorMessageWillBeDisplayed(String errorMessage) {
		currentAccountPage = new CurrentAccountPage(driver);
		assertThat(currentAccountPage.doesAccountHolderNameErrorMessageHaveAnchor()).isTrue();
		assertThat(currentAccountPage.getAccountHolderNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(currentAccountPage.getAccountHolderNameFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter invalid current account details using the (.*) '(.*)'$")
	public void iEnterInvalidCurrentAccountDetailsUsingFieldValue(String field, String value) {

		setInvalidBankDetails();

		switch (field) {
		case "accountNumber":
			accountNumber = value;
			break;
		case "accountHolderName":
			accountHolderName = value;
			break;
		}
		currentAccountPage = new CurrentAccountPage(driver);
		currentAccountPage.enterBankDetails(accountNumber,sortCodeFirstField, sortCodeSecondField, sortCodeThirdField,
				accountHolderName);
		currentAccountPage.submitInValidBankDetails();
	}

	@Then("^The length of current account holder name is verified$")
	public void theLengthOfCurrentAccountHolderNameIsVerified() {
		currentAccountPage = new CurrentAccountPage(driver);
		
		assertThat(currentAccountPage.readAccountHolderNameField()).matches("InvalidIn@ validInvalidI");

	}

	@When("^I enter invalid sort code details for current account using the sortCode1 '(.*)', sortCode2 '(.*)' and sortCode3 '(.*)'$")
	public void iEnterInvalidSortCodeDetailsForCurrentAccountUsingTheSortCode1SortCode2AndSortCode3(String sortCode1,
			String sortCode2, String sortCode3) {
		setBankAccountDetails();
		currentAccountPage = new CurrentAccountPage(driver);
		currentAccountPage.enterBankDetails(accountNumber, sortCode1, sortCode2, sortCode3, accountHolderName);
		currentAccountPage.submitInValidBankDetails();
	}

	@When("^I enter invalid current account holder name using the name '(.*)'$")
	public void iEnterInvalidCurrentAccountHolderNameUsingTheName(String Name) {
		setInvalidBankDetails();
		currentAccountPage = new CurrentAccountPage(driver);
		currentAccountPage.enterBankDetails(accountNumber, sortCodeFirstField, sortCodeSecondField, sortCodeThirdField,
				Name);
		currentAccountPage.submitInValidBankDetails();
	}

	private void setBankDetails() {
	//	SharedData.accountNumber = "123AB7I8";
		SharedData.accountNumber = "123AB7I80olk";
		SharedData.accountHolderName = "Test-User";
		SharedData.sortCodeFirstField = "12";
		SharedData.sortCodeSecondField = "34";
		SharedData.sortCodeThirdField = "56";
	}

	private void setBankAccountDetails() {
		accountNumber = "123l4OP78lpj76";
		//accountNumber = "123l4OP7";
		accountHolderName = "Test-User";
	}
	
	private void setInvalidBankDetails() {
		accountNumber = "123l4OP78lpj76";
		//accountNumber = "123l4OP7";
		accountHolderName = "Test-User";
		sortCodeFirstField = "12";
		sortCodeSecondField = "34";
		sortCodeThirdField = "56";
	}

	

}

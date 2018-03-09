package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DepositAccountPage;
import com.nhsbsa.finance.pageobjects.EmployerAddressPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployerAddressStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private EmployerAddressPage employerAddressPage;
	private String streetLineOne;
	private String streetLineTwo;
	private String town;
	private String postCode;

	@Given("^I am on your employer address page$")
	public void iAmOnYourEmployerAddressPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/what-is-your-employer-address");
	}

	@Given("^I go to your employer address page$")
	public void iGoToYourEmployerAddressPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/what-is-your-employer-address");
		employerAddressPage = new EmployerAddressPage(driver);
		assertThat(employerAddressPage.getHeading()).contains("What is your employer's address?");
	}

	@Then("^the employer address details submission will be successful$")
	public void theEmployerAddressDetailsSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}
	
	
	@Then("^the employer address page will be displayed$")
	public void enterBankDetailsForDepositAccountPageWillBeDisplayed() {
		employerAddressPage = new EmployerAddressPage(driver);
		assertThat(employerAddressPage.getHeading()).contains("What is your employer's address?");
	}

	@When("^I enter valid employer address details$")
	public void IenterValidEmployerAddressDetails() {
		setEmployerAddressDetails();
		employerAddressPage = new EmployerAddressPage(driver);
		employerAddressPage.submitValidAddressDetails(streetLineOne, streetLineTwo, town, postCode);
	}

	@Then("^the employer address details submission will be unsuccessful$")
	public void theAddressDetailsSubmissionWillBeUnsuccessful() {
		employerAddressPage = new EmployerAddressPage(driver);
		assertThat(employerAddressPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly.");
		assertThat(employerAddressPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@And("^the building and street name one error message '(.*)' will be displayed$")
	public void theBuildingAndStreetNameOneErrorMessageWillBeDisplayed(String errorMessage) {
		employerAddressPage = new EmployerAddressPage(driver);
		assertThat(employerAddressPage.doesStreetLineOneErrorMessageHaveAnchor()).isTrue();
		assertThat(employerAddressPage.getStreetLineOneAnchoredErrorMessage()).matches(errorMessage);
		assertThat(employerAddressPage.getStreetLineOneFieldErrorMessage()).matches(errorMessage);

	}

	@And("^the building and street name two error message '(.*)' will be displayed$")
	public void theBuildingAndStreetLineNameErrorMessageWillBeDisplayed(String errorMessage) {
		employerAddressPage = new EmployerAddressPage(driver);
		assertThat(employerAddressPage.doesStreetLineTwoErrorMessageHaveAnchor()).isTrue();
		assertThat(employerAddressPage.getStreetLineTwoAnchoredErrorMessage()).matches(errorMessage);
		assertThat(employerAddressPage.getStreetLineTwoFieldErrorMessage()).matches(errorMessage);

	}

	@And("^the town error message '(.*)' will be displayed$")
	public void theTownErrorMessageWillBeDisplayed(String errorMessage) {
		employerAddressPage = new EmployerAddressPage(driver);
		assertThat(employerAddressPage.doesTownErrorMessageHaveAnchor()).isTrue();
		assertThat(employerAddressPage.getTownAnchoredErrorMessage()).matches(errorMessage);
		assertThat(employerAddressPage.getTownFieldErrorMessage()).matches(errorMessage);
	}

	@And("^the employer postcode error message '(.*)' will be displayed$")
	public void theEmployerPostCodeErrorMessageWillBeDisplayed(String errorMessage) {
		employerAddressPage = new EmployerAddressPage(driver);
		assertThat(employerAddressPage.doesPostCodeErrorMessageHaveAnchor()).isTrue();
		assertThat(employerAddressPage.getPostCodeAnchoredErrorMessage()).matches(errorMessage);
		assertThat(employerAddressPage.getPostCodeFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter invalid employer address details using the (.*) '(.*)'$")
	public void iEnterInvalidEmployerAddressDetailsUsingFieldValue(String field, String value) {

		setEmployerAddressDetails();

		switch (field) {
		case "streetLineOne":
			streetLineOne = value;
			break;
		case "streetLineTwo":
			streetLineTwo = value;
			break;
		case "town":
			town = value;
			break;
		case "postCode":
			postCode = value;
			break;
		}
		employerAddressPage = new EmployerAddressPage(driver);
		employerAddressPage.enterEmployerAddressDetails(streetLineOne, streetLineTwo, town, postCode);
		employerAddressPage.submitInValidEmployerAddressDetails();
	}

	private void setEmployerAddressDetails() {
		streetLineOne = "Flat 1B";
		streetLineTwo = "North Street";
		town = "Leeds";
		postCode = "LE12 3RT";

	}

}

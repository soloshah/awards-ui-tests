package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.YourAddressPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YourAddressStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private YourAddressPage yourAddressPage;
	private String streetLineOne;
	private String streetLineTwo;
	private String town;
	private String postCode;
	private String country;

	@Given("^I am on your address page$")
	public void iAmOnYourAddressPage() {
		new Page(driver).navigateToUrl(baseUrl + "/personal-details/what-is-your-address");
	}

	@Given("^I go to your address page$")
	public void iGoToYourAddressPage() {
		new Page(driver).navigateToUrl(baseUrl + "/personal-details/what-is-your-address");
		yourAddressPage = new YourAddressPage(driver);
		assertThat(yourAddressPage.getHeading()).contains("What is your address?");
	}

	@Then("^the address details submission will be successful$")
	public void theAddressDetailsSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@When("^I enter valid address details$")
	public void IenterValidAddressDetails() {
		setNewAddressDetails();
		yourAddressPage = new YourAddressPage(driver);
		yourAddressPage.submitValidAddressDetails(SharedData.streetLineOne, SharedData.streetLineTwo, SharedData.town,
				SharedData.postCode, SharedData.country);
	}

	@Then("^your address page will be displayed$")
	public void yourAddressPageWillBeDisplayed() {
		yourAddressPage = new YourAddressPage(driver);
		assertThat(yourAddressPage.getHeading()).contains("What is your address?");
	}

	@When("^I click next on your address page$")
	public void iClickNextOnYourAddressPage() {
		yourAddressPage = new YourAddressPage(driver);
		yourAddressPage.nextStep();
	}

	@Then("^the address details are sustained$")
	public void theAddressDetailsAreSustained() {
		yourAddressPage = new YourAddressPage(driver);
		assertThat(yourAddressPage.getAddressLineOneDetails()).matches(SharedData.streetLineOne);
		assertThat(yourAddressPage.getAddressLineTwoDetails()).matches(SharedData.streetLineTwo);
		assertThat(yourAddressPage.getAddressTownDetails()).matches(SharedData.town);
		assertThat(yourAddressPage.getAddressPostcodeDetails()).matches(SharedData.postCode);
		assertThat(yourAddressPage.getAddressCountryDetails()).matches(SharedData.country);
	}

	@When("^I enter address details using different valid details$")
	public void iEnterAddressDetailsUsingDifferentDetails() {
		setUpdatedAddressDetails();
		yourAddressPage = new YourAddressPage(driver);
		yourAddressPage.submitValidAddressDetails(SharedData.streetLineOne, SharedData.streetLineTwo, SharedData.town,
				SharedData.postCode, SharedData.country);
	}

	@Then("^the address details submission will be unsuccessful$")
	public void theAddressDetailsSubmissionWillBeUnsuccessful() {
		yourAddressPage = new YourAddressPage(driver);
		assertThat(yourAddressPage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(yourAddressPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@And("^the building and street line one error message '(.*)' will be displayed$")
	public void theBuildingAndStreetLineOneErrorMessageWillBeDisplayed(String errorMessage) {
		yourAddressPage = new YourAddressPage(driver);
		assertThat(yourAddressPage.doesStreetLineOneErrorMessageHaveAnchor()).isTrue();
		assertThat(yourAddressPage.getStreetLineOneAnchoredErrorMessage()).matches(errorMessage);
		assertThat(yourAddressPage.getStreetLineOneFieldErrorMessage()).matches(errorMessage);

	}

	@And("^the building and street line two error message '(.*)' will be displayed$")
	public void theBuildingAndStreetLineTwoErrorMessageWillBeDisplayed(String errorMessage) {
		yourAddressPage = new YourAddressPage(driver);
		assertThat(yourAddressPage.doesStreetLineTwoErrorMessageHaveAnchor()).isTrue();
		assertThat(yourAddressPage.getStreetLineTwoAnchoredErrorMessage()).matches(errorMessage);
		assertThat(yourAddressPage.getStreetLineTwoFieldErrorMessage()).matches(errorMessage);

	}

	@And("^the town or city error message '(.*)' will be displayed$")
	public void theTownOrCityErrorMessageWillBeDisplayed(String errorMessage) {
		yourAddressPage = new YourAddressPage(driver);
		assertThat(yourAddressPage.doesTownErrorMessageHaveAnchor()).isTrue();
		assertThat(yourAddressPage.getTownAnchoredErrorMessage()).matches(errorMessage);
		assertThat(yourAddressPage.getTownFieldErrorMessage()).matches(errorMessage);
	}

	@And("^the postcode error message '(.*)' will be displayed$")
	public void thePostCodeErrorMessageWillBeDisplayed(String errorMessage) {
		yourAddressPage = new YourAddressPage(driver);
		assertThat(yourAddressPage.doesPostCodeErrorMessageHaveAnchor()).isTrue();
		assertThat(yourAddressPage.getPostCodeAnchoredErrorMessage()).matches(errorMessage);
		assertThat(yourAddressPage.getPostCodeFieldErrorMessage()).matches(errorMessage);
	}

	@And("^the country error message '(.*)' will be displayed$")
	public void theCountryErrorMessageWillBeDisplayed(String errorMessage) {
		yourAddressPage = new YourAddressPage(driver);
		assertThat(yourAddressPage.doesCountryErrorMessageHaveAnchor()).isTrue();
		assertThat(yourAddressPage.getCountryAnchoredErrorMessage()).matches(errorMessage);
		assertThat(yourAddressPage.getCountryFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter invalid address details using the (.*) '(.*)'$")
	public void iEnterInvalidAddressDetailsUsingFieldValue(String field, String value) {

		setAddressDetails();

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
		case "country":
			country = value;
			break;
		}
		yourAddressPage = new YourAddressPage(driver);
		yourAddressPage.enterAddressDetails(streetLineOne, streetLineTwo, town, postCode, country);
		yourAddressPage.submitInValidAddressDetails();
	}

	private void setAddressDetails() {
		streetLineOne = "Flat 1B";
		streetLineTwo = "North Street";
		town = "Leeds";
		postCode = "LE12 3RT";
		country = "UK";
	}

	private void setUpdatedAddressDetails() {
		SharedData.streetLineOne = "Flat 1C";
		SharedData.streetLineTwo = "South Street";
		SharedData.town = "Leeds";
		SharedData.postCode = "LE12 3RY";

	}
	
	private void setNewAddressDetails() {
		SharedData.streetLineOne = "Flat 1B";
		SharedData.streetLineTwo = "North Street";
		SharedData.town = "Leeds";
		SharedData.postCode = "LE12 3RT";
		SharedData.country = "UK";

	}

}

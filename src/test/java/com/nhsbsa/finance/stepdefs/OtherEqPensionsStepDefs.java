package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.OtherEqPensionsPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OtherEqPensionsStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private OtherEqPensionsPage otherEqPensionsPage;

	@Given("^I am on other eq pension page$")
	public void iAmOnOtherEqPensionsPage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/other-eq-pensions");
	}

	@Given("^I go to other eq pension page$")
	public void iGoToOtherEqPensionsPage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/other-eq-pensions");
		otherEqPensionsPage = new OtherEqPensionsPage(driver);
		assertThat(otherEqPensionsPage.getHeading())
				.contains("Do you have any other pensions paid by Equiniti Paymaster?");
	}

	@Then("^the default value for other pensions paid by Equiniti Paymaster will be blank$")
	public void theDefaultValueForOtherPensionsPaidByEquinityPaymasterWillBeBlank() {
		assertThat(otherEqPensionsPage.isOtherEqPensionsRadioButtonSelected()).isFalse();
	}

	@And("^other Pensions paid by Equiniti Paymaster Page error message '(.*)' will be displayed$")
	public void otherPensionsPaidByEquinitiPaymasterPageErrorMessageWillBeDisplayed(String errorMessage) {
		otherEqPensionsPage = new OtherEqPensionsPage(driver);
		assertThat(otherEqPensionsPage.getOtherEqPensionsFieldErrorMessage()).matches(errorMessage);
		assertThat(otherEqPensionsPage.doesOtherEqPensionsErrorMessageHaveAnchor()).isTrue();
		assertThat(otherEqPensionsPage.getOtherEqPensionsAnchoredErrorMessage()).matches(errorMessage);

	}

	@When("^I pick Yes$")
	public void iPickYes() {
		otherEqPensionsPage = new OtherEqPensionsPage(driver);
		otherEqPensionsPage.selectYesButton();
	}

	@When("^I pick No$")
	public void iPickNo() {
		otherEqPensionsPage = new OtherEqPensionsPage(driver);
		otherEqPensionsPage.selectNoButton();
	}

	@When("^I dont select anything and click next$")
	public void iDontSelectAnythingAndClickNext() {
		otherEqPensionsPage = new OtherEqPensionsPage(driver);
		otherEqPensionsPage.otherEqPensionsIsNotSelected();
	}
}
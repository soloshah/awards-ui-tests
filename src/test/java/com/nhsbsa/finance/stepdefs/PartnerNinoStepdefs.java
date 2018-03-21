package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.PartnerNinoPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PartnerNinoStepdefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private PartnerNinoPage partnerNinoPage;

	@Given("^I am on the partner national insurance page$")
	public void iAmOnThePartnerNationalInsurancePage() {
		new Page(driver).navigateToUrl(baseUrl + "/partner-and-child/what-is-your-partner-ni");
	}

	@When("^I go to partner nino page$")
	public void iGoToPartnerNinoPage() {

		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/partner-and-child/what-is-your-partner-ni");
		partnerNinoPage = new PartnerNinoPage(driver);
		assertThat(partnerNinoPage.getHeading()).contains("What is your spouse's or civil partner's National Insurance number?");
	}

	@Then("^the partner national insurance number submission will be successful$")
	public void thePartnerNationalInsuranceNumberSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the partner national insurance number submission will be unsuccessful$")
	public void thePartnerNationalInsuranceNumberSubmissionWillBeUnsuccessful() {
		partnerNinoPage = new PartnerNinoPage(driver);
		assertThat(partnerNinoPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly:");
		assertThat(partnerNinoPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@And("^the partner nino error message '(.*)' will be displayed$")
	public void thePartnerNinoErrorMessageWillBeDisplayed(String errorMessage) {
		partnerNinoPage = new PartnerNinoPage(driver);
		assertThat(partnerNinoPage.doesNinoErrorMessageHaveAnchor()).isTrue();
		assertThat(partnerNinoPage.getNinoAnchoredErrorMessage()).matches(errorMessage);
		assertThat(partnerNinoPage.getNinoFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter partner national insurance number using the nino '(.*)'$")
	public void iEnterPartnerNationalInsuranceNumberUsingTheNino(String nino) {
		partnerNinoPage = new PartnerNinoPage(driver);
		partnerNinoPage.enterPartnerNino(nino);
		partnerNinoPage.submitInValidNinoDetails();

	}

	@When("^I enter valid partner national insurance number$")
	public void IenterValidPartnerNationalInsuranceNumber() {
		String partnerNino = "AA123456B";
		partnerNinoPage = new PartnerNinoPage(driver);
		partnerNinoPage.submitValidNiDetails(partnerNino);
	}

	
	
}
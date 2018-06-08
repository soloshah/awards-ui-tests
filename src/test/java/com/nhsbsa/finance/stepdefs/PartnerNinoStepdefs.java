package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.PartnerNinoPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PartnerNinoStepdefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private PartnerNinoPage partnerNinoPage;
	  private PartnerNameStepDefs partnerNameSteps;
	  
	@Given("^I am on the partner nino page$")
	public void iAmOnThePartnerNinoPage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/dependant-details/what-is-your-partner-ni");
	}

	@When("^I go to partner nino page$")
	public void iGoToPartnerNinoPage() {

		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/dependant-details/what-is-your-partner-ni");
		partnerNinoPage = new PartnerNinoPage(driver);
		assertThat(partnerNinoPage.getHeading())
				.contains("What is your spouse's or civil partner's National Insurance number?");
	}

	@Then("^the partner national insurance number submission will be successful$")
	public void thePartnerNationalInsuranceNumberSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the partner national insurance number submission will be unsuccessful$")
	public void thePartnerNationalInsuranceNumberSubmissionWillBeUnsuccessful() {
		partnerNinoPage = new PartnerNinoPage(driver);
		assertThat(partnerNinoPage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(partnerNinoPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
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
		SharedData.nino = "AA123456B";
		partnerNinoPage = new PartnerNinoPage(driver);
		partnerNinoPage.submitValidNiDetails(SharedData.nino);
	}
	
	@Then("^the partner nino page will be displayed$")
	public void thePartnerNinoPageWillBeDisplayed() {
		partnerNinoPage = new PartnerNinoPage(driver);
		assertThat(partnerNinoPage.getHeading())
				.contains("What is " + SharedData.firstName + "'s " + "National Insurance number?");
	}

	@And("^I enter same nino as of main applicant$")
	public void iEnterSameNinoAsOfMainApplicant() {

		partnerNinoPage = new PartnerNinoPage(driver);
		partnerNinoPage.enterPartnerNino(SharedData.nino);
		partnerNinoPage.submitInValidNinoDetails();
	}

	@When("^I click next on partner national insurance page$")
	public void iClickNextOnPartnerNationalInsurancePage() {
		partnerNinoPage = new PartnerNinoPage(driver);
		partnerNinoPage.nextStep();
	}

	@Then("^the partnerNino details are sustained$")
	public void thePartnerNinoDetailsAreSustained() {
		partnerNinoPage = new PartnerNinoPage(driver);
		assertThat(partnerNinoPage.getNino()).matches(SharedData.nino);
		}
	
	@When("^I enter partnerNino using different valid details$")
	public void iEnterPartnerNinoUsingDifferentDetails() {
		SharedData.nino = "AA123489B";
		partnerNinoPage = new PartnerNinoPage(driver);
		partnerNinoPage.submitValidNiDetails(SharedData.nino);
	}
	
	@And("^I enter valid partner details$")
	public void iEnterValidPartnerDetails() {
     partnerNameSteps = new PartnerNameStepDefs();
     partnerNameSteps.iGoToThePartnerNamePage();
     partnerNameSteps.iSubmitValidPartnerFirstAndLastNameDetails();
     iAmOnThePartnerNinoPage();
	}
	
	@When("^I go to dynamic partner nino page$")
	public void iGoToDynamicPartnerNinoPage() {

		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/dependant-details/what-is-your-partner-ni");
		partnerNinoPage = new PartnerNinoPage(driver);
		assertThat(partnerNinoPage.getHeading()
				.contains("What is " + SharedData.firstName + "'s " + "National Insurance number?"));
	}
	
}
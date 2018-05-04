package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DynamicNinoPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DynamicNinoStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private DynamicNinoPage dynamicNinoPage;
    private PartnerNameStepDefs partnerNameSteps;
 
 
	@When("^I go to dynamic partner nino page$")
	public void iGoToDynamicPartnerNinoPage() {

		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/dependant-details/what-is-your-partner-ni");
		dynamicNinoPage = new DynamicNinoPage(driver);
		assertThat(dynamicNinoPage.getHeading()
				.contains("What is " + SharedData.firstName + "'s " + "National Insurance number?"));
	}

		
	@Then("^the dynamic partners nino page will be displayed$")
	public void theDynamicPartnersNinoPageWillBeDisplayed() {
		Page page = new Page(driver);
		String partnerNinoPageTitle = "What is " + SharedData.firstName + "'s "
				+ "National Insurance number? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(partnerNinoPageTitle);
		dynamicNinoPage = new DynamicNinoPage(driver);
		assertThat(dynamicNinoPage.getHeading())
				.contains("What is " + SharedData.firstName + "'s " + "National Insurance number?");
	}

	@And("^I enter same nino as of main applicant$")
	public void iEnterSameNinoAsOfMainApplicant() {

		dynamicNinoPage = new DynamicNinoPage(driver);
		dynamicNinoPage.enterPartnerNino(SharedData.nino);
		dynamicNinoPage.submitInValidNinoDetails();
	}

	@Then("^the dynamic national insurance number submission will be unsuccessful$")
	public void theDynamicNationalInsuranceNumberSubmissionWillBeUnsuccessful() {
		dynamicNinoPage = new DynamicNinoPage(driver);
		assertThat(dynamicNinoPage.getErrorHeadingErrorMessage())
				.matches("Your form contains errors");
		assertThat(dynamicNinoPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	
	@When("^I enter valid partner nino$")
	public void IenterValidPartnerNino() {
		SharedData.nino = "AB234567C";
		dynamicNinoPage = new DynamicNinoPage(driver);
		dynamicNinoPage.submitValidNiDetails(SharedData.nino);
	}
	
	
	@When("^I click next on partner national insurance page$")
	public void iClickNextOnPartnerNationalInsurancePage() {
		dynamicNinoPage = new DynamicNinoPage(driver);
		dynamicNinoPage.nextStep();
	}

	@Then("^the partnerNino details are sustained$")
	public void thePartnerNinoDetailsAreSustained() {
		dynamicNinoPage = new DynamicNinoPage(driver);
		assertThat(dynamicNinoPage.getNino()).matches(SharedData.nino);
		}
	
	@When("^I enter partnerNino using different valid details$")
	public void iEnterPartnerNinoUsingDifferentDetails() {
		SharedData.nino = "AA123489B";
		dynamicNinoPage = new DynamicNinoPage(driver);
		dynamicNinoPage.submitValidNiDetails(SharedData.nino);
	}
	
	@And("^I enter valid partner details$")
	public void iEnterValidPartnerDetails() {
     partnerNameSteps = new PartnerNameStepDefs();
     partnerNameSteps.iGoToThePartnerNamePage();
     partnerNameSteps.iSubmitValidPartnerFirstAndLastNameDetails();
     iGoToDynamicPartnerNinoPage();
	}
}

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

	@When("^I go to dynamic partner nino page$")
	public void iGoToDynamicPartnerNinoPage() {

		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/partner-and-child/what-is-your-partner-ni");
		dynamicNinoPage = new DynamicNinoPage(driver);
		assertThat(dynamicNinoPage.getHeading()
				.contains("What is " + SharedData.firstName + "'s " + "National Insurance number?"));
	}

	@Then("^the dynamic value of partners name will be displayed on partner's nino page$")
	public void theDynamicValueOfPartnersNameWillBeDisplayedOnThePartnersNinoPage() {
		Page page = new Page(driver);
		String partnerNinoPageTitle = "What is " + SharedData.firstName + "'s "
				+ "National Insurance number? - Claim your NHS Pension";
		page.waitForTitleToExist(partnerNinoPageTitle);
		dynamicNinoPage = new DynamicNinoPage(driver);
		assertThat(dynamicNinoPage.getHeading()
				.contains("What is " + SharedData.firstName + "'s " + "National Insurance number?"));

	}
	
	@Then("^the dynamic partners nino page will be displayed$")
	public void theDynamicPartnersNinoPageWillBeDisplayed() {
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
				.matches("Some questions have not been answered correctly:");
		assertThat(dynamicNinoPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

}

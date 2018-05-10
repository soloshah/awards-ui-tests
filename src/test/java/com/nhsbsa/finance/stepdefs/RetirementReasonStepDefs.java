package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.ReasonForRetirementPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RetirementReasonStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private ReasonForRetirementPage reasonForRetirementPage;

	@Then("^the reason for retirement submission will be successful$")
	public void theReasonForRetirementSubmissionWillBeSuccessful() {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		reasonForRetirementPage.selectValidRetirementReason();
		 new NavBarPage(driver);
	}

	@When("^I select retirement reason as retirementAge$")
	public void ISelectRetirementReasonAsRetirementAge() {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		reasonForRetirementPage.selectRetirementReasonAge();
		reasonForRetirementPage.selectValidRetirementReason();

	}
	
	@When("^I select valid retirement reason using (.*)$")
	public void iSelectValidRetirementReasonUsing(String field) {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		switch (field) {
		case "retirementAge":
			reasonForRetirementPage.selectRetirementReasonAge();
			break;
		case "deferredBenefit":
			reasonForRetirementPage.selectRetirementReasonDeferredBenefit();
			break;
		case "deferredBenefitHealth":
			reasonForRetirementPage.selectRetirementReasonDeferredBenefitHealth();
			break;
		case "earlyPaymentHealth":
			reasonForRetirementPage.selectRetirementReasonEarlyPaymentHealth();
			break;
		}
	}

	@When("^the 2015 valid retirement reason text for (.*) will be displayed$")
	public void the2015ValidRetirementReasonTextForWillBeDisplayed(String field) {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		switch (field) {
		case "age":
			
 		assertThat(reasonForRetirementPage.getRetirementReasonAgeText())
					.matches("This will normally be your 65th birthday or your State Pension Age, whichever is later.");
			break;
		case "deferredBenefit":
			
			assertThat(reasonForRetirementPage.getRetirementReasonDeferredBenefitText())
					.matches("You can take early payment of your deferred benefit between the ages of 55 and 65.");
			break;
		case "deferredBenefitHealth":
			
			assertThat(reasonForRetirementPage.getRetirementReasonDeferredBenefitHealthText())
			.matches("You can only choose this option if you’re under 65 or your State Pension Age, whichever is later, and your ill health application has been approved by the Scheme’s medical advisors.");
			break;
		case "earlyPaymentHealth":
			
			assertThat(reasonForRetirementPage.getRetirementReasonEarlyPaymentHealthText())
					.matches("You can only choose this option if you’re under 65 or your State Pension Age, whichever is later, and your ill health application has been approved by the Scheme’s medical advisors.");
			break;
		}
	}
	
	@When("^the valid 1995 retirement reason text for (.*) will be displayed$")
	public void theValid1995RetirementReasonTextForWillBeDisplayed(String field) {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		switch (field) {
		case "age":

			assertThat(reasonForRetirementPage.getRetirementReasonAgeText())
					.matches("This will normally be your 60th birthday.");
			break;
		case "deferredBenefit":

			assertThat(reasonForRetirementPage.getRetirementReasonDeferredBenefitText())
					.matches("Early payment of deferred benefits are available to you at the age of:");
			break;
		case "deferredBenefitHealth":

			assertThat(reasonForRetirementPage.getRetirementReasonDeferredBenefitHealthText()).matches(
					"You can only choose this option if you’re under 60 and your ill health application has been approved by the Scheme’s medical advisors.");
			break;
		case "earlyPaymentHealth":

			assertThat(reasonForRetirementPage.getRetirementReasonEarlyPaymentHealthText())
					.matches("You can only choose this option if:");
			break;
		}
	}
	
	@When("^the 2008 valid retirement reason text for (.*) will be displayed$")
	public void the2008ValidRetirementReasonTextForWillBeDisplayed(String field) {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		switch (field) {
		case "age":
 		assertThat(reasonForRetirementPage.getRetirementReasonAgeText())
					.matches("This will normally be your 65th birthday.");
			break;
		case "deferredBenefit":
			assertThat(reasonForRetirementPage.getRetirementReasonDeferredBenefitText())
					.matches("You can take early payment of your deferred benefit between the ages of 55 and 65.");
			break;
		case "deferredBenefitHealth":
			
			assertThat(reasonForRetirementPage.getRetirementReasonDeferredBenefitHealthText()).matches(
					"You can only choose this option if you’re under 65 and your ill health application has been approved by the Scheme’s medical advisors.");
			break;
		case "earlyPaymentHealth":
			
			assertThat(reasonForRetirementPage.getRetirementReasonEarlyPaymentHealthText())
					.matches("You can only choose this option if you’re under 65 and your ill health application has been approved by the Scheme’s medical advisors.");
			break;
		}
	}


	@Then("^the reason for retirement submission will be unsuccessful$")
	public void theReasonForRetirementSubmissionWillBeUnsuccessful() {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		assertThat(reasonForRetirementPage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(reasonForRetirementPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I dont select any reason for retirement$")
	public void iDontSelectAnyReasonForRetirement() {

		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		reasonForRetirementPage.isRetirementReasonNotSelected();

	}
		
	@And("^the error message '(.*)' for 2008 reason for retirement will be displayed$")
	public void theErrorMessageFor2008ReasonForRetirementWillBeDisplayed(String errorMessage) {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		assertThat(reasonForRetirementPage.doesRetirementReasonErrorMessageHaveAnchor()).isTrue();
		assertThat(reasonForRetirementPage.getRetirementReasonAnchoredErrorMessage()).matches(errorMessage);
		assertThat(reasonForRetirementPage.getRetirementReason2008FieldErrorMessage()).matches(errorMessage);
	}
	
	@And("^the error message '(.*)' for reason for retirement will be displayed$")
	public void theErrorMessageForReasonForRetirementWillBeDisplayed(String errorMessage) {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		assertThat(reasonForRetirementPage.doesRetirementReasonErrorMessageHaveAnchor()).isTrue();
		assertThat(reasonForRetirementPage.getRetirementReasonAnchoredErrorMessage()).matches(errorMessage);
		assertThat(reasonForRetirementPage.getRetirementReasonFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I go to the 2008 reason for retirement page$")
	public void iGoToThe2008ReasonForRetirementPage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2008-reason-for-retirement");
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		assertThat(reasonForRetirementPage.getHeading())
				.contains("Why are you claiming your deferred benefits for the 2008 Section?");
	}
	
	@When("^I go to the 1995 reason for retirement page$")
	public void iGoToThe1995ReasonForRetirementPage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/1995-reason-for-retirement");
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		assertThat(reasonForRetirementPage.getHeading())
				.contains("Why are you claiming your deferred benefits for the 1995 Section?");
	}

	
	@When("^I go to the 2015 reason for retirement page$")
	public void iGoToThe2015ReasonForRetirementPage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2015-reason-for-retirement");
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		assertThat(reasonForRetirementPage.getHeading())
				.contains("Why are you claiming your deferred benefits for the 2015 Scheme?");
	}

	
	@Then("^the 2008 reason for retirement page will be displayed$")
	public void the2008ReasonForRetirementPageWillBeDisplayed() {
		Page page = new Page(driver);
		String retirement2008PageTitle = "Why are you claiming your deferred benefits for the 2008 Section? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(retirement2008PageTitle);
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		assertThat(reasonForRetirementPage.getHeading()).contains("Why are you claiming your deferred benefits for the 2008 Section?");
	}
	
	@Then("^the 1995 reason for retirement page will be displayed$")
	public void the1995ReasonForRetirementPageWillBeDisplayed() {
		Page page = new Page(driver);
		String retirement1995PageTitle = "Why are you claiming your deferred benefits for the 1995 Section? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(retirement1995PageTitle);
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		assertThat(reasonForRetirementPage.getHeading()).contains("Why are you claiming your deferred benefits for the 1995 Section?");
	}
	
	@Then("^the 2015 reason for retirement page will be displayed$")
	public void the2015ReasonForRetirementPageWillBeDisplayed() {
		Page page = new Page(driver);
		String retirement2015PageTitle = "Why are you claiming your deferred benefits for the 2015 Scheme? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(retirement2015PageTitle);
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		assertThat(reasonForRetirementPage.getHeading()).contains("Why are you claiming your deferred benefits for the 2015 Scheme?");
	}
	
	@When("^I select deferredBenefitHealth as retirement reason$")
	public void iSelectDeferredBenefitHealthAsRetirementReason() {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		reasonForRetirementPage.selectRetirementReasonDeferredBenefitHealth();
		reasonForRetirementPage.selectValidRetirementReason();
	}
	
	@When("^I select retirementAge as retirement reason$")
	public void ISelectRetirementAgeAsRetirementReason() {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		reasonForRetirementPage.selectRetirementReasonAge();
		reasonForRetirementPage.selectValidRetirementReason();
	}
	
	
	@When("^I select deferredBenefit as retirement reason$")
	public void ISelectDeferredBenefitAsRetirementReason() {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		reasonForRetirementPage.selectRetirementReasonDeferredBenefit();
		reasonForRetirementPage.selectValidRetirementReason();
	}
	
	@Then("^I click next on retirement reason page$")
	public void iClickNextOnRetirementReasonPage() {
		reasonForRetirementPage = new ReasonForRetirementPage(driver);
		reasonForRetirementPage.nextStep();
	}
	
}

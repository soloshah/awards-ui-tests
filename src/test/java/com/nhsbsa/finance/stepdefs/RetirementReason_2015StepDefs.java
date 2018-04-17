package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.ReasonForRetirement_2015Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RetirementReason_2015StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private ReasonForRetirement_2015Page reasonForRetirement_2015Page;

	@Then("^the 2015 reason for retirement submission will be successful$")
	public void theReasonForRetirementSubmissionWillBeSuccessful() {
		reasonForRetirement_2015Page = new ReasonForRetirement_2015Page(driver);
		reasonForRetirement_2015Page.selectValidRetirementReason();
		// new NavBarPage(driver);
	}
	

	@When("^I select deferredBenefitHealth as 2015 retirement reason$")
	public void iSelectdeferredBenefitHealth2015RetirementReason() {
		reasonForRetirement_2015Page = new ReasonForRetirement_2015Page(driver);
		reasonForRetirement_2015Page.selectRetirementReasonDeferredBenefitHealth();
		reasonForRetirement_2015Page.selectValidRetirementReason();
	}
	

	@When("^I select valid 2015 retirement reason using (.*)$")
	public void iSelectValid2015RetirementReasonUsing(String field) {
		reasonForRetirement_2015Page = new ReasonForRetirement_2015Page(driver);
		switch (field) {
		case "retirementAge":
			reasonForRetirement_2015Page.selectRetirementReasonAge();
			break;
		case "deferredBenefit":
			reasonForRetirement_2015Page.selectRetirementReasonDeferredBenefit();
			break;
		case "deferredBenefitHealth":
			reasonForRetirement_2015Page.selectRetirementReasonDeferredBenefitHealth();
			break;
		case "earlyPaymentHealth":
			reasonForRetirement_2015Page.selectRetirementReasonEarlyPaymentHealth();
			break;
		}
	}

	@When("^the 2015 valid retirement reason text for (.*) will be displayed$")
	public void the2015ValidRetirementReasonTextForWillBeDisplayed(String field) {
		reasonForRetirement_2015Page = new ReasonForRetirement_2015Page(driver);
		switch (field) {
		case "age":
			
 		assertThat(reasonForRetirement_2015Page.getRetirementReasonAgeText())
					.matches("This will normally be your 65th birthday or your State Pension Age, whichever is later.");
			break;
		case "deferredBenefit":
			
			assertThat(reasonForRetirement_2015Page.getRetirementReasonDeferredBenefitText())
					.matches("You can take early payment of your deferred benefit between the ages of 55 and 65.");
			break;
		case "deferredBenefitHealth":
			
			assertThat(reasonForRetirement_2015Page.getRetirementReasonDeferredBenefitHealthText())
			.matches("You can only choose this option if you’re under 65 or your State Pension Age, whichever is later, and your ill health application has been approved by the Scheme’s medical advisors.");
			break;
		case "earlyPaymentHealth":
			
			assertThat(reasonForRetirement_2015Page.getRetirementReasonEarlyPaymentHealthText())
					.matches("You can only choose this option if you’re under 65 or your State Pension Age, whichever is later, and your ill health application has been approved by the Scheme’s medical advisors.");
			break;
		}
	}

	@Then("^the 2015 reason for retirement submission will be unsuccessful$")
	public void the2015ReasonForRetirementSubmissionWillBeUnsuccessful() {
		reasonForRetirement_2015Page = new ReasonForRetirement_2015Page(driver);
		assertThat(reasonForRetirement_2015Page.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(reasonForRetirement_2015Page.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I dont select any 2015 reason for retirement$")
	public void iDontSelectAny2015ReasonForRetirement() {

		reasonForRetirement_2015Page = new ReasonForRetirement_2015Page(driver);
		reasonForRetirement_2015Page.isRetirementReasonNotSelected();

	}

	@Then("^the default value of 2015 reason for retirement will be blank$")
	public void theDefaultValueOf2015ReasonForRetirementWillBeBlank() {
		assertThat(reasonForRetirement_2015Page.isRetirementReasonRadioButtonSelected()).isFalse();
	}

	
	@And("^the error message '(.*)' for 2015 reason for retirement will be displayed$")
	public void theErrorMessageFor2015ReasonForRetirementWillBeDisplayed(String errorMessage) {
		reasonForRetirement_2015Page = new ReasonForRetirement_2015Page(driver);
		assertThat(reasonForRetirement_2015Page.doesRetirementReasonErrorMessageHaveAnchor()).isTrue();
		assertThat(reasonForRetirement_2015Page.getRetirementReasonAnchoredErrorMessage()).matches(errorMessage);
		assertThat(reasonForRetirement_2015Page.getRetirementReasonFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I go to the 2015 reason for retirement page$")
	public void iGoToThe2015ReasonForRetirementPage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2015-reason-for-retirement");
		reasonForRetirement_2015Page = new ReasonForRetirement_2015Page(driver);
		assertThat(reasonForRetirement_2015Page.getHeading())
				.contains("Why are you claiming your deferred benefits for the 2015 Scheme?");
	}
	
	@Then("^the 2015 reason for retirement page will be displayed$")
	public void the2015ReasonForRetirementPageWillBeDisplayed() {
		reasonForRetirement_2015Page = new ReasonForRetirement_2015Page(driver);
		assertThat(reasonForRetirement_2015Page.getHeading()).contains("Why are you claiming your deferred benefits for the 2015 Section?");
	}

}

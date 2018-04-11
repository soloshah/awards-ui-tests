package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.ReasonForRetirement_2008Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RetirementReason_2008StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private ReasonForRetirement_2008Page reasonForRetirement_2008Page;

	@Then("^the 2008 reason for retirement submission will be successful$")
	public void theReasonForRetirementSubmissionWillBeSuccessful() {
		reasonForRetirement_2008Page = new ReasonForRetirement_2008Page(driver);
		reasonForRetirement_2008Page.selectValidRetirementReason();
		// new NavBarPage(driver);
	}

	@When("^I select 2008 retirement reason as retirementAge$")
	public void ISelect2008RetirementReasonAsRetirementAge() {
		reasonForRetirement_2008Page = new ReasonForRetirement_2008Page(driver);
		reasonForRetirement_2008Page.selectRetirementReasonAge();
		reasonForRetirement_2008Page.selectValidRetirementReason();

	}
	
	@When("^I select valid 2008 retirement reason using (.*)$")
	public void iSelectValid2008RetirementReasonUsing(String field) {
		reasonForRetirement_2008Page = new ReasonForRetirement_2008Page(driver);
		switch (field) {
		case "retirementAge":
			reasonForRetirement_2008Page.selectRetirementReasonAge();
			break;
		case "deferredBenefit":
			reasonForRetirement_2008Page.selectRetirementReasonDeferredBenefit();
			break;
		case "deferredBenefitHealth":
			reasonForRetirement_2008Page.selectRetirementReasonDeferredBenefitHealth();
			break;
		case "earlyPaymentHealth":
			reasonForRetirement_2008Page.selectRetirementReasonEarlyPaymentHealth();
			break;
		}
	}

	@When("^the 2008 valid retirement reason text for (.*) will be displayed$")
	public void the2008ValidRetirementReasonTextForWillBeDisplayed(String field) {
		reasonForRetirement_2008Page = new ReasonForRetirement_2008Page(driver);
		switch (field) {
		case "age":
 		assertThat(reasonForRetirement_2008Page.getRetirementReasonAgeText())
					.matches("This will normally be your 65th birthday.");
			break;
		case "deferredBenefit":
			assertThat(reasonForRetirement_2008Page.getRetirementReasonDeferredBenefitText())
					.matches("You can take early payment of your deferred benefit between the ages of 55 and 65.");
			break;
		case "deferredBenefitHealth":
			
			assertThat(reasonForRetirement_2008Page.getRetirementReasonDeferredBenefitHealthText()).matches(
					"You can only choose this option if you’re under 65 and your ill health application has been approved by the Scheme’s medical advisors.");
			break;
		case "earlyPaymentHealth":
			
			assertThat(reasonForRetirement_2008Page.getRetirementReasonEarlyPaymentHealthText())
					.matches("You can only choose this option if you’re under 65 and your ill health application has been approved by the Scheme’s medical advisors.");
			break;
		}
	}

	@Then("^the 2008 reason for retirement submission will be unsuccessful$")
	public void the2008ReasonForRetirementSubmissionWillBeUnsuccessful() {
		reasonForRetirement_2008Page = new ReasonForRetirement_2008Page(driver);
		assertThat(reasonForRetirement_2008Page.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(reasonForRetirement_2008Page.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I dont select any 2008 reason for retirement$")
	public void iDontSelectAny2008ReasonForRetirement() {

		reasonForRetirement_2008Page = new ReasonForRetirement_2008Page(driver);
		reasonForRetirement_2008Page.isRetirementReasonNotSelected();

	}

	@Then("^the default value of 2008 reason for retirement will be blank$")
	public void theDefaultValueOf2008ReasonForRetirementWillBeBlank() {
		assertThat(reasonForRetirement_2008Page.isRetirementReasonRadioButtonSelected()).isFalse();
	}

	
	@And("^the error message '(.*)' for 2008 reason for retirement will be displayed$")
	public void theErrorMessageFor2008ReasonForRetirementWillBeDisplayed(String errorMessage) {
		reasonForRetirement_2008Page = new ReasonForRetirement_2008Page(driver);
		assertThat(reasonForRetirement_2008Page.doesRetirementReasonErrorMessageHaveAnchor()).isTrue();
		assertThat(reasonForRetirement_2008Page.getRetirementReasonAnchoredErrorMessage()).matches(errorMessage);
		assertThat(reasonForRetirement_2008Page.getRetirementReasonFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I go to the 2008 reason for retirement page$")
	public void iGoToThe2008ReasonForRetirementPage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/2008-reason-for-retirement");
		reasonForRetirement_2008Page = new ReasonForRetirement_2008Page(driver);
		assertThat(reasonForRetirement_2008Page.getHeading())
				.contains("Why are you claiming your deferred benefits for the 2008 Section?");
	}

	
	@Then("^the 2008 reason for retirement page will be displayed$")
	public void the2008ReasonForRetirementPageWillBeDisplayed() {
		reasonForRetirement_2008Page = new ReasonForRetirement_2008Page(driver);
		assertThat(reasonForRetirement_2008Page.getHeading()).contains("Why are you claiming your deferred benefits for the 2008 Section?");
	}
}

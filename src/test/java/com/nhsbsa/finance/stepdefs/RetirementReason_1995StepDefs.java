package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.ReasonForRetirement_1995Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RetirementReason_1995StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private ReasonForRetirement_1995Page reasonForRetirement_1995Page;

	@Then("^the 1995 reason for retirement submission will be successful$")
	public void the1995ReasonForRetirementSubmissionWillBeSuccessful() {
		reasonForRetirement_1995Page = new ReasonForRetirement_1995Page(driver);
		reasonForRetirement_1995Page.selectValidRetirementReason();
		// new NavBarPage(driver);
	}

	@When("^I select valid 1995 retirement reason using (.*)$")
	public void IenterValid1995RetirementReasonUsing(String field) {
		reasonForRetirement_1995Page = new ReasonForRetirement_1995Page(driver);
		switch (field) {
		case "retirementAge":
			reasonForRetirement_1995Page.selectRetirementReasonAge();
			break;
		case "deferredBenefit":
			reasonForRetirement_1995Page.selectRetirementReasonDeferredBenefit();
			break;
		case "deferredBenefitHealth":
			reasonForRetirement_1995Page.selectRetirementReasonDeferredBenefitHealth();
			break;
		case "earlyPaymentHealth":
			reasonForRetirement_1995Page.selectRetirementReasonEarlyPaymentHealth();
			break;
		}
	}

	@When("^the valid 1995 retirement reason text for (.*) will be displayed$")
	public void theValid1995RetirementReasonTextForWillBeDisplayed(String field) {
		reasonForRetirement_1995Page = new ReasonForRetirement_1995Page(driver);
		switch (field) {
		case "age":

			assertThat(reasonForRetirement_1995Page.getRetirementReasonAgeText())
					.matches("This will normally be your 60th birthday.");
			break;
		case "deferredBenefit":

			assertThat(reasonForRetirement_1995Page.getRetirementReasonDeferredBenefitText())
					.matches("Early payment of deferred benefits are available to you at the age of:");
			break;
		case "deferredBenefitHealth":

			assertThat(reasonForRetirement_1995Page.getRetirementReasonDeferredBenefitHealthText()).matches(
					"You can only choose this option if you’re under 60 and your ill health application has been approved by the Scheme’s medical advisors.");
			break;
		case "earlyPaymentHealth":

			assertThat(reasonForRetirement_1995Page.getRetirementReasonEarlyPaymentHealthText())
					.matches("joined the NHS Pension Scheme on or after 06/03/1995");
			break;
		}
	}

	@Then("^the 1995 reason for retirement submission will be unsuccessful$")
	public void the1995ReasonForRetirementSubmissionWillBeUnsuccessful() {
		reasonForRetirement_1995Page = new ReasonForRetirement_1995Page(driver);
		assertThat(reasonForRetirement_1995Page.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(reasonForRetirement_1995Page.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I dont select any 1995 reason for retirement$")
	public void iDontSelectAny1995ReasonForRetirement() {

		reasonForRetirement_1995Page = new ReasonForRetirement_1995Page(driver);
		reasonForRetirement_1995Page.isRetirementReasonNotSelected();

	}

	@Then("^the default value of 1995 reason for retirement will be blank$")
	public void theDefaultValueOf1995ReasonForRetirementWillBeBlank() {
		assertThat(reasonForRetirement_1995Page.isRetirementReasonRadioButtonSelected()).isFalse();
	}

	
	@And("^the 1995 reason for retirement error message '(.*)' will be displayed$")
	public void the1995ReasonForRetirementErrorMessageWillBeDisplayed(String errorMessage) {
		reasonForRetirement_1995Page = new ReasonForRetirement_1995Page(driver);
		assertThat(reasonForRetirement_1995Page.doesRetirementReasonErrorMessageHaveAnchor()).isTrue();
		assertThat(reasonForRetirement_1995Page.getRetirementReasonAnchoredErrorMessage()).matches(errorMessage);
		assertThat(reasonForRetirement_1995Page.getRetirementReasonFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I go to the 1995 reason for retirement page$")
	public void iGoToThe1995ReasonForRetirementPage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/1995-reason-for-retirement");
		reasonForRetirement_1995Page = new ReasonForRetirement_1995Page(driver);
		assertThat(reasonForRetirement_1995Page.getHeading())
				.contains("Why are you claiming your deferred benefits for the 1995 Section?");
	}

}

package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.LifetimeAllowancePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LifetimeAllowanceStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private LifetimeAllowancePage lifetimeAllowancePage;

	@Given("^I am on lifetime allowance page$")
	public void iAmOnLifetimeAllowancePage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-arrangement-details/do-you-have-lifetime-allowance");
	}

	@Given("^I go to lifetime allowance page$")
	public void iGoToLifetimeAllowancePage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-arrangement-details/do-you-have-lifetime-allowance");
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		assertThat(lifetimeAllowancePage.getHeading()).contains("Do you have HMRC Lifetime Allowance protection?");
	}

	@Then("^the default value for lifetime allowance will be blank$")
	public void theDefaultValueForLifetimeAllowanceWillBeBlank() {
		assertThat(lifetimeAllowancePage.isLifeTimeAllowanceRadioButtonSelected()).isFalse();
	}

	@And("^the certificate number error message '(.*)' will be displayed$")
	public void theCertificateNumberPageErrorMessageWillBeDisplayed(String errorMessage) {
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		assertThat(lifetimeAllowancePage.getCertNumberFieldErrorMessage()).matches(errorMessage);
		assertThat(lifetimeAllowancePage.doesCertNumberErrorMessageHaveAnchor()).isTrue();
		assertThat(lifetimeAllowancePage.getCertNumberAnchoredErrorMessage()).matches(errorMessage);
	}

	@When("^I select Yes on lifetime allowance page$")
	public void iSelectYesOnLifetimeAllowancePage() {
		SharedData.sharedNHSRadioButton = "Yes";
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		lifetimeAllowancePage.selectYes();
	}

	@When("^I select No on lifetime allowance page$")
	public void iSelectNoOnLifetimeAllowancePage() {
		SharedData.sharedNHSRadioButton = "No";
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		lifetimeAllowancePage.selectNo();
	}

	@When("^the certificate number field will be displayed$")
	public void theCertificateNumberFieldsWillBeDisplayed() {

		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		assertThat(lifetimeAllowancePage.getCertNumberHeading().contains("Certificates or reference number"));

	}

	@When("^I enter the valid certificate number$")
	public void IenterTheValidCertificateNumber() {
		SharedData.certNumber = "A5528888";
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		lifetimeAllowancePage.submitValidCertNumber(SharedData.certNumber);
	}

	@When("^I enter certificateNumber with different valid value$")
	public void IenterCertificateNumberWithDifferenrtValidValue() {
		SharedData.certNumber = "FP1612345678912";
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		lifetimeAllowancePage.submitValidCertNumber(SharedData.certNumber);
	}

	@When("^the certificateNumber details are sustained$")
	public void theCertificateNumberDetailsAreSustained() {
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		assertThat(lifetimeAllowancePage.getCertNumberValue()).matches(SharedData.certNumber);
	}

	@When("^I enter the valid certificate number using the certNumber '(.*)'$")
	public void IenterTheValidCertificateNumberUsingTheCertNumber(String certNumber) {
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		lifetimeAllowancePage.submitValidCertNumber(certNumber);
	}

	@When("^I enter invalid certificate number using the certNumber '(.*)'$")
	public void iEnterInvalidCertificateNumberUsingTheCertNumber(String certNumber) {

		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		lifetimeAllowancePage.enterCertNumber(certNumber);
		lifetimeAllowancePage.submitInValidCertNumber();

	}

	@When("^I dont select anything on lifetime allowance page$")
	public void iDontSelectAnythingOnLifetimeAllowancePage() {
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		lifetimeAllowancePage.lifetimeAllowanceIsNotSelected();
	}

	@And("^the lifetime allowance error message '(.*)' will be displayed$")
	public void theLifetimeAllowanceErrorMessageWillBeDisplayed(String errorMessage) {
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		assertThat(lifetimeAllowancePage.doesLifetimeAllowanceErrorMessageHaveAnchor()).isTrue();
		assertThat(lifetimeAllowancePage.getLifetimeAllowanceAnchoredErrorMessage()).matches(errorMessage);
		assertThat(lifetimeAllowancePage.getLifetimeAllowanceFieldErrorMessage()).matches(errorMessage);
	}

	@Then("^the lifetime allowance submission will be unsuccessful$")
	public void theLifetimeAllowanceSubmissionWillBeUnsuccessful() {
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		assertThat(lifetimeAllowancePage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(lifetimeAllowancePage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@Then("^the lifetime allowance submission will be successful$")
	public void theLifetimeAllowanceSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the lifetime allowance page will be displayed$")
	public void theLifetimeAllowancePageWillBeDisplayed() {
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		assertThat(lifetimeAllowancePage.getHeading()).contains("Do you have HMRC Lifetime Allowance protection?");
	}

	@Then("^the lifetime allowance details are sustained$")
	public void theLifetimeAllowanceDetailsAreSustained() {
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		assertThat(lifetimeAllowancePage.getYesRadioButton()).matches(SharedData.sharedNHSRadioButton);

	}

	@When("^I select lifetimeAllowance with different valid option$")
	public void iSelectLifetimeAllowanceWithDifferentValidOption() {
		iSelectNoOnLifetimeAllowancePage();
	}
	
	@When("^I click next on lifetime allowance page$")
	public void iClickNextOnLifetimeAllowancePage() {
		lifetimeAllowancePage = new LifetimeAllowancePage(driver);
		lifetimeAllowancePage.nextStep();
	}

}
package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.WhichSchemePage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WhichSchemeStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private WhichSchemePage whichSchemePage;
	private RetirementReason_1995StepDefs retirement1995Steps;
	private RetirementReason_2008StepDefs retirement2008Steps;
	private LumpSumChoice_1995StepDefs lumpsum1995Steps;
	private LumpSumChoice_2008StepDefs lumpsum2008Steps;
	private SharedYeNoStepDefs sharedYesNoSteps;

	@When("^I select the options for 1995 on next navigating pages$")
	public void iSelectTheOptionsFor1995OnNextNavigatingPages() {

		retirement1995Steps = new RetirementReason_1995StepDefs();
		retirement1995Steps.ISelect1995RetirementReasonAsRetirementAge();
		lumpsum1995Steps = new LumpSumChoice_1995StepDefs();
		lumpsum1995Steps.the1995LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectNo();
	}

	@When("^I select the options for 2008 on next navigating pages$")
	public void iSelectTheOptionsFor2008OnNextNavigatingPages() {

		retirement2008Steps = new RetirementReason_2008StepDefs();
		retirement2008Steps.ISelect2008RetirementReasonAsRetirementAge();
		lumpsum2008Steps = new LumpSumChoice_2008StepDefs();
		lumpsum2008Steps.the2008LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectNo();
	}

	@When("^I select 1995 Section scheme$")
	public void Iselect1995SectionScheme() {
		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.select1995Section();
		whichSchemePage.selectWhichScheme();
	}

	@When("^I select 2008 Section scheme$")
	public void Iselect2008SectionScheme() {
		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.select2008Section();
		whichSchemePage.selectWhichScheme();
	}

	@When("^I select 2015 Section scheme$")
	public void Iselect2015SectionScheme() {
		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.select2015Section();
		whichSchemePage.selectWhichScheme();

	}

	@Then("^the scheme selection submission will be unsuccessful$")
	public void theSchemeSelectionSubmissionWillBeUnsuccessful() {
		whichSchemePage = new WhichSchemePage(driver);
		assertThat(whichSchemePage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(whichSchemePage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I dont select any scheme$")
	public void iDontSelectAnyScheme() {

		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.isWhichSchemeNotSelected();

	}

	@Then("^the default value of which scheme will be blank$")
	public void theDefaultValueOfWhichSchemeWillBeBlank() {
		assertThat(whichSchemePage.isWhichSchemeCheckboxSelected()).isFalse();
	}

	@And("^the error message '(.*)' for scheme selection will be displayed$")
	public void theErrorMessageForSchemeSelectionWillBeDisplayed(String errorMessage) {
		whichSchemePage = new WhichSchemePage(driver);
		assertThat(whichSchemePage.doesWhichSchemeErrorMessageHaveAnchor()).isTrue();
		assertThat(whichSchemePage.getWhichSchemeAnchoredErrorMessage()).matches(errorMessage);
		assertThat(whichSchemePage.getWhichSchemeFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I go to which scheme page$")
	public void iGoToWhichSchemePage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-scheme-details/which-scheme");
		whichSchemePage = new WhichSchemePage(driver);
		assertThat(whichSchemePage.getHeading()).contains("Which Section or Scheme are you claiming benefits from?");
	}

	@Then("^which scheme page will be displayed$")
	public void whichSchemePageWillBeDisplayed() {
		whichSchemePage = new WhichSchemePage(driver);
		assertThat(whichSchemePage.getHeading()).contains("Which Section or Scheme are you claiming benefits from?");
	}

	@When("^I select schemes under 1995 and 2008 Section$")
	public void iSelectSchemesUnder1995And2008Section() {

		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.select1995Section();
		whichSchemePage.select2008Section();
		whichSchemePage.selectWhichScheme();
	}

	@When("^I select schemes under 1995 and 2015 Section$")
	public void iSelectSchemesUnder1995And2015Section() {

		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.select1995Section();
		whichSchemePage.select2015Section();
		whichSchemePage.selectWhichScheme();
	}

	@When("^I select schemes under 2008 and 2015 Section$")
	public void iSelectSchemesUnder2008And2015Section() {

		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.select2008Section();
		whichSchemePage.select2015Section();
		whichSchemePage.selectWhichScheme();
	}

	@When("^I select all the schemes$")
	public void iSelectAllTheSchemes() {

		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.select1995Section();
		whichSchemePage.select2008Section();
		whichSchemePage.select2015Section();
		whichSchemePage.selectWhichScheme();
	}

	@And("^I click on scheme information link$")
	public void iClickOnSchemeInformationLink() {
		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.selectSchemeInformation();
	}
	
	@Then("^the which scheme details are sustained$")
	public void theWhichSchemeDetailsAreSustained() {
		whichSchemePage = new WhichSchemePage(driver);
		assertThat(whichSchemePage.is1995CheckboxSelected()).isTrue();

	}
	
	@When("^I select one more scheme using different valid option$")
	public void iSelectOneMoreSchemeUsingDifferentValidOption() {
		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.select2008Section();
		whichSchemePage.selectWhichScheme();

	}

}

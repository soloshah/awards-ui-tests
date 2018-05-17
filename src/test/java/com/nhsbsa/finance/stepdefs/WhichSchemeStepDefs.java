package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

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
	private RetirementReasonStepDefs retirementSteps;
	private LumpSumChoiceStepDefs lumpsumSteps;
	private SharedYeNoStepDefs sharedYesNoSteps;

	@When("^I select the options for 1995 on next navigating pages$")
	public void iSelectTheOptionsFor1995OnNextNavigatingPages() {

		retirementSteps = new RetirementReasonStepDefs();
		retirementSteps.ISelectRetirementReasonAsRetirementAge();
		lumpsumSteps = new LumpSumChoiceStepDefs();
		lumpsumSteps.the1995LumpsumChoicePageWillBeDisplayed();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectNo();
	}

	@When("^I select the options for 2008 on next navigating pages$")
	public void iSelectTheOptionsFor2008OnNextNavigatingPages() {

		retirementSteps = new RetirementReasonStepDefs();
		retirementSteps.ISelectRetirementReasonAsRetirementAge();
		lumpsumSteps = new LumpSumChoiceStepDefs();
		lumpsumSteps.the2008LumpsumChoicePageWillBeDisplayed();
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
	
	
	@And("^the new scheme information page will be displayed$")
	public void theNewSchemeInformationPageWillBeDisplayed() {
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		driver.get("https://apps.nhsbsa.nhs.uk/choice/MemberID.html");
		driver.getPageSource().contains("Pension identification tool");
		driver.close();
		driver.switchTo().window(browserTabs.get(0));

	}
	
	@Then("^the which scheme details are sustained$")
	public void theWhichSchemeDetailsAreSustained() {
		whichSchemePage = new WhichSchemePage(driver);
		assertThat(whichSchemePage.is1995CheckboxSelected()).isTrue();

	}
	
	@When("^I select scheme using different valid option$")
	public void iSelectSchemeUsingDifferentValidOption() {
		whichSchemePage = new WhichSchemePage(driver);
		whichSchemePage.select1995Section();
		whichSchemePage.select2008Section();
		whichSchemePage.selectWhichScheme();

	}

}

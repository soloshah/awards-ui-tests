package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.IntendToWorkForNHSPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IntendToWorkForNHSStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private IntendToWorkForNHSPage intendToWorkForNHSPage;
	private WorkingForNHSStepDefs workingForNHSSteps;
	private DateYouLeaveStepDefs dateYouLeaveSteps;
	private NameOfYourLastEmployerStepDefs lastEmployerNameSteps;
	private JobTitleStepDefs jobTitleSteps;
	private SharedYeNoStepDefs sharedYesNoSteps;

	@Given("^I go to intend to work for NHS page$")
	public void iGoToIntendToWorkForNHSPage() {
		new Page(driver).navigateToUrl(baseUrl + "/employment-details/do-you-intend-to-work-for-nhs");
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		assertThat(intendToWorkForNHSPage.getHeading())
				.contains("Do you plan to work for the NHS after you get your pension?");
	}

	@Then("^the intend to work for NHS page will be displayed$")
	public void theIntendToWorkForNHSPageWillbeDisplayed() {
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		assertThat(intendToWorkForNHSPage.getHeading())
				.contains("Do you plan to work for the NHS after you get your pension?");

	}

	@When("^I click next on intend to work page$")
	public void iClickNextOnIntendToWorkPage() {
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		intendToWorkForNHSPage.nextStep();
	}

	@And("^intend to work for NHS Page error message '(.*)' will be displayed$")
	public void intendToWorkForNhsPageErrorMessageWillBeDisplayed(String errorMessage) {
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		assertThat(intendToWorkForNHSPage.getNhsFieldErrorMessage()).matches(errorMessage);
		assertThat(intendToWorkForNHSPage.doesNhsErrorMessageHaveAnchor()).isTrue();
		assertThat(intendToWorkForNHSPage.getNhsAnchoredErrorMessage()).matches(errorMessage);

	}

	@When("^I choose Yes$")
	public void iChooseYes() {
		SharedData.sharedNHSRadioButton = "Yes";
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		intendToWorkForNHSPage.submitValidYesNhsDetails();
	}

	@When("^I choose No$")
	public void iChooseNo() {
		SharedData.sharedNHSRadioButton = "No";
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		intendToWorkForNHSPage.submitValidNoDetails();
	}

	@When("^I dont choose anything$")
	public void iDontChooseAnything() {
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		intendToWorkForNHSPage.intendToWorkForNHSIsNotSelected();
	}

	@When("^the date you return to work fields will be displayed$")
	public void theDateYouReturnToWorkfieldsWillBeDisplayed() {

		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		assertThat(intendToWorkForNHSPage.getDateHeading().contains("What date will you be returning work?"));
		assertThat(intendToWorkForNHSPage.getExampleReturnDateHint().matches("For example, 31 3 1980"));

	}

	@When("^I enter the valid date$")
	public void IenterTheValidDate() {
		String randomDateString = SharedMethods.randomDateGenerator();
		LocalDate localDate = LocalDate.parse(randomDateString);
		SharedData.returnDay = SharedMethods.formatDay(localDate);
		SharedData.returnMonth = SharedMethods.formatMonth(localDate);
		SharedData.returnYear = SharedMethods.formatYear(localDate);
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		intendToWorkForNHSPage.submitValidDate(SharedData.returnDay, SharedData.returnMonth, SharedData.returnYear);
	}

	@When("^I enter invalid date details using the day '(.*)', month '(.*)' and year '(.*)'$")
	public void iEnterInvalidDateDetailsUsingTheDayMonthAndYear(String day, String month, String year) {

		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		intendToWorkForNHSPage.enterDateDetails(day, month, year);
		intendToWorkForNHSPage.submitInValidDateDetails();

	}

	@And("^the date you return to work error message '(.*)' will be displayed$")
	public void theDateYouReturnToWorkErrorMessageWillBeDisplayed(String errorMessage) {
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		assertThat(intendToWorkForNHSPage.doesDateErrorMessageHaveAnchor()).isTrue();
		assertThat(intendToWorkForNHSPage.getDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(intendToWorkForNHSPage.getDateFieldErrorMessage()).matches(errorMessage);
	}

	@Then("^the intend to work for NHS submission will be unsuccessful$")
	public void theIntendToWorkForNHSSubmissionWillBeUnsuccessful() {
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		assertThat(intendToWorkForNHSPage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(intendToWorkForNHSPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@Then("^the intend to work for NHS submission will be successful$")
	public void theIntendToWorkForNHSSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the intend to work details are sustained$")
	public void theIntendToWorkDetailsAreSustained() {
		intendToWorkForNHSPage = new IntendToWorkForNHSPage(driver);
		assertThat(intendToWorkForNHSPage.getYesRadioButton()).matches(SharedData.sharedRadioButton);
		// assertThat(intendToWorkForNHSPage.getDay()).matches(SharedData.returnDay);
		// assertThat(intendToWorkForNHSPage.getMonth()).matches(SharedData.returnMonth);
		assertThat(intendToWorkForNHSPage.getYear()).matches(SharedData.returnYear);

	}

	@When("^I enter return date using different valid details$")
	public void iEnterReturnDateUsingDifferentDetails() {
		IenterTheValidDate();
	}

	@When("^I enter employment details$")
	public void iEnterEmploymentDetails() {
		workingForNHSSteps = new WorkingForNHSStepDefs();
		workingForNHSSteps.iGoToWorkingForNHSPage();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectNo();
		lastEmployerNameSteps = new NameOfYourLastEmployerStepDefs();
		lastEmployerNameSteps.whatWasTheNameofYourLastEmployerPageWillBeDisplayed();
		lastEmployerNameSteps.IenterValidNameOfLastNHSEmployerDetails();
		jobTitleSteps = new JobTitleStepDefs();
		jobTitleSteps.theJobTitlePageWillBeDisplayed();
		jobTitleSteps.IenterValidJobTitleDetails();
		dateYouLeaveSteps = new DateYouLeaveStepDefs();
		dateYouLeaveSteps.theDateYouleavePageWillBeDisplayed();
		dateYouLeaveSteps.IenterValidDateDetails();
		theIntendToWorkForNHSPageWillbeDisplayed();

	}

}
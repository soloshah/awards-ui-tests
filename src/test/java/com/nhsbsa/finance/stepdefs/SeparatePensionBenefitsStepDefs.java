package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.SeparatePensionBenefitsPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeparatePensionBenefitsStepDefs {

	private String baseUrl = PropertyReader.getProperty("base.server");
	private WebDriver driver = Config.getDriver();

	private SeparatePensionBenefitsPage separatePensionBenefitsPage;

	@Then("^the separate pension benefits page will be displayed$")
	public void theSeparatePensionBenefitsPageWillBeDisplayed() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.getHeading()).contains("Do you have any separate pension benefits?");
	}

	@When("^I go to separate benefits page$")
	public void iGoToSeparateBenefitsPage() {
		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/pension-arrangement-details/do-you-have-separate-pension-benefits");
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.getHeading()).contains("Do you have any separate pension benefits?");
	}

	@When("^I select after April 6 2006 option$")
	public void iSelectAfterApril62006Option() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.selectAfter6April();

	}

	@When("^I select before April 6 2006 option$")
	public void iSelectBeforeApril62006Option() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.selectBefore6April();

	}

	@When("^I select dont have information$")
	public void IselectDontHaveInformation() {
		SharedData.sharedCheckBox = "I don't have this information";
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.selectNoInformation();
		separatePensionBenefitsPage.submitSeperateBenefit();
	}

	@When("^I select dont have separate benefits$")
	public void IselectDontHaveSeparateBenefits() {
		SharedData.sharedCheckBox = "I don't have any separate benefits";
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.selectNoSeparateBenefits();
		separatePensionBenefitsPage.submitSeperateBenefit();
	}

	@When("^I select after and before april 6 2006$")
	public void IselectAfterAndBeforeApril62006() throws InterruptedException {
		iSelectAfterApril62006Option();
		iEnterTheTotalCombinedPercentageOfLifetimeAllowance();
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		LocalDate plusYear = LocalDate.now().minusYears(11);
		SharedData.day = SharedMethods.formatDay(plusYear);
		SharedData.month = SharedMethods.formatMonth(plusYear);
		SharedData.year = SharedMethods.formatYear(plusYear);
		separatePensionBenefitsPage.enterBenefitCrystallisationDate(SharedData.day, SharedData.month, SharedData.year);
		iSelectBeforeApril62006Option();
		iEnterTheGrossAnnualRate();
	}
	
	@Then("^the separate benefits submission will be unsuccessful$")
	public void theSeparateBenefitsSubmissionWillBeUnsuccessful() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(separatePensionBenefitsPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
	}

	@When("^I dont select any option$")
	public void iDontSelectAnyOption() {

		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.isSeparateBenefitNotSelected();

	}
	
	@When("^I select after and before april 6 2006 and I dont have information$")
	public void IselectAfterAndBeforeApril62006AndIdontHaveInformation() throws InterruptedException {
		iSelectAfterApril62006Option();
		iEnterTheTotalCombinedPercentageOfLifetimeAllowance();
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		LocalDate plusYear = LocalDate.now().minusYears(11);
		SharedData.day = SharedMethods.formatDay(plusYear);
		SharedData.month = SharedMethods.formatMonth(plusYear);
		SharedData.year = SharedMethods.formatYear(plusYear);
		separatePensionBenefitsPage.enterBenefitCrystallisationDate(SharedData.day, SharedData.month, SharedData.year);
		iSelectBeforeApril62006Option();
		SharedData.grossAnnualRate = "987654.98";
		separatePensionBenefitsPage.enterGrossAnnualRate(SharedData.grossAnnualRate);
		IselectDontHaveInformation();
		
	}
	
	

	@Then("^the default value of separate benefits will be blank$")
	public void theDefaultValueOfSeparateBenefitsWillBeBlank() {
		assertThat(separatePensionBenefitsPage.isSeparateBenefitCheckboxSelected()).isFalse();
	}

	@And("^the error message '(.*)' for separate benefits page will be displayed$")
	public void theErrorMessageForSeparateBenefitsPageWillBeDisplayed(String errorMessage) {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.doesSeparateBenefitsErrorMessageHaveAnchor()).isTrue();
		assertThat(separatePensionBenefitsPage.getSeparateBenefitsAnchoredErrorMessage()).matches(errorMessage);
		assertThat(separatePensionBenefitsPage.getSeparateBenefitFieldErrorMessage()).matches(errorMessage);
	}

	@And("^the error message '(.*)' for benefit crystallisation date will be displayed$")
	public void theErrorMessageForBenefitCrystallisationDateWillBeDisplayed(String errorMessage) {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.doesBenefitDateErrorMessageHaveAnchor()).isTrue();
		assertThat(separatePensionBenefitsPage.getBenefitDateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(separatePensionBenefitsPage.getBenefitDateFieldErrorMessage()).matches(errorMessage);
	}

	@And("^the error message '(.*)' for gross annual rate will be displayed$")
	public void theErrorMessageForGrossAnnualRateWillBeDisplayed(String errorMessage) {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.doesGrossAnnualRateErrorMessageHaveAnchor()).isTrue();
		assertThat(separatePensionBenefitsPage.getGrossAnnualRateAnchoredErrorMessage()).matches(errorMessage);
		assertThat(separatePensionBenefitsPage.getGrossAnnualRateFieldErrorMessage()).matches(errorMessage);
	}

	@And("^the error message '(.*)' for annual LTA will be displayed$")
	public void theErrorMessageForAnnualLTAWillBeDisplayed(String errorMessage) {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.doesAnnualLTAErrorMessageHaveAnchor()).isTrue();
		assertThat(separatePensionBenefitsPage.getAnnualLTAAnchoredErrorMessage()).matches(errorMessage);
		assertThat(separatePensionBenefitsPage.getAnnualLTAFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter the invalid date for benefit crystallisation using the day '(.*)', month '(.*)' and year '(.*)'$")
	public void iEnterInvalidDateForBenefitCrystallisationUsingTheDayMonthAndYear(String day, String month,
			String year) {

		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.enterBenefitCrystallisationDate(day, month, year);
		separatePensionBenefitsPage.submitInvalidDetails();

	}

	@And("^I enter the benefit crystallisation date greater than today's date$")
	public void iEnterTheBenefitCrystallisationDateGreaterThanTodaysDate() {
		LocalDate futuredate = LocalDate.now().plusDays(1);
		SharedData.day = SharedMethods.formatDay(futuredate);
		SharedData.month = SharedMethods.formatMonth(futuredate);
		SharedData.year = SharedMethods.formatYear(futuredate);
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.enterBenefitCrystallisationDate(SharedData.day, SharedData.month, SharedData.year);
		separatePensionBenefitsPage.submitInvalidDetails();
	}

	@When("^I enter the invalid gross annual rate using '(.*)'$")
	public void iEnterTheInvalidGrossAnnualRatesUsing(String annualRate) throws InterruptedException {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.enterGrossAnnualRate(annualRate);
		separatePensionBenefitsPage.submitInvalidDetails();
		Thread.sleep(3000);
	}

	@When("^I enter the invalid total percentage of LTA using '(.*)'$")
	public void iEnterTheInvalidTotalPercentageOfLTAUsing(String LTA) {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.enterCombinedLTA(LTA);

	}

	@When("^I enter the total combined percentage of lifetime allowance$")
	public void iEnterTheTotalCombinedPercentageOfLifetimeAllowance() {
	SharedData.combinedLTA = "123456.78";
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.enterCombinedLTA(SharedData.combinedLTA);
	
	}

	@When("^I enter the gross annual rate$")
	public void iEnterTheGrossAnnualRate() {
		SharedData.grossAnnualRate = "987654321125.98";
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.enterGrossAnnualRate(SharedData.grossAnnualRate);
		separatePensionBenefitsPage.submitSeperateBenefit();
	
	}

	@And("^I enter the date of first benefit crystallisation$")
	public void iEnterTheDateOfFirstBenefitCrystallisation() {
		LocalDate plusYear = LocalDate.now().minusYears(11);
		SharedData.day = SharedMethods.formatDay(plusYear);
		SharedData.month = SharedMethods.formatMonth(plusYear);
		SharedData.year = SharedMethods.formatYear(plusYear);
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.enterBenefitCrystallisationDate(SharedData.day, SharedData.month, SharedData.year);
		separatePensionBenefitsPage.submitSeperateBenefit();
	}
	
	
	@When("^I click next on separate benefit page$")
	public void iClickNextOnSeparateBenefitPage() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.nextStep();
	}
	
	@Then("^the combinedLTA details are sustained$")
	public void theCombinedLTADetailsAreSustained() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.getCombinedLTA()).matches(SharedData.combinedLTA);
	}

	@When("^I enter combinedLTA with different valid value$")
	public void iEnterCombinedLTAWithDifferentValidValue() {
		SharedData.combinedLTA = "852656";
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.enterCombinedLTA(SharedData.combinedLTA);
		separatePensionBenefitsPage.submitSeperateBenefit();
	}

	@Then("^the benefitCrysallisationDate details are sustained$")
	public void thebenefitCrysallisationDatebDetailsAreSustained() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.getDay()).matches(SharedData.day);
		//assertThat(separatePensionBenefitsPage.getMonth()).matches(SharedData.month);
		assertThat(separatePensionBenefitsPage.getYear()).matches(SharedData.year);

	}

	@When("^I enter benefitCrysallisationDate with different valid value$")
	public void iEnterBenefitCrysallisationDateWithDifferentValidValue() {
		iEnterTheDateOfFirstBenefitCrystallisation();
	}
	
	@Then("^the grossAnnualRate details are sustained$")
	public void theGrossAnnualRateDetailsAreSustained() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.getGrossAnnualRate()).matches(SharedData.grossAnnualRate);
	}

	@When("^I enter grossAnnualRate with different valid value$")
	public void iEnterGrossAnnualRateWithDifferentValidValue() {
		SharedData.grossAnnualRate = "852656";
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		separatePensionBenefitsPage.enterGrossAnnualRate(SharedData.grossAnnualRate);
		separatePensionBenefitsPage.submitSeperateBenefit();
	}

	@Then("^the separateBenefit details are sustained$")
	public void theSeparateBenefitDetailsAreSustained() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.isAfterApril6CheckboxSelected()).isTrue();
		assertThat(separatePensionBenefitsPage.isBeforeApril6CheckboxSelected()).isTrue();
		assertThat(separatePensionBenefitsPage.isIDontHaveInformationCheckboxSelected()).isTrue();
	}

	@When("^I select separateBenefit with different valid option$")
	public void iSelectSeparateBenefitWithDifferentValidOption() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.isIDontHaveInformationCheckboxSelected()).isTrue();
		separatePensionBenefitsPage.selectNoInformation();
		IselectDontHaveSeparateBenefits();
		
	}



}
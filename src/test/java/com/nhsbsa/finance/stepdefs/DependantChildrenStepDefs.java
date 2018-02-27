package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DependantChildrenPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DependantChildrenStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private DependantChildrenPage dependantChildrenPage;

	@Given("^I am on dependant children page$")
	public void iAmOnDependantChildrenPage() {
		new Page(driver).navigateToUrl(baseUrl + "/partner-and-child/do-you-have-any-dependant-children");
	}

	@Given("^I go to dependant children page$")
	public void iGoToDependantChildrenPage() {
		new Page(driver).navigateToUrl(baseUrl + "/partner-and-child/do-you-have-any-dependant-children");
		dependantChildrenPage = new DependantChildrenPage(driver);
		assertThat(dependantChildrenPage.getHeading()).contains("Do you have any dependant children?");
	}

	@Then("^the default value for dependant children page will be blank$")
	public void theDefaultValueForDependantChildrenPageWillBeBlank() {
		assertThat(dependantChildrenPage.isDependantChildrenRadioButtonSelected()).isFalse();
	}

	@Then("^ Do you have any dependant children page will be displayed$")
	public void areYouWorkingForNHSPageWillBeDisplayed() {
		dependantChildrenPage = new DependantChildrenPage(driver);
		assertThat(dependantChildrenPage.getHeading()).matches("Do you have any dependant children?");
	}

	@And("^the dependant children page error message '(.*)' will be displayed$")
	public void theDependantChildrenPageErrorMessageWillBeDisplayed(String errorMessage) {
		dependantChildrenPage = new DependantChildrenPage(driver);
		assertThat(dependantChildrenPage.getDependantChildrenFieldErrorMessage()).matches(errorMessage);
		assertThat(dependantChildrenPage.doesDependantChildrenErrorMessageHaveAnchor()).isTrue();
		assertThat(dependantChildrenPage.getDependantChildrenAnchoredErrorMessage()).matches(errorMessage);

	}

	@When("^I will select Yes$")
	public void iWillSelectYes() {
		dependantChildrenPage = new DependantChildrenPage(driver);
		dependantChildrenPage.selectValidYesDetails();
	}

	@When("^I will select No$")
	public void iWillSelectNo() {
		dependantChildrenPage = new DependantChildrenPage(driver);
		dependantChildrenPage.selectValidNoDetails();
	}

	@When("^I wont select anything$")
	public void iWontSelectAnything() {
		dependantChildrenPage = new DependantChildrenPage(driver);
		dependantChildrenPage.dependantChildrenIsNotSelected();
	}
}
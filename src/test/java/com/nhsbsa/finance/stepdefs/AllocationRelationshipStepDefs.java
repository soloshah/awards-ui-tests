package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.AllocationRelationshipPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllocationRelationshipStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private AllocationRelationshipPage allocationRelationshipPage;

	@Given("^I am on the relationship page$")
	public void iAmOnTheRelationshipPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-allocation-relationship");
	}

	@Given("^I go to the relationship page$")
	public void iGoToTheRelationshipPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-allocation-relationship");
		allocationRelationshipPage = new AllocationRelationshipPage(driver);
		assertThat(allocationRelationshipPage.getHeading()).contains("What is their relationship to you?");
	}

	@Then("^the relationship submission will be successful$")
	public void theRelationshipSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@Then("^the allocation relationship page will be displayed$")
	public void theAllocationRelationshipPageWillBeDisplayed() {
		allocationRelationshipPage = new AllocationRelationshipPage(driver);
		assertThat(allocationRelationshipPage.getHeading()).contains("What is their relationship to you?");
	}

	
	@When("^I enter valid relationship details$")
	public void IenterValidRelationshipDetails() {
		SharedData.relationship = "Wife";
		allocationRelationshipPage = new AllocationRelationshipPage(driver);
		allocationRelationshipPage.submitValidAllocationRelationship(SharedData.relationship);
	}
	
	

	@Then("^the relationship submission will be unsuccessful$")
	public void theRelationshipSubmissionWillBeUnsuccessful() {
		allocationRelationshipPage = new AllocationRelationshipPage(driver);
		assertThat(allocationRelationshipPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly.");
		assertThat(allocationRelationshipPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter relationship name details using the name '(.*)'$")
	public void iEnterRelationshipDetailsUsingTheTitle(String relationship) {
		allocationRelationshipPage = new AllocationRelationshipPage(driver);
		allocationRelationshipPage.enterRelationshipDetails(relationship);
		allocationRelationshipPage.submitInValidRelationshipDetails();
	}

	@And("^the relationship name error message '(.*)' will be displayed$")
	public void theRelationshipErrorMessageWillBeDisplayed(String errorMessage) {
		allocationRelationshipPage = new AllocationRelationshipPage(driver);
		assertThat(allocationRelationshipPage.doesRelationshipErrorMessageHaveAnchor()).isTrue();
		assertThat(allocationRelationshipPage.getRelationshipAnchoredErrorMessage()).matches(errorMessage);
		assertThat(allocationRelationshipPage.getRelationshipFieldErrorMessage()).matches(errorMessage);
	}

}

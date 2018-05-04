package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.AllocationRelationshipPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllocationRelationshipStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private AllocationRelationshipPage allocationRelationshipPage;
	private AllocationNameStepDefs allocationNameSteps;
	private AllocationDOBStepDefs allocationDobSteps;
	private MaritalStatusStepDefs maritalStatusSteps;
	private DependantChildrenStepDefs dependantChildrenSteps;
	private SharedYeNoStepDefs sharedYeNoSteps;
	private AllocatePensionStepDefs allocationPensionSteps;

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

	@When("^I enter valid dependant details$")
	public void IenterValidDependantDetails() {
		maritalStatusSteps = new MaritalStatusStepDefs();
		maritalStatusSteps.iGoToTheMaritalStatusPage();
		maritalStatusSteps.iSelectMaritalStatusAsSingle();
		dependantChildrenSteps = new DependantChildrenStepDefs();
		dependantChildrenSteps.doYouHaveAnyDependantChildrenPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectNo();
		allocationPensionSteps = new AllocatePensionStepDefs();
		allocationPensionSteps.doYouWantToAllocatePensionPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectYes();
		allocationNameSteps = new AllocationNameStepDefs();
		allocationNameSteps.iGoToTheAllocationNamePage();
		allocationNameSteps.IenterValidAllocationName();
		allocationDobSteps = new AllocationDOBStepDefs();
		allocationDobSteps.theAllocationDateOfBirthPageWillBeDisplayed();
		allocationDobSteps.IenterValidAllocationDOB();

	}

	
	@Then("^the relationship submission will be unsuccessful$")
	public void theRelationshipSubmissionWillBeUnsuccessful() {
		allocationRelationshipPage = new AllocationRelationshipPage(driver);
		assertThat(allocationRelationshipPage.getErrorHeadingErrorMessage()).matches("Your form contains errors");
		assertThat(allocationRelationshipPage.getErrorsBelowErrorMessage()).matches("Check your answer:");
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

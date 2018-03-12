package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.RelationshipPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RelationshipStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private RelationshipPage relationshipPage;

	@Given("^I am on the relationship page$")
	public void iAmOnTheRelationshipPage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-allocation-details/what-is-allocation-relationship");
	}

	@Given("^I go to the relationship page$")
	public void iGoToTheRelationshipPage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-allocation-details/what-is-allocation-relationship");
		relationshipPage = new RelationshipPage(driver);
		assertThat(relationshipPage.getHeading()).contains("What is their relationship to you?");
	}

	@Then("^the relationship submission will be successful$")
	public void theRelationshipSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@When("^I enter valid relationship details$")
	public void IenterValidRelationshipDetails() {
		String relationship = "Wife";
		relationshipPage = new RelationshipPage(driver);
		relationshipPage.submitValidJobTitle(relationship);
	}

	@Then("^the relationship submission will be unsuccessful$")
	public void theRelationshipSubmissionWillBeUnsuccessful() {
		relationshipPage = new RelationshipPage(driver);
		assertThat(relationshipPage.getErrorHeadingErrorMessage())
				.matches("Some questions have not been answered correctly.");
		assertThat(relationshipPage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@When("^I enter relationship name details using the name '(.*)'$")
	public void iEnterRelationshipDetailsUsingTheTitle(String relationship) {
		relationshipPage = new RelationshipPage(driver);
		relationshipPage.enterRelationshipDetails(relationship);
		relationshipPage.submitInValidRelationshipDetails();
	}

	@And("^the relationship name error message '(.*)' will be displayed$")
	public void theRelationshipErrorMessageWillBeDisplayed(String errorMessage) {
		relationshipPage = new RelationshipPage(driver);
		assertThat(relationshipPage.doesRelationshipErrorMessageHaveAnchor()).isTrue();
		assertThat(relationshipPage.getRelationshipAnchoredErrorMessage()).matches(errorMessage);
		assertThat(relationshipPage.getRelationshipFieldErrorMessage()).matches(errorMessage);
	}

}

package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DynamicAllocationRelationshipPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DynamicAllocationRelationshipStepDefs {

	private WebDriver driver = Config.getDriver();
	private DynamicAllocationRelationshipPage dynamicAllocationRelationshipPage;

	
	@Then("^the dynamic allocation relationship page will be displayed$")
	public void theDynamicAllocationrelationshipPageWillBeDisplayed() {
		Page page = new Page(driver);
		String allocationRelationshipPageTitle = "What is " + SharedData.allocationFirstName + "'s " + "relationship to you? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(allocationRelationshipPageTitle);
		dynamicAllocationRelationshipPage = new DynamicAllocationRelationshipPage(driver);
		assertThat(dynamicAllocationRelationshipPage.getHeading()).contains("What is " + SharedData.allocationFirstName + "'s " + "relationship to you?");
	}

	@When("^I enter valid relationship$")
	public void IenterValidRelationship() {
		SharedData.relationship = "Wife";
		dynamicAllocationRelationshipPage = new DynamicAllocationRelationshipPage(driver);
		dynamicAllocationRelationshipPage.submitValidAllocationRelationship(SharedData.relationship);
	}

		
	
	@When("^I click next on allocationRelationship page$")
	public void iClickNextOnAllocationRelationshipPage() {
		dynamicAllocationRelationshipPage = new DynamicAllocationRelationshipPage(driver);
		dynamicAllocationRelationshipPage.nextStep();
	}

	@Then("^the allocationRelationship details are sustained$")
	public void theAllocationRelationshipDetailsAreSustained() {
		dynamicAllocationRelationshipPage = new DynamicAllocationRelationshipPage(driver);
		assertThat(dynamicAllocationRelationshipPage.getRelationshipNameDetails()).matches(SharedData.relationship);
		
	}

	@When("^I enter allocationRelationship using different valid details$")
	public void iEnterAallocationRelationshipUsingDifferentDetails() {
		SharedData.relationship = "Son";
		dynamicAllocationRelationshipPage = new DynamicAllocationRelationshipPage(driver);
		dynamicAllocationRelationshipPage.submitValidAllocationRelationship(SharedData.relationship);
	}
	
	
}

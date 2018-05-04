package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DependantChildrenPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DependantChildrenStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private DependantChildrenPage dependantChildrenPage;
	private ChildNameStepDefs childNameSteps;
	private DynamicChildDateOfBirthStepDefs dynamicChildDOBSteps;
	private OtherDependantChildrenStepDefs otherDependantChildrenSteps;
	private SharedYeNoStepDefs sharedYeNoSteps;

	@Given("^I am on dependant children page$")
	public void iAmOnDependantChildrenPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/do-you-have-any-dependant-children");
	}

	@Given("^I go to dependant children page$")
	public void iGoToDependantChildrenPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/do-you-have-any-dependant-children");
		dependantChildrenPage = new DependantChildrenPage(driver);
		assertThat(dependantChildrenPage.getHeading().contains("Do you have any dependant children?"));
	}

	@Then("^the default value for dependant children page will be blank$")
	public void theDefaultValueForDependantChildrenPageWillBeBlank() {
		assertThat(dependantChildrenPage.isDependantChildrenRadioButtonSelected()).isFalse();
	}

	@Then("^Do you have any dependant children page will be displayed$")
	public void doYouHaveAnyDependantChildrenPageWillBeDisplayed() {
		dependantChildrenPage = new DependantChildrenPage(driver);
		assertThat(dependantChildrenPage.getHeading()).contains("Do you have any dependant children?");
	}

	@When("^I click on the link Who's classed as a dependant child$")
	public void iClickOnTheLinkWhosClassedAsADependantChild() {
		dependantChildrenPage = new DependantChildrenPage(driver);
		dependantChildrenPage.verifyDependantChildLink();
	}

	@Then("^the dependant child information will be displayed$")
	public void theDependantChildInformationWillBeDisplayed() {
		dependantChildrenPage = new DependantChildrenPage(driver);
		assertThat(dependantChildrenPage.verifyDependantChildLinkText()
				.contains("Where your Scheme membership extends to or beyond 1 April 2008, a dependant child is:"));
	}
	
	@When("^I enter dependantChildren using different valid details$")
	public void iSelectDependantChildrenUsingDifferentValidOption() {
		childNameSteps = new ChildNameStepDefs();
		childNameSteps.IenterMoreValidChildName();
		dynamicChildDOBSteps = new DynamicChildDateOfBirthStepDefs();
		dynamicChildDOBSteps.IenterValidChildDobDetails();
		otherDependantChildrenSteps = new OtherDependantChildrenStepDefs();
		otherDependantChildrenSteps.doYouHaveAnyOtherDependantPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectNo();
			
	}

}
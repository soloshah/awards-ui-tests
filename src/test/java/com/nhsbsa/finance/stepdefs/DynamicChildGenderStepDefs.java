package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DynamicChildGenderPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DynamicChildGenderStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private DynamicChildGenderPage dynamicChildGenderPage;
	private StartPageStepdefs startPageSteps;
	private ChildNameStepDefs childNameSteps;
	private ChildDOBStepDefs childDOBSteps;
	
	@Then("^the child gender page will be displayed$")
	public void theChildGenderPageWillBeDisplayed() {
		
		Page page = new Page(driver);
		String childGenderPageTitle = "What is " + SharedData.firstName + "'s " + "legally recognised gender? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(childGenderPageTitle);
		dynamicChildGenderPage = new DynamicChildGenderPage(driver);
		assertThat(dynamicChildGenderPage.getHeading()).contains("What is " + SharedData.firstName + "'s " + "legally recognised gender?");
		
	}
	
	@Given("^I go to child gender page$")
	public void iGoToChildGenderPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-your-child-gender");
		dynamicChildGenderPage = new DynamicChildGenderPage(driver);
		assertThat(dynamicChildGenderPage.getHeading())
				.contains("What is " + SharedData.firstName + "'s " + "legally recognised gender?");
	}
	
	

	@And("^what is your child gender page error message '(.*)' will be displayed$")
	public void whatIsYourPartnerGenderPageErrorMessageWillBeDisplayed(String errorMessage) {
		dynamicChildGenderPage = new DynamicChildGenderPage(driver);
		assertThat(dynamicChildGenderPage.getChildGenderFieldErrorMessage()).matches(errorMessage);
		assertThat(dynamicChildGenderPage.doesChildGenderErrorMessageHaveAnchor()).isTrue();
		assertThat(dynamicChildGenderPage.getChildGenderAnchoredErrorMessage()).matches(errorMessage);

	}

	@When("^I dont select anything on child gender page$")
	public void iDontSelectAnythingOnChildGenderPage() {
		dynamicChildGenderPage = new DynamicChildGenderPage(driver);
		dynamicChildGenderPage.childGenderIsNotSelected();
	}

	@When("^I click on the link how legal gender is identified$")
	public void iClickOnTheLinkHowLegalGenderIsIdentified() {
		dynamicChildGenderPage = new DynamicChildGenderPage(driver);
		dynamicChildGenderPage.verifyGenderLink();
	}

	@Then("^the guidance for gender link will be displayed$")
	public void theGuidanceForGenderLinkWillBeDisplayed() {
		dynamicChildGenderPage = new DynamicChildGenderPage(driver);
		assertThat((dynamicChildGenderPage.verifyGenderLinkText())
				.contains("more guidance on legally recognised gender available"));
	}

	
	@When("^I select Female on child gender page$")
	public void iSelectFemaleOnChildGenderPage() {
		SharedData.gender = "Female";
		dynamicChildGenderPage = new DynamicChildGenderPage(driver);
		dynamicChildGenderPage.selectFemale();
	}

	@When("^I select Male on child gender page$")
	public void iSelectMaleOnChildGenderPage() {
		SharedData.gender = "Male";
		dynamicChildGenderPage = new DynamicChildGenderPage(driver);
		dynamicChildGenderPage.selectMale();
	}

	@When("^I click next on child gender page$")
	public void iClickNextOnPartnerGenderPage() {
		dynamicChildGenderPage = new DynamicChildGenderPage(driver);
		dynamicChildGenderPage.nextStep();
	}
	
	@Then("^the childGender details are sustained$")
	public void theChildGenderDetailsAreSustained() {
		dynamicChildGenderPage = new DynamicChildGenderPage(driver);
		assertThat(dynamicChildGenderPage.getGenderFemale()).matches(SharedData.gender);

	}

	@When("^I select gender using different valid option$")
	public void iSelectGenderUsingDifferentValidOption() {
		iSelectMaleOnChildGenderPage();
	}
	
	
	@When("^I fill in child details$")
	public void iFillInChildDetails() {
	startPageSteps = new StartPageStepdefs();
	startPageSteps.iAmOnTheStartPage();
	childNameSteps = new ChildNameStepDefs();
	childNameSteps.iGoToTheChildNamePage();
	childNameSteps.IenterValidChildName();
	childDOBSteps.theDynamicValueOnChildDateOfBirthPageWillBeDisplayed();
	childDOBSteps.IenterValidChildDateOfBirthDetails();

	}
		
}

package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ChildGenderPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChildGenderStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private ChildGenderPage childGenderPage;
	private StartPageStepdefs startPageSteps;
	private ChildNameStepDefs childNameSteps;
	private ChildDOBStepDefs childDOBSteps;
	private DependantChildrenStepDefs dependantChildrenSteps;
	private SharedYeNoStepDefs sharedYesNoSteps;
	
	@Then("^the child gender page will be displayed$")
	public void theChildGenderPageWillBeDisplayed() {
		childGenderPage = new ChildGenderPage(driver);
		assertThat(childGenderPage.getHeading()).contains("What is " + SharedData.childFirstName + "'s " + "gender?");
		
	}
	
	@Given("^I go to child gender page$")
	public void iGoToChildGenderPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-your-child-gender");
		childGenderPage = new ChildGenderPage(driver);
		assertThat(childGenderPage.getHeading())
				.contains("What is " + SharedData.childFirstName + "'s " + "legally recognised gender?");
	}
	
	

	@And("^what is your child gender page error message '(.*)' will be displayed$")
	public void whatIsYourPartnerGenderPageErrorMessageWillBeDisplayed(String errorMessage) {
		childGenderPage = new ChildGenderPage(driver);
		assertThat(childGenderPage.getChildGenderFieldErrorMessage()).matches(errorMessage);
		assertThat(childGenderPage.doesChildGenderErrorMessageHaveAnchor()).isTrue();
		assertThat(childGenderPage.getChildGenderAnchoredErrorMessage()).matches(errorMessage);

	}

	@When("^I dont select anything on child gender page$")
	public void iDontSelectAnythingOnChildGenderPage() {
		childGenderPage = new ChildGenderPage(driver);
		childGenderPage.childGenderIsNotSelected();
	}

	@When("^I select Female on child gender page$")
	public void iSelectFemaleOnChildGenderPage() {
		SharedData.gender = "Female";
		childGenderPage = new ChildGenderPage(driver);
		childGenderPage.selectFemale();
	}

	@When("^I select Male on child gender page$")
	public void iSelectMaleOnChildGenderPage() {
		SharedData.gender = "Male";
		childGenderPage = new ChildGenderPage(driver);
		childGenderPage.selectMale();
	}

/*	@When("^I click next on child gender page$")
	public void iClickNextOnPartnerGenderPage() {
		childGenderPage = new ChildGenderPage(driver);
		childGenderPage.nextStep();
	}
	
	@Then("^the childGender details are sustained$")
	public void theChildGenderDetailsAreSustained() {
		childGenderPage = new ChildGenderPage(driver);
		assertThat(childGenderPage.getGenderFemale()).matches(SharedData.gender);

	}

	@When("^I select gender using different valid option$")
	public void iSelectGenderUsingDifferentValidOption() {
		iSelectMaleOnChildGenderPage();
	}*/
	
	
	@When("^I fill in child details$")
	public void iFillInChildDetails() {
	startPageSteps = new StartPageStepdefs();
	startPageSteps.iAmOnTheStartPage();
	dependantChildrenSteps = new DependantChildrenStepDefs();
	dependantChildrenSteps.iGoToDependantChildrenPage();
	sharedYesNoSteps =  new SharedYeNoStepDefs();
	sharedYesNoSteps.iSelectYes();
	childNameSteps = new ChildNameStepDefs();
	childNameSteps.theChildNamePageWillBeDisplayed();
	childNameSteps.IenterValidChildName();
	childDOBSteps = new ChildDOBStepDefs();
	childDOBSteps.theChildDateOfBirthPageWillBeDisplayed();
	childDOBSteps.IenterValidChildDobDetails();

	}
		
}

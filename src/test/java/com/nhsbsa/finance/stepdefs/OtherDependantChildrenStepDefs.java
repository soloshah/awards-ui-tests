package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.OtherDependantChildrenPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.SharedYesNoPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OtherDependantChildrenStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private OtherDependantChildrenPage otherDependantChildrenPage;
	private DependantChildrenStepDefs dependantChildrenSteps;
	SharedYesNoPage sharedYesNoPage;
	private ChildNameStepDefs childNameSteps;
	private SharedYeNoStepDefs sharedYesNoSteps;
	private DynamicChildDateOfBirthStepDefs dynamicChildDObSteps;

	@Given("^I am on other dependant children page$")
	public void iAmOnOtherDependantChildrenPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/do-you-have-any-other-dependant-children");
	}

	@Given("^I go to other dependant children page$")
	public void iGoToOtherDependantChildrenPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/do-you-have-any-other-dependant-children");
		otherDependantChildrenPage = new OtherDependantChildrenPage(driver);
		assertThat(otherDependantChildrenPage.getHeading().contains("Do you have any other dependant children?"));
	}

	@Then("^do you have any other depandant children page will be displayed$")
	public void doYouHaveAnyOtherDependantPageWillBeDisplayed() {
		otherDependantChildrenPage = new OtherDependantChildrenPage(driver);
		assertThat(otherDependantChildrenPage.getHeading()).contains("Do you have any other dependant children?");
	}

	@Then("^the default value for any other dependant children page will be blank$")
	public void theDefaultValueForAnyOtherDependantChildrenPageWillBeBlank() {
		assertThat(otherDependantChildrenPage.isOtherDependantChildrenRadioButtonSelected()).isFalse();
	}

	@Then("^the dynamic value of child first and last name will be displayed$")
	public void theDynamicValueOfChildFirstAndLastNameWillBeDisplayed() {
		otherDependantChildrenPage = new OtherDependantChildrenPage(driver);
		List<String> enteredFullNames = SharedData.fullName;
		for (int i = 0; i < enteredFullNames.size(); i++) {
			System.out.println("Name from list : " + enteredFullNames.get(enteredFullNames.size() - 1 - i));
			System.out.println("Name from page : " + otherDependantChildrenPage.readDynamicNameDetails(i));
			assertThat(otherDependantChildrenPage.readDynamicNameDetails(i))
					.matches(enteredFullNames.get(enteredFullNames.size() - 1 - i));
		}
	}

	
	@And("^the other dependant children page error message '(.*)' will be displayed$")
	public void theOtherDependantChildrenPageErrorMessageWillBeDisplayed(String errorMessage) {
		otherDependantChildrenPage = new OtherDependantChildrenPage(driver);
		sharedYesNoPage = new SharedYesNoPage(driver);
		assertThat(sharedYesNoPage.getSharedFieldErrorMessage()).matches(errorMessage);
		assertThat(sharedYesNoPage.doesSharedErrorMessageHaveAnchor()).isTrue();
		assertThat(sharedYesNoPage.getSharedAnchoredErrorMessage()).matches(errorMessage);

	}

	@And("^I try to enter more than 6 dependant children details$")
	public void iTryToEnterMoreThan6DependantChildrenDetails() {
		sharedYesNoPage = new SharedYesNoPage(driver);
		sharedYesNoPage.selectYes();

	}
	
	@And("^I enter 6 dependant children details$")
	public void iEnter6DependantChildrenDetails() {
		
		for(int i = 0; i<6; i++){
			childNameSteps = new ChildNameStepDefs();
			childNameSteps.iGoToTheChildNamePage();
			childNameSteps.IenterValidChildFirstAndLastNameDetails();
			dynamicChildDObSteps =  new DynamicChildDateOfBirthStepDefs();
			dynamicChildDObSteps.theDynamicValueOfChildFirstNameIsDisplayedOnTheChildsDOBPage();
			dynamicChildDObSteps.IenterValidChildDobDetails();
			iAmOnOtherDependantChildrenPage();
			theDynamicValueOfChildFirstAndLastNameWillBeDisplayed();
			sharedYesNoSteps =  new SharedYeNoStepDefs();
			sharedYesNoSteps.iSelectYes();
		}
		
	}
	
	@When("^I enter dependant children details$")
	public void iEnterDependantChildrenDetails() {
		dependantChildrenSteps =  new DependantChildrenStepDefs();
		dependantChildrenSteps.iGoToDependantChildrenPage();
		sharedYesNoSteps =  new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		childNameSteps = new ChildNameStepDefs();
		childNameSteps.IenterValidChildName();
		dynamicChildDObSteps =  new DynamicChildDateOfBirthStepDefs();
		dynamicChildDObSteps.theDynamicValueOfChildFirstNameIsDisplayedOnTheChildsDOBPage();
		dynamicChildDObSteps.IenterValidChildDobDetails();
		
	}

}
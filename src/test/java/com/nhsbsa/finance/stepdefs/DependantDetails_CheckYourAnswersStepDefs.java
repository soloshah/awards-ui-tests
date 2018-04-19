package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DependantDetails_CheckYourAnswerPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DependantDetails_CheckYourAnswersStepDefs {

	private WebDriver driver = Config.getDriver();
	private DependantDetails_CheckYourAnswerPage dependantDetails_CheckYourAnswerPage;
	private StartPageStepdefs startSteps;
	private MaritalStatusStepDefs maritalStatusSteps;
	private PartnerNameStepDefs partnerNameSteps;
	private DynamicDateOfBirthStepDefs dynamicDobSteps;
	private DynamicAllocationStepDefs dynamicAllocationSteps;
	private DynamicAllocationRelationshipStepDefs dynamicAllocationRelationshipSteps;
	private PartnerGenderStepDefs partnerGenderSteps;
	private DynamicNinoStepDefs dynamicNinoSteps;
	private DependantChildrenStepDefs dependantChildrenSteps;
	private OtherDependantChildrenStepDefs otherDependantChildrenSteps;
	private SharedYeNoStepDefs sharedYeNoSteps;
	private ChildNameStepDefs childNameSteps;
	private ChildDOBStepDefs childDOBSteps;
	private AllocatePensionStepDefs allocationPensionSteps;
	private AllocationNameStepDefs allocationNameSteps;
	
	

	@Given("^I have filled in a depandant details$")
	public void iHaveFilledInADependantlDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		maritalStatusSteps = new MaritalStatusStepDefs();
		maritalStatusSteps.iGoToTheMaritalStatusPage();
		maritalStatusSteps.iSelectMarriedAsMaritalStatus();
		partnerNameSteps = new PartnerNameStepDefs();
		partnerNameSteps.iGoToThePartnerNamePage();
		partnerNameSteps.iSubmitValidPartnerFirstAndLastNameDetails();
		dynamicDobSteps = new DynamicDateOfBirthStepDefs();
		dynamicDobSteps.theDynamicPartnersDateOfBirthPageWillBeDisplayed();
		dynamicDobSteps.IenterValidPartnerDOB();
		partnerGenderSteps = new PartnerGenderStepDefs();
		partnerGenderSteps.theDynamicValueOfPartnerFirstNameIsDisplayedOnThePartnersGenderPage();
		partnerGenderSteps.iSelectFemale();
		dynamicNinoSteps = new DynamicNinoStepDefs();
		dynamicNinoSteps.theDynamicValueOfPartnersNameWillBeDisplayedOnThePartnersNinoPage();
		dynamicNinoSteps.IenterValidPartnerNino();
		dependantChildrenSteps = new DependantChildrenStepDefs();
		dependantChildrenSteps.doYouHaveAnyDependantChildrenPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectYes();
		childNameSteps = new ChildNameStepDefs();
		childNameSteps.IenterValidChildName();
		childDOBSteps = new ChildDOBStepDefs();
		childDOBSteps.IenterValidChildDateOfBirthDetails();
		otherDependantChildrenSteps = new OtherDependantChildrenStepDefs();
		otherDependantChildrenSteps.doYouHaveAnyOtherDependantPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectNo();
		allocationPensionSteps = new AllocatePensionStepDefs();
		allocationPensionSteps.doYouWantToAllocatePensionPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectYes();
		allocationNameSteps = new AllocationNameStepDefs();
		allocationNameSteps.theAllocationNamePageWillBeDisplayed();
		allocationNameSteps.IenterValidAllocationName();
		dynamicAllocationSteps = new DynamicAllocationStepDefs();
		dynamicAllocationSteps.theDynamicAllocationDateOfBirthPageWillBeDisplayed();
		dynamicAllocationSteps.IenterValidAllocationDOB();
		dynamicAllocationRelationshipSteps = new DynamicAllocationRelationshipStepDefs();
		dynamicAllocationRelationshipSteps.theDynamicAllocationrelationshipPageWillBeDisplayed();
		dynamicAllocationRelationshipSteps.IenterValidRelationship();
	}

	
	@Then("^Check your answers page for dependant details will be displayed$")
	public void checkYourAnswersPageForDependantDetailsWillBeDisplayed() {
		dependantDetails_CheckYourAnswerPage = new DependantDetails_CheckYourAnswerPage(driver);
		assertThat(dependantDetails_CheckYourAnswerPage.getHeading()).contains("Check your answers");
	}

	
	@Then("^the correct dependant details will be displayed$")
	public void theCorrectDependantDetailsWillBeDisplayed() {
		dependantDetails_CheckYourAnswerPage = new DependantDetails_CheckYourAnswerPage(driver);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfMaritalStatus()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatus())
				.matches("What is your marital status");
		assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatusText()).matches(SharedData.sharedNHSRadioButton);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerName()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnername()).matches("What is your spouse's or civil partner's name");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNameText()).matches(SharedData.firstName + "\n" + SharedData.lastName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerDOB()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerDob()).matches("What is your spouse's or civil partner's date of birth");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerDobText()).matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerGender()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerGender()).matches("What is your spouse's or civil partner's legally recognised gender");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerGenderText()).matches(SharedData.gender);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerNino()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNino()).matches("What is your spouse's or civil partner's National Insurance number");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNinoText()).matches(SharedData.nino);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfDependantChildren()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildren()).matches("Do you have any dependant children");
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildrenText()).matches("Yes"+ "\n" + "Details added for " + SharedData.childFirstName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationPension()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPension()).matches("Do you want to allocate part of your pension");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPensionText()).matches("Yes");
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationName()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationName()).matches("What is the name of the person you want to allocate some of your pension to");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationNameText()).matches(SharedData.allocationFirstName+ "\n" + SharedData.allocationLastName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationDob()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationDob()).matches("What is their date of birth");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationDobText()).matches(SharedData.allocateDay+ " " + SharedData.allocateMonth + " " +SharedData.allocateYear);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationRelationship()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationRelationship()).matches("What is their relationship to you");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationRelationshipText()).matches(SharedData.relationship);
	}

	@Then("^the correct dependant details with updated children details will be displayed$")
	public void theCorrectDependantDetailsWithUpdatedChildrenDetailsWillBeDisplayed() {
		dependantDetails_CheckYourAnswerPage = new DependantDetails_CheckYourAnswerPage(driver);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfMaritalStatus()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatus())
				.matches("What is your marital status");
		assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatusText()).matches(SharedData.sharedNHSRadioButton);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerName()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnername()).matches("What is your spouse's or civil partner's name");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNameText()).matches(SharedData.firstName + "\n" + SharedData.lastName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerDOB()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerDob()).matches("What is your spouse's or civil partner's date of birth");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerDobText()).matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerGender()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerGender()).matches("What is your spouse's or civil partner's legally recognised gender");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerGenderText()).matches(SharedData.gender);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerNino()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNino()).matches("What is your spouse's or civil partner's National Insurance number");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNinoText()).matches(SharedData.nino);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfDependantChildren()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildren()).matches("Do you have any dependant children");
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildrenText()).matches("No");
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationPension()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPension()).matches("Do you want to allocate part of your pension");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPensionText()).matches("Yes");
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationName()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationName()).matches("What is the name of the person you want to allocate some of your pension to");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationNameText()).matches(SharedData.allocationFirstName+ "\n" + SharedData.allocationLastName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationDob()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationDob()).matches("What is their date of birth");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationDobText()).matches(SharedData.allocateDay+ " " + SharedData.allocateMonth + " " +SharedData.allocateYear);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationRelationship()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationRelationship()).matches("What is their relationship to you");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationRelationshipText()).matches(SharedData.relationship);
	}

	
	@Then("^the correct dependant details with updated allocationPension details will be displayed$")
	public void theCorrectDependantDetailsWithUpdatedAllocationPensionDetailsWillBeDisplayed() {
		dependantDetails_CheckYourAnswerPage = new DependantDetails_CheckYourAnswerPage(driver);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfMaritalStatus()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatus())
				.matches("What is your marital status");
		assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatusText()).matches(SharedData.sharedNHSRadioButton);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerName()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnername()).matches("What is your spouse's or civil partner's name");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNameText()).matches(SharedData.firstName + "\n" + SharedData.lastName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerDOB()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerDob()).matches("What is your spouse's or civil partner's date of birth");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerDobText()).matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerGender()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerGender()).matches("What is your spouse's or civil partner's legally recognised gender");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerGenderText()).matches(SharedData.gender);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerNino()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNino()).matches("What is your spouse's or civil partner's National Insurance number");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNinoText()).matches(SharedData.nino);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfDependantChildren()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildren()).matches("Do you have any dependant children");
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildrenText()).matches("Yes"+ "\n" + "Details added for " + SharedData.childFirstName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationPension()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPension()).matches("Do you want to allocate part of your pension");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPensionText()).matches("No");
		
	}
	
	
	@Then("^the correct dependant details with updated maritalStatus will be displayed$")
	public void theCorrectDependantDetailsWithUpdatedMaritalStatusWillBeDisplayed() {
		dependantDetails_CheckYourAnswerPage = new DependantDetails_CheckYourAnswerPage(driver);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfMaritalStatus()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatus())
				.matches("What is your marital status");
		assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatusText()).matches(SharedData.sharedNHSRadioButton);
	    assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfDependantChildren()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildren()).matches("Do you have any dependant children");
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildrenText()).matches("No");
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationPension()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPension()).matches("Do you want to allocate part of your pension");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPensionText()).matches("No");
		
	}
	
	@Then("^the correct dependant details with different child details will be displayed$")
	public void theCorrectDependantDetailsWithDifferentChildDetailsWillBeDisplayed() {
		dependantDetails_CheckYourAnswerPage = new DependantDetails_CheckYourAnswerPage(driver);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfMaritalStatus()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatus())
				.matches("What is your marital status");
		assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatusText()).matches(SharedData.sharedNHSRadioButton);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerName()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnername()).matches("What is your spouse's or civil partner's name");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNameText()).matches(SharedData.firstName + "\n" + SharedData.lastName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerDOB()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerDob()).matches("What is your spouse's or civil partner's date of birth");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerDobText()).matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerGender()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerGender()).matches("What is your spouse's or civil partner's legally recognised gender");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerGenderText()).matches(SharedData.gender);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfPartnerNino()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNino()).matches("What is your spouse's or civil partner's National Insurance number");
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNinoText()).matches(SharedData.nino);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfDependantChildren()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildren()).matches("Do you have any dependant children");
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildrenText()).matches("Yes"+ "\n" + "Details added for " + SharedData.childFirstName + "\n" +"Details added for " + SharedData.childFirstName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationPension()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPension()).matches("Do you want to allocate part of your pension");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPensionText()).matches("Yes");
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationName()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationName()).matches("What is the name of the person you want to allocate some of your pension to");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationNameText()).matches(SharedData.allocationFirstName+ "\n" + SharedData.allocationLastName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationDob()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationDob()).matches("What is their date of birth");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationDobText()).matches(SharedData.allocateDay+ " " + SharedData.allocateMonth + " " +SharedData.allocateYear);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationRelationship()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationRelationship()).matches("What is their relationship to you");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationRelationshipText()).matches(SharedData.relationship);
	}
	
	@And("^the dependant details for updated (.*) will be displayed$")
	public void theDependantDetailsForUpdatedWillBeDisplayed(String field) {
		dependantDetails_CheckYourAnswerPage = new DependantDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "maritalStatus":
			assertThat(dependantDetails_CheckYourAnswerPage.getMaritalStatusText())
					.matches(SharedData.sharedNHSRadioButton);
			break;
			
		case "partnerName":
			assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNameText()).matches(SharedData.firstName + "\n" + SharedData.lastName);
			break;
			
		case "partnerDob":
			assertThat(dependantDetails_CheckYourAnswerPage.getPartnerDobText())
					.matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
			break;
			
		case "partnerGender":
			assertThat(dependantDetails_CheckYourAnswerPage.getPartnerGenderText()).matches(SharedData.gender);
			break;
			
		case "partnerNino":
			assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNinoText()).matches(SharedData.nino);
			break;
			
		case "dependantChildren":
			assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildrenText()).matches("Yes");
			break;

		case "allocatePension":
			assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPension()).matches(SharedData.sharedRadioButton);
			break;

		case "allocatePensionName":
			assertThat(dependantDetails_CheckYourAnswerPage.getAllocationNameText()).matches(SharedData.firstName+ "\n" + SharedData.lastName);
			break;

		case "allocationDob":
			assertThat(dependantDetails_CheckYourAnswerPage.getAllocationDobText()).matches(SharedData.day+ " " + SharedData.month + " " +SharedData.year);
			break;

		case "allocationRelationship":
			assertThat(dependantDetails_CheckYourAnswerPage.getAllocationRelationshipText()).matches(SharedData.relationship);
			break;
		}
	}

	
	@When("^I select on change (.*) details$")
	public void iClickOnChangeForNameDetails(String field) {
		dependantDetails_CheckYourAnswerPage = new DependantDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "maritalStatus":
			dependantDetails_CheckYourAnswerPage.changeMaritalStatus();
			break;
		case "partnerName":
			dependantDetails_CheckYourAnswerPage.changePartnerName();
			break;
		case "partnerDob":
			dependantDetails_CheckYourAnswerPage.changePartnerDob();
			break;
		case "partnerGender":
			dependantDetails_CheckYourAnswerPage.changePartnerGender();
			break;
		case "partnerNino":
			dependantDetails_CheckYourAnswerPage.changePartnerNino();
			break;
		case "dependantChildren":
			dependantDetails_CheckYourAnswerPage.changeDependantChildren();
			break;
		case "allocationPension":
			dependantDetails_CheckYourAnswerPage.changeAllocationPension();
			break;
		case "allocationPensionName":
			dependantDetails_CheckYourAnswerPage.changeAllocationName();
			break;
		case "allocationDob":
			dependantDetails_CheckYourAnswerPage.changeAllocationDOB();
			break;
		case "allocationRelationship":
			dependantDetails_CheckYourAnswerPage.changeAllocationRelationship();
			break;
		}
	}

	
	@And("^I navigate from marital status page to check your answers page$")
	public void InavigateFromMaritalStatusPageToCheckYourAnswersPage() {
		partnerNameSteps = new PartnerNameStepDefs();
		partnerNameSteps.thePartnerNamePageWillBeDisplayed();
		partnerNameSteps.iClickNextOnPartnerNamePage();
		dynamicDobSteps = new DynamicDateOfBirthStepDefs();
		dynamicDobSteps.theDynamicPartnersDateOfBirthPageWillBeDisplayed();
		dynamicDobSteps.iClickNextOnPartnerDateOfBirthPage();
		partnerGenderSteps = new PartnerGenderStepDefs();
		partnerGenderSteps.theDynamicValueOfPartnerFirstNameIsDisplayedOnThePartnersGenderPage();
		partnerGenderSteps.iClickNextOnPartnerGenderPage();
		dynamicNinoSteps = new DynamicNinoStepDefs();
		dynamicNinoSteps.theDynamicValueOfPartnersNameWillBeDisplayedOnThePartnersNinoPage();
		dynamicNinoSteps.iClickNextOnPartnerNationalInsurancePage();
		dependantChildrenSteps = new DependantChildrenStepDefs();
		dependantChildrenSteps.doYouHaveAnyDependantChildrenPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectNo();
		allocationPensionSteps = new AllocatePensionStepDefs();
		allocationPensionSteps.doYouWantToAllocatePensionPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iClickNextOnAllocatePensionPage();
		allocationNameSteps = new AllocationNameStepDefs();
		allocationNameSteps.theAllocationNamePageWillBeDisplayed();
		allocationNameSteps.iClickNextOnAllocationNamePage();
		dynamicAllocationSteps = new DynamicAllocationStepDefs();
		dynamicAllocationSteps.theDynamicAllocationDateOfBirthPageWillBeDisplayed();
		dynamicAllocationSteps.iClickNextOnAllocationDateOfBirthPage();
		dynamicAllocationRelationshipSteps = new DynamicAllocationRelationshipStepDefs();
		dynamicAllocationRelationshipSteps.theDynamicAllocationrelationshipPageWillBeDisplayed();
		dynamicAllocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

	}

	@And("^I navigate from partner name page to check your answers page$")
	public void InavigateFromPartnerNamePageToCheckYourAnswersPage() {
		dynamicDobSteps = new DynamicDateOfBirthStepDefs();
		dynamicDobSteps.theDynamicPartnersDateOfBirthPageWillBeDisplayed();
		dynamicDobSteps.iClickNextOnPartnerDateOfBirthPage();
		partnerGenderSteps = new PartnerGenderStepDefs();
		partnerGenderSteps.theDynamicValueOfPartnerFirstNameIsDisplayedOnThePartnersGenderPage();
		partnerGenderSteps.iClickNextOnPartnerGenderPage();
		dynamicNinoSteps = new DynamicNinoStepDefs();
		dynamicNinoSteps.theDynamicValueOfPartnersNameWillBeDisplayedOnThePartnersNinoPage();
		dynamicNinoSteps.iClickNextOnPartnerNationalInsurancePage();
		dependantChildrenSteps = new DependantChildrenStepDefs();
		dependantChildrenSteps.doYouHaveAnyDependantChildrenPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectNo();
		allocationPensionSteps = new AllocatePensionStepDefs();
		allocationPensionSteps.doYouWantToAllocatePensionPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iClickNextOnAllocatePensionPage();
		allocationNameSteps = new AllocationNameStepDefs();
		allocationNameSteps.theAllocationNamePageWillBeDisplayed();
		allocationNameSteps.iClickNextOnAllocationNamePage();
		dynamicAllocationSteps = new DynamicAllocationStepDefs();
		dynamicAllocationSteps.theDynamicAllocationDateOfBirthPageWillBeDisplayed();
		dynamicAllocationSteps.iClickNextOnAllocationDateOfBirthPage();
		dynamicAllocationRelationshipSteps = new DynamicAllocationRelationshipStepDefs();
		dynamicAllocationRelationshipSteps.theDynamicAllocationrelationshipPageWillBeDisplayed();
		dynamicAllocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();
		
	}
	
	
	@And("^I navigate from partner dob page to check your answers page$")
	public void InavigateFromPartnerDobPageToCheckYourAnswersPage() {
		partnerGenderSteps = new PartnerGenderStepDefs();
		partnerGenderSteps.theDynamicValueOfPartnerFirstNameIsDisplayedOnThePartnersGenderPage();
		partnerGenderSteps.iClickNextOnPartnerGenderPage();
		dynamicNinoSteps = new DynamicNinoStepDefs();
		dynamicNinoSteps.theDynamicValueOfPartnersNameWillBeDisplayedOnThePartnersNinoPage();
		dynamicNinoSteps.iClickNextOnPartnerNationalInsurancePage();
		dependantChildrenSteps = new DependantChildrenStepDefs();
		dependantChildrenSteps.doYouHaveAnyDependantChildrenPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectNo();
		allocationPensionSteps = new AllocatePensionStepDefs();
		allocationPensionSteps.doYouWantToAllocatePensionPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iClickNextOnAllocatePensionPage();
		allocationNameSteps = new AllocationNameStepDefs();
		allocationNameSteps.theAllocationNamePageWillBeDisplayed();
		allocationNameSteps.iClickNextOnAllocationNamePage();
		dynamicAllocationSteps = new DynamicAllocationStepDefs();
		dynamicAllocationSteps.theDynamicAllocationDateOfBirthPageWillBeDisplayed();
		dynamicAllocationSteps.iClickNextOnAllocationDateOfBirthPage();
		dynamicAllocationRelationshipSteps = new DynamicAllocationRelationshipStepDefs();
		dynamicAllocationRelationshipSteps.theDynamicAllocationrelationshipPageWillBeDisplayed();
		dynamicAllocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

	}
	
	
	@And("^I navigate from partner gender page to check your answers page$")
	public void InavigateFromPartnerGenderPageToCheckYourAnswersPage() {
		dynamicNinoSteps = new DynamicNinoStepDefs();
		dynamicNinoSteps.theDynamicValueOfPartnersNameWillBeDisplayedOnThePartnersNinoPage();
		dynamicNinoSteps.iClickNextOnPartnerNationalInsurancePage();
		dependantChildrenSteps = new DependantChildrenStepDefs();
		dependantChildrenSteps.doYouHaveAnyDependantChildrenPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectNo();
		allocationPensionSteps = new AllocatePensionStepDefs();
		allocationPensionSteps.doYouWantToAllocatePensionPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iClickNextOnAllocatePensionPage();
		allocationNameSteps = new AllocationNameStepDefs();
		allocationNameSteps.theAllocationNamePageWillBeDisplayed();
		allocationNameSteps.iClickNextOnAllocationNamePage();
		dynamicAllocationSteps = new DynamicAllocationStepDefs();
		dynamicAllocationSteps.theDynamicAllocationDateOfBirthPageWillBeDisplayed();
		dynamicAllocationSteps.iClickNextOnAllocationDateOfBirthPage();
		dynamicAllocationRelationshipSteps = new DynamicAllocationRelationshipStepDefs();
		dynamicAllocationRelationshipSteps.theDynamicAllocationrelationshipPageWillBeDisplayed();
		dynamicAllocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

	}
	
	
	@And("^I navigate from partnerNino page to check your answers page$")
	public void InavigateFromPartnerNinoPageToCheckYourAnswersPage() {
		dependantChildrenSteps = new DependantChildrenStepDefs();
		dependantChildrenSteps.doYouHaveAnyDependantChildrenPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectNo();
		allocationPensionSteps = new AllocatePensionStepDefs();
		allocationPensionSteps.doYouWantToAllocatePensionPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iClickNextOnAllocatePensionPage();
		allocationNameSteps = new AllocationNameStepDefs();
		allocationNameSteps.theAllocationNamePageWillBeDisplayed();
		allocationNameSteps.iClickNextOnAllocationNamePage();
		dynamicAllocationSteps = new DynamicAllocationStepDefs();
		dynamicAllocationSteps.theDynamicAllocationDateOfBirthPageWillBeDisplayed();
		dynamicAllocationSteps.iClickNextOnAllocationDateOfBirthPage();
		dynamicAllocationRelationshipSteps = new DynamicAllocationRelationshipStepDefs();
		dynamicAllocationRelationshipSteps.theDynamicAllocationrelationshipPageWillBeDisplayed();
		dynamicAllocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

	}
	
	@And("^I navigate from dependantChildren page to check your answers page$")
	public void InavigateFromDependantChildrenPageToCheckYourAnswersPage() {
		allocationPensionSteps = new AllocatePensionStepDefs();
		allocationPensionSteps.doYouWantToAllocatePensionPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iClickNextOnAllocatePensionPage();
		allocationNameSteps = new AllocationNameStepDefs();
		allocationNameSteps.theAllocationNamePageWillBeDisplayed();
		allocationNameSteps.iClickNextOnAllocationNamePage();
		dynamicAllocationSteps = new DynamicAllocationStepDefs();
		dynamicAllocationSteps.theDynamicAllocationDateOfBirthPageWillBeDisplayed();
		dynamicAllocationSteps.iClickNextOnAllocationDateOfBirthPage();
		dynamicAllocationRelationshipSteps = new DynamicAllocationRelationshipStepDefs();
		dynamicAllocationRelationshipSteps.theDynamicAllocationrelationshipPageWillBeDisplayed();
		dynamicAllocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

	}
	
	@And("^I navigate from marital status page with updated status to check your answers page$")
	public void InavigateFromMaritalStatusPageWithUpdatedStatusToCheckYourAnswersPage() {
		dependantChildrenSteps = new DependantChildrenStepDefs();
		dependantChildrenSteps.doYouHaveAnyDependantChildrenPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectNo();
		allocationPensionSteps = new AllocatePensionStepDefs();
		allocationPensionSteps.doYouWantToAllocatePensionPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectNo();

	}
	
		
	@And("^I navigate from allocatePensionName page to check your answers page$")
	public void InavigateFromAllocatePensionNamePageToCheckYourAnswersPage() {
		dynamicAllocationSteps = new DynamicAllocationStepDefs();
		dynamicAllocationSteps.theDynamicAllocationDateOfBirthPageWillBeDisplayed();
		dynamicAllocationSteps.iClickNextOnAllocationDateOfBirthPage();
		dynamicAllocationRelationshipSteps = new DynamicAllocationRelationshipStepDefs();
		dynamicAllocationRelationshipSteps.theDynamicAllocationrelationshipPageWillBeDisplayed();
		dynamicAllocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

	}
	
	@And("^I navigate from allocationDOB page to check your answers page$")
	public void InavigateFromAllocationDOBPageToCheckYourAnswersPage() {
		dynamicAllocationRelationshipSteps = new DynamicAllocationRelationshipStepDefs();
		dynamicAllocationRelationshipSteps.theDynamicAllocationrelationshipPageWillBeDisplayed();
		dynamicAllocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

	}

	@When("^I submit the dependant details$")
	public void iSubmitTheDependantDetails() {
		dependantDetails_CheckYourAnswerPage = new DependantDetails_CheckYourAnswerPage(driver);
		dependantDetails_CheckYourAnswerPage.submitDependantDetails();
	}
}
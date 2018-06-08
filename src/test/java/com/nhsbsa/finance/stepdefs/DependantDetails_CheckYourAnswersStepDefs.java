package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DependantDetails_CheckYourAnswerPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class DependantDetails_CheckYourAnswersStepDefs {

	private WebDriver driver = Config.getDriver();
	private DependantDetails_CheckYourAnswerPage dependantDetails_CheckYourAnswerPage;
	private StartPageStepdefs startSteps;
	private MaritalStatusStepDefs maritalStatusSteps;
	private PartnerNameStepDefs partnerNameSteps;
	private PartnerDateOfBirthStepDefs partnerDobSteps;
	private PartnerGenderStepDefs partnerGenderSteps;
	private ChildDOBStepDefs childDobSteps;
	private AllocationDOBStepDefs allocationDOBSteps;
	private AllocationRelationshipStepDefs allocationRelationshipSteps;
	private PartnerNinoStepdefs partnerNinoSteps;
	private DependantChildrenStepDefs dependantChildrenSteps;
	private OtherDependantChildrenStepDefs otherDependantChildrenSteps;
	private SharedYeNoStepDefs sharedYeNoSteps;
	private ChildNameStepDefs childNameSteps;
	private AllocatePensionStepDefs allocationPensionSteps;
	private AllocationNameStepDefs allocationNameSteps;
	
	@Given("^I have filled in a depandant details for summary page$")
	public void iHaveFilledInADependantlDetailsForSummaryPage() throws Throwable {
		maritalStatusSteps = new MaritalStatusStepDefs();
		maritalStatusSteps.whatIsYourMaritalStatusPageWillBeDisplayed();
		maritalStatusSteps.iSelectMarriedAsMaritalStatus();
		partnerNameSteps = new PartnerNameStepDefs();
		partnerNameSteps.iGoToThePartnerNamePage();
		partnerNameSteps.iSubmitValidPartnerFirstAndLastNameDetails();
		partnerDobSteps = new PartnerDateOfBirthStepDefs();
		partnerDobSteps.thePartnersDateOfBirthPageWillBeDisplayed();
		partnerDobSteps.IenterValidPartnerDOB();
		partnerGenderSteps = new PartnerGenderStepDefs();
		partnerGenderSteps.thePartnerGenderPageWillBeDisplayed();
	    partnerGenderSteps.iSelectFemale();
		partnerNinoSteps = new PartnerNinoStepdefs();
		partnerNinoSteps.thePartnerNinoPageWillBeDisplayed();
		partnerNinoSteps.IenterValidPartnerNationalInsuranceNumber();
		dependantChildrenSteps = new DependantChildrenStepDefs();
		dependantChildrenSteps.doYouHaveAnyDependantChildrenPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectYes();
		childNameSteps = new ChildNameStepDefs();
		childNameSteps.IenterValidChildName();
		childDobSteps = new ChildDOBStepDefs();
		childDobSteps.theChildDateOfBirthPageWillBeDisplayed();
		childDobSteps.IenterValidChildDobDetails();
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
		allocationDOBSteps = new AllocationDOBStepDefs();
		allocationDOBSteps.theAllocationDateOfBirthPageWillBeDisplayed();
		allocationDOBSteps.IenterValidAllocationDOB();
		allocationRelationshipSteps = new AllocationRelationshipStepDefs();
		allocationRelationshipSteps.theAllocationrelationshipPageWillBeDisplayed();
		allocationRelationshipSteps.IenterValidRelationship();
	}

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
		partnerDobSteps = new PartnerDateOfBirthStepDefs();
		partnerDobSteps.thePartnersDateOfBirthPageWillBeDisplayed();
		partnerDobSteps.IenterValidPartnerDOB();
		partnerGenderSteps = new PartnerGenderStepDefs();
		partnerGenderSteps.thePartnerGenderPageWillBeDisplayed();
	    partnerGenderSteps.iSelectFemale();
		partnerNinoSteps = new PartnerNinoStepdefs();
		partnerNinoSteps.thePartnerNinoPageWillBeDisplayed();
		partnerNinoSteps.IenterValidPartnerNationalInsuranceNumber();
		dependantChildrenSteps = new DependantChildrenStepDefs();
		dependantChildrenSteps.doYouHaveAnyDependantChildrenPageWillBeDisplayed();
		sharedYeNoSteps = new SharedYeNoStepDefs();
		sharedYeNoSteps.iSelectYes();
		childNameSteps = new ChildNameStepDefs();
		childNameSteps.IenterValidChildName();
		childDobSteps = new ChildDOBStepDefs();
		childDobSteps.theChildDateOfBirthPageWillBeDisplayed();
		childDobSteps.IenterValidChildDobDetails();
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
		allocationDOBSteps = new AllocationDOBStepDefs();
		allocationDOBSteps.theAllocationDateOfBirthPageWillBeDisplayed();
		allocationDOBSteps.IenterValidAllocationDOB();
		allocationRelationshipSteps = new AllocationRelationshipStepDefs();
		allocationRelationshipSteps.theAllocationrelationshipPageWillBeDisplayed();
		allocationRelationshipSteps.IenterValidRelationship();
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
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNameText()).matches(SharedData.firstName + " " + SharedData.lastName);
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
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationNameText()).matches(SharedData.allocationFirstName+ " " + SharedData.allocationLastName);
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
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNameText()).matches(SharedData.firstName + " " + SharedData.lastName);
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
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationNameText()).matches(SharedData.allocationFirstName+ " " + SharedData.allocationLastName);
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
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNameText()).matches(SharedData.firstName + " " + SharedData.lastName);
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
		assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNameText()).matches(SharedData.firstName + " " + SharedData.lastName);
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
		assertThat(dependantDetails_CheckYourAnswerPage.getDependantChildrenText()).matches("Yes"+ "\n" + "Details added for " + SharedData.child1FirstName + "\n" +"Details added for " + SharedData.childFirstName);
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationPension()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPension()).matches("Do you want to allocate part of your pension");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationPensionText()).matches("Yes");
		assertThat(dependantDetails_CheckYourAnswerPage.getPresenceOfAllocationName()).isEqualTo(true);
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationName()).matches("What is the name of the person you want to allocate some of your pension to");
		assertThat(dependantDetails_CheckYourAnswerPage.getAllocationNameText()).matches(SharedData.allocationFirstName+ " " + SharedData.allocationLastName);
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
			assertThat(dependantDetails_CheckYourAnswerPage.getPartnerNameText()).matches(SharedData.firstName + " " + SharedData.lastName);
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
			assertThat(dependantDetails_CheckYourAnswerPage.getAllocationNameText()).matches(SharedData.firstName+ " " + SharedData.lastName);
			break;

		case "allocationDob":
			assertThat(dependantDetails_CheckYourAnswerPage.getAllocationDobText()).matches(SharedData.day+ " " + SharedData.month + " " +SharedData.year);
			break;

		case "allocationRelationship":
			assertThat(dependantDetails_CheckYourAnswerPage.getAllocationRelationshipText()).matches(SharedData.relationship);
			break;
		}
	}

	
	
	@And("^I navigate from marital status page to check your answers page$")
	public void InavigateFromMaritalStatusPageToCheckYourAnswersPage() {
		partnerNameSteps = new PartnerNameStepDefs();
		partnerNameSteps.thePartnerNamePageWillBeDisplayed();
		partnerNameSteps.iClickNextOnPartnerNamePage();
		partnerDobSteps = new PartnerDateOfBirthStepDefs();
		partnerDobSteps.thePartnersDateOfBirthPageWillBeDisplayed();
		partnerDobSteps.iClickNextOnPartnerDateOfBirthPage();
		partnerGenderSteps = new PartnerGenderStepDefs();
		partnerGenderSteps.thePartnerGenderPageWillBeDisplayed();
		partnerGenderSteps.iClickNextOnPartnerGenderPage();
		partnerNinoSteps = new PartnerNinoStepdefs();
		partnerNinoSteps.thePartnerNinoPageWillBeDisplayed();
		partnerNinoSteps.iClickNextOnPartnerNationalInsurancePage();
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
		allocationDOBSteps = new AllocationDOBStepDefs();
		allocationDOBSteps.theAllocationDateOfBirthPageWillBeDisplayed();
		allocationDOBSteps.iClickNextOnAllocationDateOfBirthPage();
		allocationRelationshipSteps = new AllocationRelationshipStepDefs();
		allocationRelationshipSteps.theAllocationrelationshipPageWillBeDisplayed();
		allocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();


	}

	@And("^I navigate from partner name page to check your answers page$")
	public void InavigateFromPartnerNamePageToCheckYourAnswersPage() {
		partnerDobSteps = new PartnerDateOfBirthStepDefs();
		partnerDobSteps.thePartnersDateOfBirthPageWillBeDisplayed();
		partnerDobSteps.iClickNextOnPartnerDateOfBirthPage();
		partnerGenderSteps = new PartnerGenderStepDefs();
		partnerGenderSteps.thePartnerGenderPageWillBeDisplayed();
		partnerGenderSteps.iClickNextOnPartnerGenderPage();
		partnerNinoSteps = new PartnerNinoStepdefs();
		partnerNinoSteps.thePartnerNinoPageWillBeDisplayed();
		partnerNinoSteps.iClickNextOnPartnerNationalInsurancePage();
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
		allocationDOBSteps = new AllocationDOBStepDefs();
		allocationDOBSteps.theAllocationDateOfBirthPageWillBeDisplayed();
		allocationDOBSteps.iClickNextOnAllocationDateOfBirthPage();
		allocationRelationshipSteps = new AllocationRelationshipStepDefs();
		allocationRelationshipSteps.theAllocationrelationshipPageWillBeDisplayed();
		allocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();
		
	}
	
	
	@And("^I navigate from partner dob page to check your answers page$")
	public void InavigateFromPartnerDobPageToCheckYourAnswersPage() {
		partnerGenderSteps = new PartnerGenderStepDefs();
		partnerGenderSteps.thePartnerGenderPageWillBeDisplayed();
		partnerGenderSteps.iClickNextOnPartnerGenderPage();
		partnerNinoSteps = new PartnerNinoStepdefs();
		partnerNinoSteps.thePartnerNinoPageWillBeDisplayed();
		partnerNinoSteps.iClickNextOnPartnerNationalInsurancePage();
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
		allocationDOBSteps = new AllocationDOBStepDefs();
		allocationDOBSteps.theAllocationDateOfBirthPageWillBeDisplayed();
		allocationDOBSteps.iClickNextOnAllocationDateOfBirthPage();
		allocationRelationshipSteps = new AllocationRelationshipStepDefs();
		allocationRelationshipSteps.theAllocationrelationshipPageWillBeDisplayed();
		allocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

	}
	
	
	@And("^I navigate from partner gender page to check your answers page$")
	public void InavigateFromPartnerGenderPageToCheckYourAnswersPage() {
		partnerNinoSteps = new PartnerNinoStepdefs();
		partnerNinoSteps.thePartnerNinoPageWillBeDisplayed();
		partnerNinoSteps.iClickNextOnPartnerNationalInsurancePage();
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
		allocationDOBSteps = new AllocationDOBStepDefs();
		allocationDOBSteps.theAllocationDateOfBirthPageWillBeDisplayed();
		allocationDOBSteps.iClickNextOnAllocationDateOfBirthPage();
		allocationRelationshipSteps = new AllocationRelationshipStepDefs();
		allocationRelationshipSteps.theAllocationrelationshipPageWillBeDisplayed();
		allocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();
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
		allocationDOBSteps = new AllocationDOBStepDefs();
		allocationDOBSteps.theAllocationDateOfBirthPageWillBeDisplayed();
		allocationDOBSteps.iClickNextOnAllocationDateOfBirthPage();
		allocationRelationshipSteps = new AllocationRelationshipStepDefs();
		allocationRelationshipSteps.theAllocationrelationshipPageWillBeDisplayed();
		allocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

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
		allocationDOBSteps = new AllocationDOBStepDefs();
		allocationDOBSteps.theAllocationDateOfBirthPageWillBeDisplayed();
		allocationDOBSteps.iClickNextOnAllocationDateOfBirthPage();
		allocationRelationshipSteps = new AllocationRelationshipStepDefs();
		allocationRelationshipSteps.theAllocationrelationshipPageWillBeDisplayed();
		allocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

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
		allocationDOBSteps = new AllocationDOBStepDefs();
		allocationDOBSteps.theAllocationDateOfBirthPageWillBeDisplayed();
		allocationDOBSteps.iClickNextOnAllocationDateOfBirthPage();
		allocationRelationshipSteps = new AllocationRelationshipStepDefs();
		allocationRelationshipSteps.theAllocationrelationshipPageWillBeDisplayed();
		allocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

	}
	
	@And("^I navigate from allocationDOB page to check your answers page$")
	public void InavigateFromAllocationDOBPageToCheckYourAnswersPage() {
		allocationRelationshipSteps = new AllocationRelationshipStepDefs();
		allocationRelationshipSteps.theAllocationrelationshipPageWillBeDisplayed();
		allocationRelationshipSteps.iClickNextOnAllocationRelationshipPage();

	}

}
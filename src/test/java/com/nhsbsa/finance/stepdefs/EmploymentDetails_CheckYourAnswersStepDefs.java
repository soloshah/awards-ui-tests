package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.EmploymentDetails_CheckYourAnswerPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class EmploymentDetails_CheckYourAnswersStepDefs {

	private WebDriver driver = Config.getDriver();
	private EmploymentDetails_CheckYourAnswerPage employmentDetails_CheckYourAnswerPage;
	private StartPageStepdefs startSteps;
	private WorkingForNHSStepDefs workingForNHSPrefSteps;
	private SharedYeNoStepDefs sharedYesNoSteps;
    private NameOfYourCurentEmployerStepDefs currentEmployerSteps;
	private EmployerAddressStepDefs employerAddressSteps;
	private LastDayOfWorkStepDefs lastDaySteps;
    private IntendToWorkForNHSStepDefs intendToWorkSteps;
    private NameOfYourLastEmployerStepDefs lastEmployerSteps;
    private JobTitleStepDefs jobTitleSteps;
    private DateYouLeaveStepDefs dateYouLeaveSteps;
    
    
    @Given("^I have filled in current employment details for summary page$")
	public void iHaveFilledInCurrentEmploymentDetailsForSummaryPage() throws Throwable {
    	workingForNHSPrefSteps = new WorkingForNHSStepDefs();
    	workingForNHSPrefSteps.areYouWorkingForNHSPageWillBeDisplayed();
    	sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		currentEmployerSteps = new NameOfYourCurentEmployerStepDefs();
		currentEmployerSteps.whatIsTheNameOfYourCurrentEmployerPageWillBeDisplayed();
		currentEmployerSteps.IenterValidNameOfCurrentNHSEmployerDetails();
		employerAddressSteps = new EmployerAddressStepDefs();
		employerAddressSteps.theEmployersAddressPageWillBeDisplayed();
		employerAddressSteps.IenterValidEmployerAddressDetails();
		lastDaySteps = new LastDayOfWorkStepDefs();
		lastDaySteps.theLastDayOfWorkPageWillBeDisplayed();
		lastDaySteps.IenterValidDateForLastDayOfWork();
		intendToWorkSteps = new IntendToWorkForNHSStepDefs();
		intendToWorkSteps.theIntendToWorkForNHSPageWillbeDisplayed();
		intendToWorkSteps.iChooseYes();
		intendToWorkSteps.IenterTheValidDate();
    }
	
	@Given("^I have filled in current employment details$")
	public void iHaveFilledInCurrentEmploymentDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		workingForNHSPrefSteps = new WorkingForNHSStepDefs();
		workingForNHSPrefSteps.iGoToWorkingForNHSPage();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectYes();
		currentEmployerSteps = new NameOfYourCurentEmployerStepDefs();
		currentEmployerSteps.whatIsTheNameOfYourCurrentEmployerPageWillBeDisplayed();
		currentEmployerSteps.IenterValidNameOfCurrentNHSEmployerDetails();
		employerAddressSteps = new EmployerAddressStepDefs();
		employerAddressSteps.theEmployersAddressPageWillBeDisplayed();
		employerAddressSteps.IenterValidEmployerAddressDetails();
		lastDaySteps = new LastDayOfWorkStepDefs();
		lastDaySteps.theLastDayOfWorkPageWillBeDisplayed();
		lastDaySteps.IenterValidDateForLastDayOfWork();
		intendToWorkSteps = new IntendToWorkForNHSStepDefs();
		intendToWorkSteps.theIntendToWorkForNHSPageWillbeDisplayed();
		intendToWorkSteps.iChooseYes();
		intendToWorkSteps.IenterTheValidDate();
	}

	@Given("^I have filled in last employment details$")
	public void iHaveFilledInLastEmploymentDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		workingForNHSPrefSteps = new WorkingForNHSStepDefs();
		workingForNHSPrefSteps.iGoToWorkingForNHSPage();
		sharedYesNoSteps = new SharedYeNoStepDefs();
		sharedYesNoSteps.iSelectNo();
		lastEmployerSteps = new NameOfYourLastEmployerStepDefs();
		lastEmployerSteps.whatWasTheNameofYourLastEmployerPageWillBeDisplayed();
		lastEmployerSteps.IenterValidNameOfLastNHSEmployerDetails();
		jobTitleSteps = new JobTitleStepDefs();
		jobTitleSteps.theJobTitlePageWillBeDisplayed();
		jobTitleSteps.IenterValidJobTitleDetails();
		dateYouLeaveSteps = new DateYouLeaveStepDefs();
		dateYouLeaveSteps.theDateYouleavePageWillBeDisplayed();
		dateYouLeaveSteps.IenterValidDateDetails();
		intendToWorkSteps = new IntendToWorkForNHSStepDefs();
		intendToWorkSteps.theIntendToWorkForNHSPageWillbeDisplayed();
		intendToWorkSteps.iChooseNo();
}
	
	@Given("^I fill in the last employment details$")
	public void iFillInTheLastEmploymentDetails() throws Throwable {
		lastEmployerSteps = new NameOfYourLastEmployerStepDefs();
		lastEmployerSteps.whatWasTheNameofYourLastEmployerPageWillBeDisplayed();
		lastEmployerSteps.IenterValidNameOfLastNHSEmployerDetails();
		jobTitleSteps = new JobTitleStepDefs();
		jobTitleSteps.theJobTitlePageWillBeDisplayed();
		jobTitleSteps.IenterValidJobTitleDetails();
		dateYouLeaveSteps = new DateYouLeaveStepDefs();
		dateYouLeaveSteps.theDateYouleavePageWillBeDisplayed();
		dateYouLeaveSteps.IenterValidDateDetails();
		intendToWorkSteps = new IntendToWorkForNHSStepDefs();
		intendToWorkSteps.theIntendToWorkForNHSPageWillbeDisplayed();
		intendToWorkSteps.iClickNextOnIntendToWorkPage();
}
	
	@And("^the correct current employment details will be displayed$")
	public void theCorrectCurrentEmploymentDetailsWillBeDisplayed() {
		employmentDetails_CheckYourAnswerPage = new EmploymentDetails_CheckYourAnswerPage(driver);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfWorkingForNHS()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getWorkingForNHSText()).matches(SharedData.sharedRadioButton);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfCurrentEmployerName()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getCurrentEmployerName()).matches("What is the name of your current NHS employer");
		assertThat(employmentDetails_CheckYourAnswerPage.getCurrentEmployerNameText()).matches(SharedData.employerName);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfEmployerAddress()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getEmployerAddressText()).matches(SharedData.streetLineOne + "\n" + SharedData.streetLineTwo + "\n" + SharedData.town + "\n"
				+ SharedData.postCode);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfLastDayOfWork()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getLastDayOfWorkText()).matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfIntendToWork()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getIntendToWorkText()).matches(SharedData.sharedNHSRadioButton);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfReturnDate()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getReturnDate()).matches("What date will you be returning work");
		assertThat(employmentDetails_CheckYourAnswerPage.getReturnDateText()).matches(SharedData.returnDay + " " + SharedData.returnMonth + " " + SharedData.returnYear);
		
	}

	@And("^the new current employment details will be displayed$")
	public void theNewCurrentEmploymentDetailsWillBeDisplayed() {
		employmentDetails_CheckYourAnswerPage = new EmploymentDetails_CheckYourAnswerPage(driver);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfWorkingForNHS()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getWorkingForNHSText()).matches(SharedData.sharedRadioButton);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfCurrentEmployerName()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getCurrentEmployerName()).matches("What is the name of your current NHS employer");
		assertThat(employmentDetails_CheckYourAnswerPage.getCurrentEmployerNameText()).matches(SharedData.employerName);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfEmployerAddress()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getEmployerAddressText()).matches(SharedData.streetLineOne + "\n" + SharedData.streetLineTwo + "\n" + SharedData.town + "\n"
				+ SharedData.postCode);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfLastDayOfWork()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getLastDayOfWorkText()).matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfIntendToWork()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getIntendToWorkText()).matches(SharedData.sharedNHSRadioButton);
		
	}

	@And("^the new last employment details will be displayed$")
	public void theNewLastEmploymentDetailsWillBeDisplayed() {
		employmentDetails_CheckYourAnswerPage = new EmploymentDetails_CheckYourAnswerPage(driver);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfWorkingForNHS()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getWorkingForNHSText()).matches(SharedData.sharedRadioButton);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfLastEmployerName()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getLastEmployerNameText()).matches(SharedData.employerName);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfJobTitle()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getJobTitleText()).matches(SharedData.jobTitle);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfDateYouLeave()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getDateYouLeaveText()).matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfIntendToWork()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getIntendToWorkText()).matches(SharedData.sharedNHSRadioButton);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfReturnDate()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getReturnDate()).matches("What date will you be returning work");
		assertThat(employmentDetails_CheckYourAnswerPage.getReturnDateText()).matches(SharedData.returnDay + " " + SharedData.returnMonth + " " + SharedData.returnYear);		
	}
	
	
	@And("^the correct last employment details will be displayed$")
	public void theCorrectLastEmploymentDetailsWillBeDisplayed() {
		employmentDetails_CheckYourAnswerPage = new EmploymentDetails_CheckYourAnswerPage(driver);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfWorkingForNHS()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getWorkingForNHSText()).matches(SharedData.sharedRadioButton);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfLastEmployerName()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getLastEmployerNameText()).matches(SharedData.employerName);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfJobTitle()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getJobTitleText()).matches(SharedData.jobTitle);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfDateYouLeave()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getDateYouLeaveText()).matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(employmentDetails_CheckYourAnswerPage.getPresenceOfIntendToWork()).isEqualTo(true);
		assertThat(employmentDetails_CheckYourAnswerPage.getIntendToWorkText()).matches(SharedData.sharedNHSRadioButton);
				
	}
	

	@And("^I navigate from current employer name page to check your answers page$")
	public void InavigateFromCurrentEmployerNamePageToCheckYourAnswersPage() {
		employerAddressSteps = new EmployerAddressStepDefs();
		employerAddressSteps.theEmployersAddressPageWillBeDisplayed();
		employerAddressSteps.iClickNextOnEmployerAddressPage();
		lastDaySteps = new LastDayOfWorkStepDefs();
		lastDaySteps.theLastDayOfWorkPageWillBeDisplayed();
		lastDaySteps.iClickNextOnLastDayOfWorkPage();
		intendToWorkSteps = new IntendToWorkForNHSStepDefs();
		intendToWorkSteps.theIntendToWorkForNHSPageWillbeDisplayed();
		intendToWorkSteps.iClickNextOnIntendToWorkPage();
	
	}
	
	@And("^I navigate from last employer name page to check your answers page$")
	public void InavigateFromLastEmployerNamePageToCheckYourAnswersPage() {
		jobTitleSteps = new JobTitleStepDefs();
		jobTitleSteps.theJobTitlePageWillBeDisplayed();
		jobTitleSteps.iClickNextOnJobTitlePage();
		dateYouLeaveSteps = new DateYouLeaveStepDefs();
		dateYouLeaveSteps.theDateYouleavePageWillBeDisplayed();
		dateYouLeaveSteps.iClickNextOnDateYouLeavePage();
		intendToWorkSteps = new IntendToWorkForNHSStepDefs();
		intendToWorkSteps.theIntendToWorkForNHSPageWillbeDisplayed();
		intendToWorkSteps.iClickNextOnIntendToWorkPage();
	
	}
	

	@And("^I navigate from current employer address page to check your answers page$")
	public void InavigateFromCurrentEmployerAddressPageToCheckYourAnswersPage() {
		lastDaySteps = new LastDayOfWorkStepDefs();
		lastDaySteps.theLastDayOfWorkPageWillBeDisplayed();
		lastDaySteps.iClickNextOnLastDayOfWorkPage();
		intendToWorkSteps = new IntendToWorkForNHSStepDefs();
		intendToWorkSteps.theIntendToWorkForNHSPageWillbeDisplayed();
		intendToWorkSteps.iClickNextOnIntendToWorkPage();
	
	}
	
	
	@And("^I navigate from job title page to check your answers page$")
	public void InavigateFromJobTitlePageToCheckYourAnswersPage() {
		dateYouLeaveSteps = new DateYouLeaveStepDefs();
		dateYouLeaveSteps.theDateYouleavePageWillBeDisplayed();
		dateYouLeaveSteps.iClickNextOnDateYouLeavePage();
		intendToWorkSteps = new IntendToWorkForNHSStepDefs();
		intendToWorkSteps.theIntendToWorkForNHSPageWillbeDisplayed();
		intendToWorkSteps.iClickNextOnIntendToWorkPage();
	
	}
	
	@And("^I navigate from last day of work page to check your answers page$")
	public void InavigateFromlastDayOfWorkPageToCheckYourAnswersPage() {
		intendToWorkSteps = new IntendToWorkForNHSStepDefs();
		intendToWorkSteps.theIntendToWorkForNHSPageWillbeDisplayed();
		intendToWorkSteps.iClickNextOnIntendToWorkPage();
	
	}
	
	@And("^I navigate from date you leave page to check your answers page$")
	public void InavigateFromDateYouleavePageToCheckYourAnswersPage() {
		intendToWorkSteps = new IntendToWorkForNHSStepDefs();
		intendToWorkSteps.theIntendToWorkForNHSPageWillbeDisplayed();
		intendToWorkSteps.iClickNextOnIntendToWorkPage();
	
	}
	
	
	
	@And("^the updated current (.*) will be displayed$")
	public void theUpdatedCurrentDetailsWillBeDisplayed(String field) {
		employmentDetails_CheckYourAnswerPage = new EmploymentDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "employerName":
			assertThat(employmentDetails_CheckYourAnswerPage.getCurrentEmployerNameText())
					.matches(SharedData.employerName);
			break;
		case "employerAddress":
			assertThat(employmentDetails_CheckYourAnswerPage.getEmployerAddressText())
					.matches(SharedData.streetLineOne + "\n" + SharedData.streetLineTwo + "\n" + SharedData.town + "\n"	+ SharedData.postCode);
			break;
		case "lastDay":
			assertThat(employmentDetails_CheckYourAnswerPage.getLastDayOfWorkText()).matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
			break;
		case "returnDate":
			assertThat(employmentDetails_CheckYourAnswerPage.getReturnDateText())
					.matches(SharedData.returnDay + " " + SharedData.returnMonth + " " + SharedData.returnYear);
			break;
		case "intendToWork":
			assertThat(employmentDetails_CheckYourAnswerPage.getIntendToWorkText()).matches(SharedData.sharedNHSRadioButton);
			break;
		}
	}
	
	
	@And("^the updated last (.*) will be displayed$")
	public void theUpdatedLastDetailsWillBeDisplayed(String field) {
		employmentDetails_CheckYourAnswerPage = new EmploymentDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "employmentName":
			assertThat(employmentDetails_CheckYourAnswerPage.getLastEmployerNameText())
					.matches(SharedData.employerName);
			break;
		case "jobTitle":
			assertThat(employmentDetails_CheckYourAnswerPage.getJobTitleText())
					.matches(SharedData.jobTitle);
			break;
		case "leavingDate":
			assertThat(employmentDetails_CheckYourAnswerPage.getDateYouLeaveText()).matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
			break;
		case "workingForNHS":
			assertThat(employmentDetails_CheckYourAnswerPage.getWorkingForNHSText())
					.matches(SharedData.sharedRadioButton);
			break;
	}
}
	
}
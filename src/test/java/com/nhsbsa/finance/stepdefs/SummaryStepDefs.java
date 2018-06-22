package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.SummaryPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SummaryStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
   private SummaryPage  summaryPage;
   private PersonalDetails_CheckYourAnswersStepDefs personalDetailsSteps;
   private DependantDetails_CheckYourAnswersStepDefs dependantDetailsSteps;
   private EmploymentDetails_CheckYourAnswersStepDefs employmentDetailsSteps;
   private ContactDetails_CheckYourAnswersStepDefs2 contactDetailsSteps;
   private PensionDetails_CheckYourAnswersStepDefs pensionDetailsSteps;
   private HMRC2Details_CheckYourAnswersStepDefs hmrcDetailsSteps;
   private PaymentDetails_CheckYourAnswersStepDefs paymentetailsSteps;
   private CheckYourAnswersStepDefs checkYourAnswersSteps;
   
   
	@Then("^the summary page will be displayed$")
  public void theSummaryPageWillBeDisplayed() {
	  summaryPage = new SummaryPage(driver);
	  assertThat(summaryPage.getSummaryHeading()).contains("Your application");
  }
	

	@When("^I go to the summary page$")
	public void iGoToTheSummaryPage() {

		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/summary");
		summaryPage = new SummaryPage(driver);
		assertThat(summaryPage.getSummaryHeading()).contains("Your application");
	}

	@Then("^I click on submit button$")
	public void iClickOnSubmitButton() {
		summaryPage.submitApplication();
	}

	@When("^the completed field will be displayed against (.*) details section$")
	public void theCompletedFieldWillBeDisplayedAgainstDetailsSection(String field){
		summaryPage = new SummaryPage(driver);
		switch (field) {
		case "personal":
			assertThat(summaryPage.isPersonalDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getPersonalDetailCompletedValue()).matches("COMPLETED");
			break;
		case "dependant":
			assertThat(summaryPage.isPartnerDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getPartnerDetailCompletedValue()).matches("COMPLETED");
			break;
		case "employment":
			assertThat(summaryPage.isEmploymentDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getEmploymentDetailCompletedValue()).matches("COMPLETED");
			break;
		case "contact":
			assertThat(summaryPage.isContactDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getContactDetailCompletedValue()).matches("COMPLETED");
			break;
		case "pension":
			assertThat(summaryPage.isPensionDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getPensionDetailCompletedValue()).matches("COMPLETED");
			break;
		case "hmrc":
			assertThat(summaryPage.isHmrcDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getHmrcDetailCompletedValue()).matches("COMPLETED");
			break;
		case "payment":
			assertThat(summaryPage.isPaymentDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getPaymentDetailCompletedValue()).matches("COMPLETED");
			break;

		}		
	}
	
	
	@When("^I click on (.*) details link$")
	public void iClickOnDetailsLink(String field){
		summaryPage = new SummaryPage(driver);
		switch (field) {
		case "personal":
			summaryPage.personalDetailsLink();
			break;
		case "dependant":
			summaryPage.partnerDetailsLink();
			break;
		case "employment":
			summaryPage.employmentDetailsLink();
			break;
		case "contact":
			summaryPage.contactDetailsLink();
			break;
		case "pension":
			summaryPage.pensionDetailsLink();
			break;
		case "hmrc":
			summaryPage.hmrcDetailsLink();
			break;
		case "payment":
			summaryPage.paymentDetailsLink();
			break;
		}
	
	}
	
	
	@When("^the (.*) section is not completed$")
	public void thePersonalDetailSectionIsNotCompleted(String field){
		summaryPage = new SummaryPage(driver);
		switch (field) {
	case "personalDetail":
		assertThat(summaryPage.isPersonalDetailsCompleted()).isEqualTo(false);
		break;
		case "dependantDetail":
		assertThat(summaryPage.isPartnerDetailsCompleted()).isEqualTo(false);
		break;
	case "employmentDetail":
		assertThat(summaryPage.isEmploymentDetailsCompleted()).isEqualTo(false);
		break;
	case "contactDetail":
		assertThat(summaryPage.isContactDetailsCompleted()).isEqualTo(false);
		break;
	case "pensionDetail":
		assertThat(summaryPage.isPensionDetailsCompleted()).isEqualTo(false);
		break;
	case "hmrcDetail":
		assertThat(summaryPage.isHmrcDetailsCompleted()).isEqualTo(false);
		break;
	case "paymentDetail":
		assertThat(summaryPage.isPaymentDetailsCompleted()).isEqualTo(false);
		break;
		}	
		
	}
	
	@When("^any section is not completed$")
	public void anySectionIsNotCompleted(){
		summaryPage = new SummaryPage(driver);
		
		assertThat(summaryPage.isPersonalDetailsCompleted()).isEqualTo(false);
        assertThat(summaryPage.isPartnerDetailsCompleted()).isEqualTo(false);
        assertThat(summaryPage.isEmploymentDetailsCompleted()).isEqualTo(false);
        assertThat(summaryPage.isContactDetailsCompleted()).isEqualTo(false);
        assertThat(summaryPage.isPensionDetailsCompleted()).isEqualTo(false);
        assertThat(summaryPage.isHmrcDetailsCompleted()).isEqualTo(false);
        assertThat(summaryPage.isPaymentDetailsCompleted()).isEqualTo(false);
	}
	
	
	@When("^I have completed (.*) details section$")
	public void iHaveCompletedDetailsSection(String field) throws Throwable{
	switch (field) {
	case "personal":
		personalDetailsSteps = new PersonalDetails_CheckYourAnswersStepDefs();
		personalDetailsSteps.iHaveFilledInAPersonalDetails();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		break;
	case "dependant":
		dependantDetailsSteps = new DependantDetails_CheckYourAnswersStepDefs();
		dependantDetailsSteps.iHaveFilledInADependantlDetails();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		break;	
	case "employment":
		employmentDetailsSteps = new EmploymentDetails_CheckYourAnswersStepDefs();
		employmentDetailsSteps.iHaveFilledInCurrentEmploymentDetails();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		break;	
	case "contact":
		contactDetailsSteps = new ContactDetails_CheckYourAnswersStepDefs2();
		contactDetailsSteps.iHaveFilledInAContactDetails();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		break;			
	case "pension":
		pensionDetailsSteps = new PensionDetails_CheckYourAnswersStepDefs();
		pensionDetailsSteps.iHaveFilledIn1995PensionSchemeDetails();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		break;			
	case "hmrc":
		hmrcDetailsSteps = new HMRC2Details_CheckYourAnswersStepDefs();
		hmrcDetailsSteps.iHaveFilledInTheHmrc2Details();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		break;			
	case "payment":
		paymentetailsSteps = new PaymentDetails_CheckYourAnswersStepDefs();
		paymentetailsSteps.iHaveFilledInAPaymentDetails();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		break;	
		
		}
	}

	
	@When("^I have completed all sections$")
	public void iHaveCompletedAllSections() throws Throwable{
		
		personalDetailsSteps = new PersonalDetails_CheckYourAnswersStepDefs();
		personalDetailsSteps.iHaveFilledInAPersonalDetails();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.partnerDetailsLink();
		dependantDetailsSteps = new DependantDetails_CheckYourAnswersStepDefs();
		dependantDetailsSteps.iHaveFilledInADependantlDetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.employmentDetailsLink();
		employmentDetailsSteps = new EmploymentDetails_CheckYourAnswersStepDefs();
		employmentDetailsSteps.iHaveFilledInCurrentEmploymentDetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.contactDetailsLink();
		contactDetailsSteps = new ContactDetails_CheckYourAnswersStepDefs2();
		contactDetailsSteps.iHaveFilledInAContactDetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.pensionDetailsLink();
		pensionDetailsSteps = new PensionDetails_CheckYourAnswersStepDefs();
		pensionDetailsSteps.iHaveFilledIn1995PensionSchemeDetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.hmrcDetailsLink();
		hmrcDetailsSteps = new HMRC2Details_CheckYourAnswersStepDefs();
		hmrcDetailsSteps.iHaveFilledInTheHmrc2DetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.paymentDetailsLink();
		paymentetailsSteps = new PaymentDetails_CheckYourAnswersStepDefs();
		paymentetailsSteps.iHaveFilledInAPaymentDetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		theSummaryPageWillBeDisplayed();
	
		}
	
	@Then("^the submit button will be disabled$")
	public void theSubmitButtonWillBeDisabled(){
		summaryPage = new SummaryPage(driver);
	assertThat(summaryPage.isSubmitButtonEnabled()).isFalse();
		
      
	}
}
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

 
   
   
	@Then("^the summary page will be displayed$")
  public void theSummaryPageWillBeDisplayed() {
	  summaryPage = new SummaryPage(driver);
   driver.getPageSource().contains("Your application");
  }
	

	@When("^I go to the summary page$")
	public void iGoToTheSummaryPage() {

		Page page = new Page(driver);
		page.navigateToUrl(baseUrl + "/summary");
		summaryPage = new SummaryPage(driver);
		assertThat(summaryPage.getSummaryHeading()).contains("Your application");
	}

	@Then("^I click on continue button$")
	public void iClickOnContinueButton() {
		summaryPage.submitApplication();
	}

	@When("^the completed field will be displayed against (.*) details section$")
	public void theCompletedFieldWillBeDisplayedAgainstDetailsSection(String field){
		summaryPage = new SummaryPage(driver);
		switch (field) {
		case "personal":
			System.out.println("*******" + summaryPage.isPersonalDetailsCompleted());
			System.out.println("&&&&&&&&" + summaryPage.getPersonalDetailCompletedValue());
			assertThat(summaryPage.isPersonalDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getPersonalDetailCompletedValue()).matches("COMPLETED");
			break;
		case "dependant":
			System.out.println("$$$$$$$$" + summaryPage.isPartnerDetailsCompleted());
			System.out.println("%%%%%%%%" + summaryPage.getPartnerDetailCompletedValue());
			assertThat(summaryPage.isPartnerDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getPartnerDetailCompletedValue()).matches("COMPLETED");
			break;
		case "employment":
			System.out.println("^^^^^^^^" + summaryPage.isEmploymentDetailsCompleted());
			System.out.println("!!!!!!!!" + summaryPage.getEmploymentDetailCompletedValue());
			assertThat(summaryPage.isEmploymentDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getEmploymentDetailCompletedValue()).matches("COMPLETED");
			break;
		case "contact":
			System.out.println("{{{{{{{{{{" + summaryPage.isContactDetailsCompleted());
			System.out.println("}}}}}}}}}}" + summaryPage.getContactDetailCompletedValue());
			assertThat(summaryPage.isContactDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getContactDetailCompletedValue()).matches("COMPLETED");
			break;
		case "pension":
			System.out.println("*******" + summaryPage.isPensionDetailsCompleted());
			System.out.println("&&&&&&&&" + summaryPage.getPensionDetailCompletedValue());
			assertThat(summaryPage.isPensionDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getPensionDetailCompletedValue()).matches("COMPLETED");
			break;
		case "hmrc":
			System.out.println("@@@@@@@@" + summaryPage.isHmrcDetailsCompleted());
			System.out.println("++++++++" + summaryPage.getHmrcDetailCompletedValue());
			assertThat(summaryPage.isHmrcDetailsCompleted()).isEqualTo(true);
			assertThat(summaryPage.getHmrcDetailCompletedValue()).matches("COMPLETED");
			break;
		case "payment":
			System.out.println("???????" + summaryPage.isPaymentDetailsCompleted());
			System.out.println("########" + summaryPage.getPaymentDetailCompletedValue());
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
		System.out.println("@@@@@" + summaryPage.isPersonalDetailsCompleted());
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
		personalDetailsSteps.iSubmitThePersonalDetails();
		theSummaryPageWillBeDisplayed();
		break;
	case "dependant":
		dependantDetailsSteps = new DependantDetails_CheckYourAnswersStepDefs();
		dependantDetailsSteps.iHaveFilledInADependantlDetails();
		dependantDetailsSteps.iSubmitTheDependantDetails();
		theSummaryPageWillBeDisplayed();
		break;	
	case "employment":
		employmentDetailsSteps = new EmploymentDetails_CheckYourAnswersStepDefs();
		employmentDetailsSteps.iHaveFilledInCurrentEmploymentDetails();
		employmentDetailsSteps.iSubmitTheEmploymentDetails();
		theSummaryPageWillBeDisplayed();
		break;	
	case "contact":
		contactDetailsSteps = new ContactDetails_CheckYourAnswersStepDefs2();
		contactDetailsSteps.iHaveFilledInAContactDetails();
		contactDetailsSteps.iSubmitTheContactDetails();
		theSummaryPageWillBeDisplayed();
		break;			
	case "pension":
		pensionDetailsSteps = new PensionDetails_CheckYourAnswersStepDefs();
		pensionDetailsSteps.iHaveFilledIn1995PensionSchemeDetails();
		pensionDetailsSteps.iSubmitThePensionSchemeDetails();
		theSummaryPageWillBeDisplayed();
		break;			
	case "hmrc":
		hmrcDetailsSteps = new HMRC2Details_CheckYourAnswersStepDefs();
		hmrcDetailsSteps.iHaveFilledInTheHmrc2Details();
		hmrcDetailsSteps.iSubmitTheHmrc2Details();
		theSummaryPageWillBeDisplayed();
		break;			
	case "payment":
		paymentetailsSteps = new PaymentDetails_CheckYourAnswersStepDefs();
		paymentetailsSteps.iHaveFilledInAPaymentDetails();
		paymentetailsSteps.iSubmitThePaymentDetails();
		theSummaryPageWillBeDisplayed();
		break;	
		
		}
	}

	
	@When("^I have completed all sections$")
	public void iHaveCompletedAllSections() throws Throwable{
		
		personalDetailsSteps = new PersonalDetails_CheckYourAnswersStepDefs();
		personalDetailsSteps.iHaveFilledInAPersonalDetails();
		personalDetailsSteps.iSubmitThePersonalDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.partnerDetailsLink();
		dependantDetailsSteps = new DependantDetails_CheckYourAnswersStepDefs();
		dependantDetailsSteps.iHaveFilledInADependantlDetailsForSummaryPage();
		dependantDetailsSteps.iSubmitTheDependantDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.employmentDetailsLink();
		employmentDetailsSteps = new EmploymentDetails_CheckYourAnswersStepDefs();
		employmentDetailsSteps.iHaveFilledInCurrentEmploymentDetailsForSummaryPage();
		employmentDetailsSteps.iSubmitTheEmploymentDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.contactDetailsLink();
		contactDetailsSteps = new ContactDetails_CheckYourAnswersStepDefs2();
		contactDetailsSteps.iHaveFilledInAContactDetailsForSummaryPage();
		contactDetailsSteps.iSubmitTheContactDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.pensionDetailsLink();
		pensionDetailsSteps = new PensionDetails_CheckYourAnswersStepDefs();
		pensionDetailsSteps.iHaveFilledIn1995PensionSchemeDetailsForSummaryPage();
		pensionDetailsSteps.iSubmitThePensionSchemeDetails();
		theSummaryPageWillBeDisplayed();
		summaryPage.hmrcDetailsLink();
		hmrcDetailsSteps = new HMRC2Details_CheckYourAnswersStepDefs();
		hmrcDetailsSteps.iHaveFilledInTheHmrc2DetailsForSummaryPage();
		hmrcDetailsSteps.iSubmitTheHmrc2Details();
		theSummaryPageWillBeDisplayed();
		summaryPage.paymentDetailsLink();
		paymentetailsSteps = new PaymentDetails_CheckYourAnswersStepDefs();
		paymentetailsSteps.iHaveFilledInAPaymentDetailsForSummaryPage();
		paymentetailsSteps.iSubmitThePaymentDetails();
		theSummaryPageWillBeDisplayed();
	
		}
	
	@Then("^the continue button will be disabled$")
	public void theContinueButtonWillBeDisabled(){
		summaryPage = new SummaryPage(driver);
	assertThat(summaryPage.isContinueButtonEnabled()).isFalse();
		
      
	}
}
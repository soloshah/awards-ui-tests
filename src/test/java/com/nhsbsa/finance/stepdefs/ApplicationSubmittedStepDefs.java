package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ApplicationSubmittedPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.SummaryPage;
import com.nhsbsa.finance.properties.PropertyReader;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationSubmittedStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
   private ApplicationSubmittedPage  applicationSubmittedPage;
   private PersonalDetails_CheckYourAnswersStepDefs personalDetailsSteps;
   private DependantDetails_CheckYourAnswersStepDefs dependantDetailsSteps;
   private EmploymentDetails_CheckYourAnswersStepDefs employmentDetailsSteps;
   private ContactDetails_CheckYourAnswersStepDefs2 contactDetailsSteps;
   private PensionDetails_CheckYourAnswersStepDefs pensionDetailsSteps;
   private HMRC2Details_CheckYourAnswersStepDefs hmrcDetailsSteps;
   private PaymentDetails_CheckYourAnswersStepDefs paymentetailsSteps;
   private CheckYourAnswersStepDefs checkYourAnswersSteps;
   private SummaryPage summaryPage;
  

	@Then("^the application submitted page will be displayed$")
  public void theApplicationSubmittedPageWillBeDisplayed() {
		applicationSubmittedPage = new ApplicationSubmittedPage(driver);
		assertThat(applicationSubmittedPage.getFormCompleteHeaderText()).contains("Form complete");
  }
	
	@Then("^I fill in the application$")
	  public void iFillInTheApplication() throws Throwable {
		personalDetailsSteps = new PersonalDetails_CheckYourAnswersStepDefs();
		personalDetailsSteps.iHaveFilledInAPersonalDetails();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		summaryPage = new SummaryPage(driver);
		summaryPage.partnerDetailsLink();
		dependantDetailsSteps = new DependantDetails_CheckYourAnswersStepDefs();
		dependantDetailsSteps.iHaveFilledInADependantlDetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		summaryPage = new SummaryPage(driver);
		summaryPage.employmentDetailsLink();
		employmentDetailsSteps = new EmploymentDetails_CheckYourAnswersStepDefs();
		employmentDetailsSteps.iHaveFilledInCurrentEmploymentDetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		summaryPage = new SummaryPage(driver);
		summaryPage.contactDetailsLink();
		contactDetailsSteps = new ContactDetails_CheckYourAnswersStepDefs2();
		contactDetailsSteps.iHaveFilledInAContactDetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		summaryPage = new SummaryPage(driver);
		summaryPage.pensionDetailsLink();
		pensionDetailsSteps = new PensionDetails_CheckYourAnswersStepDefs();
		pensionDetailsSteps.iHaveFilledIn1995PensionSchemeDetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		summaryPage = new SummaryPage(driver);
		summaryPage.hmrcDetailsLink();
		hmrcDetailsSteps = new HMRC2Details_CheckYourAnswersStepDefs();
		hmrcDetailsSteps.iHaveFilledInTheHmrc2DetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		summaryPage = new SummaryPage(driver);
		summaryPage.paymentDetailsLink();
		paymentetailsSteps = new PaymentDetails_CheckYourAnswersStepDefs();
		paymentetailsSteps.iHaveFilledInAPaymentDetailsForSummaryPage();
		checkYourAnswersSteps = new CheckYourAnswersStepDefs();
		checkYourAnswersSteps.iSubmitAllDetails();
		summaryPage = new SummaryPage(driver);
		summaryPage.submitApplication();
	  }
	
	@Given("^I go to application submitted page$")
	public void iGoToApplicationSubmittedPage() {
		new Page(driver).navigateToUrl(baseUrl + "/application-submitted");
		applicationSubmittedPage = new ApplicationSubmittedPage(driver);
		assertThat(applicationSubmittedPage.getFormCompleteHeaderText()).contains("Form complete");
	}

	@Then("^the form complete header will be displayed$")
	public void theFormCompleteHeaderWillBeDisplayed() {
		new Page(driver).navigateToUrl(baseUrl + "/application-submitted");
		applicationSubmittedPage = new ApplicationSubmittedPage(driver);
		assertThat(applicationSubmittedPage.getFormCompleteHeaderText()).contains("Form complete");
		assertThat(applicationSubmittedPage.getNextStepText())
				.contains("Follow the next steps to complete your application");
	}
	
	@When("^I click on the link who a witness can be$")
	public void iClickOnTheLinkWhoAWitnessCanBe() {
		applicationSubmittedPage = new ApplicationSubmittedPage(driver);
		applicationSubmittedPage.verifyWitnessLink();
		
	}

	@Then("^the witness information will be displayed$")
	public void theWitnessInformationWillBeDisplayed() {
		applicationSubmittedPage = new ApplicationSubmittedPage(driver);
		assertThat(applicationSubmittedPage.verifyWitnessLinkText().contains("A witness can also be a professional outside of the UK, including:"));
	}

	@When("^I click on finished button$")
	public void iClickOnFinsihedButton() {
		applicationSubmittedPage = new ApplicationSubmittedPage(driver);
		applicationSubmittedPage.clickFinished();
		
	}
	
}
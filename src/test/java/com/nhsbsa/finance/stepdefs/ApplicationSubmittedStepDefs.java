package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ApplicationSubmittedPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationSubmittedStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
   private ApplicationSubmittedPage  applicationSubmittedPage;

	@Then("^the application submitted page will be displayed$")
  public void theSummaryPageWillBeDisplayed() {
		applicationSubmittedPage = new ApplicationSubmittedPage(driver);
		assertThat(applicationSubmittedPage.getFormCompleteHeaderText()).contains("Form complete");
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
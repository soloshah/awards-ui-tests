package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NHSBSAWebsitePage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.SubmitClaimLaterPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SubmitClaimLaterStepDefs {

  private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
   private SubmitClaimLaterPage  submitClaimLaterPage;
   private NHSBSAWebsitePage nHSBSAWebsitePage;

	@Then("^the submit claim later page will be displayed$")
	public void theSubmitClaimLaterPageWillBeDisplayed(){
		submitClaimLaterPage = new SubmitClaimLaterPage(driver);
		assertThat(submitClaimLaterPage.getHeading()).contains("Submit your claim later");
		
	}
	
	@Given("^I go to the submit claim later page$")
	public void iGoToTheSubmitClaimLaterPage(){
		new Page(driver).navigateToUrl(baseUrl + "/pension-arrangement-details/submit-your-claim-later");
		submitClaimLaterPage = new SubmitClaimLaterPage(driver);
		assertThat(submitClaimLaterPage.getHeading()).contains("Submit your claim later");
		
	}
		
	
	@When("^I click on NHS website link$")
	public void iClickOnNHSWebsiteLink(){
		submitClaimLaterPage = new SubmitClaimLaterPage(driver);
		submitClaimLaterPage.clickNHSLink();
		
	}
	
	@Then("^the NHS pensions page will be displayed$")
	public void theNHSPensionsPageWillBeDisplayed(){
		nHSBSAWebsitePage = new NHSBSAWebsitePage(driver);
		assertThat(nHSBSAWebsitePage.getNhsPensionsHeading()).contains("NHS Pensions");
		
	}
}
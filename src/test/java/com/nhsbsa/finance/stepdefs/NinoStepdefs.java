package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DateOfBirthPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.NinoPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NinoStepdefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");

  private NinoPage ninoPage;

  @Given("^I am on the national insurance page$")
  public void iAmOnTheNationalInsurancePage() {
    new Page(driver).navigateToUrl(baseUrl+ "/personal-details/what-is-your-ni");
  }
  
  @When("^I go to nino page$")
  public void iGoToNinoPage() {
   
    	Page page = new Page(driver);
    	page.navigateToUrl(baseUrl + "/personal-details/what-is-your-ni");
     ninoPage = new NinoPage(driver);
     assertThat(ninoPage.getHeading()).contains("What is your National Insurance number?");
  }
  
  @Then("^the national insurance number submission will be successful$")
  public void theNationalInsuranceNumberSubmissionWillBeSuccessful() {
	 new NavBarPage(driver);
  }
  
	@Then("^the national insurance page will be displayed$")
	public void theNationalInsurancePageWillBeDisplayed() {
		ninoPage = new NinoPage(driver);
		assertThat(ninoPage.getHeading()).contains("What is your National Insurance number?");
	}
  
  @Then("^the national insurance number submission will be unsuccessful$")
  public void theNationalInsuranceNumberSubmissionWillBeUnsuccessful() {
	  ninoPage = new NinoPage(driver);
    assertThat(ninoPage.getErrorHeadingErrorMessage())
        .matches("Some questions have not been answered correctly:");
    assertThat(ninoPage
    		.getErrorsBelowErrorMessage())
        .matches("Please see the errors below.");
  }
  
  @And("^the nino error message '(.*)' will be displayed$")
  public void theNinoErrorMessageWillBeDisplayed(String errorMessage) {
	  ninoPage = new NinoPage(driver);
    assertThat(ninoPage.doesNinoErrorMessageHaveAnchor()).isTrue();
    assertThat(ninoPage.getNinoAnchoredErrorMessage()).matches(errorMessage);
    assertThat(ninoPage.getNinoFieldErrorMessage()).matches(errorMessage);
  }
  
  @When("^I enter national insurance number using the nino '(.*)'$")
  public void iEnterNationalInsuranceNumberUsingTheNino(
      String nino) {
     ninoPage = new NinoPage(driver);
     ninoPage.enterNino(nino);
     ninoPage.submitInValidNinoDetails();
     
}
  
  @When ("^I enter valid national insurance number$")
  public void IenterValidNationalInsuranceNumber(){
	 SharedData.nino = "AA123456A";
	  ninoPage = new NinoPage(driver); 
	  ninoPage.submitValidNiDetails(SharedData.nino);
	    }
  
}
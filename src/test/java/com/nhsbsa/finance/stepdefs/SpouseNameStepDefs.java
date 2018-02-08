package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.SpouseNamePage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SpouseNameStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
  private SpouseNamePage  spouseNamePage;


  @Given("^I am on the spouse name page$")
  public void iAmOnTheSpouseNamePage() {
    new Page(driver).navigateToUrl(baseUrl+ "/about-you/spousename");
  }

  @Then("^the spouse name submission will be successful$")
  public void theSpouseNameSubmissionWillBeSuccessful() {
	 new NavBarPage(driver);
  }
  
  @When("^I enter valid spouse name details$")
  public void IenterValidSpouseNameDetails(){
	  SharedData.firstName = "Spouse Test";
	  SharedData.lastName = "User";	
	  spouseNamePage = new SpouseNamePage(driver); 
	  spouseNamePage.submitValidSpouseNameDetails(SharedData.firstName, SharedData.lastName);
  }	
  
  @Then("^the spouse name submission will be unsuccessful$")
  public void theSpouseNameSubmissionWillBeUnsuccessful() {
	  spouseNamePage = new SpouseNamePage(driver); 
    assertThat(spouseNamePage.getErrorHeadingErrorMessage())
        .matches("Some questions have not been answered correctly.");
    assertThat(spouseNamePage
    		.getErrorsBelowErrorMessage())
        .matches("Please see the errors below.");
  }
  
  @When("^I enter spouse name details using the firstName '(.*)' and lastName '(.*)'$")
  public void iEnterSpouseNameDetailsUsingTheFirstNameAndLastName(
      String firstName, String lastName) {
  	  spouseNamePage = new SpouseNamePage(driver); 
	  spouseNamePage
        .enterNameDetails(SharedData.firstName,
            SharedData.lastName);
	  spouseNamePage.submitInValidSpouseNameDetails();
}
  
  @And("^the spouse name error message '(.*)' will be displayed$")
  public void theSpouseNameErrorMessageWillBeDisplayed(String errorMessage) {
	  spouseNamePage = new SpouseNamePage(driver); 
    assertThat(spouseNamePage.doesSpouseNameErrorMessageHaveAnchor()).isTrue();
    assertThat(spouseNamePage.getSpouseNameAnchoredErrorMessage()).matches(errorMessage);
    assertThat(spouseNamePage.getSpouseNameFieldErrorMessage()).matches(errorMessage);
  }
 
}

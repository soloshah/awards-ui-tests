package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ChildNamePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChildNameStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
  private ChildNamePage  childNamePage;


  @Given("^I am on the child name page$")
  public void iAmOnTheChildNamePage() {
    new Page(driver).navigateToUrl(baseUrl+ "/about-you/childname");
  }

  @Then("^the child name submission will be successful$")
  public void theChildNameSubmissionWillBeSuccessful() {
	 new NavBarPage(driver);
  }
  
  @When("^I enter valid child name details$")
  public void IenterValidChildNameDetails() {
	 
	  SharedData.firstName = "Child Test";
	  SharedData.lastName = "User";	
	  childNamePage = new ChildNamePage(driver); 
	  childNamePage.submitValidChildNameDetails(SharedData.firstName, SharedData.lastName);
	    }
  
  @Then("^the child name submission will be unsuccessful$")
  public void theChildNameSubmissionWillBeUnsuccessful() {
	  childNamePage = new ChildNamePage(driver); 
    assertThat(childNamePage.getErrorHeadingErrorMessage())
        .matches("Some questions have not been answered correctly.");
    assertThat(childNamePage
    		.getErrorsBelowErrorMessage())
        .matches("Please see the errors below.");
  }
  
  @When("^I enter child name details using the firstName '(.*)' and lastName '(.*)'$")
  public void iEnterChildNameDetailsUsingTheFirstNameAndLastName(
      String firstName, String lastName) {
    
	  childNamePage = new ChildNamePage(driver); 
	  childNamePage
        .enterNameDetails(SharedData.firstName,
            SharedData.lastName);
	  childNamePage.submitInValidChildNameDetails();
}
  
  @And("^the child name error message '(.*)' will be displayed$")
  public void theChildNameErrorMessageWillBeDisplayed(String errorMessage) {
	  childNamePage = new ChildNamePage(driver); 
    assertThat(childNamePage.doesChildNameErrorMessageHaveAnchor()).isTrue();
    assertThat(childNamePage.getChildNameAnchoredErrorMessage()).matches(errorMessage);
    assertThat(childNamePage.getChildNameFieldErrorMessage()).matches(errorMessage);
  }
  
 
}

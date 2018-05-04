package com.nhsbsa.finance.stepdefs;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.FeedbackPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.ThankyouPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeedbackStepDefs {

  private WebDriver driver = Config.getDriver();
   private FeedbackPage  feedbackPage;
   private ThankyouPage thankyouPage;

  @Then("^the feedback page will be displayed$")
  public void theFeedbackPageWillBeDisplayed() {
	  feedbackPage = new FeedbackPage(driver);
   driver.getPageSource().contains("Claim my NHS pension feedback");
   
  }
  
  @Given("^I go to feedback page$")
  public void iGoToFeedbackPage() {
	  new Page(driver).navigateToUrl("https://www.snapsurveys.com/wh/s.asp?k=151924233722");
	  
  }
  
  @When("^I select the option for feedback$")
  public void iSelectTheOptionForFeedback() {
	  feedbackPage = new FeedbackPage(driver);
	  feedbackPage.click9RadioButton();
	  feedbackPage.clickSubmit();
  
  }
  
	@Then("^the thankyou page will be displayed$")
	public void theThankyouPageWillBeDisplayed() {
		thankyouPage = new ThankyouPage(driver);
		driver.getPageSource().contains("Thank you");

	}
  
  
  
}
package com.nhsbsa.finance.stepdefs;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ApplicationSubmittedPage;


import cucumber.api.java.en.Then;

public class ApplicationSubmittedStepDefs {

  private WebDriver driver = Config.getDriver();
 // private String baseUrl = PropertyReader.getProperty("base.server");
   private ApplicationSubmittedPage  applicationSubmittedPage;

	@Then("^the application submitted page will be displayed$")
  public void theSummaryPageWillBeDisplayed() {
		applicationSubmittedPage = new ApplicationSubmittedPage(driver);
   driver.getPageSource().contains("Form complete");
  }
}
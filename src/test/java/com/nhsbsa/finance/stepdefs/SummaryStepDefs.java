package com.nhsbsa.finance.stepdefs;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.SummaryPage;

import cucumber.api.java.en.Then;

public class SummaryStepDefs {

  private WebDriver driver = Config.getDriver();
 // private String baseUrl = PropertyReader.getProperty("base.server");
   private SummaryPage  summaryPage;

	@Then("^the summary page will be displayed$")
  public void theSummaryPageWillBeDisplayed() {
	  summaryPage = new SummaryPage(driver);
   driver.getPageSource().contains("Your application");
  }
}
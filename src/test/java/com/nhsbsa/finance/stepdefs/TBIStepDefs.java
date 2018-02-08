package com.nhsbsa.finance.stepdefs;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.TBIPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Then;

public class TBIStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
  private TBIPage  tBIPage;

  @Then("^the tbi page will be displayed$")
  public void theGenderPageWillBeDisplayed() {
	  tBIPage = new TBIPage(driver);
   driver.getPageSource().contains("This page is yet to be implemented");
  }
}
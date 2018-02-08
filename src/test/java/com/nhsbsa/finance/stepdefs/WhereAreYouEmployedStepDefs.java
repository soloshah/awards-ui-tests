package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.WhereAreYouEmployedPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Then;

public class WhereAreYouEmployedStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
  private WhereAreYouEmployedPage  whereAreYouEmployedPage;

  @Then("^Where are you employed page is displayed$")
  public void whereAreYouEmployedPageWillBeDisplayed() {
	  whereAreYouEmployedPage = new WhereAreYouEmployedPage(driver);
    assertThat(whereAreYouEmployedPage.getHeading()).matches("What is the name of your current NHS employer??");
  }
}
package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.SpouseDOBPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Then;

public class SpouseDOBStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
  private SpouseDOBPage  spouseDOBPage;
  
  
  @Then("^the spouse date of birth page will be displayed$")
  public void theSpouseDateOfBirthPageWillBeDisplayed() {
	  spouseDOBPage = new SpouseDOBPage(driver);
    assertThat(spouseDOBPage.getHeading()).matches("What is your date of birth?");
  }

}
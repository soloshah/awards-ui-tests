package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NameOfYourLastEmployerPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Then;

public class NameOfYourLastEmployerStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
  private NameOfYourLastEmployerPage  nameOfYourLastEmployerPage;

  @Then("^What was the name of your last employer page will be displayed$")
  public void whatWasTheNameofYourLastEmployerPageWillBeDisplayed() {
	  nameOfYourLastEmployerPage = new NameOfYourLastEmployerPage(driver);
    assertThat(nameOfYourLastEmployerPage.getHeading()).matches("What was the name of your last NHS employer?");
  }
}
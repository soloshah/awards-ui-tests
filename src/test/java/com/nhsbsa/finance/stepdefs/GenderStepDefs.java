package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.GenderPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Then;

public class GenderStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
  private GenderPage  genderPage;

  @Then("^the gender page will be displayed$")
  public void theGenderPageWillBeDisplayed() {
	  genderPage = new GenderPage(driver);
    assertThat(genderPage.getHeading()).matches("What is your gender?");
  }
}
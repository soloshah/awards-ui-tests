package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.CheckYourAnswerPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Then;

public class CheckYourAnswersStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");

  private CheckYourAnswerPage  checkYourAnswerPage;

  @Then("^Check your answers page is displayed$")
  public void checkYourAnswersPageWillBeDisplayed() {
	  checkYourAnswerPage = new CheckYourAnswerPage(driver);
    assertThat(checkYourAnswerPage.getHeading()).matches("Check Your Answers");
  }


}
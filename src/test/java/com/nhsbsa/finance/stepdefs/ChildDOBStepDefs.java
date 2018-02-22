package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ChildDOBPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Then;

public class ChildDOBStepDefs {

  private WebDriver driver = Config.getDriver();
  private String baseUrl = PropertyReader.getProperty("base.server");
  private ChildDOBPage  childDOBPage;
  
  
  @Then("^the child date of birth page will be displayed$")
  public void theChildDateOfBirthPageWillBeDisplayed() {
	  childDOBPage = new ChildDOBPage(driver);
    assertThat(childDOBPage.getHeading()).matches("What is your child's date of birth?");
  }

}
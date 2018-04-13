package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.PensionOver30Page;

import cucumber.api.java.en.Then;

public class PensionOver30StepDefs {

  private WebDriver driver = Config.getDriver();
 // private String baseUrl = PropertyReader.getProperty("base.server");
   private PensionOver30Page  pensionOver30Page;

  @Then("^the pension over 30k page will be displayed$")
  public void thePensionOver30kPageWillBeDisplayed() {
	  pensionOver30Page = new PensionOver30Page(driver);
	  assertThat(pensionOver30Page.getHeading()).contains("Will your NHS pension plus any other pension benefits be more than £30,000 per year, or have you accessed your benefits with another pension scheme using pension flexibilities?");
  }
}
package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Interstitial2008Page;
import cucumber.api.java.en.Then;

public class Interstitial2008StepDefs {

  private WebDriver driver = Config.getDriver();

   private Interstitial2008Page  interstitial2008Page;

  @Then("^the 2008 interstitial page will be displayed$")
  public void the2008InterstitialPageWillBeDisplayed() {
	  interstitial2008Page = new Interstitial2008Page(driver);
	  assertThat(interstitial2008Page.getHeading()).contains("The next questions will be in relation to 2008 Section");
	  interstitial2008Page.nextStep();
  }

}
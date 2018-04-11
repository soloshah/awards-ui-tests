package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Interstitial2015Page;

import cucumber.api.java.en.Then;

public class Interstitial2015StepDefs {

  private WebDriver driver = Config.getDriver();

   private Interstitial2015Page  interstitial2015Page;

  @Then("^the 2015 interstitial page will be displayed$")
  public void the2015InterstitialPageWillBeDisplayed() {
	  interstitial2015Page = new Interstitial2015Page(driver);
	  assertThat(interstitial2015Page.getHeading()).contains("The next questions will be in relation to 2015 Section");
	  interstitial2015Page.nextStep();
  }

}
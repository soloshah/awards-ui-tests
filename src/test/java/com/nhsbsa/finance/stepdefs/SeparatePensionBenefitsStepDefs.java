package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.SeparatePensionBenefitsPage;

import cucumber.api.java.en.Then;

public class SeparatePensionBenefitsStepDefs {

  private WebDriver driver = Config.getDriver();

   private SeparatePensionBenefitsPage  separatePensionBenefitsPage;

	@Then("^the separate pension benefits page will be displayed$")
  public void theSeparatePensionBenefitsPageWillBeDisplayed() {
		separatePensionBenefitsPage = new SeparatePensionBenefitsPage(driver);
		assertThat(separatePensionBenefitsPage.getHeading()).contains("Do you have any separate pension benefits?");
  }
}
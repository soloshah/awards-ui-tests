package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.SubmitClaimLaterPage;

import cucumber.api.java.en.Then;

public class SubmitClaimLaterStepDefs {

  private WebDriver driver = Config.getDriver();
   private SubmitClaimLaterPage  submitClaimLaterPage;

	@Then("^the submit claim later page will be displayed$")
	public void theSubmitClaimLaterPageWillBeDisplayed(){
		submitClaimLaterPage = new SubmitClaimLaterPage(driver);
		assertThat(submitClaimLaterPage.getHeading()).contains("Submit your claim later");
		
	}
}
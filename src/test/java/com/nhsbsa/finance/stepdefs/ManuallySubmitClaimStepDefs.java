package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ManuallySubmitClaimPage;

import cucumber.api.java.en.Then;

public class ManuallySubmitClaimStepDefs {

  private WebDriver driver = Config.getDriver();
   private ManuallySubmitClaimPage  manuallySubmitClaimPage;

	@Then("^the manually submit claim page will be displayed$")
	public void theManuallySubmitClaimPageWillBeDisplayed(){
		manuallySubmitClaimPage = new ManuallySubmitClaimPage(driver);
		assertThat(manuallySubmitClaimPage.getHeading()).contains("You need to submit your claim manually");
		
	}
}
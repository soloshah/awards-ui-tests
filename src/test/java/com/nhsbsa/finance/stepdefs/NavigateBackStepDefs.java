package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NavigateBackPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigateBackStepDefs {

  private WebDriver driver = Config.getDriver();
  private NavigateBackPage  navigateBackPage;

  @Then("^the back button will be displayed$")
  public void theBackButtonWillBeDisplayed() {
	  navigateBackPage = new NavigateBackPage(driver);
		assertThat(navigateBackPage.isBackLinkVisible()).isTrue();
  }
  
  @When("^I click on back button$")
  public void iClickonBackButton() {
	  navigateBackPage = new NavigateBackPage(driver);
  navigateBackPage.backLink();
  }
 
  
	@Then("^the back button will not be displayed$")
	public void theBackButtonWillNotBeDisplayed() throws Exception {
		navigateBackPage = new NavigateBackPage(driver);
		navigateBackPage.assertLinkNotPresent();
		//assertThat(navigateBackPage.isBackLinkVisible()).isTrue();
	}


  
}
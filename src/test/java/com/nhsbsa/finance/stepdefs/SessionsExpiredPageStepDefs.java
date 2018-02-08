package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.SessionsExpiredPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class SessionsExpiredPageStepDefs {

  SessionsExpiredPage sessionsExpiredPage;
  private WebDriver driver = Config.getDriver();

  @Given("^my session is expired$")
  public void mySessionIsExpired() {
    iExpireMySession();
  }

  @When("^I expire my session$")
  public void iExpireMySession() {
    Page page = new Page(driver);
    page.deleteCookies();
  }

  @Then("^the session expired page will be displayed$")
  public void theSessionExpiredPageWillBeDisplayed() {
    iAmOnTheSessionExpiredPage();
  }
  
  @When("^I start again from the session expired page$")
  public void iStartAgainFromTheSessionExpiredPage() {
    sessionsExpiredPage = new SessionsExpiredPage(driver);
    sessionsExpiredPage.startAgain();
  }


  @Given("^I am on the session expired page$")
  public void iAmOnTheSessionExpiredPage() {
    sessionsExpiredPage = new SessionsExpiredPage(driver);
    assertThat(sessionsExpiredPage.getHeading()).matches("Sorry, you'll have to start again");
  }
}

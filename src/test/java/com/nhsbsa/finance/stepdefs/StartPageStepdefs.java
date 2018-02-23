package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.StartPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StartPageStepdefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private StartPage startPage;

	@Then("^the start page will be displayed$")
	public void theStartPageWillBeDisplayed() {
		startPage = new StartPage(driver);
		assertThat(startPage.getStartPageHeading()).matches("Claim your NHS Pension");
	}

	@Given("^I am on the start page$")
	public void iAmOnTheStartPage() {
		new Page(driver).navigateToUrl(baseUrl);
		startPage = new StartPage(driver);
		startPage.clickStart();
	}

	@Given("^I go to the start page$")
	public void iGoToTheStartPage() {
	new Page(driver).navigateToUrl(baseUrl);
	startPage = new StartPage(driver);
	assertThat(startPage.getStartPageHeading()).contains("Claim your NHS Pension");
	}

	@Then("^the estimate link will be displayed$")
	public void theEstimateLinkWillBeDisplayed() {
		startPage = new StartPage(driver);
		assertThat(startPage.doesEstimateLinkHaveAnchor()).isTrue();
	}
}

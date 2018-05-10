package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.LumpSumChoicePage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LumpSumChoiceStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private LumpSumChoicePage lumpSumChoicePage;

	@Given("^I go to 2015 lump sum choice page$")
	public void iGoTo2015LumpSumChoicePage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/2015-lump-sum-choice");
		lumpSumChoicePage = new LumpSumChoicePage(driver);
		assertThat(lumpSumChoicePage.getHeading()).contains("Do you want to give up part of your 2015 Scheme pension to receive a lump sum?");
	}

	
	@Then("^the 2015 lumpsum choice page will be displayed$")
	public void the2015LumpsumChoicePageWillBeDisplayed() {
		Page page = new Page(driver);
		String lumpsum2015PageTitle = "Do you want to give up part of your 2015 Scheme pension to receive a lump sum? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(lumpsum2015PageTitle);
		lumpSumChoicePage = new LumpSumChoicePage(driver);
		assertThat(lumpSumChoicePage.getHeading()).contains("Do you want to give up part of your 2015 Scheme pension to receive a lump sum?");
	}
	
	@Given("^I go to 2008 lump sum choice page$")
	public void iGoTo2008LumpSumChoicePage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/2008-lump-sum-choice");
		lumpSumChoicePage = new LumpSumChoicePage(driver);
		assertThat(lumpSumChoicePage.getHeading()).contains("Do you want to give up part of your 2008 Section pension to receive a lump sum?");
	}

		
	@Then("^the 2008 lumpsum choice page will be displayed$")
	public void the2008LumpsumChoicePageWillBeDisplayed() {
		Page page = new Page(driver);
		String lumpsum2008PageTitle = "Do you want to give up part of your 2008 Section pension to receive a lump sum? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(lumpsum2008PageTitle);
		lumpSumChoicePage = new LumpSumChoicePage(driver);
		assertThat(lumpSumChoicePage.getHeading()).contains("Do you want to give up part of your 2008 Section pension to receive a lump sum?");
	}
	
	@Given("^I go to 1995 lump sum choice page$")
	public void iGoTo1995LumpSumChoicePage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/1995-lump-sum-choice");
		lumpSumChoicePage = new LumpSumChoicePage(driver);
		assertThat(lumpSumChoicePage.getHeading()).contains(
				"You are already entitled to a lump sum. Do you want to increase your lump sum by giving up part of your 1995 pension?");
	}

	
	@Then("^the 1995 lumpsum choice page will be displayed$")
	public void the1995LumpsumChoicePageWillBeDisplayed() {
		Page page = new Page(driver);
		String lumpsum1995PageTitle = "You are already entitled to a lump sum. Do you want to increase your lump sum by giving up part of your 1995 pension? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(lumpsum1995PageTitle);
		lumpSumChoicePage = new LumpSumChoicePage(driver);
		assertThat(lumpSumChoicePage.getHeading()).contains("You are already entitled to a lump sum. Do you want to increase your lump sum by giving up part of your 1995 pension?");
	}

}
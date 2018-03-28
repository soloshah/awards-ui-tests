package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.LumpSumChoice_2015Page;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LumpSumChoice_2015StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private LumpSumChoice_2015Page lumpSumChoice_2015Page;

	@Given("^I go to 2015 lump sum choice page$")
	public void iGoTo2015LumpSumChoicePage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/2015-lump-sum-choice");
		lumpSumChoice_2015Page = new LumpSumChoice_2015Page(driver);
		assertThat(lumpSumChoice_2015Page.getHeading()).contains("Do you want to give up part of your 2015 Section pension to receive a lump sum?");
	}

	@Then("^the default value for 2015 lump sum choice will be blank$")
	public void theDefaultValueFor2015LumpSumChoiceWillBeBlank() {
		assertThat(lumpSumChoice_2015Page.isLumpSum2015RadioButtonSelected()).isFalse();
	}
	
	@Then("^the 2015 lumpsum choice page will be displayed$")
	public void the2015LumpsumChoicePageWillBeDisplayed() {
		lumpSumChoice_2015Page = new LumpSumChoice_2015Page(driver);
		assertThat(lumpSumChoice_2015Page.getHeading()).contains("Do you want to give up part of your 2015 Section pension to receive a lump sum?");
	}

}
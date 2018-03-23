package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.LumpSumChoice_2008Page;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LumpSumChoice_2008StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private LumpSumChoice_2008Page lumpSumChoice_2008Page;

	@Given("^I go to 2008 lump sum choice page$")
	public void iGoTo2008LumpSumChoicePage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/2008-lump-sum-choice");
		lumpSumChoice_2008Page = new LumpSumChoice_2008Page(driver);
		assertThat(lumpSumChoice_2008Page.getHeading()).contains("Do you want to give up part of your 2008 Section pension to receive a lump sum?");
	}

	@Then("^the default value for 2008 lump sum choice will be blank$")
	public void theDefaultValueFor2008LumpSumChoiceWillBeBlank() {
		assertThat(lumpSumChoice_2008Page.isLumpSum2008RadioButtonSelected()).isFalse();
	}

}
package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.LumpSumChoice_1995Page;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LumpSumChoice_1995StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private LumpSumChoice_1995Page lumpSumChoice_1995Page;

	@Given("^I go to 1995 lump sum choice page$")
	public void iGoTo1995LumpSumChoicePage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-scheme-details/1995-lump-sum-choice");
		lumpSumChoice_1995Page = new LumpSumChoice_1995Page(driver);
		assertThat(lumpSumChoice_1995Page.getHeading()).contains(
				"You are already entitled to a lump sum. Do you want to increase your lump sum by giving up part of your 1995 pension?");
	}

	@Then("^the default value for 1995 lump sum choice will be blank$")
	public void theDefaultValueFor1995LumpSumChoiceWillBeBlank() {
		assertThat(lumpSumChoice_1995Page.isLumpSum1995RadioButtonSelected()).isFalse();
	}

}
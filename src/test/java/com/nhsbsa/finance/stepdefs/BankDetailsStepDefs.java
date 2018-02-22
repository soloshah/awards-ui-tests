package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.BankDetailsPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Then;

public class BankDetailsStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private BankDetailsPage bankDetailsPage;

	@Then("^enter bank details page will be displayed$")
	public void enterBankDetailsPageWillBeDisplayed() {
		bankDetailsPage = new BankDetailsPage(driver);
		assertThat(bankDetailsPage.getHeading()).contains("Enter bank details");
	}
}
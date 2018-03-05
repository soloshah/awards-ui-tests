package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DynamicDateOfBirthPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.Then;

public class DynamicDateOfBirthStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private DynamicDateOfBirthPage dynamicDateOfBirthPage;

	@Then("^the dynamic partners date of birth page will be displayed$")
	public void theDynamicPartnersDateOfBirthPageWillBeDisplayed() {
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.getExampleHint().matches("For example, 31 03 1980"));
		assertThat(dynamicDateOfBirthPage.getHeading())
				.containsIgnoringCase("What is " + SharedData.firstName + "'s " + "date of birth?");
	}

	@Then("^the dynamic value of partner first name is displayed on the partners DOB page$")
	public void theDynamicValueOfPartnerFirstNameIsDisplayedOnThePartnersDOBPage() {
		Page page = new Page(driver);
		String partnerDatePageTitle = "What is " + SharedData.firstName + "'s " + "date of birth? - Claim your NHS Pension";
		page.waitForTitleToExist(partnerDatePageTitle);
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.getHeading()).contains("What is " + SharedData.firstName + "'s " + "date of birth?");

	}

	@Then("^the dynamic child date of birth page will be displayed$")
	public void theDynamicChildDateOfBirthPageWillBeDisplayed() {
		dynamicDateOfBirthPage = new DynamicDateOfBirthPage(driver);
		assertThat(dynamicDateOfBirthPage.getExampleHint().matches("For example, 31 03 1980"));
	    assertThat(dynamicDateOfBirthPage.getHeading()).containsIgnoringCase("What is " + SharedData.firstName + "'s " + "date of birth?");
	    
	}

}

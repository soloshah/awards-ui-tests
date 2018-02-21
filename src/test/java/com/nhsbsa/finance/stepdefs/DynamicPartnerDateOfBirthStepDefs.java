package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DynamicPartnerDateOfBirthPage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.PartnerDateOfBirthPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DynamicPartnerDateOfBirthStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private DynamicPartnerDateOfBirthPage dynamicPartnerDateOfBirthPage;
	
	
	@Then("^the dynamic partners date of birth page will be displayed$")
	public void theDynamicPartnersDateOfBirthPageWillBeDisplayed() {
		dynamicPartnerDateOfBirthPage = new DynamicPartnerDateOfBirthPage(driver);
		assertThat(dynamicPartnerDateOfBirthPage.getExampleHint().matches("For example, 31 03 1980"));
		//assertThat(partnerDateOfBirthPage.getHeading()).contains("What is " + SharedData.firstName + "'s " +  "date of birth?");
	}

		
	@Then("^the dynamic value of partner first name is displayed on the partners DOB page$")
	public void theDynamicValueOfPartnerFirstNameIsDisplayedOnThePartnersDOBPage() {
   		//partnerDateOfBirthPage = new PartnerDateOfBirthPage(driver);
   		Page page = new Page(driver);
   		String partnerDatePageTitle = "What is " + SharedData.firstName + "'s " +  "date of birth? - Claim your NHS Pension";
   	page.waitForTitleToExist(partnerDatePageTitle);
		//assertThat(partnerDateOfBirthPage.getHeading().contains("What is " + SharedData.firstName + "'s " +  "date of birth?"));
   	
	}
}

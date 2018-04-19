package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DynamicPartnerGenderPage;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.Then;

public class DynamicPartnerGenderStepDefs {

	private WebDriver driver = Config.getDriver();
	private DynamicPartnerGenderPage dynamicPartnerGenderPage;

	
	@Then("^the dynamic partner gender page will be displayed$")
	public void theDynamicPartnerGenderPageWillBeDisplayed() {
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		assertThat(dynamicPartnerGenderPage.getHeading()).contains("What is" + SharedData.firstName + "'s " + "legally recognised gender?");
	}

		
}

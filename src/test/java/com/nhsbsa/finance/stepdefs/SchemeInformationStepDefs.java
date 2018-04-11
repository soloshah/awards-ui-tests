package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.SchemeInformationPage;


import cucumber.api.java.en.Then;

public class SchemeInformationStepDefs {

  private WebDriver driver = Config.getDriver();
   private SchemeInformationPage  schemeInformationPage;

	@Then("^the new scheme information page will be displayed$")
	public void theNewSchemeInformationPageWillBeDisplayed(){
		schemeInformationPage = new SchemeInformationPage(driver);
		assertThat(schemeInformationPage.getSchemeInformationPageText()).matches("Pension identification tool");
		
	}
}
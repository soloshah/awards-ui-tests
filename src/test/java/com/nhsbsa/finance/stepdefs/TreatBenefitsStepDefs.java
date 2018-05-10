package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.TreatBenefitsPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TreatBenefitsStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private TreatBenefitsPage treatBenefitsPage;


	@Given("^I go to treat benefits page$")
	public void iGoToTreatBenefitsPage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-arrangement-details/do-you-want-to-treat-benefits-in-excess-of-lta");
		treatBenefitsPage = new TreatBenefitsPage(driver);
		assertThat(treatBenefitsPage.getHeading()).contains("We’ll only be able to process your application if we treat your NHS Pension Scheme benefits in excess of the Lifetime Allowance");
	}
	
	
	@Then("^the treat benefits page will be displayed$")
	public void theTreatBenefitsPageWillbeDisplayed() {
		treatBenefitsPage = new TreatBenefitsPage(driver);	
		assertThat(treatBenefitsPage.getHeading()).contains("We’ll only be able to process your application if we treat your NHS Pension Scheme benefits in excess of the Lifetime Allowance");

		}
	
	@When("^I click next on treat excess benefit page$")
	public void iClickNextOnTreatExcessBenefitPage() {
		treatBenefitsPage = new TreatBenefitsPage(driver);	
		treatBenefitsPage.nextStep();
	}

}
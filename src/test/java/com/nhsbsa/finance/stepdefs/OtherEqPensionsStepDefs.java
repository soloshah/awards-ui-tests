package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.OtherEqPensionsPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class OtherEqPensionsStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private OtherEqPensionsPage otherEqPensionsPage;

	@Given("^I am on other eq pension page$")
	public void iAmOnOtherEqPensionsPage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/other-eq-pensions");
	}

	@Given("^I go to other eq pension page$")
	public void iGoToOtherEqPensionsPage() {
		new Page(driver).navigateToUrl(baseUrl + "/payment-details/other-eq-pensions");
		otherEqPensionsPage = new OtherEqPensionsPage(driver);
		assertThat(otherEqPensionsPage.getHeading())
		.contains("Do you have any other pensions paid by Equiniti Paymaster?");
	}
	
	
	@Then("^the otherEqPensions page will be displayed$")
	public void theOtherEqpensionsPageWillbeDisplayed() {
		otherEqPensionsPage = new OtherEqPensionsPage(driver);	
		assertThat(otherEqPensionsPage.getHeading()).contains("Do you have any other pensions paid by Equiniti Paymaster?");

		}

	@Then("^the default value for other pensions paid by Equiniti Paymaster will be blank$")
	public void theDefaultValueForOtherPensionsPaidByEquinityPaymasterWillBeBlank() {
		assertThat(otherEqPensionsPage.isOtherEqPensionsRadioButtonSelected()).isFalse();
	}

}
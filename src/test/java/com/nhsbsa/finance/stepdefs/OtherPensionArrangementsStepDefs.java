package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.OtherPensionArrangementsPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.SharedYesNoPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class OtherPensionArrangementsStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private OtherPensionArrangementsPage otherPensionArrangementsPage;

	SharedYesNoPage sharedYesNoPage;

	@Given("^I am on other pension arrangements page$")
	public void iAmOnOtherPensionArrangementsPage() {
		new Page(driver)
				.navigateToUrl(baseUrl + "/pension-arrangement-details/do-you-have-any-other-pension-arrangements");
	}

	@Given("^I go to other pension arrangements page$")
	public void iGoToOtherPensionArrangementsPage() {
		new Page(driver)
				.navigateToUrl(baseUrl + "/pension-arrangement-details/do-you-have-any-other-pension-arrangements");
		otherPensionArrangementsPage = new OtherPensionArrangementsPage(driver);
		assertThat(otherPensionArrangementsPage.getHeading()).contains("Do you have any other pension arrangements?");
	}

	@Then("^do you have any other pension arrangements page will be displayed$")
	public void doYouHaveAnyOtherPensionArrangementsPageWillBeDisplayed() {
		otherPensionArrangementsPage = new OtherPensionArrangementsPage(driver);
		assertThat(otherPensionArrangementsPage.getHeading()).contains("Do you have any other pension arrangements?");
	}

	@Then("^the default value for other pension arrangements page will be blank$")
	public void theDefaultValueForOtherPensionArrangementsWillBeBlank() {
		assertThat(otherPensionArrangementsPage.isAnyRadioButtonSelected()).isFalse();
	}

}
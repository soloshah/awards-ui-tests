package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.PensionOver30Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PensionOver30StepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private PensionOver30Page pensionOver30Page;

	@Then("^the pension over 30k page will be displayed$")
	public void thePensionOver30kPageWillBeDisplayed() {
		pensionOver30Page = new PensionOver30Page(driver);
		assertThat(pensionOver30Page.getHeading()).contains("Do any of these apply?");
	}

	@Given("^I go to pension over 30k page$")
	public void iGoToPensionOver30kPage() {
		new Page(driver).navigateToUrl(baseUrl + "/pension-arrangement-details/will-your-pension-be-over-30k");
		pensionOver30Page = new PensionOver30Page(driver);
		assertThat(pensionOver30Page.getHeading()).contains("Do any of these apply?");
	}

	@Then("^the default value for pension over 30k will be blank$")
	public void theDefaultValueForPensionOver30kWillBeBlank() {
		assertThat(pensionOver30Page.isPensionOver30kRadioButtonSelected()).isFalse();
	}

	@When("^I select Yes on pension over 30k page$")
	public void iSelectYesOnPensionOver30kPage() {
		SharedData.shared1995RadioButton = "Yes";
		pensionOver30Page = new PensionOver30Page(driver);
		pensionOver30Page.selectYes();
	}

	@When("^I select No on pension over 30k page$")
	public void iSelectNoOnPensionOver30kPage() {
		SharedData.shared1995RadioButton = "No";
		pensionOver30Page = new PensionOver30Page(driver);
		pensionOver30Page.selectNo();
	}

	@When("^I select notSure on pension over 30k page$")
	public void iSelectNotSureOnPensionOver30kPage() {
		SharedData.shared1995RadioButton = "Not sure";
		pensionOver30Page = new PensionOver30Page(driver);
		pensionOver30Page.selectNotsure();
	}

	@When("^I dont select anything on pension over 30k page$")
	public void iDontSelectAnythingOnPensionOver30kPage() {
		pensionOver30Page = new PensionOver30Page(driver);
		pensionOver30Page.pensionOver30kIsNotSelected();
	}

	@And("^pension over 30k error message '(.*)' will be displayed$")
	public void pensionOver30kErrorMessageWillBeDisplayed(String errorMessage) {
		pensionOver30Page = new PensionOver30Page(driver);
		assertThat(pensionOver30Page.doesPensionOver30kErrorMessageHaveAnchor()).isTrue();
		assertThat(pensionOver30Page.getPensionOver30kAnchoredErrorMessage()).matches(errorMessage);
		assertThat(pensionOver30Page.getPensionOver30kFieldErrorMessage()).matches(errorMessage);
	}
	
	
	@Then("^the pensionOver30k details are sustained$")
	public void thePensionOver30KDetailsAreSustained() {
		pensionOver30Page = new PensionOver30Page(driver);
		assertThat(pensionOver30Page.getYesRadioButton()).matches(SharedData.shared1995RadioButton);

	}

	@When("^I select different pensionOver30K using different valid option$")
	public void iSelectPensionOver30kUsingDifferentValidOption() {
		iSelectNotSureOnPensionOver30kPage();
	}

}
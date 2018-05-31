package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.DynamicPartnerGenderPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DynamicPartnerGenderStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private DynamicPartnerGenderPage dynamicPartnerGenderPage;

	
	@Then("^the partner gender page will be displayed$")
	public void thePartnerGenderPageWillBeDisplayed() {
		
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		assertThat(dynamicPartnerGenderPage.getHeading()).contains("What is " + SharedData.firstName + "'s " + "legally recognised gender?");
		
	}
	
	@Given("^I go to partner gender page$")
	public void iGoToPartnerGenderPage() {
		new Page(driver).navigateToUrl(baseUrl + "/dependant-details/what-is-your-partner-gender");
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		assertThat(dynamicPartnerGenderPage.getHeading())
				.contains("What is " + SharedData.firstName + "'s " + "legally recognised gender?");
	}
	
	@And("^what is your partner gender page error message '(.*)' will be displayed$")
	public void whatIsYourPartnerGenderPageErrorMessageWillBeDisplayed(String errorMessage) {
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		assertThat(dynamicPartnerGenderPage.getPartnerGenderFieldErrorMessage()).matches(errorMessage);
		assertThat(dynamicPartnerGenderPage.doesPartnerGenderErrorMessageHaveAnchor()).isTrue();
		assertThat(dynamicPartnerGenderPage.getPartnerGenderAnchoredErrorMessage()).matches(errorMessage);

	}

	@When("^I dont select anything on partner gender page$")
	public void iDontSelectAnythingOnPartnerGenderPage() {
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		dynamicPartnerGenderPage.partnerGenderIsNotSelected();
	}

	@When("^I click on the link how legal gender is identified$")
	public void iClickOnTheLinkHowLegalGenderIsIdentified() {
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		dynamicPartnerGenderPage.verifyGenderLink();
	}

	@Then("^the guidance for gender link will be displayed$")
	public void theGuidanceForGenderLinkWillBeDisplayed() {
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		assertThat((dynamicPartnerGenderPage.verifyGenderLinkText())
				.contains("more guidance on legally recognised gender available"));
	}

	
	@When("^I select Female$")
	public void iSelectFemale() {
		SharedData.gender = "Female";
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		dynamicPartnerGenderPage.selectFemale();
	}

	@When("^I select Male$")
	public void iSelectMale() {
		SharedData.gender = "Male";
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		dynamicPartnerGenderPage.selectMale();
	}

	@When("^I click next on partner gender page$")
	public void iClickNextOnPartnerGenderPage() {
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		dynamicPartnerGenderPage.nextStep();
	}
	
	@Then("^the partnerGender details are sustained$")
	public void theGenderDetailsAreSustained() {
		dynamicPartnerGenderPage = new DynamicPartnerGenderPage(driver);
		assertThat(dynamicPartnerGenderPage.getGenderFemale()).matches(SharedData.gender);
	}
	

	@When("^I select gender using different valid option$")
	public void iSelectGenderUsingDifferentValidOption() {
		iSelectMale();
	}
		
}

package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.PartnerGenderPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PartnerGenderStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private PartnerGenderPage partnerGenderPage;

	@Given("^I am on partner gender page$")
	public void iAmOnPartnerGenderPage() {
		new Page(driver).navigateToUrl(baseUrl + "/partner-and-child/what-is-your-partner-gender");
	}

	@Given("^I go to partner gender page$")
	public void iGoToPartnerGenderPage() {
		new Page(driver).navigateToUrl(baseUrl + "/partner-and-child/what-is-your-partner-gender");
		partnerGenderPage = new PartnerGenderPage(driver);
		assertThat(partnerGenderPage.getHeading())
				.contains("What is " + SharedData.firstName + "'s " + "legally recognised gender?");
	}
	
	@Then("^the partner gender page will be displayed$")
	public void thePartnerGenderPageWillBeDisplayed() {
		partnerGenderPage = new PartnerGenderPage(driver);
		assertThat(partnerGenderPage.getHeading()).contains("What is null's legally recognised gender?");
	}

	@Then("^the dynamic value of partner first name is displayed on the partners gender page$")
	public void theDynamicValueOfPartnerFirstNameIsDisplayedOnThePartnersGenderPage() {
		
		partnerGenderPage = new PartnerGenderPage(driver);
		assertThat(partnerGenderPage.getHeading())
				.contains("What is " + SharedData.firstName + "'s " + "legally recognised gender?");

	}

	@Then("^the default value for partner gender page will be blank$")
	public void theDefaultValueForPartnerGenderPageWillBeBlank() {
		assertThat(partnerGenderPage.isPartnerGenderRadioButtonSelected()).isFalse();
	}

	@And("^what is your partner gender page error message '(.*)' will be displayed$")
	public void whatIsYourPartnerGenderPageErrorMessageWillBeDisplayed(String errorMessage) {
		partnerGenderPage = new PartnerGenderPage(driver);
		assertThat(partnerGenderPage.getPartnerGenderFieldErrorMessage()).matches(errorMessage);
		assertThat(partnerGenderPage.doesPartnerGenderErrorMessageHaveAnchor()).isTrue();
		assertThat(partnerGenderPage.getPartnerGenderAnchoredErrorMessage()).matches(errorMessage);

	}

	@When("^I select Female$")
	public void iSelectFemale() {
		partnerGenderPage = new PartnerGenderPage(driver);
		partnerGenderPage.selectFemale();
	}

	@When("^I select Male$")
	public void iSelectMale() {
		partnerGenderPage = new PartnerGenderPage(driver);
		partnerGenderPage.selectMale();
	}

	@When("^I dont select anything on partner gender page$")
	public void iDontSelectAnythingOnPartnerGenderPage() {
		partnerGenderPage = new PartnerGenderPage(driver);
		partnerGenderPage.partnerGenderIsNotSelected();
	}
	
	@When("^I click on the link how legal gender is identified$")
	public void iClickOnTheLinkHowLegalGenderIsIdentified() {
		partnerGenderPage = new PartnerGenderPage(driver);
		partnerGenderPage.verifyGenderLink();
	}
	
	@Then("^the guidance for gender link will be displayed$")
	public void theGuidanceForGenderLinkWillBeDisplayed() {
		partnerGenderPage = new PartnerGenderPage(driver);
		assertThat((partnerGenderPage.verifyGenderLinkText()).contains("more guidance on legally recognised gender available"));
	}
	
	
}
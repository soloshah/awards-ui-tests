package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.WouldYouLikeToBeContactedPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WouldYouLikeToBeContactedStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private WouldYouLikeToBeContactedPage wouldYouLikeToBeContactedPage;

	@Given("^I am on would you like to be contacted page$")
	public void iAmOnWouldYouLikeToBeContactedPage() {
		new Page(driver).navigateToUrl(baseUrl + "/contact-details/would-you-like-to-be-contacted");
	}

	@Given("^I go to would you like to be contacted page$")
	public void iGoToWouldYouLikeToBeContactedPage() {
		new Page(driver).navigateToUrl(baseUrl + "/contact-details/would-you-like-to-be-contacted");
		wouldYouLikeToBeContactedPage = new WouldYouLikeToBeContactedPage(driver);
		assertThat(wouldYouLikeToBeContactedPage.getHeading())
				.contains("How would you like to be contacted about your pension?");
	}
	
	@Then("^Would you like to be contacted page will be displayed$")
	public void wouldYouLikeToBeContactedPageWillBeDisplayed() {
		wouldYouLikeToBeContactedPage = new WouldYouLikeToBeContactedPage(driver);
		assertThat(wouldYouLikeToBeContactedPage.getHeading()).contains("How would you like to be contacted about your pension?");
	}
	
	@Then("^the contact details are sustained$")
	public void theContactDetailsAreSustained() {
		wouldYouLikeToBeContactedPage = new WouldYouLikeToBeContactedPage(driver);
		assertThat(wouldYouLikeToBeContactedPage.isEmailCheckboxSelected()).isTrue();
		assertThat(wouldYouLikeToBeContactedPage.isPhoneCheckboxSelected()).isTrue();

	}

	@When("^I select contact details using different valid option$")
	public void iSelectContactDetailsUsingDifferentValidOption() {
		iSelectWouldNotLikeToBeContacted();
	}
	
	@When("^I click next on would you like to be contacted page$")
	public void iClickNextOnWouldYouLikeToBeContactedPage() {
		wouldYouLikeToBeContactedPage = new WouldYouLikeToBeContactedPage(driver);
		wouldYouLikeToBeContactedPage.nextStep();
	}

	@Then("^the default value for would you like to be contacted will be blank$")
	public void theDefaultValueForWouldYouLikeToBeContactedWillBeBlank() {
		assertThat(wouldYouLikeToBeContactedPage.isWouldYouLikeToBeContactedCheckboxSelected()).isFalse();
	}

	@And("^how would you like to be contacted page error message '(.*)' will be displayed$")
	public void howWouldYouLikeToBeContactedPageErrorMessageWillBeDisplayed(String errorMessage) {
		wouldYouLikeToBeContactedPage = new WouldYouLikeToBeContactedPage(driver);
		assertThat(wouldYouLikeToBeContactedPage.getContactFieldErrorMessage()).matches(errorMessage);
		assertThat(wouldYouLikeToBeContactedPage.doesContactErrorMessageHaveAnchor()).isTrue();
		assertThat(wouldYouLikeToBeContactedPage.getContactAnchoredErrorMessage()).matches(errorMessage);

	}

	@When("^I select by phone$")
	public void iSelectByPhone() {
		SharedData.sharedCheckBox = "By phone";
		wouldYouLikeToBeContactedPage = new WouldYouLikeToBeContactedPage(driver);
		wouldYouLikeToBeContactedPage.selectByPhoneCheckbox();
	}

	@When("^I select by email$")
	public void iSelectByEmail() {
		SharedData.sharedCheckBox = "By email";
		wouldYouLikeToBeContactedPage = new WouldYouLikeToBeContactedPage(driver);
		wouldYouLikeToBeContactedPage.selectByEmailCheckbox();
	}

	@When("^I select would not like to be contacted$")
	public void iSelectWouldNotLikeToBeContacted() {
		SharedData.sharedCheckBox = "I would not like to be contacted";
		wouldYouLikeToBeContactedPage = new WouldYouLikeToBeContactedPage(driver);
		wouldYouLikeToBeContactedPage.selectNotToBeContactedCheckbox();
	}

	@When("^I select by phone and email$")
	public void iSelectByPhoneAndEmail() {
		wouldYouLikeToBeContactedPage = new WouldYouLikeToBeContactedPage(driver);
		wouldYouLikeToBeContactedPage.selectByPhoneAndEmailCheckbox();
	}

	@When("^I dont pick anything$")
	public void iDontPickAnything() {
		wouldYouLikeToBeContactedPage = new WouldYouLikeToBeContactedPage(driver);
		wouldYouLikeToBeContactedPage.wouldYouLikeToBeContactedIsNotSelected();
	}
}
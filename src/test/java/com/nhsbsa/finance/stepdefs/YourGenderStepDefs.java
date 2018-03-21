package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.YourGenderPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YourGenderStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private YourGenderPage yourGenderPage;

	@Then("^your gender page will be displayed$")
	public void theGenderPageWillBeDisplayed() {
		yourGenderPage = new YourGenderPage(driver);
		assertThat(yourGenderPage.getHeading()).contains("What is your legally recognised gender?");
	}

	@Given("^I am on your gender page$")
	public void iAmOnYourGenderPage() {
		new Page(driver).navigateToUrl(baseUrl + "/personal-details/what-is-your-gender");
	}

	@When("^I click next on your gender page$")
	public void iClickNextOnYourGenderPage() {
		yourGenderPage = new YourGenderPage(driver);
		yourGenderPage.nextStep();
	}

	@Given("^I go to your gender page$")
	public void iGoToYourGenderPage() {
		new Page(driver).navigateToUrl(baseUrl + "/personal-details/what-is-your-gender");
		yourGenderPage = new YourGenderPage(driver);
		assertThat(yourGenderPage.getHeading()).contains("What is your legally recognised gender?");
	}

	@Then("^the gender details are sustained$")
	public void theGenderDetailsAreSustained() {
		yourGenderPage = new YourGenderPage(driver);
		assertThat(yourGenderPage.getGenderFemale()).matches(SharedData.gender);

	}

	@When("^I select gender details using different valid option$")
	public void iSelectGenderDetailsUsingDifferentValidOption() {
			iSelectMaleOnYourGenderPage();
	}

	@Then("^the default value for your gender page will be blank$")
	public void theDefaultValueForYourGenderPageWillBeBlank() {
		assertThat(yourGenderPage.isGenderRadioButtonSelected()).isFalse();
	}

	@And("^what is your gender page error message '(.*)' will be displayed$")
	public void whatIsYourGenderPageErrorMessageWillBeDisplayed(String errorMessage) {
		yourGenderPage = new YourGenderPage(driver);
		assertThat(yourGenderPage.getGenderFieldErrorMessage()).matches(errorMessage);
		assertThat(yourGenderPage.doesGenderErrorMessageHaveAnchor()).isTrue();
		assertThat(yourGenderPage.getGenderAnchoredErrorMessage()).matches(errorMessage);

	}

	@When("^I select Female on your gender page$")
	public void iSelectFemaleOnYourGenderPage() {
		SharedData.gender = "Female";
		yourGenderPage = new YourGenderPage(driver);
		yourGenderPage.selectGenderFemale();
	
	}

	@When("^I select Male on your gender page$")
	public void iSelectMaleOnYourGenderPage() {
		SharedData.gender = "Male";
		yourGenderPage = new YourGenderPage(driver);
		yourGenderPage.selectGenderMale();
		
	}

	@When("^I dont select anything on your gender page$")
	public void iDontSelectAnythingOnYourGenderPage() {
		yourGenderPage.genderIsNotSelected();
	}

	@When("^I click on the link how legal gender is identified on your gender page$")
	public void iClickOnTheLinkHowLegalGenderIsIdentifiedOnYourGenderPage() {
		yourGenderPage = new YourGenderPage(driver);
		yourGenderPage.verifyGenderLink();
	}

	@Then("^the guidance for gender link will be displayed on your gender page$")
	public void theGuidanceForGenderLinkWillBeDisplayedOnYourGenderPage() {
		yourGenderPage = new YourGenderPage(driver);
		assertThat((yourGenderPage.verifyGenderLinkText())
				.contains("more guidance on legally recognised gender available"));
	}
	

}
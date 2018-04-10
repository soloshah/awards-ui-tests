package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.PersonalDetails_CheckYourAnswerPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PersonalDetails_CheckYourAnswersStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private PersonalDetails_CheckYourAnswerPage personalDetails_CheckYourAnswerPage;
	private StartPageStepdefs startSteps;
	private NameStepDefs nameSteps;
	private DateOfBirthStepDefs dobSteps;
	private YourGenderStepDefs genderSteps;
	private YourAddressStepDefs addressSteps;
	private NinoStepdefs ninoSteps;

	@Given("^I have filled in a personal details$")
	public void iHaveFilledInAPersonalDetails() throws Throwable {
		startSteps = new StartPageStepdefs();
		startSteps.iAmOnTheStartPage();
		nameSteps = new NameStepDefs();
		nameSteps.iGoToTheNamePage();
		nameSteps.IenterValidNameDetails();
		dobSteps = new DateOfBirthStepDefs();
		dobSteps.theDateOfBirthPageWillBeDisplayed();
		dobSteps.IenterValidDOBDetails();
		genderSteps = new YourGenderStepDefs();
		genderSteps.theGenderPageWillBeDisplayed();
		genderSteps.iSelectFemaleOnYourGenderPage();
		addressSteps = new YourAddressStepDefs();
		addressSteps.yourAddressPageWillBeDisplayed();
		addressSteps.IenterValidAddressDetails();
		ninoSteps = new NinoStepdefs();
		ninoSteps.theNationalInsurancePageWillBeDisplayed();
		ninoSteps.IenterValidNationalInsuranceNumber();
	}

	@Then("^Check your answers page for personal details will be displayed$")
	public void checkYourAnswersPageForPersonalDetailsWillBeDisplayed() {
		personalDetails_CheckYourAnswerPage = new PersonalDetails_CheckYourAnswerPage(driver);
		assertThat(personalDetails_CheckYourAnswerPage.getHeading()).contains("Check your answers");
	}

	@Given("^I am on the check your answers page$")
	public void iAmOnTheCheckYourAnswersPage() {
		personalDetails_CheckYourAnswerPage = new PersonalDetails_CheckYourAnswerPage(driver);
		new Page(driver).navigateToUrl(baseUrl + "/personal-details/check-your-answers");
		assertThat(personalDetails_CheckYourAnswerPage.getHeading()).contains("Check your answers");
	}

	@Then("^the correct personal details will be displayed$")
	public void theCorrectPersonalDetailsWillBeDisplayed() {
		personalDetails_CheckYourAnswerPage = new PersonalDetails_CheckYourAnswerPage(driver);
		assertThat(personalDetails_CheckYourAnswerPage.getPresenceOfFullName()).isEqualTo(true);
		assertThat(personalDetails_CheckYourAnswerPage.getFullname())
				.matches(SharedData.title + " " + SharedData.firstName + " " + SharedData.lastName);
		assertThat(personalDetails_CheckYourAnswerPage.getPresenceOfDOB()).isEqualTo(true);
		assertThat(personalDetails_CheckYourAnswerPage.getDob())
				.matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
		assertThat(personalDetails_CheckYourAnswerPage.getPresenceOfGender()).isEqualTo(true);
		assertThat(personalDetails_CheckYourAnswerPage.getGender()).matches(SharedData.gender);
		assertThat(personalDetails_CheckYourAnswerPage.getPresenceOfAddress()).isEqualTo(true);
		assertThat(personalDetails_CheckYourAnswerPage.getAddress())
				.matches(SharedData.streetLineOne + "\n" + SharedData.streetLineTwo + "\n" + SharedData.town + "\n"
						+ SharedData.postCode + "\n" + SharedData.country);
		assertThat(personalDetails_CheckYourAnswerPage.getPresenceOfNino()).isEqualTo(true);
		assertThat(personalDetails_CheckYourAnswerPage.getNino()).matches(SharedData.nino);

	}

	@And("^the update (.*) details will be displayed$")
	public void theUpdatedDetailsWillBeDisplayed(String field) {
		personalDetails_CheckYourAnswerPage = new PersonalDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "name":
			assertThat(personalDetails_CheckYourAnswerPage.getFullname())
					.matches(SharedData.title + " " + SharedData.firstName + " " + SharedData.lastName);
			break;
		case "dob":
			assertThat(personalDetails_CheckYourAnswerPage.getDob())
					.matches(SharedData.day + " " + SharedData.month + " " + SharedData.year);
			break;
		case "gender":
			assertThat(personalDetails_CheckYourAnswerPage.getGender()).matches(SharedData.gender);
			break;
		case "address":
			assertThat(personalDetails_CheckYourAnswerPage.getAddress())
					.matches(SharedData.streetLineOne + "\n" + SharedData.streetLineTwo + "\n" + SharedData.town + "\n"
							+ SharedData.postCode + "\n" + SharedData.country);
			break;
		case "nino":
			assertThat(personalDetails_CheckYourAnswerPage.getNino()).matches(SharedData.nino);
			break;
		}
	}

	@And("^I navigate from name page to check your answers page$")
	public void InavigateFromNamePageToCheckYourAnswersPage() {
		dobSteps = new DateOfBirthStepDefs();
		dobSteps.theDateOfBirthPageWillBeDisplayed();
		dobSteps.iClickNextOnDateOfBirthPage();
		genderSteps = new YourGenderStepDefs();
		genderSteps.theGenderPageWillBeDisplayed();
		genderSteps.iClickNextOnYourGenderPage();
		addressSteps = new YourAddressStepDefs();
		addressSteps.yourAddressPageWillBeDisplayed();
		addressSteps.iClickNextOnYourAddressPage();
		ninoSteps = new NinoStepdefs();
		ninoSteps.theNationalInsurancePageWillBeDisplayed();
		ninoSteps.iClickNextOnNationalInsurancePage();

	}

	@And("^I navigate from dob page to check your answers page$")
	public void InavigateFromDOBPageToCheckYourAnswersPage() {
		genderSteps = new YourGenderStepDefs();
		genderSteps.theGenderPageWillBeDisplayed();
		genderSteps.iClickNextOnYourGenderPage();
		addressSteps = new YourAddressStepDefs();
		addressSteps.yourAddressPageWillBeDisplayed();
		addressSteps.iClickNextOnYourAddressPage();
		ninoSteps = new NinoStepdefs();
		ninoSteps.theNationalInsurancePageWillBeDisplayed();
		ninoSteps.iClickNextOnNationalInsurancePage();

	}

	@When("^I select on change for (.*) details$")
	public void iClickOnChangeForNameDetails(String field) {
		personalDetails_CheckYourAnswerPage = new PersonalDetails_CheckYourAnswerPage(driver);
		switch (field) {
		case "name":
			personalDetails_CheckYourAnswerPage.changeNameDetails();
			break;
		case "dob":
			personalDetails_CheckYourAnswerPage.changeDobDetails();
			break;
		case "gender":
			personalDetails_CheckYourAnswerPage.changeGenderDetails();
			break;
		case "address":
			personalDetails_CheckYourAnswerPage.changeAddressDetails();
			break;
		case "nino":
			personalDetails_CheckYourAnswerPage.changeNinoDetails();
			break;

		}
	}

	@And("^I navigate from gender page to check your answers page$")
	public void InavigateFromGenderPageToCheckYourAnswersPage() {
		addressSteps = new YourAddressStepDefs();
		addressSteps.yourAddressPageWillBeDisplayed();
		addressSteps.iClickNextOnYourAddressPage();
		ninoSteps = new NinoStepdefs();
		ninoSteps.theNationalInsurancePageWillBeDisplayed();
		ninoSteps.iClickNextOnNationalInsurancePage();

	}

	@And("^I navigate from address page to check your answers page$")
	public void InavigateFromAddressPageToCheckYourAnswersPage() {
		ninoSteps = new NinoStepdefs();
		ninoSteps.theNationalInsurancePageWillBeDisplayed();
		ninoSteps.iClickNextOnNationalInsurancePage();

	}

	@When("^I submit the personal details$")
	public void iSubmitThePersonalDetails() {
		personalDetails_CheckYourAnswerPage = new PersonalDetails_CheckYourAnswerPage(driver);
		personalDetails_CheckYourAnswerPage.submitPersonalDetails();
	}
}
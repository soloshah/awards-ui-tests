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

	@Given("^I go to check your answers for personal details page$")
	public void iGoToCheckYourAnswersForPersonalDetailsPage() {
		new Page(driver).navigateToUrl(baseUrl + "/personal-details/check-your-answers");
		personalDetails_CheckYourAnswerPage = new PersonalDetails_CheckYourAnswerPage(driver);
		assertThat(personalDetails_CheckYourAnswerPage.getHeading().contains("Check your answers"));
	}

	@Given("^I am on the check your answers page$")
	public void iAmOnTheCheckYourAnswersPage() {
		personalDetails_CheckYourAnswerPage = new PersonalDetails_CheckYourAnswerPage(driver);
		new Page(driver).navigateToUrl(baseUrl + "/personal-details/check-your-answers");
		assertThat(personalDetails_CheckYourAnswerPage.getHeading()).contains("Check your answers");
	}

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

}
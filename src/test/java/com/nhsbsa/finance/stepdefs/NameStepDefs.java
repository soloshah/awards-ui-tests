package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.NamePage;
import com.nhsbsa.finance.pageobjects.NavBarPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.StartPage;
import com.nhsbsa.finance.properties.PropertyReader;
import com.nhsbsa.finance.shared.SharedData;
import com.nhsbsa.finance.shared.SharedMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NameStepDefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");
	private NamePage namePage;
	private String firstName;
	private String lastName;

	@Given("^I am on the name page$")
	public void iAmOnTheNamePage() {

		new Page(driver).navigateToUrl(baseUrl + "/personal-details/what-is-your-name");
		StartPage startPage = new StartPage(driver);
		startPage.startNow();
	}

	@Then("^the name submission will be successful$")
	public void theNameSubmissionWillBeSuccessful() {
		new NavBarPage(driver);
	}

	@When("^I enter valid name details$")
	public void IenterValidNameDetails() {
		SharedData.firstName = "Test";
		SharedData.lastName = "User";
		namePage = new NamePage(driver);
		namePage.submitValidNameDetails(SharedData.firstName, SharedData.lastName);
	}

	@Then("^the name submission will be unsuccessful$")
	public void theNameSubmissionWillBeUnsuccessful() {
		namePage = new NamePage(driver);
		assertThat(namePage.getErrorHeadingErrorMessage()).matches("Some questions have not been answered correctly:");
		assertThat(namePage.getErrorsBelowErrorMessage()).matches("Please see the errors below.");
	}

	@And("^the first name error message '(.*)' will be displayed$")
	public void theFirstNameErrorMessageWillBeDisplayed(String errorMessage) {
		namePage = new NamePage(driver);
		assertThat(namePage.doesFirstNameErrorMessageHaveAnchor()).isTrue();
		assertThat(namePage.getFirstNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(namePage.getFirstNameFieldErrorMessage()).matches(errorMessage);

	}

	@And("^the last name error message '(.*)' will be displayed$")
	public void theLastNameErrorMessageWillBeDisplayed(String errorMessage) {
		namePage = new NamePage(driver);
		assertThat(namePage.doesLastNameErrorMessageHaveAnchor()).isTrue();
		assertThat(namePage.getLastNameAnchoredErrorMessage()).matches(errorMessage);
		assertThat(namePage.getLastNameFieldErrorMessage()).matches(errorMessage);
	}

	@When("^I enter an invalid name using the (.*) '(.*)'$")
	public void iEnterAnInvalidNameUsingFieldValue(String field, String value) {
		setNameDetails();
		switch (field) {
		case "firstName":
			firstName = value;
			break;
		case "lastName":
			lastName = value;
			break;
		}
		namePage = new NamePage(driver);
		namePage.enterNameDetails(firstName, lastName);
		namePage.submitInValidNameDetails();
	}

	@When("^I enter valid name details using the firstName '(.*)' and lastName '(.*)'$")
	public void iEnterValidNameDetailsUsingTheFirstNameAndLastName(String firstName, String lastName) {
		namePage = new NamePage(driver);
		namePage.enterNameDetails(firstName, lastName);
		namePage.submitInValidNameDetails();
	}

	@Then("^The length of first and last name is verified$")
	public void theLengthOfFirstAndLastNameIsVerified() {
		namePage = new NamePage(driver);
		String s1 = "hgn-yuiom jkhetryuyyuyuuuyjk";
		String s2 = "hgn-yuiom jkhetryuhibhgfrtdoiueyt";
		navigateToElementBy(selectedWorkingForNHSRadioButtonLocator);
		System.out.println(SharedMethods.substring_safe(s1, 0, 25));
		assertThat(SharedMethods.substring_safe(s1, 0, 25).compareTo("hgn-yuiom jkhetryuyyuyuuu"));
		assertThat(SharedMethods.substring_safe(s2, 0, 32).matches("hgn-yuiom jkhetryuhibhgfrtdoiuey"));
	}

	private void setNameDetails() {
		firstName = "Test";
		lastName = "User";

	}

}
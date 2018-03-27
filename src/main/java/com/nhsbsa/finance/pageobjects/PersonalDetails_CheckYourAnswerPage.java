package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetails_CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
	private By fullNameFieldLocator = By.id("personalDetails.checkYourAnswers.fullname");
	private By dobFieldLocator = By.id("personalDetails.checkYourAnswers.dob");
	private By genderFieldLocator = By.id("personalDetails.checkYourAnswers.gender");
	private By addressFieldLocator = By.id("personalDetails.checkYourAnswers.address");
	private By ninoFieldLocator = By.id("personalDetails.checkYourAnswers.ni");
	private By continueButtonLocator = By.id("continue_button");
	private By fullNameChangeLinkLocator = By.id("personalDetails.checkYourAnswers.fullname-chgit snge");
	private By dobChangeLinkLocator = By.id("personalDetails.checkYourAnswers.dob-chgit snge");
	private By genderChangeLinkLocator = By.id("personalDetails.checkYourAnswers.gender-chgit snge");
	private By addressChangeLinkLocator = By.id("personalDetails.checkYourAnswers.address-chgit snge");
	private By ninoChangeLinkLocator = By.id("personalDetails.checkYourAnswers.ni-chgit snge");
	private By fullNameTextLocator = By.id("personalDetails.checkYourAnswers.fullname-answer");
	private By dobTextLocator = By.id("personalDetails.checkYourAnswers.dob-answer");
	private By genderTextLocator = By.id("personalDetails.checkYourAnswers.gender-answer");
	private By addressTextLocator = By.id("personalDetails.checkYourAnswers.address-answer");
	private By ninoTextLocator = By.id("personalDetails.checkYourAnswers.ni-answer");

	public PersonalDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(checkYouAnswersPageTitle);
		waitForElementToBeVisibleBy(fullNameFieldLocator);
	}

	public boolean getPresenceOfFullName() {
		navigateToRootElement();
		return getPresenceOfElement(fullNameFieldLocator);
	}

	public boolean getPresenceOfDOB() {
		navigateToRootElement();
		return getPresenceOfElement(dobFieldLocator);
	}

	public boolean getPresenceOfGender() {
		navigateToRootElement();
		return getPresenceOfElement(genderFieldLocator);
	}

	public boolean getPresenceOfAddress() {
		navigateToRootElement();
		return getPresenceOfElement(addressFieldLocator);
	}

	public boolean getPresenceOfNino() {
		navigateToRootElement();
		return getPresenceOfElement(ninoFieldLocator);
	}

	public String getFullname() {
		navigateToRootElement();
		navigateToElementBy(fullNameTextLocator);
		return getElementText();
	}

	public String getDob() {
		navigateToRootElement();
		navigateToElementBy(dobTextLocator);
		return getElementText();
	}

	public String getGender() {
		navigateToRootElement();
		navigateToElementBy(genderTextLocator);
		return getElementText();
	}

	public String getAddress() {
		navigateToRootElement();
		navigateToElementBy(addressTextLocator);
		return getElementText();
	}
	
	public String getNino() {
		navigateToRootElement();
		navigateToElementBy(ninoTextLocator);
		return getElementText();
	}

	private void changeNameLink() {
		navigateToRootElement();
		navigateToElementBy(fullNameChangeLinkLocator);
		click();
	}

	public NamePage changeNameDetails() {
		changeNameLink();
		return new NamePage(driver);
	}

	private void changeDobLink() {
		navigateToRootElement();
		navigateToElementBy(dobChangeLinkLocator);
		click();
	}

	public DateOfBirthPage changeDobDetails() {
		changeDobLink();
		return new DateOfBirthPage(driver);
	}

	private void changeGenderLink() {
		navigateToRootElement();
		navigateToElementBy(genderChangeLinkLocator);
		click();
	}

	public YourGenderPage changeGenderDetails() {
		changeGenderLink();
		return new YourGenderPage(driver);
	}

	private void changeAddressLink() {
		navigateToRootElement();
		navigateToElementBy(addressChangeLinkLocator);
		click();
	}

	public YourAddressPage changeAddressDetails() {
		changeAddressLink();
		return new YourAddressPage(driver);
	}

	private void changeNinoLink() {
		navigateToRootElement();
		navigateToElementBy(ninoChangeLinkLocator);
		click();
	}

	public NinoPage changeNinoDetails() {
		changeNinoLink();
		return new NinoPage(driver);
	}

	public SummaryPage submitPersonalDetails() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
		return new SummaryPage(driver);
	}
}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetails_CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
	private By fullNameFieldLocator = By.id("name");
	private By dobFieldLocator = By.id("dob");
	private By genderFieldLocator = By.id("gender");
	private By addressFieldLocator = By.id("address");
	private By ninoFieldLocator = By.id("nino");
	private By continueButtonLocator = By.id("continue_button");
	private By fullNameChangeLinkLocator = By.id("name-change");
	private By dobChangeLinkLocator = By.id("dob-change");
	private By genderChangeLinkLocator = By.id("gender-change");
	private By addressChangeLinkLocator = By.id("address-change");
	private By ninoChangeLinkLocator = By.id("nino-change");
	private By fullNameTextLocator = By.id("name-answer");
	private By dobTextLocator = By.id("dob-answer");
	private By genderTextLocator = By.id("gender-answer");
	private By addressTextLocator = By.id("address-answer");
	private By addressLine1TextLocator = By.id("address-line-one");
	private By addressLine2TextLocator = By.id("address-line-two");
	private By addressTownTextLocator = By.id("town-or-city");
	private By addressPostcodeTextLocator = By.id("postcode");
	private By addressCountryTextLocator = By.id("country");
	private By ninoTextLocator = By.id("nino-answer");

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

	public String getAddressLineOne() {
		navigateToRootElement();
		navigateToElementBy(addressLine1TextLocator);
		return getElementText();
	}

	public String getAddressLineTwo() {
		navigateToRootElement();
		navigateToElementBy(addressLine2TextLocator);
		return getElementText();
	}

	public String getAddressTown() {
		navigateToRootElement();
		navigateToElementBy(addressTownTextLocator);
		return getElementText();
	}

	public String getAddressPostcode() {
		navigateToRootElement();
		navigateToElementBy(addressPostcodeTextLocator);
		return getElementText();
	}

	public String getAddressCountry() {
		navigateToRootElement();
		navigateToElementBy(addressCountryTextLocator);
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

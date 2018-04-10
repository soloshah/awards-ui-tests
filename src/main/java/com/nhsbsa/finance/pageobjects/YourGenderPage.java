package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourGenderPage extends Page {
	
	private String yourGenderPageTitle = "What is your legally recognised gender? - Claim your NHS Pension - NHSBSA";
	private By femaleRadioButtonLocator = By.xpath("//*[@id='gender']/div[1]/label");
	private By maleRadioButtonLocator = By.xpath("//*[@id='gender']/div[2]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By GenderAnchoredErrorMessageLocator = By.id("error-list0");
	private By GenderAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#gender']");
	private By GenderFieldErrorMessageLocator = By.id("'error-message-'+${fieldName}");
	private By genderIdentifyLinkLocator = By.className("summary");
	private By genderInformationLinkLocator = By.linkText("more guidance on legally recognised gender available");
	private By selectedFemaleRadioButtonLocator = By.xpath("//input[@checked='checked']");
	private By selectedMaleRadioButtonLocator = By.xpath("//input[@checked='checked']");

	public YourGenderPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(yourGenderPageTitle);
		waitForElementToBeVisibleBy(femaleRadioButtonLocator);
	}

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public boolean isGenderRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(femaleRadioButtonLocator) && !isElementSelected(maleRadioButtonLocator))
			selected = false;
		return selected;
	}

	public String getErrorHeadingErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(errorHeadingErrorMessageLocator);
		return getElementText();
	}

	public String getErrorsBelowErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(errorsBelowErrorMessageLocator);
		return getElementText();
	}

	public String getGenderFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(GenderFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesGenderErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(GenderAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(GenderAnchoredErrorMessageAnchorLocator);
	}

	public String getGenderAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(GenderAnchoredErrorMessageLocator);
		return getElementText();
	}

	public YourAddressPage selectGenderFemale() {
		navigateToRootElement();
		navigateToElementBy(femaleRadioButtonLocator);
		click();
		nextStep();
		return new YourAddressPage(driver);
	}

	public YourAddressPage selectGenderMale() {
		navigateToRootElement();
		navigateToElementBy(maleRadioButtonLocator);
		click();
		nextStep();
		return new YourAddressPage(driver);
	}

	public YourGenderPage genderIsNotSelected() {
		nextStep();
		return new YourGenderPage(driver);
	}

	public void verifyGenderLink() {

		try {
			navigateToRootElement();
			navigateToElementBy(genderIdentifyLinkLocator);
			Thread.sleep(1000);
			click();
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			System.out.print("Link message not success: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String verifyGenderLinkText() {

		navigateToRootElement();
		navigateToElementBy(genderInformationLinkLocator);
		return getElementText();

	}

	public String getGenderFemale() {
		navigateToRootElement();
		navigateToElementBy(selectedFemaleRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}

	public String getGenderMale() {
		navigateToRootElement();
		navigateToElementBy(selectedMaleRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}
}

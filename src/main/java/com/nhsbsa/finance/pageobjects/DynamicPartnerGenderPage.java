package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicPartnerGenderPage extends Page {

	private String partnerGenderPageTitle = "What is your spouse's or civil partner's legally recognised gender? - Claim your NHS Pension - NHSBSA";
	private By femaleRadioButtonLocator = By.id("gender0");
	private By maleRadioButtonLocator = By.id("gender1");
	private By nextButtonLocator = By.id("submit_button");
	private By backLinkLocator = By.id("back-link");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By partnerGenderAnchoredErrorMessageLocator = By.id("error-list0");
	private By partnerGenderAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#gender']");
	private By partnerGenderFieldErrorMessageLocator = By.id("'error-message-'+${fieldName}");
	private By genderIdentifyLinkLocator = By.className("summary");
	private By genderInformationLinkLocator = By.linkText("more guidance on legally recognised gender available.");
	private By selectedFemaleRadioButtonLocator = By.xpath("//input[@checked='checked']");
	private By selectedMaleRadioButtonLocator = By.xpath("//input[@checked='checked']");

	
	public DynamicPartnerGenderPage(WebDriver driver) {
		super(driver);
	waitForTitleToExist(partnerGenderPageTitle);
		waitForElementToBeVisibleBy(backLinkLocator);
	}

	
	public DynamicNinoPage selectFemale() {
		navigateToRootElement();
		navigateToElementBy(femaleRadioButtonLocator);
		click();
		nextStep();
		return new DynamicNinoPage(driver);
	}

	public DynamicNinoPage selectMale() {
		navigateToRootElement();
		navigateToElementBy(maleRadioButtonLocator);
		click();
		nextStep();
		return new DynamicNinoPage(driver);
	}
	
	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
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
	
	public DynamicPartnerGenderPage partnerGenderIsNotSelected() {
		nextStep();
		return new DynamicPartnerGenderPage(driver);
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


	public String getPartnerGenderFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(partnerGenderFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesPartnerGenderErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(partnerGenderAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(partnerGenderAnchoredErrorMessageAnchorLocator);
	}

	public String getPartnerGenderAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(partnerGenderAnchoredErrorMessageLocator);
		return getElementText();
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


}

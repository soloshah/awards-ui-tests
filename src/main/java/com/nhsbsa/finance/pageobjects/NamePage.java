package com.nhsbsa.finance.pageobjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NamePage extends Page {

	private String namePageTitle = "What is your name? - Claim your NHS Pension - NHSBSA";
	private By titleFieldLocator = By.id("title");
	private By firstNameFieldLocator = By.id("firstName");
	private By lastNameFieldLocator = By.id("lastName");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By titleFieldErrorMessageLocator = By.id("title-error-message");
	private By titleAnchoredErrorMessageLocator = By.id("error-list0");
	private By titleAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#title']");
	private By firstNameFieldErrorMessageLocator = By.id("firstName-error-message");
	private By firstNameAnchoredErrorMessageLocator = By.id("error-list1");
	private By firstNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#firstName']");
	private By lastNameFieldErrorMessageLocator = By.id("lastName-error-message");
	private By lastNameAnchoredErrorMessageLocator = By.id("error-list2");
	private By lastNameAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#lastName']");
	private By personalInformationLinkLocator = By.xpath("//*[@id='survey-title']/a");
    private By closeButtonLocator = By.id("user-survey-cancel");


	public NamePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(namePageTitle);
		waitForElementToBeVisibleBy(titleFieldLocator);
	}

	public void enterTitle(String title) {
		navigateToRootElement();
		navigateToElementBy(titleFieldLocator);
		type(title);
	}

	public void enterfirstName(String firstName) {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldLocator);
		type(firstName);
	}

	public void enterlastName(String lastName) {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldLocator);
		type(lastName);
	}

	public String getFirstNameDetails() {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldLocator);
		return getElementValue();
	}

	
	public String getLastNameDetails() {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldLocator);
		return getElementValue();
	}

	public String getTitleDetails() {
		navigateToRootElement();
		navigateToElementBy(titleFieldLocator);
		return getElementValue();
	}

	public void enterNames(String firstName, String lastName) {
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
	}

	public void enterNameDetails(String title, String firstName, String lastName) {
		enterTitle(title);
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
	}

	private void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
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

	public boolean doesTitleErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(titleAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(titleAnchoredErrorMessageAnchorLocator);
	}

	public boolean doesFirstNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(firstNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(firstNameAnchoredErrorMessageAnchorLocator);
	}

	public boolean doesLastNameErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(lastNameAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(lastNameAnchoredErrorMessageAnchorLocator);
	}

	public String getTitleAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(titleAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getFirstNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(firstNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getLastNameAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lastNameAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getTitleFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(titleFieldErrorMessageLocator);
		return getElementText();
	}

	public String getFirstNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldErrorMessageLocator);
		return getElementText();
	}

	public String getLastNameFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldErrorMessageLocator);
		return getElementText();
	}

	public String readTitleField() {
		navigateToRootElement();
		navigateToElementBy(titleFieldLocator);
		return getElementValue();
	}

	public String readFirstNameField() {
		navigateToRootElement();
		navigateToElementBy(firstNameFieldLocator);
		return getElementValue();
	}

	public String readLastNameField() {
		navigateToRootElement();
		navigateToElementBy(lastNameFieldLocator);
		return getElementValue();
	}

	public DateOfBirthPage submitValidNameDetails(String title, String firstName, String lastName) {
		enterTitle(title);
		enterfirstName(firstName);
		enterlastName(lastName);
		nextStep();
		return new DateOfBirthPage(driver);
	}

	public NamePage submitInValidNameDetails() {
		nextStep();
		return new NamePage(driver);
	}

	
	public void verifyPersonalInformationLink() {
		try {
			navigateToRootElement();
			navigateToElementBy(personalInformationLinkLocator);
			Thread.sleep(1000);
			click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.print("No such element: " + e.getMessage());
			e.printStackTrace();
		}
	

	}	
	
		public boolean isPersonalInformationLinkAvailable() {
			navigateToRootElement();
			navigateToElementBy(personalInformationLinkLocator);
			return getPresenceOfElement(personalInformationLinkLocator);
		}	

		
		public void closePersonalInformation() {
			navigateToRootElement();
			navigateToElementBy(closeButtonLocator);
			click();
		}
	
		
		
		public Boolean IsTestElementPresent(WebDriver driver)
		{
		    try
		    {
		    	navigateToRootElement();
				navigateToElementBy(personalInformationLinkLocator);
		        return true;
		    }
		    catch (NoSuchElementException e)
		    {
		    	System.out.print("No such element: " + e.getMessage());
		        return false;
		    }
		}
		
}
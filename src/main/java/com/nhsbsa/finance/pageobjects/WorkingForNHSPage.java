package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkingForNHSPage extends Page {

	private String workingForNHSTitle = "Are you working in the NHS now? - Claim your NHS Pension";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[2]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By nhsAnchoredErrorMessageLocator = By.id("error-list0");
	private By nhsAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#yesNo']");
	private By nhsFieldErrorMessageLocator = By.id("fieldName-error-message");

	public WorkingForNHSPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(workingForNHSTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}
	
	public WorkingForNHSPage workingForNHSIsNotSelected() {
		nextStep();
		return new WorkingForNHSPage(driver);
	}

	public boolean isWorkingForNHSRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

	public WhereAreYouEmployedPage submitValidYesNhsDetails() {
		navigateToRootElement();
		navigateToElementBy(yesRadioButtonLocator);
		click();
		nextStep();
		return new WhereAreYouEmployedPage(driver);
	}

	public TBIPage submitValidYesDetails() {
		navigateToRootElement();
		navigateToElementBy(yesRadioButtonLocator);
		click();
		nextStep();
		return new TBIPage(driver);
	}

	public NameOfYourLastEmployerPage submitValidNoNhsDetails() {
		navigateToRootElement();
		navigateToElementBy(noRadioButtonLocator);
		click();
		nextStep();
		return new NameOfYourLastEmployerPage(driver);
	}

	public TBIPage submitValidNoDetails() {
		navigateToRootElement();
		navigateToElementBy(noRadioButtonLocator);
		click();
		nextStep();
		return new TBIPage(driver);
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

	private void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public String getNhsFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(nhsFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesNhsErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(nhsAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(nhsAnchoredErrorMessageAnchorLocator);
	}

	public String getNhsAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(nhsAnchoredErrorMessageLocator);
		return getElementText();
	}
}

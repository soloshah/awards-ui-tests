package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtherDependantChildrenPage extends Page {

	private String otherDependantChildrenTitle = "Do you have any other dependant children? - Claim your NHS Pension";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[2]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By otherDependantChildrenAnchoredErrorMessageLocator = By.id("error-list0");
	private By otherDependantChildrenAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#yesNo']");
	private By otherDependantChildrenFieldErrorMessageLocator = By.id("fieldName-error-message");
	public By dynamicNameLocator;

	public OtherDependantChildrenPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(otherDependantChildrenTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}

	public OtherDependantChildrenPage otherDependantChildrenIsNotSelected() {
		nextStep();
		return new OtherDependantChildrenPage(driver);
	}

	public boolean isOtherDependantChildrenRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

	public ChildNamePage selectValidYesDetails() {
		navigateToRootElement();
		navigateToElementBy(yesRadioButtonLocator);
		click();
		nextStep();
		return new ChildNamePage(driver);
	}

	public OtherDependantChildrenPage selectYes() {
		navigateToRootElement();
		navigateToElementBy(yesRadioButtonLocator);
		click();
		nextStep();
		return new OtherDependantChildrenPage(driver);
	}

	public TBIPage selectValidNoDetails() {
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

	public String getOtherDependantChildrenFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(otherDependantChildrenFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesOtherDependantChildrenErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(otherDependantChildrenAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(otherDependantChildrenAnchoredErrorMessageAnchorLocator);
	}

	public String getOtherDependantChildrenAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(otherDependantChildrenAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String readDynamicNameDetails(int listCount) {
		navigateToRootElement();
		dynamicNameLocator = By.id("child" + listCount);
		navigateToElementBy(dynamicNameLocator);
		return getElementText();
	}

}

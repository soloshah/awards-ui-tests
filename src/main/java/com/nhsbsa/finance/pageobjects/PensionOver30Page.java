package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PensionOver30Page extends Page {

	private String pensionOver30PageTitle = "Will your NHS pension plus any other pension benefits be more than £30,000 per year, or have you accessed your benefits with another pension scheme using pension flexibilities? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNoNotSureValue']/fieldset/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNoNotSureValue']/fieldset/div/div[2]/label");
	private By notSureRadioButtonLocator = By.xpath("//*[@id='yesNoNotSureValue']/fieldset/div/div[3]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By pensionOver30kAnchoredErrorMessageLocator = By.id("error-list0");
	private By pensionOver30kAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#yesNoNotSureValue']");
	private By pensionOver30kFieldErrorMessageLocator = By.id("fieldName-error-message");
	private By selectedYesRadioButtonLocator = By.xpath("//input[@checked='checked']");
	private By selectedNoRadioButtonLocator = By.xpath("//input[@checked='checked']");
	private By selectedNotSureRadioButtonLocator = By.xpath("//input[@checked='checked']");

	public PensionOver30Page(WebDriver driver) {
		super(driver);
		waitForTitleToExist(pensionOver30PageTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);

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

	public String getPensionOver30kFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(pensionOver30kFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesPensionOver30kErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(pensionOver30kAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(pensionOver30kAnchoredErrorMessageAnchorLocator);
	}

	public String getPensionOver30kAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(pensionOver30kAnchoredErrorMessageLocator);
		return getElementText();
	}

	public PensionOver30Page pensionOver30kIsNotSelected() {
		nextStep();
		return new PensionOver30Page(driver);
	}

	public boolean isPensionOver30kRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

	public SeparatePensionBenefitsPage selectYes() {
		navigateToRootElement();
		navigateToElementBy(yesRadioButtonLocator);
		click();
		nextStep();
		return new SeparatePensionBenefitsPage(driver);
	}

	public SeparatePensionBenefitsPage selectNotsure() {
		navigateToRootElement();
		navigateToElementBy(notSureRadioButtonLocator);
		click();
		nextStep();
		return new SeparatePensionBenefitsPage(driver);
	}

	public LifetimeAllowancePage selectNo() {
		navigateToRootElement();
		navigateToElementBy(noRadioButtonLocator);
		click();
		nextStep();
		return new LifetimeAllowancePage(driver);
	}

	public String getYesRadioButton() {
		navigateToRootElement();
		navigateToElementBy(selectedYesRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}

	public String getNoRadioButton() {
		navigateToRootElement();
		navigateToElementBy(selectedNoRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}

	public String getNotSureRadioButton() {
		navigateToRootElement();
		navigateToElementBy(selectedNotSureRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}
}

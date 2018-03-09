package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DependantChildrenPage extends Page {

	private String dependantChildrenTitle = "Do you have any dependant children? - Claim your NHS Pension";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[2]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By dependantChildrenAnchoredErrorMessageLocator = By.id("error-list0");
	private By dependantChildrenAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#yesNo']");
	private By dependantChildrenFieldErrorMessageLocator = By.id("fieldName-error-message");
	private By DependantChildrenLinkLocator = By.className("summary");
	private By DependentChildLinkTextLocator = By.xpath("//*[@id='details-content-0']/p[1]");
	
	public DependantChildrenPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(dependantChildrenTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
		waitForElementToBeVisibleBy(DependantChildrenLinkLocator);
	}
	
	public DependantChildrenPage dependantChildrenIsNotSelected() {
		nextStep();
		return new DependantChildrenPage(driver);
	}

	public boolean isDependantChildrenRadioButtonSelected() {
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
	

	public WorkingForNHSPage selectValidNoDetails() {
		navigateToRootElement();
		navigateToElementBy(noRadioButtonLocator);
		click();
		nextStep();
		return new WorkingForNHSPage(driver);
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

	public String getDependantChildrenFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(dependantChildrenFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesDependantChildrenErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(dependantChildrenAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(dependantChildrenAnchoredErrorMessageAnchorLocator);
	}

	public String getDependantChildrenAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(dependantChildrenAnchoredErrorMessageLocator);
		return getElementText();
	}
	
	
	public void verifyDependantChildLink() {
		try {
			navigateToRootElement();
			navigateToElementBy(DependantChildrenLinkLocator);
			Thread.sleep(1000);
			click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.print("Link message not success: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String verifyDependantChildLinkText() {
		navigateToRootElement();
		navigateToElementBy(DependentChildLinkTextLocator);
		return getElementText();

	}

}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllocatePensionPage extends Page {

	private String doYouWantToAllocateTitle = "Do you want to allocate part of your pension? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[2]/label");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By allocatePensionAnchoredErrorMessageLocator = By.id("error-list0");
	private By allocatePensionAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#yesNo']");
	private By allocatePensionFieldErrorMessageLocator = By.id("fieldName-error-message");
	private By allocationIdentifyLinkLocator = By.className("summary");
	private By allocationInformationLinkLocator = By.xpath("//*[@id='details-content-0']/p[4]");

	public AllocatePensionPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(doYouWantToAllocateTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}

	public AllocatePensionPage allocatePensionIsNotSelected() {
		nextStep();
		return new AllocatePensionPage(driver);
	}

	public boolean isAllocatePensionRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

	public AllocationNamePage selectYesButton() {
		navigateToRootElement();
		navigateToElementBy(yesRadioButtonLocator);
		click();
		nextStep();
		return new AllocationNamePage(driver);
	}

	public TBIPage selectNoButton() {
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

	public String getAllocatePensionFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(allocatePensionFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesAllocatePensionErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(allocatePensionAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(allocatePensionAnchoredErrorMessageAnchorLocator);
	}

	public String getAllocatePensionAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(allocatePensionAnchoredErrorMessageLocator);
		return getElementText();
	}

	public void verifyAllocationLink() {
		try {
			navigateToRootElement();
			navigateToElementBy(allocationIdentifyLinkLocator);
			Thread.sleep(1000);
			click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.print("Link message not success: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String verifyAllocationText() {
		navigateToRootElement();
		navigateToElementBy(allocationInformationLinkLocator);
		return getElementText();

	}
}

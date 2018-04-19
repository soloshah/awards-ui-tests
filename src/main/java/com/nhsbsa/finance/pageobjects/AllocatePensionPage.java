package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllocatePensionPage extends Page {

	private String doYouWantToAllocateTitle = "Do you want to allocate part of your pension? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[2]/label");
	private By allocationIdentifyLinkLocator = By.className("summary");
	private By allocationInformationLinkLocator = By.xpath("//*[@id='details-content-0']/p[4]");

	public AllocatePensionPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(doYouWantToAllocateTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}

	public boolean isAllocatePensionRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
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

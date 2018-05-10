package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllocatePensionPage extends Page {

	private String doYouWantToAllocateTitle = "Do you want to allocate part of your pension? - Claim your NHS Pension - NHSBSA";
	private By backLinkLocator = By.id("back-link");
	private By yesRadioButtonLocator = By.id("radio-yes");
	private By allocationIdentifyLinkLocator = By.className("summary");
	private By allocationInformationLinkLocator = By.xpath("//*[@id='details-content-0']/p[4]");

	public AllocatePensionPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(doYouWantToAllocateTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
		waitForElementToBeVisibleBy(backLinkLocator);
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

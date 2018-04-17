package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends Page {

	private String startPageTitle = "Claim your NHS Pension - NHSBSA";
	private By startNowButtonLocator = By.id("next-button");
	private By timeConstraintMessageLocator = By.xpath("//*[@id='content']/div[2]/div/div/div[2]/div[1]/strong");
	private By guidanceNoteLinkLocator = By.xpath("//*[@id='content']/div[2]/div/div/div[2]/ul[1]/li[1]/a");
	private By fairProcessingLinkLocator = By.xpath("//*[@id='content']/div[2]/div/div/div[2]/ul[1]/li[2]/a");
	
	
	public StartPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(startPageTitle);
		waitForElementToBeVisibleBy(startNowButtonLocator);
	}

	public NamePage startNow() {
		navigateToRootElement();
		navigateToElementBy(startNowButtonLocator);
		click();
		return new NamePage(driver);
	}

	public void clickStart() {
		navigateToRootElement();
		navigateToElementBy(startNowButtonLocator);
		click();

	}

	public String getTimeConstraintMessage() {
		navigateToRootElement();
		navigateToElementBy(timeConstraintMessageLocator);
		navigateToParentElement();
		return getElementText();
	}

	
	public void verifyFairProcessingNoticeLink() {
		try {
			navigateToRootElement();
			navigateToElementBy(fairProcessingLinkLocator);
			Thread.sleep(1000);
			click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.print("Link message not success: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void verifyGuidanceNotesLink() {
		try {
			navigateToRootElement();
			navigateToElementBy(guidanceNoteLinkLocator);
			Thread.sleep(1000);
			click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.print("Link message not success: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DependantChildrenPage extends Page {

	private String dependantChildrenTitle = "Do you have any dependant children? - Claim your NHS Pension - NHSBSA";
	private By backButtonLocator = By.id("back-link");
	private By DependantChildrenLinkLocator = By.className("summary");
	private By DependentChildLinkTextLocator = By.xpath("//*[@id='details-content-0']/p[1]");

	public DependantChildrenPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(dependantChildrenTitle);
		waitForElementToBeVisibleBy(backButtonLocator);
		waitForElementToBeVisibleBy(DependantChildrenLinkLocator);
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

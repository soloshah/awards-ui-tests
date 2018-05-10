package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtherEqPensionsPage extends Page {

	private String otherEqPensionsTitle = "Do you have any other pensions paid by Equiniti Paymaster? - Claim your NHS Pension - NHSBSA";
	private By backLinkLocator = By.id("backLinkLocator");

	public OtherEqPensionsPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(otherEqPensionsTitle);
		waitForElementToBeVisibleBy(backLinkLocator);
	}


}

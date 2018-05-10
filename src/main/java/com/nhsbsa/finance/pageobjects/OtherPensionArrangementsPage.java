package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtherPensionArrangementsPage extends Page {

	private String otherPensionArrangementsTitle = "Do you have any other pension arrangements? - Claim your NHS Pension - NHSBSA";
    private By backLinkLocator = By.id("back-link");

	public OtherPensionArrangementsPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(otherPensionArrangementsTitle);
		waitForElementToBeVisibleBy(backLinkLocator);
	}

}

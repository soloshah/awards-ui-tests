package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChildDOBPage extends Page {

	private String childDOBPageTitle = "What is your date of birth - Claim your NHS Pension";
	private By dayFieldLocator = By.id("day");
	// private By nextButtonLocator = By.id("submit");

	public ChildDOBPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(childDOBPageTitle);
		waitForElementToBeVisibleBy(dayFieldLocator);
	}

}

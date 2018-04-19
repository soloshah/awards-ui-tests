package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nhsbsa.finance.pageobjects.Page;

public class DynamicChildDateOfBirthPage extends Page {

	String fName = "Brian";
	private String childDobPageTitle = "What is " + fName + "'s " +  "date of birth? - Claim your NHS Pension - NHSBSA";
	private By dayFieldLocator = By.id("dateOfBirth-day");
	

	public DynamicChildDateOfBirthPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(childDobPageTitle);
		waitForElementToBeVisibleBy(dayFieldLocator);
	}
	
	

	
}

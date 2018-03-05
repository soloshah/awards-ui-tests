package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nhsbsa.finance.pageobjects.Page;

public class DynamicDateOfBirthPage extends Page {

	String fName = "Partner-Test";
	private String dobPageTitle = "What is " + fName + "'s " +  "date of birth? - Claim your NHS Pension";
	//private String dobPageTitle = "Claim your NHS Pension";
	private By dayFieldLocator = By.id("dateOfBirth-day");
	

	public DynamicDateOfBirthPage(WebDriver driver) {
		super(driver);
	//	waitForTitleToExist(dobPageTitle);
		waitForElementToBeVisibleBy(dayFieldLocator);
	}


	
}

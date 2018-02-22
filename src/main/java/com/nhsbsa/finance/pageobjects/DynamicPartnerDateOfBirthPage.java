package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nhsbsa.finance.pageobjects.Page;

public class DynamicPartnerDateOfBirthPage extends Page {

	String fName = "Partner Test";
	private String partnerDobPageTitle = "What is " + fName + "'s " +  "date of birth? - Claim your NHS Pension";
	private By partnerDayFieldLocator = By.id("dateOfBirth-day");
	

	public DynamicPartnerDateOfBirthPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(partnerDobPageTitle);
		waitForElementToBeVisibleBy(partnerDayFieldLocator);
	}

}

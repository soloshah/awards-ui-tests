package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nhsbsa.finance.pageobjects.Page;

public class DynamicNinoPage extends Page {

	String fName = "Partner Test";
	private String partnerNinoPageTitle = "What is " + fName + "'s " +  "National Insurance number? - Claim your NHS Pension";
	private By partnerNinoFieldLocator = By.id("nino");
	

	public DynamicNinoPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(partnerNinoPageTitle);
		waitForElementToBeVisibleBy(partnerNinoFieldLocator);
	}

}

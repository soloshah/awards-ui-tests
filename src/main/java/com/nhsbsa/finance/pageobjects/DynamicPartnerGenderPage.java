package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicPartnerGenderPage extends Page {

	private String fname = "Arya";
	private String dynamicPartnerGenderPageTitle = "What is " + fname + "'s " +  "legally recognised gender - Claim your NHS Pension";
	private By femaleRadioButtonLocator = By.xpath("//*[@id='gender']/div[1]/label");
	
	
	public DynamicPartnerGenderPage(WebDriver driver) {
		super(driver);
	//	waitForTitleToExist(dynamicPartnerGenderPageTitle);
		waitForElementToBeVisibleBy(femaleRadioButtonLocator);
	}

	

}

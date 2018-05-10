package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LumpSumChoicePage extends Page {

	private By backButtonLocator = By.id("back-link");
	

	public LumpSumChoicePage(WebDriver driver) {
		super(driver);
		waitForElementToBeVisibleBy(backButtonLocator);
	}

	
	}



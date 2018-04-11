package com.nhsbsa.finance.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LumpSumChoice_1995Page extends Page {

	private String lumpSumChoice1995Title = "You are already entitled to a lump sum. Do you want to increase your lump sum by giving up part of your 1995 pension? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[2]/label");
	

	public LumpSumChoice_1995Page(WebDriver driver) {
		super(driver);
		waitForTitleToExist(lumpSumChoice1995Title);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}

	public boolean isLumpSum1995RadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}


	}



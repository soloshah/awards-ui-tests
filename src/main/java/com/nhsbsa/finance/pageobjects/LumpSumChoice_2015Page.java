package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LumpSumChoice_2015Page extends Page {

	private String lumpSumChoice2015Title = "Do you want to give up part of your 2015 Section pension to receive a lump sum? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.id("radio-yes");
	private By noRadioButtonLocator = By.id("radio-no");
	private By backButtonLocator = By.id("back-link");
	

	public LumpSumChoice_2015Page(WebDriver driver) {
		super(driver);
		waitForTitleToExist(lumpSumChoice2015Title);
		waitForElementToBeVisibleBy(backButtonLocator);
	}

	public boolean isLumpSum2015RadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}


	}



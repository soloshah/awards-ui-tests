package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LumpSumChoice_2008Page extends Page {

	private String lumpSumChoice2008Title = "Do you want to give up part of your 2008 Section pension to receive a lump sum? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[2]/label");
	

	public LumpSumChoice_2008Page(WebDriver driver) {
		super(driver);
		waitForTitleToExist(lumpSumChoice2008Title);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}

	public boolean isLumpSum2008RadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}


	}



package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkingForNHSPage extends Page {

	private String workingForNHSTitle = "Are you working for the NHS? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.id("radio-yes");
	private By noRadioButtonLocator = By.id("radio-no");
	private By backLinkLocator = By.id("back-link");


	public WorkingForNHSPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(workingForNHSTitle);
		waitForElementToBeVisibleBy(backLinkLocator);
	}
	

	public boolean isWorkingForNHSRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

	}

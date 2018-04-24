package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkingForNHSPage extends Page {

	private String workingForNHSTitle = "Are you working in the NHS now? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[2]/label");


	public WorkingForNHSPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(workingForNHSTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}
	

	public boolean isWorkingForNHSRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

	}

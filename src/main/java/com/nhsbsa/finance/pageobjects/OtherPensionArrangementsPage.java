package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtherPensionArrangementsPage extends Page {

	private String otherPensionArrangementsTitle = "Do you have any other pension arrangements? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[2]/label");

	public OtherPensionArrangementsPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(otherPensionArrangementsTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}

	public boolean isAnyRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

}

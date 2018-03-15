package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtherEqPensionsPage extends Page {

	private String otherEqPensionsTitle = "Do you have any other pensions paid by Equiniti Paymaster? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[2]/label");


	public OtherEqPensionsPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(otherEqPensionsTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}


	public boolean isOtherEqPensionsRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

}

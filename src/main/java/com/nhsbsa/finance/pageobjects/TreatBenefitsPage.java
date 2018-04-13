package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TreatBenefitsPage extends Page {

	private String treatBenefitsWithExcessLTATitle = "We’ll only be able to process your application if we treat your NHS Pension Scheme benefits in excess of the Lifetime Allowance - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[2]/label");


	public TreatBenefitsPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(treatBenefitsWithExcessLTATitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}


	public boolean isTreatBenefitsRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

}

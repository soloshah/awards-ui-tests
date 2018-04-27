package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TreatBenefitsPage extends Page {

	private String treatBenefitsWithExcessLTATitle = "We’ll only be able to process your application if we treat your NHS Pension Scheme benefits in excess of the Lifetime Allowance - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[2]/label");
	private By nextButtonLocator = By.id("submit_button");

	public TreatBenefitsPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(treatBenefitsWithExcessLTATitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public boolean isTreatBenefitsRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TreatBenefitsPage extends Page {

	private String treatBenefitsWithExcessLTATitle = "We’ll only be able to process your application if we treat your NHS Pension Scheme benefits in excess of the Lifetime Allowance - Claim your NHS Pension - NHSBSA";
	private By backButtonLocator = By.id("back-link");
	private By nextButtonLocator = By.id("submit_button");
	private By treatBenefitsFieldErrorMessageLocator = By.id("yesNo-error-message");

	public TreatBenefitsPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(treatBenefitsWithExcessLTATitle);
		waitForElementToBeVisibleBy(backButtonLocator);
	}

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}
	
	public String getTreatBenefitsFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(treatBenefitsFieldErrorMessageLocator);
		return getElementText();
	}

	
}

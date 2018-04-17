package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReasonForRetirement_1995Page extends Page {
	//*[@id="retirementReason"]/div[1]/label
	private String retirementPageTitle = "Why are you claiming your deferred benefits for the 1995 Section? - Claim your NHS Pension - NHSBSA";
	private By retirementAgeRadioButtonLocator = By.xpath("//*[@id='retirementReason']/div[1]/label");
	private By paymentDeferredBenefitRadioButtonLocator = By.xpath("//*[@id='retirementReason']/div[3]/label");
	private By deferredBenefitIllRadioButtonLocator = By.xpath("//*[@id='retirementReason']/div[5]/label");
	private By commutedEarlyPaymentRadioButtonLocator = By.xpath("//*[@id='retirementReason']/div[7]/label");
	private By retirementAgeTextLocator = By.id("retirement");
	private By paymentDeferredBenefitTextLocator = By.xpath("//*[@id='deferred-benefit']/p");
	private By deferredBenefitHealthTextLocator = By.xpath("//*[@id='deferred-benefits-health']/p");
	private By commutedEarlyPaymentTextLocator = By.cssSelector("#early-payment-health > ul > li:nth-child(2)");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By retirementReasonFieldErrorMessageLocator = By.id("error-message-why-1995");
	private By retirementReasonAnchoredErrorMessageLocator = By.id("error-list0");
	private By retirementReasonAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#retirementReason']");
	private By selectedDeferredBenefitRadioButtonLocator = By.xpath("//input[@checked='checked']");
		
	public ReasonForRetirement_1995Page(WebDriver driver) {
		super(driver);
		waitForTitleToExist(retirementPageTitle);
		waitForElementToBeVisibleBy(retirementAgeRadioButtonLocator);
	}

	public void selectRetirementReasonAge() {
		navigateToRootElement();
		navigateToElementBy(retirementAgeRadioButtonLocator);
		click();
	}
	
	public void selectRetirementReasonDeferredBenefit() {
		navigateToRootElement();
		navigateToElementBy(paymentDeferredBenefitRadioButtonLocator);
		click();
	}
	
	public void selectRetirementReasonDeferredBenefitHealth() {
		navigateToRootElement();
		navigateToElementBy(deferredBenefitIllRadioButtonLocator);
		click();
	}
	
	public void selectRetirementReasonEarlyPaymentHealth() {
		navigateToRootElement();
		navigateToElementBy(commutedEarlyPaymentRadioButtonLocator);
		click();
	}
	

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public String getRetirementReasonAgeText() {
		navigateToRootElement();
		navigateToElementBy(retirementAgeTextLocator);
		return getElementText();
	
	}
	
	public String getRetirementReasonDeferredBenefitText() {
		navigateToRootElement();
		navigateToElementBy(paymentDeferredBenefitTextLocator);
		return getElementText();
	}
	
	public String getRetirementReasonDeferredBenefitHealthText() {
		navigateToRootElement();
		navigateToElementBy(deferredBenefitHealthTextLocator);
		return getElementText();
	}
	
	public String getRetirementReasonEarlyPaymentHealthText() {
		navigateToRootElement();
		navigateToElementBy(commutedEarlyPaymentTextLocator);
		return getElementText();
	}
	
	public String getErrorHeadingErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(errorHeadingErrorMessageLocator);
		return getElementText();
	}

	public String getErrorsBelowErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(errorsBelowErrorMessageLocator);
		return getElementText();
	}

	public boolean doesRetirementReasonErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(retirementReasonAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(retirementReasonAnchoredErrorMessageAnchorLocator);
	}

	public String getRetirementReasonAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(retirementReasonAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getRetirementReasonFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(retirementReasonFieldErrorMessageLocator);
		return getElementText();
	}

		public void selectValidRetirementReason(){
		nextStep();
		
	}


	public ReasonForRetirement_1995Page isRetirementReasonNotSelected() {
		nextStep();
		return new ReasonForRetirement_1995Page(driver);
	}

	public boolean isRetirementReasonRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(retirementAgeRadioButtonLocator) && !isElementSelected(paymentDeferredBenefitRadioButtonLocator)
				&& !isElementSelected(deferredBenefitIllRadioButtonLocator) && !isElementSelected(commutedEarlyPaymentRadioButtonLocator))
			selected = false;
		return selected;
	}

	
	public String getRetirementReason() {
		navigateToRootElement();
		navigateToElementBy(selectedDeferredBenefitRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}
}

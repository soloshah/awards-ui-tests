package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReasonForRetirementPage extends Page {

	private By retirementAgeRadioButtonLocator = By.id("retirement_radio");
	private By paymentDeferredBenefitRadioButtonLocator = By.id("deferred-benefit_radio");
	private By deferredBenefitIllRadioButtonLocator = By.id("deferred-benefits-health_radio");
	private By commutedEarlyPaymentRadioButtonLocator = By.id("early-payment-health_radio");
	private By retirementAgeTextLocator = By.id("retirement");
	private By paymentDeferredBenefitTextLocator = By.xpath("//*[@id='deferred-benefit']/p");
	private By deferredBenefitHealthTextLocator = By.xpath("//*[@id='deferred-benefits-health']/p");
	private By commutedEarlyPaymentTextLocator = By.xpath("//*[@id='early-payment-health']/p");
	private By nextButtonLocator = By.id("submit_button");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By retirementReasonField2008ErrorMessageLocator = By.id("error-message-why-2008");
	private By retirementReasonFieldErrorMessageLocator = By.id("error-message-why-1995");
	private By retirementReasonAnchoredErrorMessageLocator = By.id("error-list0");
	private By retirementReasonAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#retirementReason']");
	private By backLinkLocator = By.id("back-link");
	private By selectedDeferredBenefitRadioButtonLocator = By.xpath("//input[@checked='checked']");
		
	public ReasonForRetirementPage(WebDriver driver) {
		super(driver);
		waitForElementToBeVisibleBy(backLinkLocator);
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
	
	public String getRetirementReason2008FieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(retirementReasonField2008ErrorMessageLocator);
		return getElementText();
	}

		public void selectValidRetirementReason(){
			nextStep();
		}


	public void isRetirementReasonNotSelected() {
		nextStep();
		
	}
	
	public String getRetirementReason() {
		navigateToRootElement();
		navigateToElementBy(selectedDeferredBenefitRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}


	}

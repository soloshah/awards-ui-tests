package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LumpSumPreferencePage extends Page {

	private String lumpSumPreferenceTitle = "How would you like your lump sum? - Claim your NHS Pension - NHSBSA";
	private By maxTaxFreeAmountRadioButtonLocator = By.id("max-tax-free_radio");
	private By lessTaxFreeAmountRadioButtonLocator = By.id("less-than-max-tax-free_radio");
	private By maxAdditionalLumpSumRadioButtonLocator = By.id("max-additional-sum_radio");
    private By nextButtonLocator = By.id("submit_button");
    private By backButtonLocator = By.id("back-link");
    private By amountFieldLocator = By.id("amount");
    private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By amountFieldErrorMessageLocator = By.id("error-message-additional-amount");
	private By amountAnchoredErrorMessageLocator = By.id("error-list1");
	private By amountAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#amount']");
	private By lumpSum1995FieldErrorMessageLocator = By.id("error-message-lump-sum-1995-pref-status");
	private By lumpSum2008FieldErrorMessageLocator = By.id("error-message-lump-sum-2008-pref-status");
	private By lumpSum2015FieldErrorMessageLocator = By.id("error-message-lump-sum-2015-pref-status");
	private By lumpSumAnchoredErrorMessageLocator = By.id("error-list0");
	private By lumpSumAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#lumpSumPreference']");
	private By maxTaxFreeAmountTextLocator = By.xpath("//*[@id='max-tax-free']/p");
	private By lessTaxFreeAmounTextLocator = By.xpath("//*[@id='less-than-max-tax-free']/p");
	private By maxAdditionalLumpSumTextLocator = By.xpath("//*[@id='max-additional-sum']/p");
    private By poundSymbolLocator = By.xpath("//span[@class='form-label']");
    private By selectedLumpsumPrefRadioButtonLocator = By.xpath("//input[@checked='checked']");
    
    
	public LumpSumPreferencePage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(lumpSumPreferenceTitle);
		waitForElementToBeVisibleBy(backButtonLocator);
	}

	public void selectMaxtaxFreeAmount() {
		navigateToRootElement();
		navigateToElementBy(maxTaxFreeAmountRadioButtonLocator);
		click();
	}
	
	public void selectLessThanMaxTaxFreeAmount() {
		navigateToRootElement();
		navigateToElementBy(lessTaxFreeAmountRadioButtonLocator);
		click();
	}
	
	public void selectAdditionalLumpSumAmount() {
		navigateToRootElement();
		navigateToElementBy(maxAdditionalLumpSumRadioButtonLocator);
		click();
	}
	
	public void enterAmount(String amount) {
		navigateToRootElement();
		navigateToElementBy(amountFieldLocator);
		type(amount);
	}
	
	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public String getMaxTaxFreeAmountText() {
		navigateToRootElement();
		navigateToElementBy(maxTaxFreeAmountTextLocator);
		return getElementText();
	
	}
	
	public String getLessThanMaxTaxFreeAmountText() {
		navigateToRootElement();
		navigateToElementBy(lessTaxFreeAmounTextLocator);
		return getElementText();
	}
	
	public String getMaxAdditonalLumpSumAmountText() {
		navigateToRootElement();
		navigateToElementBy(maxAdditionalLumpSumTextLocator);
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

	public boolean doesLumpSumErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(lumpSumAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(lumpSumAnchoredErrorMessageAnchorLocator);
	}

	public String getLumpSumAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lumpSumAnchoredErrorMessageLocator);
		return getElementText();
	}
	
	public String getLumpSum1995FieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lumpSum1995FieldErrorMessageLocator);
		return getElementText();
	}
	
	public String getLumpSum2008FieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lumpSum2008FieldErrorMessageLocator);
		return getElementText();
	}
	
	public String getLumpSum2015FieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(lumpSum2015FieldErrorMessageLocator);
		return getElementText();
	}

	public String getAmountFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(amountFieldErrorMessageLocator);
		return getElementText();
	}

	
	public boolean doesAmountErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(amountAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(amountAnchoredErrorMessageAnchorLocator);
	}

	public String getAmountAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(amountAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getPoundSymbol() {
		navigateToRootElement();
		navigateToElementBy(poundSymbolLocator);
		return getElementText();
	}


		public void selectValidLumpSumPref(){
		nextStep();
		
	}
		
	public CheckYourAnswerPage submitValidLumpSumAmount(String amount) {
			enterAmount(amount);
			nextStep();
			return new CheckYourAnswerPage(driver);	
		}
	
	public LumpSumPreferencePage submitInvalidAmount() {
		nextStep();
		return new LumpSumPreferencePage(driver);
	}
		

	public LumpSumPreferencePage isLumpSumAmountNotSelected() {
		nextStep();
		return new LumpSumPreferencePage(driver);
	}

	public boolean isLumpSumAmountRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(maxTaxFreeAmountRadioButtonLocator) && !isElementSelected(lessTaxFreeAmountRadioButtonLocator)
				&& !isElementSelected(maxAdditionalLumpSumRadioButtonLocator))
			selected = false;
		return selected;
	}
	
	public String getLumpsumPref() {
		navigateToRootElement();
		navigateToElementBy(selectedLumpsumPrefRadioButtonLocator);
		navigateToParentElement();
		return getElementText();
	}

	}



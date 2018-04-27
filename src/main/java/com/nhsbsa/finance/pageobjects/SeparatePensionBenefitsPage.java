package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeparatePensionBenefitsPage extends Page {

	private String separatePensionBenefitsPageTitle = "Do you have any separate pension benefits? - Claim your NHS Pension - NHSBSA";
	private By after6AprilCheckboxLocator = By.id("reason0");
	private By before6AprilCheckboxLocator = By.id("reason1");
	private By noInformationCheckboxLocator = By.id("reason2");
	private By noBenefitsCheckboxLocator = By.id("reason3");
	private By annualLTAFieldLocator = By.id("percentInPaymentAfter2006");
	private By benefitDayFieldLocator = By.id("firstBenefitCrysDate-day");
	private By benefitMonthFieldLocator = By.id("firstBenefitCrysDate-month");
	private By benefitYearFieldLocator = By.id("firstBenefitCrysDate-year");
	private By grossAnnualRateFieldLocator = By.id("percentInPaymentBefore2006");
	private By nextButtonLocator = By.id("submit_button");
	private By backButtonLocator = By.id("back-link");
	private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
	private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
	private By after6AprilLTAFieldErrorMessageLocator = By.id("percentInPaymentAfter2006-error-message");
	private By after6AprilLTAAnchoredErrorMessageLocator = By.id("error-list0");
	private By after6AprilLTAAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#percentInPaymentAfter2006']");
	private By after6AprilDateFieldErrorMessageLocator = By.id("firstBenefitCrysDate-error-message");
	private By after6AprilDateAnchoredErrorMessageLocator = By.id("error-list1");
	private By after6AprilDateAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#firstBenefitCrysDate']");
	private By before6AprilFieldErrorMessageLocator = By.id("percentInPaymentBefore2006-error-message");
	private By beforeAprilAnchoredErrorMessageLocator = By.id("error-list2");
	private By before6AprilAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#percentInPaymentBefore2006']");
	private By separateBenefitsFieldErrorMessageLocator = By.id("reason-error-message");
	private By separateBenefitsAnchoredErrorMessageLocator = By.id("error-list0");
	private By separateBenefitsAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#reason0']");
	private By selectedAfterApril6CheckBoxLocator = By.xpath("//input[@checked='checked']");
	private By selectedBeforeApril6CheckBoxLocator = By.xpath("//input[@checked='checked']");
	private By selectedIDontHaveInformationCheckBoxLocator = By.xpath("//input[@checked='checked']");
	
	
	
	public SeparatePensionBenefitsPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(separatePensionBenefitsPageTitle);
		waitForElementToBeVisibleBy(backButtonLocator);

	}

	public void selectAfter6April() {
		navigateToRootElement();
		navigateToElementBy(after6AprilCheckboxLocator);
		click();
	}

	public void selectBefore6April() {
		navigateToRootElement();
		navigateToElementBy(before6AprilCheckboxLocator);
		click();
	}

	public void selectNoInformation() {
		navigateToRootElement();
		navigateToElementBy(noInformationCheckboxLocator);
		click();
	}

	public void selectNoSeparateBenefits() {
		navigateToRootElement();
		navigateToElementBy(noBenefitsCheckboxLocator);
		click();
	}

	public void enterCombinedLTA(String LTA) {
		navigateToRootElement();
		navigateToElementBy(annualLTAFieldLocator);
		type(LTA);
	}

	public void enterGrossAnnualRate(String annualRate) {
		navigateToRootElement();
		navigateToElementBy(grossAnnualRateFieldLocator);
		type(annualRate);
	}

	private void enterBenefitCrystallisationDay(String day) {
		navigateToRootElement();
		navigateToElementBy(benefitDayFieldLocator);
		type(day);
	}

	private void enterBenefitCrystallisationMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(benefitMonthFieldLocator);
		type(month);
	}

	private void enterBenefitCrystallisationYear(String year) {
		navigateToRootElement();
		navigateToElementBy(benefitYearFieldLocator);
		type(year);
	}

	public void enterBenefitCrystallisationDate(String day, String month, String year) {
		enterBenefitCrystallisationDay(day);
		enterBenefitCrystallisationMonth(month);
		enterBenefitCrystallisationYear(year);
	}

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
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

	public boolean doesSeparateBenefitsErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(separateBenefitsAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(separateBenefitsAnchoredErrorMessageAnchorLocator);
	}

	public String getSeparateBenefitsAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(separateBenefitsAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getSeparateBenefitFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(separateBenefitsFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesAnnualLTAErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(after6AprilLTAAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(after6AprilLTAAnchoredErrorMessageAnchorLocator);
	}

	public String getAnnualLTAAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(after6AprilLTAAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getAnnualLTAFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(after6AprilLTAFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesBenefitDateErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(after6AprilDateAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(after6AprilDateAnchoredErrorMessageAnchorLocator);
	}

	public String getBenefitDateAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(after6AprilDateAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getBenefitDateFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(after6AprilDateFieldErrorMessageLocator);
		return getElementText();
	}

	public boolean doesGrossAnnualRateErrorMessageHaveAnchor() {
		navigateToRootElement();
		navigateToElementBy(beforeAprilAnchoredErrorMessageLocator);
		navigateToParentElement();
		return getPresenceOfElement(before6AprilAnchoredErrorMessageAnchorLocator);
	}

	public String getGrossAnnualRateAnchoredErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(beforeAprilAnchoredErrorMessageLocator);
		return getElementText();
	}

	public String getGrossAnnualRateFieldErrorMessage() {
		navigateToRootElement();
		navigateToElementBy(before6AprilFieldErrorMessageLocator);
		return getElementText();
	}

	public void submitSeperateBenefit() {
		nextStep();

	}
	
	public SeparatePensionBenefitsPage submitInvalidDetails() {
		nextStep();
		return new SeparatePensionBenefitsPage(driver);
	}
	

	public SeparatePensionBenefitsPage isSeparateBenefitNotSelected() {
		nextStep();
		return new SeparatePensionBenefitsPage(driver);
	}

	public boolean isSeparateBenefitCheckboxSelected() {
		boolean selected = true;

		if (!isElementSelected(after6AprilCheckboxLocator) && !isElementSelected(before6AprilCheckboxLocator)
				&& !isElementSelected(noInformationCheckboxLocator) && !isElementSelected(noBenefitsCheckboxLocator))
			selected = false;
		return selected;
	}

	public LifetimeAllowancePage selectAfterApril6Details(String LTA, String day, String month, String year) {
		selectAfter6April();
		enterCombinedLTA(LTA);
		enterBenefitCrystallisationDate(day, month, year);
		nextStep();
		return new LifetimeAllowancePage(driver);
	}

	public LifetimeAllowancePage selectBeforeApril6Details(String annualRate) {
		selectBefore6April();
		enterGrossAnnualRate(annualRate);
		nextStep();
		return new LifetimeAllowancePage(driver);
	}
	
	public String getCombinedLTA() {
		navigateToRootElement();
		navigateToElementBy(annualLTAFieldLocator);
		return getElementValue();
	}
	
	public String getGrossAnnualRate() {
		navigateToRootElement();
		navigateToElementBy(grossAnnualRateFieldLocator);
		return getElementValue();
	}
	
	 public String getDay() {
		    navigateToRootElement();
		    navigateToElementBy(benefitDayFieldLocator);
		    return getElementValue();
		  }

	 public String getMonth() {
		    navigateToRootElement();
		    navigateToElementBy(benefitMonthFieldLocator);
		    return getElementValue();
		  }
	
	 public String getYear() {
		    navigateToRootElement();
		    navigateToElementBy(benefitYearFieldLocator);
		    return getElementValue();
		  }
	 
	 public boolean isAfterApril6CheckboxSelected() {
			navigateToRootElement();
			boolean checked=isElementSelected(selectedAfterApril6CheckBoxLocator);
		return checked;
	 }
		
		 public boolean isBeforeApril6CheckboxSelected() {
				navigateToRootElement();
				boolean checked=isElementSelected(selectedBeforeApril6CheckBoxLocator);
			return checked;

			}
		 
		 public boolean isIDontHaveInformationCheckboxSelected() {
				navigateToRootElement();
				boolean checked=isElementSelected(selectedIDontHaveInformationCheckBoxLocator);
			return checked;

			}


}

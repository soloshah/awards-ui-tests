package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EqPaymasterReferencePage extends Page {
	
  String name = "NHS-England";
  private String eqPaymasterReferencePageTitle = "Give the reference number of " + name +" - Claim your NHS Pension - NHSBSA";
  private By referenceFieldLocator = By.id("reference");
  private By nextButtonLocator = By.id("submit_button");
  private By errorHeadingErrorMessageLocator = By.id("error-summary-heading");
  private By errorsBelowErrorMessageLocator = By.id("error-summary-heading1");
  private By referenceFieldErrorMessageLocator = By.id("reference-error-message");
  private By referenceAnchoredErrorMessageLocator = By.id("error-list0");
  private By referenceAnchoredErrorMessageAnchorLocator = By.xpath("//a[@href='#reference']");
 
 
  public EqPaymasterReferencePage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(eqPaymasterReferencePageTitle);
    waitForElementToBeVisibleBy(referenceFieldLocator);
  }
  public void enterReferenceNumber(String reference) {
	    navigateToRootElement();
	    navigateToElementBy(referenceFieldLocator);
	    type(reference);
	  }
  
  private void nextStep() {
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
	  

	  public boolean doesReferenceErrorMessageHaveAnchor() {
		    navigateToRootElement();
		    navigateToElementBy(referenceAnchoredErrorMessageLocator);
		    navigateToParentElement();
		    return getPresenceOfElement(referenceAnchoredErrorMessageAnchorLocator);
		  }
	  
	  public String getReferenceAnchoredErrorMessage() {
		    navigateToRootElement();
		    navigateToElementBy(referenceAnchoredErrorMessageLocator);
		    return getElementText();
		  }
	  
	  public String getReferenceFieldErrorMessage() {
			navigateToRootElement();
			navigateToElementBy(referenceFieldErrorMessageLocator);
			return getElementText();
		}
  
	  
	  public TBIPage submitValidReferenceNumber(String reference) {
		  enterReferenceNumber(reference);
	       nextStep();
		    return new TBIPage(driver);
		  }

	  
	  public EqPaymasterReferencePage submitInValidReferenceNumber() {
	 	  nextStep();
	    return new EqPaymasterReferencePage(driver);
	  }
  	  
}

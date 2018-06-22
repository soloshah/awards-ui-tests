package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends Page {


  private String summaryPageTitle = "Your application - Claim your NHS Pension - NHSBSA";
  private By personalDetailsLinkLocator = By.id("about-you-table-row-0");
  private By partnerDetailsLinkLocator = By.id("about-you-table-row-1");
  private By employmentDetailsLinkLocator = By.id("about-you-table-row-2");
  private By contactDetailsLinkLocator = By.id("about-you-table-row-3");
  private By pensionDetailsLinkLocator = By.id("about-your-pension-table-row-0");
  private By hmrcDetailsLinkLocator = By.id("about-your-pension-table-row-1");
  private By paymentDetailsLinkLocator = By.id("about-your-pension-table-row-2");
  private By submitButtonLocator = By.id("continue-button");
  private By personalDetailsCompletedTextLocator = By.id("about-you-table-row-0-completed");
  private By partnerDetailsCompletedTextLocator = By.id("about-you-table-row-1-completed");
  private By employmentDetailsCompletedTextLocator = By.id("about-you-table-row-2-completed");
  private By contactDetailsCompletedTextLocator = By.id("about-you-table-row-3-completed");
  private By pensionDetailsCompletedTextLocator = By.id("about-your-pension-table-row-0-completed");
  private By hmrcDetailsCompletedTextLocator = By.id("about-your-pension-table-row-1-completed");
  private By paymentDetailsCompletedTextLocator = By.id("about-your-pension-table-row-2-completed");
   private By headertextLocator =  By.id("heading-text");



  public SummaryPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(summaryPageTitle);
    waitForElementToBeVisibleBy(personalDetailsLinkLocator);
   
  }
  
  private void submitStep() {
		navigateToRootElement();
		navigateToElementBy(submitButtonLocator);
		click();
	}
  
  public ApplicationSubmittedPage submitApplication(){
	  submitStep();
	  return new ApplicationSubmittedPage(driver);
  }
  
  public boolean isPersonalDetailsCompleted() {
		navigateToRootElement();
		return getPresenceOfElement(personalDetailsCompletedTextLocator);
	}
  
  
  public String getPersonalDetailCompletedValue(){
	  navigateToRootElement();
		navigateToElementBy(personalDetailsCompletedTextLocator);
		return getElementText();
	  
  }
  
  public boolean isPartnerDetailsCompleted() {
		navigateToRootElement();
		return getPresenceOfElement(partnerDetailsCompletedTextLocator);
	}
  
  public String getPartnerDetailCompletedValue(){
	  navigateToRootElement();
		navigateToElementBy(partnerDetailsCompletedTextLocator);
		return getElementText();
	  
  }
  
  public boolean isEmploymentDetailsCompleted() {
		navigateToRootElement();
		return getPresenceOfElement(employmentDetailsCompletedTextLocator);
	}
  
  public String getEmploymentDetailCompletedValue(){
	  navigateToRootElement();
		navigateToElementBy(employmentDetailsCompletedTextLocator);
		return getElementText();
	  
  }
  
  public boolean isContactDetailsCompleted() {
		navigateToRootElement();
		return getPresenceOfElement(contactDetailsCompletedTextLocator);
	}
  
  public String getContactDetailCompletedValue(){
	  navigateToRootElement();
		navigateToElementBy(contactDetailsCompletedTextLocator);
		return getElementText();
	  
  }
  
  public boolean isPensionDetailsCompleted() {
		navigateToRootElement();
		return getPresenceOfElement(pensionDetailsCompletedTextLocator);
	}
  
  public String getPensionDetailCompletedValue(){
	  navigateToRootElement();
		navigateToElementBy(pensionDetailsCompletedTextLocator);
		return getElementText();
	  
  }
  
  public boolean isHmrcDetailsCompleted() {
		navigateToRootElement();
		return getPresenceOfElement(hmrcDetailsCompletedTextLocator);
	}
  
  public String getHmrcDetailCompletedValue(){
	  navigateToRootElement();
		navigateToElementBy(hmrcDetailsCompletedTextLocator);
		return getElementText();
	  
  }
  
  
  public boolean isPaymentDetailsCompleted() {
		navigateToRootElement();
		return getPresenceOfElement(paymentDetailsCompletedTextLocator);
	}
  
  public String getPaymentDetailCompletedValue(){
	  navigateToRootElement();
		navigateToElementBy(paymentDetailsCompletedTextLocator);
		return getElementText();
	  
  }
  
  public void personalDetailsLink() {
		navigateToRootElement();
		navigateToElementBy(personalDetailsLinkLocator);
		click();
	}
  
  public void partnerDetailsLink() {
		navigateToRootElement();
		navigateToElementBy(partnerDetailsLinkLocator);
		click();
	}
  public void employmentDetailsLink() {
		navigateToRootElement();
		navigateToElementBy(employmentDetailsLinkLocator);
		click();
	}
  public void contactDetailsLink() {
		navigateToRootElement();
		navigateToElementBy(contactDetailsLinkLocator);
		click();
	}
  
  public void pensionDetailsLink() {
		navigateToRootElement();
		navigateToElementBy(pensionDetailsLinkLocator);
		click();
	}
  
  public void hmrcDetailsLink() {
		navigateToRootElement();
		navigateToElementBy(hmrcDetailsLinkLocator);
		click();
	}
  
  public void paymentDetailsLink() {
		navigateToRootElement();
		navigateToElementBy(paymentDetailsLinkLocator);
		click();
	}
  
  public boolean isSubmitButtonEnabled() {
	  navigateToRootElement();
	  navigateToElementBy(submitButtonLocator);
	  return isButtonEnabled();
	}
  

	public String getSummaryHeading() {
		navigateToRootElement();
		navigateToElementBy(headertextLocator);
		return getElementText();
	}
  
}

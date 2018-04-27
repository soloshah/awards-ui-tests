package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage extends Page {


  private String summaryPageTitle = "Your application - Claim your NHS Pension - NHSBSA";
  private By personalDetailsLinkLocator = By.id("row-0");
  private By partnerDetailsLinkLocator = By.id("row-1");
  private By employmentDetailsLinkLocator = By.id("row-2");
  private By contactDetailsLinkLocator = By.id("row-3");
  private By pensionDetailsLinkLocator = By.xpath("//*[@id='row-0']");
  private By hmrcDetailsLinkLocator = By.xpath("//*[@id='row-1']");
  private By paymentDetailsLinkLocator = By.xpath("//*[@id='row-2']");
  private By continueButtonLocator = By.xpath("//*[@id='content']/div[2]/div/div/form/div[2]/input");
  private By personalDetailsCompletedTextLocator = By.xpath("//*[@id='about-you-table']/tbody/tr[1]/td[2]/strong");
  private By partnerDetailsCompletedTextLocator = By.xpath("//*[@id='about-you-table']/tbody/tr[2]/td[2]/strong");
  private By employmentDetailsCompletedTextLocator = By.xpath("//*[@id='about-you-table']/tbody/tr[3]/td[2]/strong");
  private By contactDetailsCompletedTextLocator = By.xpath("//*[@id='about-you-table']/tbody/tr[4]/td[2]/strong");
  private By pensionDetailsCompletedTextLocator = By.xpath("//*[@id='about-your-pension-table']/tbody/tr[1]/td[2]/strong");
  private By hmrcDetailsCompletedTextLocator = By.xpath("//*[@id='about-your-pension-table']/tbody/tr[2]/td[2]/strong");
  private By paymentDetailsCompletedTextLocator = By.xpath("//*[@id='about-your-pension-table']/tbody/tr[3]/td[2]/strong");
   private By headertextLocator =  By.xpath("//*[@id='content']/div[2]/div/div/form/h1");



  public SummaryPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(summaryPageTitle);
    waitForElementToBeVisibleBy(personalDetailsLinkLocator);
   
  }
  
  private void continueStep() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
	}
  
  public ApplicationSubmittedPage submitApplication(){
	  
	  continueStep();
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
  
  public boolean isContinueButtonEnabled() {
	  navigateToRootElement();
	  navigateToElementBy(continueButtonLocator);
	  return isButtonEnabled();
	}
  

public String getSummaryHeading() {
		navigateToRootElement();
		navigateToElementBy(headertextLocator);
		return getElementText();
	}
  
}

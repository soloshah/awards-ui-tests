package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobTitlePage extends Page {

  private String jobPageTitle = "What was the name of your last NHS employer? - Claim your NHS Pension";
  private By jobTitleFieldLocator = By.id("jobtitle");
  private By nextButtonLocator = By.id("submit");
  private By errorHeadingErrorMessageLocator = By.id("job-title-error-heading");
  private By errorsBelowErrorMessageLocator = By.id("job-title-error-text");
  private By jobTitleFieldErrorMessageLocator = By.id("job-title-message");
  private By jobTitleAnchoredErrorMessageLocator = By.id("job-title-error-list1");
  private By jobTitleAnchoredErrorMessageAnchorLocator = By
      .xpath("//a[@href='#jobtitle']");
 
  public JobTitlePage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(jobPageTitle);
    waitForElementToBeVisibleBy(jobTitleFieldLocator);
  }
  
  public void enterjobTitle(String jobTitle) {
	    navigateToRootElement();
	    navigateToElementBy(jobTitleFieldLocator);
	    type(jobTitle);
	  }
  
   
  public void enterJobDetails(String jobTitle) {
	  enterjobTitle(jobTitle);
	  nextStep();
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
	  

	  public boolean doesJobTitleErrorMessageHaveAnchor() {
		    navigateToRootElement();
		    navigateToElementBy(jobTitleAnchoredErrorMessageLocator);
		    navigateToParentElement();
		    return getPresenceOfElement(jobTitleAnchoredErrorMessageAnchorLocator);
		  }
	  
	  public String getJobTitleAnchoredErrorMessage() {
		    navigateToRootElement();
		    navigateToElementBy(jobTitleAnchoredErrorMessageLocator);
		    return getElementText();
		  }
	  
	  public String getJobTitleFieldErrorMessage() {
			navigateToRootElement();
			navigateToElementBy(jobTitleFieldErrorMessageLocator);
			return getElementText();
		}
  
	  
	  public DateYouLeavePage submitValidJobTitleDetails(String jobTitle) {
		  enterjobTitle(jobTitle);
		  
	      nextStep();
		  return new DateYouLeavePage(driver);
		  }
	  
	  public JobTitlePage submitInValidJobTitleDetails() {
	 	  nextStep();
	    return new JobTitlePage(driver);
	  }
  
	  
	  public SessionsExpiredPage submitValidJobtitleDetailsInExpiredSession(String jobTitle) {
		  enterjobTitle(jobTitle);
		  
	      nextStep();
		  return new SessionsExpiredPage(driver);
		  }
	  
}

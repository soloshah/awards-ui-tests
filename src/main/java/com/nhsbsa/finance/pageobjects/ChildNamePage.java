package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChildNamePage extends Page {

  private String childNamePageTitle = "What is your spouse or civil partner's name? - Claim your NHS Pension";
  private By firstNameFieldLocator = By.id("firstname");
  private By lastNameFieldLocator = By.id("lastname");
  private By nextButtonLocator = By.id("submit");
  private By errorHeadingErrorMessageLocator = By.id("child-name-error-heading");
  private By errorsBelowErrorMessageLocator = By.id("child-name-error-text");
  private By childNameFieldErrorMessageLocator = By.id("child-name-message-dob");
  private By childNameAnchoredErrorMessageLocator = By.id("child-name-error-list1");
  private By childNameAnchoredErrorMessageAnchorLocator = By
      .xpath("//a[@href='#childname']");
 
  public ChildNamePage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(childNamePageTitle);
    waitForElementToBeVisibleBy(firstNameFieldLocator);
  }
  public void enterfirstName(String firstName) {
	    navigateToRootElement();
	    navigateToElementBy(firstNameFieldLocator);
	    type(firstName);
	  }
  public void enterlastName(String lastName) {
	    navigateToRootElement();
	    navigateToElementBy(lastNameFieldLocator);
	    type(lastName);
	  }
  
  public void enterNameDetails(String firstName,String lastName) {
	  enterfirstName(firstName);
	  enterlastName(lastName);
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
	  

	  public boolean doesChildNameErrorMessageHaveAnchor() {
		    navigateToRootElement();
		    navigateToElementBy(childNameAnchoredErrorMessageLocator);
		    navigateToParentElement();
		    return getPresenceOfElement(childNameAnchoredErrorMessageAnchorLocator);
		  }
	  
	  public String getChildNameAnchoredErrorMessage() {
		    navigateToRootElement();
		    navigateToElementBy(childNameAnchoredErrorMessageLocator);
		    return getElementText();
		  }
	  
	  public String getChildNameFieldErrorMessage() {
			navigateToRootElement();
			navigateToElementBy(childNameFieldErrorMessageLocator);
			return getElementText();
		}
  
	  
	  public ChildDOBPage submitValidChildNameDetails(String firstName, String lastName) {
		  enterfirstName(firstName);
		  enterlastName(lastName);
	  nextStep();
		    return new ChildDOBPage(driver);
		  }
	  
	  public ChildNamePage submitInValidChildNameDetails() {
	 	  nextStep();
	    return new ChildNamePage(driver);
	  }
  
	  
	  public SessionsExpiredPage submitValidChildNameDetailsInExpiredSession(String firstName, String lastName) {
		  enterfirstName(firstName);
		  enterlastName(lastName);
	  nextStep();
		    return new SessionsExpiredPage(driver);
		  }
	  
}

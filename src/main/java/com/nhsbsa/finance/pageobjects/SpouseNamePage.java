package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpouseNamePage extends Page {

  private String spouseNamePageTitle = "What is your spouse or civil partner's name? - Claim your NHS Pension";
  private By firstNameFieldLocator = By.id("firstname");
  private By lastNameFieldLocator = By.id("lastname");
  private By nextButtonLocator = By.id("submit");
  private By errorHeadingErrorMessageLocator = By.id("spouse-name-error-heading");
  private By errorsBelowErrorMessageLocator = By.id("spouse-name-error-text");
  private By spouseNameFieldErrorMessageLocator = By.id("spouse-name-message");
  private By spouseNameAnchoredErrorMessageLocator = By.id("spouse-name-error-list1");
  private By spouseNameAnchoredErrorMessageAnchorLocator = By
      .xpath("//a[@href='#spousename']");
 
  public SpouseNamePage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(spouseNamePageTitle);
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
	  

	  public boolean doesSpouseNameErrorMessageHaveAnchor() {
		    navigateToRootElement();
		    navigateToElementBy(spouseNameAnchoredErrorMessageLocator);
		    navigateToParentElement();
		    return getPresenceOfElement(spouseNameAnchoredErrorMessageAnchorLocator);
		  }
	  
	  public String getSpouseNameAnchoredErrorMessage() {
		    navigateToRootElement();
		    navigateToElementBy(spouseNameAnchoredErrorMessageLocator);
		    return getElementText();
		  }
	  
	  public String getSpouseNameFieldErrorMessage() {
			navigateToRootElement();
			navigateToElementBy(spouseNameFieldErrorMessageLocator);
			return getElementText();
		}
  
	  
	  public SpouseDOBPage submitValidSpouseNameDetails(String firstName, String lastName) {
		  enterfirstName(firstName);
		  enterlastName(lastName);
	      nextStep();
		  return new SpouseDOBPage(driver);
		  }
	  
	  public SpouseNamePage submitInValidSpouseNameDetails() {
	 	  nextStep();
	    return new SpouseNamePage(driver);
	  }
  
	  
	  public SessionsExpiredPage submitValidSpouseNameDetailsInExpiredSession(String firstName, String lastName) {
		  enterfirstName(firstName);
		  enterlastName(lastName);
	      nextStep();
		  return new SessionsExpiredPage(driver);
		  }
	  
}

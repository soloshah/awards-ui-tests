package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Interstitial2008Page extends Page {

  private String interStitial2008PageTitle = "The next questions will be in relation to 2008 Section - Claim your NHS Pension - NHSBSA";

  private By nextButtonLocator = By.id("submit_button");
 
  public Interstitial2008Page(WebDriver driver) {
    super(driver);
    waitForTitleToExist(interStitial2008PageTitle);
    waitForElementToBeVisibleBy(nextButtonLocator);
   
  }
  
  public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

  
}

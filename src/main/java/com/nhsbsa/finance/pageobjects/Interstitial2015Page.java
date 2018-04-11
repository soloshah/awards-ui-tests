package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Interstitial2015Page extends Page {

  private String interStitial2015PageTitle = "The next questions will be in relation to 2015 Section - Claim your NHS Pension - NHSBSA";

  private By nextButtonLocator = By.id("submit_button");
 
  public Interstitial2015Page(WebDriver driver) {
    super(driver);
    waitForTitleToExist(interStitial2015PageTitle);
    waitForElementToBeVisibleBy(nextButtonLocator);
   
  }
  
  public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}
  
}

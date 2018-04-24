package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplicationSubmittedPage extends Page {

	
  private String applicationSubmittedPageTitle = "Done - Claim your NHS Pension - NHSBSA";
  private By finishedButtonLocator = By.id("finished-button");

  public ApplicationSubmittedPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(applicationSubmittedPageTitle);
    waitForElementToBeVisibleBy(finishedButtonLocator);
   
  }

  
  
}

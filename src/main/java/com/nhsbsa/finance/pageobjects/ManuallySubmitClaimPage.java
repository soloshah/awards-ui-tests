package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManuallySubmitClaimPage extends Page {

  private String manuallySubmitClaimPageTitle = "You need to submit your claim manually - Claim your NHS Pension - NHSBSA";
  private By nhsbsaLinkLocator = By.id("nhsbsa-link");

 
  public ManuallySubmitClaimPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(manuallySubmitClaimPageTitle);
    waitForElementToBeVisibleBy(nhsbsaLinkLocator);
  }

  
}

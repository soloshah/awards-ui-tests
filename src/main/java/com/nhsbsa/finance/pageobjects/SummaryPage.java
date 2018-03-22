package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends Page {

  private String summaryPageTitle = "Your application - Claim your NHS Pension - NHSBSA";
  private By personalDetailsLinkLocator = By.id("row-0");

  public SummaryPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(summaryPageTitle);
    waitForElementToBeVisibleBy(personalDetailsLinkLocator);
   
  }

  
}

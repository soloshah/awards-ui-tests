package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpouseDOBPage extends Page {

  private String spouseDOBPageTitle = "What is your date of birth - Claim your NHS Pension";
  private By dayFieldLocator = By.id("day");
    private By nextButtonLocator = By.id("submit");
 
  public SpouseDOBPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(spouseDOBPageTitle);
    waitForElementToBeVisibleBy(dayFieldLocator);
  }

  
}

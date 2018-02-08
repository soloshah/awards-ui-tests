package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhereAreYouEmployedPage extends Page {

  private String whereAreYouEmployedPageTitle = "Where are you employed? - Claim your NHS Pension";

  private By nextButtonLocator = By.id("submit");
 
  public WhereAreYouEmployedPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(whereAreYouEmployedPageTitle);
    waitForElementToBeVisibleBy(nextButtonLocator);
  }

  
}

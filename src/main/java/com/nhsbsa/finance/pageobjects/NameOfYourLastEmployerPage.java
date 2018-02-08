package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NameOfYourLastEmployerPage extends Page {

  private String lastEmployerPageTitle = "What was the name of your last NHS employer? - Claim your NHS Pension";
  private By nextButtonLocator = By.id("submit");
 
  public NameOfYourLastEmployerPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(lastEmployerPageTitle);
    waitForElementToBeVisibleBy(nextButtonLocator);
  }

  
}

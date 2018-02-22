package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlanToWorkPage extends Page {

  private String PlanToWorkPageTitle = "Claim your NHS Pension";
  private By yesRadioButtonLocator = By.id("yes");
  //private By noRadioButtonLocator = By.id("no");
 // private By nextButtonLocator = By.id("submit");
 
  public PlanToWorkPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(PlanToWorkPageTitle);
    waitForElementToBeVisibleBy(yesRadioButtonLocator);
  }

  
}

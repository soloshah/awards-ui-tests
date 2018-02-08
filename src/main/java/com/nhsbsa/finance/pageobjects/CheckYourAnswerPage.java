package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckYourAnswerPage extends Page {

  private String CheckYouAnswersPageTitle = "Check your answers - Claim your NHS Pension";
  private By fullNameFieldLocator = By.id("full-name");
    private By continueButtonLocator = By.id("submit");
 
  public CheckYourAnswerPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(CheckYouAnswersPageTitle);
    waitForElementToBeVisibleBy(fullNameFieldLocator);
  }

  
}

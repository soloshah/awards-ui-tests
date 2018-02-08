package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenderPage extends Page {

  private String genderPageTitle = "What is your status? - Claim your NHS Pension";
  private By maleRadioButtonLocator = By.id("male");
  private By femaleRadioButtonLocator = By.id("female");
  private By nextButtonLocator = By.id("submit");
 
  public GenderPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(genderPageTitle);
    waitForElementToBeVisibleBy(femaleRadioButtonLocator);
  }

  
}

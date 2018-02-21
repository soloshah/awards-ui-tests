package com.nhsbsa.finance.pageobjects;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployerAddressPage extends Page {

  private String tbiPageTitle = "??awardsTitle_en_US??";
  private By maleRadioButtonLocator = By.id("male");
  private By femaleRadioButtonLocator = By.id("female");
  private By nextButtonLocator = By.id("submit");
 
  public EmployerAddressPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(tbiPageTitle);
  //  waitForElementToBeVisibleBy(femaleRadioButtonLocator);
   
  }

  
}

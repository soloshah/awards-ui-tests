package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankyouPage extends Page {

  private String thankyouPageTitle = "NHSBSA Thank you for completing our survey";
  private By nhsbsaMailLinkLocator = By.linkText("nhsbsaresearch@nhs.net");


  public ThankyouPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(thankyouPageTitle);
    waitForElementToBeVisibleBy(nhsbsaMailLinkLocator);
   
  }

 
  
}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeparatePensionBenefitsPage extends Page {

  private String separatePensionBenefitsPageTitle = "Do you have any separate pension benefits? - Claim your NHS Pension - NHSBSA";
  private By after6AprilCheckboxLocator = By.id("reason0-label-text");

  public SeparatePensionBenefitsPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(separatePensionBenefitsPageTitle);
    waitForElementToBeVisibleBy(after6AprilCheckboxLocator);
   
  }

  
}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PensionOver30Page extends Page {

  private String pensionOver30PageTitle = "Will your NHS pension plus any other pension benefits be more than £30,000 per year, or have you accessed your benefits with another pension scheme using pension flexibilities? - Claim your NHS Pension - NHSBSA";
  private By YesRadioButtonLocator = By.xpath("//*[@id='yesNoNotSureValue']/fieldset/div/div[1]/label");
// private By femaleRadioButtonLocator = By.id("female");
 // private By nextButtonLocator = By.id("submit");
 
  public PensionOver30Page(WebDriver driver) {
    super(driver);
    waitForTitleToExist(pensionOver30PageTitle);
    waitForElementToBeVisibleBy(YesRadioButtonLocator);
   
  }

  
}

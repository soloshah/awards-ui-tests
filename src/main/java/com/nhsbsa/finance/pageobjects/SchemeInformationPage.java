package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SchemeInformationPage extends Page {

  private String schemeInformationPageTitle = "NHS Pensions Your NHS Pension Choice NHS Business Service Authority";
  private By schemeInformationTextLocator = By.id("contentHeader");
  private By proceedButtonLocator = By.className("proceed");

 
  public SchemeInformationPage(WebDriver driver) {
    super(driver);
   // waitForTitleToExist(schemeInformationPageTitle);
    //waitForElementToBeVisibleBy(schemeInformationTextLocator);
    waitForElementToBeVisibleBy(proceedButtonLocator);
   
  }

	public String getSchemeInformationPageText() {
		navigateToRootElement();
		navigateToElementBy(proceedButtonLocator);
		return getElementText();
	}
  
}

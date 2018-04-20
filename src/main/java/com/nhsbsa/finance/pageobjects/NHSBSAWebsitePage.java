package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NHSBSAWebsitePage extends Page {

  private String nhsBSAWebsitePageTitle = "NHS Pensions | NHSBSA";
  private By searchFieldLocator = By.id("edit-aggregated-field");
  private By nhsPensionsHeaderLocator = By.id("block-pagetitle");

 
  public NHSBSAWebsitePage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(nhsBSAWebsitePageTitle);
    waitForElementToBeVisibleBy(searchFieldLocator);
   
  }
  
  public String getNhsPensionsHeading() {
		navigateToRootElement();
		navigateToElementBy(nhsPensionsHeaderLocator);
		return getElementText();
	}
	  
  }
  
	  

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends Page {

  private String startPageTitle = "Claim your NHS Pension";
  private By startNowButtonLocator = By.id("next-button");
 // private By estimateLinkLocator = By.id("start-related-list-link1");
  private By estimateLinkAnchorLocator = By
      .xpath("//a[@href='https://www.nhsbsa.nhs.uk/member-hub/getting-estimate-your-pension']");

  public StartPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(startPageTitle);
    waitForElementToBeVisibleBy(startNowButtonLocator);
  }

  public NamePage startNow() {
	    navigateToRootElement();
	    navigateToElementBy(startNowButtonLocator);
	    click();
	    return new NamePage(driver);
	  }
  
  
  public void clickStart(){
	  navigateToRootElement();
	  navigateToElementBy(startNowButtonLocator);
	    click();
	
  }
  
  public boolean doesEstimateLinkHaveAnchor() {
	    navigateToRootElement();
	    navigateToElementBy(estimateLinkAnchorLocator);
	    navigateToParentElement();
	    return getPresenceOfElement(estimateLinkAnchorLocator);
	  }
}
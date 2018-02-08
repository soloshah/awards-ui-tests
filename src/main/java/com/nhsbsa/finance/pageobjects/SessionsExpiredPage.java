package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;

public class SessionsExpiredPage extends Page {

  private String sessionExpiredPageTitle = "Sorry, you'll have to start again";
  private By startButtonLocator = By.id("start-button");

  public SessionsExpiredPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(sessionExpiredPageTitle);
    waitForElementToBeVisibleBy(startButtonLocator);
  }
  
  public StartPage startAgain() {
	    navigateToRootElement();
	    navigateToElementBy(startButtonLocator);
	    click();
	    return new StartPage(driver);
	  }
 
}

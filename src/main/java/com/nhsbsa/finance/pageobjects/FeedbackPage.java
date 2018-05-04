package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeedbackPage extends Page {

  private String feedbackPageTitle = "Claim my NHS pension feedback";
  private By radioButton9Locator = By.id("V9_2new");
  private By resetButtonLocator = By.id("b_reset");
 private By submitRadioButtonLocator = By.id("b_submit");

  public FeedbackPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(feedbackPageTitle);
    waitForElementToBeVisibleBy(resetButtonLocator);
   
  }

  public void clickSubmit(){
	  navigateToRootElement();
		navigateToElementBy(submitRadioButtonLocator);
		click();
	
	  
  }
  
  public void click9RadioButton(){
	  navigateToRootElement();
		navigateToElementBy(radioButton9Locator);
		click(); 
	  
  }
  
}

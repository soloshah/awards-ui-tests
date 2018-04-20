package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitClaimLaterPage extends Page {

  private String submitClaimLaterPageTitle = "Submit your claim later - Claim your NHS Pension - NHSBSA";
  private By returntoNHSWebsiteLinkLocator = By.xpath("//*[@id='content']/div[3]/div/div/div/a");

 
  public SubmitClaimLaterPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(submitClaimLaterPageTitle);
    waitForElementToBeVisibleBy(returntoNHSWebsiteLinkLocator);
   
  }

  public void clickNHSLink(){
	  try {
			navigateToRootElement();
			navigateToElementBy(returntoNHSWebsiteLinkLocator);
			Thread.sleep(1000);
			click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.print("Link message not success: " + e.getMessage());
			e.printStackTrace();
		}  
	  
  }
  
	  
}

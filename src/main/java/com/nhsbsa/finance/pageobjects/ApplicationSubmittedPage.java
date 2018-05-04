package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplicationSubmittedPage extends Page {

	
  private String applicationSubmittedPageTitle = "Form complete - Claim your NHS Pension - NHSBSA";
  private By finishedButtonLocator = By.id("finished-button");
  private By formCompleteHeaderLocator = By.xpath("//*[@id='content']/div[2]/div/div/div/div[1]/h1");
  private By nextStepsTextLocator = By.xpath("//*[@id='content']/div[2]/div/div/div/div[1]/p");
  private By witnessLinkLocator = By.className("summary");
  private By witnessLinkTextLocator = By.xpath("//*[@id='details-content-0']/p[2]");
  
  
  
  public ApplicationSubmittedPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(applicationSubmittedPageTitle);
    waitForElementToBeVisibleBy(finishedButtonLocator);
   
  }

  public void verifyWitnessLink() {
		try {
			navigateToRootElement();
			navigateToElementBy(witnessLinkLocator);
			Thread.sleep(1000);
			click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.print("Link message not success: " + e.getMessage());
			e.printStackTrace();
		}
	}

  
	public String verifyWitnessLinkText() {
		navigateToRootElement();
		navigateToElementBy(witnessLinkTextLocator);
		return getElementText();

	}
 
	
	public String getFormCompleteHeaderText() {
		navigateToRootElement();
		navigateToElementBy(formCompleteHeaderLocator);
		return getElementText();

	}
	
	public String getNextStepText() {
		navigateToRootElement();
		navigateToElementBy(nextStepsTextLocator);
		return getElementText();

	}
	
	public void clickFinished() {
		navigateToRootElement();
		navigateToElementBy(finishedButtonLocator);
		click();
		
	}
  
}

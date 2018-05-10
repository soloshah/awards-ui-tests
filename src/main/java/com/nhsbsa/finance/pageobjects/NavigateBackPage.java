package com.nhsbsa.finance.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigateBackPage extends Page {
	//*[@id="back-link"]
  private By backButtonLocator = By.xpath("//*[@id='back-link']");
 
  public NavigateBackPage(WebDriver driver) {
    super(driver);
   
  }

  public void backLink() {
		navigateToRootElement();
		navigateToElementBy(backButtonLocator);
		click();
	}
  
  public boolean isBackLinkVisible() {
		navigateToRootElement();
		navigateToElementBy(backButtonLocator);
		navigateToParentElement();
		return getPresenceOfElement(backButtonLocator);
	}
  
  
  public  void assertLinkNotPresent() throws Exception {
  
  List<WebElement> err = driver.findElements(By.xpath("//*[@id='back-link']"));

     if(err.size() > 0)
    	System.out.println("Element is found");
    	
    	else
    	System.out.println("Element is not found");
  }
 
}

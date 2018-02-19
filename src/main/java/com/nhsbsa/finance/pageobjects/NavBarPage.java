package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBarPage extends Page {

  private By secondaryHeading = By.id("service-name-text");

  public NavBarPage(WebDriver driver) {
    super(driver);
    waitForElementToBeVisibleBy(secondaryHeading);
    }

}

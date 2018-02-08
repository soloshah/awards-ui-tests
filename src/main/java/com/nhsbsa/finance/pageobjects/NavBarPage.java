package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBarPage extends Page {

  private By logOutLink = By.id("logout-link");

  public NavBarPage(WebDriver driver) {
    super(driver);
    waitForElementToBeVisibleBy(logOutLink);
  }

}

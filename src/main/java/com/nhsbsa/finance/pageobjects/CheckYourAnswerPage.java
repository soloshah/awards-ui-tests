package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
	private By continueButtonLocator = By.id("continue_button");

	public CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(checkYouAnswersPageTitle);
		waitForElementToBeVisibleBy(continueButtonLocator);
	}

	private By getChangeLinkLocator(String page) {
		return By.id(page + ".heading-change");
	}

	public Page changeLink(String page) {
		navigateToRootElement();
		navigateToElementBy(getChangeLinkLocator(page));
		click();
		return new Page(driver);
	}
	
	private By getChangeLink(String page) {
		return By.id(page + "-change");
	}

	public Page clickChange(String page) {
		navigateToRootElement();
		navigateToElementBy(getChangeLink(page));
		click();
		return new Page(driver);
	}

	public SummaryPage submitDetails() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
		return new SummaryPage(driver);
	}
}

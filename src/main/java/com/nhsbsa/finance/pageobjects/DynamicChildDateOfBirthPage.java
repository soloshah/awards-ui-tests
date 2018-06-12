package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nhsbsa.finance.pageobjects.Page;

public class DynamicChildDateOfBirthPage extends Page {

    private By childDayFieldLocator = By.id("dateOfBirth-day");
	private By childMonthFieldLocator = By.id("dateOfBirth-month");
	private By childYearFieldLocator = By.id("dateOfBirth-year");
	private By nextButtonLocator = By.id("submit_button");

	public DynamicChildDateOfBirthPage(WebDriver driver) {
		super(driver);
				waitForElementToBeVisibleBy(childDayFieldLocator);
	}
	
	public DynamicChildGenderPage submitValidChildDateOfBirth(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new DynamicChildGenderPage(driver);
	}
	
	private void enterDay(String day) {
		navigateToRootElement();
		navigateToElementBy(childDayFieldLocator);
		type(day);
	}

	private void enterMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(childMonthFieldLocator);
		type(month);
	}

	private void enterYear(String year) {
		navigateToRootElement();
		navigateToElementBy(childYearFieldLocator);
		type(year);
	}
	
	private void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}
	
}

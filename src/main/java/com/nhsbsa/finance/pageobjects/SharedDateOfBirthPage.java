package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SharedDateOfBirthPage extends Page {

	public By dayFieldLocator = By.id("dateOfBirth-day");
	public By monthFieldLocator = By.id("dateOfBirth-month");
	public By yearFieldLocator = By.id("dateOfBirth-year");
	public By nextButtonLocator = By.id("submit_button");

	
	public SharedDateOfBirthPage(WebDriver driver) {
		super(driver);

	}
	

	public void enterDay(String day) {
		navigateToRootElement();
		navigateToElementBy(dayFieldLocator);
		type(day);
	}

	public void enterMonth(String month) {
		navigateToRootElement();
		navigateToElementBy(monthFieldLocator);
		type(month);
	}

	public void enterYear(String year) {
		navigateToRootElement();
		navigateToElementBy(yearFieldLocator);
		type(year);
	}

	public void nextStep() {
		navigateToRootElement();
		navigateToElementBy(nextButtonLocator);
		click();
	}

	public void enterDobDetails(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
	}


	public GenderPage submitValidDOBDetails(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new GenderPage(driver);
	}
	
	public TBIPage submitValidDateDetails(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new TBIPage(driver);
	}



	public SessionsExpiredPage submitValidDOBDetailsInExpiredSession(String day, String month, String year) {
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		nextStep();
		return new SessionsExpiredPage(driver);
	}

}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmploymentDetails_CheckYourAnswerPage extends Page {

	private By workingForNHSFieldLocator = By.id("workingNhs.heading");
	private By lastEmployerNameFieldLocator = By.id("lastNhsEmployer.heading");
	private By jobTitleFieldLocator = By.id("jobTitle.heading");
	private By dateYouLeaveFieldLocator = By.id("lastEmploymentDate.heading");
	private By intendToWorkFieldLocator = By.id("doYouIntend.heading");
	private By returnDateFieldLocator = By.id("doYouIntend.label");
	private By currentEmployerNameFieldLocator = By.id("currentNhsEmployer.heading");
	private By employerAddressFieldLocator = By.id("whatIsYourEmployerAddress.heading");
	private By lastDayOfWorkFieldLocator = By.id("lastDayOfWorkWillBe.heading");
	private By workingForNHSTextLocator = By.id("workingNhs.heading-answer");
	private By lastEmployerNameTextLocator = By.id("lastNhsEmployer.heading-answer");
	private By jobTitleTextLocator = By.id("jobTitle.heading-answer");
	private By dateYouleaveTextLocator = By.id("lastEmploymentDate.heading-answer");
	private By intendToWorkTextLocator = By.id("doYouIntend.heading-answer");
	private By returnDateTextLocator = By.id("doYouIntend.label-answer");
	private By currentEmployerNameTextLocator = By.id("currentNhsEmployer.heading-answer");
	private By employerAddressTextLocator = By.id("whatIsYourEmployerAddress.heading-answer");
	private By lastDayOfWorkTextLocator = By.id("lastDayOfWorkWillBe.heading-answer");

	public EmploymentDetails_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForElementToBeVisibleBy(workingForNHSFieldLocator);
	}

	public boolean getPresenceOfWorkingForNHS() {
		navigateToRootElement();
		return getPresenceOfElement(workingForNHSFieldLocator);
	}

	public boolean getPresenceOfLastEmployerName() {
		navigateToRootElement();
		return getPresenceOfElement(lastEmployerNameFieldLocator);
	}

	public boolean getPresenceOfCurrentEmployerName() {
		navigateToRootElement();
		return getPresenceOfElement(currentEmployerNameFieldLocator);
	}

	public boolean getPresenceOfEmployerAddress() {
		navigateToRootElement();
		return getPresenceOfElement(employerAddressFieldLocator);
	}

	public boolean getPresenceOfJobTitle() {
		navigateToRootElement();
		return getPresenceOfElement(jobTitleFieldLocator);
	}

	public boolean getPresenceOfLastDayOfWork() {
		navigateToRootElement();
		return getPresenceOfElement(lastDayOfWorkFieldLocator);
	}

	public boolean getPresenceOfDateYouLeave() {
		navigateToRootElement();
		return getPresenceOfElement(dateYouLeaveFieldLocator);
	}

	public boolean getPresenceOfIntendToWork() {
		navigateToRootElement();
		return getPresenceOfElement(intendToWorkFieldLocator);
	}

	public boolean getPresenceOfReturnDate() {
		navigateToRootElement();
		return getPresenceOfElement(returnDateFieldLocator);
	}

	public String getWorkingForNHS() {
		navigateToRootElement();
		navigateToElementBy(workingForNHSFieldLocator);
		return getElementText();
	}

	public String getCurrentEmployerName() {
		navigateToRootElement();
		navigateToElementBy(currentEmployerNameFieldLocator);
		return getElementText();
	}

	public String getLastEmployerName() {
		navigateToRootElement();
		navigateToElementBy(lastEmployerNameFieldLocator);
		return getElementText();
	}

	public String getJobTitle() {
		navigateToRootElement();
		navigateToElementBy(jobTitleFieldLocator);
		return getElementText();
	}

	public String getEmployerAddress() {
		navigateToRootElement();
		navigateToElementBy(employerAddressFieldLocator);
		return getElementText();
	}

	public String getReturnDate() {
		navigateToRootElement();
		navigateToElementBy(returnDateFieldLocator);
		return getElementText();
	}

	public String getLastDayOfWork() {
		navigateToRootElement();
		navigateToElementBy(lastDayOfWorkFieldLocator);
		return getElementText();
	}

	public String getDateYouLeave() {
		navigateToRootElement();
		navigateToElementBy(dateYouLeaveFieldLocator);
		return getElementText();
	}

	public String getIntendToWork() {
		navigateToRootElement();
		navigateToElementBy(intendToWorkFieldLocator);
		return getElementText();
	}
	
	
	public String getWorkingForNHSText() {
		navigateToRootElement();
		navigateToElementBy(workingForNHSTextLocator);
		return getElementText();
	}

	public String getCurrentEmployerNameText() {
		navigateToRootElement();
		navigateToElementBy(currentEmployerNameTextLocator);
		return getElementText();
	}

	public String getLastEmployerNameText() {
		navigateToRootElement();
		navigateToElementBy(lastEmployerNameTextLocator);
		return getElementText();
	}

	public String getJobTitleText() {
		navigateToRootElement();
		navigateToElementBy(jobTitleTextLocator);
		return getElementText();
	}

	public String getEmployerAddressText() {
		navigateToRootElement();
		navigateToElementBy(employerAddressTextLocator);
		return getElementText();
	}

	public String getReturnDateText() {
		navigateToRootElement();
		navigateToElementBy(returnDateTextLocator);
		return getElementText();
	}

	public String getLastDayOfWorkText() {
		navigateToRootElement();
		navigateToElementBy(lastDayOfWorkTextLocator);
		return getElementText();
	}

	public String getDateYouLeaveText() {
		navigateToRootElement();
		navigateToElementBy(dateYouleaveTextLocator);
		return getElementText();
	}

	public String getIntendToWorkText() {
		navigateToRootElement();
		navigateToElementBy(intendToWorkTextLocator);
		return getElementText();
	}

	
}

package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmploymentDetails_CheckYourAnswerPage extends Page {

	private String checkYouAnswersPageTitle = "Check your answers - Claim your NHS Pension - NHSBSA";
	private By workingForNHSFieldLocator = By.id("workingNhs.heading");
	private By lastEmployerNameFieldLocator = By.id("lastNhsEmployer.heading");
	private By jobTitleFieldLocator = By.id("jobTitle.heading");
	private By dateYouLeaveFieldLocator = By.id("lastEmploymentDate.heading");
	private By intendToWorkFieldLocator = By.id("doYouIntend.heading");
	private By returnDateFieldLocator = By.id("doYouIntend.label");
	private By continueButtonLocator = By.id("continue_button");
	private By currentEmployerNameFieldLocator = By.id("currentNhsEmployer.heading");
	private By employerAddressFieldLocator = By.id("whatIsYourEmployerAddress.heading");
	private By lastDayOfWorkFieldLocator = By.id("lastDayOfWorkWillBe.heading");
	private By workingForNHSChangeLinkLocator = By.id("workingNhs.heading-chgit snge");
	private By currentEmployerNameChangeLinkLocator = By.id("currentNhsEmployer.heading-chgit snge");
	private By employerAddressChangeLinkLocator = By.id("whatIsYourEmployerAddress.heading-chgit snge");
	private By lastDayOfWorkChangeLinkLocator = By.id("lastDayOfWorkWillBe.heading-chgit snge");
	private By intendToWorkChangeLinkLocator = By.id("doYouIntend.heading-chgit snge");
	private By returnDateChangeLinkLocator = By.id("doYouIntend.label-chgit snge");
	private By lastEmployerNameChangeLinkLocator = By.id("lastNhsEmployer.heading-chgit snge");
	private By jobTitleChangeLinkLocator = By.id("jobTitle.heading-chgit snge");
	private By dateYouleaveChangeLinkLocator = By.id("lastEmploymentDate.heading-chgit snge");
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
		waitForTitleToExist(checkYouAnswersPageTitle);
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

	private void changeWorkingForNHSLink() {
		navigateToRootElement();
		navigateToElementBy(workingForNHSChangeLinkLocator);
		click();
	}

	public WorkingForNHSPage changeWorkingForNHSDetails() {
		changeWorkingForNHSLink();
		return new WorkingForNHSPage(driver);
	}

	private void changeLastEmployerNameLink() {
		navigateToRootElement();
		navigateToElementBy(lastEmployerNameChangeLinkLocator);
		click();
	}

	public NameOfYourLastEmployerPage changeLastEmployerNameDetails() {
		changeLastEmployerNameLink();
		return new NameOfYourLastEmployerPage(driver);
	}

	private void changeCurrentEmployerNameLink() {
		navigateToRootElement();
		navigateToElementBy(currentEmployerNameChangeLinkLocator);
		click();
	}

	public NameOfYourCurrentEmployerPage changeCurrentEmploymentNameDetails() {
		changeCurrentEmployerNameLink();
		return new NameOfYourCurrentEmployerPage(driver);
	}

	private void changeJobTitleLink() {
		navigateToRootElement();
		navigateToElementBy(jobTitleChangeLinkLocator);
		click();
	}

	public JobTitlePage changeJobTitleDetails() {
		changeJobTitleLink();
		return new JobTitlePage(driver);
	}

	private void changeDateYouLeaveLink() {
		navigateToRootElement();
		navigateToElementBy(dateYouleaveChangeLinkLocator);
		click();
	}

	public DateYouLeavePage changeDateYouLeaveDetails() {
		changeDateYouLeaveLink();
		return new DateYouLeavePage(driver);
	}

	private void changeEmployerAddressLink() {
		navigateToRootElement();
		navigateToElementBy(employerAddressChangeLinkLocator);
		click();
	}

	public EmployerAddressPage changeEmployerAddressDetails() {
		changeEmployerAddressLink();
		return new EmployerAddressPage(driver);
	}

	private void changeLastDayOfWorkLink() {
		navigateToRootElement();
		navigateToElementBy(lastDayOfWorkChangeLinkLocator);
		click();
	}

	public LastDayOfWorkPage changeLastDayOfWorkDetails() {
		changeLastDayOfWorkLink();
		return new LastDayOfWorkPage(driver);
	}

	private void changeIntendToWorkLink() {
		navigateToRootElement();
		navigateToElementBy(intendToWorkChangeLinkLocator);
		click();
	}

	public IntendToWorkForNHSPage changeIntendToWorkDetails() {
		changeIntendToWorkLink();
		return new IntendToWorkForNHSPage(driver);
	}

	private void changeReturnDateLink() {
		navigateToRootElement();
		navigateToElementBy(returnDateChangeLinkLocator);
		click();
	}

	public IntendToWorkForNHSPage changeReturnDateDetails() {
		changeReturnDateLink();
		return new IntendToWorkForNHSPage(driver);
	}

	public SummaryPage submitEmploymentDetails() {
		navigateToRootElement();
		navigateToElementBy(continueButtonLocator);
		click();
		return new SummaryPage(driver);
	}
}

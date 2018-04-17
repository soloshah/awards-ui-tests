package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.pageobjects.StartPage;
import com.nhsbsa.finance.properties.PropertyReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StartPageStepdefs {

	private WebDriver driver = Config.getDriver();
	private String baseUrl = PropertyReader.getProperty("base.server");

	private StartPage startPage;

	@Then("^the start page will be displayed$")
	public void theStartPageWillBeDisplayed() {
		startPage = new StartPage(driver);
		assertThat(startPage.getStartPageHeading()).matches("Claim your NHS Pension");
	}

	@Given("^I am on the start page$")
	public void iAmOnTheStartPage() {
		new Page(driver).navigateToUrl(baseUrl);
		startPage = new StartPage(driver);
		startPage.clickStart();
	}

	@Given("^I go to the start page$")
	public void iGoToTheStartPage() {
		new Page(driver).navigateToUrl(baseUrl);
		startPage = new StartPage(driver);
		assertThat(startPage.getStartPageHeading()).contains("Claim your NHS Pension");
	}

	@Given("^I click on start now button$")
	public void iClickOnStartNowButton() {
		startPage = new StartPage(driver);
		startPage.startNow();
	}

	@And("^the time constraint message will be dsiplayed$")
	public void theTimeConstraintMessageWillBeDisplayed() {
		startPage = new StartPage(driver);
		assertThat(startPage.getTimeConstraintMessage())
				.matches("This form should not be submitted until 3 months before your expected retirement date.");
	}

	@And("^the guidance notes information will be displayed$")
	public void theGuidanceNotesInformationWillBeDisplayed() {
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		System.out.println("*******" + driver.getTitle());
		driver.getTitle().equals("GuidanceNotes.pdf");
		driver.close();
		driver.switchTo().window(browserTabs.get(0));

	}

	@And("^the fair processing notice information will be displayed$")
	public void theFairProcessingNoticeInformationWillBeDisplayed() {
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		System.out.println("*******" + driver.getTitle());
		driver.getTitle().equals("FairProcessingNotice.pdf");
		driver.close();
		driver.switchTo().window(browserTabs.get(0));

	}

	@And("^I click on guidance notes link$")
	public void iClickOnGuidanceNotesLink() {
		startPage = new StartPage(driver);
		startPage.verifyGuidanceNotesLink();
	}

	@And("^I click on fair processing notice link$")
	public void iClickOnFairProcessingNoticeLink() {
		startPage = new StartPage(driver);
		startPage.verifyFairProcessingNoticeLink();
	}

}

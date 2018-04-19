package com.nhsbsa.finance.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.nhsbsa.finance.driver.Config;
import com.nhsbsa.finance.pageobjects.ChildDOBPage;
import com.nhsbsa.finance.pageobjects.DynamicChildDateOfBirthPage;
import com.nhsbsa.finance.pageobjects.Page;
import com.nhsbsa.finance.shared.SharedData;

import cucumber.api.java.en.Then;

public class DynamicChildDateOfBirthStepDefs {

	private WebDriver driver = Config.getDriver();
	private DynamicChildDateOfBirthPage dynamicChildDateOfBirthPage;
	ChildDOBPage childDOBPage;

	
	@Then("^the dynamic child date of birth page will be displayed$")
	public void theDynamicChildDateOfBirthPageWillBeDisplayed() {
		dynamicChildDateOfBirthPage = new DynamicChildDateOfBirthPage(driver);
		assertThat(dynamicChildDateOfBirthPage.getExampleHint().matches("For example, 31 03 1980"));
		assertThat(dynamicChildDateOfBirthPage.getHeading())
				.containsIgnoringCase("What is " + SharedData.childFirstName + "'s " + "date of birth?");
	}

	@Then("^the dynamic value of child first name is displayed on the childs DOB page$")
	public void theDynamicValueOfChildFirstNameIsDisplayedOnTheChildsDOBPage() {
		Page page = new Page(driver);
		String partnerDatePageTitle = "What is " + SharedData.childFirstName + "'s " + "date of birth? - Claim your NHS Pension - NHSBSA";
		page.waitForTitleToExist(partnerDatePageTitle);
		dynamicChildDateOfBirthPage = new DynamicChildDateOfBirthPage(driver);
		assertThat(dynamicChildDateOfBirthPage.getHeading()).contains("What is " + SharedData.childFirstName + "'s " + "date of birth?");

	}
	

	
}

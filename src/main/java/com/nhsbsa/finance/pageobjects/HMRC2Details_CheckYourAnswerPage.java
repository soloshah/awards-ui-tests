package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HMRC2Details_CheckYourAnswerPage extends Page {

	private By otherPensionArrangementsFieldLocator = By.id("otherPensionArrangements.heading");
	private By lifetimeAllowanceFieldLocator = By.id("lifetimeAllowance.heading");
	private By certificateNumberFieldLocator = By.id("lifetimeAllowance.cert");
	private By otherPensionArrangementsTextLocator = By.id("otherPensionArrangements.heading-answer");
	private By lifetimeAllowanceTextLocator = By.id("lifetimeAllowance.heading-answer");
	private By certificateNumberTextLocator = By.id("lifetimeAllowance.cert-answer");

	public HMRC2Details_CheckYourAnswerPage(WebDriver driver) {
		super(driver);
		waitForElementToBeVisibleBy(otherPensionArrangementsFieldLocator);
	}

	public boolean getPresenceOfOtherPension() {
		navigateToRootElement();
		return getPresenceOfElement(otherPensionArrangementsFieldLocator);
	}

	public boolean getPresenceOfLifetimeAllowance() {
		navigateToRootElement();
		return getPresenceOfElement(lifetimeAllowanceFieldLocator);
	}

	public boolean getPresenceOfCertificateNumber() {
		navigateToRootElement();
		return getPresenceOfElement(certificateNumberFieldLocator);
	}

	public String getOtherPensions() {
		navigateToRootElement();
		navigateToElementBy(otherPensionArrangementsFieldLocator);
		return getElementText();
	}

	public String getLifetimeAllowance() {
		navigateToRootElement();
		navigateToElementBy(lifetimeAllowanceFieldLocator);
		return getElementText();
	}

	public String getCertificateNumber() {
		navigateToRootElement();
		navigateToElementBy(certificateNumberFieldLocator);
		return getElementText();
	}

	public String getOtherPensionsText() {
		navigateToRootElement();
		navigateToElementBy(otherPensionArrangementsTextLocator);
		return getElementText();
	}

	public String getLifetimeAllowanceText() {
		navigateToRootElement();
		navigateToElementBy(lifetimeAllowanceTextLocator);
		return getElementText();
	}

	public String getCertificateNumberText() {
		navigateToRootElement();
		navigateToElementBy(certificateNumberTextLocator);
		return getElementText();
	}

}

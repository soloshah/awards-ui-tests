package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtherDependantChildrenPage extends Page {

	private String otherDependantChildrenTitle = "Do you have any other dependant children? - Claim your NHS Pension - NHSBSA";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo']/div/div[2]/label");

	public By dynamicNameLocator;

	public OtherDependantChildrenPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(otherDependantChildrenTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
	}

	public boolean isOtherDependantChildrenRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

	public String readDynamicNameDetails(int listCount) {
		navigateToRootElement();
		dynamicNameLocator = By.id("child" + listCount);
		navigateToElementBy(dynamicNameLocator);
		return getElementText();
	}

}

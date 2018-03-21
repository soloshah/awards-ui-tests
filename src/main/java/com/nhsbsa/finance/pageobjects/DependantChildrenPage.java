package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DependantChildrenPage extends Page {

	private String dependantChildrenTitle = "Do you have any dependant children? - Claim your NHS Pension";
	private By yesRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[1]/label");
	private By noRadioButtonLocator = By.xpath("//*[@id='yesNo_group']/div/div[2]/label");
	private By DependantChildrenLinkLocator = By.className("summary");
	private By DependentChildLinkTextLocator = By.xpath("//*[@id='details-content-0']/p[1]");

	public DependantChildrenPage(WebDriver driver) {
		super(driver);
		waitForTitleToExist(dependantChildrenTitle);
		waitForElementToBeVisibleBy(yesRadioButtonLocator);
		waitForElementToBeVisibleBy(DependantChildrenLinkLocator);
	}

	public boolean isDependantChildrenRadioButtonSelected() {
		boolean selected = true;

		if (!isElementSelected(yesRadioButtonLocator) && !isElementSelected(noRadioButtonLocator))
			selected = false;
		return selected;
	}

	public void verifyDependantChildLink() {
		try {
			navigateToRootElement();
			navigateToElementBy(DependantChildrenLinkLocator);
			Thread.sleep(1000);
			click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.print("Link message not success: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String verifyDependantChildLinkText() {
		navigateToRootElement();
		navigateToElementBy(DependentChildLinkTextLocator);
		return getElementText();

	}

}

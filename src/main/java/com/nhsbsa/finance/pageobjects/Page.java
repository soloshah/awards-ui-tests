package com.nhsbsa.finance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class Page {

	protected WebDriver driver;
	private WebElement element = null;
	private int explicitWaitTime = 20;

	private By headingLocator = By.id("main-heading");
	private By createdHeadingLocator = By.id("account-created-heading");
    private By exampleHintLocator = By.id("form-hint");
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void tearDownDriver(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/jpeg");
		}
		driver.quit();
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	public void navigateToRootElement() {
		element = driver.findElement(By.xpath("/html/body"));
	}

	public void navigateToParentElement() {
		element = element.findElement(By.xpath("./.."));
	}

	public void navigateToElementBy(By by) {
		element = element.findElement(by);
	}

	public void click() {
		element.click();
	}

	public void type(String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void waitForElementToBeVisibleBy(By by) {
		new WebDriverWait(driver, (long) explicitWaitTime).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForTitleToExist(String title) {
		new WebDriverWait(driver, (long) explicitWaitTime).until(ExpectedConditions.titleIs(title));
	}

	public boolean getPresenceOfElement(By by) {
		boolean present = false;
		if (element.findElements(by).size() != 0) {
			present = true;
		}
		return present;
	}

	public String getElementText() {
		return element.getText();
	}

	public String getElementValue() {
		return element.getAttribute("value");
	}

	public String getHeading() {
		navigateToRootElement();
		navigateToElementBy(headingLocator);
		return getElementText();
	}

	public String getExampleHint() {
		navigateToRootElement();
		navigateToElementBy(exampleHintLocator);
		return getElementText();
	}
	
	public String getCreatedHeading() {
		navigateToRootElement();
		navigateToElementBy(createdHeadingLocator);
		return getElementText();
	}

	public String getDate(By monthLocator, By yearLocator) {
		navigateToRootElement();
		navigateToElementBy(monthLocator);
		String month = getElementText();
		navigateToRootElement();
		navigateToElementBy(yearLocator);
		String year = getElementText();
		return month + " " + year;
	}

	public String getDate(By dayLocator, By monthLocator, By yearLocator) {
		navigateToRootElement();
		navigateToElementBy(dayLocator);
		String day = getElementText();
		navigateToRootElement();
		navigateToElementBy(monthLocator);
		String month = getElementText();
		navigateToRootElement();
		navigateToElementBy(yearLocator);
		String year = getElementText();
		return day + " " + month + " " + year;
	}

	public boolean isElementSelected(By by) {
		navigateToElementBy(by);
		return element.isSelected();
	}

}

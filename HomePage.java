package com.flipkartonlineshopping.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseUIPage {

	private final By HOME_PAGE_SEARCH_TEXTBOX = By.xpath("//input[@placeholder='Search for products, brands and more']");
	private final By HOME_PAGE_SEARCH_BUTTON = By.xpath("//button[@type='submit']");
	private final By HOME_PAGE_SEARCH_FIELD = By.xpath("//form[@action=\"/search\"]");

	public HomePage() {
		validateHomePageNavigation();
	}

	public HomePage enterProductNameIntoSearchTextfield(String productName) {
		try {
			driver.findElement(HOME_PAGE_SEARCH_TEXTBOX).click();
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_SEARCH_TEXTBOX));
		}
		driver.findElement(HOME_PAGE_SEARCH_TEXTBOX).sendKeys(productName);
		return this;
	}

	public SearchResultPage searchUserEnteredProduct() {
		driver.findElement(HOME_PAGE_SEARCH_BUTTON).click();
		return new SearchResultPage();
	}
	
	private void validateHomePageNavigation() {
		try {
			driver.findElement(HOME_PAGE_SEARCH_FIELD);
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_SEARCH_FIELD));
		}
	}
}

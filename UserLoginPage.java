package com.flipkartonlineshopping.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLoginPage extends BaseUIPage {

	private final By USER_NAME_TEXT_FIELD = By.xpath("//span[contains(text(),'Enter Email/Mobile number')]//parent::label//parent::div/input");
	private final By USER_PASSWORD_TEXT_FIELD = By.xpath("//span[contains(text(),'Enter Password')]//parent::label//parent::div/input");
	private final By LOGIN_SUBMIT_BUTTON = By.xpath("//button/span[contains(text(), 'Login')]");
	private final By USER_LOGIN_PAGE = By.xpath("//span[contains(text(), 'Login')]//parent::span//parent::div//parent::div");

	public UserLoginPage() {
		validateLoginPageNavigation();
	}

	public UserLoginPage enterUserName(String userName) {
		driver.findElement(USER_NAME_TEXT_FIELD).sendKeys(userName);
		return this;
	}

	public UserLoginPage enterUserPassword(String userPassword) {
		driver.findElement(USER_PASSWORD_TEXT_FIELD).sendKeys(userPassword);
		return this;
	}

	public HomePage submitUserLoginDetails() {
		driver.findElement(LOGIN_SUBMIT_BUTTON).click();
		return new HomePage();
	}

	private void validateLoginPageNavigation() {
		try {
			driver.findElement(USER_LOGIN_PAGE);
		} catch (StaleElementReferenceException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(USER_LOGIN_PAGE));
		}
	}

}

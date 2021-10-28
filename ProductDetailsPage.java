package com.flipkartonlineshopping.pageobject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BaseUIPage {

	private final By ADD_TO_CART_BUTTON = By.xpath("//button[text()='ADD TO CART']");
	
	String MainWindow;
	
	public ProductDetailsPage() {
		validateProductDetailsPageNavigation();
	}

	public SearchResultPage addToTheCart() {
		driver.findElement(ADD_TO_CART_BUTTON).click();
		driver.switchTo().window(MainWindow);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return new SearchResultPage();
	}

	private void validateProductDetailsPageNavigation() {
		this.MainWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		Iterator<String> childWindow = childWindows.iterator();
		while (childWindow.hasNext()) {
			String newWindow = childWindow.next();
			try {
				if (!MainWindow.equalsIgnoreCase(newWindow)) {
					driver.switchTo().window(newWindow);
					driver.findElement(ADD_TO_CART_BUTTON);
				}
			} catch (Exception e) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BUTTON));
			}
		}
	}
	
}

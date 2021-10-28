package com.flipkartonlineshopping.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingCartPage extends BaseUIPage {

	private final By SHOPPING_CART_ICON = By.xpath("//div[@class='_1Er18h']//a//following::div/div/a");
	private final By SHOPPING_CART_PAGE = By.xpath("//span[text()=\"Price details\"]//parent::div");
	
	public ShoppingCartPage() {
		validateShoppingCartPageNavigation();
	}

	public ShoppingCartPage validateProductPresentInTheCart() {
		WebElement productInShoppingCartPage = driver.findElement(SHOPPING_CART_ICON);
		Assert.assertEquals(SearchResultPage.productDetails, productInShoppingCartPage.getText(),
				"Product in the Cart and product selected by the user doesn't match!!");
		return this;
	}
	
	private void validateShoppingCartPageNavigation() {
		try {
			driver.findElement(SHOPPING_CART_PAGE);
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(SHOPPING_CART_PAGE));
		}
	}

}

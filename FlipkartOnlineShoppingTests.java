package com.flipkartonlineshopping.testcases;

import org.testng.annotations.Test;

import com.flipkartonlineshopping.pageobject.BaseUIPage;

public class FlipkartOnlineShoppingTests extends BasicRequirementTests {

	@Test
	public void productPurchaseByValidUserTestCase() {
		BaseUIPage baseUiPage = new BaseUIPage();
		baseUiPage.setupChromeDriver()
				.setupChromePage()
				.navigateToLoginPage(getFlipkartUrl())
				.enterUserName(getUserName())
				.enterUserPassword(getUserPassword())
				.submitUserLoginDetails()
				.enterProductNameIntoSearchTextfield(getProductName())
				.searchUserEnteredProduct()
				.viewProduct(getProductName())
				.addToTheCart()
				.viewProductFromCart()
				.validateProductPresentInTheCart();
	}
}

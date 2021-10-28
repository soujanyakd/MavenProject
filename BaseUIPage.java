package com.flipkartonlineshopping.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUIPage {
	
	static WebDriver driver;
	
	public BaseUIPage setupChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return this;
	}
	
	public BaseUIPage setupChromePage() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return this;
	}
	
	public UserLoginPage navigateToLoginPage(String flipkartUrl) {
		driver.get(flipkartUrl);
		return new UserLoginPage();
	}
}

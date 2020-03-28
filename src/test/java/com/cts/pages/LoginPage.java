package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private By emailLocator = By.id("input-email");
	private By passwordLocator = By.id("input-password");
	private By loginLocator = By.xpath("//input[@value='Login']");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

//Enter Username for login
	public void enterEmail(String email) {
		driver.findElement(emailLocator).sendKeys(email);
	}

	// enter password for login
	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	// click on login
	public void clickOnLogin() {
		driver.findElement(loginLocator).click();
	}
}

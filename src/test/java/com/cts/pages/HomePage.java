package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	private By myAccLocator = By.xpath("//a[@title='My Account']");
	private By registerLocator = By.xpath("//a[text()='Register']");
	private By loginLocator = By.xpath("//a[text()='Login']");
	private By accTitleLoc=By.linkText("My Account");
	private By camClickLoc=By.linkText("Cameras");
	private By ipodTouchWishListLoc=By.xpath("(//button[@type='button'])[19]");
	
	private WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Account click
	public void clickOnMyAccount() 
	{
		driver.findElement(myAccLocator).click();
	}

	//click on login
	public void clickOnLogin() 
	{
		driver.findElement(loginLocator).click();
	}
	
	//Printing the text that appear after login
	public String getCurrentTitle()
	{
		String actualTitle=driver.findElement(accTitleLoc).getText();
		return actualTitle;
	}
	
	//Click on cameras
	public void clickOnCameras()
	{
		driver.findElement(camClickLoc).click();
	}
	
	
	}
		
	
	
	
	
	
	
	
	
	
	
	


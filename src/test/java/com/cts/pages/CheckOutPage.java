package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

	private By checkOutClickLoc=By.xpath("//a[text()='Checkout']");
	
	private By shoppingCartClickLoc=By.xpath("//span[text()='Shopping Cart']");
	
	private By billContinueLoc=By.xpath("//input[@class='btn btn-primary']");
	
	private By deliveryContinueLoc=By.xpath("(//input[@class='btn btn-primary'])[2]");
	
	private By delMethodLoc=By.xpath("(//input[@class='btn btn-primary'])[3]");
	
	private By termsLoc=By.name("agree");
	
	private By payMethodLoc=By.xpath("(//input[@class='btn btn-primary'])[4]");
	
	private By confirmOrderLoc=By.xpath("(//input[@class='btn btn-primary'])[5]");
	
	private By thanksLoc=By.xpath("//h1[text()='Your order has been placed!']");
	
	private WebDriver driver;

	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	
	//Click on shopping cart 
	public void shoppingCartClick()
	{
		driver.findElement(shoppingCartClickLoc).click();
	}
	
	
	//click on checkout
	public void checkOutClick()
	{
		driver.findElement(checkOutClickLoc).click();
	}
	
	//click on billing details
	public void billDetailsClick()
	{
		driver.findElement(billContinueLoc).click();
	}
	
	//click on delivery details
	public void deliveryDetailsClick()
	{
		driver.findElement(deliveryContinueLoc).click();
	}
	
	//click on delivery method
	public void deliveryMethodClick()
	{
		driver.findElement(delMethodLoc).click();
	}
	
	//accepting terms and conditions click
	public void termsClick()
	{
		driver.findElement(termsLoc).click();
	}
	
	//Selecting Payment method
	public void paycontinueClick()
	{
		driver.findElement(payMethodLoc).click();
	}
	
	//click on confirm order
	public void confirmOrderClick()
	{
		driver.findElement(confirmOrderLoc).click();
	}
	
	//Print thanks for shopping
	public String thanks()
	{
		String thanks=driver.findElement(thanksLoc).getText();
		return thanks;
	}

}

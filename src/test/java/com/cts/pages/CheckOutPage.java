package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

	private By CheckOutClickLoc=By.xpath("//a[text()='Checkout']");
	
	private By shoppingCartClickLoc=By.xpath("//span[text()='Shopping Cart']");
	
	private By BillcontinueLoc=By.xpath("//input[@class='btn btn-primary']");
	
	private By DeliverycontinueLoc=By.xpath("(//input[@class='btn btn-primary'])[2]");
	
	private By DelmethodLoc=By.xpath("(//input[@class='btn btn-primary'])[3]");
	
	private By TermsLoc=By.name("agree");
	
	private By PaymethodLoc=By.xpath("(//input[@class='btn btn-primary'])[4]");
	
	private By ConfirmOrderLoc=By.xpath("(//input[@class='btn btn-primary'])[5]");
	
	private By ThanksLoc=By.xpath("//h1[text()='Your order has been placed!']");
	
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
		driver.findElement(CheckOutClickLoc).click();
	}
	
	//click on billing details
	public void billDetailsClick()
	{
		driver.findElement(BillcontinueLoc).click();
	}
	
	//click on delivery details
	public void deliveryDetailsClick()
	{
		driver.findElement(DeliverycontinueLoc).click();
	}
	
	//click on delivery method
	public void deliveryMethodClick()
	{
		driver.findElement(DelmethodLoc).click();
	}
	
	//accepting terms and conditions click
	public void termsClick()
	{
		driver.findElement(TermsLoc).click();
	}
	
	//Selecting Payment method
	public void paycontinueClick()
	{
		driver.findElement(PaymethodLoc).click();
	}
	
	//click on confirm order
	public void confirmOrderClick()
	{
		driver.findElement(ConfirmOrderLoc).click();
	}
	
	//Print thanks for shopping
	public String thanks()
	{
		String thanks=driver.findElement(ThanksLoc).getText();
		return thanks;
	}

}

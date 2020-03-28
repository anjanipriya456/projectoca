package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CamPage{
	
	private  By canon5DclickLoc=By.xpath("//a[text()='Canon EOS 5D']");
	private  By canon5DTitleLoc=By.xpath("//h1[text()='Canon EOS 5D']");
	private  By productCodeLoc=By.xpath("//li[text()='Product Code: Product 3']");
	private  By rewardLoc=By.xpath("//li[text()='Reward Points: 200']");
	private  By availLoc=By.xpath("//li[text()='Availability: 2-3 Days']");
	private  By costLoc=By.xpath("//h2[text()='$98.00']");

private WebDriver driver;

public CamPage(WebDriver driver)
{
	this.driver=driver;
}
	//camera model click 
	public void clickOnCanonEOS5D()
	{
		driver.findElement(canon5DclickLoc).click();
	}
	
	//To print model name as
	public String canon5DDetails()
	{
		String canonTitle=driver.findElement(canon5DTitleLoc).getText();
		return canonTitle;
	}
	
	//To print model code
	public String productCode()
	{
		String productName=driver.findElement(productCodeLoc).getText();
		return productName;
	}
	
	//To print model Reward points
	public String rewardPoints()
	{
		String rewardPoints=driver.findElement(rewardLoc).getText();
		return rewardPoints;
	}
	
	//print Availability of products
	public String availability()
	{
		String availability=driver.findElement(availLoc).getText();
		return availability;
	}
	
	//Print the cost of the model
	public String cost()
	{
		String cost=driver.findElement(costLoc).getText();
		return cost;
	}
	
}

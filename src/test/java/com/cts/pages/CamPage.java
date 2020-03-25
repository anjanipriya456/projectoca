package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CamPage{
	
	private  By Canon5DclickLoc=By.xpath("//a[text()='Canon EOS 5D']");
	private  By Canon5DTitleLoc=By.xpath("//h1[text()='Canon EOS 5D']");
	private  By productCodeLoc=By.xpath("//li[text()='Product Code: Product 3']");
	private  By rewardLoc=By.xpath("//li[text()='Reward Points: 200']");
	private  By availLoc=By.xpath("//li[text()='Availability: 2-3 Days']");
	private  By costLoc=By.xpath("//h2[text()='$98.00']");

private WebDriver driver;

public CamPage(WebDriver driver)
{
	this.driver=driver;
}
	//camera model click and
	public void clickOnCanonEOS5D()
	{
		driver.findElement(Canon5DclickLoc).click();
	}
	
	//To print model name as
	public String Canon5DDetails()
	{
		String canonTitle=driver.findElement(Canon5DTitleLoc).getText();
		return canonTitle;
	}
	
	//To print model code
	public String ProductCode()
	{
		String productName=driver.findElement(productCodeLoc).getText();
		return productName;
	}
	
	//To print model Reward points
	public String RewardPoints()
	{
		String rewardPoints=driver.findElement(rewardLoc).getText();
		return rewardPoints;
	}
	
	//print Availability of products
	public String Availability()
	{
		String availability=driver.findElement(availLoc).getText();
		return availability;
	}
	
	//Print the cost of the model
	public String Cost()
	{
		String cost=driver.findElement(costLoc).getText();
		return cost;
	}
	
}

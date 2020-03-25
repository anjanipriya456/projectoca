package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MP3PlayerPage {

	private By ClickOnMP3=By.linkText("MP3 Players");
	private By ClickOnAllMP3=By.linkText("Show All MP3 Players");
	private By MP3TitleLoc=By.xpath("//h2[text()='MP3 Players']");
	private By IpodCartLoc=By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[10]");
	
	
	private WebDriver driver;

	public MP3PlayerPage(WebDriver driver) {
		this.driver = driver;
	}
	//click on MP3 players
	public void clickOnMP3Players()
	{
		driver.findElement(ClickOnMP3).click();
	}
	
	//click on all MP3 Players 
	public void clickOnAllMP3()
	{
		Actions actions =new Actions(driver);
	     actions.moveToElement(driver.findElement(ClickOnAllMP3)).pause(1000).doubleClick().build().perform();
	}
	
	
	public String getAllMP3Title()
	{
		String actualTitle=driver.findElement(MP3TitleLoc).getText();
		return actualTitle;
	}
	
	//Adding ipod model to cart
	public void clickOnipodCart()
	{
		driver.findElement(IpodCartLoc).click();
	}
}

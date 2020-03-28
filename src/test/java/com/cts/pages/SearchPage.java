package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	private By searchLoc = By.xpath("//input[@type='text']");
	private By searchBoxLoc = By.xpath("(//button[@type='button'])[4]");
	private By searchTitleLoc = By.xpath("//a[text()='Samsung SyncMaster 941BW']");
	private By searchTitleLoc2 = By.xpath("//a[text()='Samsung Galaxy Tab 10.1']");
	private By invalidSearchLoc = By.xpath("//p[text()='There is no product that matches the search criteria.']");

	private WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

//search for valid products
	public void searchText(String productName) {
		driver.findElement(searchLoc).sendKeys(productName);
	}

//search for invalid products
	public void searchBox() {
		driver.findElement(searchBoxLoc).click();
	}

//printing valid search text
	public String getSearchRelatedTitle() {
		String actualTitle = driver.findElement(searchTitleLoc).getText();
		return actualTitle;
	}

//printing invalid search text
	public String getSearchRelatedTitle2() {
		String actualTitle = driver.findElement(searchTitleLoc2).getText();
		return actualTitle;
	}

	public String getinvalidSearchRelatedTitle() {
		String actualTitle = driver.findElement(invalidSearchLoc).getText();
		return actualTitle;
	}

}

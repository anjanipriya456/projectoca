package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LapTopPage {

	private By LapTopClick = By.linkText("Laptops & Notebooks");
	private By AllLapTopClickLoc = By.linkText("Show All Laptops & Notebooks");
	private By HPcompareLoc = By.xpath("//i[@class='fa fa-exchange']");
	private By MaccompareLoc = By.xpath("(//button[@type='button'])[14]");
	private By SonycompareLoc = By.xpath("(//i[@class='fa fa-exchange'])[5]");
	private By comparisionListLoc = By.xpath("//a[text()='product comparison']");

	private WebDriver driver;

	public LapTopPage(WebDriver driver) {
		this.driver = driver;
	}

	// Click on Laptops and Notebooks
	public void clickOnLaptopsandNotebooks() {
		driver.findElement(LapTopClick).click();
	}

	// click on show all laptops and desktops
	public void clickOnShowAll() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(AllLapTopClickLoc)).pause(1000).doubleClick().build().perform();
	}

	// click on hp model laptop compare icon
	public void hpCompare() {
		driver.findElement(HPcompareLoc).click();
	}

//click on macbook model laptop compare icon
	public void macCompare() {
		driver.findElement(MaccompareLoc).click();
	}

//click on sony model laptop compare icon
	public void sonyCompare() {
		driver.findElement(SonycompareLoc).click();
	}

//Comparision table for selected model laptops
	public void compareTable() {

		for (int i = 0; i <= 2; i++) {
			try {
				driver.findElement(comparisionListLoc).click();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

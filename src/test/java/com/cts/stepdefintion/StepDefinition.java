package com.cts.stepdefintion;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.cts.pages.CamPage;
import com.cts.pages.CheckOutPage;
import com.cts.pages.HomePage;
import com.cts.pages.LapTopPage;
import com.cts.pages.LoginPage;
import com.cts.pages.MP3PlayerPage;
import com.cts.pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	private WebDriver driver;

	// Navigating to opencart url
	@Given("I have browser with opencartpage")
	public void i_have_browser_with_opencartpage() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		ChromeOptions chrome = new ChromeOptions();
		chrome.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(chrome);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://opencart.abstracta.us/");

	}

	// searching for particular product

	@When("I search for the product with {string}")
	public void i_search_for_the_product_with(String productname) {

		SearchPage searchpage = new SearchPage(driver);

		searchpage.searchText(productname);

		searchpage.searchBox();
	}

	// Printing the product model names
	@Then("I should get all the search related products")
	public void i_should_get_all_the_search_related_products() {

		SearchPage searchpage = new SearchPage(driver);

		String actualTitle = searchpage.getSearchRelatedTitle();
		Assert.assertEquals("Samsung SyncMaster 941BW", actualTitle);
		System.out.println(actualTitle);

		String actualTitle2 = searchpage.getSearchRelatedTitle2();
		Assert.assertEquals("Samsung Galaxy Tab 10.1", actualTitle2);
		System.out.println(actualTitle2);

		driver.quit();
	}

	// Invalid Search
	@When("I search for the product as {string}")
	public void i_search_for_the_product_as(String productname) {

		SearchPage searchpage = new SearchPage(driver);

		searchpage.searchText(productname);

		searchpage.searchBox();
	}

	// Printing the message when the product not available
	@Then("I should get message as There is no product that matches the search criteria")
	public void i_should_get_message_as_There_is_no_product_that_matches_the_search_criteria() {

		SearchPage searchpage = new SearchPage(driver);

		String actualTitle = searchpage.getinvalidSearchRelatedTitle();
		Assert.assertEquals("There is no product that matches the search criteria.", actualTitle);
		System.out.println(actualTitle);

		driver.quit();
	}

	// Click on the product to get the detailed description or features of the
	// product to buy better one
	@When("I click on any product")
	public void i_click_on_any_product() {

		HomePage homepage = new HomePage(driver);
		homepage.clickOnCameras();

		CamPage campage = new CamPage(driver);
		campage.clickOnCanonEOS5D();
	}

	// Printing the description of the product that clicked
	@Then("I should get all the details of the particular product")
	public void i_should_get_all_the_details_of_the_particular_product() {

		CamPage campage = new CamPage(driver);
		String actualTitle = campage.Canon5DDetails();
		Assert.assertEquals("Canon EOS 5D", actualTitle);
		System.out.println(actualTitle);

		String code = campage.ProductCode();
		Assert.assertEquals("Product Code: Product 3", code);
		System.out.println(code);

		String reward = campage.RewardPoints();
		Assert.assertEquals("Reward Points: 200", reward);
		System.out.println(reward);

		String avail = campage.Availability();
		Assert.assertEquals("Availability: 2-3 Days", avail);
		System.out.println(avail);

		String cost = campage.Cost();
		Assert.assertEquals("$98.00", cost);
		System.out.println(cost);

		driver.quit();

	}

	// Comparing the product to select the best one
	@When("I click on compare icon")
	public void i_click_on_compare_icon() {

		LapTopPage laptoppage = new LapTopPage(driver);

		laptoppage.clickOnLaptopsandNotebooks();

		laptoppage.clickOnShowAll();

		laptoppage.hpCompare();

		laptoppage.macCompare();

		laptoppage.sonyCompare();

	}

	// Taking the screenshot of the comparision table
	@Then("I should get the comparision among the products")
	public void i_should_get_the_comparision_among_the_products() throws InterruptedException {

		LapTopPage laptoppage = new LapTopPage(driver);
		laptoppage.compareTable();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		file.renameTo(new File("src/test/resources/screenshots/compareImage.png"));

		driver.quit();

	}

//Checking the checkout option whether all the available options there or not
	@When("I enter {string} and {string} click on CheckOut")
	public void i_enter_and_click_on_CheckOut(String username, String password) throws InterruptedException {

		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();

		homepage.clickOnLogin();

		LoginPage loginpage = new LoginPage(driver);

		loginpage.enteremail(username);

		loginpage.enterpassword(password);

		loginpage.clickOnLogin();

		MP3PlayerPage mp3page = new MP3PlayerPage(driver);

		mp3page.clickOnMP3Players();

		mp3page.clickOnAllMP3();

		mp3page.clickOnipodCart();

		CheckOutPage checkoutpage = new CheckOutPage(driver);
		checkoutpage.shoppingCartClick();

		checkoutpage.checkOutClick();

		checkoutpage.billDetailsClick();

		Thread.sleep(5000);
		checkoutpage.deliveryDetailsClick();

		checkoutpage.deliveryMethodClick();

		Thread.sleep(5000);
		checkoutpage.termsClick();

		checkoutpage.paycontinueClick();

	}

	// Taking the screenshot of the "your order is placed page"
	@Then("I should navigate to payment page")
	public void i_should_navigate_to_payment_page() {

		CheckOutPage checkoutpage = new CheckOutPage(driver);
		checkoutpage.confirmOrderClick();

		String thanks = checkoutpage.thanks();
		Assert.assertEquals("Your order has been placed!", thanks);
		System.out.println(thanks);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		file.renameTo(new File("src/test/resources/screenshots/Thanks.png"));
		driver.quit();
	}
}

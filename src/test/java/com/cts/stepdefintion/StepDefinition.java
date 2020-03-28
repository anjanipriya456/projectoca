package com.cts.stepdefintion;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
import com.cts.utils.ExcelUtils;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	private WebDriver driver;

	
	@After
	public void end() {

		// Take screenshot for every scenario before closing the browser with date
		Date date = new Date();
		String dateStr = date.toString().replace(":", "-");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		file.renameTo(new File("src/test/resources/screenshots/image" + dateStr + ".png"));

		// Quit the browser after every scenario
		driver.quit();
	}

	//Common for Every Scenario
	@Given("I have browser with opencartpage")
	public void i_have_browser_with_opencartpage() {

		//Driver Path set Property
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		ChromeOptions chrome = new ChromeOptions();
		
		//Accept if any secure connections
		chrome.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(chrome);
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Wait to find the element
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Navigating to the URL
		driver.get("http://opencart.abstracta.us/");

	}

	//Search for the required product
	@When("I search for the product with {string}")
	public void i_search_for_the_product_with(String productname) {

		SearchPage searchPage = new SearchPage(driver);

		//Enter Product Name
		searchPage.searchText(productname);

		//Click on Search Box
		searchPage.searchBox();
	}

	@Then("I should get all the search related products")
	public void i_should_get_all_the_search_related_products() {

		SearchPage searchPage = new SearchPage(driver);

		//Asserting for actual and expected
		String actualTitle = searchPage.getSearchRelatedTitle();
		Assert.assertEquals("Samsung SyncMaster 941BW", actualTitle);
		System.out.println(actualTitle);

		//Asserting for actual and expected
		String actualTitle2 = searchPage.getSearchRelatedTitle2();
		Assert.assertEquals("Samsung Galaxy Tab 10.1", actualTitle2);
		System.out.println(actualTitle2);
	}

	//Searching for the product that was not available
	@When("User enter search as {string}")
	public void user_enter_search_as(String product) {
	  
		//Reading from Excel sheet
		SearchPage searchPage = new SearchPage(driver);

		//Enter Product Name
		searchPage.searchText(product);

		//Click on Search Box
		searchPage.searchBox();
	}

	@Then("I should get message as There is no product that matches the search criteria")
	public void i_should_get_message_as_There_is_no_product_that_matches_the_search_criteria() {

		SearchPage searchPage = new SearchPage(driver);

		//Asserting and Printing the Actual message
		String actualTitle = searchPage.getinvalidSearchRelatedTitle();
		Assert.assertEquals("There is no product that matches the search criteria.", actualTitle);
		System.out.println(actualTitle);
	}

	@When("I click on any product")
	public void i_click_on_any_product() {

		//Click On Cameras
		HomePage homePage = new HomePage(driver);
		homePage.clickOnCameras();

		//Click on Camera Model
		CamPage camPage = new CamPage(driver);
		camPage.clickOnCanonEOS5D();
	}

	@Then("I should get all the details of the particular product")
	public void i_should_get_all_the_details_of_the_particular_product() {

		//Asserting the actual and expected and Printing the Camera Model description
		CamPage camPage = new CamPage(driver);
		
		//Assertion
		String actualTitle = camPage.canon5DDetails();
		Assert.assertEquals("Canon EOS 5D", actualTitle);
		
		//Printing
		System.out.println(actualTitle);

		String code = camPage.productCode();
		Assert.assertEquals("Product Code: Product 3", code);
		System.out.println(code);

		String reward = camPage.rewardPoints();
		Assert.assertEquals("Reward Points: 200", reward);
		System.out.println(reward);

		String avail = camPage.availability();
		Assert.assertEquals("Availability: 2-3 Days", avail);
		System.out.println(avail);

		String cost = camPage.cost();
		Assert.assertEquals("$98.00", cost);
		System.out.println(cost);

	}

	@When("I click on compare icon")
	public void i_click_on_compare_icon() {

		LapTopPage laptopPage = new LapTopPage(driver);

		//Click on Laptops and notebooks
		laptopPage.clickOnLaptopsandNotebooks();

		//Click on showall
		laptopPage.clickOnShowAll();

		//Click on hp laptop compare icon
		laptopPage.hpCompare();

		//Click on mac laptop compare icon
		laptopPage.macCompare();

		//Click on sony laptop compare icon
		laptopPage.sonyCompare();

	}

	@Then("I should get the comparision among the products")
	public void i_should_get_the_comparision_among_the_products() throws InterruptedException {

		//Getting Comparision Table for selected products
		LapTopPage laptopPage = new LapTopPage(driver);
		laptopPage.compareTable();
	}

	@When("User enter username and password details from Excel {string} with SheetName {string}")
	public void user_enter_username_and_password_details_from_Excel_with_SheetName(String fileDetails, String sheetName) throws IOException, InterruptedException {

		//Reading Username and Password from excel Sheet
		ExcelUtils readExcel = new ExcelUtils();
		String str[][] = readExcel.getSheetIntoStringArray(fileDetails, sheetName);
		
		HomePage homePage = new HomePage(driver);
		
		//Click on My Account
		homePage.clickOnMyAccount();

		//Click on Login
		homePage.clickOnLogin();

		LoginPage loginPage = new LoginPage(driver);

		//Enter Email
		loginPage.enterEmail(str[0][0]);

		//Enter Password
		loginPage.enterPassword(str[0][1]);

		loginPage.clickOnLogin();
				
		MP3PlayerPage mp3Page = new MP3PlayerPage(driver);

		//Click on mp3 players
		mp3Page.clickOnMP3Players();

		//Click on all mp3 players
		mp3Page.clickOnAllMP3();

		//Add Ipod to the cart
		mp3Page.clickOnipodCart();

		CheckOutPage checkoutPage = new CheckOutPage(driver);
		
		//Click on shopping cart
		checkoutPage.shoppingCartClick();

		//Click on Checkout
		checkoutPage.checkOutClick();

		//Click on bill details
		checkoutPage.billDetailsClick();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click on Delivery Details
		checkoutPage.deliveryDetailsClick();

		//Click on delivery Method
		checkoutPage.deliveryMethodClick();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Accepting Terms and Conditions
		checkoutPage.termsClick();

		//Click on Payment continue icon
		checkoutPage.paycontinueClick();

	}

	@Then("I should navigate to payment page")
	public void i_should_navigate_to_payment_page() {

		CheckOutPage checkoutPage = new CheckOutPage(driver);
		
		//Click on confirm order
		checkoutPage.confirmOrderClick();

		//Asserting actual and expected
		String thanks = checkoutPage.thanks();
		Assert.assertEquals("Your order has been placed!", thanks);
		
		//Printing the actual message
		System.out.println(thanks);
	}
}

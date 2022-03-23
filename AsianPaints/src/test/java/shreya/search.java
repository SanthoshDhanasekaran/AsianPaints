package shreya;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import io.cucumber.testng.PickleWrapper;

public class search {

	static Properties prop = new Properties();

	public static WebDriver driver;

	@Given("User is on the hompage")
	public void user_is_on_the_homepage() throws Exception {
		FileInputStream fs = new FileInputStream(".\\AsianPaints.properties");
		prop.load(fs);
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--disable-notifications");
		driver = new ChromeDriver(opts);
		driver.get("http://asianpaints.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("i_understand"))).click();
		/*
		 * By cookies_accept = By.xpath("//*[@id=\"cookie-popup-id\"]/div/button"); By
		 * cookies_gotIt = By.xpath("//*[@id=\"cookie_action_close_header\"]");
		 * 
		 * @SuppressWarnings("deprecation") WebDriverWait wait = new
		 * WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
		 */
	}

	@When("user click on searchbar")
	public void user_click_on_searchbar() {
		driver.findElement(By.xpath(prop.getProperty("searchbar")));
		driver.findElement(By.xpath(prop.getProperty("searchbar"))).click();
	}

	@Then("user will get popular result")
	public void user_will_get_popular_result() {
		driver.findElement(By.xpath(prop.getProperty("searchpopular")));
		driver.quit();
	}

	@When("user writes on searchbar")
	public void user_writes_on_searchbar() {
		driver.findElement(By.xpath(prop.getProperty("searchbar"))).sendKeys("shop");
	}

	@When("user press search button")
	public void user_press_search_button() {
		driver.findElement(By.xpath(prop.getProperty("searchbutton"))).click();
	}

	@Then("user will get search result")
	public void user_will_get_search_result() {
		String expurl = "https://www.asianpaints.com/search-results.html?q=shop";
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		Assert.assertEquals(expurl, URL);
		driver.quit();
	}

}

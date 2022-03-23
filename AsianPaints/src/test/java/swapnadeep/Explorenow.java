package swapnadeep;


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

public class Explorenow {
	public static WebDriver driver;
	static Properties prop=new Properties();
	@Given("I am on Asian Paints Homepages")
	public void i_am_on_asianpaints_homepages() throws Exception {
		FileInputStream fs= new FileInputStream(".\\AsianPaints.properties");
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

	@When("I click on Explore Now")
	public void i_click_on_explore_now() throws IOException{
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		driver.findElement(By.xpath(prop.getProperty("explorenow"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);

	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("explorenow"))));

	    //throw new io.cucumber.java.PendingException();
	}


	@Then("Beautiful Homes page opens")
	public void beautiful_homes_page_opens() {
		driver.navigate();
		driver.quit();
	}

}

package swapnadeep;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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


public class wallcovering {
	public static WebDriver driver;
	static Properties prop=new Properties();
	@Given("I am on ap wc")
	public void i_am_on_ap_wc() throws Exception {
		FileInputStream fs= new FileInputStream(".\\AsianPaints.properties");
		prop.load(fs);
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--disable-notifications");
		driver = new ChromeDriver(opts);
		driver.get("https://www.asianpaints.com/products/wall-coverings.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
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
	@When("user clicks on bedroom")
	public void user_clicks_on_bedroom() throws InterruptedException, IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("bedroom"))).click();
	}
	
	@When("user clicks on livingroom")
	public void user_clicks_on_livingroom() throws InterruptedException, IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("livingroom"))).click();
	}
	
	@When("user clicks on designer")
	public void user_clicks_on_designer() throws IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		driver.findElement(By.xpath(prop.getProperty("designer"))).click();
	}
	
	@Then("design changes")
	public void design_changes() {
		driver.quit();
	}
}

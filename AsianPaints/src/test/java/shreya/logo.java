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

public class logo {
	static Properties prop=new Properties();

		public static WebDriver driver;
		@Given("user is on any page")
		public void user_is_on_any_page() throws Exception{
			FileInputStream in = new FileInputStream(".\\AsianPaints.properties");
			prop.load(in);
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
		
		@When("user cick on logo")
		public void user_cick_on_logo() throws IOException {
			FileInputStream in=new FileInputStream(".\\AsianPaints.properties");
	   	 	prop.load(in);
			driver.findElement (By.xpath(prop.getProperty("logo"))).click();
			}
		
		@Then("user get homepage")
		public void user_get_homepage() {
			String expurl = "https://www.asianpaints.com/";
			String URL = driver.getCurrentUrl();
			System.out.println(URL);
			Assert.assertEquals( expurl,URL);
			driver.quit();
		}

	}

		



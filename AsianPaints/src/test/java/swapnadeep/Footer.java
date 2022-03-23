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

public class Footer {
	public static WebDriver driver;
	static Properties prop=new Properties();
	@Given("I am on ap hp")
	public void i_am_on_ap_hp() {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.navigate().to("https://www.asianpaints.com");
		driver.manage().deleteAllCookies();
		 //driver.switchTo().frame(0);
	       // driver.getWindowHandles();


	        By cookies_accept = By.xpath("//*[@id=\"cookie-popup-id\"]/div/button");
	        By cookies_gotIt = By.xpath("//*[@id=\"cookie_action_close_header\"]");
	        @SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
			//driver.switchTo().alert().accept();

	        //wait.until(ExpectedConditions.invisibilityOfElementLocated(cookies_accept));
	        //wait.until(ExpectedConditions.elementToBeClickable(cookies_gotIt)).click();
	}



	@When("user finds about")
	public void user_finds_about() throws IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);

		driver.findElement(By.xpath(prop.getProperty("about")));
	}

	@When("user finds content")
	public void user_finds_content() throws IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);

		driver.findElement(By.xpath(prop.getProperty("content")));
	}

	@When("user finds policies")
	public void user_finds_policies() throws IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);

		driver.findElement(By.xpath(prop.getProperty("policies")));
	}

	@When("user finds tools")
	public void user_finds_tools() throws IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);

		driver.findElement(By.xpath(prop.getProperty("tools")));
	}

	@When("user finds country")
	public void user_finds_country() throws IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);

		driver.findElement(By.xpath(prop.getProperty("country")));
	}

	@Then("footer working")
	public void footer_working() {
		driver.quit();
	}
}

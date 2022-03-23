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

public class ImageValidate {
	public static WebDriver driver;
	static Properties prop=new Properties();
	@Given("I am on aps hp")
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



	@When("beautiful homes image")
	public void beautiful_homes_image() throws IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);

		driver.findElement(By.xpath(prop.getProperty("bhi")));
	}

	@When("exquisite finish image")
	public void exquisite_finish_image() throws IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);

		driver.findElement(By.xpath(prop.getProperty("efi")));
	}

	@When("design and colour app image")
	public void design_and_colour_app_image() throws IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);

		driver.findElement(By.xpath(prop.getProperty("dacai")));
	}

	@When("explore now image")
	public void explore_now_image() throws IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);

		driver.findElement(By.xpath(prop.getProperty("eni")));
	}

	@Then("images working")
	public void images_working() {
		driver.quit();
	}
}

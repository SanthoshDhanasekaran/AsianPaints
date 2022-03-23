package shreya;

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
import java.util.concurrent.TimeUnit;

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

public class signup {
	public static WebDriver driver;
	static Properties prop = new Properties();

	// driver.findElement(By.xpath(prop.getProperty("loginbutton_xpath"))).click();
	@Given("I am on asianpaints signup page")

	public void i_am_on_asianpaints_signup_page() throws Exception {
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

	@When("user enters mobile number for signup")
	public void user_enters_mobile_number_for_signup() throws IOException {
		FileInputStream in = new FileInputStream(
				".\\AsianPaints.properties");
		prop.load(in);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/header/div[3]/div[2]/div[1]/a[1]/span"))
				.click();
		driver.findElement(By.id(prop.getProperty("mobile"))).sendKeys("7972981370");
		driver.findElement(By.xpath("//*[@id=\"validate-mobile\"]/div[2]/button")).click();
	}

	@When("user enters credentials")
	public void user_enters_credentials() throws InterruptedException {
		// *[@id="registerName"]
		driver.findElement(By.xpath(prop.getProperty("name"))).sendKeys("Sneha");
		driver.findElement(By.id("registerEmail")).sendKeys("Sneha@gmail.com");
		Thread.sleep(10000);
	}

	@Then("user should signup")
	public void user_should_sigup() {
		driver.findElement(By.xpath("//*[@id=\"validate-register\"]/div[6]/button")).click();
		driver.quit();
	}

	@When("user enters wrong mobile number for signup")
	public void user_enters_wrong_mobile_number_for_signup() throws Exception {
		
		FileInputStream in = new FileInputStream(
				".\\AsianPaints.properties");
		prop.load(in);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/header/div[3]/div[2]/div[1]/a[1]/span"))
				.click();
		//driver.findElement(By.id(prop.getProperty("mobile"))).sendKeys("7972981370");
		//driver.findElement(By.xpath("//*[@id=\"validate-mobile\"]/div[2]/button")).click();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		//findElement(By.xpath("//span[@class='spriteIcon-Firstfold profileIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id(prop.getProperty("mobile"))).sendKeys("13456789991");
		driver.findElement(By.xpath("//*[@id=\"validate-mobile\"]/div[2]/button")).click();
		// driver.findElement(By.id("loginMobile")).click();
	}

	@Then("user should not signup")
	public void user_should_not_sigup() {
		driver.findElement(By.xpath("//*[@id=\"validate-register\"]/div[6]/button")).click();
		//driver.findElement(By.xpath("//*[@id=\"validate-register\"]/div[2]/div"));
		driver.quit();
	}
}

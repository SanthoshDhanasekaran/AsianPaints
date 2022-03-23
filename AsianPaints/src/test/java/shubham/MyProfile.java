package shubham;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyProfile {
	public static WebDriver driver;
	static Properties prop = new Properties();

	@Given("I am on the homepage of AP")
	public void i_am_on_the_homepage_of_ap() throws InterruptedException, IOException {
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

	@When("I click on my profile")
	public void i_click_on_my_profile() throws InterruptedException {
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("MyProfileIcon"))).click();
		driver.findElement(By.id("loginMobile")).sendKeys("7887676487");
		driver.findElement(By.xpath(prop.getProperty("Mob"))).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(prop.getProperty("OTPSubmit"))).click();
		driver.navigate().to("https://www.asianpaints.com/my-profile.html");
	}

	@Then("Profile is shown")
	public void profile_is_shown() 
	{
		String expurl = "https://www.asianpaints.com/my-profile.html";
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(expurl, URL);
	}

	@Then("Edit is working")
	public void edit_is_working() {
		driver.findElement(By.xpath(prop.getProperty("Editbutton"))).click();
		driver.findElement(By.xpath(prop.getProperty("EditFname"))).clear();
		driver.findElement(By.xpath(prop.getProperty("EditFname"))).sendKeys("Shubham");
		driver.findElement(By.xpath(prop.getProperty("ProfileUpdateBtn"))).click();
		driver.quit();

	}

}

package swapnadeep;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

public class painttexturewallpaper {
	
	public static WebDriver driver;
	static Properties prop=new Properties();
	@Given("I am on ap homepage")
	public void i_am_on_ap_homepage() throws Exception {
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
	
	@When("user clicks on paint")
	public void user_clicks_on_paint() throws InterruptedException, IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("paint"))).click();
	}
	
	@When("user clicks on texture")
	public void user_clicks_on_texture() throws InterruptedException, IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("texture"))).click();
	}
	
	@When("user clicks on wallpaper")
	public void user_clicks_on_wallpaper() throws InterruptedException, IOException {
		FileInputStream ip=new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("wallpaper"))).click();
	}
	
	@Then("changes occur")
	public void changes_occur() {
		driver.quit();
	}
}

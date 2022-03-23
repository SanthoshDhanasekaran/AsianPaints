package shubham;

import java.io.FileInputStream;
//import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyOrder {
	public static WebDriver driver;
	static Properties prop = new Properties();
	@Given("I am on homepage")
	public void i_am_on_homepage() throws Exception {
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
	@Given("I click on profile")
	public void i_click_on_profile() throws InterruptedException {
		driver.manage().window();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath(prop.getProperty("MyOrderProfile"))).click();
	  driver.findElement(By.id("loginMobile")).sendKeys("7887676487");
	  driver.findElement(By.xpath(prop.getProperty("Mob"))).click();
	  Thread.sleep(15000);
	  
	  driver.findElement(By.xpath(prop.getProperty("OTPSubmit"))).click();
	  driver.navigate().to("https://www.asianpaints.com/my-profile.html");
		//driver.findElement(By.xpath("//span[@class='spriteIcon-Aprevamp profileIcon-active']")).click();
	}
	@When("I click My orders")
	public void i_click_my_orders() {
		driver.findElement(By.xpath(prop.getProperty("MyOrder"))).click();
		
	}
	@Then("No orders is shown")
	public void no_orders_is_shown() {
		driver.findElement(By.xpath(prop.getProperty("NoOrderTxt")));
		
	}
	@Then("Start Shopping is shown")
	public void start_shopping_is_shown() {
		driver.findElement(By.xpath(prop.getProperty("StartShopp")));
		driver.quit();
	}

}

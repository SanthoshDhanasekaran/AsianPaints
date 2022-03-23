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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.junit.CucumberOptions;

public class chatbutton {

	public static WebDriver driver;
	static Properties prop = new Properties();

	@Given("I am on asian paints homepage")
	public void i_am_on_asian_paints_homepage() throws Exception {
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

	@When("user clicks chat button")
	public void user_clicks_chat_button() throws IOException {
		FileInputStream ip = new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		driver.findElement(By.xpath(prop.getProperty("chatbutton"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("selectoption"))));
	}

	@When("user selects option")
	public void user_selects_option() throws InterruptedException, IOException {
		FileInputStream ip = new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		driver.findElement(By.xpath(prop.getProperty("selectoption"))).click();
		Thread.sleep(3000);
	}

	@When("user clicks minimize")
	public void user_clicks_minimize() throws IOException {
		FileInputStream ip = new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		driver.findElement(By.xpath(prop.getProperty("minimize"))).click();
	}

	@When("user clicks chat button again")
	public void user_clicks_chat_button_again() throws IOException {
		FileInputStream ip = new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		driver.findElement(By.xpath("/html/body/div[7]/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("close"))));
	}

	@When("user clicks close")
	public void user_clicks_close() throws IOException {
		FileInputStream ip = new FileInputStream(".\\AsianPaints.properties");
		prop.load(ip);
		driver.findElement(By.xpath(prop.getProperty("close"))).click();
	}

	@Then("chat box closes")
	public void chat_box_closes() {
		driver.quit();
	}
}

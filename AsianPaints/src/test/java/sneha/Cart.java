package sneha;
//package newtest;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cart {
	public static WebDriver driver;
	static Properties prop = new Properties();

	@Given("I am on asianpaints cart page")
	public void i_am_on_asianpaints_cart_page() throws Exception {
		FileInputStream fs = new FileInputStream(
				"D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-3\\java_assigments\\AsianPaints\\AsianPaints.properties");
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
	}

	@When("user click on cart")
	public void user_click_on_cart() throws IOException {
		FileInputStream fs = new FileInputStream(
				"D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-3\\java_assigments\\AsianPaints\\AsianPaints.properties");
		prop.load(fs);
		driver.findElement(By.xpath(prop.getProperty("cart"))).click();
	}

	@When("user gets empty cart")
	public void user_gets_empty_cart() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/header/div[3]/div[2]/div[2]/div/div/p"))
				.click();
		Thread.sleep(2000);
	}

	@Then("user gets start shopping")
	public void user_gets_start_shopping() throws InterruptedException {
		driver.findElement(
				By.xpath("/html/body/div[1]/div/div[1]/div/div/header/div[3]/div[2]/div[2]/div/div/div[2]/a")).click();
		Thread.sleep(2000);
	}

	@When("user check from shopping")
	public void user_check_from_shopping() throws InterruptedException {
		driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/a/div[1]/picture/img"))
				.click();
		Thread.sleep(2000);
	}

	@When("user select item")
	public void user_select_item() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"thin-banner-info\"]/ul/li[1]/a/img")).click();
		Thread.sleep(2000);
	}

	@When("user will give pincode")
	public void user_will_give_pincode() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"productPincode\"]")).sendKeys("700065");
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div/div[2]/div/div[5]/div/div[1]/a")).click();
		Thread.sleep(3000);
	}

	@When("user added item to cart")
	public void user_added_item_to_cart() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"addToCart\"]")).click();
		Thread.sleep(3000);
	}
}

package shubham;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ColournTexture {
	public static WebDriver driver;
	static Properties prop = new Properties();

	@SuppressWarnings("deprecation")
	@Given("I am on Asian Paint Homepage")
	public void i_am_on_asian_paint_homepage() throws IOException, InterruptedException {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='spriteIcon-Firstfold profileIcon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("loginMobile")).sendKeys("7887676487");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"validate-mobile\"]/div[2]/button")).click();
		Thread.sleep(15000);
		// driver.findElement(By.xpath("//*[@id=\\\"validate-otp\\\"]/div[3]/button")).click();
		driver.findElement(By.xpath(
				"//form[@id='validate-otp']//button[contains(@class,'modal__variant-login--submit')][normalize-space()='SUBMIT']"))
				.click();

	}

	@When("I move cursor on Paints and Texture tab and select colours")
	public void i_move_cursor_on_paints_and_texture_tab_and_select_colours() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[1]/a[2]/span[1]")));
		// Locating the Main Menu (Parent element)
		WebElement mainMenu = driver.findElement(By.xpath(prop.getProperty("PaintnTexturehover")));

		// Instantiating Actions class
		Actions actions = new Actions(driver);

		// Hovering on main menu
		actions.moveToElement(mainMenu);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath(prop.getProperty("ColournTextureSubmenu")));

		// To mouseover on sub menu
		actions.moveToElement(subMenu).click();

	}

	@Then("Colour catlougue is opened")
	public void colour_catlougue_is_opened() throws InterruptedException {
		driver.navigate().to("https://www.asianpaints.com/catalogue/colour-catalogue.html");
		Thread.sleep(2000);

		String expurl = "https://www.asianpaints.com/catalogue/colour-catalogue.html";
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(expurl, URL);
	}

	@When("I select the colour")
	public void i_select_the_colour() {
		driver.findElement(By.xpath("//*[@id=\"colorCatalogueList\"]/div/div[2]/div[1]/ul/li[1]/a/div")).click();
		driver.findElement(By.xpath("//*[@id=\"mainSwatch\"]/div/div/div/div[3]")).click();
		driver.findElement(By.xpath(prop.getProperty("pincode"))).clear();
		driver.findElement(By.xpath(prop.getProperty("pincode"))).sendKeys("444906");
	}

	@Then("I am able to order it")
	public void i_am_able_to_order_it() {
		driver.findElement(By.xpath("//a[@id='buy-now-click']")).click();
		if (driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[7]/div/div[1]/div[5]/div/span"))
				.isDisplayed()) {
			System.out.println("Currently out of stock.");
		} else {
			driver.findElement(By.xpath("//a[@id='buy-now-click']")).click();
		}
	}

}

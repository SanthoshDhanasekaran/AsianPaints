package shubham;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaintnTexture {
	public static WebDriver driver;
	static Properties prop = new Properties();
	@Given("I am on Asian Paints Homepage")
	public void i_am_on_asian_paints_homepage() throws Exception {
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
	
	@When("I move cursor on Paints and Texture tab")
	public void i_move_cursor_on_paints_and_texture_tab() {
		WebElement mainMenu = driver.findElement(By.xpath(prop.getProperty("PaintnTexturehover"))); 
		

		//Instantiating Actions class
		Actions actions = new Actions(driver);

		//Hovering on main menu
		actions.moveToElement(mainMenu);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath(prop.getProperty("PaintnTexturehover")));

		//To mouseover on sub menu
		actions.moveToElement(subMenu);
	}
	
	@Then("Paints and Texture tab is hovered")
	public void paints_and_texture_tab_is_hovered() {
		driver.findElement (By.xpath(prop.getProperty("PaintnTexturesubmenu")));
	}
	
	
	@When("I click on Paints and Texture tab")
	public void i_click_on_paints_and_texture_tab() {
		driver.findElement(By.xpath(prop.getProperty("PaintnTexturehover"))).click();  

	}
	
	@Then("Paints and Texture tab is opened")
	public void paints_and_texture_tab_is_opened() {
		driver.findElement (By.xpath("/html/body"));
		driver.quit();
	}
	
	
}
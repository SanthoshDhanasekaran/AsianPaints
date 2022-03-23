package sneha;

import org.testng.AssertJUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import ch.qos.logback.core.joran.action.Action;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TopMenu {
	public static WebDriver driver;
	static Properties prop = new Properties();

	@Given("I am on Asian Paints Homepage for top menu on site")
	public void i_am_on_asian_paints_homepage_for_top_menu_on_site() throws Exception {
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

	@When("user should see top menu")
	public void user_should_see_top_menu() throws IOException {
		FileInputStream fs = new FileInputStream(
				"D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-3\\java_assigments\\AsianPaints\\AsianPaints.properties");
		prop.load(fs);
		driver.findElement(By.xpath(prop.getProperty("topmenu")));
	}

	@Then("user redirect to homepage top menu")
	public void user_redirect_to_homepage_top_menu() {
		driver.findElement(By.xpath("//*[@id=\"headerNav\"]"));
		driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div/div/header/div[2]/div/div[2]/a[2]/span[2]"));
		String expurl = "https://www.asianpaints.com/";
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		AssertJUnit.assertEquals(expurl, URL);
	}

	@When("I move cursor on Paints n Texture tab")
	public void i_move_cursor_on_paints_n_texture_tab() {
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[1]/a[2]/span[1]"));

		// Instantiating Actions class
		Actions actions = new Actions(driver);

		// Hovering on main menu
		actions.moveToElement(mainMenu);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"PAINTSTEXTURES\"]/div[2]/div/div"));

		// To mouseover on sub menu
		actions.moveToElement(subMenu);
	}

	// *[@id="headerNav"]/div[1]/ul/li[1]/a[2]/span[1]

	@Then("Paints n Texture tab is hovered")
	public void paints_n_texture_tab_is_hovered() throws IOException {
		FileInputStream fs = new FileInputStream(
				"D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-3\\java_assigments\\AsianPaints\\AsianPaints.properties");
		prop.load(fs);
		driver.findElement(By.xpath(prop.getProperty("paintntexture")));
		driver.quit();
	}

	@When("I move cursor on Wallpapers tab")
	public void i_move_cursor_on_wallpapers_tab() {
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[2]/a[2]/span[1]"));

		// Instantiating Actions class
		Actions actions = new Actions(driver);

		// Hovering on main menu
		actions.moveToElement(mainMenu);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[2]/a[2]"));

		// To mouseover on sub menu
		actions.moveToElement(subMenu);
	}

	@Then("Wallpapers tab is hovered")
	public void wallpapers_tab_is_hovered() throws IOException {
		FileInputStream fs = new FileInputStream(
				"D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-3\\java_assigments\\AsianPaints\\AsianPaints.properties");
		prop.load(fs);
		driver.findElement(By.xpath(prop.getProperty("wallpapers")));
		driver.quit();
	}

	@When("I move cursor on Health and Hygiene tab")
	public void i_move_cursor_on_health_and_hygiene_tab() {
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[3]/a[2]/span[1]"));

		// Instantiating Actions class
		Actions actions = new Actions(driver);

		// Hovering on main menu
		actions.moveToElement(mainMenu);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[3]/a[2]/span[1]"));

		// To mouseover on sub menu
		actions.moveToElement(subMenu);
	}

	@Then("Health and Hygiene tab is hovered")
	public void health_and_hygiene_tab_is_hovered() throws IOException {
		FileInputStream fs = new FileInputStream(
				"D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-3\\java_assigments\\AsianPaints\\AsianPaints.properties");
		prop.load(fs);
		driver.findElement(By.xpath(prop.getProperty("hnh")));
		driver.quit();
	}

	@When("I move cursor on Services tab")
	public void i_move_cursor_on_services_tab() {
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[4]/a[2]/span[1]"));
		Actions actions = new Actions(driver);// Instantiating Actions class
		actions.moveToElement(mainMenu);// Hovering on main menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[4]/a[2]/span[1]"));// Locating the element from Sub Menu
		actions.moveToElement(subMenu);// To mouseover on sub menu
	}

	@Then("Services tab is hovered")
	public void services_tab_is_hovered() throws IOException {
		FileInputStream fs = new FileInputStream(
				"D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-3\\java_assigments\\AsianPaints\\AsianPaints.properties");
		prop.load(fs);
		driver.findElement(By.xpath(prop.getProperty("services")));
		driver.quit();
	}

	@When("I move cursor on Ideas tab in top menu")
	public void i_move_cursor_on_ideas_tab_in_top_menu() {
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[5]/a[2]/span[1]"));
		Actions actions = new Actions(driver);// Instantiating Actions class
		actions.moveToElement(mainMenu);// Hovering on main menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[5]/a[2]/span[1]"));// Locating the element from Sub Menu
		actions.moveToElement(subMenu);// To mouseover on sub menu
	}

	@Then("Ideas tab is hovered")
	public void ideas_tab_is_hovered() throws IOException {
		FileInputStream fs = new FileInputStream(
				"D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-3\\java_assigments\\AsianPaints\\AsianPaints.properties");
		prop.load(fs);
		driver.findElement(By.xpath(prop.getProperty("ideas")));
		driver.quit();
	}

	@When("I move cursor on Shop tab")
	public void i_move_cursor_on_shop_tab() {
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[6]/a[2]/span[1]"));
		Actions actions = new Actions(driver);// Instantiating Actions class
		actions.moveToElement(mainMenu);// Hovering on main menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"headerNav\"]/div[1]/ul/li[6]/a[2]/span[1]"));// Locating the element from Sub Menu
		actions.moveToElement(subMenu);// To mouseover on sub menu
	}

	@Then("Shop tab is hovered")
	public void shop_tab_is_hovered() throws IOException {
		FileInputStream fs = new FileInputStream(
				"D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-3\\java_assigments\\AsianPaints\\AsianPaints.properties");
		prop.load(fs);
		driver.findElement (By.xpath(prop.getProperty("shop")));
		driver.quit();
	}
}

package shreya;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.junit.CucumberOptions;

public class header {
	public static WebDriver driver;
	static Properties prop=new Properties();

	@Given("user is on front page")
	public void user_is_on_front_page() throws Exception {
		FileInputStream in=new FileInputStream(".\\AsianPaints.properties");
   	 	prop.load(in);
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
	@When("user cick on header")
	public void user_cick_on_header() throws IOException {
		FileInputStream in=new FileInputStream(".\\AsianPaints.properties");
   	 	prop.load(in);
		driver.findElements(By.xpath(prop.getProperty("header")));
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("user get new page")
	public void user_get_new_page() {
		
		driver.findElement(By.xpath(prop.getProperty("find_con_logo"))).click();
		String expurl = "https://www.asianpaints.com/contractor-landing-page.html";
		String URL = driver.getCurrentUrl();
		System.out.println(URL);

		Assert.assertEquals( expurl,URL);
		driver.quit();
	    // Write code here that turns the phrase above into concrete actions
	}



}

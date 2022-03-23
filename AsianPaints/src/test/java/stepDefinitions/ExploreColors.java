package stepDefinitions;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class ExploreColors {
	WebDriver driver;
	static Properties prop = new Properties();
	
	@Given("User is on the Homepage")
	public void user_is_on_the_homepage() throws Exception {
		FileInputStream fs= new FileInputStream("D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-3\\java_assigments\\AsianPaints\\AsianPaints.properties");
		prop.load(fs);
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--disable-notifications");
		driver = new ChromeDriver(opts);
		driver.get("http://asianpaints.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("i_understand"))).click();
		Thread.sleep(1000);
	}

	@When("User Clicks on ExploreColors")
	public void user_clicks_on_explore_colors() throws InterruptedException {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/a[3]/div[2]")).click();
		Thread.sleep(2000);
	}

	@Then("It Redirects to ExploreColors page")
	public void it_redirects_to_explore_colors_page() throws InterruptedException {
		String exp_col_url = driver.getCurrentUrl();
		System.out.println(exp_col_url);
		Assert.assertEquals("https://www.asianpaints.com/catalogue/colour-catalogue.html",exp_col_url);
		Thread.sleep(2000);
	    driver.quit();
	}

	@When("User Clicks on PaintBudgetCalC")
	public void user_clicks_on_paint_budget_cal_c() throws InterruptedException {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/a[1]/div[2]/span[1]")).click();
		Thread.sleep(2000);
	}

	@Then("It Redirects to PaintBudgetCalC page")
	public void it_redirects_to_paint_budget_cal_c_page() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Quick & Advanced Paint Budget Calculator - Asian Paints");
		Thread.sleep(2000);
		driver.quit();
	}
	
}

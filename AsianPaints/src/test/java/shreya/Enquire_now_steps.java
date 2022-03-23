package shreya;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import io.cucumber.testng.PickleWrapper;

public class Enquire_now_steps {
	static Properties prop = new Properties();

	public static WebDriver driver;

	@Given("I am on asianpaints home page")
	public void i_am_on_asianpaints_home_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://asianpaints.com");
		driver.manage().deleteAllCookies();
		// driver.switchTo().frame(0);
		// driver.getWindowHandles();

		By cookies_accept = By.xpath("//*[@id=\"cookie-popup-id\"]/div/button");
		By cookies_gotIt = By.xpath("//*[@id=\"cookie_action_close_header\"]");
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();

	}

	@When("user enters name")
	public void user_enters_name() throws IOException {
		FileInputStream in = new FileInputStream(
				".\\AsianPaints.properties");
		prop.load(in);
		// Write code here that turns the phrase above into concrete actions
		String excelFile = ".\\DataFiles\\data.xlsx";
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("enquire");
		int row = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		DataFormatter formatter = new DataFormatter();

		for (int r = 0; r < row; r++) 
		{
			XSSFRow record = sheet.getRow(r);
			XSSFCell cell = record.getCell(0);
			String val = cell.getStringCellValue();
			driver.findElement(By.id(prop.getProperty("enquire_name"))).sendKeys(val);
		}
	}

	@When("user enters email id")
	public void user_enters_email_id() {
		driver.findElement(By.xpath(prop.getProperty("enquire_email"))).sendKeys("shreya.das1999@gmail.com");
	}

	@When("user enters mobile number")
	public void user_enters_mobile_number() {
		driver.findElement(By.xpath(prop.getProperty("enquire_mobile"))).sendKeys("8777796764");
	}

	@When("user enters pincode")
	public void user_enters_pincode() {
		driver.findElement(By.id("enquire-pincode")).sendKeys("700065");

	}

	@When("user clicks enquire now button")
	public void user_clicks_enquire_now_button() {
		driver.findElement(By.xpath(prop.getProperty("enquire_button"))).click();
	}

	@Then("user gets details successfully")
	public void user_gets_details_successfully() {
		if (driver.findElement(By.xpath(prop.getProperty("enquire_name_error"))).isDisplayed()) {
			System.out.println("ERROR!!");
			driver.navigate();

		} else {
			System.out.println("successfull");
			driver.navigate();
		}
		driver.quit();
	}

}

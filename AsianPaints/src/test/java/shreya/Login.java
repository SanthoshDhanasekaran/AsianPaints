package shreya;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class Login {
	public static WebDriver driver;
	static Properties prop = new Properties();

	@Given("I am on asianpaints login page")
	public void i_am_on_asianpaints_login_page() throws Exception {
		FileInputStream in = new FileInputStream(".\\AsianPaints.properties");
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

	@When("user enters mobile numbrer")
	public void user_enters_mobile_numbrer() throws InterruptedException, IOException {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String excelFile = ".\\DataFiles\\data.xlsx";
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet3");
		int row = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		DataFormatter formatter = new DataFormatter();

		for (int r = 0; r < row; r++) {
			XSSFRow record = sheet.getRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = record.getCell(c);
				String val = formatter.formatCellValue(cell);
				WebDriverWait wait = new WebDriverWait(driver, 10);
				driver.findElement(By.xpath(prop.getProperty("login_button"))).click();

				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("login_no"))))
						.sendKeys(val);
				Thread.sleep(1500);
				driver.findElement(By.xpath(prop.getProperty("login"))).click();

				Thread.sleep(3000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		}
		wb.close();	}

	@When("User enters OTP")
	public void user_enters_otp() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.xpath(prop.getProperty("f_login"))).click();

	}

	@Then("User is successfully Logged in")
	public void user_is_successfully_logged_in() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/header/div[3]/div[2]/div[1]/a[1]/span"));
		Thread.sleep(3000);
		driver.quit();
	}

}
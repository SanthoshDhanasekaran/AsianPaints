package shreya;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
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
//import io.cucumber.junit.CucumberOptions;

public class store {
	public static WebDriver driver;
	static Properties prop = new Properties();

	@Given("I am on asianpaints store page")
	public void I_am_on_asianpaints_store_page() throws Exception {
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

	@When("user enters pincode_s")
	public void user_enters_pincode_s() throws InterruptedException, IOException {
		driver.findElement(By.xpath(prop.getProperty("storelogo"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String excelFile = ".\\DataFiles\\data.xlsx";
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		DataFormatter formatter = new DataFormatter();

		for (int r = 0; r < row; r++) {
			XSSFRow record = sheet.getRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = record.getCell(c);
				String val = formatter.formatCellValue(cell);
				driver.findElement(By.id(prop.getProperty("storepin"))).clear();;
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("storepin")))).sendKeys(val);
				//driver.manage().window().maximize();
				WebElement element = driver.findElement(By.xpath(prop.getProperty("storebutton")));
				Actions actions = new Actions(driver);
				actions.moveToElement(element).click().perform();
				Thread.sleep(3000);
				//driver.navigate().refresh();
			}
		}
	}

	@Then("User is successfully find store")
	public void user_is_successfully_find_store() throws InterruptedException {

		driver.quit();
	}

}

package stepDefinitions;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvPaintBudgetCalc {
	WebDriver driver;
	String excelFile = "D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-4\\Sprint2\\AsianPaintsSprint2.xlsx";
	static Properties prop = new Properties();
	@Given("User is in the Homepage")
	public void user_is_in_the_homepage() throws Exception {
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

	@When("User Clicks PaintBudgetCalC")
	public void user_clicks_paint_budget_cal_c() throws InterruptedException {
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/a[1]/div[2]/span[1]"))
				.click();
		Thread.sleep(2000);
	}

	@Then("It Redirects to PaintBudgetCalC")
	public void it_redirects_to_paint_budget_cal_c() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Quick & Advanced Paint Budget Calculator - Asian Paints");
		Thread.sleep(1000);
	}

	@When("User Clicks on the AdvBudgetCalc")
	public void user_clicks_on_the_adv_budget_calc() throws InterruptedException {
		String advBudgetCalcLoc = "//a[normalize-space()='Advanced calculator']";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement advCalc = driver.findElement(By.xpath(advBudgetCalcLoc));
		advCalc.click();
		js.executeScript("arguments[0].scrollIntoView()", advCalc);
	}

	@Then("It opens the AdvBudgetCalc")
	public void it_opens_the_adv_budget_calc() throws Exception {
		WebElement rePainting = driver.findElement(By.xpath("//div[contains(@class,'PaintAndSpaceSelection')]//div[1]//div[1]//div[1]//div[2]//div[1]//label[1]//span[1]"));
		WebElement Exterior = driver.findElement(By.xpath("//div[contains(@class,'tabs-details')]//div//div[2]//div[1]//div[1]//div[2]//div[1]//label[1]//span[1]"));
		Exterior.click();
		rePainting.click();
		Thread.sleep(500);
		WebElement carpt_area = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]"));
		//WebElement calcButton = 
		String reset ="//div[@class='d-flex align-items-center flex-wrap flex-lg-nowrap field-elements']//button[@class='ctaText DarkButton track-reset-btn'][normalize-space()='RESET']";
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("budgetCalcExterior");
		int row = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		for (int r = 0; r < row; r++) 
		{
			XSSFRow record = sheet.getRow(r);
			for (int c = 0; c < cols; c++) 
			{
				XSSFCell cell = record.getCell(c);
				String value = cell.getStringCellValue();
				carpt_area.sendKeys(value);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[normalize-space()='CALCULATE NOW']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(reset)).click();
				Thread.sleep(2000);
			}
		}
		wb.close();
		driver.quit();
	}
}

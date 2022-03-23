package stepDefinitions;

import io.cucumber.java.en.*;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DesignAndColorApp {
	WebDriver driver;
	String excelFile = "D:\\Users\\SANTHOSH\\CAPGEMINI\\Internship Materials\\module-4\\Sprint2\\AsianPaintsSprint2.xlsx";
	static Properties prop = new Properties();
	
	@Given("User is in the Homepage header")
	public void user_is_in_the_homepage_header() throws Exception {
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
		Thread.sleep(2000);
	}

	@When("User Clicks on the Design and Color App")
	public void user_clicks_on_the_design_and_color_app() throws InterruptedException {
		driver.findElement(By.xpath("//span[normalize-space()='Design and Colour App']")).click();
		Thread.sleep(2000);
	}

	@Then("Redirect to the Design and Color App")
	public void redirect_to_the_design_and_color_app() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Colour With Asian Paints - Download The Painting App");
		Thread.sleep(2000);
	}

	@When("User clicks on the PlayStore image")
	public void user_clicks_on_the_play_store_image() throws InterruptedException {
		String gplay = "//div[@class='downloadpaintingapp aem-GridColumn aem-GridColumn--default--12']//div[@class='mobileAppPage_mobileAppSendIcon_appStore']//a";
		driver.findElement(By.xpath(gplay)).click();
		Thread.sleep(2000);
	}

	@Then("Redirects to PlayStore App Download")
	public void redirects_to_play_store_app_download() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Colour with Asian Paints - Wall Paint & Design App - Apps on Google Play");
		Thread.sleep(2000);
		driver.close();
	}

	@When("User clicks on the AppStore image")
	public void user_clicks_on_the_app_store_image() throws InterruptedException {
		String appStore = "//div[@class='downloadpaintingapp aem-GridColumn aem-GridColumn--default--12']//img[@title='app@3x']";
		driver.findElement(By.xpath(appStore)).click();
		Thread.sleep(2000);
	}

	@Then("Redirects to AppStore App Download")
	public void redirects_to_app_store_app_download() throws InterruptedException {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals("https://apps.apple.com/in/app/colour-with-asian-paints/id1277723039",url);
		Thread.sleep(2000);
		driver.quit();
	}

	@When("User Enters PhoneNumber to Receive link")
	public void user_enters_phone_number_to_receive_link() throws Exception {
		
		String numberLoc = "paintingAppMobile";
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Design and App");
		int row = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		for (int r = 0; r < row; r++) 
		{
			XSSFRow record = sheet.getRow(r);
			for (int c = 0; c < cols; c++) 
			{
				XSSFCell cell = record.getCell(c);
				String mobNumber = cell.getStringCellValue();
				driver.findElement(By.id(numberLoc)).sendKeys(mobNumber);
				Thread.sleep(1500);
				String sms = "//div[@class='downloadpaintingapp aem-GridColumn aem-GridColumn--default--12']//button[@class='ctaText send-download-app-link track_download_app'][normalize-space()='SEND SMS']";
				driver.findElement(By.xpath(sms)).click();
				Thread.sleep(3000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		}
		wb.close();
	}

	@Then("User receives AppLink")
	public void user_receives_app_link() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		driver.quit();
	}

}

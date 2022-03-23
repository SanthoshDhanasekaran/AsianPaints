package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SocialMediaSteps {
	WebDriver driver;
	static Properties prop = new Properties();
	@Given("User is in the Homepage Footer")
	public void user_is_in_the_homepage_footer() throws Exception {
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
		driver.findElement(By.className(prop.getProperty("logo_ap"))).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("i_understand"))).click();
		Thread.sleep(2000);
	}

	@When("User Clicks on the Facebook Icon")
	public void user_clicks_on_the_facebook_icon() throws InterruptedException {
		WebElement fbIcon = driver.findElement(By.xpath(prop.getProperty("fbLoc")));
		fbIcon.click();
		Thread.sleep(2000);
	}

	@Then("Redirect to the Asian Paints Facebook page")
	public void redirect_to_the_asian_paints_facebook_page() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Asian Paints - Home | Facebook");
		driver.close();
	}

	@When("User Clicks on the Twitter Icon")
	public void user_clicks_on_the_twitter_icon() throws InterruptedException {
		String twtrLoc = "//span[@class='spriteIcon-Aprevamp twitterImg']";
		WebElement twtrIcon=driver.findElement(By.xpath(twtrLoc));
		twtrIcon.click();
		Thread.sleep(2000);
	}

	@Then("Redirect to the Asian Paints Twitter page")
	public void redirect_to_the_asian_paints_twitter_page() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Asian Paints (@asianpaints) / Twitter");
		driver.close();
	}

	@When("User Clicks on the Pinterest Icon")
	public void user_clicks_on_the_pinterest_icon() throws InterruptedException {
		String pintrstLoc = "//span[@class='spriteIcon-Aprevamp pinterestImg']";
		WebElement pintrstIcon=driver.findElement(By.xpath(pintrstLoc));
		pintrstIcon.click();
		Thread.sleep(2000);
	}

	@Then("Redirect to the Asian Paints Pinterest page")
	public void redirect_to_the_asian_paints_pinterest_page() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Asian Paints (asianpaints) - Profile | Pinterest");
		driver.close();
	}

	@When("User Clicks on the Instagram Icon")
	public void user_clicks_on_the_instagram_icon() throws InterruptedException {
		String instaLoc = "//span[@class='spriteIcon-Aprevamp instagramImg']";
		WebElement instaIcon=driver.findElement(By.xpath(instaLoc));
		instaIcon.click();
		Thread.sleep(2000);
	}

	@Then("Redirect to the Asian Paints Instagram page")
	public void redirect_to_the_asian_paints_instagram_page() {
		String title = driver.getTitle();
		String acturl = driver.getCurrentUrl();
		String expurl="";
		System.out.println(title);
		try
		{
			boolean instaAP=acturl.equals(expurl);
			if(instaAP)
			{
			Assert.assertEquals(title,"Asian Paints (@asianpaints) • Instagram photos and videos");
			}
			else
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			Assert.assertEquals(title,"Login • Instagram");
		}
		
		driver.close();
	}

	@When("User Clicks on the YouTube Icon")
	public void user_clicks_on_the_you_tube_icon() throws InterruptedException {
		String utubeLoc = "//span[@class='spriteIcon-Aprevamp youtubeImg']";
		WebElement utubeIcon=driver.findElement(By.xpath(utubeLoc));
		utubeIcon.click();
		Thread.sleep(2000);
	}

	@Then("Redirect to the Asian Paints YouTube page")
	public void redirect_to_the_asian_paints_you_tube_page() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Asian Paints - YouTube");
		driver.quit();
	}

}

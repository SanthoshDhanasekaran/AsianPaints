package com.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Enquire_now_steps 
{
		public static WebDriver driver;
		@Given("I am on asianpaints home page")
		public void i_am_on_asianpaints_home_page() {
			System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.navigate().to("http://asianpaints.com");
			driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();

		}
		@When("user enters name")
		public void user_enters_name() {
			driver.findElement (By.id("Name")).sendKeys("Shreya Das");
			}
		@When("user enters email id")
		public void user_enters_email_id() {
			driver.findElement (By.id("Email")).sendKeys("shreya.das1999@gmail.com");
		}
		@When("user enters mobile number")
		public void user_enters_mobile_number() {
			driver.findElement (By.id("Mobile")).sendKeys("8777796764");
		}
		@When("user enters pincode")
		public void user_enters_pincode() {
			driver.findElement (By.id("Pincode")).sendKeys("700065");

		}
		@When("user clicks enquire now button")
		public void user_clicks_enquire_now_button() {
			driver.findElement(By.id("ENQUIRE NOW")).click();
		}
		@Then("user gets details successfully")
		public void user_gets_details_successfully() {
			driver.quit();
		}
		
}

	


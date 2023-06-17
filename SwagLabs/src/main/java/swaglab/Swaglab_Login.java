package swaglab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Swaglab_Login {
	WebDriver driver;
	@BeforeTest
	public void URL_Swag() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	} 
	@Test (priority = 1)
	public void Userlogin() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
	@Test (priority = 2)
	public void product() throws Exception {
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();	
		Thread.sleep(1000);
		driver.findElement(By.id("checkout")).click();
	}
	@Test (priority = 3)
	public void checkout_Info() throws Exception {
		driver.findElement(By.name("firstName")).sendKeys("Praffull");
		driver.findElement(By.name("lastName")).sendKeys("Tembhurne");
		driver.findElement(By.name("postalCode")).sendKeys("440037");
		Thread.sleep(1000);
		driver.findElement(By.name("continue")).click();
		
	}
	@Test (priority = 4)
	public void backToProduct() throws Exception {
		driver.findElement(By.name("finish")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("back-to-products")).click();
		Thread.sleep(1000);
	}
	@Test (priority = 5)
	public void logout() throws Exception {
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
		
		
	}
	@Test (priority = 6)
	public void driverClose() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}

}

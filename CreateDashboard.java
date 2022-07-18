package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDashboard {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();    // default code to remove notifications
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt); // pass opt into the constructor of the chromedriver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/ ");

		// 1. Login to https://login.salesforce.com
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");

		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("Login")).click();

		// 2. Click on the toggle menu button from the left corner
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click View All and click Dashboards from App Launcher

		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("dashboard");
		driver.findElement(By.xpath("//li[@class='slds-size_1-of-5 slds-col--padded slds-p-vertical_small']")).click();

		// 4. Click on the New Dashboard option
		Thread.sleep(2000);
		driver.findElement(By.className("forceActionLink")).click();

		// 5.Handle the frame
		Thread.sleep(2000);
//		Set<String> windowHandles = driver.getWindowHandles();
//		List<String> list = new ArrayList<String>(windowHandles);

		//driver.switchTo().window(list.get(0));

		WebDriver frame = driver.switchTo().frame(0);

		// 6. Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.
		WebElement creating = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		creating.sendKeys("Salesforce Automation by Logeswari");
		driver.findElement(By.id("submitBtn")).click();

		//driver.switchTo().window(list.get(0));

		// 7.Click on Save and Verify Dashboard name.
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String verify = driver.findElement(By.xpath("//span[@class='slds-form-element__static slds-grid slds-grid_align-spread']")).getText();
		if(creating.equals(verify)) {
			System.out.println("Both are same");
		}
		else {
			System.out.println("Different");
		}
	
	
	}

}
